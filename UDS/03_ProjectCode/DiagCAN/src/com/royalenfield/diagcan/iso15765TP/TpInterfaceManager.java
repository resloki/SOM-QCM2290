package com.royalenfield.diagcan.iso15765TP;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.ContentResolver;
import android.content.Context;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.util.Log;

import com.royalenfield.diagcan.Iso14229UdsClient.UdsUtilities.ResponseFrameContainer;
import com.royalenfield.diagcan.iso15765TP.Network.Network;
import com.royalenfield.diagcan.iso15765TP.Transport.Transport;
import com.royalenfield.diagcan.iso15765TP.session.Session;

import org.yaml.snakeyaml.Yaml;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class TpInterfaceManager extends Iso15765TpInterface {

    private Session Session;
    private Transport Transport;
    private Network Network;

    private final DataLinkConnectorTP connectDataLink;

    Context context;
    private final BlockingQueue<byte[]> receptionQueue = new ArrayBlockingQueue<>(1);


    void initializeLayers() {
        Session = new Session();
        Transport = new Transport();
        Network = new Network();


        Session.setSession(this::onDataReceived, Transport);
        Transport.SetTransport(Session, Network);
        Network.setNetwork(Transport, connectDataLink);


    }


    public void onDataReceived(byte[] data) {
        try {
            receptionQueue.put(data);
        } catch (InterruptedException e) {
            Log.e(TAG, "onDataReceived: Error:", e);
        }
    }


    public TpInterfaceManager(DataLinkConnectorTP connectDataLinkInterface, Context context) {
        this.connectDataLink = connectDataLinkInterface;
        this.context = context;
        initializeLayers();
    }


    private boolean fileExists(Uri uri) {
        if (uri == null) {
            return false;
        }

        ContentResolver resolver = context.getContentResolver();
        ParcelFileDescriptor pfd = null;
        try {
            pfd = resolver.openFileDescriptor(uri, "r");
            return pfd != null;
        } catch (FileNotFoundException e) {
            Log.e(TAG, "File not found: " + uri, e);
        } catch (Exception e) {
            Log.e(TAG, "Error opening file descriptor: " + uri, e);
        } finally {
            try {
                if (pfd != null) {
                    pfd.close();
                }
            } catch (IOException e) {
                Log.e(TAG, "Error closing file descriptor: " + uri, e);
            }
        }
        return false;
    }



    public void setTPConfig(String filePath) {
        Uri configFileUri = Uri.parse(filePath);
        if (!fileExists(configFileUri)) {
            Log.e(TAG, "Configuration file does not exist: " + filePath);
            return;
        }

        try (InputStream inputStream = configFileUri.getScheme().equalsIgnoreCase("content") ?
                context.getContentResolver().openInputStream(configFileUri) :
                Files.newInputStream(Paths.get(configFileUri.getPath()))) {

            if (inputStream == null) {
                throw new IOException("Failed to open config file input stream.");
            }

            Yaml yaml = new Yaml();

            CanConfig config = yaml.loadAs(inputStream, CanConfig.class);
            I15765CanConfig.physicalCanId = config.getCanIds().getPhysical();
            I15765CanConfig.functionalCanId = config.getCanIds().getFunctional();
            I15765CanConfig.responseCanId = config.getCanIds().getResponse();
            I15765CanConfig.timeoutMs =  config.getCanTp().getTimeoutMs();
            I15765CanConfig.TxSeperationTime = (byte) config.getCanTp().getStminTx();

        } catch (IOException | SecurityException e) {
            Log.e(TAG, "Failed to load or parse YAML configuration.", e);
        }
    }







    @Override
    public int sendRequest(byte[] Payload, int paloadLength) {
        Session.RecieveDataFromApplication(Payload, paloadLength);
        return 0;
    }

    @Override
    public void readResponse(ResponseFrameContainer Response, int timeoutInMillis) {
        try {
            byte[] responseFrame = receptionQueue.poll(timeoutInMillis, TimeUnit.MILLISECONDS);
            if (responseFrame != null) {
                Response.setResponseFrame(responseFrame);
                Response.serviceResponse = ResponseFrameContainer.ServiceResponse.RESPONSE_SUCCESS;
                return;
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            Response.serviceResponse = ResponseFrameContainer.ServiceResponse.RESPONSE_FAILD;
        }
        Log.d("iso15765TP", "No data received within the timeout.");
        Response.serviceResponse = ResponseFrameContainer.ServiceResponse.NO_RESPONSE;
    }


}