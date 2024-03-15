package com.royalenfield.diagcan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.provider.OpenableColumns;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "AidlClientActivity";
    private UDSService mUDSService;
    Button xmlfileLoadBtn;
    TextView titleTextView;
    TextView descriptionTextView;
    Button grantPermissionButton;
    Button hexfileLoadButton;
    Button xmlfileLoadButton;
    Button submit_BL_Request;
    Button submit_AP_Request;


    private static final int STORAGE_PERMISSION_REQUEST_CODE = 1001;
    private static final int REQUEST_PICK_HEX_FILE = 1;
    private static final int REQUEST_PICK_XML_FILE = 2;


    protected Uri UDSFlowConfig = null;
    protected Uri ProgramFile = null;


    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName className, IBinder service) {
            mUDSService = UDSService.Stub.asInterface(service);
        }

        @Override
        public void onServiceDisconnected(ComponentName className) {
            mUDSService = null;
        }
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        titleTextView = findViewById(R.id.titleTextView);
        descriptionTextView = findViewById(R.id.descriptionTextView);
        grantPermissionButton = findViewById(R.id.grant_permission_button);
        hexfileLoadButton = findViewById(R.id.hexfileLoadBtn);
        xmlfileLoadButton = findViewById(R.id.xmlfileLoadBtn);
        submit_BL_Request = findViewById(R.id.submit_BL_Request);
        submit_AP_Request = findViewById(R.id.submit_AP_Request);


        // Set onClickListener for grantPermissionButton
        grantPermissionButton.setOnClickListener(v -> {
            
        });


        // Set onClickListener for hexfileLoadButton
        hexfileLoadButton.setOnClickListener(v -> {
            loadHexFile();
        });

        // Set onClickListener for xmlfileLoadButton
        xmlfileLoadButton.setOnClickListener(v -> {
            loadXmlFile();
        });

        // Set onClickListener for submitRequestButton
        submit_BL_Request.setOnClickListener(v -> {
            submitRequest_BL();
        });


        // Set onClickListener for submitRequestButton
        submit_AP_Request.setOnClickListener(v -> {
            submitRequest_AL();
        });


    }


    private void loadHexFile() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("application/octet-stream");
        intent.putExtra(Intent.EXTRA_MIME_TYPES, new String[]{"application/octet-stream", "text/plain"});
        startActivityForResult(intent, REQUEST_PICK_HEX_FILE);
    }

    private void loadXmlFile() {
        Intent intent = new Intent(Intent.ACTION_OPEN_DOCUMENT);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setType("text/xml");
        startActivityForResult(intent, REQUEST_PICK_XML_FILE);
    }


    private void submitRequest_BL() {
        try {
            if (UDSFlowConfig != null && ProgramFile != null) {
                if (fileExists(UDSFlowConfig) && fileExists(ProgramFile)) {
                    Bundle params = new Bundle();
                    params.putString("UDSFlowConfiguration", String.valueOf(UDSFlowConfig));
                    params.putString("ProgramFile", String.valueOf(ProgramFile));
                    params.putInt("PhysicalCanId", 0x7f0);
                    params.putInt("FunctionalCanId", 0x7f0);
                    params.putInt("ResponseCanId", 0x7f1);
                    params.putString("ServiceType", ServiceType.BOOTLOADER.name()); // or ServiceType.APPLICATION.name()
                    mUDSService.SubmitRequest(params);
                } else {
                    Toast.makeText(this, "One or both files do not exist", Toast.LENGTH_SHORT).show();
                }
            } else {

                Toast.makeText(this, "Please select both XML and HEX files", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Log.e(TAG, "submitRequest: Error: "+e);
        }
    }

    private void submitRequest_AL() {
        try {
            if (UDSFlowConfig != null) {
                if (fileExists(UDSFlowConfig)) {
                    Bundle params = new Bundle();
                    params.putString("UDSFlowConfiguration", String.valueOf(UDSFlowConfig));
                    params.putInt("PhysicalCanId", 0x7f0);
                    params.putInt("FunctionalCanId", 0x7f0);
                    params.putInt("ResponseCanId", 0x7f1);
                    params.putString("ServiceType", ServiceType.APPLICATION.name()); // or ServiceType.APPLICATION.name()
                    mUDSService.SubmitRequest(params);
                } else {
                    Toast.makeText(this, "One or both files do not exist", Toast.LENGTH_SHORT).show();
                }
            } else {

                Toast.makeText(this, "Please select both XML and HEX files", Toast.LENGTH_SHORT).show();
            }
        } catch (Exception e) {
            Log.e(TAG, "submitRequest: Error: "+e);
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == STORAGE_PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                //bindServices(); // Bind services when permission is granted
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show();
            }
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == REQUEST_PICK_HEX_FILE) {
                ProgramFile = data.getData();
                String hexFileName = getFileNameFromUri(ProgramFile);
//                selectedHexfileName.setText(hexFileName);
            } else if (requestCode == REQUEST_PICK_XML_FILE) {
                UDSFlowConfig = data.getData();
                String xmlFileName = getFileNameFromUri(UDSFlowConfig);
//                selectedxmlfileName.setText(xmlFileName);
            }
        }
    }


    private boolean fileExists(Uri uri) {
        if (uri != null) {
            ContentResolver resolver = getContentResolver();
            try {
                ParcelFileDescriptor pfd = resolver.openFileDescriptor(uri, "r");
                if (pfd != null) {
                    pfd.close();
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
                Log.e(TAG, "Error in fileExists: " + e.getMessage());
            }
        }
        return false;
    }


    private String getFileNameFromUri(Uri uri) {
        String fileName = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            try {
                if (cursor != null && cursor.moveToFirst()) {
                    // Try to get the display name from the cursor
                    int displayNameIndex = cursor.getColumnIndex(OpenableColumns.DISPLAY_NAME);
                    if (displayNameIndex != -1) {
                        fileName = cursor.getString(displayNameIndex);
                    } else {
                        // If DISPLAY_NAME column is not available, use the last segment of the URI
                        fileName = uri.getLastPathSegment();
                    }
                }
            } finally {
                if (cursor != null) {
                    cursor.close();
                }
            }
        } else if (uri.getScheme().equals("file")) {
            fileName = new File(uri.getPath()).getName();
        }
        return fileName;
    }


    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = new Intent(this, DiagCanServiceMain.class);
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
    }


}