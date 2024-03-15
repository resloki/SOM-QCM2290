package com.royalenfield.diagcan.iso14229UDS;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.royalenfield.diagcan.UdsCallbackEventManager;
import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.ServiceInfo;
import com.royalenfield.diagcan.iso14229UDS.TemplateCompilerEngine.TemplateCompilerEngine;
import com.royalenfield.diagcan.iso15765TP.DiagCanTp;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

public class ApplicationService {
    Context mContext;
    private final DiagCanTp diagCANTp;
    TemplateCompilerEngine templateCompilerEngine = null;
    private final UdsCallbackEventManager callbackMgr = UdsCallbackEventManager.getInstance();
    static final String TAG = "iso14229UDS";
    public ApplicationService(DiagCanTp diagCANTp, Context context) {
        this.mContext = context;
        this.diagCANTp = diagCANTp;
    }


    public void startApplicationService(Uri xmlFileUri) {
        String methodName = getMethodName();
        Queue<ServiceInfo> serviceFIFO = new LinkedList<>();

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
                int Result = templateCompilerEngine.processTemplate(inputStream, serviceFIFO);
                if (Result != 0) {
                    return;
                }
                callbackMgr.Log(TAG, methodName + "Creating unifiedDiagnosticService...");
                callbackMgr.Log(TAG, methodName + "Processing template...");
                UdsServiceFactory serviceFactory = new Iso14229ServiceFactory();
                List<DiagCanService> services = serviceFactory.createServiceInstances(serviceFIFO, diagCANTp);
                runServices(services);

            } else {
                Log.e(TAG, methodName + "Error: InputStream is null");
            }

        } catch (FileNotFoundException e) {
            Log.e(TAG, methodName + "File not found: " + e.getMessage(), e);
        }
    }


    private ContentResolver getContentResolver() {
        return mContext.getContentResolver();
    }

    private String getMethodName() {
        return "Method Name: " + Thread.currentThread().getStackTrace()[2].getMethodName() + ": ";
    }


    public int runServices(List<DiagCanService> udsServices) {
        try {

            String methodName =  "runServices";
            callbackMgr.Log(TAG, methodName + "Starting Bootloader Service....");

            // Execute each UdsService
            for (DiagCanService udsService : udsServices) {
                int serviceExecutionStatus = udsService.runService();
                if (0 != serviceExecutionStatus) {
                    return serviceExecutionStatus;
                }
            }
        } catch (Exception ex) {
            callbackMgr.Log(TAG, "service failed: error in Template processing");
        }
        return 0;
    }


}
