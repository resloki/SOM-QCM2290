package com.royalenfield.dataaggregator.DataAggregator.DataPreserveLayer;

import com.royalenfield.dataaggregator.DataAggregator.DataTransformLayer.CanDataProcessor;
import com.royalenfield.dataaggregator.DataAggregator.DataTransformLayer.SignalConvert.ConverterInitialize;

import java.util.HashMap;
import java.util.Map;

/**
 * CanHandlerRegistry class is responsible for managing the mappings between CAN IDs and their corresponding handler methods.
 * It initializes these mappings in the constructor based on the provided DataTransformMain instance.
 * The mappings are stored in a HashMap, where the key is the CAN ID and the value is the corresponding CanHandler.
 */

public class CanHandlerRegistry {
    private final Map<Integer, CanHandler> mapHandlers = new HashMap<>();
    private final CanDataProcessor canProcessor;
    ConverterInitialize converterInitialize = new ConverterInitialize();

    public CanHandlerRegistry(CanDataProcessor canProcessor) {
        this.canProcessor = canProcessor;
        initializeHandlers();
    }

    private void initializeHandlers() {
        mapHandlers.put(converterInitialize.ABS_DIAG_REQUEST_ID, canProcessor::ABS_Diag_Request_Handle);
        mapHandlers.put(converterInitialize.ABS_DIAG_RESPONSE_ID, canProcessor::ABS_Diag_Response_Handle);
        mapHandlers.put(converterInitialize.ABS_HARDWARE_VERSION_ID, canProcessor::ABS_Hardware_Version_Handle);
        mapHandlers.put(converterInitialize.ABS_PARAMETERS_ID, canProcessor::ABS_Parameters_Handle);
        mapHandlers.put(converterInitialize.ABS_SOFTWARE_VERSION_ID, canProcessor::ABS_Software_Version_Handle);
        mapHandlers.put(converterInitialize.BATTERY_ENERGY_CYCLES_ID, canProcessor::Battery_Energy_Cycles_Handle);
        mapHandlers.put(converterInitialize.BATTERY_LIMITS_ID, canProcessor::BATTERY_LIMITS_Handle);
        mapHandlers.put(converterInitialize.BATTERY_STATUS_INFO_ID, canProcessor::BATTERY_STATUS_INFO_Handle);
        mapHandlers.put(converterInitialize.BATTERY_TEMPERATURE_ID, canProcessor::BATTERY_TEMPERATURE_Handle);
        mapHandlers.put(converterInitialize.BCM_DIAGNOSTIC_REQUEST_ID, canProcessor::BCM_Diagnostic_Request_Handle);
        mapHandlers.put(converterInitialize.BCM_DIAGNOSTIC_RESPONSE_ID, canProcessor::BCM_Diagnostic_Response_Handle);
        mapHandlers.put(converterInitialize.BMS_CELL_STATUS_ID, canProcessor::BMS_CELL_STATUS_Handle);
        mapHandlers.put(converterInitialize.BMS_CELL_VOLTAGE_1_ID, canProcessor::BMS_CELL_VOLTAGE_1_Handle);
        mapHandlers.put(converterInitialize.BMS_CELL_VOLTAGE_2_ID, canProcessor::BMS_CELL_VOLTAGE_2_Handle);
        mapHandlers.put(converterInitialize.BMS_CELL_VOLTAGE_3_ID, canProcessor::BMS_CELL_VOLTAGE_3_Handle);
        mapHandlers.put(converterInitialize.BMS_CELL_VOLTAGE_4_ID, canProcessor::BMS_CELL_VOLTAGE_4_Handle);
        mapHandlers.put(converterInitialize.BMS_CELL_VOLTAGE_5_ID, canProcessor::BMS_CELL_VOLTAGE_5_Handle);
        mapHandlers.put(converterInitialize.BMS_CELL_VOLTAGE_6_ID, canProcessor::BMS_CELL_VOLTAGE_6_Handle);
        mapHandlers.put(converterInitialize.BMS_CELL_VOLTAGE_7_ID, canProcessor::BMS_CELL_VOLTAGE_7_Handle);
        mapHandlers.put(converterInitialize.BMS_DIAGNOSTIC_REQUEST_ID, canProcessor::BMS_Diagnostic_Request_Handle);
        mapHandlers.put(converterInitialize.BMS_DIAGNOSTIC_RESPONSE_ID, canProcessor::BMS_Diagnostic_Response_Handle);
        mapHandlers.put(converterInitialize.BMS_FAULT_1_ID, canProcessor::BMS_Fault_1_Handle);
        mapHandlers.put(converterInitialize.BMS_FAULT_2_ID, canProcessor::BMS_Fault_2_Handle);
        mapHandlers.put(converterInitialize.BMS_HARDWARE_VERSION_ID, canProcessor::BMS_HARDWARE_VERSION_Handle);
        mapHandlers.put(converterInitialize.BMS_PARAMETER_1_ID, canProcessor::BMS_PARAMETER_1_Handle);
        mapHandlers.put(converterInitialize.BMS_PARAMETER_3_ID, canProcessor::BMS_PARAMETER_3_Handle);
        mapHandlers.put(converterInitialize.BMS_PARAMETER_4_ID, canProcessor::BMS_PARAMETER_4_Handle);
        mapHandlers.put(converterInitialize.BMS_PARAMETER_LIMIT_2_ID, canProcessor::BMS_PARAMETER_LIMIT_2_Handle);
        mapHandlers.put(converterInitialize.BMS_SOFTWARE_VERSIONS_ID, canProcessor::BMS_SOFTWARE_VERSIONS_Handle);
        mapHandlers.put(converterInitialize.CHARGER_FAULT_INFO_ID, canProcessor::Charger_Fault_Info_Handle);
        mapHandlers.put(converterInitialize.CHARGER_PARAMETER_1_ID, canProcessor::Charger_Parameter_1_Handle);
        mapHandlers.put(converterInitialize.CHARGER_STATUS_INFO_ID, canProcessor::Charger_status_Info_Handle);
        mapHandlers.put(converterInitialize.CUSTOM_MODE_ID, canProcessor::Custom_Mode_Handle);
        mapHandlers.put(converterInitialize.DISPLAY_INFO_ID, canProcessor::Display_info_Handle);
        mapHandlers.put(converterInitialize.ENVIRONMENT_DATA_ID, canProcessor::Environment_Data_Handle);
        mapHandlers.put(converterInitialize.ESCL_DATA_ID, canProcessor::ESCL_Data_Handle);
        mapHandlers.put(converterInitialize.ESCL_DIAGNOSTIC_REQUEST_ID, canProcessor::ESCL_Diagnostic_Request_Handle);
        mapHandlers.put(converterInitialize.ESCL_DIAGNOSTIC_RESPONSE_ID, canProcessor::ESCL_Diagnostic_Response_Handle);
        mapHandlers.put(converterInitialize.ESCL_HW_VERSION_INFO_ID, canProcessor::ESCL_HW_Version_Info_Handle);
        mapHandlers.put(converterInitialize.ESCL_SW_VERSION_INFO_ID, canProcessor::ESCL_SW_Version_Info_Handle);
        mapHandlers.put(converterInitialize.FUNC_DIAGNOSTIC_REQUEST_ID, canProcessor::Func_Diagnostic_Request_Handle);
        mapHandlers.put(converterInitialize.HP_DCDC_PARAMETER1_ID, canProcessor::HP_DCDC_Parameter1_Handle);
        mapHandlers.put(converterInitialize.HU_DIAGNOSTIC_REQUEST_ID, canProcessor::HU_Diagnostic_Request_Handle);
        mapHandlers.put(converterInitialize.HU_DIAGNOSTIC_RESPONSE_ID, canProcessor::HU_Diagnostic_Response_Handle);
        mapHandlers.put(converterInitialize.IC_PARAMTER_1_ID, canProcessor::IC_Paramter_1_Handle);
        mapHandlers.put(converterInitialize.ICM_DIGITAL_INPUT_ID, canProcessor::ICM_Digital_Input_Handle);
        mapHandlers.put(converterInitialize.ICM_ERROR_ID, canProcessor::ICM_Error_Handle);
        mapHandlers.put(converterInitialize.ICM_HW_VERSION_INFO_ID, canProcessor::ICM_HW_Version_Info_Handle);
        mapHandlers.put(converterInitialize.ICM_SW_VERSION_ID, canProcessor::ICM_SW_Version_Handle);
        mapHandlers.put(converterInitialize.IMU_DATA_X_ID, canProcessor::IMU_Data_X_Handle);
        mapHandlers.put(converterInitialize.IMU_DATA_Y_ID, canProcessor::IMU_Data_Y_Handle);
        mapHandlers.put(converterInitialize.IMU_DATA_Z_ID, canProcessor::IMU_Data_Z_Handle);
        mapHandlers.put(converterInitialize.LSC_DIAGNOSTIC_REQUEST_ID, canProcessor::LSC_Diagnostic_Request_Handle);
        mapHandlers.put(converterInitialize.LSC_DIAGNOSTIC_RESPONSE_ID, canProcessor::LSC_Diagnostic_Response_Handle);
        mapHandlers.put(converterInitialize.LSC_HW_VERSION_INFO_ID, canProcessor::LSC_HW_Version_Info_Handle);
        mapHandlers.put(converterInitialize.LSC_SW_VERSION_ID, canProcessor::LSC_SW_Version_Handle);
        mapHandlers.put(converterInitialize.MCU_DATA_ID, canProcessor::MCU_DATA_Handle);
        mapHandlers.put(converterInitialize.MCU_DATA1_ID, canProcessor::MCU_Data1_Handle);
        mapHandlers.put(converterInitialize.MCU_DATA2_ID, canProcessor::MCU_Data2_Handle);
        mapHandlers.put(converterInitialize.MCU_DATA3_ID, canProcessor::MCU_Data3_Handle);
        mapHandlers.put(converterInitialize.MCU_DATA4_ID, canProcessor::MCU_Data4_Handle);
        mapHandlers.put(converterInitialize.MCU_DIAGNOSTIC_REQUEST_ID, canProcessor::MCU_Diagnostic_Request_Handle);
        mapHandlers.put(converterInitialize.MCU_DIAGNOSTIC_RESPONSE_ID, canProcessor::MCU_Diagnostic_Response_Handle);
        mapHandlers.put(converterInitialize.MCU_DISCONNECT_ACK_ID, canProcessor::MCU_Disconnect_ACK_Handle);
        mapHandlers.put(converterInitialize.MCU_FAULT_DATA_ID, canProcessor::MCU_Fault_Data_Handle);
        mapHandlers.put(converterInitialize.MCU_SW_VERSION_ID, canProcessor::MCU_SW_Version_Handle);
        mapHandlers.put(converterInitialize.MCU_TO_VCU_AUTH_RESP_ID, canProcessor::MCU_to_VCU_Auth_Resp_Handle);
        mapHandlers.put(converterInitialize.OBC_DIAGNOSTIC_REQUEST_ID, canProcessor::OBC_Diagnostic_Request_Handle);
        mapHandlers.put(converterInitialize.OBC_DIAGNOSTIC_RESPONSE_ID, canProcessor::OBC_Diagnostic_Response_Handle);
        mapHandlers.put(converterInitialize.OBC_HP_DCDC_PARAMETER_2_ID, canProcessor::OBC_HP_DCDC_Parameter_2_Handle);
        mapHandlers.put(converterInitialize.OBC_HW_VERSION_ID, canProcessor::OBC_HW_Version_Handle);
        mapHandlers.put(converterInitialize.OBC_SW_VERSION_ID, canProcessor::OBC_SW_Version_Handle);
        mapHandlers.put(converterInitialize.OBC_TO_VCU_AUTH_RESP_ID, canProcessor::OBC_to_VCU_Auth_Resp_Handle);
        mapHandlers.put(converterInitialize.OBC_WAKEUP_INFO_ID, canProcessor::OBC_Wakeup_Info_Handle);
        mapHandlers.put(converterInitialize.OTA_STATUS_ID, canProcessor::OTA_Status_Handle);
        mapHandlers.put(converterInitialize.RSC_DIAGNOSTIC_REQUEST_ID, canProcessor::RSC_Diagnostic_Request_Handle);
        mapHandlers.put(converterInitialize.RSC_DIAGNOSTIC_RESPONSE_ID, canProcessor::RSC_Diagnostic_Response_Handle);
        mapHandlers.put(converterInitialize.RSC_HW_VERSION_INFO_ID, canProcessor::RSC_HW_Version_Info_Handle);
        mapHandlers.put(converterInitialize.RSC_SW_VERSION_ID, canProcessor::RSC_SW_Version_Handle);
        mapHandlers.put(converterInitialize.SOM_PARAMETERS_1_ID, canProcessor::SOM_Parameters_1_Handle);
        mapHandlers.put(converterInitialize.SOM_SETTINGS_DATA_ID, canProcessor::SOM_Settings_Data_Handle);
        mapHandlers.put(converterInitialize.TIMESTAMP_SYNC_MESSAGE_ID, canProcessor::TimeStamp_Sync_Message_Handle);
        mapHandlers.put(converterInitialize.TRACTION_CONTROL_ID, canProcessor::Traction_Control_Handle);
        mapHandlers.put(converterInitialize.TRACTION_CONTROL2_ID, canProcessor::Traction_Control2_Handle);
        mapHandlers.put(converterInitialize.VCU_DATA_ID, canProcessor::VCU_Data_Handle);
        mapHandlers.put(converterInitialize.VCU_TO_MCU_AUTH_REQ_ID, canProcessor::VCU_to_MCU_Auth_Req_Handle);
        mapHandlers.put(converterInitialize.VCU_TO_MCU_AUTH_STAT_ID, canProcessor::VCU_to_MCU_Auth_Stat_Handle);
        mapHandlers.put(converterInitialize.VCU_TO_OBC_AUTH_REQ_ID, canProcessor::VCU_to_OBC_Auth_Req_Handle);
        mapHandlers.put(converterInitialize.VCU_TO_OBC_AUTH_STAT_ID, canProcessor::VCU_to_OBC_Auth_Stat_Handle);
        mapHandlers.put(converterInitialize.VEHICLE_FUNC_ID, canProcessor::Vehicle_Func_Handle);
        mapHandlers.put(converterInitialize.VEHICLE_LEFT_SW_CUBE_ID, canProcessor::Vehicle_left_SW_Cube_Handle);
        mapHandlers.put(converterInitialize.VEHICLE_MODE_ID, canProcessor::Vehicle_Mode_Handle);
        mapHandlers.put(converterInitialize.VEHICLE_RIGHT_SW_CUBE_ID, canProcessor::Vehicle_Right_SW_Cube_Handle);
    }

    public CanHandler getHandler(int canId) {
        return mapHandlers.get(canId);
    }
}
