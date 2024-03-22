package com.royalenfield.diagcan.Iso14229UdsClient;


import android.content.Context;
import android.net.Uri;
import android.util.Log;

import com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.UdsServiceFactory;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.Iso14229ServiceFactory;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.ProgramFileReader.FirmwareProgramFile;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsComponents.ProgramFileReader.HexToBin;
import  com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ServiceInfo;
import  com.royalenfield.diagcan.iso15765TP.Iso15765TpInterface;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;



/**
 * This class represents a Bootloader Service within a UDS (Unified Diagnostic Service) session.
 * It inherits functionalities from the UdsSession class for managing service discovery and communication.
 * A Bootloader Service typically deals with diagnostic services specific to the bootloader of the
 * Electronic Control Unit (ECU), used for flashing firmware or performing low-level operations.
 *
 * @author Venu Manikonda (venu.v@sloki.in)
 */
public class BootloaderService extends UdsSession {
    private final Iso15765TpInterface udsInterface;
    private final HexToBin hexToBin = new HexToBin();


    public BootloaderService(Iso15765TpInterface udsInterface, Context context) {
        super(context);
        this.udsInterface = udsInterface;
    }

    /**
     * Starts the bootloader update service.
     * @author Venu Manikonda
     * @param TemplateUri URI representing the UDS flow configuration file.
     * @param firmwareImageFileURI URI representing the program file for the ECU software update.
     */
    public void startBootloaderService(Uri TemplateUri, Uri firmwareImageFileURI) {
        Log.i(TAG,  "Starting Bootloader Service");

        try {
            /**
             * Converts the program file (hex format) to a ProgramFile object.
             * - mContext: The application context.
             * - firmwareImageFileURI: URI for the program file.
             */
            FirmwareProgramFile firmwareProgramFile = hexToBin.convertHexToBinary(mContext, firmwareImageFileURI);

            /**
             * Parses the UDS flow configuration file and retrieves a list of service information objects.
             * - TemplateUri: URI for the UDS flow configuration file.
             * - programFile: The program file object.
             * @return A Queue containing ServiceInfo objects parsed from the XML file.
             */
            Queue<ServiceInfo> serviceInfoList = parseServiceDiscoveryFile(TemplateUri, firmwareProgramFile);

            /**
             * List to store the created DiagCanService objects based on service information.
             */
            List<UdsDiagnosticService> serviceObjectFIFO = new LinkedList<>();

            /**
             * Processes the service information list and program file to create DiagCanService objects.
             * - serviceInfoList: The Queue containing ServiceInfo objects.
             * - programFile: The program file object.
             * - serviceObjectFIFO: The List to store the created DiagCanService objects (FIFO order).
             */
            processServiceElements(serviceInfoList, firmwareProgramFile, serviceObjectFIFO);


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



    protected void processServiceElements(Queue<ServiceInfo> serviceInfoList, FirmwareProgramFile firmwareProgramFile, List<UdsDiagnosticService> servicesFIFO) {
        UdsServiceFactory serviceFactory = new Iso14229ServiceFactory();
        servicesFIFO.addAll(serviceFactory.createServiceInstances(serviceInfoList, firmwareProgramFile, udsInterface));
        callbackMgr.log(TAG,  "Creating unifiedDiagnosticService...");
        callbackMgr.log(TAG,  "Processing template...");
    }







}
