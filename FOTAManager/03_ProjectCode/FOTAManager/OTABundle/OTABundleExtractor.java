package com.sloki.FOTAManager.OTABundle;

import android.content.Context;

import android.net.Uri;

import android.util.Log;

import androidx.documentfile.provider.DocumentFile;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.exception.ZipException;

import java.io.*;


import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class OTABundleExtractor {
    Context context;
    public static final int REQUEST_WRITE_EXTERNAL_STORAGE = 1;


    public OTABundleExtractor(Context context) {
        this.context = context;
    }

    public OTABundle extract(Uri bundlePath, String password) {
        if (bundlePath != null) {
            Uri tempFolder = createTempFolder(context);

            try {
                unzip(context, bundlePath, tempFolder, password);

                OTABundle otaBundle = createOTABundle(tempFolder);
                return otaBundle;

            } catch (IOException e) {
                Log.e("OTABundleExtraction", "Error during extraction: " + e.getMessage());
                e.printStackTrace();
                return null; // Handle error appropriately in your application
            } finally {
                // You can add cleanup code here if needed
            }
        } else {
            Log.e("OTABundleExtraction", "Bundle path is null");
            return null; // Handle error appropriately in your application
        }
    }


    private static Uri createTempFolder(Context context) {
        File tempDir = new File(context.getExternalCacheDir(), "secure_temp_folder");

        if (!tempDir.exists() && !tempDir.mkdirs()) {
            throw new RuntimeException("Error creating temporary folder");
        }

        return Uri.fromFile(tempDir);
    }

    private static void unzip(Context context, Uri zipFilePath, Uri destDirectoryUri, String password) throws ZipException {
        DocumentFile zipDocumentFile = DocumentFile.fromSingleUri(context, zipFilePath);
        File destDirectory = new File(destDirectoryUri.getPath());

        if (zipDocumentFile != null && zipDocumentFile.exists()) {
            try {
                // Create a temporary file
                File tempFile = File.createTempFile("temp", null, context.getCacheDir());
                tempFile.deleteOnExit();

                // Write the InputStream to the temporary file
                try (InputStream inputStream = context.getContentResolver().openInputStream(zipDocumentFile.getUri());
                     OutputStream outputStream = new FileOutputStream(tempFile)) {
                    byte[] buffer = new byte[4096];
                    int bytesRead;
                    while ((bytesRead = inputStream.read(buffer)) != -1) {
                        outputStream.write(buffer, 0, bytesRead);
                    }
                }

                // Now, use the temporary file path to create the ZipFile
                ZipFile zipFile = new ZipFile(tempFile);

                if (zipFile.isEncrypted()) {
                    zipFile.setPassword(password.toCharArray());
                }

                zipFile.extractAll(destDirectory.getAbsolutePath());
            } catch (IOException e) {
                e.printStackTrace();
                throw new ZipException("Error extracting zip file: " + e.getMessage());
            }
        } else {
            throw new ZipException("Zip file not found or does not exist");
        }
    }


    private OTABundle createOTABundle(Uri tempFolder) {
        OTABundle otaBundle = new OTABundle();

        try {
            // Read manifest.json file
            Uri manifestFileUri = Uri.parse(tempFolder.toString() + File.separator + "OTA Bundle" + File.separator + "Manifest.json");
            String manifestContent = readManifestFile(manifestFileUri);

            if (manifestContent == null) {
                return null;
            }

            // Parse the manifest JSON
            JsonObject manifestJson = new JsonParser().parse(manifestContent).getAsJsonObject();
            JsonObject manifest = manifestJson.getAsJsonObject("manifest");

            // Set configuration, manifest, and signature files
            otaBundle.setConfigurationFile(Uri.parse(tempFolder.toString() + File.separator + "OTA Bundle" + File.separator + "configuration.xml"));
            otaBundle.setManifestFile(manifestFileUri);
            otaBundle.setSignatureFile(Uri.parse(tempFolder.toString() + File.separator + "OTA Bundle" + File.separator + "signature.txt"));

            // Process directories
            JsonObject directories = manifest.getAsJsonObject("directories");
            for (Map.Entry<String, JsonElement> directoryEntry : directories.entrySet()) {
                String directoryName = directoryEntry.getKey();
                JsonObject directory = directoryEntry.getValue().getAsJsonObject();

                // Create directory-specific folder
                Uri directoryPath = Uri.parse(tempFolder.toString() + File.separator + "OTA Bundle" + File.separator + directoryName);
                File directoryFolder = new File(directoryPath.getPath());
                if (directoryFolder.exists() && directoryFolder.isDirectory()) {
                    // Process files in the directory
                    JsonArray filesArray = directory.getAsJsonArray("files");
                    for (JsonElement fileElement : filesArray) {
                        try {
                            JsonObject fileObject = fileElement.getAsJsonObject();
                            String fileName = fileObject.getAsJsonPrimitive("fileName").getAsString();
                            long fileSize = fileObject.getAsJsonPrimitive("fileSize").getAsLong();
                            String checksum = fileObject.getAsJsonPrimitive("checksum").getAsString();

                            // Create FirmwareImageFile instance
                            Uri filePath = Uri.parse(directoryPath.toString() + File.separator + fileName);
                            bundleDirectories file = new bundleDirectories(fileName, fileSize, checksum, filePath);

                            if (directoryName.equals("FirmwareImageFiles")) {
                                otaBundle.addFirmwareImageFile(file);
                            } else if (directoryName.equals("udsFlowConfig")) {
                                otaBundle.addUdsFlowConfigFile(file);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                            // Handle specific exception or log the error as needed
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }

        return otaBundle;
    }


    private String readManifestFile(Uri manifestFileUri) {
        StringBuilder content = new StringBuilder();

        try (InputStream inputStream = context.getContentResolver().openInputStream(manifestFileUri);
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return content.toString();
    }


    private static void deleteTempFolder(String folderPath) throws IOException {
        Files.walk(Paths.get(folderPath))
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);
    }
}
