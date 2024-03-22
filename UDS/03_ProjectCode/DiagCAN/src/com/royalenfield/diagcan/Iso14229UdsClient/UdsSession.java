package com.royalenfield.diagcan.Iso14229UdsClient;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.util.Log;

import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.ProgramFileReader.FirmwareProgramFile;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.TemplateCompilerEngine.TemplateCompilerEngine;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.UDSNrcCodes;
import  com.royalenfield.diagcan.UdsCallbackEventManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.Queue;

/**
 * This class manages a UDS (Unified Diagnostic Service) session, including parsing service discovery files,
 * executing diagnostic services, and handling communication with the ECU (Electronic Control Unit).
 *
 * @author Venu Maniknoda
 */
public class UdsSession {

    public enum ServiceType {
        /**
         * Type of service to be executed: Application or Bootloader
         */
        APPLICATION_SERVICE,
        BOOTLOADER_SERVICE
    }


    protected final Context mContext;
    protected final TemplateCompilerEngine templateCompilerEngine;
    protected final UdsCallbackEventManager callbackMgr = UdsCallbackEventManager.getInstance();
    static final String TAG = "iso14229UDS";
    UDSNrcCodes UDSErrors = new UDSNrcCodes();


    /**
     * Constructor for UdsSession class. Requires a Context object.
     *
     * @param mContext The application context.
     */
    public UdsSession(Context mContext) {
        templateCompilerEngine = new TemplateCompilerEngine();
        this.mContext = mContext;
    }


    /**
     * Parses a service discovery file specified by a URI and a ProgramFile object, and returns a queue
     * containing the parsed service information.
     *
     * @param templateUri         The URI of the service discovery file (content:// or file:// scheme).
     * @param firmwareProgramFile The ProgramFile object containing additional context for parsing.
     * @return A queue containing the parsed ServiceInfo objects.
     * @throws IOException If there's an error reading or parsing the file.
     */
    protected Queue<ServiceInfo> parseServiceDiscoveryFile(Uri templateUri, FirmwareProgramFile firmwareProgramFile) throws IOException {
        InputStream inputStream;
        if ("content".equalsIgnoreCase(templateUri.getScheme())) {
            inputStream = getContentResolver().openInputStream(templateUri);
        } else {
            File xmlFile = new File(Objects.requireNonNull(templateUri.getPath()));
            if (!xmlFile.exists() || !xmlFile.isFile()) {
                Log.e(TAG, "Invalid or non-existent XML file");
                throw new FileNotFoundException("Invalid or non-existent XML file");
            }
            inputStream = Files.newInputStream(xmlFile.toPath());

        }

        if (inputStream == null) {
            Log.e(TAG, "Error: InputStream is null");
            throw new IOException("Error: InputStream is null");
        }

        Queue<ServiceInfo> serviceElementsInFlowConfig = new LinkedList<>();
        int parseResult = templateCompilerEngine.processTemplate(inputStream, serviceElementsInFlowConfig, firmwareProgramFile);
        if (parseResult != 0) {
            throw new IOException("invalid template");
        }

        return serviceElementsInFlowConfig;
    }


    /**
     * Parses a service discovery file specified by a URI, and returns a queue containing the parsed service information.
     * This overload assumes no ProgramFile object is needed for parsing.
     *
     * @param templateUri The URI of the service discovery file (content:// or file:// scheme).
     * @return A queue containing the parsed ServiceInfo objects.
     * @throws IOException If there's an error reading or parsing the file.
     */
    protected Queue<ServiceInfo> parseServiceDiscoveryFile(Uri templateUri) throws IOException {
        InputStream inputStream;

        if ("content".equalsIgnoreCase(templateUri.getScheme())) {
            inputStream = getContentResolver().openInputStream(templateUri);
        } else {
            File xmlFile = new File(Objects.requireNonNull(templateUri.getPath()));
            if (!xmlFile.exists() || !xmlFile.isFile()) {
                Log.e(TAG, "Invalid or non-existent XML file");
                throw new FileNotFoundException("Invalid or non-existent XML file");
            }
            inputStream = Files.newInputStream(xmlFile.toPath());

        }

        if (inputStream == null) {
            Log.e(TAG, "Error: InputStream is null");
            throw new IOException("Error: InputStream is null");
        }

        Queue<ServiceInfo> serviceElementsInFlowConfig = new LinkedList<>();
        int parseResult = templateCompilerEngine.processTemplate(inputStream, serviceElementsInFlowConfig);
        if (parseResult != 0) {
            throw new IOException("invalid template");
        }

        return serviceElementsInFlowConfig;
    }


    private ContentResolver getContentResolver() {
        return mContext.getContentResolver();
    }


    /**
     * Executes a list of diagnostic services (DiagCanService objects) sequentially.
     * <p>
     * This method iterates through the provided service list and calls the `executeDiagnosticService` method on each DiagCanService object.
     * The return value of `executeDiagnosticService` is assumed to be an integer representing the service execution status.
     * <p>
     * The method extracts the service ID, result (success/failure), and NRC (Negative Response Code) from the status value.
     * It logs successful executions and terminates the execution with the status code upon encountering a failure.
     *
     * @param serviceObjectList A list of DiagCanService objects representing the diagnostic services to be executed.
     * @return 0 on successful execution of all services, or the status code from a failing service.
     * @throws Exception If there's an unexpected error during execution.
     */
    public int executeServices(List<UdsDiagnosticService> serviceObjectList) {
        try {

            callbackMgr.log(TAG, "Starting Service Session....\n");

            // Execute each UdsService
            for (UdsDiagnosticService udsService : serviceObjectList) {
                int serviceExecutionStatus = udsService.executeDiagnosticService();

                // Extract Service ID, Result, and NRC from the serviceExecutionStatus
                byte serviceId = (byte) ((serviceExecutionStatus >> 24) & 0xFF);
                byte result = (byte) ((serviceExecutionStatus >> 16) & 0xFF);
                byte nrc = (byte) (serviceExecutionStatus & 0xFF);

                if (result == 0) {
                    callbackMgr.log(TAG, udsService.serviceName + " Success\n");
                } else {
                    String nrcDescription = UDSErrors.getErrorDescription(nrc);
                    callbackMgr.onError(nrc, udsService.serviceName + "Failed," +
                            "\n Service ID: " + serviceId +
                            "\n NRC: " + Integer.toHexString(nrc) +
                            "\n Description:  " + nrcDescription);
                    return serviceExecutionStatus;
                }

            }
        } catch (Exception ex) {
            callbackMgr.onError(1, "service failed: error in Template processing");
        }
        return 0;
    }


}








