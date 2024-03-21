package com.royalenfield.dataaggregator.DataTransformLayer;

import android.content.Context;
import android.util.Log;


import com.royalenfield.dataaggregator.DataPreserveLayer.Intervals;
import com.royalenfield.dataaggregator.DataTransformLayer.SignalConvert.ConverterInitialize;
import com.royalenfield.dataaggregator.DataTransformLayer.SignalConvert.SignalConverter;
import com.royalenfield.dataaggregator.FrameStructure.CanFrames;
import com.royalenfield.dataaggregator.strategicIoLayer.SignalPublisher;
import com.royalenfield.dataaggregator.strategicIoLayer.dbHandler.DBHandler_10ms;
import com.royalenfield.dataaggregator.strategicIoLayer.dbHandler.DBHandler_500ms;
import com.royalenfield.dataaggregator.strategicIoLayer.dbHandler.DBHandler_50ms;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * DataTransformMain is responsible for handling the transformation of CAN messages into specific data structures.
 * It uses SignalConverter to deserialize CAN message data and processes it accordingly.
 */
public class CanDataProcessor {
    private Context context;
    private SignalConverter signalConverter = new SignalConverter();
    private DBHandler_10ms databaseHandler_10ms;
    private DBHandler_50ms databaseHandler_50ms;
    private DBHandler_500ms databaseHandler_500ms;
    private static final String TAG = "CanProcessor";
    private static final int THREAD_POOL_SIZE = 10;
    private static final ExecutorService executorService = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

    public CanDataProcessor(Context context) {
        this.context = context;
        databaseHandler_10ms = new DBHandler_10ms(context);
        databaseHandler_50ms = new DBHandler_50ms(context);
        databaseHandler_500ms = new DBHandler_500ms(context);
    }

    public void ABS_Diag_Request_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.ABS_Diag_Request_t vcuMessages_deserialize_abs_diag_request = new ConverterInitialize.ABS_Diag_Request_t();
        signalConverter.Deserialize_ABS_Diag_Request(vcuMessages_deserialize_abs_diag_request, receivedData.Data);

        Class<?> messageType = vcuMessages_deserialize_abs_diag_request.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_abs_diag_request);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void ABS_Diag_Response_Handle(CanFrames receivedData, Intervals interval) {

        ConverterInitialize.ABS_Diag_Response_t vcuMessages_deserialize_abs_diag_response =
                new ConverterInitialize.ABS_Diag_Response_t();
        signalConverter.Deserialize_ABS_Diag_Response(
                vcuMessages_deserialize_abs_diag_response, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_abs_diag_response.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_abs_diag_response);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void ABS_Hardware_Version_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.ABS_Hardware_Version_t vcuMessages_deserialize_abs_hardware_version = new ConverterInitialize.ABS_Hardware_Version_t();
        signalConverter.Deserialize_ABS_Hardware_Version(vcuMessages_deserialize_abs_hardware_version, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_abs_hardware_version.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_abs_hardware_version);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void ABS_Parameters_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.ABS_Parameters_t vcuMessages_deserialize_abs_parameters = new ConverterInitialize.ABS_Parameters_t();
        signalConverter.Deserialize_ABS_Parameters(vcuMessages_deserialize_abs_parameters, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_abs_parameters.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_abs_parameters);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void ABS_Software_Version_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.ABS_Software_Version_t vcuMessages_deserialize_abs_software_version = new ConverterInitialize.ABS_Software_Version_t();
        signalConverter.Deserialize_ABS_Software_Version(vcuMessages_deserialize_abs_software_version, receivedData.Data);

        Class<?> messageType = vcuMessages_deserialize_abs_software_version.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_abs_software_version);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void Battery_Energy_Cycles_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.Battery_Energy_Cycles_t vcuMessages_deserialize_battery_energy_cycles = new ConverterInitialize.Battery_Energy_Cycles_t();
        signalConverter.Deserialize_Battery_Energy_Cycles(vcuMessages_deserialize_battery_energy_cycles, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_battery_energy_cycles.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_battery_energy_cycles);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BATTERY_LIMITS_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BATTERY_LIMITS_t vcuMessages_deserialize_battery_limits = new ConverterInitialize.BATTERY_LIMITS_t();
        signalConverter.Deserialize_BATTERY_LIMITS(vcuMessages_deserialize_battery_limits, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_battery_limits.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_battery_limits);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BATTERY_STATUS_INFO_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BATTERY_STATUS_INFO_t vcuMessages_deserialize_battery_status_info = new ConverterInitialize.BATTERY_STATUS_INFO_t();
        signalConverter.Deserialize_BATTERY_STATUS_INFO(vcuMessages_deserialize_battery_status_info, receivedData.Data);

        Class<?> messageType = vcuMessages_deserialize_battery_status_info.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_battery_status_info);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BATTERY_TEMPERATURE_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BATTERY_TEMPERATURE_t vcuMessages_deserialize_battery_temperature = new ConverterInitialize.BATTERY_TEMPERATURE_t();
        signalConverter.Deserialize_BATTERY_TEMPERATURE(vcuMessages_deserialize_battery_temperature, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_battery_temperature.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_battery_temperature);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BCM_Diagnostic_Request_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BCM_Diagnostic_Request_t vcuMessages_deserialize_bcm_diagnostic_request = new ConverterInitialize.BCM_Diagnostic_Request_t();
        signalConverter.Deserialize_BCM_Diagnostic_Request(vcuMessages_deserialize_bcm_diagnostic_request, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bcm_diagnostic_request.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bcm_diagnostic_request);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BCM_Diagnostic_Response_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BCM_Diagnostic_Response_t vcuMessages_deserialize_bcm_diagnostic_response = new ConverterInitialize.BCM_Diagnostic_Response_t();
        signalConverter.Deserialize_BCM_Diagnostic_Response(vcuMessages_deserialize_bcm_diagnostic_response, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bcm_diagnostic_response.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bcm_diagnostic_response);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_CELL_STATUS_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_CELL_STATUS_t vcuMessages_deserialize_bms_cell_status = new ConverterInitialize.BMS_CELL_STATUS_t();
        signalConverter.Deserialize_BMS_CELL_STATUS(vcuMessages_deserialize_bms_cell_status, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_cell_status.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_cell_status);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_CELL_VOLTAGE_1_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_CELL_VOLTAGE_1_t vcuMessages_deserialize_bms_cell_voltage_1 = new ConverterInitialize.BMS_CELL_VOLTAGE_1_t();
        signalConverter.Deserialize_BMS_CELL_VOLTAGE_1(vcuMessages_deserialize_bms_cell_voltage_1, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_cell_voltage_1.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_cell_voltage_1);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_CELL_VOLTAGE_2_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_CELL_VOLTAGE_2_t vcuMessages_deserialize_bms_cell_voltage_2 = new ConverterInitialize.BMS_CELL_VOLTAGE_2_t();
        signalConverter.Deserialize_BMS_CELL_VOLTAGE_2(vcuMessages_deserialize_bms_cell_voltage_2, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_cell_voltage_2.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_cell_voltage_2);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_CELL_VOLTAGE_3_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_CELL_VOLTAGE_3_t vcuMessages_deserialize_bms_cell_voltage_3 = new ConverterInitialize.BMS_CELL_VOLTAGE_3_t();
        signalConverter.Deserialize_BMS_CELL_VOLTAGE_3(vcuMessages_deserialize_bms_cell_voltage_3, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_cell_voltage_3.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_cell_voltage_3);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_CELL_VOLTAGE_4_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_CELL_VOLTAGE_4_t vcuMessages_deserialize_bms_cell_voltage_4 = new ConverterInitialize.BMS_CELL_VOLTAGE_4_t();
        signalConverter.Deserialize_BMS_CELL_VOLTAGE_4(vcuMessages_deserialize_bms_cell_voltage_4, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_cell_voltage_4.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_cell_voltage_4);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_CELL_VOLTAGE_5_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_CELL_VOLTAGE_5_t vcuMessages_deserialize_bms_cell_voltage_5 = new ConverterInitialize.BMS_CELL_VOLTAGE_5_t();
        signalConverter.Deserialize_BMS_CELL_VOLTAGE_5(vcuMessages_deserialize_bms_cell_voltage_5, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_cell_voltage_5.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_cell_voltage_5);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_CELL_VOLTAGE_6_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_CELL_VOLTAGE_6_t vcuMessages_deserialize_bms_cell_voltage_6 = new ConverterInitialize.BMS_CELL_VOLTAGE_6_t();
        signalConverter.Deserialize_BMS_CELL_VOLTAGE_6(vcuMessages_deserialize_bms_cell_voltage_6, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_cell_voltage_6.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_cell_voltage_6);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_CELL_VOLTAGE_7_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_CELL_VOLTAGE_7_t vcuMessages_deserialize_bms_cell_voltage_7 = new ConverterInitialize.BMS_CELL_VOLTAGE_7_t();
        signalConverter.Deserialize_BMS_CELL_VOLTAGE_7(vcuMessages_deserialize_bms_cell_voltage_7, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_cell_voltage_7.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_cell_voltage_7);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_Diagnostic_Request_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_Diagnostic_Request_t vcuMessages_deserialize_bms_diagnostic_request = new ConverterInitialize.BMS_Diagnostic_Request_t();
        signalConverter.Deserialize_BMS_Diagnostic_Request(vcuMessages_deserialize_bms_diagnostic_request, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_diagnostic_request.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_diagnostic_request);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_Diagnostic_Response_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_Diagnostic_Response_t vcuMessages_deserialize_bms_diagnostic_response = new ConverterInitialize.BMS_Diagnostic_Response_t();
        signalConverter.Deserialize_BMS_Diagnostic_Response(vcuMessages_deserialize_bms_diagnostic_response, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_diagnostic_response.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_diagnostic_response);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_Fault_1_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_Fault_1_t vcuMessages_deserialize_bms_fault_1 = new ConverterInitialize.BMS_Fault_1_t();
        signalConverter.Deserialize_BMS_Fault_1(vcuMessages_deserialize_bms_fault_1, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_fault_1.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_fault_1);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_Fault_2_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_Fault_2_t vcuMessages_deserialize_bms_fault_2 = new ConverterInitialize.BMS_Fault_2_t();
        signalConverter.Deserialize_BMS_Fault_2(vcuMessages_deserialize_bms_fault_2, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_fault_2.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_fault_2);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_HARDWARE_VERSION_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_HARDWARE_VERSION_t vcuMessages_deserialize_bms_hardware_version = new ConverterInitialize.BMS_HARDWARE_VERSION_t();
        signalConverter.Deserialize_BMS_HARDWARE_VERSION(vcuMessages_deserialize_bms_hardware_version, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_hardware_version.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_hardware_version);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_PARAMETER_1_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_PARAMETER_1_t vcuMessages_deserialize_bms_parameter_1 = new ConverterInitialize.BMS_PARAMETER_1_t();
        signalConverter.Deserialize_BMS_PARAMETER_1(vcuMessages_deserialize_bms_parameter_1, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_parameter_1.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_parameter_1);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_PARAMETER_3_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_PARAMETER_3_t vcuMessages_deserialize_bms_parameter_3 = new ConverterInitialize.BMS_PARAMETER_3_t();
        signalConverter.Deserialize_BMS_PARAMETER_3(vcuMessages_deserialize_bms_parameter_3, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_parameter_3.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_parameter_3);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_PARAMETER_4_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_PARAMETER_4_t vcuMessages_deserialize_bms_parameter_4 = new ConverterInitialize.BMS_PARAMETER_4_t();
        signalConverter.Deserialize_BMS_PARAMETER_4(vcuMessages_deserialize_bms_parameter_4, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_parameter_4.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_parameter_4);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_PARAMETER_LIMIT_2_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_PARAMETER_LIMIT_2_t vcuMessages_deserialize_bms_parameter_2 = new ConverterInitialize.BMS_PARAMETER_LIMIT_2_t();
        signalConverter.Deserialize_BMS_PARAMETER_LIMIT_2(vcuMessages_deserialize_bms_parameter_2, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_parameter_2.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();
        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_parameter_2);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
//                processAndSubmitDataToDB(receivedData.CANId, signalName, value, interval);

            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void BMS_SOFTWARE_VERSIONS_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.BMS_SOFTWARE_VERSIONS_t vcuMessages_deserialize_bms_software_versions = new ConverterInitialize.BMS_SOFTWARE_VERSIONS_t();
        signalConverter.Deserialize_BMS_SOFTWARE_VERSIONS(vcuMessages_deserialize_bms_software_versions, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_bms_software_versions.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_bms_software_versions);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void Charger_Fault_Info_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.Charger_Fault_Info_t vcuMessages_deserialize_charger_fault_info = new ConverterInitialize.Charger_Fault_Info_t();
        signalConverter.Deserialize_Charger_Fault_Info(vcuMessages_deserialize_charger_fault_info, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_charger_fault_info.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_charger_fault_info);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void Charger_Parameter_1_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.Charger_Parameter_1_t vcuMessages_deserialize_charger_parameter_1 = new ConverterInitialize.Charger_Parameter_1_t();
        signalConverter.Deserialize_Charger_Parameter_1(vcuMessages_deserialize_charger_parameter_1, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_charger_parameter_1.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_charger_parameter_1);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void Charger_status_Info_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.Charger_status_Info_t vcuMessages_deserialize_charger_status_info = new ConverterInitialize.Charger_status_Info_t();
        signalConverter.Deserialize_Charger_status_Info(vcuMessages_deserialize_charger_status_info, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_charger_status_info.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_charger_status_info);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void Custom_Mode_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.Custom_Mode_t vcuMessages_deserialize_custom_mode = new ConverterInitialize.Custom_Mode_t();
        signalConverter.Deserialize_Custom_Mode(vcuMessages_deserialize_custom_mode, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_custom_mode.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_custom_mode);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void Display_info_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.Display_info_t vcuMessages_deserialize_display_info = new ConverterInitialize.Display_info_t();
        signalConverter.Deserialize_Display_info(vcuMessages_deserialize_display_info, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_display_info.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_display_info);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void Environment_Data_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.Environment_Data_t vcuMessages_deserialize_environment_data = new ConverterInitialize.Environment_Data_t();
        signalConverter.Deserialize_Environment_Data(vcuMessages_deserialize_environment_data, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_environment_data.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_environment_data);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void ESCL_Data_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.ESCL_Data_t vcuMessages_deserialize_escl_data = new ConverterInitialize.ESCL_Data_t();
        signalConverter.Deserialize_ESCL_Data(vcuMessages_deserialize_escl_data, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_escl_data.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_escl_data);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void ESCL_Diagnostic_Request_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.ESCL_Diagnostic_Request_t vcuMessages_deserialize_escl_diagnostic_request = new ConverterInitialize.ESCL_Diagnostic_Request_t();
        signalConverter.Deserialize_ESCL_Diagnostic_Request(vcuMessages_deserialize_escl_diagnostic_request, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_escl_diagnostic_request.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_escl_diagnostic_request);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void ESCL_Diagnostic_Response_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.ESCL_Diagnostic_Response_t vcuMessages_deserialize_escl_diagnostic_response = new ConverterInitialize.ESCL_Diagnostic_Response_t();
        signalConverter.Deserialize_ESCL_Diagnostic_Response(vcuMessages_deserialize_escl_diagnostic_response, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_escl_diagnostic_response.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_escl_diagnostic_response);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void ESCL_HW_Version_Info_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.ESCL_HW_Version_Info_t vcuMessages_deserialize_escl_hw_version_info = new ConverterInitialize.ESCL_HW_Version_Info_t();
        signalConverter.Deserialize_ESCL_HW_Version_Info(vcuMessages_deserialize_escl_hw_version_info, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_escl_hw_version_info.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_escl_hw_version_info);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void ESCL_SW_Version_Info_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.ESCL_SW_Version_Info_t vcuMessages_deserialize_escl_sw_version_info = new ConverterInitialize.ESCL_SW_Version_Info_t();
        signalConverter.Deserialize_ESCL_SW_Version_Info(vcuMessages_deserialize_escl_sw_version_info, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_escl_sw_version_info.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_escl_sw_version_info);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void Func_Diagnostic_Request_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.Func_Diagnostic_Request_t vcuMessages_deserialize_func_diagnostic_request = new ConverterInitialize.Func_Diagnostic_Request_t();
        signalConverter.Deserialize_Func_Diagnostic_Request(vcuMessages_deserialize_func_diagnostic_request, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_func_diagnostic_request.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_func_diagnostic_request);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void HP_DCDC_Parameter1_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.HP_DCDC_Parameter1_t vcuMessages_deserialize_hp_dcdc_parameter_1 = new ConverterInitialize.HP_DCDC_Parameter1_t();
        signalConverter.Deserialize_HP_DCDC_Parameter1(vcuMessages_deserialize_hp_dcdc_parameter_1, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_hp_dcdc_parameter_1.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_hp_dcdc_parameter_1);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void HU_Diagnostic_Request_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.HU_Diagnostic_Request_t vcuMessages_deserialize_hu_diagnostic_request = new ConverterInitialize.HU_Diagnostic_Request_t();
        signalConverter.Deserialize_HU_Diagnostic_Request(vcuMessages_deserialize_hu_diagnostic_request, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_hu_diagnostic_request.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_hu_diagnostic_request);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void HU_Diagnostic_Response_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.HU_Diagnostic_Response_t vcuMessages_deserialize_hu_diagnostic_response = new ConverterInitialize.HU_Diagnostic_Response_t();
        signalConverter.Deserialize_HU_Diagnostic_Response(vcuMessages_deserialize_hu_diagnostic_response, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_hu_diagnostic_response.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_hu_diagnostic_response);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void IC_Paramter_1_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.IC_Paramter_1_t vcuMessages_deserialize_ic_parameter_1 = new ConverterInitialize.IC_Paramter_1_t();
        signalConverter.Deserialize_IC_Paramter_1(vcuMessages_deserialize_ic_parameter_1, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_ic_parameter_1.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_ic_parameter_1);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void ICM_Digital_Input_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.ICM_Digital_Input_t vcuMessages_deserialize_icm_digital_input = new ConverterInitialize.ICM_Digital_Input_t();
        signalConverter.Deserialize_ICM_Digital_Input(vcuMessages_deserialize_icm_digital_input, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_icm_digital_input.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_icm_digital_input);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void ICM_Error_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.ICM_Error_t vcuMessages_deserialize_icm_error = new ConverterInitialize.ICM_Error_t();
        signalConverter.Deserialize_ICM_Error(vcuMessages_deserialize_icm_error, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_icm_error.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_icm_error);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void ICM_HW_Version_Info_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.ICM_HW_Version_Info_t vcuMessages_deserialize_icm_hw_version_info = new ConverterInitialize.ICM_HW_Version_Info_t();
        signalConverter.Deserialize_ICM_HW_Version_Info(vcuMessages_deserialize_icm_hw_version_info, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_icm_hw_version_info.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_icm_hw_version_info);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void ICM_SW_Version_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.ICM_SW_Version_t vcuMessages_deserialize_icm_sw_version = new ConverterInitialize.ICM_SW_Version_t();
        signalConverter.Deserialize_ICM_SW_Version(vcuMessages_deserialize_icm_sw_version, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_icm_sw_version.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_icm_sw_version);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void IMU_Data_X_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.IMU_Data_X_t vcuMessages_deserialize_imu_data_x = new ConverterInitialize.IMU_Data_X_t();
        signalConverter.Deserialize_IMU_Data_X(vcuMessages_deserialize_imu_data_x, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_imu_data_x.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_imu_data_x);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void IMU_Data_Y_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.IMU_Data_Y_t vcuMessages_deserialize_imu_data_y = new ConverterInitialize.IMU_Data_Y_t();
        signalConverter.Deserialize_IMU_Data_Y(vcuMessages_deserialize_imu_data_y, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_imu_data_y.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_imu_data_y);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void IMU_Data_Z_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.IMU_Data_Z_t vcuMessages_deserialize_imu_data_z = new ConverterInitialize.IMU_Data_Z_t();
        signalConverter.Deserialize_IMU_Data_Z(vcuMessages_deserialize_imu_data_z, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_imu_data_z.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_imu_data_z);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void LSC_Diagnostic_Request_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.LSC_Diagnostic_Request_t vcuMessages_deserialize_lsc_diagnostic_request = new ConverterInitialize.LSC_Diagnostic_Request_t();
        signalConverter.Deserialize_LSC_Diagnostic_Request(vcuMessages_deserialize_lsc_diagnostic_request, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_lsc_diagnostic_request.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_lsc_diagnostic_request);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void LSC_Diagnostic_Response_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.LSC_Diagnostic_Response_t vcuMessages_deserialize_lsc_diagnostic_response = new ConverterInitialize.LSC_Diagnostic_Response_t();
        signalConverter.Deserialize_LSC_Diagnostic_Response(vcuMessages_deserialize_lsc_diagnostic_response, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_lsc_diagnostic_response.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_lsc_diagnostic_response);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void LSC_HW_Version_Info_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.LSC_HW_Version_Info_t vcuMessages_deserialize_lsc_hw_version_info = new ConverterInitialize.LSC_HW_Version_Info_t();
        signalConverter.Deserialize_LSC_HW_Version_Info(vcuMessages_deserialize_lsc_hw_version_info, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_lsc_hw_version_info.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_lsc_hw_version_info);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void LSC_SW_Version_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.LSC_SW_Version_t vcuMessages_deserialize_lsc_sw_version = new ConverterInitialize.LSC_SW_Version_t();
        signalConverter.Deserialize_LSC_SW_Version(vcuMessages_deserialize_lsc_sw_version, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_lsc_sw_version.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_lsc_sw_version);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void MCU_DATA_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.MCU_DATA_t vcuMessages_deserialize_mcu_data = new ConverterInitialize.MCU_DATA_t();
        signalConverter.Deserialize_MCU_DATA(vcuMessages_deserialize_mcu_data, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_mcu_data.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_mcu_data);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void MCU_Data1_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.MCU_Data1_t vcuMessages_deserialize_mcu_data1 = new ConverterInitialize.MCU_Data1_t();
        signalConverter.Deserialize_MCU_Data1(vcuMessages_deserialize_mcu_data1, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_mcu_data1.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_mcu_data1);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void MCU_Data2_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.MCU_Data2_t vcuMessages_deserialize_mcu_data2 = new ConverterInitialize.MCU_Data2_t();
        signalConverter.Deserialize_MCU_Data2(vcuMessages_deserialize_mcu_data2, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_mcu_data2.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_mcu_data2);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void MCU_Data3_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.MCU_Data3_t vcuMessages_deserialize_mcu_data3 = new ConverterInitialize.MCU_Data3_t();
        signalConverter.Deserialize_MCU_Data3(vcuMessages_deserialize_mcu_data3, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_mcu_data3.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_mcu_data3);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void MCU_Data4_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.MCU_Data4_t vcuMessages_deserialize_mcu_data4 = new ConverterInitialize.MCU_Data4_t();
        signalConverter.Deserialize_MCU_Data4(vcuMessages_deserialize_mcu_data4, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_mcu_data4.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_mcu_data4);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void MCU_Diagnostic_Request_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.MCU_Diagnostic_Request_t vcuMessages_deserialize_mcu_diagnostic_request = new ConverterInitialize.MCU_Diagnostic_Request_t();
        signalConverter.Deserialize_MCU_Diagnostic_Request(vcuMessages_deserialize_mcu_diagnostic_request, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_mcu_diagnostic_request.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_mcu_diagnostic_request);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void MCU_Diagnostic_Response_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.MCU_Diagnostic_Response_t vcuMessages_deserialize_mcu_diagnostic_response = new ConverterInitialize.MCU_Diagnostic_Response_t();
        signalConverter.Deserialize_MCU_Diagnostic_Response(vcuMessages_deserialize_mcu_diagnostic_response, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_mcu_diagnostic_response.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_mcu_diagnostic_response);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void MCU_Disconnect_ACK_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.MCU_Disconnect_ACK_t vcuMessages_deserialize_mcu_disconnect_ack = new ConverterInitialize.MCU_Disconnect_ACK_t();
        signalConverter.Deserialize_MCU_Disconnect_ACK(vcuMessages_deserialize_mcu_disconnect_ack, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_mcu_disconnect_ack.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_mcu_disconnect_ack);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void MCU_Fault_Data_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.MCU_Fault_Data_t vcuMessages_deserialize_mcu_fault_data = new ConverterInitialize.MCU_Fault_Data_t();
        signalConverter.Deserialize_MCU_Fault_Data(vcuMessages_deserialize_mcu_fault_data, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_mcu_fault_data.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_mcu_fault_data);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void MCU_SW_Version_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.MCU_SW_Version_t vcuMessages_deserialize_mcu_sw_version = new ConverterInitialize.MCU_SW_Version_t();
        signalConverter.Deserialize_MCU_SW_Version(vcuMessages_deserialize_mcu_sw_version, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_mcu_sw_version.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_mcu_sw_version);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void MCU_to_VCU_Auth_Resp_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.MCU_to_VCU_Auth_Resp_t vcuMessages_deserialize_mcu_to_vcu_auth_resp = new ConverterInitialize.MCU_to_VCU_Auth_Resp_t();
        signalConverter.Deserialize_MCU_to_VCU_Auth_Resp(vcuMessages_deserialize_mcu_to_vcu_auth_resp, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_mcu_to_vcu_auth_resp.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_mcu_to_vcu_auth_resp);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void OBC_Diagnostic_Request_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.OBC_Diagnostic_Request_t vcuMessages_deserialize_obc_diagnostic_request = new ConverterInitialize.OBC_Diagnostic_Request_t();
        signalConverter.Deserialize_OBC_Diagnostic_Request(vcuMessages_deserialize_obc_diagnostic_request, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_obc_diagnostic_request.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_obc_diagnostic_request);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void OBC_Diagnostic_Response_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.OBC_Diagnostic_Response_t vcuMessages_deserialize_obc_diagnostic_response = new ConverterInitialize.OBC_Diagnostic_Response_t();
        signalConverter.Deserialize_OBC_Diagnostic_Response(vcuMessages_deserialize_obc_diagnostic_response, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_obc_diagnostic_response.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_obc_diagnostic_response);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void OBC_HP_DCDC_Parameter_2_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.OBC_HP_DCDC_Parameter_2_t vcuMessages_deserialize_obc_hp_dcdc_parameter_2 = new ConverterInitialize.OBC_HP_DCDC_Parameter_2_t();
        signalConverter.Deserialize_OBC_HP_DCDC_Parameter_2(vcuMessages_deserialize_obc_hp_dcdc_parameter_2, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_obc_hp_dcdc_parameter_2.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_obc_hp_dcdc_parameter_2);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void OBC_HW_Version_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.OBC_HW_Version_t vcuMessages_deserialize_obc_hw_version = new ConverterInitialize.OBC_HW_Version_t();
        signalConverter.Deserialize_OBC_HW_Version(vcuMessages_deserialize_obc_hw_version, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_obc_hw_version.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_obc_hw_version);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void OBC_SW_Version_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.OBC_SW_Version_t vcuMessages_deserialize_obc_sw_version = new ConverterInitialize.OBC_SW_Version_t();
        signalConverter.Deserialize_OBC_SW_Version(vcuMessages_deserialize_obc_sw_version, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_obc_sw_version.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_obc_sw_version);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void OBC_to_VCU_Auth_Resp_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.OBC_to_VCU_Auth_Resp_t vcuMessages_deserialize_obc_to_vcu_auth_resp = new ConverterInitialize.OBC_to_VCU_Auth_Resp_t();
        signalConverter.Deserialize_OBC_to_VCU_Auth_Resp(vcuMessages_deserialize_obc_to_vcu_auth_resp, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_obc_to_vcu_auth_resp.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_obc_to_vcu_auth_resp);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void OBC_Wakeup_Info_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.OBC_Wakeup_Info_t vcuMessages_deserialize_obc_wakeup_info = new ConverterInitialize.OBC_Wakeup_Info_t();
        signalConverter.Deserialize_OBC_Wakeup_Info(vcuMessages_deserialize_obc_wakeup_info, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_obc_wakeup_info.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_obc_wakeup_info);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void OTA_Status_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.OTA_Status_t vcuMessages_deserialize_ota_status = new ConverterInitialize.OTA_Status_t();
        signalConverter.Deserialize_OTA_Status(vcuMessages_deserialize_ota_status, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_ota_status.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_ota_status);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void RSC_Diagnostic_Request_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.RSC_Diagnostic_Request_t vcuMessages_deserialize_rsc_diagnostic_request = new ConverterInitialize.RSC_Diagnostic_Request_t();
        signalConverter.Deserialize_RSC_Diagnostic_Request(vcuMessages_deserialize_rsc_diagnostic_request, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_rsc_diagnostic_request.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_rsc_diagnostic_request);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void RSC_Diagnostic_Response_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.RSC_Diagnostic_Response_t vcuMessages_deserialize_rsc_diagnostic_response = new ConverterInitialize.RSC_Diagnostic_Response_t();
        signalConverter.Deserialize_RSC_Diagnostic_Response(vcuMessages_deserialize_rsc_diagnostic_response, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_rsc_diagnostic_response.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_rsc_diagnostic_response);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void RSC_HW_Version_Info_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.RSC_HW_Version_Info_t vcuMessages_deserialize_rsc_hw_version_info = new ConverterInitialize.RSC_HW_Version_Info_t();
        signalConverter.Deserialize_RSC_HW_Version_Info(vcuMessages_deserialize_rsc_hw_version_info, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_rsc_hw_version_info.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_rsc_hw_version_info);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void RSC_SW_Version_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.RSC_SW_Version_t vcuMessages_deserialize_rsc_sw_version = new ConverterInitialize.RSC_SW_Version_t();
        signalConverter.Deserialize_RSC_SW_Version(vcuMessages_deserialize_rsc_sw_version, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_rsc_sw_version.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_rsc_sw_version);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void SOM_Parameters_1_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.SOM_Parameters_1_t vcuMessages_deserialize_som_parameters_1 = new ConverterInitialize.SOM_Parameters_1_t();
        signalConverter.Serialize_SOM_Parameters_1(vcuMessages_deserialize_som_parameters_1, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_som_parameters_1.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_som_parameters_1);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void SOM_Settings_Data_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.SOM_Settings_Data_t vcuMessages_deserialize_som_settings_data = new ConverterInitialize.SOM_Settings_Data_t();
        signalConverter.Serialize_SOM_Settings_Data(vcuMessages_deserialize_som_settings_data, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_som_settings_data.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_som_settings_data);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void TimeStamp_Sync_Message_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.TimeStamp_Sync_Message_t vcuMessages_deserialize_timestamp_sync_message = new ConverterInitialize.TimeStamp_Sync_Message_t();
        signalConverter.Deserialize_TimeStamp_Sync_Message(vcuMessages_deserialize_timestamp_sync_message, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_timestamp_sync_message.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_timestamp_sync_message);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void Traction_Control_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.Traction_Control_t vcuMessages_deserialize_traction_control = new ConverterInitialize.Traction_Control_t();
        signalConverter.Deserialize_Traction_Control(vcuMessages_deserialize_traction_control, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_traction_control.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_traction_control);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void Traction_Control2_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.Traction_Control2_t vcuMessages_deserialize_traction_control2 = new ConverterInitialize.Traction_Control2_t();
        signalConverter.Deserialize_Traction_Control2(vcuMessages_deserialize_traction_control2, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_traction_control2.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_traction_control2);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void VCU_Data_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.VCU_Data_t vcuMessages_deserialize_vcu_data = new ConverterInitialize.VCU_Data_t();
        signalConverter.Deserialize_VCU_Data(vcuMessages_deserialize_vcu_data, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_vcu_data.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_vcu_data);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void VCU_to_MCU_Auth_Req_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.VCU_to_MCU_Auth_Req_t vcuMessages_deserialize_vcu_to_mcu_auth_req = new ConverterInitialize.VCU_to_MCU_Auth_Req_t();
        signalConverter.Deserialize_VCU_to_MCU_Auth_Req(vcuMessages_deserialize_vcu_to_mcu_auth_req, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_vcu_to_mcu_auth_req.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_vcu_to_mcu_auth_req);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void VCU_to_MCU_Auth_Stat_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.VCU_to_MCU_Auth_Stat_t vcuMessages_deserialize_vcu_to_mcu_auth_stat = new ConverterInitialize.VCU_to_MCU_Auth_Stat_t();
        signalConverter.Deserialize_VCU_to_MCU_Auth_Stat(vcuMessages_deserialize_vcu_to_mcu_auth_stat, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_vcu_to_mcu_auth_stat.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_vcu_to_mcu_auth_stat);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void VCU_to_OBC_Auth_Req_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.VCU_to_OBC_Auth_Req_t vcuMessages_deserialize_vcu_to_obc_auth_req = new ConverterInitialize.VCU_to_OBC_Auth_Req_t();
        signalConverter.Deserialize_VCU_to_OBC_Auth_Req(vcuMessages_deserialize_vcu_to_obc_auth_req, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_vcu_to_obc_auth_req.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_vcu_to_obc_auth_req);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void VCU_to_OBC_Auth_Stat_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.VCU_to_OBC_Auth_Stat_t vcuMessages_deserialize_vcu_to_obc_auth_stat = new ConverterInitialize.VCU_to_OBC_Auth_Stat_t();
        signalConverter.Deserialize_VCU_to_OBC_Auth_Stat(vcuMessages_deserialize_vcu_to_obc_auth_stat, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_vcu_to_obc_auth_stat.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_vcu_to_obc_auth_stat);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void Vehicle_Func_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.Vehicle_Func_t vcuMessages_deserialize_vehicle_func = new ConverterInitialize.Vehicle_Func_t();
        signalConverter.Deserialize_Vehicle_Func(vcuMessages_deserialize_vehicle_func, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_vehicle_func.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_vehicle_func);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void Vehicle_left_SW_Cube_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.Vehicle_left_SW_Cube_t vcuMessages_deserialize_vehicle_left_sw_cube = new ConverterInitialize.Vehicle_left_SW_Cube_t();
        signalConverter.Deserialize_Vehicle_left_SW_Cube(vcuMessages_deserialize_vehicle_left_sw_cube, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_vehicle_left_sw_cube.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_vehicle_left_sw_cube);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void Vehicle_Mode_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.Vehicle_Mode_t vcuMessages_deserialize_vehicle_mode = new ConverterInitialize.Vehicle_Mode_t();
        signalConverter.Deserialize_Vehicle_Mode(vcuMessages_deserialize_vehicle_mode, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_vehicle_mode.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_vehicle_mode);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void Vehicle_Right_SW_Cube_Handle(CanFrames receivedData, Intervals interval) {
        ConverterInitialize.Vehicle_Right_SW_Cube_t vcuMessages_deserialize_vehicle_right_sw_cube = new ConverterInitialize.Vehicle_Right_SW_Cube_t();
        signalConverter.Deserialize_Vehicle_Right_SW_Cube(vcuMessages_deserialize_vehicle_right_sw_cube, receivedData.Data);
        Class<?> messageType = vcuMessages_deserialize_vehicle_right_sw_cube.getClass();
        Field[] fields = messageType.getDeclaredFields();

        Map<String, Object> signalDataMap = new HashMap<>();

        for (Field field : fields) {
            try {
                field.setAccessible(true);
                Object value = field.get(vcuMessages_deserialize_vehicle_right_sw_cube);
                String signalName = field.getName();
                signalDataMap.put(signalName, value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        executorService.submit(() ->
                processAndSubmitDataToDB(receivedData.CANId, signalDataMap, interval)
        );
    }

    public void processAndSubmitDataToDB(int canid, Map<String, Object> signalDataMap, Intervals interval) {
        try {
            if (context == null) {
                Log.e(TAG, "Context is null");
                return;
            }

            for (Map.Entry<String, Object> entry : signalDataMap.entrySet()) {
                String signalName = entry.getKey();
                Object data = entry.getValue();


                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault());
                String formattedTimestamp = dateFormat.format(new Date());

                Log.d("DatabaseLog", " Timestamp: " + formattedTimestamp + "  CAN ID: 0x" + Integer.toHexString(canid) + "  Signal Name: " + signalName + "  Value: " + String.valueOf(data));


                SignalPublisher signalPublisher = new SignalPublisher(context);
                signalPublisher.SignalBroadcast(canid, signalName, data, formattedTimestamp);

            }

            switch (interval) {
                case Milliseconds_10: {
                    databaseHandler_10ms.saveDataToDatabase(canid, signalDataMap);
                    break;
                }
                case Milliseconds_50: {
                    databaseHandler_50ms.saveDataToDatabase(canid, signalDataMap);
                    break;
                }
                case Milliseconds_500: {
                    databaseHandler_500ms.saveDataToDatabase(canid, signalDataMap);
                    break;
                }
                default:

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
