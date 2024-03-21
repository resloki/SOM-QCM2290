package com.royalenfield.diagcan.Iso14229UdsClient;

import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.UdsServiceFactory;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.Iso14229ServiceFactory;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/**
 * This class represents an Application Service within a UDS (Unified Diagnostic Service) session.
 * It inherits functionalities from the UdsSession class for managing service discovery and communication.
 * An Application Service typically deals with diagnostic services specific to the application layer
 * of the Electronic Control Unit (ECU), as opposed to Bootloader services.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 */
public class ApplicationService extends UdsSession {
    private final Iso15765TpInterface udsInterface;

    public ApplicationService(Iso15765TpInterface udsInterface, Context context) {
        super(context);
        this.udsInterface = udsInterface;
    }

    public void startApplicationService(Uri TemplateUri) {
        Log.i(TAG,  "Starting Application Service");

        try {
            /**
             * Parses the UDS flow configuration file and retrieves a list of service information objects.
             * - TemplateUri: URI for the UDS flow configuration file.
             * @return A Queue containing ServiceInfo objects parsed from the XML file.
             *
             * @author Venu Maniknoda
             */
            Queue<ServiceInfo> serviceInfoList = parseServiceDiscoveryFile(TemplateUri);

            /**
             * List to store the created DiagCanService objects based on service information.
             */
            List<UdsDiagnosticService> serviceObjectFIFO = new LinkedList<>();

            /**
             * Processes the service information list and program file to create DiagCanService objects.
             * - serviceInfoList: The Queue containing ServiceInfo objects.
             * - serviceObjectFIFO: The List to store the created DiagCanService objects (FIFO order).
             */
            processServiceElements(serviceInfoList, serviceObjectFIFO);

            /**
             * Executes the created DiagCanService objects in the order they are stored in the list (FIFO).
             * - serviceObjectFIFO: The List containing the DiagCanService objects for execution.
             */
            executeServices(serviceObjectFIFO);

        } catch (FileNotFoundException e) {
            callbackMgr.operationComplete(-1, "Input files don't exist");
        } catch (IOException e) {
            callbackMgr.operationComplete(-1, "Input files URIs are null");
        }
    }

    protected void processServiceElements(Queue<ServiceInfo> serviceInfoList, List<UdsDiagnosticService> servicesFIFO) {
        UdsServiceFactory serviceFactory = new Iso14229ServiceFactory();
        servicesFIFO.addAll(serviceFactory.createServiceInstances(serviceInfoList, udsInterface));
        callbackMgr.log(TAG,  "Creating unifiedDiagnosticService...");
        callbackMgr.log(TAG,  "Processing template...");
    }
}

