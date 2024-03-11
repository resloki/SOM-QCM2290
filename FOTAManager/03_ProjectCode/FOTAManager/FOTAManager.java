package com.sloki.FOTAManager;

import static android.content.ContentValues.TAG;
import static android.content.Context.DOWNLOAD_SERVICE;

import android.content.Context;

import android.app.DownloadManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.documentfile.provider.DocumentFile;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.sloki.DiagCAN.DiagMain.DiagMain;
import com.sloki.DiagCAN.iso15765TP.DiagCAN;
import com.sloki.DiagCAN.iso15765TP.Physical.PhysicalInterface;
import com.sloki.DiagCAN.iso15765TP.i15765CANTPInterface;
import com.sloki.FOTAManager.FirebaseCloud.NotificationCallback;
import com.sloki.FOTAManager.OTABundle.OTABundle;
import com.sloki.FOTAManager.OTABundle.OTABundleExtractor;
import com.sloki.FOTAManager.OTABundle.bundleDirectories;
import com.sloki.slokicanmessenger.MainActivity;
import com.sloki.slokicanmessenger.USBViewModel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class FOTAManager implements NotificationCallback {
    // Implement the methods from the NotificationCallback interface
    public FOTAManager() {
        getFirebaseClientToken();
    }

    i15765CANTPInterface i15765_TP;
    USBViewModel usbViewModel;
    final String TAG = "fotaManager";
    Context context;
    Uri downloadUrl = null;

    public void setUsbViewModel(USBViewModel usbViewModel) {
        this.usbViewModel = usbViewModel;
        initFirebase();
    }

    public void setContext(Context context,i15765CANTPInterface i15765CANTPInterface) {
        this.context = context;
        this.i15765_TP=i15765CANTPInterface;
    }


    @Override
    public void onNotificationReceived(String title, String body) {
        //downloadUpdate();
    }

    @Override
    public void updatedBundle(Uri link) {
        //downloadUpdate(link);
        new DownloadTask(context, FOTAManager.this).execute(link);

    }


    void getFirebaseClientToken() {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        //String msg = getString(R.string.msg_token_fmt, token);
                        Log.d(TAG, "msg");
                        //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }


    public void startUpdate(Uri OTABundleFile) {
        if (OTABundleFile != null) {
            try {
                // Now you can use the filePath in your extract method
                OTABundleExtractor otaBundleExtractor = new OTABundleExtractor(context);
                OTABundle OTABundle = otaBundleExtractor.extract(OTABundleFile, "1234");

                if (OTABundle != null) {
                    bundleDirectories getUdsFlowConfigFiles = OTABundle.getUdsFlowConfigFiles().get(0);
                    bundleDirectories getFirmwareImageFiles = OTABundle.getFirmwareImageFiles().get(0);

                    Uri xmlFileUri = getUdsFlowConfigFiles.getFilePath();
                    Uri hexFileUri = getFirmwareImageFiles.getFilePath();

                    if (documentFileExistsAndIsFile(xmlFileUri)) {
                        DiagMain dataTemplateEngine = new DiagMain(i15765_TP, context, xmlFileUri);
                        try {
                            InputStream inputStream = context.getContentResolver().openInputStream(xmlFileUri);
                            if (inputStream != null) {
                                dataTemplateEngine.setURI(hexFileUri);
                                dataTemplateEngine.connectDiag(inputStream);
                            } else {
                                Log.e("FilePaths", "Failed to open InputStream for XML file");
                            }
                        } catch (FileNotFoundException e) {
                            Log.e("FilePaths", "File not found: " + e.getMessage());
                        } catch (Exception e) {
                            Log.e("FilePaths", "Error processing XML file: " + e.getMessage());
                            // Handle specific exception or log the error as needed
                        }
                    } else {
                        Log.e("FilePaths", "Invalid or non-existent XML file");
                    }
                } else {
                    Log.e("OTA_SERVER", "Failed to extract OTABundle");
                }
            } catch (Exception e) {
                Log.e("OTA_SERVER", "Error during OTABundle extraction: " + e.getMessage());
                // Handle specific exception or log the error as needed
            }
        } else {
            Log.e("OTA_SERVER", "Download link is invalid");
        }
    }



    private boolean documentFileExistsAndIsFile(Uri fileUri) {
        if (fileUri == null) {
            // Handle the case where fileUri is null
            return false;
        }

        DocumentFile documentFile = DocumentFile.fromSingleUri(context, fileUri);
        if (documentFile == null) {
            // Handle the case where DocumentFile is null
            return false;
        }

        return true;
    }



    private void downloadUpdate(Uri link) {
        if (link != null) {
            Uri uri = Uri.parse(String.valueOf(link));
            DownloadManager.Request request = new DownloadManager.Request(uri);
            request.setDestinationInExternalFilesDir(context, Environment.DIRECTORY_DOWNLOADS, "OTA_Update.zip");

            DownloadManager downloadManager = (DownloadManager) context.getSystemService(DOWNLOAD_SERVICE);
            long downloadId = downloadManager.enqueue(request);

            // Wait for the download to complete (optional)
            // Note: This should be done in a separate thread or AsyncTask to avoid blocking the UI

            // Check the status of the download
            DownloadManager.Query query = new DownloadManager.Query();
            query.setFilterById(downloadId);

            Cursor cursor = downloadManager.query(query);
            if (cursor != null && cursor.moveToFirst()) {
                int statusIndex = cursor.getColumnIndex(DownloadManager.COLUMN_STATUS);
                int localUriIndex = cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_URI);
                int localFileNameIndex = cursor.getColumnIndex(DownloadManager.COLUMN_LOCAL_FILENAME);

                int status = cursor.getInt(statusIndex);

                if (status == DownloadManager.STATUS_SUCCESSFUL) {
                    // Check if COLUMN_LOCAL_URI is available, if not, use COLUMN_LOCAL_FILENAME
                    String filePath;
                    if (localUriIndex != -1) {
                        filePath = cursor.getString(localUriIndex);
                    } else if (localFileNameIndex != -1) {
                        filePath = cursor.getString(localFileNameIndex);
                    } else {
                        // Handle the case where both columns are not available
                        Log.e("OTA_SERVER", "Downloaded file Uri not available");
                        return;
                    }

                    Uri downloadedFileUri = Uri.parse(filePath);
                    startUpdate(downloadedFileUri);
                    // Now you can use downloadedFileUri as needed
                    Log.d("OTA_SERVER", "Downloaded file Uri: " + downloadedFileUri);
                } else {
                    // Handle download failure
                    Log.e("OTA_SERVER", "Download failed. Status: " + status);
                }

                cursor.close();
            } else {
                Log.e("OTA_SERVER", "No download information available");
            }
        } else {
            Log.e("OTA_SERVER", "No download URL available");
        }
    }


    private void handleDataMessage(@NonNull Map<String, String> data) {
        if (data.containsKey("versionCode")) {
            long newVersionCode = Long.parseLong(data.get("versionCode"));
            //handleUpdateNotification(newVersionCode);
        }
    }


    void initFirebase() {
        FirebaseMessaging.getInstance().getToken()
                .addOnCompleteListener(new OnCompleteListener<String>() {
                    @Override
                    public void onComplete(@NonNull Task<String> task) {
                        if (!task.isSuccessful()) {
                            Log.w(TAG, "Fetching FCM registration token failed", task.getException());
                            return;
                        }

                        // Get new FCM registration token
                        String token = task.getResult();

                        // Log and toast
                        //String msg = getString(R.string.msg_token_fmt, token);
                        Log.d(TAG, "msg");
                        //Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
                    }
                });
    }


}
