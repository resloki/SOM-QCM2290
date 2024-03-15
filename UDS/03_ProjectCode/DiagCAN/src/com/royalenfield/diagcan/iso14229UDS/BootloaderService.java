package com.royalenfield.diagcan.iso14229UDS;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.royalenfield.diagcan.UdsCallbackEventManager;
import com.royalenfield.diagcan.iso14229UDS.HexFileReader.HexToBin;
import com.royalenfield.diagcan.iso14229UDS.HexFileReader.ProgramFile;
import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.TemplateCompilerEngine;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class BootloaderService {
    private final DiagCanTp diagCANTp;
    private final Context mContext;
    private final TemplateCompilerEngine templateCompilerEngine;
    private final UdsCallbackEventManager callbackMgr =  UdsCallbackEventManager.getInstance();
    private final HexToBin hexToBin = new HexToBin();
    static final String TAG = "iso14229UDS";


    public BootloaderService(DiagCanTp diagCANTp, Context context) {
        this.mContext = context;
        this.diagCANTp = diagCANTp;
        templateCompilerEngine = new TemplateCompilerEngine();
    }

    public void startBootloaderService(Uri xmlFileUri, Uri hexFileUri) {
        String methodName = "startBootloaderService";
        Queue<ServiceInfo> serviceElementsInFlowConfig = new LinkedList<>();

        Log.i(TAG, methodName + "Starting Bootloader Service");

        try {
            InputStream inputStream;
            if ("content".equalsIgnoreCase(xmlFileUri.getScheme())) {
                inputStream = getContentResolver().openInputStream(xmlFileUri);
            } else {
                File xmlFile = new File(Objects.requireNonNull(xmlFileUri.getPath()));
                if (!xmlFile.exists() || !xmlFile.isFile()) {
                    Log.e(TAG, methodName + "Invalid or non-existent XML file");
                    return;
                }
                inputStream = new FileInputStream(xmlFile);
            }

            if (inputStream != null) {
                ProgramFile programFile = hexToBin.convertHexToBinary(mContext, hexFileUri);
                int parseResult = templateCompilerEngine.processTemplate(inputStream, serviceElementsInFlowConfig,programFile);
                if (parseResult != 0) {
                    return;
                }

                callbackMgr.Log(TAG, methodName + "Creating unifiedDiagnosticService...");
                callbackMgr.Log(TAG, methodName + "Processing template...");
                UdsServiceFactory serviceFactory = new Iso14229ServiceFactory();
                List<DiagCanService> servicesFIFO = serviceFactory.createServiceInstances(serviceElementsInFlowConfig, programFile, diagCANTp);
                runServices(servicesFIFO);

            } else {
                Log.e(TAG, methodName + "Error: InputStream is null");
            }

        } catch (FileNotFoundException e) {
            Log.e(TAG, methodName + "File not found: " + e.getMessage(), e);
        } catch (IOException e) {
            Log.e(TAG, methodName + "IOException: " + e.getMessage(), e);
        }
    }


    public int runServices(List<DiagCanService> udsServices) {
        try {
             String methodName = "runServices";
            callbackMgr.Log(TAG, methodName + "Starting Bootloader Service....");

            // Execute each UdsService
            for (DiagCanService udsService : udsServices) {
                int serviceExecutionStatus = udsService.runService();
                if (0 != serviceExecutionStatus) {
                    return serviceExecutionStatus;
                }
            }
        } catch (Exception ex) {
            callbackMgr.onError(1, "service failed: error in Template processing");
        }
        return 0;
    }


    private ContentResolver getContentResolver() {
        return mContext.getContentResolver();
    }

}
