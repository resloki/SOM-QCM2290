package com.royalenfield.dataaggregator.DataAggregator.DataTransformLayer.SignalConvert;


/**
 * SignalConverter is responsible for converting CAN message data to specific data structures
 * and vice versa based on the defined conversion methods in the ConverterInterface.
 */
public class SignalConverter implements ConverterInterface{

    /**
     * @param messages The object to store the deserialized data.
     * @param data     The byte array representing the CAN message data.
     */
    public long Deserialize_VCU_to_OBC_Auth_Req(ConverterInitialize.VCU_to_OBC_Auth_Req_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_to_OBC_Seed = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.VCU_TO_OBC_AUTH_REQ_VCU_TO_OBC_SEED_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.VCU_TO_OBC_AUTH_REQ_VCU_TO_OBC_SEED_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.VCU_TO_OBC_AUTH_REQ_VCU_TO_OBC_SEED_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.VCU_TO_OBC_AUTH_REQ_CANID_VCU_TO_OBC_SEED_OFFSET));

        return can.VCU_TO_OBC_AUTH_REQ_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_VCU_to_OBC_Auth_Req(ConverterInitialize.VCU_to_OBC_Auth_Req_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_to_OBC_Seed = (int) (messages.VCU_to_OBC_Seed - can.VCU_TO_OBC_AUTH_REQ_CANID_VCU_TO_OBC_SEED_OFFSET);
        data[0] = (byte) ((messages.VCU_to_OBC_Seed & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.VCU_to_OBC_Seed >> can.VCU_TO_OBC_AUTH_REQ_VCU_TO_OBC_SEED_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.VCU_to_OBC_Seed >> can.VCU_TO_OBC_AUTH_REQ_VCU_TO_OBC_SEED_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.VCU_to_OBC_Seed >> can.VCU_TO_OBC_AUTH_REQ_VCU_TO_OBC_SEED_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.VCU_TO_OBC_AUTH_REQ_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_VCU_to_OBC_Auth_Stat(ConverterInitialize.VCU_to_OBC_Auth_Stat_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_Auth_Res_to_OBC = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_TO_OBC_AUTH_STAT_CANID_VCU_AUTH_RES_TO_OBC_OFFSET));

        return can.VCU_TO_OBC_AUTH_STAT_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_VCU_to_OBC_Auth_Stat(ConverterInitialize.VCU_to_OBC_Auth_Stat_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_Auth_Res_to_OBC = (byte) (messages.VCU_Auth_Res_to_OBC - can.VCU_TO_OBC_AUTH_STAT_CANID_VCU_AUTH_RES_TO_OBC_OFFSET);
        data[0] = (byte) ((messages.VCU_Auth_Res_to_OBC & (can.SIGNLE_READ_Mask1)));
        return can.VCU_TO_OBC_AUTH_STAT_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OBC_to_VCU_Auth_Resp(ConverterInitialize.OBC_to_VCU_Auth_Resp_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Key = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.OBC_TO_VCU_AUTH_RESP_OBC_KEY_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.OBC_TO_VCU_AUTH_RESP_OBC_KEY_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.OBC_TO_VCU_AUTH_RESP_OBC_KEY_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.OBC_TO_VCU_AUTH_RESP_CANID_OBC_KEY_OFFSET));

        return can.OBC_TO_VCU_AUTH_RESP_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OBC_to_VCU_Auth_Resp(ConverterInitialize.OBC_to_VCU_Auth_Resp_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Key = (int) (messages.OBC_Key - can.OBC_TO_VCU_AUTH_RESP_CANID_OBC_KEY_OFFSET);
        data[0] = (byte) ((messages.OBC_Key & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.OBC_Key >> can.OBC_TO_VCU_AUTH_RESP_OBC_KEY_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.OBC_Key >> can.OBC_TO_VCU_AUTH_RESP_OBC_KEY_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.OBC_Key >> can.OBC_TO_VCU_AUTH_RESP_OBC_KEY_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.OBC_TO_VCU_AUTH_RESP_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_VCU_to_MCU_Auth_Req(ConverterInitialize.VCU_to_MCU_Auth_Req_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_to_MCU_Seed = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.VCU_TO_MCU_AUTH_REQ_VCU_TO_MCU_SEED_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.VCU_TO_MCU_AUTH_REQ_VCU_TO_MCU_SEED_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.VCU_TO_MCU_AUTH_REQ_VCU_TO_MCU_SEED_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.VCU_TO_MCU_AUTH_REQ_CANID_VCU_TO_MCU_SEED_OFFSET));

        return can.VCU_TO_MCU_AUTH_REQ_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_VCU_to_MCU_Auth_Req(ConverterInitialize.VCU_to_MCU_Auth_Req_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_to_MCU_Seed = (int) (messages.VCU_to_MCU_Seed - can.VCU_TO_MCU_AUTH_REQ_CANID_VCU_TO_MCU_SEED_OFFSET);
        data[0] = (byte) ((messages.VCU_to_MCU_Seed & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.VCU_to_MCU_Seed >> can.VCU_TO_MCU_AUTH_REQ_VCU_TO_MCU_SEED_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.VCU_to_MCU_Seed >> can.VCU_TO_MCU_AUTH_REQ_VCU_TO_MCU_SEED_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.VCU_to_MCU_Seed >> can.VCU_TO_MCU_AUTH_REQ_VCU_TO_MCU_SEED_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.VCU_TO_MCU_AUTH_REQ_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_to_VCU_Auth_Resp(ConverterInitialize.MCU_to_VCU_Auth_Resp_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Key = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.MCU_TO_VCU_AUTH_RESP_MCU_KEY_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.MCU_TO_VCU_AUTH_RESP_MCU_KEY_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.MCU_TO_VCU_AUTH_RESP_MCU_KEY_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.MCU_TO_VCU_AUTH_RESP_CANID_MCU_KEY_OFFSET));

        return can.MCU_TO_VCU_AUTH_RESP_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_to_VCU_Auth_Resp(ConverterInitialize.MCU_to_VCU_Auth_Resp_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Key = (int) (messages.MCU_Key - can.MCU_TO_VCU_AUTH_RESP_CANID_MCU_KEY_OFFSET);
        data[0] = (byte) ((messages.MCU_Key & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.MCU_Key >> can.MCU_TO_VCU_AUTH_RESP_MCU_KEY_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.MCU_Key >> can.MCU_TO_VCU_AUTH_RESP_MCU_KEY_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.MCU_Key >> can.MCU_TO_VCU_AUTH_RESP_MCU_KEY_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.MCU_TO_VCU_AUTH_RESP_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_VCU_to_MCU_Auth_Stat(ConverterInitialize.VCU_to_MCU_Auth_Stat_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_Auth_Resp_to_MCU = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_TO_MCU_AUTH_STAT_CANID_VCU_AUTH_RESP_TO_MCU_OFFSET));

        return can.VCU_TO_MCU_AUTH_STAT_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_VCU_to_MCU_Auth_Stat(ConverterInitialize.VCU_to_MCU_Auth_Stat_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_Auth_Resp_to_MCU = (byte) (messages.VCU_Auth_Resp_to_MCU - can.VCU_TO_MCU_AUTH_STAT_CANID_VCU_AUTH_RESP_TO_MCU_OFFSET);
        data[0] = (byte) ((messages.VCU_Auth_Resp_to_MCU & (can.SIGNLE_READ_Mask1)));
        return can.VCU_TO_MCU_AUTH_STAT_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Data2(ConverterInitialize.MCU_Data2_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Rotor_Angle = (short) ((((data[1] & (can.SIGNLE_READ_Mask1)) << can.MCU_DATA2_ROTOR_ANGLE_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.MCU_DATA2_CANID_ROTOR_ANGLE_OFFSET));
        messages.MCU_Riding_Mode = (byte) ((((data[1] >> can.MCU_DATA2_MCU_RIDING_MODE_MASK0) & (can.SIGNLE_READ_Mask4))) + (byte) (can.MCU_DATA2_CANID_MCU_RIDING_MODE_OFFSET));
        messages.MCU_DC_voltage = (short) ((((data[3] & (can.SIGNLE_READ_Mask5)) << can.MCU_DATA2_MCU_DC_VOLTAGE_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA2_MCU_DC_VOLTAGE_MASK1) | ((data[1] >> can.MCU_DATA2_MCU_DC_VOLTAGE_MASK2) & (can.SIGNLE_READ_Mask3))) + (short) (can.MCU_DATA2_CANID_MCU_DC_VOLTAGE_OFFSET));
        messages.Cruise_Control_Status = (byte) ((((data[3] >> can.MCU_DATA2_CRUISE_CONTROL_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_DATA2_CANID_CRUISE_CONTROL_STATUS_OFFSET));
        messages.Hill_Hold_Status = (byte) ((((data[3] >> can.MCU_DATA2_HILL_HOLD_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_DATA2_CANID_HILL_HOLD_STATUS_OFFSET));

        return can.MCU_DATA2_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Data2(ConverterInitialize.MCU_Data2_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Rotor_Angle = (short) (messages.Rotor_Angle - can.MCU_DATA2_CANID_ROTOR_ANGLE_OFFSET);
        messages.MCU_Riding_Mode = (byte) (messages.MCU_Riding_Mode - can.MCU_DATA2_CANID_MCU_RIDING_MODE_OFFSET);
        messages.MCU_DC_voltage = (short) (messages.MCU_DC_voltage - can.MCU_DATA2_CANID_MCU_DC_VOLTAGE_OFFSET);
        messages.Cruise_Control_Status = (byte) (messages.Cruise_Control_Status - can.MCU_DATA2_CANID_CRUISE_CONTROL_STATUS_OFFSET);
        messages.Hill_Hold_Status = (byte) (messages.Hill_Hold_Status - can.MCU_DATA2_CANID_HILL_HOLD_STATUS_OFFSET);
        data[0] = (byte) ((messages.Rotor_Angle & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Rotor_Angle >> can.MCU_DATA2_ROTOR_ANGLE_MASK0) & (can.SIGNLE_READ_Mask1)) | ((messages.MCU_Riding_Mode & (can.SIGNLE_READ_Mask4)) << can.MCU_DATA2_MCU_RIDING_MODE_MASK0) | ((messages.MCU_DC_voltage & (can.SIGNLE_READ_Mask3)) << can.MCU_DATA2_MCU_DC_VOLTAGE_MASK2));
        data[2] = (byte) (((messages.MCU_DC_voltage >> can.MCU_DATA2_MCU_DC_VOLTAGE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.MCU_DC_voltage >> can.MCU_DATA2_MCU_DC_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask5)) | ((messages.Cruise_Control_Status & (can.SIGNLE_READ_Mask1)) << can.MCU_DATA2_CRUISE_CONTROL_STATUS_MASK0) | ((messages.Hill_Hold_Status & (can.SIGNLE_READ_Mask1)) << can.MCU_DATA2_HILL_HOLD_STATUS_MASK0));
        return can.MCU_DATA2_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_PARAMETER_1(ConverterInitialize.BMS_PARAMETER_1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Contactor_State = (byte) (((data[0] & (can.SIGNLE_READ_Mask4))) + (byte) (can.BMS_PARAMETER_1_CANID_CONTACTOR_STATE_OFFSET));
        messages.Battery_Pack_Bus_Volt = (short) ((((data[2] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_1_BATTERY_PACK_BUS_VOLT_MASK0) | (data[1] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_PARAMETER_1_CANID_BATTERY_PACK_BUS_VOLT_OFFSET));
        messages.BMS_Board_Temp = (short) ((((data[4] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_1_BMS_BOARD_TEMP_MASK0) | (data[3] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_PARAMETER_1_CANID_BMS_BOARD_TEMP_OFFSET));
        messages.BMS_Mode = (byte) (((data[5] & (can.SIGNLE_READ_Mask4))) + (byte) (can.BMS_PARAMETER_1_CANID_BMS_MODE_OFFSET));
        messages.Battery_Precharge_Failure_Status = (byte) (((data[6] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_PARAMETER_1_CANID_BATTERY_PRECHARGE_FAILURE_STATUS_OFFSET));
        messages.Battery_Charge_Inhibit = (byte) ((((data[6] >> can.BMS_PARAMETER_1_BATTERY_CHARGE_INHIBIT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_PARAMETER_1_CANID_BATTERY_CHARGE_INHIBIT_OFFSET));
        messages.Battery_Discharge_Inhibit = (byte) ((((data[6] >> can.BMS_PARAMETER_1_BATTERY_DISCHARGE_INHIBIT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_PARAMETER_1_CANID_BATTERY_DISCHARGE_INHIBIT_OFFSET));
        messages.Battery_Derate_Drive_Curr_Flag = (byte) ((((data[6] >> can.BMS_PARAMETER_1_BATTERY_DERATE_DRIVE_CURR_FLAG_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_PARAMETER_1_CANID_BATTERY_DERATE_DRIVE_CURR_FLAG_OFFSET));
        messages.Battery_Derate_Charge_Curr_Flag = (byte) ((((data[6] >> can.BMS_PARAMETER_1_BATTERY_DERATE_CHARGE_CURR_FLAG_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_PARAMETER_1_CANID_BATTERY_DERATE_CHARGE_CURR_FLAG_OFFSET));
        messages.Battery_Inhibit_Regen_Fault = (byte) ((((data[6] >> can.BMS_PARAMETER_1_BATTERY_INHIBIT_REGEN_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_PARAMETER_1_CANID_BATTERY_INHIBIT_REGEN_FAULT_OFFSET));
        messages.Battery_Permanant_Fault = (byte) ((((data[6] >> can.BMS_PARAMETER_1_BATTERY_PERMANANT_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_PARAMETER_1_CANID_BATTERY_PERMANANT_FAULT_OFFSET));
        messages.BMS_Short_Cir_Detection_Error = (byte) ((((data[6] >> can.BMS_PARAMETER_1_BMS_SHORT_CIR_DETECTION_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_PARAMETER_1_CANID_BMS_SHORT_CIR_DETECTION_ERROR_OFFSET));
        messages.Reserved = (byte) (((data[7] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_PARAMETER_1_CANID_RESERVED_OFFSET));

        return can.BMS_PARAMETER_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_PARAMETER_1(ConverterInitialize.BMS_PARAMETER_1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Contactor_State = (byte) (messages.Contactor_State - can.BMS_PARAMETER_1_CANID_CONTACTOR_STATE_OFFSET);
        messages.Battery_Pack_Bus_Volt = (short) (messages.Battery_Pack_Bus_Volt - can.BMS_PARAMETER_1_CANID_BATTERY_PACK_BUS_VOLT_OFFSET);
        messages.BMS_Board_Temp = (short) (messages.BMS_Board_Temp - can.BMS_PARAMETER_1_CANID_BMS_BOARD_TEMP_OFFSET);
        messages.BMS_Mode = (byte) (messages.BMS_Mode - can.BMS_PARAMETER_1_CANID_BMS_MODE_OFFSET);
        messages.Battery_Precharge_Failure_Status = (byte) (messages.Battery_Precharge_Failure_Status - can.BMS_PARAMETER_1_CANID_BATTERY_PRECHARGE_FAILURE_STATUS_OFFSET);
        messages.Battery_Charge_Inhibit = (byte) (messages.Battery_Charge_Inhibit - can.BMS_PARAMETER_1_CANID_BATTERY_CHARGE_INHIBIT_OFFSET);
        messages.Battery_Discharge_Inhibit = (byte) (messages.Battery_Discharge_Inhibit - can.BMS_PARAMETER_1_CANID_BATTERY_DISCHARGE_INHIBIT_OFFSET);
        messages.Battery_Derate_Drive_Curr_Flag = (byte) (messages.Battery_Derate_Drive_Curr_Flag - can.BMS_PARAMETER_1_CANID_BATTERY_DERATE_DRIVE_CURR_FLAG_OFFSET);
        messages.Battery_Derate_Charge_Curr_Flag = (byte) (messages.Battery_Derate_Charge_Curr_Flag - can.BMS_PARAMETER_1_CANID_BATTERY_DERATE_CHARGE_CURR_FLAG_OFFSET);
        messages.Battery_Inhibit_Regen_Fault = (byte) (messages.Battery_Inhibit_Regen_Fault - can.BMS_PARAMETER_1_CANID_BATTERY_INHIBIT_REGEN_FAULT_OFFSET);
        messages.Battery_Permanant_Fault = (byte) (messages.Battery_Permanant_Fault - can.BMS_PARAMETER_1_CANID_BATTERY_PERMANANT_FAULT_OFFSET);
        messages.BMS_Short_Cir_Detection_Error = (byte) (messages.BMS_Short_Cir_Detection_Error - can.BMS_PARAMETER_1_CANID_BMS_SHORT_CIR_DETECTION_ERROR_OFFSET);
        messages.Reserved = (byte) (messages.Reserved - can.BMS_PARAMETER_1_CANID_RESERVED_OFFSET);
        data[0] = (byte) ((messages.Contactor_State & (can.SIGNLE_READ_Mask4)));
        data[1] = (byte) ((messages.Battery_Pack_Bus_Volt & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.Battery_Pack_Bus_Volt >> can.BMS_PARAMETER_1_BATTERY_PACK_BUS_VOLT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) ((messages.BMS_Board_Temp & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.BMS_Board_Temp >> can.BMS_PARAMETER_1_BMS_BOARD_TEMP_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) ((messages.BMS_Mode & (can.SIGNLE_READ_Mask4)));
        data[6] = (byte) ((messages.Battery_Precharge_Failure_Status & (can.SIGNLE_READ_Mask1)) | ((messages.Battery_Charge_Inhibit & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_1_BATTERY_CHARGE_INHIBIT_MASK0) | ((messages.Battery_Discharge_Inhibit & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_1_BATTERY_DISCHARGE_INHIBIT_MASK0) | ((messages.Battery_Derate_Drive_Curr_Flag & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_1_BATTERY_DERATE_DRIVE_CURR_FLAG_MASK0) | ((messages.Battery_Derate_Charge_Curr_Flag & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_1_BATTERY_DERATE_CHARGE_CURR_FLAG_MASK0) | ((messages.Battery_Inhibit_Regen_Fault & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_1_BATTERY_INHIBIT_REGEN_FAULT_MASK0) | ((messages.Battery_Permanant_Fault & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_1_BATTERY_PERMANANT_FAULT_MASK0) | ((messages.BMS_Short_Cir_Detection_Error & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_1_BMS_SHORT_CIR_DETECTION_ERROR_MASK0));
        data[7] = (byte) ((messages.Reserved & (can.SIGNLE_READ_Mask1)));
        return can.BMS_PARAMETER_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BATTERY_LIMITS(ConverterInitialize.BATTERY_LIMITS_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charge_Current_Limit = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_LIMITS_CHARGE_CURRENT_LIMIT_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.BATTERY_LIMITS_CANID_CHARGE_CURRENT_LIMIT_OFFSET));
        messages.Discharge_Current_Limit = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_LIMITS_DISCHARGE_CURRENT_LIMIT_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.BATTERY_LIMITS_CANID_DISCHARGE_CURRENT_LIMIT_OFFSET));

        return can.BATTERY_LIMITS_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BATTERY_LIMITS(ConverterInitialize.BATTERY_LIMITS_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charge_Current_Limit = (short) (messages.Charge_Current_Limit - can.BATTERY_LIMITS_CANID_CHARGE_CURRENT_LIMIT_OFFSET);
        messages.Discharge_Current_Limit = (short) (messages.Discharge_Current_Limit - can.BATTERY_LIMITS_CANID_DISCHARGE_CURRENT_LIMIT_OFFSET);
        data[0] = (byte) ((messages.Charge_Current_Limit & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Charge_Current_Limit >> can.BATTERY_LIMITS_CHARGE_CURRENT_LIMIT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Discharge_Current_Limit & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Discharge_Current_Limit >> can.BATTERY_LIMITS_DISCHARGE_CURRENT_LIMIT_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BATTERY_LIMITS_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_PARAMETER_LIMIT_2(ConverterInitialize.BMS_PARAMETER_LIMIT_2_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Regen_Current_Limit = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_LIMIT_2_REGEN_CURRENT_LIMIT_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_PARAMETER_LIMIT_2_CANID_REGEN_CURRENT_LIMIT_OFFSET));
        messages.Reserved = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_LIMIT_2_RESERVED_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_PARAMETER_LIMIT_2_CANID_RESERVED_OFFSET));
        messages.Cell_Aggregate_Voltage = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_LIMIT_2_CELL_AGGREGATE_VOLTAGE_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_PARAMETER_LIMIT_2_CANID_CELL_AGGREGATE_VOLTAGE_OFFSET));

        return can.BMS_PARAMETER_LIMIT_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_PARAMETER_LIMIT_2(ConverterInitialize.BMS_PARAMETER_LIMIT_2_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Regen_Current_Limit = (short) (messages.Regen_Current_Limit - can.BMS_PARAMETER_LIMIT_2_CANID_REGEN_CURRENT_LIMIT_OFFSET);
        messages.Reserved = (short) (messages.Reserved - can.BMS_PARAMETER_LIMIT_2_CANID_RESERVED_OFFSET);
        messages.Cell_Aggregate_Voltage = (short) (messages.Cell_Aggregate_Voltage - can.BMS_PARAMETER_LIMIT_2_CANID_CELL_AGGREGATE_VOLTAGE_OFFSET);
        data[0] = (byte) ((messages.Regen_Current_Limit & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Regen_Current_Limit >> can.BMS_PARAMETER_LIMIT_2_REGEN_CURRENT_LIMIT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Reserved & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Reserved >> can.BMS_PARAMETER_LIMIT_2_RESERVED_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Cell_Aggregate_Voltage & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Cell_Aggregate_Voltage >> can.BMS_PARAMETER_LIMIT_2_CELL_AGGREGATE_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_PARAMETER_LIMIT_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Vehicle_Mode(ConverterInitialize.Vehicle_Mode_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Vehicle_Mode_Lvl_1 = (byte) (((data[0] & (can.SIGNLE_READ_Mask4))) + (byte) (can.VEHICLE_MODE_CANID_VEHICLE_MODE_LVL_1_OFFSET));
        messages.Vehcile_Mode_Lvl_2 = (byte) (((data[1] & (can.SIGNLE_READ_Mask6))) + (byte) (can.VEHICLE_MODE_CANID_VEHCILE_MODE_LVL_2_OFFSET));
        messages.Vehicle_Mode_Lvl_3 = (byte) (((data[2] & (can.SIGNLE_READ_Mask5))) + (byte) (can.VEHICLE_MODE_CANID_VEHICLE_MODE_LVL_3_OFFSET));
        messages.Reserved = (byte) (((data[3] & (can.SIGNLE_READ_Mask3))) + (byte) (can.VEHICLE_MODE_CANID_RESERVED_OFFSET));
        messages.Reserved2 = (byte) ((((data[3] >> can.VEHICLE_MODE_RESERVED2_MASK0) & (can.SIGNLE_READ_Mask2))) + (byte) (can.VEHICLE_MODE_CANID_RESERVED2_OFFSET));
        messages.Odometer = (int) ((((data[6] & (can.SIGNLE_READ_Mask8)) << can.VEHICLE_MODE_ODOMETER_MASK0) | ((data[5] & (can.SIGNLE_READ_Mask8)) << can.VEHICLE_MODE_ODOMETER_MASK1) | (data[4] & (can.SIGNLE_READ_Mask8))) + (int) (can.VEHICLE_MODE_CANID_ODOMETER_OFFSET));
        messages.HMI_StatusBar_Stt = (byte) (((data[7] & (can.SIGNLE_READ_Mask4))) + (byte) (can.VEHICLE_MODE_CANID_HMI_STATUSBAR_STT_OFFSET));

        return can.VEHICLE_MODE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Vehicle_Mode(ConverterInitialize.Vehicle_Mode_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Vehicle_Mode_Lvl_1 = (byte) (messages.Vehicle_Mode_Lvl_1 - can.VEHICLE_MODE_CANID_VEHICLE_MODE_LVL_1_OFFSET);
        messages.Vehcile_Mode_Lvl_2 = (byte) (messages.Vehcile_Mode_Lvl_2 - can.VEHICLE_MODE_CANID_VEHCILE_MODE_LVL_2_OFFSET);
        messages.Vehicle_Mode_Lvl_3 = (byte) (messages.Vehicle_Mode_Lvl_3 - can.VEHICLE_MODE_CANID_VEHICLE_MODE_LVL_3_OFFSET);
        messages.Reserved = (byte) (messages.Reserved - can.VEHICLE_MODE_CANID_RESERVED_OFFSET);
        messages.Reserved2 = (byte) (messages.Reserved2 - can.VEHICLE_MODE_CANID_RESERVED2_OFFSET);
        messages.Odometer = (int) (messages.Odometer - can.VEHICLE_MODE_CANID_ODOMETER_OFFSET);
        messages.HMI_StatusBar_Stt = (byte) (messages.HMI_StatusBar_Stt - can.VEHICLE_MODE_CANID_HMI_STATUSBAR_STT_OFFSET);
        data[0] = (byte) ((messages.Vehicle_Mode_Lvl_1 & (can.SIGNLE_READ_Mask4)));
        data[1] = (byte) ((messages.Vehcile_Mode_Lvl_2 & (can.SIGNLE_READ_Mask6)));
        data[2] = (byte) ((messages.Vehicle_Mode_Lvl_3 & (can.SIGNLE_READ_Mask5)));
        data[3] = (byte) ((messages.Reserved & (can.SIGNLE_READ_Mask3)) | ((messages.Reserved2 & (can.SIGNLE_READ_Mask2)) << can.VEHICLE_MODE_RESERVED2_MASK0));
        data[4] = (byte) ((messages.Odometer & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Odometer >> can.VEHICLE_MODE_ODOMETER_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.Odometer >> can.VEHICLE_MODE_ODOMETER_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) ((messages.HMI_StatusBar_Stt & (can.SIGNLE_READ_Mask4)));
        return can.VEHICLE_MODE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Traction_Control(ConverterInitialize.Traction_Control_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Traction_Status = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.TRACTION_CONTROL_CANID_TRACTION_STATUS_OFFSET));
        messages.Lean_angle_right = (byte) ((((data[1] & (can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL_LEAN_ANGLE_RIGHT_MASK0) | ((data[0] >> can.TRACTION_CONTROL_LEAN_ANGLE_RIGHT_MASK1) & (can.SIGNLE_READ_Mask7))) + (byte) (can.TRACTION_CONTROL_CANID_LEAN_ANGLE_RIGHT_OFFSET));
        messages.Lean_angle_left = (byte) ((((data[2] & (can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL_LEAN_ANGLE_LEFT_MASK0) | ((data[1] >> can.TRACTION_CONTROL_LEAN_ANGLE_LEFT_MASK1) & (can.SIGNLE_READ_Mask7))) + (byte) (can.TRACTION_CONTROL_CANID_LEAN_ANGLE_LEFT_OFFSET));
        messages.Throtte_1_Value = (short) ((((data[4] & (can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL_THROTTE_1_VALUE_MASK0) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.TRACTION_CONTROL_THROTTE_1_VALUE_MASK1) | ((data[2] >> can.TRACTION_CONTROL_THROTTE_1_VALUE_MASK2) & (can.SIGNLE_READ_Mask7))) + (short) (can.TRACTION_CONTROL_CANID_THROTTE_1_VALUE_OFFSET));
        messages.Throttle_2_Value = (short) ((((data[6] & (can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL_THROTTLE_2_VALUE_MASK0) | ((data[5] & (can.SIGNLE_READ_Mask8)) << can.TRACTION_CONTROL_THROTTLE_2_VALUE_MASK1) | ((data[4] >> can.TRACTION_CONTROL_THROTTLE_2_VALUE_MASK2) & (can.SIGNLE_READ_Mask7))) + (short) (can.TRACTION_CONTROL_CANID_THROTTLE_2_VALUE_OFFSET));
        messages.Motor_Cut = (byte) ((((data[7] >> can.TRACTION_CONTROL_MOTOR_CUT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.TRACTION_CONTROL_CANID_MOTOR_CUT_OFFSET));

        return can.TRACTION_CONTROL_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Traction_Control(ConverterInitialize.Traction_Control_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Traction_Status = (byte) (messages.Traction_Status - can.TRACTION_CONTROL_CANID_TRACTION_STATUS_OFFSET);
        messages.Lean_angle_right = (byte) (messages.Lean_angle_right - can.TRACTION_CONTROL_CANID_LEAN_ANGLE_RIGHT_OFFSET);
        messages.Lean_angle_left = (byte) (messages.Lean_angle_left - can.TRACTION_CONTROL_CANID_LEAN_ANGLE_LEFT_OFFSET);
        messages.Throtte_1_Value = (short) (messages.Throtte_1_Value - can.TRACTION_CONTROL_CANID_THROTTE_1_VALUE_OFFSET);
        messages.Throttle_2_Value = (short) (messages.Throttle_2_Value - can.TRACTION_CONTROL_CANID_THROTTLE_2_VALUE_OFFSET);
        messages.Motor_Cut = (byte) (messages.Motor_Cut - can.TRACTION_CONTROL_CANID_MOTOR_CUT_OFFSET);
        data[0] = (byte) ((messages.Traction_Status & (can.SIGNLE_READ_Mask1)) | ((messages.Lean_angle_right & (can.SIGNLE_READ_Mask7)) << can.TRACTION_CONTROL_LEAN_ANGLE_RIGHT_MASK1));
        data[1] = (byte) (((messages.Lean_angle_right >> can.TRACTION_CONTROL_LEAN_ANGLE_RIGHT_MASK0) & (can.SIGNLE_READ_Mask1)) | ((messages.Lean_angle_left & (can.SIGNLE_READ_Mask7)) << can.TRACTION_CONTROL_LEAN_ANGLE_LEFT_MASK1));
        data[2] = (byte) (((messages.Lean_angle_left >> can.TRACTION_CONTROL_LEAN_ANGLE_LEFT_MASK0) & (can.SIGNLE_READ_Mask1)) | ((messages.Throtte_1_Value & (can.SIGNLE_READ_Mask7)) << can.TRACTION_CONTROL_THROTTE_1_VALUE_MASK2));
        data[3] = (byte) (((messages.Throtte_1_Value >> can.TRACTION_CONTROL_THROTTE_1_VALUE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.Throtte_1_Value >> can.TRACTION_CONTROL_THROTTE_1_VALUE_MASK0) & (can.SIGNLE_READ_Mask1)) | ((messages.Throttle_2_Value & (can.SIGNLE_READ_Mask7)) << can.TRACTION_CONTROL_THROTTLE_2_VALUE_MASK2));
        data[5] = (byte) (((messages.Throttle_2_Value >> can.TRACTION_CONTROL_THROTTLE_2_VALUE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.Throttle_2_Value >> can.TRACTION_CONTROL_THROTTLE_2_VALUE_MASK0) & (can.SIGNLE_READ_Mask1)));
        data[7] = (byte) (((messages.Motor_Cut & (can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL_MOTOR_CUT_MASK0));
        return can.TRACTION_CONTROL_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_SOM_Parameters_1(ConverterInitialize.SOM_Parameters_1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.SOM_HeartBeat_Failure = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.SOM_PARAMETERS_1_CANID_SOM_HEARTBEAT_FAILURE_OFFSET));
        messages.SOM_Status = (byte) ((((data[0] >> can.SOM_PARAMETERS_1_SOM_STATUS_MASK0) & (can.SIGNLE_READ_Mask4))) + (byte) (can.SOM_PARAMETERS_1_CANID_SOM_STATUS_OFFSET));
        messages.Passcode_Authentication = (byte) ((((data[0] >> can.SOM_PARAMETERS_1_PASSCODE_AUTHENTICATION_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.SOM_PARAMETERS_1_CANID_PASSCODE_AUTHENTICATION_OFFSET));

        return can.SOM_PARAMETERS_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_SOM_Parameters_1(ConverterInitialize.SOM_Parameters_1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.SOM_HeartBeat_Failure = (byte) (messages.SOM_HeartBeat_Failure - can.SOM_PARAMETERS_1_CANID_SOM_HEARTBEAT_FAILURE_OFFSET);
        messages.SOM_Status = (byte) (messages.SOM_Status - can.SOM_PARAMETERS_1_CANID_SOM_STATUS_OFFSET);
        messages.Passcode_Authentication = (byte) (messages.Passcode_Authentication - can.SOM_PARAMETERS_1_CANID_PASSCODE_AUTHENTICATION_OFFSET);
        data[0] = (byte) ((messages.SOM_HeartBeat_Failure & (can.SIGNLE_READ_Mask1)) | ((messages.SOM_Status & (can.SIGNLE_READ_Mask4)) << can.SOM_PARAMETERS_1_SOM_STATUS_MASK0) | ((messages.Passcode_Authentication & (can.SIGNLE_READ_Mask1)) << can.SOM_PARAMETERS_1_PASSCODE_AUTHENTICATION_MASK0));
        return can.SOM_PARAMETERS_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ABS_Parameters(ConverterInitialize.ABS_Parameters_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_FrontBrake_Status = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.ABS_PARAMETERS_CANID_ABS_FRONTBRAKE_STATUS_OFFSET));
        messages.ABS_RearBrake_Status = (byte) ((((data[0] >> can.ABS_PARAMETERS_ABS_REARBRAKE_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ABS_PARAMETERS_CANID_ABS_REARBRAKE_STATUS_OFFSET));
        messages.ABS_State = (byte) ((((data[0] >> can.ABS_PARAMETERS_ABS_STATE_MASK0) & (can.SIGNLE_READ_Mask4))) + (byte) (can.ABS_PARAMETERS_CANID_ABS_STATE_OFFSET));
        messages.ABS_Faulty = (byte) ((((data[0] >> can.ABS_PARAMETERS_ABS_FAULTY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ABS_PARAMETERS_CANID_ABS_FAULTY_OFFSET));

        return can.ABS_PARAMETERS_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ABS_Parameters(ConverterInitialize.ABS_Parameters_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_FrontBrake_Status = (byte) (messages.ABS_FrontBrake_Status - can.ABS_PARAMETERS_CANID_ABS_FRONTBRAKE_STATUS_OFFSET);
        messages.ABS_RearBrake_Status = (byte) (messages.ABS_RearBrake_Status - can.ABS_PARAMETERS_CANID_ABS_REARBRAKE_STATUS_OFFSET);
        messages.ABS_State = (byte) (messages.ABS_State - can.ABS_PARAMETERS_CANID_ABS_STATE_OFFSET);
        messages.ABS_Faulty = (byte) (messages.ABS_Faulty - can.ABS_PARAMETERS_CANID_ABS_FAULTY_OFFSET);
        data[0] = (byte) ((messages.ABS_FrontBrake_Status & (can.SIGNLE_READ_Mask1)) | ((messages.ABS_RearBrake_Status & (can.SIGNLE_READ_Mask1)) << can.ABS_PARAMETERS_ABS_REARBRAKE_STATUS_MASK0) | ((messages.ABS_State & (can.SIGNLE_READ_Mask4)) << can.ABS_PARAMETERS_ABS_STATE_MASK0) | ((messages.ABS_Faulty & (can.SIGNLE_READ_Mask1)) << can.ABS_PARAMETERS_ABS_FAULTY_MASK0));
        return can.ABS_PARAMETERS_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Traction_Control2(ConverterInitialize.Traction_Control2_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Throttle_1_per = (byte) (((data[0] & (can.SIGNLE_READ_Mask8))) + (byte) (can.TRACTION_CONTROL2_CANID_THROTTLE_1_PER_OFFSET));
        messages.Throttle_2_per = (byte) (((data[1] & (can.SIGNLE_READ_Mask8))) + (byte) (can.TRACTION_CONTROL2_CANID_THROTTLE_2_PER_OFFSET));
        messages.Throttle_Percentage = (byte) (((data[2] & (can.SIGNLE_READ_Mask8))) + (byte) (can.TRACTION_CONTROL2_CANID_THROTTLE_PERCENTAGE_OFFSET));
        messages.Thottle_1_flt = (byte) (((data[3] & (can.SIGNLE_READ_Mask2))) + (byte) (can.TRACTION_CONTROL2_CANID_THOTTLE_1_FLT_OFFSET));
        messages.Throttle_2_flt = (byte) ((((data[3] >> can.TRACTION_CONTROL2_THROTTLE_2_FLT_MASK0) & (can.SIGNLE_READ_Mask2))) + (byte) (can.TRACTION_CONTROL2_CANID_THROTTLE_2_FLT_OFFSET));
        messages.Throttle_Dev_flt = (byte) ((((data[3] >> can.TRACTION_CONTROL2_THROTTLE_DEV_FLT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.TRACTION_CONTROL2_CANID_THROTTLE_DEV_FLT_OFFSET));
        messages.Front_Brake_Status = (byte) ((((data[3] >> can.TRACTION_CONTROL2_FRONT_BRAKE_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.TRACTION_CONTROL2_CANID_FRONT_BRAKE_STATUS_OFFSET));
        messages.Rear_Brake_Status = (byte) ((((data[3] >> can.TRACTION_CONTROL2_REAR_BRAKE_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.TRACTION_CONTROL2_CANID_REAR_BRAKE_STATUS_OFFSET));
        messages.Regeneration_Command = (byte) ((((data[4] & (can.SIGNLE_READ_Mask2)) << can.TRACTION_CONTROL2_REGENERATION_COMMAND_MASK0) | ((data[3] >> can.TRACTION_CONTROL2_REGENERATION_COMMAND_MASK1) & (can.SIGNLE_READ_Mask1))) + (byte) (can.TRACTION_CONTROL2_CANID_REGENERATION_COMMAND_OFFSET));

        return can.TRACTION_CONTROL2_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Traction_Control2(ConverterInitialize.Traction_Control2_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Throttle_1_per = (byte) (messages.Throttle_1_per - can.TRACTION_CONTROL2_CANID_THROTTLE_1_PER_OFFSET);
        messages.Throttle_2_per = (byte) (messages.Throttle_2_per - can.TRACTION_CONTROL2_CANID_THROTTLE_2_PER_OFFSET);
        messages.Throttle_Percentage = (byte) (messages.Throttle_Percentage - can.TRACTION_CONTROL2_CANID_THROTTLE_PERCENTAGE_OFFSET);
        messages.Thottle_1_flt = (byte) (messages.Thottle_1_flt - can.TRACTION_CONTROL2_CANID_THOTTLE_1_FLT_OFFSET);
        messages.Throttle_2_flt = (byte) (messages.Throttle_2_flt - can.TRACTION_CONTROL2_CANID_THROTTLE_2_FLT_OFFSET);
        messages.Throttle_Dev_flt = (byte) (messages.Throttle_Dev_flt - can.TRACTION_CONTROL2_CANID_THROTTLE_DEV_FLT_OFFSET);
        messages.Front_Brake_Status = (byte) (messages.Front_Brake_Status - can.TRACTION_CONTROL2_CANID_FRONT_BRAKE_STATUS_OFFSET);
        messages.Rear_Brake_Status = (byte) (messages.Rear_Brake_Status - can.TRACTION_CONTROL2_CANID_REAR_BRAKE_STATUS_OFFSET);
        messages.Regeneration_Command = (byte) (messages.Regeneration_Command - can.TRACTION_CONTROL2_CANID_REGENERATION_COMMAND_OFFSET);
        data[0] = (byte) ((messages.Throttle_1_per & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) ((messages.Throttle_2_per & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Throttle_Percentage & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) ((messages.Thottle_1_flt & (can.SIGNLE_READ_Mask2)) | ((messages.Throttle_2_flt & (can.SIGNLE_READ_Mask2)) << can.TRACTION_CONTROL2_THROTTLE_2_FLT_MASK0) | ((messages.Throttle_Dev_flt & (can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL2_THROTTLE_DEV_FLT_MASK0) | ((messages.Front_Brake_Status & (can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL2_FRONT_BRAKE_STATUS_MASK0) | ((messages.Rear_Brake_Status & (can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL2_REAR_BRAKE_STATUS_MASK0) | ((messages.Regeneration_Command & (can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL2_REGENERATION_COMMAND_MASK1));
        data[4] = (byte) (((messages.Regeneration_Command >> can.TRACTION_CONTROL2_REGENERATION_COMMAND_MASK0) & (can.SIGNLE_READ_Mask2)));
        return can.TRACTION_CONTROL2_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Vehicle_Func(ConverterInitialize.Vehicle_Func_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cruise_Control_Req = (byte) ((((data[0] >> can.VEHICLE_FUNC_CRUISE_CONTROL_REQ_MASK0) & (can.SIGNLE_READ_Mask3))) + (byte) (can.VEHICLE_FUNC_CANID_CRUISE_CONTROL_REQ_OFFSET));
        messages.Hill_Hold_Command = (byte) ((((data[0] >> can.VEHICLE_FUNC_HILL_HOLD_COMMAND_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_FUNC_CANID_HILL_HOLD_COMMAND_OFFSET));
        messages.Cruise_Set_Speed = (short) ((((data[2] & (can.SIGNLE_READ_Mask5)) << can.VEHICLE_FUNC_CRUISE_SET_SPEED_MASK0) | ((data[1] >> can.VEHICLE_FUNC_CRUISE_SET_SPEED_MASK1) & (can.SIGNLE_READ_Mask6))) + (short) (can.VEHICLE_FUNC_CANID_CRUISE_SET_SPEED_OFFSET));
        messages.Vehicle_speed_kmph = (short) ((((data[4] & (can.SIGNLE_READ_Mask8)) << can.VEHICLE_FUNC_VEHICLE_SPEED_KMPH_MASK0) | (data[3] & (can.SIGNLE_READ_Mask8))) + (short) (can.VEHICLE_FUNC_CANID_VEHICLE_SPEED_KMPH_OFFSET));

        return can.VEHICLE_FUNC_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Vehicle_Func(ConverterInitialize.Vehicle_Func_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cruise_Control_Req = (byte) (messages.Cruise_Control_Req - can.VEHICLE_FUNC_CANID_CRUISE_CONTROL_REQ_OFFSET);
        messages.Hill_Hold_Command = (byte) (messages.Hill_Hold_Command - can.VEHICLE_FUNC_CANID_HILL_HOLD_COMMAND_OFFSET);
        messages.Cruise_Set_Speed = (short) (messages.Cruise_Set_Speed - can.VEHICLE_FUNC_CANID_CRUISE_SET_SPEED_OFFSET);
        messages.Vehicle_speed_kmph = (short) (messages.Vehicle_speed_kmph - can.VEHICLE_FUNC_CANID_VEHICLE_SPEED_KMPH_OFFSET);
        data[0] = (byte) (((messages.Cruise_Control_Req & (can.SIGNLE_READ_Mask3)) << can.VEHICLE_FUNC_CRUISE_CONTROL_REQ_MASK0) | ((messages.Hill_Hold_Command & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_FUNC_HILL_HOLD_COMMAND_MASK0));
        data[1] = (byte) (((messages.Cruise_Set_Speed & (can.SIGNLE_READ_Mask6)) << can.VEHICLE_FUNC_CRUISE_SET_SPEED_MASK1));
        data[2] = (byte) (((messages.Cruise_Set_Speed >> can.VEHICLE_FUNC_CRUISE_SET_SPEED_MASK0) & (can.SIGNLE_READ_Mask5)));
        data[3] = (byte) ((messages.Vehicle_speed_kmph & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.Vehicle_speed_kmph >> can.VEHICLE_FUNC_VEHICLE_SPEED_KMPH_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.VEHICLE_FUNC_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_PARAMETER_3(ConverterInitialize.BMS_PARAMETER_3_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Balancing_Status = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_PARAMETER_3_CANID_BALANCING_STATUS_OFFSET));
        messages.Effective_Battery_Temperature = (byte) ((((data[1] & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_3_EFFECTIVE_BATTERY_TEMPERATURE_MASK0) | ((data[0] >> can.BMS_PARAMETER_3_EFFECTIVE_BATTERY_TEMPERATURE_MASK1) & (can.SIGNLE_READ_Mask7))) + (byte) (can.BMS_PARAMETER_3_CANID_EFFECTIVE_BATTERY_TEMPERATURE_OFFSET));
        messages.Delta_Temp = (byte) ((((data[2] & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_3_DELTA_TEMP_MASK0) | ((data[1] >> can.BMS_PARAMETER_3_DELTA_TEMP_MASK1) & (can.SIGNLE_READ_Mask7))) + (byte) (can.BMS_PARAMETER_3_CANID_DELTA_TEMP_OFFSET));
        messages.Delta_Voltage = (short) ((((data[4] & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_3_DELTA_VOLTAGE_MASK0) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_3_DELTA_VOLTAGE_MASK1) | ((data[2] >> can.BMS_PARAMETER_3_DELTA_VOLTAGE_MASK2) & (can.SIGNLE_READ_Mask7))) + (short) (can.BMS_PARAMETER_3_CANID_DELTA_VOLTAGE_OFFSET));
        messages.HVIL_OBC_Req = (byte) ((((data[4] >> can.BMS_PARAMETER_3_HVIL_OBC_REQ_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_PARAMETER_3_CANID_HVIL_OBC_REQ_OFFSET));
        messages.HVIL_MCU_Req = (byte) ((((data[4] >> can.BMS_PARAMETER_3_HVIL_MCU_REQ_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_PARAMETER_3_CANID_HVIL_MCU_REQ_OFFSET));
        messages.HVIL_OBC_Status = (byte) ((((data[4] >> can.BMS_PARAMETER_3_HVIL_OBC_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_PARAMETER_3_CANID_HVIL_OBC_STATUS_OFFSET));
        messages.HVIL_MCU_Status = (byte) ((((data[4] >> can.BMS_PARAMETER_3_HVIL_MCU_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_PARAMETER_3_CANID_HVIL_MCU_STATUS_OFFSET));
        messages.Isolation_Resistance = (short) ((((data[6] & (can.SIGNLE_READ_Mask6)) << can.BMS_PARAMETER_3_ISOLATION_RESISTANCE_MASK0) | ((data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_3_ISOLATION_RESISTANCE_MASK1) | ((data[4] >> can.BMS_PARAMETER_3_ISOLATION_RESISTANCE_MASK2) & (can.SIGNLE_READ_Mask2))) + (short) (can.BMS_PARAMETER_3_CANID_ISOLATION_RESISTANCE_OFFSET));

        return can.BMS_PARAMETER_3_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_PARAMETER_3(ConverterInitialize.BMS_PARAMETER_3_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Balancing_Status = (byte) (messages.Balancing_Status - can.BMS_PARAMETER_3_CANID_BALANCING_STATUS_OFFSET);
        messages.Effective_Battery_Temperature = (byte) (messages.Effective_Battery_Temperature - can.BMS_PARAMETER_3_CANID_EFFECTIVE_BATTERY_TEMPERATURE_OFFSET);
        messages.Delta_Temp = (byte) (messages.Delta_Temp - can.BMS_PARAMETER_3_CANID_DELTA_TEMP_OFFSET);
        messages.Delta_Voltage = (short) (messages.Delta_Voltage - can.BMS_PARAMETER_3_CANID_DELTA_VOLTAGE_OFFSET);
        messages.HVIL_OBC_Req = (byte) (messages.HVIL_OBC_Req - can.BMS_PARAMETER_3_CANID_HVIL_OBC_REQ_OFFSET);
        messages.HVIL_MCU_Req = (byte) (messages.HVIL_MCU_Req - can.BMS_PARAMETER_3_CANID_HVIL_MCU_REQ_OFFSET);
        messages.HVIL_OBC_Status = (byte) (messages.HVIL_OBC_Status - can.BMS_PARAMETER_3_CANID_HVIL_OBC_STATUS_OFFSET);
        messages.HVIL_MCU_Status = (byte) (messages.HVIL_MCU_Status - can.BMS_PARAMETER_3_CANID_HVIL_MCU_STATUS_OFFSET);
        messages.Isolation_Resistance = (short) (messages.Isolation_Resistance - can.BMS_PARAMETER_3_CANID_ISOLATION_RESISTANCE_OFFSET);
        data[0] = (byte) ((messages.Balancing_Status & (can.SIGNLE_READ_Mask1)) | ((messages.Effective_Battery_Temperature & (can.SIGNLE_READ_Mask7)) << can.BMS_PARAMETER_3_EFFECTIVE_BATTERY_TEMPERATURE_MASK1));
        data[1] = (byte) (((messages.Effective_Battery_Temperature >> can.BMS_PARAMETER_3_EFFECTIVE_BATTERY_TEMPERATURE_MASK0) & (can.SIGNLE_READ_Mask1)) | ((messages.Delta_Temp & (can.SIGNLE_READ_Mask7)) << can.BMS_PARAMETER_3_DELTA_TEMP_MASK1));
        data[2] = (byte) (((messages.Delta_Temp >> can.BMS_PARAMETER_3_DELTA_TEMP_MASK0) & (can.SIGNLE_READ_Mask1)) | ((messages.Delta_Voltage & (can.SIGNLE_READ_Mask7)) << can.BMS_PARAMETER_3_DELTA_VOLTAGE_MASK2));
        data[3] = (byte) (((messages.Delta_Voltage >> can.BMS_PARAMETER_3_DELTA_VOLTAGE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.Delta_Voltage >> can.BMS_PARAMETER_3_DELTA_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask1)) | ((messages.HVIL_OBC_Req & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_3_HVIL_OBC_REQ_MASK0) | ((messages.HVIL_MCU_Req & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_3_HVIL_MCU_REQ_MASK0) | ((messages.HVIL_OBC_Status & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_3_HVIL_OBC_STATUS_MASK0) | ((messages.HVIL_MCU_Status & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_3_HVIL_MCU_STATUS_MASK0) | ((messages.Isolation_Resistance & (can.SIGNLE_READ_Mask2)) << can.BMS_PARAMETER_3_ISOLATION_RESISTANCE_MASK2));
        data[5] = (byte) (((messages.Isolation_Resistance >> can.BMS_PARAMETER_3_ISOLATION_RESISTANCE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.Isolation_Resistance >> can.BMS_PARAMETER_3_ISOLATION_RESISTANCE_MASK0) & (can.SIGNLE_READ_Mask6)));
        return can.BMS_PARAMETER_3_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_PARAMETER_4(ConverterInitialize.BMS_PARAMETER_4_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Pack_Internal_Resistance = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_4_PACK_INTERNAL_RESISTANCE_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_PARAMETER_4_CANID_PACK_INTERNAL_RESISTANCE_OFFSET));
        messages.Pack_SOH = (byte) (((data[2] & (can.SIGNLE_READ_Mask8))) + (byte) (can.BMS_PARAMETER_4_CANID_PACK_SOH_OFFSET));
        messages.Pack_SOP = (byte) (((data[3] & (can.SIGNLE_READ_Mask8))) + (byte) (can.BMS_PARAMETER_4_CANID_PACK_SOP_OFFSET));
        messages.Total_Charge_Cycles = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_4_TOTAL_CHARGE_CYCLES_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_PARAMETER_4_CANID_TOTAL_CHARGE_CYCLES_OFFSET));
        messages.Pack_DOD = (byte) (((data[6] & (can.SIGNLE_READ_Mask8))) + (byte) (can.BMS_PARAMETER_4_CANID_PACK_DOD_OFFSET));

        return can.BMS_PARAMETER_4_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_PARAMETER_4(ConverterInitialize.BMS_PARAMETER_4_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Pack_Internal_Resistance = (short) (messages.Pack_Internal_Resistance - can.BMS_PARAMETER_4_CANID_PACK_INTERNAL_RESISTANCE_OFFSET);
        messages.Pack_SOH = (byte) (messages.Pack_SOH - can.BMS_PARAMETER_4_CANID_PACK_SOH_OFFSET);
        messages.Pack_SOP = (byte) (messages.Pack_SOP - can.BMS_PARAMETER_4_CANID_PACK_SOP_OFFSET);
        messages.Total_Charge_Cycles = (short) (messages.Total_Charge_Cycles - can.BMS_PARAMETER_4_CANID_TOTAL_CHARGE_CYCLES_OFFSET);
        messages.Pack_DOD = (byte) (messages.Pack_DOD - can.BMS_PARAMETER_4_CANID_PACK_DOD_OFFSET);
        data[0] = (byte) ((messages.Pack_Internal_Resistance & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Pack_Internal_Resistance >> can.BMS_PARAMETER_4_PACK_INTERNAL_RESISTANCE_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Pack_SOH & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) ((messages.Pack_SOP & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Total_Charge_Cycles & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Total_Charge_Cycles >> can.BMS_PARAMETER_4_TOTAL_CHARGE_CYCLES_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Pack_DOD & (can.SIGNLE_READ_Mask8)));
        return can.BMS_PARAMETER_4_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Battery_Energy_Cycles(ConverterInitialize.Battery_Energy_Cycles_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cycle_Energy_In = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_ENERGY_CYCLES_CYCLE_ENERGY_IN_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.BATTERY_ENERGY_CYCLES_CANID_CYCLE_ENERGY_IN_OFFSET));
        messages.Cycle_Enegy_Out = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_ENERGY_CYCLES_CYCLE_ENEGY_OUT_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.BATTERY_ENERGY_CYCLES_CANID_CYCLE_ENEGY_OUT_OFFSET));
        messages.Total_Energy_In = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_ENERGY_CYCLES_TOTAL_ENERGY_IN_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.BATTERY_ENERGY_CYCLES_CANID_TOTAL_ENERGY_IN_OFFSET));
        messages.Total_Energy_Out = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_ENERGY_CYCLES_TOTAL_ENERGY_OUT_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.BATTERY_ENERGY_CYCLES_CANID_TOTAL_ENERGY_OUT_OFFSET));

        return can.BATTERY_ENERGY_CYCLES_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Battery_Energy_Cycles(ConverterInitialize.Battery_Energy_Cycles_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cycle_Energy_In = (short) (messages.Cycle_Energy_In - can.BATTERY_ENERGY_CYCLES_CANID_CYCLE_ENERGY_IN_OFFSET);
        messages.Cycle_Enegy_Out = (short) (messages.Cycle_Enegy_Out - can.BATTERY_ENERGY_CYCLES_CANID_CYCLE_ENEGY_OUT_OFFSET);
        messages.Total_Energy_In = (short) (messages.Total_Energy_In - can.BATTERY_ENERGY_CYCLES_CANID_TOTAL_ENERGY_IN_OFFSET);
        messages.Total_Energy_Out = (short) (messages.Total_Energy_Out - can.BATTERY_ENERGY_CYCLES_CANID_TOTAL_ENERGY_OUT_OFFSET);
        data[0] = (byte) ((messages.Cycle_Energy_In & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Cycle_Energy_In >> can.BATTERY_ENERGY_CYCLES_CYCLE_ENERGY_IN_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Cycle_Enegy_Out & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Cycle_Enegy_Out >> can.BATTERY_ENERGY_CYCLES_CYCLE_ENEGY_OUT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Total_Energy_In & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Total_Energy_In >> can.BATTERY_ENERGY_CYCLES_TOTAL_ENERGY_IN_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Total_Energy_Out & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Total_Energy_Out >> can.BATTERY_ENERGY_CYCLES_TOTAL_ENERGY_OUT_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BATTERY_ENERGY_CYCLES_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OBC_Wakeup_Info(ConverterInitialize.OBC_Wakeup_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Wakeup = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.OBC_WAKEUP_INFO_CANID_OBC_WAKEUP_OFFSET));

        return can.OBC_WAKEUP_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OBC_Wakeup_Info(ConverterInitialize.OBC_Wakeup_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Wakeup = (byte) (messages.OBC_Wakeup - can.OBC_WAKEUP_INFO_CANID_OBC_WAKEUP_OFFSET);
        data[0] = (byte) ((messages.OBC_Wakeup & (can.SIGNLE_READ_Mask1)));
        return can.OBC_WAKEUP_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BATTERY_TEMPERATURE(ConverterInitialize.BATTERY_TEMPERATURE_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Battery_Temperature_1 = (byte) (((data[0] & (can.SIGNLE_READ_Mask8))) + (byte) (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_1_OFFSET));
        messages.Battery_Temperature_2 = (byte) (((data[1] & (can.SIGNLE_READ_Mask8))) + (byte) (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_2_OFFSET));
        messages.Battery_Temperature_3 = (byte) (((data[2] & (can.SIGNLE_READ_Mask8))) + (byte) (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_3_OFFSET));
        messages.Battery_Temperature_4 = (byte) (((data[3] & (can.SIGNLE_READ_Mask8))) + (byte) (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_4_OFFSET));
        messages.Battery_Temperature_5 = (byte) (((data[4] & (can.SIGNLE_READ_Mask8))) + (byte) (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_5_OFFSET));
        messages.Battery_Temperature_6 = (byte) (((data[5] & (can.SIGNLE_READ_Mask8))) + (byte) (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_6_OFFSET));
        messages.Battery_Temperature_Min = (byte) (((data[6] & (can.SIGNLE_READ_Mask8))) + (byte) (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_MIN_OFFSET));
        messages.Battery_Temperature_Max = (byte) (((data[7] & (can.SIGNLE_READ_Mask8))) + (byte) (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_MAX_OFFSET));

        return can.BATTERY_TEMPERATURE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BATTERY_TEMPERATURE(ConverterInitialize.BATTERY_TEMPERATURE_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Battery_Temperature_1 = (byte) (messages.Battery_Temperature_1 - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_1_OFFSET);
        messages.Battery_Temperature_2 = (byte) (messages.Battery_Temperature_2 - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_2_OFFSET);
        messages.Battery_Temperature_3 = (byte) (messages.Battery_Temperature_3 - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_3_OFFSET);
        messages.Battery_Temperature_4 = (byte) (messages.Battery_Temperature_4 - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_4_OFFSET);
        messages.Battery_Temperature_5 = (byte) (messages.Battery_Temperature_5 - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_5_OFFSET);
        messages.Battery_Temperature_6 = (byte) (messages.Battery_Temperature_6 - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_6_OFFSET);
        messages.Battery_Temperature_Min = (byte) (messages.Battery_Temperature_Min - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_MIN_OFFSET);
        messages.Battery_Temperature_Max = (byte) (messages.Battery_Temperature_Max - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_MAX_OFFSET);
        data[0] = (byte) ((messages.Battery_Temperature_1 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) ((messages.Battery_Temperature_2 & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Battery_Temperature_3 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) ((messages.Battery_Temperature_4 & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Battery_Temperature_5 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) ((messages.Battery_Temperature_6 & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Battery_Temperature_Min & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) ((messages.Battery_Temperature_Max & (can.SIGNLE_READ_Mask8)));
        return can.BATTERY_TEMPERATURE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Custom_Mode(ConverterInitialize.Custom_Mode_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Custom_Drive_Enable = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.CUSTOM_MODE_CANID_CUSTOM_DRIVE_ENABLE_OFFSET));
        messages.Power = (byte) ((((data[1] & (can.SIGNLE_READ_Mask1)) << can.CUSTOM_MODE_POWER_MASK0) | ((data[0] >> can.CUSTOM_MODE_POWER_MASK1) & (can.SIGNLE_READ_Mask7))) + (byte) (can.CUSTOM_MODE_CANID_POWER_OFFSET));
        messages.Throttle_performance = (byte) ((((data[2] & (can.SIGNLE_READ_Mask1)) << can.CUSTOM_MODE_THROTTLE_PERFORMANCE_MASK0) | ((data[1] >> can.CUSTOM_MODE_THROTTLE_PERFORMANCE_MASK1) & (can.SIGNLE_READ_Mask7))) + (byte) (can.CUSTOM_MODE_CANID_THROTTLE_PERFORMANCE_OFFSET));
        messages.Regen = (byte) ((((data[3] & (can.SIGNLE_READ_Mask1)) << can.CUSTOM_MODE_REGEN_MASK0) | ((data[2] >> can.CUSTOM_MODE_REGEN_MASK1) & (can.SIGNLE_READ_Mask7))) + (byte) (can.CUSTOM_MODE_CANID_REGEN_OFFSET));

        return can.CUSTOM_MODE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Custom_Mode(ConverterInitialize.Custom_Mode_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Custom_Drive_Enable = (byte) (messages.Custom_Drive_Enable - can.CUSTOM_MODE_CANID_CUSTOM_DRIVE_ENABLE_OFFSET);
        messages.Power = (byte) (messages.Power - can.CUSTOM_MODE_CANID_POWER_OFFSET);
        messages.Throttle_performance = (byte) (messages.Throttle_performance - can.CUSTOM_MODE_CANID_THROTTLE_PERFORMANCE_OFFSET);
        messages.Regen = (byte) (messages.Regen - can.CUSTOM_MODE_CANID_REGEN_OFFSET);
        data[0] = (byte) ((messages.Custom_Drive_Enable & (can.SIGNLE_READ_Mask1)) | ((messages.Power & (can.SIGNLE_READ_Mask7)) << can.CUSTOM_MODE_POWER_MASK1));
        data[1] = (byte) (((messages.Power >> can.CUSTOM_MODE_POWER_MASK0) & (can.SIGNLE_READ_Mask1)) | ((messages.Throttle_performance & (can.SIGNLE_READ_Mask7)) << can.CUSTOM_MODE_THROTTLE_PERFORMANCE_MASK1));
        data[2] = (byte) (((messages.Throttle_performance >> can.CUSTOM_MODE_THROTTLE_PERFORMANCE_MASK0) & (can.SIGNLE_READ_Mask1)) | ((messages.Regen & (can.SIGNLE_READ_Mask7)) << can.CUSTOM_MODE_REGEN_MASK1));
        data[3] = (byte) (((messages.Regen >> can.CUSTOM_MODE_REGEN_MASK0) & (can.SIGNLE_READ_Mask1)));
        return can.CUSTOM_MODE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_VCU_Data(ConverterInitialize.VCU_Data_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charger_Plugin = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_CHARGER_PLUGIN_OFFSET));
        messages.MCU_Power_Supply = (byte) ((((data[0] >> can.VCU_DATA_MCU_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_MCU_POWER_SUPPLY_OFFSET));
        messages.HU_Power_Supply = (byte) ((((data[0] >> can.VCU_DATA_HU_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_HU_POWER_SUPPLY_OFFSET));
        messages.Left_Indicator_Power_Supply = (byte) ((((data[0] >> can.VCU_DATA_LEFT_INDICATOR_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_LEFT_INDICATOR_POWER_SUPPLY_OFFSET));
        messages.Right_Indicator_Power_Supply = (byte) ((((data[0] >> can.VCU_DATA_RIGHT_INDICATOR_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_RIGHT_INDICATOR_POWER_SUPPLY_OFFSET));
        messages.High_Beam_Power_Supply = (byte) ((((data[0] >> can.VCU_DATA_HIGH_BEAM_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_HIGH_BEAM_POWER_SUPPLY_OFFSET));
        messages.Low_Beam_Power_Supply = (byte) ((((data[0] >> can.VCU_DATA_LOW_BEAM_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_LOW_BEAM_POWER_SUPPLY_OFFSET));
        messages.DRL_Power_Supply = (byte) ((((data[0] >> can.VCU_DATA_DRL_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_DRL_POWER_SUPPLY_OFFSET));
        messages.Left_Switch_Cube_Power_Supply = (byte) (((data[1] & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_LEFT_SWITCH_CUBE_POWER_SUPPLY_OFFSET));
        messages.Right_Switch_Cube_Power_Supply = (byte) ((((data[1] >> can.VCU_DATA_RIGHT_SWITCH_CUBE_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_RIGHT_SWITCH_CUBE_POWER_SUPPLY_OFFSET));
        messages.Horn_Power_Supply = (byte) ((((data[1] >> can.VCU_DATA_HORN_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_HORN_POWER_SUPPLY_OFFSET));
        messages.Speaker_Power_Supply = (byte) ((((data[1] >> can.VCU_DATA_SPEAKER_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_SPEAKER_POWER_SUPPLY_OFFSET));
        messages.SOM_Power_Supply = (byte) ((((data[1] >> can.VCU_DATA_SOM_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_SOM_POWER_SUPPLY_OFFSET));
        messages.ESCL_Power_Supply = (byte) ((((data[1] >> can.VCU_DATA_ESCL_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_ESCL_POWER_SUPPLY_OFFSET));
        messages.ESCL_Commands = (byte) ((((data[2] & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_ESCL_COMMANDS_MASK0) | ((data[1] >> can.VCU_DATA_ESCL_COMMANDS_MASK1) & (can.SIGNLE_READ_Mask2))) + (byte) (can.VCU_DATA_CANID_ESCL_COMMANDS_OFFSET));
        messages.Stop_Lamp_Power_Supply = (byte) ((((data[2] >> can.VCU_DATA_STOP_LAMP_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_STOP_LAMP_POWER_SUPPLY_OFFSET));
        messages.Tail_Lamp_Power_Supply = (byte) ((((data[2] >> can.VCU_DATA_TAIL_LAMP_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_TAIL_LAMP_POWER_SUPPLY_OFFSET));
        messages.Charger_Info = (byte) (((data[3] & (can.SIGNLE_READ_Mask1))) + (byte) (can.VCU_DATA_CANID_CHARGER_INFO_OFFSET));

        return can.VCU_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_VCU_Data(ConverterInitialize.VCU_Data_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charger_Plugin = (byte) (messages.Charger_Plugin - can.VCU_DATA_CANID_CHARGER_PLUGIN_OFFSET);
        messages.MCU_Power_Supply = (byte) (messages.MCU_Power_Supply - can.VCU_DATA_CANID_MCU_POWER_SUPPLY_OFFSET);
        messages.HU_Power_Supply = (byte) (messages.HU_Power_Supply - can.VCU_DATA_CANID_HU_POWER_SUPPLY_OFFSET);
        messages.Left_Indicator_Power_Supply = (byte) (messages.Left_Indicator_Power_Supply - can.VCU_DATA_CANID_LEFT_INDICATOR_POWER_SUPPLY_OFFSET);
        messages.Right_Indicator_Power_Supply = (byte) (messages.Right_Indicator_Power_Supply - can.VCU_DATA_CANID_RIGHT_INDICATOR_POWER_SUPPLY_OFFSET);
        messages.High_Beam_Power_Supply = (byte) (messages.High_Beam_Power_Supply - can.VCU_DATA_CANID_HIGH_BEAM_POWER_SUPPLY_OFFSET);
        messages.Low_Beam_Power_Supply = (byte) (messages.Low_Beam_Power_Supply - can.VCU_DATA_CANID_LOW_BEAM_POWER_SUPPLY_OFFSET);
        messages.DRL_Power_Supply = (byte) (messages.DRL_Power_Supply - can.VCU_DATA_CANID_DRL_POWER_SUPPLY_OFFSET);
        messages.Left_Switch_Cube_Power_Supply = (byte) (messages.Left_Switch_Cube_Power_Supply - can.VCU_DATA_CANID_LEFT_SWITCH_CUBE_POWER_SUPPLY_OFFSET);
        messages.Right_Switch_Cube_Power_Supply = (byte) (messages.Right_Switch_Cube_Power_Supply - can.VCU_DATA_CANID_RIGHT_SWITCH_CUBE_POWER_SUPPLY_OFFSET);
        messages.Horn_Power_Supply = (byte) (messages.Horn_Power_Supply - can.VCU_DATA_CANID_HORN_POWER_SUPPLY_OFFSET);
        messages.Speaker_Power_Supply = (byte) (messages.Speaker_Power_Supply - can.VCU_DATA_CANID_SPEAKER_POWER_SUPPLY_OFFSET);
        messages.SOM_Power_Supply = (byte) (messages.SOM_Power_Supply - can.VCU_DATA_CANID_SOM_POWER_SUPPLY_OFFSET);
        messages.ESCL_Power_Supply = (byte) (messages.ESCL_Power_Supply - can.VCU_DATA_CANID_ESCL_POWER_SUPPLY_OFFSET);
        messages.ESCL_Commands = (byte) (messages.ESCL_Commands - can.VCU_DATA_CANID_ESCL_COMMANDS_OFFSET);
        messages.Stop_Lamp_Power_Supply = (byte) (messages.Stop_Lamp_Power_Supply - can.VCU_DATA_CANID_STOP_LAMP_POWER_SUPPLY_OFFSET);
        messages.Tail_Lamp_Power_Supply = (byte) (messages.Tail_Lamp_Power_Supply - can.VCU_DATA_CANID_TAIL_LAMP_POWER_SUPPLY_OFFSET);
        messages.Charger_Info = (byte) (messages.Charger_Info - can.VCU_DATA_CANID_CHARGER_INFO_OFFSET);
        data[0] = (byte) ((messages.Charger_Plugin & (can.SIGNLE_READ_Mask1)) | ((messages.MCU_Power_Supply & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_MCU_POWER_SUPPLY_MASK0) | ((messages.HU_Power_Supply & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_HU_POWER_SUPPLY_MASK0) | ((messages.Left_Indicator_Power_Supply & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_LEFT_INDICATOR_POWER_SUPPLY_MASK0) | ((messages.Right_Indicator_Power_Supply & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_RIGHT_INDICATOR_POWER_SUPPLY_MASK0) | ((messages.High_Beam_Power_Supply & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_HIGH_BEAM_POWER_SUPPLY_MASK0) | ((messages.Low_Beam_Power_Supply & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_LOW_BEAM_POWER_SUPPLY_MASK0) | ((messages.DRL_Power_Supply & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_DRL_POWER_SUPPLY_MASK0));
        data[1] = (byte) ((messages.Left_Switch_Cube_Power_Supply & (can.SIGNLE_READ_Mask1)) | ((messages.Right_Switch_Cube_Power_Supply & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_RIGHT_SWITCH_CUBE_POWER_SUPPLY_MASK0) | ((messages.Horn_Power_Supply & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_HORN_POWER_SUPPLY_MASK0) | ((messages.Speaker_Power_Supply & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_SPEAKER_POWER_SUPPLY_MASK0) | ((messages.SOM_Power_Supply & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_SOM_POWER_SUPPLY_MASK0) | ((messages.ESCL_Power_Supply & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_ESCL_POWER_SUPPLY_MASK0) | ((messages.ESCL_Commands & (can.SIGNLE_READ_Mask2)) << can.VCU_DATA_ESCL_COMMANDS_MASK1));
        data[2] = (byte) (((messages.ESCL_Commands >> can.VCU_DATA_ESCL_COMMANDS_MASK0) & (can.SIGNLE_READ_Mask1)) | ((messages.Stop_Lamp_Power_Supply & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_STOP_LAMP_POWER_SUPPLY_MASK0) | ((messages.Tail_Lamp_Power_Supply & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_TAIL_LAMP_POWER_SUPPLY_MASK0));
        data[3] = (byte) ((messages.Charger_Info & (can.SIGNLE_READ_Mask1)));
        return can.VCU_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_STATUS(ConverterInitialize.BMS_CELL_STATUS_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Balancing_Status_Cell_1 = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_1_OFFSET));
        messages.BMS_Balancing_Status_Cell_2 = (byte) ((((data[0] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_2_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_2_OFFSET));
        messages.BMS_Balancing_Status_Cell_3 = (byte) ((((data[0] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_3_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_3_OFFSET));
        messages.BMS_Balancing_Status_Cell_4 = (byte) ((((data[0] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_4_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_4_OFFSET));
        messages.BMS_Balancing_Status_Cell_5 = (byte) ((((data[0] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_5_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_5_OFFSET));
        messages.BMS_Balancing_Status_Cell_6 = (byte) ((((data[0] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_6_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_6_OFFSET));
        messages.BMS_Balancing_Status_Cell_7 = (byte) ((((data[0] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_7_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_7_OFFSET));
        messages.BMS_Balancing_Status_Cell_8 = (byte) ((((data[0] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_8_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_8_OFFSET));
        messages.BMS_Balancing_Status_Cell_9 = (byte) (((data[1] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_9_OFFSET));
        messages.BMS_Balancing_Status_Cell_10 = (byte) ((((data[1] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_10_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_10_OFFSET));
        messages.BMS_Balancing_Status_Cell_11 = (byte) ((((data[1] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_11_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_11_OFFSET));
        messages.BMS_Balancing_Status_Cell_12 = (byte) ((((data[1] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_12_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_12_OFFSET));
        messages.BMS_Balancing_Status_Cell_13 = (byte) ((((data[1] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_13_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_13_OFFSET));
        messages.BMS_Balancing_Status_Cell_14 = (byte) ((((data[1] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_14_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_14_OFFSET));
        messages.BMS_Balancing_Status_Cell_15 = (byte) ((((data[1] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_15_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_15_OFFSET));
        messages.BMS_Balancing_Status_Cell_16 = (byte) ((((data[1] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_16_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_16_OFFSET));
        messages.BMS_Balancing_Status_Cell_17 = (byte) (((data[2] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_17_OFFSET));
        messages.BMS_Balancing_Status_Cell_18 = (byte) ((((data[2] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_18_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_18_OFFSET));
        messages.BMS_Balancing_Status_Cell_20 = (byte) ((((data[2] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_20_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_20_OFFSET));
        messages.BMS_Balancing_Status_Cell_21 = (byte) ((((data[2] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_21_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_21_OFFSET));
        messages.BMS_Balancing_Status_Cell_22 = (byte) ((((data[2] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_22_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_22_OFFSET));
        messages.BMS_Balancing_Status_Cell_23 = (byte) ((((data[2] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_23_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_23_OFFSET));
        messages.BMS_Balancing_Status_Cell_24 = (byte) ((((data[2] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_24_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_24_OFFSET));
        messages.BMS_Balancing_Status_Cell_25 = (byte) (((data[3] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_25_OFFSET));
        messages.BMS_Balancing_Status_Cell_26 = (byte) ((((data[3] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_26_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_26_OFFSET));
        messages.BMS_Balancing_Status_Cell_27 = (byte) ((((data[3] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_27_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_27_OFFSET));
        messages.BMS_Balancing_Status_Cell_28 = (byte) ((((data[3] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_28_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_28_OFFSET));
        messages.BMS_Cell_Min_Voltage = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_STATUS_BMS_CELL_MIN_VOLTAGE_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_STATUS_CANID_BMS_CELL_MIN_VOLTAGE_OFFSET));
        messages.BMS_Cell_Max_Voltage = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_STATUS_BMS_CELL_MAX_VOLTAGE_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_STATUS_CANID_BMS_CELL_MAX_VOLTAGE_OFFSET));

        return can.BMS_CELL_STATUS_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_STATUS(ConverterInitialize.BMS_CELL_STATUS_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Balancing_Status_Cell_1 = (byte) (messages.BMS_Balancing_Status_Cell_1 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_1_OFFSET);
        messages.BMS_Balancing_Status_Cell_2 = (byte) (messages.BMS_Balancing_Status_Cell_2 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_2_OFFSET);
        messages.BMS_Balancing_Status_Cell_3 = (byte) (messages.BMS_Balancing_Status_Cell_3 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_3_OFFSET);
        messages.BMS_Balancing_Status_Cell_4 = (byte) (messages.BMS_Balancing_Status_Cell_4 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_4_OFFSET);
        messages.BMS_Balancing_Status_Cell_5 = (byte) (messages.BMS_Balancing_Status_Cell_5 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_5_OFFSET);
        messages.BMS_Balancing_Status_Cell_6 = (byte) (messages.BMS_Balancing_Status_Cell_6 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_6_OFFSET);
        messages.BMS_Balancing_Status_Cell_7 = (byte) (messages.BMS_Balancing_Status_Cell_7 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_7_OFFSET);
        messages.BMS_Balancing_Status_Cell_8 = (byte) (messages.BMS_Balancing_Status_Cell_8 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_8_OFFSET);
        messages.BMS_Balancing_Status_Cell_9 = (byte) (messages.BMS_Balancing_Status_Cell_9 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_9_OFFSET);
        messages.BMS_Balancing_Status_Cell_10 = (byte) (messages.BMS_Balancing_Status_Cell_10 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_10_OFFSET);
        messages.BMS_Balancing_Status_Cell_11 = (byte) (messages.BMS_Balancing_Status_Cell_11 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_11_OFFSET);
        messages.BMS_Balancing_Status_Cell_12 = (byte) (messages.BMS_Balancing_Status_Cell_12 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_12_OFFSET);
        messages.BMS_Balancing_Status_Cell_13 = (byte) (messages.BMS_Balancing_Status_Cell_13 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_13_OFFSET);
        messages.BMS_Balancing_Status_Cell_14 = (byte) (messages.BMS_Balancing_Status_Cell_14 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_14_OFFSET);
        messages.BMS_Balancing_Status_Cell_15 = (byte) (messages.BMS_Balancing_Status_Cell_15 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_15_OFFSET);
        messages.BMS_Balancing_Status_Cell_16 = (byte) (messages.BMS_Balancing_Status_Cell_16 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_16_OFFSET);
        messages.BMS_Balancing_Status_Cell_17 = (byte) (messages.BMS_Balancing_Status_Cell_17 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_17_OFFSET);
        messages.BMS_Balancing_Status_Cell_18 = (byte) (messages.BMS_Balancing_Status_Cell_18 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_18_OFFSET);
        messages.BMS_Balancing_Status_Cell_20 = (byte) (messages.BMS_Balancing_Status_Cell_20 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_20_OFFSET);
        messages.BMS_Balancing_Status_Cell_21 = (byte) (messages.BMS_Balancing_Status_Cell_21 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_21_OFFSET);
        messages.BMS_Balancing_Status_Cell_22 = (byte) (messages.BMS_Balancing_Status_Cell_22 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_22_OFFSET);
        messages.BMS_Balancing_Status_Cell_23 = (byte) (messages.BMS_Balancing_Status_Cell_23 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_23_OFFSET);
        messages.BMS_Balancing_Status_Cell_24 = (byte) (messages.BMS_Balancing_Status_Cell_24 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_24_OFFSET);
        messages.BMS_Balancing_Status_Cell_25 = (byte) (messages.BMS_Balancing_Status_Cell_25 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_25_OFFSET);
        messages.BMS_Balancing_Status_Cell_26 = (byte) (messages.BMS_Balancing_Status_Cell_26 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_26_OFFSET);
        messages.BMS_Balancing_Status_Cell_27 = (byte) (messages.BMS_Balancing_Status_Cell_27 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_27_OFFSET);
        messages.BMS_Balancing_Status_Cell_28 = (byte) (messages.BMS_Balancing_Status_Cell_28 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_28_OFFSET);
        messages.BMS_Cell_Min_Voltage = (short) (messages.BMS_Cell_Min_Voltage - can.BMS_CELL_STATUS_CANID_BMS_CELL_MIN_VOLTAGE_OFFSET);
        messages.BMS_Cell_Max_Voltage = (short) (messages.BMS_Cell_Max_Voltage - can.BMS_CELL_STATUS_CANID_BMS_CELL_MAX_VOLTAGE_OFFSET);
        data[0] = (byte) ((messages.BMS_Balancing_Status_Cell_1 & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_Balancing_Status_Cell_2 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_2_MASK0) | ((messages.BMS_Balancing_Status_Cell_3 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_3_MASK0) | ((messages.BMS_Balancing_Status_Cell_4 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_4_MASK0) | ((messages.BMS_Balancing_Status_Cell_5 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_5_MASK0) | ((messages.BMS_Balancing_Status_Cell_6 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_6_MASK0) | ((messages.BMS_Balancing_Status_Cell_7 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_7_MASK0) | ((messages.BMS_Balancing_Status_Cell_8 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_8_MASK0));
        data[1] = (byte) ((messages.BMS_Balancing_Status_Cell_9 & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_Balancing_Status_Cell_10 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_10_MASK0) | ((messages.BMS_Balancing_Status_Cell_11 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_11_MASK0) | ((messages.BMS_Balancing_Status_Cell_12 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_12_MASK0) | ((messages.BMS_Balancing_Status_Cell_13 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_13_MASK0) | ((messages.BMS_Balancing_Status_Cell_14 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_14_MASK0) | ((messages.BMS_Balancing_Status_Cell_15 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_15_MASK0) | ((messages.BMS_Balancing_Status_Cell_16 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_16_MASK0));
        data[2] = (byte) ((messages.BMS_Balancing_Status_Cell_17 & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_Balancing_Status_Cell_18 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_18_MASK0) | ((messages.BMS_Balancing_Status_Cell_20 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_20_MASK0) | ((messages.BMS_Balancing_Status_Cell_21 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_21_MASK0) | ((messages.BMS_Balancing_Status_Cell_22 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_22_MASK0) | ((messages.BMS_Balancing_Status_Cell_23 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_23_MASK0) | ((messages.BMS_Balancing_Status_Cell_24 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_24_MASK0));
        data[3] = (byte) ((messages.BMS_Balancing_Status_Cell_25 & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_Balancing_Status_Cell_26 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_26_MASK0) | ((messages.BMS_Balancing_Status_Cell_27 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_27_MASK0) | ((messages.BMS_Balancing_Status_Cell_28 & (can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_28_MASK0));
        data[4] = (byte) ((messages.BMS_Cell_Min_Voltage & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.BMS_Cell_Min_Voltage >> can.BMS_CELL_STATUS_BMS_CELL_MIN_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.BMS_Cell_Max_Voltage & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.BMS_Cell_Max_Voltage >> can.BMS_CELL_STATUS_BMS_CELL_MAX_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_STATUS_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Charger_Parameter_1(ConverterInitialize.Charger_Parameter_1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charger_IP_AC_Volt = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.CHARGER_PARAMETER_1_CHARGER_IP_AC_VOLT_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.CHARGER_PARAMETER_1_CANID_CHARGER_IP_AC_VOLT_OFFSET));
        messages.Charger_IP_AC_Current = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.CHARGER_PARAMETER_1_CHARGER_IP_AC_CURRENT_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.CHARGER_PARAMETER_1_CANID_CHARGER_IP_AC_CURRENT_OFFSET));
        messages.Charger_OP_DC_Volt = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.CHARGER_PARAMETER_1_CHARGER_OP_DC_VOLT_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.CHARGER_PARAMETER_1_CANID_CHARGER_OP_DC_VOLT_OFFSET));
        messages.Charger_OP_DC_Current = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.CHARGER_PARAMETER_1_CHARGER_OP_DC_CURRENT_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.CHARGER_PARAMETER_1_CANID_CHARGER_OP_DC_CURRENT_OFFSET));

        return can.CHARGER_PARAMETER_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Charger_Parameter_1(ConverterInitialize.Charger_Parameter_1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charger_IP_AC_Volt = (short) (messages.Charger_IP_AC_Volt - can.CHARGER_PARAMETER_1_CANID_CHARGER_IP_AC_VOLT_OFFSET);
        messages.Charger_IP_AC_Current = (short) (messages.Charger_IP_AC_Current - can.CHARGER_PARAMETER_1_CANID_CHARGER_IP_AC_CURRENT_OFFSET);
        messages.Charger_OP_DC_Volt = (short) (messages.Charger_OP_DC_Volt - can.CHARGER_PARAMETER_1_CANID_CHARGER_OP_DC_VOLT_OFFSET);
        messages.Charger_OP_DC_Current = (short) (messages.Charger_OP_DC_Current - can.CHARGER_PARAMETER_1_CANID_CHARGER_OP_DC_CURRENT_OFFSET);
        data[0] = (byte) ((messages.Charger_IP_AC_Volt & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Charger_IP_AC_Volt >> can.CHARGER_PARAMETER_1_CHARGER_IP_AC_VOLT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Charger_IP_AC_Current & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Charger_IP_AC_Current >> can.CHARGER_PARAMETER_1_CHARGER_IP_AC_CURRENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Charger_OP_DC_Volt & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Charger_OP_DC_Volt >> can.CHARGER_PARAMETER_1_CHARGER_OP_DC_VOLT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Charger_OP_DC_Current & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Charger_OP_DC_Current >> can.CHARGER_PARAMETER_1_CHARGER_OP_DC_CURRENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.CHARGER_PARAMETER_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OBC_HP_DCDC_Parameter_2(ConverterInitialize.OBC_HP_DCDC_Parameter_2_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_temp = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.OBC_HP_DCDC_PARAMETER_2_OBC_TEMP_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_TEMP_OFFSET));
        messages.HP_DCDC_Temp = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.OBC_HP_DCDC_PARAMETER_2_HP_DCDC_TEMP_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.OBC_HP_DCDC_PARAMETER_2_CANID_HP_DCDC_TEMP_OFFSET));
        messages.OBC_OP_Enable = (byte) (((data[4] & (can.SIGNLE_READ_Mask1))) + (byte) (can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_OP_ENABLE_OFFSET));
        messages.OBC_Coolant_Fan_Status = (byte) ((((data[4] >> can.OBC_HP_DCDC_PARAMETER_2_OBC_COOLANT_FAN_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_COOLANT_FAN_STATUS_OFFSET));
        messages.Control_Proximity_status = (byte) ((((data[4] >> can.OBC_HP_DCDC_PARAMETER_2_CONTROL_PROXIMITY_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.OBC_HP_DCDC_PARAMETER_2_CANID_CONTROL_PROXIMITY_STATUS_OFFSET));
        messages.DCDC_Conv_OP_Enable = (byte) ((((data[4] >> can.OBC_HP_DCDC_PARAMETER_2_DCDC_CONV_OP_ENABLE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.OBC_HP_DCDC_PARAMETER_2_CANID_DCDC_CONV_OP_ENABLE_OFFSET));
        messages.OBC_FET_Temp = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.OBC_HP_DCDC_PARAMETER_2_OBC_FET_TEMP_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_FET_TEMP_OFFSET));

        return can.OBC_HP_DCDC_PARAMETER_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OBC_HP_DCDC_Parameter_2(ConverterInitialize.OBC_HP_DCDC_Parameter_2_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_temp = (short) (messages.OBC_temp - can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_TEMP_OFFSET);
        messages.HP_DCDC_Temp = (short) (messages.HP_DCDC_Temp - can.OBC_HP_DCDC_PARAMETER_2_CANID_HP_DCDC_TEMP_OFFSET);
        messages.OBC_OP_Enable = (byte) (messages.OBC_OP_Enable - can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_OP_ENABLE_OFFSET);
        messages.OBC_Coolant_Fan_Status = (byte) (messages.OBC_Coolant_Fan_Status - can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_COOLANT_FAN_STATUS_OFFSET);
        messages.Control_Proximity_status = (byte) (messages.Control_Proximity_status - can.OBC_HP_DCDC_PARAMETER_2_CANID_CONTROL_PROXIMITY_STATUS_OFFSET);
        messages.DCDC_Conv_OP_Enable = (byte) (messages.DCDC_Conv_OP_Enable - can.OBC_HP_DCDC_PARAMETER_2_CANID_DCDC_CONV_OP_ENABLE_OFFSET);
        messages.OBC_FET_Temp = (short) (messages.OBC_FET_Temp - can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_FET_TEMP_OFFSET);
        data[0] = (byte) ((messages.OBC_temp & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.OBC_temp >> can.OBC_HP_DCDC_PARAMETER_2_OBC_TEMP_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.HP_DCDC_Temp & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.HP_DCDC_Temp >> can.OBC_HP_DCDC_PARAMETER_2_HP_DCDC_TEMP_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.OBC_OP_Enable & (can.SIGNLE_READ_Mask1)) | ((messages.OBC_Coolant_Fan_Status & (can.SIGNLE_READ_Mask1)) << can.OBC_HP_DCDC_PARAMETER_2_OBC_COOLANT_FAN_STATUS_MASK0) | ((messages.Control_Proximity_status & (can.SIGNLE_READ_Mask1)) << can.OBC_HP_DCDC_PARAMETER_2_CONTROL_PROXIMITY_STATUS_MASK0) | ((messages.DCDC_Conv_OP_Enable & (can.SIGNLE_READ_Mask1)) << can.OBC_HP_DCDC_PARAMETER_2_DCDC_CONV_OP_ENABLE_MASK0));
        data[6] = (byte) ((messages.OBC_FET_Temp & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.OBC_FET_Temp >> can.OBC_HP_DCDC_PARAMETER_2_OBC_FET_TEMP_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.OBC_HP_DCDC_PARAMETER_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_VOLTAGE_1(ConverterInitialize.BMS_CELL_VOLTAGE_1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_1 = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_1_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_1_OFFSET));
        messages.Cell_Voltage_Vcell_2 = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_2_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_2_OFFSET));
        messages.Cell_Voltage_Vcell_3 = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_3_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_3_OFFSET));
        messages.Cell_Voltage_Vcell_4 = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_4_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_4_OFFSET));

        return can.BMS_CELL_VOLTAGE_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_VOLTAGE_1(ConverterInitialize.BMS_CELL_VOLTAGE_1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_1 = (short) (messages.Cell_Voltage_Vcell_1 - can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_1_OFFSET);
        messages.Cell_Voltage_Vcell_2 = (short) (messages.Cell_Voltage_Vcell_2 - can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_2_OFFSET);
        messages.Cell_Voltage_Vcell_3 = (short) (messages.Cell_Voltage_Vcell_3 - can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_3_OFFSET);
        messages.Cell_Voltage_Vcell_4 = (short) (messages.Cell_Voltage_Vcell_4 - can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_4_OFFSET);
        data[0] = (byte) ((messages.Cell_Voltage_Vcell_1 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Cell_Voltage_Vcell_1 >> can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_1_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Cell_Voltage_Vcell_2 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Cell_Voltage_Vcell_2 >> can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_2_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Cell_Voltage_Vcell_3 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Cell_Voltage_Vcell_3 >> can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_3_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Cell_Voltage_Vcell_4 & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Cell_Voltage_Vcell_4 >> can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_4_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_VOLTAGE_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_VOLTAGE_2(ConverterInitialize.BMS_CELL_VOLTAGE_2_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_5 = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_5_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_5_OFFSET));
        messages.Cell_Voltage_Vcell_6 = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_6_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_6_OFFSET));
        messages.Cell_Voltage_Vcell_7 = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_7_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_7_OFFSET));
        messages.Cell_Voltage_Vcell_8 = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_8_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_8_OFFSET));

        return can.BMS_CELL_VOLTAGE_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_VOLTAGE_2(ConverterInitialize.BMS_CELL_VOLTAGE_2_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_5 = (short) (messages.Cell_Voltage_Vcell_5 - can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_5_OFFSET);
        messages.Cell_Voltage_Vcell_6 = (short) (messages.Cell_Voltage_Vcell_6 - can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_6_OFFSET);
        messages.Cell_Voltage_Vcell_7 = (short) (messages.Cell_Voltage_Vcell_7 - can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_7_OFFSET);
        messages.Cell_Voltage_Vcell_8 = (short) (messages.Cell_Voltage_Vcell_8 - can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_8_OFFSET);
        data[0] = (byte) ((messages.Cell_Voltage_Vcell_5 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Cell_Voltage_Vcell_5 >> can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_5_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Cell_Voltage_Vcell_6 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Cell_Voltage_Vcell_6 >> can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_6_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Cell_Voltage_Vcell_7 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Cell_Voltage_Vcell_7 >> can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_7_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Cell_Voltage_Vcell_8 & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Cell_Voltage_Vcell_8 >> can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_8_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_VOLTAGE_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_VOLTAGE_3(ConverterInitialize.BMS_CELL_VOLTAGE_3_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_9 = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_9_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_9_OFFSET));
        messages.Cell_Voltage_Vcell_10 = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_10_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_10_OFFSET));
        messages.Cell_Voltage_Vcell_11 = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_11_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_11_OFFSET));
        messages.Cell_Voltage_Vcell_12 = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_12_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_12_OFFSET));

        return can.BMS_CELL_VOLTAGE_3_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_VOLTAGE_3(ConverterInitialize.BMS_CELL_VOLTAGE_3_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_9 = (short) (messages.Cell_Voltage_Vcell_9 - can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_9_OFFSET);
        messages.Cell_Voltage_Vcell_10 = (short) (messages.Cell_Voltage_Vcell_10 - can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_10_OFFSET);
        messages.Cell_Voltage_Vcell_11 = (short) (messages.Cell_Voltage_Vcell_11 - can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_11_OFFSET);
        messages.Cell_Voltage_Vcell_12 = (short) (messages.Cell_Voltage_Vcell_12 - can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_12_OFFSET);
        data[0] = (byte) ((messages.Cell_Voltage_Vcell_9 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Cell_Voltage_Vcell_9 >> can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_9_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Cell_Voltage_Vcell_10 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Cell_Voltage_Vcell_10 >> can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_10_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Cell_Voltage_Vcell_11 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Cell_Voltage_Vcell_11 >> can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_11_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Cell_Voltage_Vcell_12 & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Cell_Voltage_Vcell_12 >> can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_12_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_VOLTAGE_3_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_VOLTAGE_4(ConverterInitialize.BMS_CELL_VOLTAGE_4_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_13 = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_13_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_13_OFFSET));
        messages.Cell_Voltage_Vcell_14 = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_14_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_14_OFFSET));
        messages.Cell_Voltage_Vcell_15 = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_15_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_15_OFFSET));
        messages.Cell_Voltage_Vcell_16 = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_16_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_16_OFFSET));

        return can.BMS_CELL_VOLTAGE_4_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_VOLTAGE_4(ConverterInitialize.BMS_CELL_VOLTAGE_4_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_13 = (short) (messages.Cell_Voltage_Vcell_13 - can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_13_OFFSET);
        messages.Cell_Voltage_Vcell_14 = (short) (messages.Cell_Voltage_Vcell_14 - can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_14_OFFSET);
        messages.Cell_Voltage_Vcell_15 = (short) (messages.Cell_Voltage_Vcell_15 - can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_15_OFFSET);
        messages.Cell_Voltage_Vcell_16 = (short) (messages.Cell_Voltage_Vcell_16 - can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_16_OFFSET);
        data[0] = (byte) ((messages.Cell_Voltage_Vcell_13 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Cell_Voltage_Vcell_13 >> can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_13_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Cell_Voltage_Vcell_14 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Cell_Voltage_Vcell_14 >> can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_14_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Cell_Voltage_Vcell_15 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Cell_Voltage_Vcell_15 >> can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_15_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Cell_Voltage_Vcell_16 & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Cell_Voltage_Vcell_16 >> can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_16_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_VOLTAGE_4_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_VOLTAGE_5(ConverterInitialize.BMS_CELL_VOLTAGE_5_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_17 = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_17_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_17_OFFSET));
        messages.Cell_Voltage_Vcell_18 = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_18_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_18_OFFSET));
        messages.Cell_Voltage_Vcell_19 = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_19_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_19_OFFSET));
        messages.Cell_Voltage_Vcell_20 = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_20_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_20_OFFSET));

        return can.BMS_CELL_VOLTAGE_5_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_VOLTAGE_5(ConverterInitialize.BMS_CELL_VOLTAGE_5_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_17 = (short) (messages.Cell_Voltage_Vcell_17 - can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_17_OFFSET);
        messages.Cell_Voltage_Vcell_18 = (short) (messages.Cell_Voltage_Vcell_18 - can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_18_OFFSET);
        messages.Cell_Voltage_Vcell_19 = (short) (messages.Cell_Voltage_Vcell_19 - can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_19_OFFSET);
        messages.Cell_Voltage_Vcell_20 = (short) (messages.Cell_Voltage_Vcell_20 - can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_20_OFFSET);
        data[0] = (byte) ((messages.Cell_Voltage_Vcell_17 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Cell_Voltage_Vcell_17 >> can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_17_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Cell_Voltage_Vcell_18 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Cell_Voltage_Vcell_18 >> can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_18_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Cell_Voltage_Vcell_19 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Cell_Voltage_Vcell_19 >> can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_19_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Cell_Voltage_Vcell_20 & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Cell_Voltage_Vcell_20 >> can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_20_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_VOLTAGE_5_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_VOLTAGE_6(ConverterInitialize.BMS_CELL_VOLTAGE_6_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_21 = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_21_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_21_OFFSET));
        messages.Cell_Voltage_Vcell_22 = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_22_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_22_OFFSET));
        messages.Cell_Voltage_Vcell_23 = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_23_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_23_OFFSET));
        messages.Cell_Voltage_Vcell_24 = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_24_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_24_OFFSET));

        return can.BMS_CELL_VOLTAGE_6_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_VOLTAGE_6(ConverterInitialize.BMS_CELL_VOLTAGE_6_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_21 = (short) (messages.Cell_Voltage_Vcell_21 - can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_21_OFFSET);
        messages.Cell_Voltage_Vcell_22 = (short) (messages.Cell_Voltage_Vcell_22 - can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_22_OFFSET);
        messages.Cell_Voltage_Vcell_23 = (short) (messages.Cell_Voltage_Vcell_23 - can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_23_OFFSET);
        messages.Cell_Voltage_Vcell_24 = (short) (messages.Cell_Voltage_Vcell_24 - can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_24_OFFSET);
        data[0] = (byte) ((messages.Cell_Voltage_Vcell_21 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Cell_Voltage_Vcell_21 >> can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_21_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Cell_Voltage_Vcell_22 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Cell_Voltage_Vcell_22 >> can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_22_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Cell_Voltage_Vcell_23 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Cell_Voltage_Vcell_23 >> can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_23_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Cell_Voltage_Vcell_24 & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Cell_Voltage_Vcell_24 >> can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_24_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_VOLTAGE_6_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_VOLTAGE_7(ConverterInitialize.BMS_CELL_VOLTAGE_7_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_25 = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_25_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_25_OFFSET));
        messages.Cell_Voltage_Vcell_26 = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_26_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_26_OFFSET));
        messages.Cell_Voltage_Vcell_27 = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_27_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_27_OFFSET));
        messages.Cell_Voltage_Vcell_28 = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_28_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_28_OFFSET));

        return can.BMS_CELL_VOLTAGE_7_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_VOLTAGE_7(ConverterInitialize.BMS_CELL_VOLTAGE_7_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_25 = (short) (messages.Cell_Voltage_Vcell_25 - can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_25_OFFSET);
        messages.Cell_Voltage_Vcell_26 = (short) (messages.Cell_Voltage_Vcell_26 - can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_26_OFFSET);
        messages.Cell_Voltage_Vcell_27 = (short) (messages.Cell_Voltage_Vcell_27 - can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_27_OFFSET);
        messages.Cell_Voltage_Vcell_28 = (short) (messages.Cell_Voltage_Vcell_28 - can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_28_OFFSET);
        data[0] = (byte) ((messages.Cell_Voltage_Vcell_25 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Cell_Voltage_Vcell_25 >> can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_25_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Cell_Voltage_Vcell_26 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Cell_Voltage_Vcell_26 >> can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_26_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Cell_Voltage_Vcell_27 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Cell_Voltage_Vcell_27 >> can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_27_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Cell_Voltage_Vcell_28 & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Cell_Voltage_Vcell_28 >> can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_28_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_VOLTAGE_7_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Charger_status_Info(ConverterInitialize.Charger_status_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charger_Status_Signal = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_STATUS_INFO_CANID_CHARGER_STATUS_SIGNAL_OFFSET));
        messages.Charger_Mode = (byte) ((((data[0] >> can.CHARGER_STATUS_INFO_CHARGER_MODE_MASK0) & (can.SIGNLE_READ_Mask4))) + (byte) (can.CHARGER_STATUS_INFO_CANID_CHARGER_MODE_OFFSET));

        return can.CHARGER_STATUS_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Charger_status_Info(ConverterInitialize.Charger_status_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charger_Status_Signal = (byte) (messages.Charger_Status_Signal - can.CHARGER_STATUS_INFO_CANID_CHARGER_STATUS_SIGNAL_OFFSET);
        messages.Charger_Mode = (byte) (messages.Charger_Mode - can.CHARGER_STATUS_INFO_CANID_CHARGER_MODE_OFFSET);
        data[0] = (byte) ((messages.Charger_Status_Signal & (can.SIGNLE_READ_Mask1)) | ((messages.Charger_Mode & (can.SIGNLE_READ_Mask4)) << can.CHARGER_STATUS_INFO_CHARGER_MODE_MASK0));
        return can.CHARGER_STATUS_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Data3(ConverterInitialize.MCU_Data3_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.R_Phase_Current_MCU = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA3_R_PHASE_CURRENT_MCU_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.MCU_DATA3_CANID_R_PHASE_CURRENT_MCU_OFFSET));
        messages.Y_Phase_Current_MCU = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA3_Y_PHASE_CURRENT_MCU_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.MCU_DATA3_CANID_Y_PHASE_CURRENT_MCU_OFFSET));
        messages.B_Phase_Current_MCU = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA3_B_PHASE_CURRENT_MCU_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.MCU_DATA3_CANID_B_PHASE_CURRENT_MCU_OFFSET));
        messages.Regen_Min_Speed = (short) ((((data[7] & (can.SIGNLE_READ_Mask6)) << can.MCU_DATA3_REGEN_MIN_SPEED_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.MCU_DATA3_CANID_REGEN_MIN_SPEED_OFFSET));

        return can.MCU_DATA3_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Data3(ConverterInitialize.MCU_Data3_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.R_Phase_Current_MCU = (short) (messages.R_Phase_Current_MCU - can.MCU_DATA3_CANID_R_PHASE_CURRENT_MCU_OFFSET);
        messages.Y_Phase_Current_MCU = (short) (messages.Y_Phase_Current_MCU - can.MCU_DATA3_CANID_Y_PHASE_CURRENT_MCU_OFFSET);
        messages.B_Phase_Current_MCU = (short) (messages.B_Phase_Current_MCU - can.MCU_DATA3_CANID_B_PHASE_CURRENT_MCU_OFFSET);
        messages.Regen_Min_Speed = (short) (messages.Regen_Min_Speed - can.MCU_DATA3_CANID_REGEN_MIN_SPEED_OFFSET);
        data[0] = (byte) ((messages.R_Phase_Current_MCU & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.R_Phase_Current_MCU >> can.MCU_DATA3_R_PHASE_CURRENT_MCU_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Y_Phase_Current_MCU & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Y_Phase_Current_MCU >> can.MCU_DATA3_Y_PHASE_CURRENT_MCU_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.B_Phase_Current_MCU & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.B_Phase_Current_MCU >> can.MCU_DATA3_B_PHASE_CURRENT_MCU_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Regen_Min_Speed & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Regen_Min_Speed >> can.MCU_DATA3_REGEN_MIN_SPEED_MASK0) & (can.SIGNLE_READ_Mask6)));
        return can.MCU_DATA3_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Data4(ConverterInitialize.MCU_Data4_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Motor_rpm = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA4_MOTOR_RPM_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.MCU_DATA4_CANID_MOTOR_RPM_OFFSET));
        messages.Regen_status = (byte) (((data[2] & (can.SIGNLE_READ_Mask3))) + (byte) (can.MCU_DATA4_CANID_REGEN_STATUS_OFFSET));

        return can.MCU_DATA4_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Data4(ConverterInitialize.MCU_Data4_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Motor_rpm = (short) (messages.Motor_rpm - can.MCU_DATA4_CANID_MOTOR_RPM_OFFSET);
        messages.Regen_status = (byte) (messages.Regen_status - can.MCU_DATA4_CANID_REGEN_STATUS_OFFSET);
        data[0] = (byte) ((messages.Motor_rpm & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Motor_rpm >> can.MCU_DATA4_MOTOR_RPM_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Regen_status & (can.SIGNLE_READ_Mask3)));
        return can.MCU_DATA4_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Data1(ConverterInitialize.MCU_Data1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_DC_Current = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA1_MCU_DC_CURRENT_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.MCU_DATA1_CANID_MCU_DC_CURRENT_OFFSET));
        messages.MCU_Temperature = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA1_MCU_TEMPERATURE_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.MCU_DATA1_CANID_MCU_TEMPERATURE_OFFSET));
        messages.Motor_temp = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA1_MOTOR_TEMP_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.MCU_DATA1_CANID_MOTOR_TEMP_OFFSET));
        messages.Motor_Torque = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA1_MOTOR_TORQUE_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.MCU_DATA1_CANID_MOTOR_TORQUE_OFFSET));

        return can.MCU_DATA1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Data1(ConverterInitialize.MCU_Data1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_DC_Current = (short) (messages.MCU_DC_Current - can.MCU_DATA1_CANID_MCU_DC_CURRENT_OFFSET);
        messages.MCU_Temperature = (short) (messages.MCU_Temperature - can.MCU_DATA1_CANID_MCU_TEMPERATURE_OFFSET);
        messages.Motor_temp = (short) (messages.Motor_temp - can.MCU_DATA1_CANID_MOTOR_TEMP_OFFSET);
        messages.Motor_Torque = (short) (messages.Motor_Torque - can.MCU_DATA1_CANID_MOTOR_TORQUE_OFFSET);
        data[0] = (byte) ((messages.MCU_DC_Current & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.MCU_DC_Current >> can.MCU_DATA1_MCU_DC_CURRENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.MCU_Temperature & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.MCU_Temperature >> can.MCU_DATA1_MCU_TEMPERATURE_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Motor_temp & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Motor_temp >> can.MCU_DATA1_MOTOR_TEMP_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Motor_Torque & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Motor_Torque >> can.MCU_DATA1_MOTOR_TORQUE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.MCU_DATA1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Disconnect_ACK(ConverterInitialize.MCU_Disconnect_ACK_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Disconnect_ACK = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_DISCONNECT_ACK_CANID_DISCONNECT_ACK_OFFSET));

        return can.MCU_DISCONNECT_ACK_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Disconnect_ACK(ConverterInitialize.MCU_Disconnect_ACK_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Disconnect_ACK = (byte) (messages.Disconnect_ACK - can.MCU_DISCONNECT_ACK_CANID_DISCONNECT_ACK_OFFSET);
        data[0] = (byte) ((messages.Disconnect_ACK & (can.SIGNLE_READ_Mask1)));
        return can.MCU_DISCONNECT_ACK_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Fault_Data(ConverterInitialize.MCU_Fault_Data_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.MotorOC_protect_U_ph = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MOTOROC_PROTECT_U_PH_OFFSET));
        messages.MotorOC_protect_V_ph = (byte) ((((data[0] >> can.MCU_FAULT_DATA_MOTOROC_PROTECT_V_PH_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MOTOROC_PROTECT_V_PH_OFFSET));
        messages.MotorOC_protect_W_ph = (byte) ((((data[0] >> can.MCU_FAULT_DATA_MOTOROC_PROTECT_W_PH_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MOTOROC_PROTECT_W_PH_OFFSET));
        messages.Mcu_Flt_Wrong_Offset_Fault = (byte) ((((data[0] >> can.MCU_FAULT_DATA_MCU_FLT_WRONG_OFFSET_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_WRONG_OFFSET_FAULT_OFFSET));
        messages.MCU_over_temperature_warning = (byte) ((((data[0] >> can.MCU_FAULT_DATA_MCU_OVER_TEMPERATURE_WARNING_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_OVER_TEMPERATURE_WARNING_OFFSET));
        messages.Motor_over_temperature_warning = (byte) ((((data[0] >> can.MCU_FAULT_DATA_MOTOR_OVER_TEMPERATURE_WARNING_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MOTOR_OVER_TEMPERATURE_WARNING_OFFSET));
        messages.MCU_Unintended_Direction = (byte) ((((data[0] >> can.MCU_FAULT_DATA_MCU_UNINTENDED_DIRECTION_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_UNINTENDED_DIRECTION_OFFSET));
        messages.Encoder_Failure = (byte) ((((data[0] >> can.MCU_FAULT_DATA_ENCODER_FAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_ENCODER_FAILURE_OFFSET));
        messages.DCbus_undervoltage = (byte) (((data[1] & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_DCBUS_UNDERVOLTAGE_OFFSET));
        messages.DCbus_overvoltage = (byte) ((((data[1] >> can.MCU_FAULT_DATA_DCBUS_OVERVOLTAGE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_DCBUS_OVERVOLTAGE_OFFSET));
        messages.DCbus_overcurrent = (byte) ((((data[1] >> can.MCU_FAULT_DATA_DCBUS_OVERCURRENT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_DCBUS_OVERCURRENT_OFFSET));
        messages.MCU_Over_speed_fault = (byte) ((((data[1] >> can.MCU_FAULT_DATA_MCU_OVER_SPEED_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_OVER_SPEED_FAULT_OFFSET));
        messages.Mcu_Flt_DCBus_Voltagesensor_STG = (byte) ((((data[1] >> can.MCU_FAULT_DATA_MCU_FLT_DCBUS_VOLTAGESENSOR_STG_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_DCBUS_VOLTAGESENSOR_STG_OFFSET));
        messages.Mcu_Flt_DCBus_VoltgeSensor_STB = (byte) ((((data[1] >> can.MCU_FAULT_DATA_MCU_FLT_DCBUS_VOLTGESENSOR_STB_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_DCBUS_VOLTGESENSOR_STB_OFFSET));
        messages.MCU_Flt_KL30_Sensor_STG = (byte) ((((data[1] >> can.MCU_FAULT_DATA_MCU_FLT_KL30_SENSOR_STG_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_KL30_SENSOR_STG_OFFSET));
        messages.MCU_Flt_KL30_Sensor_STB = (byte) ((((data[1] >> can.MCU_FAULT_DATA_MCU_FLT_KL30_SENSOR_STB_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_KL30_SENSOR_STB_OFFSET));
        messages.Mcu_Flt_BoardTempSensorSTG = (byte) (((data[2] & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_BOARDTEMPSENSORSTG_OFFSET));
        messages.Mcu_Flt_BoardTempSensorSTB = (byte) ((((data[2] >> can.MCU_FAULT_DATA_MCU_FLT_BOARDTEMPSENSORSTB_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_BOARDTEMPSENSORSTB_OFFSET));
        messages.Mcu_Flt_RphaseSTG = (byte) ((((data[2] >> can.MCU_FAULT_DATA_MCU_FLT_RPHASESTG_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_RPHASESTG_OFFSET));
        messages.Mcu_Flt_RphaseSTB = (byte) ((((data[2] >> can.MCU_FAULT_DATA_MCU_FLT_RPHASESTB_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_RPHASESTB_OFFSET));
        messages.Loss_of_Tractioncontrol2msg = (byte) ((((data[2] >> can.MCU_FAULT_DATA_LOSS_OF_TRACTIONCONTROL2MSG_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_LOSS_OF_TRACTIONCONTROL2MSG_OFFSET));
        messages.LV_supplyOvervoltage = (byte) ((((data[2] >> can.MCU_FAULT_DATA_LV_SUPPLYOVERVOLTAGE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_LV_SUPPLYOVERVOLTAGE_OFFSET));
        messages.LV_supplyUndervoltage = (byte) ((((data[2] >> can.MCU_FAULT_DATA_LV_SUPPLYUNDERVOLTAGE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_LV_SUPPLYUNDERVOLTAGE_OFFSET));
        messages.Mcu_Flt_YphaseSTG = (byte) ((((data[2] >> can.MCU_FAULT_DATA_MCU_FLT_YPHASESTG_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_YPHASESTG_OFFSET));
        messages.Mcu_Flt_YphaseSTB = (byte) (((data[3] & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_YPHASESTB_OFFSET));
        messages.Mcu_Flt_BphaseSTG = (byte) ((((data[3] >> can.MCU_FAULT_DATA_MCU_FLT_BPHASESTG_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_BPHASESTG_OFFSET));
        messages.Mcu_Flt_BphaseSTB = (byte) ((((data[3] >> can.MCU_FAULT_DATA_MCU_FLT_BPHASESTB_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_BPHASESTB_OFFSET));
        messages.MCU_Flt_MachineTempSensorSTB = (byte) ((((data[3] >> can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMPSENSORSTB_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_MACHINETEMPSENSORSTB_OFFSET));
        messages.MCU_Flt_MachineTempSensorSTG = (byte) ((((data[3] >> can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMPSENSORSTG_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_MACHINETEMPSENSORSTG_OFFSET));
        messages.Mcu_Flt_DCCurrentSensorSTG = (byte) ((((data[3] >> can.MCU_FAULT_DATA_MCU_FLT_DCCURRENTSENSORSTG_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_DCCURRENTSENSORSTG_OFFSET));
        messages.Mcu_Flt_DCCurrentSensorSTB = (byte) ((((data[3] >> can.MCU_FAULT_DATA_MCU_FLT_DCCURRENTSENSORSTB_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_DCCURRENTSENSORSTB_OFFSET));
        messages.Mcu_Flt_BuckConvert5V_overvolt = (byte) ((((data[3] >> can.MCU_FAULT_DATA_MCU_FLT_BUCKCONVERT5V_OVERVOLT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_BUCKCONVERT5V_OVERVOLT_OFFSET));
        messages.Mcu_Flt_BuckConvert5v_undervolt = (byte) (((data[4] & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_BUCKCONVERT5V_UNDERVOLT_OFFSET));
        messages.MCU_dio_over_volt_status = (byte) ((((data[4] >> can.MCU_FAULT_DATA_MCU_DIO_OVER_VOLT_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_DIO_OVER_VOLT_STATUS_OFFSET));
        messages.MCU_dio_over_curr_status = (byte) ((((data[4] >> can.MCU_FAULT_DATA_MCU_DIO_OVER_CURR_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_DIO_OVER_CURR_STATUS_OFFSET));
        messages.MCU_dio_phase_ctrl_status = (byte) ((((data[4] >> can.MCU_FAULT_DATA_MCU_DIO_PHASE_CTRL_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_DIO_PHASE_CTRL_STATUS_OFFSET));
        messages.Mcu_Flt_MachineTemp_Low = (byte) ((((data[4] >> can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMP_LOW_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_MACHINETEMP_LOW_OFFSET));
        messages.Mcu_Flt_BoardTemp_Low = (byte) ((((data[4] >> can.MCU_FAULT_DATA_MCU_FLT_BOARDTEMP_LOW_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_BOARDTEMP_LOW_OFFSET));
        messages.Mcu_Flt_Rotor_Stall = (byte) ((((data[4] >> can.MCU_FAULT_DATA_MCU_FLT_ROTOR_STALL_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_ROTOR_STALL_OFFSET));
        messages.Mcu_Flt_MOSFET_HighTemp = (byte) ((((data[4] >> can.MCU_FAULT_DATA_MCU_FLT_MOSFET_HIGHTEMP_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_MOSFET_HIGHTEMP_OFFSET));
        messages.MCU_Flt_MOSFET_STG = (byte) (((data[5] & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_MOSFET_STG_OFFSET));
        messages.MCU_Flt_MOSFET_STB = (byte) ((((data[5] >> can.MCU_FAULT_DATA_MCU_FLT_MOSFET_STB_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_MCU_FLT_MOSFET_STB_OFFSET));
        messages.Throttle_ideal_percentage_error = (byte) ((((data[5] >> can.MCU_FAULT_DATA_THROTTLE_IDEAL_PERCENTAGE_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.MCU_FAULT_DATA_CANID_THROTTLE_IDEAL_PERCENTAGE_ERROR_OFFSET));

        return can.MCU_FAULT_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Fault_Data(ConverterInitialize.MCU_Fault_Data_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.MotorOC_protect_U_ph = (byte) (messages.MotorOC_protect_U_ph - can.MCU_FAULT_DATA_CANID_MOTOROC_PROTECT_U_PH_OFFSET);
        messages.MotorOC_protect_V_ph = (byte) (messages.MotorOC_protect_V_ph - can.MCU_FAULT_DATA_CANID_MOTOROC_PROTECT_V_PH_OFFSET);
        messages.MotorOC_protect_W_ph = (byte) (messages.MotorOC_protect_W_ph - can.MCU_FAULT_DATA_CANID_MOTOROC_PROTECT_W_PH_OFFSET);
        messages.Mcu_Flt_Wrong_Offset_Fault = (byte) (messages.Mcu_Flt_Wrong_Offset_Fault - can.MCU_FAULT_DATA_CANID_MCU_FLT_WRONG_OFFSET_FAULT_OFFSET);
        messages.MCU_over_temperature_warning = (byte) (messages.MCU_over_temperature_warning - can.MCU_FAULT_DATA_CANID_MCU_OVER_TEMPERATURE_WARNING_OFFSET);
        messages.Motor_over_temperature_warning = (byte) (messages.Motor_over_temperature_warning - can.MCU_FAULT_DATA_CANID_MOTOR_OVER_TEMPERATURE_WARNING_OFFSET);
        messages.MCU_Unintended_Direction = (byte) (messages.MCU_Unintended_Direction - can.MCU_FAULT_DATA_CANID_MCU_UNINTENDED_DIRECTION_OFFSET);
        messages.Encoder_Failure = (byte) (messages.Encoder_Failure - can.MCU_FAULT_DATA_CANID_ENCODER_FAILURE_OFFSET);
        messages.DCbus_undervoltage = (byte) (messages.DCbus_undervoltage - can.MCU_FAULT_DATA_CANID_DCBUS_UNDERVOLTAGE_OFFSET);
        messages.DCbus_overvoltage = (byte) (messages.DCbus_overvoltage - can.MCU_FAULT_DATA_CANID_DCBUS_OVERVOLTAGE_OFFSET);
        messages.DCbus_overcurrent = (byte) (messages.DCbus_overcurrent - can.MCU_FAULT_DATA_CANID_DCBUS_OVERCURRENT_OFFSET);
        messages.MCU_Over_speed_fault = (byte) (messages.MCU_Over_speed_fault - can.MCU_FAULT_DATA_CANID_MCU_OVER_SPEED_FAULT_OFFSET);
        messages.Mcu_Flt_DCBus_Voltagesensor_STG = (byte) (messages.Mcu_Flt_DCBus_Voltagesensor_STG - can.MCU_FAULT_DATA_CANID_MCU_FLT_DCBUS_VOLTAGESENSOR_STG_OFFSET);
        messages.Mcu_Flt_DCBus_VoltgeSensor_STB = (byte) (messages.Mcu_Flt_DCBus_VoltgeSensor_STB - can.MCU_FAULT_DATA_CANID_MCU_FLT_DCBUS_VOLTGESENSOR_STB_OFFSET);
        messages.MCU_Flt_KL30_Sensor_STG = (byte) (messages.MCU_Flt_KL30_Sensor_STG - can.MCU_FAULT_DATA_CANID_MCU_FLT_KL30_SENSOR_STG_OFFSET);
        messages.MCU_Flt_KL30_Sensor_STB = (byte) (messages.MCU_Flt_KL30_Sensor_STB - can.MCU_FAULT_DATA_CANID_MCU_FLT_KL30_SENSOR_STB_OFFSET);
        messages.Mcu_Flt_BoardTempSensorSTG = (byte) (messages.Mcu_Flt_BoardTempSensorSTG - can.MCU_FAULT_DATA_CANID_MCU_FLT_BOARDTEMPSENSORSTG_OFFSET);
        messages.Mcu_Flt_BoardTempSensorSTB = (byte) (messages.Mcu_Flt_BoardTempSensorSTB - can.MCU_FAULT_DATA_CANID_MCU_FLT_BOARDTEMPSENSORSTB_OFFSET);
        messages.Mcu_Flt_RphaseSTG = (byte) (messages.Mcu_Flt_RphaseSTG - can.MCU_FAULT_DATA_CANID_MCU_FLT_RPHASESTG_OFFSET);
        messages.Mcu_Flt_RphaseSTB = (byte) (messages.Mcu_Flt_RphaseSTB - can.MCU_FAULT_DATA_CANID_MCU_FLT_RPHASESTB_OFFSET);
        messages.Loss_of_Tractioncontrol2msg = (byte) (messages.Loss_of_Tractioncontrol2msg - can.MCU_FAULT_DATA_CANID_LOSS_OF_TRACTIONCONTROL2MSG_OFFSET);
        messages.LV_supplyOvervoltage = (byte) (messages.LV_supplyOvervoltage - can.MCU_FAULT_DATA_CANID_LV_SUPPLYOVERVOLTAGE_OFFSET);
        messages.LV_supplyUndervoltage = (byte) (messages.LV_supplyUndervoltage - can.MCU_FAULT_DATA_CANID_LV_SUPPLYUNDERVOLTAGE_OFFSET);
        messages.Mcu_Flt_YphaseSTG = (byte) (messages.Mcu_Flt_YphaseSTG - can.MCU_FAULT_DATA_CANID_MCU_FLT_YPHASESTG_OFFSET);
        messages.Mcu_Flt_YphaseSTB = (byte) (messages.Mcu_Flt_YphaseSTB - can.MCU_FAULT_DATA_CANID_MCU_FLT_YPHASESTB_OFFSET);
        messages.Mcu_Flt_BphaseSTG = (byte) (messages.Mcu_Flt_BphaseSTG - can.MCU_FAULT_DATA_CANID_MCU_FLT_BPHASESTG_OFFSET);
        messages.Mcu_Flt_BphaseSTB = (byte) (messages.Mcu_Flt_BphaseSTB - can.MCU_FAULT_DATA_CANID_MCU_FLT_BPHASESTB_OFFSET);
        messages.MCU_Flt_MachineTempSensorSTB = (byte) (messages.MCU_Flt_MachineTempSensorSTB - can.MCU_FAULT_DATA_CANID_MCU_FLT_MACHINETEMPSENSORSTB_OFFSET);
        messages.MCU_Flt_MachineTempSensorSTG = (byte) (messages.MCU_Flt_MachineTempSensorSTG - can.MCU_FAULT_DATA_CANID_MCU_FLT_MACHINETEMPSENSORSTG_OFFSET);
        messages.Mcu_Flt_DCCurrentSensorSTG = (byte) (messages.Mcu_Flt_DCCurrentSensorSTG - can.MCU_FAULT_DATA_CANID_MCU_FLT_DCCURRENTSENSORSTG_OFFSET);
        messages.Mcu_Flt_DCCurrentSensorSTB = (byte) (messages.Mcu_Flt_DCCurrentSensorSTB - can.MCU_FAULT_DATA_CANID_MCU_FLT_DCCURRENTSENSORSTB_OFFSET);
        messages.Mcu_Flt_BuckConvert5V_overvolt = (byte) (messages.Mcu_Flt_BuckConvert5V_overvolt - can.MCU_FAULT_DATA_CANID_MCU_FLT_BUCKCONVERT5V_OVERVOLT_OFFSET);
        messages.Mcu_Flt_BuckConvert5v_undervolt = (byte) (messages.Mcu_Flt_BuckConvert5v_undervolt - can.MCU_FAULT_DATA_CANID_MCU_FLT_BUCKCONVERT5V_UNDERVOLT_OFFSET);
        messages.MCU_dio_over_volt_status = (byte) (messages.MCU_dio_over_volt_status - can.MCU_FAULT_DATA_CANID_MCU_DIO_OVER_VOLT_STATUS_OFFSET);
        messages.MCU_dio_over_curr_status = (byte) (messages.MCU_dio_over_curr_status - can.MCU_FAULT_DATA_CANID_MCU_DIO_OVER_CURR_STATUS_OFFSET);
        messages.MCU_dio_phase_ctrl_status = (byte) (messages.MCU_dio_phase_ctrl_status - can.MCU_FAULT_DATA_CANID_MCU_DIO_PHASE_CTRL_STATUS_OFFSET);
        messages.Mcu_Flt_MachineTemp_Low = (byte) (messages.Mcu_Flt_MachineTemp_Low - can.MCU_FAULT_DATA_CANID_MCU_FLT_MACHINETEMP_LOW_OFFSET);
        messages.Mcu_Flt_BoardTemp_Low = (byte) (messages.Mcu_Flt_BoardTemp_Low - can.MCU_FAULT_DATA_CANID_MCU_FLT_BOARDTEMP_LOW_OFFSET);
        messages.Mcu_Flt_Rotor_Stall = (byte) (messages.Mcu_Flt_Rotor_Stall - can.MCU_FAULT_DATA_CANID_MCU_FLT_ROTOR_STALL_OFFSET);
        messages.Mcu_Flt_MOSFET_HighTemp = (byte) (messages.Mcu_Flt_MOSFET_HighTemp - can.MCU_FAULT_DATA_CANID_MCU_FLT_MOSFET_HIGHTEMP_OFFSET);
        messages.MCU_Flt_MOSFET_STG = (byte) (messages.MCU_Flt_MOSFET_STG - can.MCU_FAULT_DATA_CANID_MCU_FLT_MOSFET_STG_OFFSET);
        messages.MCU_Flt_MOSFET_STB = (byte) (messages.MCU_Flt_MOSFET_STB - can.MCU_FAULT_DATA_CANID_MCU_FLT_MOSFET_STB_OFFSET);
        messages.Throttle_ideal_percentage_error = (byte) (messages.Throttle_ideal_percentage_error - can.MCU_FAULT_DATA_CANID_THROTTLE_IDEAL_PERCENTAGE_ERROR_OFFSET);
        data[0] = (byte) ((messages.MotorOC_protect_U_ph & (can.SIGNLE_READ_Mask1)) | ((messages.MotorOC_protect_V_ph & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MOTOROC_PROTECT_V_PH_MASK0) | ((messages.MotorOC_protect_W_ph & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MOTOROC_PROTECT_W_PH_MASK0) | ((messages.Mcu_Flt_Wrong_Offset_Fault & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_WRONG_OFFSET_FAULT_MASK0) | ((messages.MCU_over_temperature_warning & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_OVER_TEMPERATURE_WARNING_MASK0) | ((messages.Motor_over_temperature_warning & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MOTOR_OVER_TEMPERATURE_WARNING_MASK0) | ((messages.MCU_Unintended_Direction & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_UNINTENDED_DIRECTION_MASK0) | ((messages.Encoder_Failure & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_ENCODER_FAILURE_MASK0));
        data[1] = (byte) ((messages.DCbus_undervoltage & (can.SIGNLE_READ_Mask1)) | ((messages.DCbus_overvoltage & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_DCBUS_OVERVOLTAGE_MASK0) | ((messages.DCbus_overcurrent & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_DCBUS_OVERCURRENT_MASK0) | ((messages.MCU_Over_speed_fault & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_OVER_SPEED_FAULT_MASK0) | ((messages.Mcu_Flt_DCBus_Voltagesensor_STG & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_DCBUS_VOLTAGESENSOR_STG_MASK0) | ((messages.Mcu_Flt_DCBus_VoltgeSensor_STB & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_DCBUS_VOLTGESENSOR_STB_MASK0) | ((messages.MCU_Flt_KL30_Sensor_STG & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_KL30_SENSOR_STG_MASK0) | ((messages.MCU_Flt_KL30_Sensor_STB & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_KL30_SENSOR_STB_MASK0));
        data[2] = (byte) ((messages.Mcu_Flt_BoardTempSensorSTG & (can.SIGNLE_READ_Mask1)) | ((messages.Mcu_Flt_BoardTempSensorSTB & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_BOARDTEMPSENSORSTB_MASK0) | ((messages.Mcu_Flt_RphaseSTG & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_RPHASESTG_MASK0) | ((messages.Mcu_Flt_RphaseSTB & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_RPHASESTB_MASK0) | ((messages.Loss_of_Tractioncontrol2msg & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_LOSS_OF_TRACTIONCONTROL2MSG_MASK0) | ((messages.LV_supplyOvervoltage & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_LV_SUPPLYOVERVOLTAGE_MASK0) | ((messages.LV_supplyUndervoltage & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_LV_SUPPLYUNDERVOLTAGE_MASK0) | ((messages.Mcu_Flt_YphaseSTG & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_YPHASESTG_MASK0));
        data[3] = (byte) ((messages.Mcu_Flt_YphaseSTB & (can.SIGNLE_READ_Mask1)) | ((messages.Mcu_Flt_BphaseSTG & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_BPHASESTG_MASK0) | ((messages.Mcu_Flt_BphaseSTB & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_BPHASESTB_MASK0) | ((messages.MCU_Flt_MachineTempSensorSTB & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMPSENSORSTB_MASK0) | ((messages.MCU_Flt_MachineTempSensorSTG & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMPSENSORSTG_MASK0) | ((messages.Mcu_Flt_DCCurrentSensorSTG & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_DCCURRENTSENSORSTG_MASK0) | ((messages.Mcu_Flt_DCCurrentSensorSTB & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_DCCURRENTSENSORSTB_MASK0) | ((messages.Mcu_Flt_BuckConvert5V_overvolt & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_BUCKCONVERT5V_OVERVOLT_MASK0));
        data[4] = (byte) ((messages.Mcu_Flt_BuckConvert5v_undervolt & (can.SIGNLE_READ_Mask1)) | ((messages.MCU_dio_over_volt_status & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_DIO_OVER_VOLT_STATUS_MASK0) | ((messages.MCU_dio_over_curr_status & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_DIO_OVER_CURR_STATUS_MASK0) | ((messages.MCU_dio_phase_ctrl_status & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_DIO_PHASE_CTRL_STATUS_MASK0) | ((messages.Mcu_Flt_MachineTemp_Low & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMP_LOW_MASK0) | ((messages.Mcu_Flt_BoardTemp_Low & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_BOARDTEMP_LOW_MASK0) | ((messages.Mcu_Flt_Rotor_Stall & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_ROTOR_STALL_MASK0) | ((messages.Mcu_Flt_MOSFET_HighTemp & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_MOSFET_HIGHTEMP_MASK0));
        data[5] = (byte) ((messages.MCU_Flt_MOSFET_STG & (can.SIGNLE_READ_Mask1)) | ((messages.MCU_Flt_MOSFET_STB & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_MOSFET_STB_MASK0) | ((messages.Throttle_ideal_percentage_error & (can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_THROTTLE_IDEAL_PERCENTAGE_ERROR_MASK0));
        return can.MCU_FAULT_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Display_info(ConverterInitialize.Display_info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Side_Stand_Status = (byte) (((data[0] & (can.SIGNLE_READ_Mask3))) + (byte) (can.DISPLAY_INFO_CANID_SIDE_STAND_STATUS_OFFSET));
        messages.Display_SoC = (byte) ((((data[1] & (can.SIGNLE_READ_Mask3)) << can.DISPLAY_INFO_DISPLAY_SOC_MASK0) | ((data[0] >> can.DISPLAY_INFO_DISPLAY_SOC_MASK1) & (can.SIGNLE_READ_Mask5))) + (byte) (can.DISPLAY_INFO_CANID_DISPLAY_SOC_OFFSET));
        messages.Vehicle_Range = (byte) ((((data[2] & (can.SIGNLE_READ_Mask3)) << can.DISPLAY_INFO_VEHICLE_RANGE_MASK0) | ((data[1] >> can.DISPLAY_INFO_VEHICLE_RANGE_MASK1) & (can.SIGNLE_READ_Mask5))) + (byte) (can.DISPLAY_INFO_CANID_VEHICLE_RANGE_OFFSET));
        messages.Indicators_TTL = (byte) ((((data[2] >> can.DISPLAY_INFO_INDICATORS_TTL_MASK0) & (can.SIGNLE_READ_Mask4))) + (byte) (can.DISPLAY_INFO_CANID_INDICATORS_TTL_OFFSET));
        messages.FrontLight_TTL = (byte) ((((data[3] & (can.SIGNLE_READ_Mask3)) << can.DISPLAY_INFO_FRONTLIGHT_TTL_MASK0) | ((data[2] >> can.DISPLAY_INFO_FRONTLIGHT_TTL_MASK1) & (can.SIGNLE_READ_Mask1))) + (byte) (can.DISPLAY_INFO_CANID_FRONTLIGHT_TTL_OFFSET));
        messages.Charge_TTL = (byte) ((((data[3] >> can.DISPLAY_INFO_CHARGE_TTL_MASK0) & (can.SIGNLE_READ_Mask3))) + (byte) (can.DISPLAY_INFO_CANID_CHARGE_TTL_OFFSET));
        messages.DRL_Lamp_TTL = (byte) ((((data[3] >> can.DISPLAY_INFO_DRL_LAMP_TTL_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.DISPLAY_INFO_CANID_DRL_LAMP_TTL_OFFSET));
        messages.Low_Battery_Alert_TTL = (byte) ((((data[3] >> can.DISPLAY_INFO_LOW_BATTERY_ALERT_TTL_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.DISPLAY_INFO_CANID_LOW_BATTERY_ALERT_TTL_OFFSET));
        messages.Display_Vehicle_Speed = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.DISPLAY_INFO_DISPLAY_VEHICLE_SPEED_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.DISPLAY_INFO_CANID_DISPLAY_VEHICLE_SPEED_OFFSET));
        messages.Fog_Lamp_TTL = (byte) (((data[6] & (can.SIGNLE_READ_Mask1))) + (byte) (can.DISPLAY_INFO_CANID_FOG_LAMP_TTL_OFFSET));

        return can.DISPLAY_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Display_info(ConverterInitialize.Display_info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Side_Stand_Status = (byte) (messages.Side_Stand_Status - can.DISPLAY_INFO_CANID_SIDE_STAND_STATUS_OFFSET);
        messages.Display_SoC = (byte) (messages.Display_SoC - can.DISPLAY_INFO_CANID_DISPLAY_SOC_OFFSET);
        messages.Vehicle_Range = (byte) (messages.Vehicle_Range - can.DISPLAY_INFO_CANID_VEHICLE_RANGE_OFFSET);
        messages.Indicators_TTL = (byte) (messages.Indicators_TTL - can.DISPLAY_INFO_CANID_INDICATORS_TTL_OFFSET);
        messages.FrontLight_TTL = (byte) (messages.FrontLight_TTL - can.DISPLAY_INFO_CANID_FRONTLIGHT_TTL_OFFSET);
        messages.Charge_TTL = (byte) (messages.Charge_TTL - can.DISPLAY_INFO_CANID_CHARGE_TTL_OFFSET);
        messages.DRL_Lamp_TTL = (byte) (messages.DRL_Lamp_TTL - can.DISPLAY_INFO_CANID_DRL_LAMP_TTL_OFFSET);
        messages.Low_Battery_Alert_TTL = (byte) (messages.Low_Battery_Alert_TTL - can.DISPLAY_INFO_CANID_LOW_BATTERY_ALERT_TTL_OFFSET);
        messages.Display_Vehicle_Speed = (short) (messages.Display_Vehicle_Speed - can.DISPLAY_INFO_CANID_DISPLAY_VEHICLE_SPEED_OFFSET);
        messages.Fog_Lamp_TTL = (byte) (messages.Fog_Lamp_TTL - can.DISPLAY_INFO_CANID_FOG_LAMP_TTL_OFFSET);
        data[0] = (byte) ((messages.Side_Stand_Status & (can.SIGNLE_READ_Mask3)) | ((messages.Display_SoC & (can.SIGNLE_READ_Mask5)) << can.DISPLAY_INFO_DISPLAY_SOC_MASK1));
        data[1] = (byte) (((messages.Display_SoC >> can.DISPLAY_INFO_DISPLAY_SOC_MASK0) & (can.SIGNLE_READ_Mask3)) | ((messages.Vehicle_Range & (can.SIGNLE_READ_Mask5)) << can.DISPLAY_INFO_VEHICLE_RANGE_MASK1));
        data[2] = (byte) (((messages.Vehicle_Range >> can.DISPLAY_INFO_VEHICLE_RANGE_MASK0) & (can.SIGNLE_READ_Mask3)) | ((messages.Indicators_TTL & (can.SIGNLE_READ_Mask4)) << can.DISPLAY_INFO_INDICATORS_TTL_MASK0) | ((messages.FrontLight_TTL & (can.SIGNLE_READ_Mask1)) << can.DISPLAY_INFO_FRONTLIGHT_TTL_MASK1));
        data[3] = (byte) (((messages.FrontLight_TTL >> can.DISPLAY_INFO_FRONTLIGHT_TTL_MASK0) & (can.SIGNLE_READ_Mask3)) | ((messages.Charge_TTL & (can.SIGNLE_READ_Mask3)) << can.DISPLAY_INFO_CHARGE_TTL_MASK0) | ((messages.DRL_Lamp_TTL & (can.SIGNLE_READ_Mask1)) << can.DISPLAY_INFO_DRL_LAMP_TTL_MASK0) | ((messages.Low_Battery_Alert_TTL & (can.SIGNLE_READ_Mask1)) << can.DISPLAY_INFO_LOW_BATTERY_ALERT_TTL_MASK0));
        data[4] = (byte) ((messages.Display_Vehicle_Speed & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Display_Vehicle_Speed >> can.DISPLAY_INFO_DISPLAY_VEHICLE_SPEED_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Fog_Lamp_TTL & (can.SIGNLE_READ_Mask1)));
        return can.DISPLAY_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Environment_Data(ConverterInitialize.Environment_Data_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Ambient_Light_Sensor_Value = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.ENVIRONMENT_DATA_AMBIENT_LIGHT_SENSOR_VALUE_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.ENVIRONMENT_DATA_CANID_AMBIENT_LIGHT_SENSOR_VALUE_OFFSET));
        messages.Ambient_Temp_Sensor_Value = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.ENVIRONMENT_DATA_AMBIENT_TEMP_SENSOR_VALUE_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.ENVIRONMENT_DATA_CANID_AMBIENT_TEMP_SENSOR_VALUE_OFFSET));

        return can.ENVIRONMENT_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Environment_Data(ConverterInitialize.Environment_Data_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Ambient_Light_Sensor_Value = (short) (messages.Ambient_Light_Sensor_Value - can.ENVIRONMENT_DATA_CANID_AMBIENT_LIGHT_SENSOR_VALUE_OFFSET);
        messages.Ambient_Temp_Sensor_Value = (short) (messages.Ambient_Temp_Sensor_Value - can.ENVIRONMENT_DATA_CANID_AMBIENT_TEMP_SENSOR_VALUE_OFFSET);
        data[0] = (byte) ((messages.Ambient_Light_Sensor_Value & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Ambient_Light_Sensor_Value >> can.ENVIRONMENT_DATA_AMBIENT_LIGHT_SENSOR_VALUE_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Ambient_Temp_Sensor_Value & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Ambient_Temp_Sensor_Value >> can.ENVIRONMENT_DATA_AMBIENT_TEMP_SENSOR_VALUE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ENVIRONMENT_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_Fault_1(ConverterInitialize.BMS_Fault_1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_V_Sensor_Failure_Cell1 = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL1_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell2 = (byte) ((((data[0] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL2_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL2_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell3 = (byte) ((((data[0] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL3_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL3_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell4 = (byte) ((((data[0] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL4_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL4_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell5 = (byte) ((((data[0] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL5_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL5_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell6 = (byte) ((((data[0] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL6_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL6_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell7 = (byte) ((((data[0] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL7_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL7_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell8 = (byte) ((((data[0] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL8_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL8_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell9 = (byte) (((data[1] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL9_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell10 = (byte) ((((data[1] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL10_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL10_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell11 = (byte) ((((data[1] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL11_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL11_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell12 = (byte) ((((data[1] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL12_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL12_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell13 = (byte) ((((data[1] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL13_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL13_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell14 = (byte) ((((data[1] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL14_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL14_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell15 = (byte) ((((data[1] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL15_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL15_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell16 = (byte) ((((data[1] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL16_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL16_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell17 = (byte) (((data[2] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL17_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell18 = (byte) ((((data[2] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL18_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL18_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell19 = (byte) ((((data[2] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL19_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL19_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell20 = (byte) ((((data[2] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL20_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL20_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell21 = (byte) ((((data[2] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL21_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL21_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell22 = (byte) ((((data[2] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL22_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL22_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell23 = (byte) ((((data[2] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL23_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL23_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell24 = (byte) ((((data[2] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL24_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL24_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell25 = (byte) (((data[3] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL25_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell26 = (byte) ((((data[3] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL26_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL26_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell27 = (byte) ((((data[3] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL27_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL27_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell28 = (byte) ((((data[3] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL28_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL28_OFFSET));
        messages.BMS_V_Out_of_Range_Cell1 = (byte) ((((data[3] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL1_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL1_OFFSET));
        messages.BMS_V_Out_of_Range_Cell2 = (byte) ((((data[3] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL2_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL2_OFFSET));
        messages.BMS_V_Out_of_Range_Cell3 = (byte) ((((data[3] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL3_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL3_OFFSET));
        messages.BMS_V_Out_of_Range_Cell4 = (byte) ((((data[3] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL4_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL4_OFFSET));
        messages.BMS_V_Out_of_Range_Cell5 = (byte) (((data[4] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL5_OFFSET));
        messages.BMS_V_Out_of_Range_Cell6 = (byte) ((((data[4] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL6_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL6_OFFSET));
        messages.BMS_V_Out_of_Range_Cell7 = (byte) ((((data[4] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL7_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL7_OFFSET));
        messages.BMS_V_Out_of_Range_Cell8 = (byte) ((((data[4] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL8_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL8_OFFSET));
        messages.BMS_V_Out_of_Range_Cell9 = (byte) ((((data[4] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL9_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL9_OFFSET));
        messages.BMS_V_Out_of_Range_Cell10 = (byte) ((((data[4] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL10_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL10_OFFSET));
        messages.BMS_V_Out_of_Range_Cell11 = (byte) ((((data[4] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL11_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL11_OFFSET));
        messages.BMS_V_Out_of_Range_Cell12 = (byte) ((((data[4] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL12_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL12_OFFSET));
        messages.BMS_V_Out_of_Range_Cell13 = (byte) (((data[5] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL13_OFFSET));
        messages.BMS_V_Out_of_Range_Cell14 = (byte) ((((data[5] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL14_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL14_OFFSET));
        messages.BMS_V_Out_of_Range_Cell15 = (byte) ((((data[5] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL15_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL15_OFFSET));
        messages.BMS_V_Out_of_Range_Cell16 = (byte) ((((data[5] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL16_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL16_OFFSET));
        messages.BMS_V_Out_of_Range_Cell17 = (byte) ((((data[5] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL17_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL17_OFFSET));
        messages.BMS_V_Out_of_Range_Cell18 = (byte) ((((data[5] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL18_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL18_OFFSET));
        messages.BMS_V_Out_of_Range_Cell19 = (byte) ((((data[5] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL19_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL19_OFFSET));
        messages.BMS_V_Out_of_Range_Cell20 = (byte) ((((data[5] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL20_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL20_OFFSET));
        messages.BMS_V_Out_of_Range_Cell21 = (byte) (((data[6] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL21_OFFSET));
        messages.BMS_V_Out_of_Range_Cell22 = (byte) ((((data[6] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL22_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL22_OFFSET));
        messages.BMS_V_Out_of_Range_Cell23 = (byte) ((((data[6] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL23_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL23_OFFSET));
        messages.BMS_V_Out_of_Range_Cell24 = (byte) ((((data[6] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL24_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL24_OFFSET));
        messages.BMS_V_Out_of_Range_Cell25 = (byte) ((((data[6] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL25_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL25_OFFSET));
        messages.BMS_V_Out_of_Range_Cell26 = (byte) ((((data[6] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL26_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL26_OFFSET));
        messages.BMS_V_Out_of_Range_Cell27 = (byte) ((((data[6] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL27_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL27_OFFSET));
        messages.BMS_V_Out_of_Range_Cell28 = (byte) ((((data[6] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL28_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL28_OFFSET));
        messages.BMS_BatteryPackTemp_1_SensFail = (byte) (((data[7] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_1_SENSFAIL_OFFSET));
        messages.BMS_BatteryPackTemp_2_SensFail = (byte) ((((data[7] >> can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_2_SENSFAIL_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_2_SENSFAIL_OFFSET));
        messages.BMS_BatteryPackTemp_3_SensFail = (byte) ((((data[7] >> can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_3_SENSFAIL_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_3_SENSFAIL_OFFSET));
        messages.BMS_BatteryPackTemp_4_SensFail = (byte) ((((data[7] >> can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_4_SENSFAIL_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_4_SENSFAIL_OFFSET));
        messages.BMS_BatteryPackTemp_5_SensFail = (byte) ((((data[7] >> can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_5_SENSFAIL_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_5_SENSFAIL_OFFSET));
        messages.BMS_BatteryPackTemp_6_SensFail = (byte) ((((data[7] >> can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_6_SENSFAIL_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_6_SENSFAIL_OFFSET));

        return can.BMS_FAULT_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_Fault_1(ConverterInitialize.BMS_Fault_1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_V_Sensor_Failure_Cell1 = (byte) (messages.BMS_V_Sensor_Failure_Cell1 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL1_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell2 = (byte) (messages.BMS_V_Sensor_Failure_Cell2 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL2_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell3 = (byte) (messages.BMS_V_Sensor_Failure_Cell3 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL3_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell4 = (byte) (messages.BMS_V_Sensor_Failure_Cell4 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL4_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell5 = (byte) (messages.BMS_V_Sensor_Failure_Cell5 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL5_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell6 = (byte) (messages.BMS_V_Sensor_Failure_Cell6 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL6_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell7 = (byte) (messages.BMS_V_Sensor_Failure_Cell7 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL7_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell8 = (byte) (messages.BMS_V_Sensor_Failure_Cell8 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL8_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell9 = (byte) (messages.BMS_V_Sensor_Failure_Cell9 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL9_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell10 = (byte) (messages.BMS_V_Sensor_Failure_Cell10 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL10_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell11 = (byte) (messages.BMS_V_Sensor_Failure_Cell11 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL11_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell12 = (byte) (messages.BMS_V_Sensor_Failure_Cell12 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL12_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell13 = (byte) (messages.BMS_V_Sensor_Failure_Cell13 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL13_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell14 = (byte) (messages.BMS_V_Sensor_Failure_Cell14 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL14_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell15 = (byte) (messages.BMS_V_Sensor_Failure_Cell15 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL15_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell16 = (byte) (messages.BMS_V_Sensor_Failure_Cell16 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL16_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell17 = (byte) (messages.BMS_V_Sensor_Failure_Cell17 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL17_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell18 = (byte) (messages.BMS_V_Sensor_Failure_Cell18 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL18_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell19 = (byte) (messages.BMS_V_Sensor_Failure_Cell19 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL19_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell20 = (byte) (messages.BMS_V_Sensor_Failure_Cell20 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL20_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell21 = (byte) (messages.BMS_V_Sensor_Failure_Cell21 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL21_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell22 = (byte) (messages.BMS_V_Sensor_Failure_Cell22 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL22_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell23 = (byte) (messages.BMS_V_Sensor_Failure_Cell23 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL23_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell24 = (byte) (messages.BMS_V_Sensor_Failure_Cell24 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL24_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell25 = (byte) (messages.BMS_V_Sensor_Failure_Cell25 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL25_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell26 = (byte) (messages.BMS_V_Sensor_Failure_Cell26 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL26_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell27 = (byte) (messages.BMS_V_Sensor_Failure_Cell27 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL27_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell28 = (byte) (messages.BMS_V_Sensor_Failure_Cell28 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL28_OFFSET);
        messages.BMS_V_Out_of_Range_Cell1 = (byte) (messages.BMS_V_Out_of_Range_Cell1 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL1_OFFSET);
        messages.BMS_V_Out_of_Range_Cell2 = (byte) (messages.BMS_V_Out_of_Range_Cell2 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL2_OFFSET);
        messages.BMS_V_Out_of_Range_Cell3 = (byte) (messages.BMS_V_Out_of_Range_Cell3 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL3_OFFSET);
        messages.BMS_V_Out_of_Range_Cell4 = (byte) (messages.BMS_V_Out_of_Range_Cell4 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL4_OFFSET);
        messages.BMS_V_Out_of_Range_Cell5 = (byte) (messages.BMS_V_Out_of_Range_Cell5 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL5_OFFSET);
        messages.BMS_V_Out_of_Range_Cell6 = (byte) (messages.BMS_V_Out_of_Range_Cell6 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL6_OFFSET);
        messages.BMS_V_Out_of_Range_Cell7 = (byte) (messages.BMS_V_Out_of_Range_Cell7 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL7_OFFSET);
        messages.BMS_V_Out_of_Range_Cell8 = (byte) (messages.BMS_V_Out_of_Range_Cell8 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL8_OFFSET);
        messages.BMS_V_Out_of_Range_Cell9 = (byte) (messages.BMS_V_Out_of_Range_Cell9 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL9_OFFSET);
        messages.BMS_V_Out_of_Range_Cell10 = (byte) (messages.BMS_V_Out_of_Range_Cell10 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL10_OFFSET);
        messages.BMS_V_Out_of_Range_Cell11 = (byte) (messages.BMS_V_Out_of_Range_Cell11 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL11_OFFSET);
        messages.BMS_V_Out_of_Range_Cell12 = (byte) (messages.BMS_V_Out_of_Range_Cell12 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL12_OFFSET);
        messages.BMS_V_Out_of_Range_Cell13 = (byte) (messages.BMS_V_Out_of_Range_Cell13 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL13_OFFSET);
        messages.BMS_V_Out_of_Range_Cell14 = (byte) (messages.BMS_V_Out_of_Range_Cell14 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL14_OFFSET);
        messages.BMS_V_Out_of_Range_Cell15 = (byte) (messages.BMS_V_Out_of_Range_Cell15 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL15_OFFSET);
        messages.BMS_V_Out_of_Range_Cell16 = (byte) (messages.BMS_V_Out_of_Range_Cell16 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL16_OFFSET);
        messages.BMS_V_Out_of_Range_Cell17 = (byte) (messages.BMS_V_Out_of_Range_Cell17 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL17_OFFSET);
        messages.BMS_V_Out_of_Range_Cell18 = (byte) (messages.BMS_V_Out_of_Range_Cell18 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL18_OFFSET);
        messages.BMS_V_Out_of_Range_Cell19 = (byte) (messages.BMS_V_Out_of_Range_Cell19 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL19_OFFSET);
        messages.BMS_V_Out_of_Range_Cell20 = (byte) (messages.BMS_V_Out_of_Range_Cell20 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL20_OFFSET);
        messages.BMS_V_Out_of_Range_Cell21 = (byte) (messages.BMS_V_Out_of_Range_Cell21 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL21_OFFSET);
        messages.BMS_V_Out_of_Range_Cell22 = (byte) (messages.BMS_V_Out_of_Range_Cell22 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL22_OFFSET);
        messages.BMS_V_Out_of_Range_Cell23 = (byte) (messages.BMS_V_Out_of_Range_Cell23 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL23_OFFSET);
        messages.BMS_V_Out_of_Range_Cell24 = (byte) (messages.BMS_V_Out_of_Range_Cell24 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL24_OFFSET);
        messages.BMS_V_Out_of_Range_Cell25 = (byte) (messages.BMS_V_Out_of_Range_Cell25 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL25_OFFSET);
        messages.BMS_V_Out_of_Range_Cell26 = (byte) (messages.BMS_V_Out_of_Range_Cell26 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL26_OFFSET);
        messages.BMS_V_Out_of_Range_Cell27 = (byte) (messages.BMS_V_Out_of_Range_Cell27 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL27_OFFSET);
        messages.BMS_V_Out_of_Range_Cell28 = (byte) (messages.BMS_V_Out_of_Range_Cell28 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL28_OFFSET);
        messages.BMS_BatteryPackTemp_1_SensFail = (byte) (messages.BMS_BatteryPackTemp_1_SensFail - can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_1_SENSFAIL_OFFSET);
        messages.BMS_BatteryPackTemp_2_SensFail = (byte) (messages.BMS_BatteryPackTemp_2_SensFail - can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_2_SENSFAIL_OFFSET);
        messages.BMS_BatteryPackTemp_3_SensFail = (byte) (messages.BMS_BatteryPackTemp_3_SensFail - can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_3_SENSFAIL_OFFSET);
        messages.BMS_BatteryPackTemp_4_SensFail = (byte) (messages.BMS_BatteryPackTemp_4_SensFail - can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_4_SENSFAIL_OFFSET);
        messages.BMS_BatteryPackTemp_5_SensFail = (byte) (messages.BMS_BatteryPackTemp_5_SensFail - can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_5_SENSFAIL_OFFSET);
        messages.BMS_BatteryPackTemp_6_SensFail = (byte) (messages.BMS_BatteryPackTemp_6_SensFail - can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_6_SENSFAIL_OFFSET);
        data[0] = (byte) ((messages.BMS_V_Sensor_Failure_Cell1 & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_V_Sensor_Failure_Cell2 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL2_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell3 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL3_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell4 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL4_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell5 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL5_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell6 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL6_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell7 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL7_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell8 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL8_MASK0));
        data[1] = (byte) ((messages.BMS_V_Sensor_Failure_Cell9 & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_V_Sensor_Failure_Cell10 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL10_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell11 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL11_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell12 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL12_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell13 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL13_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell14 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL14_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell15 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL15_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell16 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL16_MASK0));
        data[2] = (byte) ((messages.BMS_V_Sensor_Failure_Cell17 & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_V_Sensor_Failure_Cell18 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL18_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell19 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL19_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell20 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL20_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell21 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL21_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell22 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL22_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell23 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL23_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell24 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL24_MASK0));
        data[3] = (byte) ((messages.BMS_V_Sensor_Failure_Cell25 & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_V_Sensor_Failure_Cell26 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL26_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell27 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL27_MASK0) | ((messages.BMS_V_Sensor_Failure_Cell28 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL28_MASK0) | ((messages.BMS_V_Out_of_Range_Cell1 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL1_MASK0) | ((messages.BMS_V_Out_of_Range_Cell2 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL2_MASK0) | ((messages.BMS_V_Out_of_Range_Cell3 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL3_MASK0) | ((messages.BMS_V_Out_of_Range_Cell4 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL4_MASK0));
        data[4] = (byte) ((messages.BMS_V_Out_of_Range_Cell5 & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_V_Out_of_Range_Cell6 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL6_MASK0) | ((messages.BMS_V_Out_of_Range_Cell7 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL7_MASK0) | ((messages.BMS_V_Out_of_Range_Cell8 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL8_MASK0) | ((messages.BMS_V_Out_of_Range_Cell9 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL9_MASK0) | ((messages.BMS_V_Out_of_Range_Cell10 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL10_MASK0) | ((messages.BMS_V_Out_of_Range_Cell11 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL11_MASK0) | ((messages.BMS_V_Out_of_Range_Cell12 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL12_MASK0));
        data[5] = (byte) ((messages.BMS_V_Out_of_Range_Cell13 & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_V_Out_of_Range_Cell14 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL14_MASK0) | ((messages.BMS_V_Out_of_Range_Cell15 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL15_MASK0) | ((messages.BMS_V_Out_of_Range_Cell16 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL16_MASK0) | ((messages.BMS_V_Out_of_Range_Cell17 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL17_MASK0) | ((messages.BMS_V_Out_of_Range_Cell18 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL18_MASK0) | ((messages.BMS_V_Out_of_Range_Cell19 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL19_MASK0) | ((messages.BMS_V_Out_of_Range_Cell20 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL20_MASK0));
        data[6] = (byte) ((messages.BMS_V_Out_of_Range_Cell21 & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_V_Out_of_Range_Cell22 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL22_MASK0) | ((messages.BMS_V_Out_of_Range_Cell23 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL23_MASK0) | ((messages.BMS_V_Out_of_Range_Cell24 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL24_MASK0) | ((messages.BMS_V_Out_of_Range_Cell25 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL25_MASK0) | ((messages.BMS_V_Out_of_Range_Cell26 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL26_MASK0) | ((messages.BMS_V_Out_of_Range_Cell27 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL27_MASK0) | ((messages.BMS_V_Out_of_Range_Cell28 & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL28_MASK0));
        data[7] = (byte) ((messages.BMS_BatteryPackTemp_1_SensFail & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_BatteryPackTemp_2_SensFail & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_2_SENSFAIL_MASK0) | ((messages.BMS_BatteryPackTemp_3_SensFail & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_3_SENSFAIL_MASK0) | ((messages.BMS_BatteryPackTemp_4_SensFail & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_4_SENSFAIL_MASK0) | ((messages.BMS_BatteryPackTemp_5_SensFail & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_5_SENSFAIL_MASK0) | ((messages.BMS_BatteryPackTemp_6_SensFail & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_6_SENSFAIL_MASK0));
        return can.BMS_FAULT_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_Fault_2(ConverterInitialize.BMS_Fault_2_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_LowTempCharge_Error = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_LOWTEMPCHARGE_ERROR_OFFSET));
        messages.BMS_LowTempDrive_Warning = (byte) ((((data[0] >> can.BMS_FAULT_2_BMS_LOWTEMPDRIVE_WARNING_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_LOWTEMPDRIVE_WARNING_OFFSET));
        messages.BMS_LowTempDrive_Error = (byte) ((((data[0] >> can.BMS_FAULT_2_BMS_LOWTEMPDRIVE_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_LOWTEMPDRIVE_ERROR_OFFSET));
        messages.OverTimetoFastCharge_Error = (byte) ((((data[0] >> can.BMS_FAULT_2_OVERTIMETOFASTCHARGE_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_OVERTIMETOFASTCHARGE_ERROR_OFFSET));
        messages.Battery_Discharge_Inhibit = (byte) ((((data[0] >> can.BMS_FAULT_2_BATTERY_DISCHARGE_INHIBIT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BATTERY_DISCHARGE_INHIBIT_OFFSET));
        messages.Battery_Derate_Drive_Cur_Flag = (byte) ((((data[0] >> can.BMS_FAULT_2_BATTERY_DERATE_DRIVE_CUR_FLAG_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BATTERY_DERATE_DRIVE_CUR_FLAG_OFFSET));
        messages.Battery_Derate_Charge_Cur_Flag = (byte) ((((data[0] >> can.BMS_FAULT_2_BATTERY_DERATE_CHARGE_CUR_FLAG_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BATTERY_DERATE_CHARGE_CUR_FLAG_OFFSET));
        messages.Battery_Inhibit_regen_Fault = (byte) ((((data[0] >> can.BMS_FAULT_2_BATTERY_INHIBIT_REGEN_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BATTERY_INHIBIT_REGEN_FAULT_OFFSET));
        messages.Battery_Volt_Deviation_Error = (byte) (((data[1] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BATTERY_VOLT_DEVIATION_ERROR_OFFSET));
        messages.BMS_Batt_PackTemp_1_OutofRange = (byte) ((((data[1] >> can.BMS_FAULT_2_BMS_BATT_PACKTEMP_1_OUTOFRANGE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_1_OUTOFRANGE_OFFSET));
        messages.BMS_Batt_PackTemp_2_OutofRange = (byte) ((((data[1] >> can.BMS_FAULT_2_BMS_BATT_PACKTEMP_2_OUTOFRANGE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_2_OUTOFRANGE_OFFSET));
        messages.BMS_Batt_PackTemp_3_OutofRange = (byte) ((((data[1] >> can.BMS_FAULT_2_BMS_BATT_PACKTEMP_3_OUTOFRANGE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_3_OUTOFRANGE_OFFSET));
        messages.BMS_Batt_PackTemp_4_OutofRange = (byte) ((((data[1] >> can.BMS_FAULT_2_BMS_BATT_PACKTEMP_4_OUTOFRANGE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_4_OUTOFRANGE_OFFSET));
        messages.BMS_Batt_PackTemp_5_OutofRange = (byte) ((((data[1] >> can.BMS_FAULT_2_BMS_BATT_PACKTEMP_5_OUTOFRANGE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_5_OUTOFRANGE_OFFSET));
        messages.BMS_Batt_PackTemp_6_OutofRange = (byte) ((((data[1] >> can.BMS_FAULT_2_BMS_BATT_PACKTEMP_6_OUTOFRANGE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_6_OUTOFRANGE_OFFSET));
        messages.BMS_Curr_Sens_Failure_OpenCir = (byte) ((((data[1] >> can.BMS_FAULT_2_BMS_CURR_SENS_FAILURE_OPENCIR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_CURR_SENS_FAILURE_OPENCIR_OFFSET));
        messages.BMS_Curr_Sens_Failure_ShortCir = (byte) (((data[2] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_CURR_SENS_FAILURE_SHORTCIR_OFFSET));
        messages.BMS_OverCurrCharge_Warn = (byte) ((((data[2] >> can.BMS_FAULT_2_BMS_OVERCURRCHARGE_WARN_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_OVERCURRCHARGE_WARN_OFFSET));
        messages.BMS_OverCurrCharge_Error = (byte) ((((data[2] >> can.BMS_FAULT_2_BMS_OVERCURRCHARGE_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_OVERCURRCHARGE_ERROR_OFFSET));
        messages.BMS_PreChargeTooFast_Info = (byte) ((((data[2] >> can.BMS_FAULT_2_BMS_PRECHARGETOOFAST_INFO_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_PRECHARGETOOFAST_INFO_OFFSET));
        messages.BMS_PreChargeTooSlow_Info = (byte) ((((data[2] >> can.BMS_FAULT_2_BMS_PRECHARGETOOSLOW_INFO_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_PRECHARGETOOSLOW_INFO_OFFSET));
        messages.BMS_PreChargeFailure = (byte) ((((data[2] >> can.BMS_FAULT_2_BMS_PRECHARGEFAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_PRECHARGEFAILURE_OFFSET));
        messages.BMS_MOSFETsConnFailed = (byte) ((((data[2] >> can.BMS_FAULT_2_BMS_MOSFETSCONNFAILED_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_MOSFETSCONNFAILED_OFFSET));
        messages.BMS_MOSFETsDisconnFailed = (byte) ((((data[2] >> can.BMS_FAULT_2_BMS_MOSFETSDISCONNFAILED_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_MOSFETSDISCONNFAILED_OFFSET));
        messages.BMS_PDU_TempWarn_Info = (byte) (((data[3] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_PDU_TEMPWARN_INFO_OFFSET));
        messages.BMS_PDU_Temp_Error = (byte) ((((data[3] >> can.BMS_FAULT_2_BMS_PDU_TEMP_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_PDU_TEMP_ERROR_OFFSET));
        messages.BMS_OverVChargeWarnInfo = (byte) ((((data[3] >> can.BMS_FAULT_2_BMS_OVERVCHARGEWARNINFO_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_OVERVCHARGEWARNINFO_OFFSET));
        messages.BMS_OverVChargeError = (byte) ((((data[3] >> can.BMS_FAULT_2_BMS_OVERVCHARGEERROR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_OVERVCHARGEERROR_OFFSET));
        messages.BMS_OverVChar_Perm_Fault = (byte) ((((data[3] >> can.BMS_FAULT_2_BMS_OVERVCHAR_PERM_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_OVERVCHAR_PERM_FAULT_OFFSET));
        messages.BMS_OverV_Regen_Warn_Info = (byte) ((((data[3] >> can.BMS_FAULT_2_BMS_OVERV_REGEN_WARN_INFO_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_OVERV_REGEN_WARN_INFO_OFFSET));
        messages.BMS_OverV_Regen_Error = (byte) ((((data[3] >> can.BMS_FAULT_2_BMS_OVERV_REGEN_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_OVERV_REGEN_ERROR_OFFSET));
        messages.BMS_UndV_Warn_Info = (byte) ((((data[3] >> can.BMS_FAULT_2_BMS_UNDV_WARN_INFO_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_UNDV_WARN_INFO_OFFSET));
        messages.BMS_UndV_Error = (byte) (((data[4] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_UNDV_ERROR_OFFSET));
        messages.BMS_UndV_Perm_fault = (byte) ((((data[4] >> can.BMS_FAULT_2_BMS_UNDV_PERM_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_UNDV_PERM_FAULT_OFFSET));
        messages.BMS_OverTempCharWarnInfo = (byte) ((((data[4] >> can.BMS_FAULT_2_BMS_OVERTEMPCHARWARNINFO_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_OVERTEMPCHARWARNINFO_OFFSET));
        messages.BMS_OverTempCharError = (byte) ((((data[4] >> can.BMS_FAULT_2_BMS_OVERTEMPCHARERROR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_OVERTEMPCHARERROR_OFFSET));
        messages.BMS_OverTempDriveWarnInfo = (byte) ((((data[4] >> can.BMS_FAULT_2_BMS_OVERTEMPDRIVEWARNINFO_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_OVERTEMPDRIVEWARNINFO_OFFSET));
        messages.BMS_OverTempDriveError = (byte) ((((data[4] >> can.BMS_FAULT_2_BMS_OVERTEMPDRIVEERROR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_OVERTEMPDRIVEERROR_OFFSET));
        messages.BMS_OvTemp_CellVentError = (byte) ((((data[4] >> can.BMS_FAULT_2_BMS_OVTEMP_CELLVENTERROR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_OVTEMP_CELLVENTERROR_OFFSET));
        messages.BMS_OvTemp_CellVentFailure = (byte) ((((data[4] >> can.BMS_FAULT_2_BMS_OVTEMP_CELLVENTFAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_OVTEMP_CELLVENTFAILURE_OFFSET));
        messages.BMS_ShortCir_DetectError = (byte) (((data[5] & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_SHORTCIR_DETECTERROR_OFFSET));
        messages.BMS_ShortCir_Detect_PermFault = (byte) ((((data[5] >> can.BMS_FAULT_2_BMS_SHORTCIR_DETECT_PERMFAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_SHORTCIR_DETECT_PERMFAULT_OFFSET));
        messages.BMS_Cell_Failure_PermFault = (byte) ((((data[5] >> can.BMS_FAULT_2_BMS_CELL_FAILURE_PERMFAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_CELL_FAILURE_PERMFAULT_OFFSET));
        messages.BMS_ParaCell_DisconFault = (byte) ((((data[5] >> can.BMS_FAULT_2_BMS_PARACELL_DISCONFAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_PARACELL_DISCONFAULT_OFFSET));
        messages.BMS_LowTemp_CharWarnInfo = (byte) ((((data[5] >> can.BMS_FAULT_2_BMS_LOWTEMP_CHARWARNINFO_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.BMS_FAULT_2_CANID_BMS_LOWTEMP_CHARWARNINFO_OFFSET));

        return can.BMS_FAULT_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_Fault_2(ConverterInitialize.BMS_Fault_2_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_LowTempCharge_Error = (byte) (messages.BMS_LowTempCharge_Error - can.BMS_FAULT_2_CANID_BMS_LOWTEMPCHARGE_ERROR_OFFSET);
        messages.BMS_LowTempDrive_Warning = (byte) (messages.BMS_LowTempDrive_Warning - can.BMS_FAULT_2_CANID_BMS_LOWTEMPDRIVE_WARNING_OFFSET);
        messages.BMS_LowTempDrive_Error = (byte) (messages.BMS_LowTempDrive_Error - can.BMS_FAULT_2_CANID_BMS_LOWTEMPDRIVE_ERROR_OFFSET);
        messages.OverTimetoFastCharge_Error = (byte) (messages.OverTimetoFastCharge_Error - can.BMS_FAULT_2_CANID_OVERTIMETOFASTCHARGE_ERROR_OFFSET);
        messages.Battery_Discharge_Inhibit = (byte) (messages.Battery_Discharge_Inhibit - can.BMS_FAULT_2_CANID_BATTERY_DISCHARGE_INHIBIT_OFFSET);
        messages.Battery_Derate_Drive_Cur_Flag = (byte) (messages.Battery_Derate_Drive_Cur_Flag - can.BMS_FAULT_2_CANID_BATTERY_DERATE_DRIVE_CUR_FLAG_OFFSET);
        messages.Battery_Derate_Charge_Cur_Flag = (byte) (messages.Battery_Derate_Charge_Cur_Flag - can.BMS_FAULT_2_CANID_BATTERY_DERATE_CHARGE_CUR_FLAG_OFFSET);
        messages.Battery_Inhibit_regen_Fault = (byte) (messages.Battery_Inhibit_regen_Fault - can.BMS_FAULT_2_CANID_BATTERY_INHIBIT_REGEN_FAULT_OFFSET);
        messages.Battery_Volt_Deviation_Error = (byte) (messages.Battery_Volt_Deviation_Error - can.BMS_FAULT_2_CANID_BATTERY_VOLT_DEVIATION_ERROR_OFFSET);
        messages.BMS_Batt_PackTemp_1_OutofRange = (byte) (messages.BMS_Batt_PackTemp_1_OutofRange - can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_1_OUTOFRANGE_OFFSET);
        messages.BMS_Batt_PackTemp_2_OutofRange = (byte) (messages.BMS_Batt_PackTemp_2_OutofRange - can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_2_OUTOFRANGE_OFFSET);
        messages.BMS_Batt_PackTemp_3_OutofRange = (byte) (messages.BMS_Batt_PackTemp_3_OutofRange - can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_3_OUTOFRANGE_OFFSET);
        messages.BMS_Batt_PackTemp_4_OutofRange = (byte) (messages.BMS_Batt_PackTemp_4_OutofRange - can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_4_OUTOFRANGE_OFFSET);
        messages.BMS_Batt_PackTemp_5_OutofRange = (byte) (messages.BMS_Batt_PackTemp_5_OutofRange - can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_5_OUTOFRANGE_OFFSET);
        messages.BMS_Batt_PackTemp_6_OutofRange = (byte) (messages.BMS_Batt_PackTemp_6_OutofRange - can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_6_OUTOFRANGE_OFFSET);
        messages.BMS_Curr_Sens_Failure_OpenCir = (byte) (messages.BMS_Curr_Sens_Failure_OpenCir - can.BMS_FAULT_2_CANID_BMS_CURR_SENS_FAILURE_OPENCIR_OFFSET);
        messages.BMS_Curr_Sens_Failure_ShortCir = (byte) (messages.BMS_Curr_Sens_Failure_ShortCir - can.BMS_FAULT_2_CANID_BMS_CURR_SENS_FAILURE_SHORTCIR_OFFSET);
        messages.BMS_OverCurrCharge_Warn = (byte) (messages.BMS_OverCurrCharge_Warn - can.BMS_FAULT_2_CANID_BMS_OVERCURRCHARGE_WARN_OFFSET);
        messages.BMS_OverCurrCharge_Error = (byte) (messages.BMS_OverCurrCharge_Error - can.BMS_FAULT_2_CANID_BMS_OVERCURRCHARGE_ERROR_OFFSET);
        messages.BMS_PreChargeTooFast_Info = (byte) (messages.BMS_PreChargeTooFast_Info - can.BMS_FAULT_2_CANID_BMS_PRECHARGETOOFAST_INFO_OFFSET);
        messages.BMS_PreChargeTooSlow_Info = (byte) (messages.BMS_PreChargeTooSlow_Info - can.BMS_FAULT_2_CANID_BMS_PRECHARGETOOSLOW_INFO_OFFSET);
        messages.BMS_PreChargeFailure = (byte) (messages.BMS_PreChargeFailure - can.BMS_FAULT_2_CANID_BMS_PRECHARGEFAILURE_OFFSET);
        messages.BMS_MOSFETsConnFailed = (byte) (messages.BMS_MOSFETsConnFailed - can.BMS_FAULT_2_CANID_BMS_MOSFETSCONNFAILED_OFFSET);
        messages.BMS_MOSFETsDisconnFailed = (byte) (messages.BMS_MOSFETsDisconnFailed - can.BMS_FAULT_2_CANID_BMS_MOSFETSDISCONNFAILED_OFFSET);
        messages.BMS_PDU_TempWarn_Info = (byte) (messages.BMS_PDU_TempWarn_Info - can.BMS_FAULT_2_CANID_BMS_PDU_TEMPWARN_INFO_OFFSET);
        messages.BMS_PDU_Temp_Error = (byte) (messages.BMS_PDU_Temp_Error - can.BMS_FAULT_2_CANID_BMS_PDU_TEMP_ERROR_OFFSET);
        messages.BMS_OverVChargeWarnInfo = (byte) (messages.BMS_OverVChargeWarnInfo - can.BMS_FAULT_2_CANID_BMS_OVERVCHARGEWARNINFO_OFFSET);
        messages.BMS_OverVChargeError = (byte) (messages.BMS_OverVChargeError - can.BMS_FAULT_2_CANID_BMS_OVERVCHARGEERROR_OFFSET);
        messages.BMS_OverVChar_Perm_Fault = (byte) (messages.BMS_OverVChar_Perm_Fault - can.BMS_FAULT_2_CANID_BMS_OVERVCHAR_PERM_FAULT_OFFSET);
        messages.BMS_OverV_Regen_Warn_Info = (byte) (messages.BMS_OverV_Regen_Warn_Info - can.BMS_FAULT_2_CANID_BMS_OVERV_REGEN_WARN_INFO_OFFSET);
        messages.BMS_OverV_Regen_Error = (byte) (messages.BMS_OverV_Regen_Error - can.BMS_FAULT_2_CANID_BMS_OVERV_REGEN_ERROR_OFFSET);
        messages.BMS_UndV_Warn_Info = (byte) (messages.BMS_UndV_Warn_Info - can.BMS_FAULT_2_CANID_BMS_UNDV_WARN_INFO_OFFSET);
        messages.BMS_UndV_Error = (byte) (messages.BMS_UndV_Error - can.BMS_FAULT_2_CANID_BMS_UNDV_ERROR_OFFSET);
        messages.BMS_UndV_Perm_fault = (byte) (messages.BMS_UndV_Perm_fault - can.BMS_FAULT_2_CANID_BMS_UNDV_PERM_FAULT_OFFSET);
        messages.BMS_OverTempCharWarnInfo = (byte) (messages.BMS_OverTempCharWarnInfo - can.BMS_FAULT_2_CANID_BMS_OVERTEMPCHARWARNINFO_OFFSET);
        messages.BMS_OverTempCharError = (byte) (messages.BMS_OverTempCharError - can.BMS_FAULT_2_CANID_BMS_OVERTEMPCHARERROR_OFFSET);
        messages.BMS_OverTempDriveWarnInfo = (byte) (messages.BMS_OverTempDriveWarnInfo - can.BMS_FAULT_2_CANID_BMS_OVERTEMPDRIVEWARNINFO_OFFSET);
        messages.BMS_OverTempDriveError = (byte) (messages.BMS_OverTempDriveError - can.BMS_FAULT_2_CANID_BMS_OVERTEMPDRIVEERROR_OFFSET);
        messages.BMS_OvTemp_CellVentError = (byte) (messages.BMS_OvTemp_CellVentError - can.BMS_FAULT_2_CANID_BMS_OVTEMP_CELLVENTERROR_OFFSET);
        messages.BMS_OvTemp_CellVentFailure = (byte) (messages.BMS_OvTemp_CellVentFailure - can.BMS_FAULT_2_CANID_BMS_OVTEMP_CELLVENTFAILURE_OFFSET);
        messages.BMS_ShortCir_DetectError = (byte) (messages.BMS_ShortCir_DetectError - can.BMS_FAULT_2_CANID_BMS_SHORTCIR_DETECTERROR_OFFSET);
        messages.BMS_ShortCir_Detect_PermFault = (byte) (messages.BMS_ShortCir_Detect_PermFault - can.BMS_FAULT_2_CANID_BMS_SHORTCIR_DETECT_PERMFAULT_OFFSET);
        messages.BMS_Cell_Failure_PermFault = (byte) (messages.BMS_Cell_Failure_PermFault - can.BMS_FAULT_2_CANID_BMS_CELL_FAILURE_PERMFAULT_OFFSET);
        messages.BMS_ParaCell_DisconFault = (byte) (messages.BMS_ParaCell_DisconFault - can.BMS_FAULT_2_CANID_BMS_PARACELL_DISCONFAULT_OFFSET);
        messages.BMS_LowTemp_CharWarnInfo = (byte) (messages.BMS_LowTemp_CharWarnInfo - can.BMS_FAULT_2_CANID_BMS_LOWTEMP_CHARWARNINFO_OFFSET);
        data[0] = (byte) ((messages.BMS_LowTempCharge_Error & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_LowTempDrive_Warning & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_LOWTEMPDRIVE_WARNING_MASK0) | ((messages.BMS_LowTempDrive_Error & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_LOWTEMPDRIVE_ERROR_MASK0) | ((messages.OverTimetoFastCharge_Error & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_OVERTIMETOFASTCHARGE_ERROR_MASK0) | ((messages.Battery_Discharge_Inhibit & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BATTERY_DISCHARGE_INHIBIT_MASK0) | ((messages.Battery_Derate_Drive_Cur_Flag & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BATTERY_DERATE_DRIVE_CUR_FLAG_MASK0) | ((messages.Battery_Derate_Charge_Cur_Flag & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BATTERY_DERATE_CHARGE_CUR_FLAG_MASK0) | ((messages.Battery_Inhibit_regen_Fault & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BATTERY_INHIBIT_REGEN_FAULT_MASK0));
        data[1] = (byte) ((messages.Battery_Volt_Deviation_Error & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_Batt_PackTemp_1_OutofRange & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_BATT_PACKTEMP_1_OUTOFRANGE_MASK0) | ((messages.BMS_Batt_PackTemp_2_OutofRange & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_BATT_PACKTEMP_2_OUTOFRANGE_MASK0) | ((messages.BMS_Batt_PackTemp_3_OutofRange & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_BATT_PACKTEMP_3_OUTOFRANGE_MASK0) | ((messages.BMS_Batt_PackTemp_4_OutofRange & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_BATT_PACKTEMP_4_OUTOFRANGE_MASK0) | ((messages.BMS_Batt_PackTemp_5_OutofRange & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_BATT_PACKTEMP_5_OUTOFRANGE_MASK0) | ((messages.BMS_Batt_PackTemp_6_OutofRange & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_BATT_PACKTEMP_6_OUTOFRANGE_MASK0) | ((messages.BMS_Curr_Sens_Failure_OpenCir & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_CURR_SENS_FAILURE_OPENCIR_MASK0));
        data[2] = (byte) ((messages.BMS_Curr_Sens_Failure_ShortCir & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_OverCurrCharge_Warn & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERCURRCHARGE_WARN_MASK0) | ((messages.BMS_OverCurrCharge_Error & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERCURRCHARGE_ERROR_MASK0) | ((messages.BMS_PreChargeTooFast_Info & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_PRECHARGETOOFAST_INFO_MASK0) | ((messages.BMS_PreChargeTooSlow_Info & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_PRECHARGETOOSLOW_INFO_MASK0) | ((messages.BMS_PreChargeFailure & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_PRECHARGEFAILURE_MASK0) | ((messages.BMS_MOSFETsConnFailed & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_MOSFETSCONNFAILED_MASK0) | ((messages.BMS_MOSFETsDisconnFailed & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_MOSFETSDISCONNFAILED_MASK0));
        data[3] = (byte) ((messages.BMS_PDU_TempWarn_Info & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_PDU_Temp_Error & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_PDU_TEMP_ERROR_MASK0) | ((messages.BMS_OverVChargeWarnInfo & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERVCHARGEWARNINFO_MASK0) | ((messages.BMS_OverVChargeError & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERVCHARGEERROR_MASK0) | ((messages.BMS_OverVChar_Perm_Fault & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERVCHAR_PERM_FAULT_MASK0) | ((messages.BMS_OverV_Regen_Warn_Info & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERV_REGEN_WARN_INFO_MASK0) | ((messages.BMS_OverV_Regen_Error & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERV_REGEN_ERROR_MASK0) | ((messages.BMS_UndV_Warn_Info & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_UNDV_WARN_INFO_MASK0));
        data[4] = (byte) ((messages.BMS_UndV_Error & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_UndV_Perm_fault & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_UNDV_PERM_FAULT_MASK0) | ((messages.BMS_OverTempCharWarnInfo & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERTEMPCHARWARNINFO_MASK0) | ((messages.BMS_OverTempCharError & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERTEMPCHARERROR_MASK0) | ((messages.BMS_OverTempDriveWarnInfo & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERTEMPDRIVEWARNINFO_MASK0) | ((messages.BMS_OverTempDriveError & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERTEMPDRIVEERROR_MASK0) | ((messages.BMS_OvTemp_CellVentError & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVTEMP_CELLVENTERROR_MASK0) | ((messages.BMS_OvTemp_CellVentFailure & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVTEMP_CELLVENTFAILURE_MASK0));
        data[5] = (byte) ((messages.BMS_ShortCir_DetectError & (can.SIGNLE_READ_Mask1)) | ((messages.BMS_ShortCir_Detect_PermFault & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_SHORTCIR_DETECT_PERMFAULT_MASK0) | ((messages.BMS_Cell_Failure_PermFault & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_CELL_FAILURE_PERMFAULT_MASK0) | ((messages.BMS_ParaCell_DisconFault & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_PARACELL_DISCONFAULT_MASK0) | ((messages.BMS_LowTemp_CharWarnInfo & (can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_LOWTEMP_CHARWARNINFO_MASK0));
        return can.BMS_FAULT_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ESCL_Data(ConverterInitialize.ESCL_Data_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Supply_Voltage = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DATA_ESCL_SUPPLY_VOLTAGE_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.ESCL_DATA_CANID_ESCL_SUPPLY_VOLTAGE_OFFSET));
        messages.Motor_Stall_Current = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DATA_MOTOR_STALL_CURRENT_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.ESCL_DATA_CANID_MOTOR_STALL_CURRENT_OFFSET));
        messages.ESCL_Status = (byte) (((data[4] & (can.SIGNLE_READ_Mask3))) + (byte) (can.ESCL_DATA_CANID_ESCL_STATUS_OFFSET));
        messages.ESCL_Hall1_Status = (byte) ((((data[4] >> can.ESCL_DATA_ESCL_HALL1_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ESCL_DATA_CANID_ESCL_HALL1_STATUS_OFFSET));
        messages.ESCL_Hall2_Status = (byte) ((((data[4] >> can.ESCL_DATA_ESCL_HALL2_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ESCL_DATA_CANID_ESCL_HALL2_STATUS_OFFSET));
        messages.ESCL_Power_Status = (byte) ((((data[4] >> can.ESCL_DATA_ESCL_POWER_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ESCL_DATA_CANID_ESCL_POWER_STATUS_OFFSET));
        messages.ESCL_Plunger_Status = (byte) ((((data[4] >> can.ESCL_DATA_ESCL_PLUNGER_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ESCL_DATA_CANID_ESCL_PLUNGER_STATUS_OFFSET));
        messages.ESCL_Motor_Temp_Fault = (byte) ((((data[4] >> can.ESCL_DATA_ESCL_MOTOR_TEMP_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ESCL_DATA_CANID_ESCL_MOTOR_TEMP_FAULT_OFFSET));
        messages.ESCL_Motor_Open_Fault = (byte) (((data[5] & (can.SIGNLE_READ_Mask1))) + (byte) (can.ESCL_DATA_CANID_ESCL_MOTOR_OPEN_FAULT_OFFSET));
        messages.ESCL_Motor_Short_Fault = (byte) ((((data[5] >> can.ESCL_DATA_ESCL_MOTOR_SHORT_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ESCL_DATA_CANID_ESCL_MOTOR_SHORT_FAULT_OFFSET));
        messages.ESCL_Lock_Unlock_Error = (byte) ((((data[5] >> can.ESCL_DATA_ESCL_LOCK_UNLOCK_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ESCL_DATA_CANID_ESCL_LOCK_UNLOCK_ERROR_OFFSET));
        messages.ESCL_Sleep_Ack = (byte) ((((data[5] >> can.ESCL_DATA_ESCL_SLEEP_ACK_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ESCL_DATA_CANID_ESCL_SLEEP_ACK_OFFSET));

        return can.ESCL_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ESCL_Data(ConverterInitialize.ESCL_Data_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Supply_Voltage = (short) (messages.ESCL_Supply_Voltage - can.ESCL_DATA_CANID_ESCL_SUPPLY_VOLTAGE_OFFSET);
        messages.Motor_Stall_Current = (short) (messages.Motor_Stall_Current - can.ESCL_DATA_CANID_MOTOR_STALL_CURRENT_OFFSET);
        messages.ESCL_Status = (byte) (messages.ESCL_Status - can.ESCL_DATA_CANID_ESCL_STATUS_OFFSET);
        messages.ESCL_Hall1_Status = (byte) (messages.ESCL_Hall1_Status - can.ESCL_DATA_CANID_ESCL_HALL1_STATUS_OFFSET);
        messages.ESCL_Hall2_Status = (byte) (messages.ESCL_Hall2_Status - can.ESCL_DATA_CANID_ESCL_HALL2_STATUS_OFFSET);
        messages.ESCL_Power_Status = (byte) (messages.ESCL_Power_Status - can.ESCL_DATA_CANID_ESCL_POWER_STATUS_OFFSET);
        messages.ESCL_Plunger_Status = (byte) (messages.ESCL_Plunger_Status - can.ESCL_DATA_CANID_ESCL_PLUNGER_STATUS_OFFSET);
        messages.ESCL_Motor_Temp_Fault = (byte) (messages.ESCL_Motor_Temp_Fault - can.ESCL_DATA_CANID_ESCL_MOTOR_TEMP_FAULT_OFFSET);
        messages.ESCL_Motor_Open_Fault = (byte) (messages.ESCL_Motor_Open_Fault - can.ESCL_DATA_CANID_ESCL_MOTOR_OPEN_FAULT_OFFSET);
        messages.ESCL_Motor_Short_Fault = (byte) (messages.ESCL_Motor_Short_Fault - can.ESCL_DATA_CANID_ESCL_MOTOR_SHORT_FAULT_OFFSET);
        messages.ESCL_Lock_Unlock_Error = (byte) (messages.ESCL_Lock_Unlock_Error - can.ESCL_DATA_CANID_ESCL_LOCK_UNLOCK_ERROR_OFFSET);
        messages.ESCL_Sleep_Ack = (byte) (messages.ESCL_Sleep_Ack - can.ESCL_DATA_CANID_ESCL_SLEEP_ACK_OFFSET);
        data[0] = (byte) ((messages.ESCL_Supply_Voltage & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.ESCL_Supply_Voltage >> can.ESCL_DATA_ESCL_SUPPLY_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Motor_Stall_Current & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Motor_Stall_Current >> can.ESCL_DATA_MOTOR_STALL_CURRENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.ESCL_Status & (can.SIGNLE_READ_Mask3)) | ((messages.ESCL_Hall1_Status & (can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_HALL1_STATUS_MASK0) | ((messages.ESCL_Hall2_Status & (can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_HALL2_STATUS_MASK0) | ((messages.ESCL_Power_Status & (can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_POWER_STATUS_MASK0) | ((messages.ESCL_Plunger_Status & (can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_PLUNGER_STATUS_MASK0) | ((messages.ESCL_Motor_Temp_Fault & (can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_MOTOR_TEMP_FAULT_MASK0));
        data[5] = (byte) ((messages.ESCL_Motor_Open_Fault & (can.SIGNLE_READ_Mask1)) | ((messages.ESCL_Motor_Short_Fault & (can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_MOTOR_SHORT_FAULT_MASK0) | ((messages.ESCL_Lock_Unlock_Error & (can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_LOCK_UNLOCK_ERROR_MASK0) | ((messages.ESCL_Sleep_Ack & (can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_SLEEP_ACK_MASK0));
        return can.ESCL_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_DATA(ConverterInitialize.MCU_DATA_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Motor_rpm = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA_MOTOR_RPM_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.MCU_DATA_CANID_MOTOR_RPM_OFFSET));

        return can.MCU_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_DATA(ConverterInitialize.MCU_DATA_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Motor_rpm = (short) (messages.Motor_rpm - can.MCU_DATA_CANID_MOTOR_RPM_OFFSET);
        data[6] = (byte) ((messages.Motor_rpm & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Motor_rpm >> can.MCU_DATA_MOTOR_RPM_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.MCU_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Charger_Fault_Info(ConverterInitialize.Charger_Fault_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_IP_AC_overVoltage = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_OBC_IP_AC_OVERVOLTAGE_OFFSET));
        messages.OBC_IP_AC_UnderV = (byte) ((((data[0] >> can.CHARGER_FAULT_INFO_OBC_IP_AC_UNDERV_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_OBC_IP_AC_UNDERV_OFFSET));
        messages.OBC_IP_Overcurrent = (byte) ((((data[0] >> can.CHARGER_FAULT_INFO_OBC_IP_OVERCURRENT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_OBC_IP_OVERCURRENT_OFFSET));
        messages.OBC_OP_Overcurrent = (byte) ((((data[0] >> can.CHARGER_FAULT_INFO_OBC_OP_OVERCURRENT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_OBC_OP_OVERCURRENT_OFFSET));
        messages.OBC_High_temp = (byte) ((((data[0] >> can.CHARGER_FAULT_INFO_OBC_HIGH_TEMP_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_OBC_HIGH_TEMP_OFFSET));
        messages.OBC_Low_temp = (byte) ((((data[0] >> can.CHARGER_FAULT_INFO_OBC_LOW_TEMP_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_OBC_LOW_TEMP_OFFSET));
        messages.OBC_Temp_Sensor_fail = (byte) ((((data[0] >> can.CHARGER_FAULT_INFO_OBC_TEMP_SENSOR_FAIL_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_OBC_TEMP_SENSOR_FAIL_OFFSET));
        messages.OBC_Current_Sensor_fail = (byte) ((((data[0] >> can.CHARGER_FAULT_INFO_OBC_CURRENT_SENSOR_FAIL_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_OBC_CURRENT_SENSOR_FAIL_OFFSET));
        messages.OBC_ContactorRelay_fail = (byte) (((data[1] & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_OBC_CONTACTORRELAY_FAIL_OFFSET));
        messages.OBC_OP_Open_Circuit = (byte) ((((data[1] >> can.CHARGER_FAULT_INFO_OBC_OP_OPEN_CIRCUIT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_OBC_OP_OPEN_CIRCUIT_OFFSET));
        messages.OBC_OP_Short_Circuit = (byte) ((((data[1] >> can.CHARGER_FAULT_INFO_OBC_OP_SHORT_CIRCUIT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_OBC_OP_SHORT_CIRCUIT_OFFSET));
        messages.OBC_OP_Over_Vol_flt = (byte) ((((data[1] >> can.CHARGER_FAULT_INFO_OBC_OP_OVER_VOL_FLT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_OBC_OP_OVER_VOL_FLT_OFFSET));
        messages.OBC_OP_Under_Vol_flt = (byte) ((((data[1] >> can.CHARGER_FAULT_INFO_OBC_OP_UNDER_VOL_FLT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_OBC_OP_UNDER_VOL_FLT_OFFSET));
        messages.DCDC_OP_Over_Vol_flt = (byte) ((((data[1] >> can.CHARGER_FAULT_INFO_DCDC_OP_OVER_VOL_FLT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_DCDC_OP_OVER_VOL_FLT_OFFSET));
        messages.DCDC_IP_Over_Voltage = (byte) ((((data[1] >> can.CHARGER_FAULT_INFO_DCDC_IP_OVER_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_DCDC_IP_OVER_VOLTAGE_OFFSET));
        messages.DCDC_IP_Under_Voltage = (byte) ((((data[1] >> can.CHARGER_FAULT_INFO_DCDC_IP_UNDER_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_DCDC_IP_UNDER_VOLTAGE_OFFSET));
        messages.DCDC_IP_Over_Current = (byte) (((data[2] & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_DCDC_IP_OVER_CURRENT_OFFSET));
        messages.DCDC_OP_Over_Current = (byte) ((((data[2] >> can.CHARGER_FAULT_INFO_DCDC_OP_OVER_CURRENT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_DCDC_OP_OVER_CURRENT_OFFSET));
        messages.DCDC_High_Temp = (byte) ((((data[2] >> can.CHARGER_FAULT_INFO_DCDC_HIGH_TEMP_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_DCDC_HIGH_TEMP_OFFSET));
        messages.DCDC_Low_Temp = (byte) ((((data[2] >> can.CHARGER_FAULT_INFO_DCDC_LOW_TEMP_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_DCDC_LOW_TEMP_OFFSET));
        messages.DCDC_TempSensor_Failure = (byte) ((((data[2] >> can.CHARGER_FAULT_INFO_DCDC_TEMPSENSOR_FAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_DCDC_TEMPSENSOR_FAILURE_OFFSET));
        messages.DCDC_Current_Sensor_Failure = (byte) ((((data[2] >> can.CHARGER_FAULT_INFO_DCDC_CURRENT_SENSOR_FAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_DCDC_CURRENT_SENSOR_FAILURE_OFFSET));
        messages.DCDC_Contactor_or_Relay_Failure = (byte) ((((data[2] >> can.CHARGER_FAULT_INFO_DCDC_CONTACTOR_OR_RELAY_FAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_DCDC_CONTACTOR_OR_RELAY_FAILURE_OFFSET));
        messages.DCDC_OP_Open_Circuit = (byte) ((((data[2] >> can.CHARGER_FAULT_INFO_DCDC_OP_OPEN_CIRCUIT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_DCDC_OP_OPEN_CIRCUIT_OFFSET));
        messages.DCDC_OP_Short_Circuit = (byte) (((data[3] & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_DCDC_OP_SHORT_CIRCUIT_OFFSET));
        messages.DCDC_OP_Under_Vol_flt = (byte) ((((data[3] >> can.CHARGER_FAULT_INFO_DCDC_OP_UNDER_VOL_FLT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.CHARGER_FAULT_INFO_CANID_DCDC_OP_UNDER_VOL_FLT_OFFSET));

        return can.CHARGER_FAULT_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Charger_Fault_Info(ConverterInitialize.Charger_Fault_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_IP_AC_overVoltage = (byte) (messages.OBC_IP_AC_overVoltage - can.CHARGER_FAULT_INFO_CANID_OBC_IP_AC_OVERVOLTAGE_OFFSET);
        messages.OBC_IP_AC_UnderV = (byte) (messages.OBC_IP_AC_UnderV - can.CHARGER_FAULT_INFO_CANID_OBC_IP_AC_UNDERV_OFFSET);
        messages.OBC_IP_Overcurrent = (byte) (messages.OBC_IP_Overcurrent - can.CHARGER_FAULT_INFO_CANID_OBC_IP_OVERCURRENT_OFFSET);
        messages.OBC_OP_Overcurrent = (byte) (messages.OBC_OP_Overcurrent - can.CHARGER_FAULT_INFO_CANID_OBC_OP_OVERCURRENT_OFFSET);
        messages.OBC_High_temp = (byte) (messages.OBC_High_temp - can.CHARGER_FAULT_INFO_CANID_OBC_HIGH_TEMP_OFFSET);
        messages.OBC_Low_temp = (byte) (messages.OBC_Low_temp - can.CHARGER_FAULT_INFO_CANID_OBC_LOW_TEMP_OFFSET);
        messages.OBC_Temp_Sensor_fail = (byte) (messages.OBC_Temp_Sensor_fail - can.CHARGER_FAULT_INFO_CANID_OBC_TEMP_SENSOR_FAIL_OFFSET);
        messages.OBC_Current_Sensor_fail = (byte) (messages.OBC_Current_Sensor_fail - can.CHARGER_FAULT_INFO_CANID_OBC_CURRENT_SENSOR_FAIL_OFFSET);
        messages.OBC_ContactorRelay_fail = (byte) (messages.OBC_ContactorRelay_fail - can.CHARGER_FAULT_INFO_CANID_OBC_CONTACTORRELAY_FAIL_OFFSET);
        messages.OBC_OP_Open_Circuit = (byte) (messages.OBC_OP_Open_Circuit - can.CHARGER_FAULT_INFO_CANID_OBC_OP_OPEN_CIRCUIT_OFFSET);
        messages.OBC_OP_Short_Circuit = (byte) (messages.OBC_OP_Short_Circuit - can.CHARGER_FAULT_INFO_CANID_OBC_OP_SHORT_CIRCUIT_OFFSET);
        messages.OBC_OP_Over_Vol_flt = (byte) (messages.OBC_OP_Over_Vol_flt - can.CHARGER_FAULT_INFO_CANID_OBC_OP_OVER_VOL_FLT_OFFSET);
        messages.OBC_OP_Under_Vol_flt = (byte) (messages.OBC_OP_Under_Vol_flt - can.CHARGER_FAULT_INFO_CANID_OBC_OP_UNDER_VOL_FLT_OFFSET);
        messages.DCDC_OP_Over_Vol_flt = (byte) (messages.DCDC_OP_Over_Vol_flt - can.CHARGER_FAULT_INFO_CANID_DCDC_OP_OVER_VOL_FLT_OFFSET);
        messages.DCDC_IP_Over_Voltage = (byte) (messages.DCDC_IP_Over_Voltage - can.CHARGER_FAULT_INFO_CANID_DCDC_IP_OVER_VOLTAGE_OFFSET);
        messages.DCDC_IP_Under_Voltage = (byte) (messages.DCDC_IP_Under_Voltage - can.CHARGER_FAULT_INFO_CANID_DCDC_IP_UNDER_VOLTAGE_OFFSET);
        messages.DCDC_IP_Over_Current = (byte) (messages.DCDC_IP_Over_Current - can.CHARGER_FAULT_INFO_CANID_DCDC_IP_OVER_CURRENT_OFFSET);
        messages.DCDC_OP_Over_Current = (byte) (messages.DCDC_OP_Over_Current - can.CHARGER_FAULT_INFO_CANID_DCDC_OP_OVER_CURRENT_OFFSET);
        messages.DCDC_High_Temp = (byte) (messages.DCDC_High_Temp - can.CHARGER_FAULT_INFO_CANID_DCDC_HIGH_TEMP_OFFSET);
        messages.DCDC_Low_Temp = (byte) (messages.DCDC_Low_Temp - can.CHARGER_FAULT_INFO_CANID_DCDC_LOW_TEMP_OFFSET);
        messages.DCDC_TempSensor_Failure = (byte) (messages.DCDC_TempSensor_Failure - can.CHARGER_FAULT_INFO_CANID_DCDC_TEMPSENSOR_FAILURE_OFFSET);
        messages.DCDC_Current_Sensor_Failure = (byte) (messages.DCDC_Current_Sensor_Failure - can.CHARGER_FAULT_INFO_CANID_DCDC_CURRENT_SENSOR_FAILURE_OFFSET);
        messages.DCDC_Contactor_or_Relay_Failure = (byte) (messages.DCDC_Contactor_or_Relay_Failure - can.CHARGER_FAULT_INFO_CANID_DCDC_CONTACTOR_OR_RELAY_FAILURE_OFFSET);
        messages.DCDC_OP_Open_Circuit = (byte) (messages.DCDC_OP_Open_Circuit - can.CHARGER_FAULT_INFO_CANID_DCDC_OP_OPEN_CIRCUIT_OFFSET);
        messages.DCDC_OP_Short_Circuit = (byte) (messages.DCDC_OP_Short_Circuit - can.CHARGER_FAULT_INFO_CANID_DCDC_OP_SHORT_CIRCUIT_OFFSET);
        messages.DCDC_OP_Under_Vol_flt = (byte) (messages.DCDC_OP_Under_Vol_flt - can.CHARGER_FAULT_INFO_CANID_DCDC_OP_UNDER_VOL_FLT_OFFSET);
        data[0] = (byte) ((messages.OBC_IP_AC_overVoltage & (can.SIGNLE_READ_Mask1)) | ((messages.OBC_IP_AC_UnderV & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_IP_AC_UNDERV_MASK0) | ((messages.OBC_IP_Overcurrent & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_IP_OVERCURRENT_MASK0) | ((messages.OBC_OP_Overcurrent & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_OP_OVERCURRENT_MASK0) | ((messages.OBC_High_temp & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_HIGH_TEMP_MASK0) | ((messages.OBC_Low_temp & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_LOW_TEMP_MASK0) | ((messages.OBC_Temp_Sensor_fail & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_TEMP_SENSOR_FAIL_MASK0) | ((messages.OBC_Current_Sensor_fail & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_CURRENT_SENSOR_FAIL_MASK0));
        data[1] = (byte) ((messages.OBC_ContactorRelay_fail & (can.SIGNLE_READ_Mask1)) | ((messages.OBC_OP_Open_Circuit & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_OP_OPEN_CIRCUIT_MASK0) | ((messages.OBC_OP_Short_Circuit & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_OP_SHORT_CIRCUIT_MASK0) | ((messages.OBC_OP_Over_Vol_flt & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_OP_OVER_VOL_FLT_MASK0) | ((messages.OBC_OP_Under_Vol_flt & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_OP_UNDER_VOL_FLT_MASK0) | ((messages.DCDC_OP_Over_Vol_flt & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_OP_OVER_VOL_FLT_MASK0) | ((messages.DCDC_IP_Over_Voltage & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_IP_OVER_VOLTAGE_MASK0) | ((messages.DCDC_IP_Under_Voltage & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_IP_UNDER_VOLTAGE_MASK0));
        data[2] = (byte) ((messages.DCDC_IP_Over_Current & (can.SIGNLE_READ_Mask1)) | ((messages.DCDC_OP_Over_Current & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_OP_OVER_CURRENT_MASK0) | ((messages.DCDC_High_Temp & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_HIGH_TEMP_MASK0) | ((messages.DCDC_Low_Temp & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_LOW_TEMP_MASK0) | ((messages.DCDC_TempSensor_Failure & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_TEMPSENSOR_FAILURE_MASK0) | ((messages.DCDC_Current_Sensor_Failure & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_CURRENT_SENSOR_FAILURE_MASK0) | ((messages.DCDC_Contactor_or_Relay_Failure & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_CONTACTOR_OR_RELAY_FAILURE_MASK0) | ((messages.DCDC_OP_Open_Circuit & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_OP_OPEN_CIRCUIT_MASK0));
        data[3] = (byte) ((messages.DCDC_OP_Short_Circuit & (can.SIGNLE_READ_Mask1)) | ((messages.DCDC_OP_Under_Vol_flt & (can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_OP_UNDER_VOL_FLT_MASK0));
        return can.CHARGER_FAULT_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_HP_DCDC_Parameter1(ConverterInitialize.HP_DCDC_Parameter1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.HP_DCDC_IP_DC_Current = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.HP_DCDC_PARAMETER1_HP_DCDC_IP_DC_CURRENT_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_IP_DC_CURRENT_OFFSET));
        messages.HP_DCDC_IP_DC_Voltage = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.HP_DCDC_PARAMETER1_HP_DCDC_IP_DC_VOLTAGE_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_IP_DC_VOLTAGE_OFFSET));
        messages.HP_DCDC_OP_DC_Current = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.HP_DCDC_PARAMETER1_HP_DCDC_OP_DC_CURRENT_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_OP_DC_CURRENT_OFFSET));
        messages.HP_DCDC_OP_DC_Voltage = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.HP_DCDC_PARAMETER1_HP_DCDC_OP_DC_VOLTAGE_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_OP_DC_VOLTAGE_OFFSET));

        return can.HP_DCDC_PARAMETER1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_HP_DCDC_Parameter1(ConverterInitialize.HP_DCDC_Parameter1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.HP_DCDC_IP_DC_Current = (short) (messages.HP_DCDC_IP_DC_Current - can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_IP_DC_CURRENT_OFFSET);
        messages.HP_DCDC_IP_DC_Voltage = (short) (messages.HP_DCDC_IP_DC_Voltage - can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_IP_DC_VOLTAGE_OFFSET);
        messages.HP_DCDC_OP_DC_Current = (short) (messages.HP_DCDC_OP_DC_Current - can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_OP_DC_CURRENT_OFFSET);
        messages.HP_DCDC_OP_DC_Voltage = (short) (messages.HP_DCDC_OP_DC_Voltage - can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_OP_DC_VOLTAGE_OFFSET);
        data[0] = (byte) ((messages.HP_DCDC_IP_DC_Current & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.HP_DCDC_IP_DC_Current >> can.HP_DCDC_PARAMETER1_HP_DCDC_IP_DC_CURRENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.HP_DCDC_IP_DC_Voltage & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.HP_DCDC_IP_DC_Voltage >> can.HP_DCDC_PARAMETER1_HP_DCDC_IP_DC_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.HP_DCDC_OP_DC_Current & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.HP_DCDC_OP_DC_Current >> can.HP_DCDC_PARAMETER1_HP_DCDC_OP_DC_CURRENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.HP_DCDC_OP_DC_Voltage & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.HP_DCDC_OP_DC_Voltage >> can.HP_DCDC_PARAMETER1_HP_DCDC_OP_DC_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.HP_DCDC_PARAMETER1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_SOM_Settings_Data(ConverterInitialize.SOM_Settings_Data_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Setting = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.SOM_SETTINGS_DATA_CANID_ABS_SETTING_OFFSET));
        messages.Regen_Setting = (byte) ((((data[0] >> can.SOM_SETTINGS_DATA_REGEN_SETTING_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.SOM_SETTINGS_DATA_CANID_REGEN_SETTING_OFFSET));
        messages.Speed_Limit_Setting = (byte) ((((data[0] >> can.SOM_SETTINGS_DATA_SPEED_LIMIT_SETTING_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.SOM_SETTINGS_DATA_CANID_SPEED_LIMIT_SETTING_OFFSET));
        messages.Haptic_Setting = (byte) ((((data[0] >> can.SOM_SETTINGS_DATA_HAPTIC_SETTING_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.SOM_SETTINGS_DATA_CANID_HAPTIC_SETTING_OFFSET));
        messages.Hill_Hold_Setting = (byte) ((((data[0] >> can.SOM_SETTINGS_DATA_HILL_HOLD_SETTING_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.SOM_SETTINGS_DATA_CANID_HILL_HOLD_SETTING_OFFSET));
        messages.Traction_Control_Setting = (byte) ((((data[0] >> can.SOM_SETTINGS_DATA_TRACTION_CONTROL_SETTING_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.SOM_SETTINGS_DATA_CANID_TRACTION_CONTROL_SETTING_OFFSET));
        messages.Cruise_Control_Setting = (byte) ((((data[0] >> can.SOM_SETTINGS_DATA_CRUISE_CONTROL_SETTING_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.SOM_SETTINGS_DATA_CANID_CRUISE_CONTROL_SETTING_OFFSET));
        messages.Set_Max_Speed = (byte) (((data[1] & (can.SIGNLE_READ_Mask8))) + (byte) (can.SOM_SETTINGS_DATA_CANID_SET_MAX_SPEED_OFFSET));

        return can.SOM_SETTINGS_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_SOM_Settings_Data(ConverterInitialize.SOM_Settings_Data_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Setting = (byte) (messages.ABS_Setting - can.SOM_SETTINGS_DATA_CANID_ABS_SETTING_OFFSET);
        messages.Regen_Setting = (byte) (messages.Regen_Setting - can.SOM_SETTINGS_DATA_CANID_REGEN_SETTING_OFFSET);
        messages.Speed_Limit_Setting = (byte) (messages.Speed_Limit_Setting - can.SOM_SETTINGS_DATA_CANID_SPEED_LIMIT_SETTING_OFFSET);
        messages.Haptic_Setting = (byte) (messages.Haptic_Setting - can.SOM_SETTINGS_DATA_CANID_HAPTIC_SETTING_OFFSET);
        messages.Hill_Hold_Setting = (byte) (messages.Hill_Hold_Setting - can.SOM_SETTINGS_DATA_CANID_HILL_HOLD_SETTING_OFFSET);
        messages.Traction_Control_Setting = (byte) (messages.Traction_Control_Setting - can.SOM_SETTINGS_DATA_CANID_TRACTION_CONTROL_SETTING_OFFSET);
        messages.Cruise_Control_Setting = (byte) (messages.Cruise_Control_Setting - can.SOM_SETTINGS_DATA_CANID_CRUISE_CONTROL_SETTING_OFFSET);
        messages.Set_Max_Speed = (byte) (messages.Set_Max_Speed - can.SOM_SETTINGS_DATA_CANID_SET_MAX_SPEED_OFFSET);
        data[0] = (byte) ((messages.ABS_Setting & (can.SIGNLE_READ_Mask1)) | ((messages.Regen_Setting & (can.SIGNLE_READ_Mask1)) << can.SOM_SETTINGS_DATA_REGEN_SETTING_MASK0) | ((messages.Speed_Limit_Setting & (can.SIGNLE_READ_Mask1)) << can.SOM_SETTINGS_DATA_SPEED_LIMIT_SETTING_MASK0) | ((messages.Haptic_Setting & (can.SIGNLE_READ_Mask1)) << can.SOM_SETTINGS_DATA_HAPTIC_SETTING_MASK0) | ((messages.Hill_Hold_Setting & (can.SIGNLE_READ_Mask1)) << can.SOM_SETTINGS_DATA_HILL_HOLD_SETTING_MASK0) | ((messages.Traction_Control_Setting & (can.SIGNLE_READ_Mask1)) << can.SOM_SETTINGS_DATA_TRACTION_CONTROL_SETTING_MASK0) | ((messages.Cruise_Control_Setting & (can.SIGNLE_READ_Mask1)) << can.SOM_SETTINGS_DATA_CRUISE_CONTROL_SETTING_MASK0));
        data[1] = (byte) ((messages.Set_Max_Speed & (can.SIGNLE_READ_Mask8)));
        return can.SOM_SETTINGS_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_IMU_Data_X(ConverterInitialize.IMU_Data_X_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Accelerometer_Xaxis = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_X_ACCELEROMETER_XAXIS_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_X_ACCELEROMETER_XAXIS_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_X_ACCELEROMETER_XAXIS_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.IMU_DATA_X_CANID_ACCELEROMETER_XAXIS_OFFSET));
        messages.Gyroscope_Xaxis = (int) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_X_GYROSCOPE_XAXIS_MASK0) | ((data[6] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_X_GYROSCOPE_XAXIS_MASK1) | ((data[5] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_X_GYROSCOPE_XAXIS_MASK2) | (data[4] & (can.SIGNLE_READ_Mask8))) + (int) (can.IMU_DATA_X_CANID_GYROSCOPE_XAXIS_OFFSET));

        return can.IMU_DATA_X_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_IMU_Data_X(ConverterInitialize.IMU_Data_X_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Accelerometer_Xaxis = (int) (messages.Accelerometer_Xaxis - can.IMU_DATA_X_CANID_ACCELEROMETER_XAXIS_OFFSET);
        messages.Gyroscope_Xaxis = (int) (messages.Gyroscope_Xaxis - can.IMU_DATA_X_CANID_GYROSCOPE_XAXIS_OFFSET);
        data[0] = (byte) ((messages.Accelerometer_Xaxis & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Accelerometer_Xaxis >> can.IMU_DATA_X_ACCELEROMETER_XAXIS_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.Accelerometer_Xaxis >> can.IMU_DATA_X_ACCELEROMETER_XAXIS_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Accelerometer_Xaxis >> can.IMU_DATA_X_ACCELEROMETER_XAXIS_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Gyroscope_Xaxis & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Gyroscope_Xaxis >> can.IMU_DATA_X_GYROSCOPE_XAXIS_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.Gyroscope_Xaxis >> can.IMU_DATA_X_GYROSCOPE_XAXIS_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Gyroscope_Xaxis >> can.IMU_DATA_X_GYROSCOPE_XAXIS_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.IMU_DATA_X_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_SW_Version(ConverterInitialize.MCU_SW_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Firmware_OEM_Version = (byte) (((data[0] & (can.SIGNLE_READ_Mask8))) + (byte) (can.MCU_SW_VERSION_CANID_MCU_FIRMWARE_OEM_VERSION_OFFSET));
        messages.MCU_Firmware_Main_Version = (byte) (((data[1] & (can.SIGNLE_READ_Mask8))) + (byte) (can.MCU_SW_VERSION_CANID_MCU_FIRMWARE_MAIN_VERSION_OFFSET));
        messages.MCU_Firmware_Sub_Version = (byte) (((data[2] & (can.SIGNLE_READ_Mask8))) + (byte) (can.MCU_SW_VERSION_CANID_MCU_FIRMWARE_SUB_VERSION_OFFSET));
        messages.MCU_Bootloader_OEM_Version = (byte) (((data[3] & (can.SIGNLE_READ_Mask8))) + (byte) (can.MCU_SW_VERSION_CANID_MCU_BOOTLOADER_OEM_VERSION_OFFSET));
        messages.MCU_Bootloader_Main_Version = (byte) (((data[4] & (can.SIGNLE_READ_Mask8))) + (byte) (can.MCU_SW_VERSION_CANID_MCU_BOOTLOADER_MAIN_VERSION_OFFSET));
        messages.MCU_Hardware_OEM_Version = (byte) (((data[5] & (can.SIGNLE_READ_Mask8))) + (byte) (can.MCU_SW_VERSION_CANID_MCU_HARDWARE_OEM_VERSION_OFFSET));
        messages.MCU_Hardware_Main_Version = (byte) (((data[6] & (can.SIGNLE_READ_Mask8))) + (byte) (can.MCU_SW_VERSION_CANID_MCU_HARDWARE_MAIN_VERSION_OFFSET));
        messages.MCU_Hardware_Sub_Version = (byte) (((data[7] & (can.SIGNLE_READ_Mask8))) + (byte) (can.MCU_SW_VERSION_CANID_MCU_HARDWARE_SUB_VERSION_OFFSET));

        return can.MCU_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_SW_Version(ConverterInitialize.MCU_SW_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Firmware_OEM_Version = (byte) (messages.MCU_Firmware_OEM_Version - can.MCU_SW_VERSION_CANID_MCU_FIRMWARE_OEM_VERSION_OFFSET);
        messages.MCU_Firmware_Main_Version = (byte) (messages.MCU_Firmware_Main_Version - can.MCU_SW_VERSION_CANID_MCU_FIRMWARE_MAIN_VERSION_OFFSET);
        messages.MCU_Firmware_Sub_Version = (byte) (messages.MCU_Firmware_Sub_Version - can.MCU_SW_VERSION_CANID_MCU_FIRMWARE_SUB_VERSION_OFFSET);
        messages.MCU_Bootloader_OEM_Version = (byte) (messages.MCU_Bootloader_OEM_Version - can.MCU_SW_VERSION_CANID_MCU_BOOTLOADER_OEM_VERSION_OFFSET);
        messages.MCU_Bootloader_Main_Version = (byte) (messages.MCU_Bootloader_Main_Version - can.MCU_SW_VERSION_CANID_MCU_BOOTLOADER_MAIN_VERSION_OFFSET);
        messages.MCU_Hardware_OEM_Version = (byte) (messages.MCU_Hardware_OEM_Version - can.MCU_SW_VERSION_CANID_MCU_HARDWARE_OEM_VERSION_OFFSET);
        messages.MCU_Hardware_Main_Version = (byte) (messages.MCU_Hardware_Main_Version - can.MCU_SW_VERSION_CANID_MCU_HARDWARE_MAIN_VERSION_OFFSET);
        messages.MCU_Hardware_Sub_Version = (byte) (messages.MCU_Hardware_Sub_Version - can.MCU_SW_VERSION_CANID_MCU_HARDWARE_SUB_VERSION_OFFSET);
        data[0] = (byte) ((messages.MCU_Firmware_OEM_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) ((messages.MCU_Firmware_Main_Version & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.MCU_Firmware_Sub_Version & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) ((messages.MCU_Bootloader_OEM_Version & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.MCU_Bootloader_Main_Version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) ((messages.MCU_Hardware_OEM_Version & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.MCU_Hardware_Main_Version & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) ((messages.MCU_Hardware_Sub_Version & (can.SIGNLE_READ_Mask8)));
        return can.MCU_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ICM_HW_Version_Info(ConverterInitialize.ICM_HW_Version_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ICM_Hardware_Version = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.ICM_HW_VERSION_INFO_CANID_ICM_HARDWARE_VERSION_OFFSET));

        return can.ICM_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ICM_HW_Version_Info(ConverterInitialize.ICM_HW_Version_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ICM_Hardware_Version = (long) (messages.ICM_Hardware_Version - can.ICM_HW_VERSION_INFO_CANID_ICM_HARDWARE_VERSION_OFFSET);
        data[0] = (byte) ((messages.ICM_Hardware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.ICM_Hardware_Version >> can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.ICM_Hardware_Version >> can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.ICM_Hardware_Version >> can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.ICM_Hardware_Version >> can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.ICM_Hardware_Version >> can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.ICM_Hardware_Version >> can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.ICM_Hardware_Version >> can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ICM_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ICM_SW_Version(ConverterInitialize.ICM_SW_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ICM_Firmware_Version = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.ICM_SW_VERSION_ICM_FIRMWARE_VERSION_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.ICM_SW_VERSION_ICM_FIRMWARE_VERSION_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.ICM_SW_VERSION_ICM_FIRMWARE_VERSION_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.ICM_SW_VERSION_CANID_ICM_FIRMWARE_VERSION_OFFSET));
        messages.ICM_Bootloader_Version = (int) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.ICM_SW_VERSION_ICM_BOOTLOADER_VERSION_MASK0) | ((data[6] & (can.SIGNLE_READ_Mask8)) << can.ICM_SW_VERSION_ICM_BOOTLOADER_VERSION_MASK1) | ((data[5] & (can.SIGNLE_READ_Mask8)) << can.ICM_SW_VERSION_ICM_BOOTLOADER_VERSION_MASK2) | (data[4] & (can.SIGNLE_READ_Mask8))) + (int) (can.ICM_SW_VERSION_CANID_ICM_BOOTLOADER_VERSION_OFFSET));

        return can.ICM_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ICM_SW_Version(ConverterInitialize.ICM_SW_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ICM_Firmware_Version = (int) (messages.ICM_Firmware_Version - can.ICM_SW_VERSION_CANID_ICM_FIRMWARE_VERSION_OFFSET);
        messages.ICM_Bootloader_Version = (int) (messages.ICM_Bootloader_Version - can.ICM_SW_VERSION_CANID_ICM_BOOTLOADER_VERSION_OFFSET);
        data[0] = (byte) ((messages.ICM_Firmware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.ICM_Firmware_Version >> can.ICM_SW_VERSION_ICM_FIRMWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.ICM_Firmware_Version >> can.ICM_SW_VERSION_ICM_FIRMWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.ICM_Firmware_Version >> can.ICM_SW_VERSION_ICM_FIRMWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.ICM_Bootloader_Version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.ICM_Bootloader_Version >> can.ICM_SW_VERSION_ICM_BOOTLOADER_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.ICM_Bootloader_Version >> can.ICM_SW_VERSION_ICM_BOOTLOADER_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.ICM_Bootloader_Version >> can.ICM_SW_VERSION_ICM_BOOTLOADER_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ICM_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ESCL_HW_Version_Info(ConverterInitialize.ESCL_HW_Version_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Hardware_Version = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.ESCL_HW_VERSION_INFO_CANID_ESCL_HARDWARE_VERSION_OFFSET));

        return can.ESCL_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ESCL_HW_Version_Info(ConverterInitialize.ESCL_HW_Version_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Hardware_Version = (long) (messages.ESCL_Hardware_Version - can.ESCL_HW_VERSION_INFO_CANID_ESCL_HARDWARE_VERSION_OFFSET);
        data[0] = (byte) ((messages.ESCL_Hardware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.ESCL_Hardware_Version >> can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.ESCL_Hardware_Version >> can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.ESCL_Hardware_Version >> can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.ESCL_Hardware_Version >> can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.ESCL_Hardware_Version >> can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.ESCL_Hardware_Version >> can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.ESCL_Hardware_Version >> can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ESCL_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OBC_SW_Version(ConverterInitialize.OBC_SW_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Firmware_Version = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.OBC_SW_VERSION_OBC_FIRMWARE_VERSION_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.OBC_SW_VERSION_OBC_FIRMWARE_VERSION_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.OBC_SW_VERSION_OBC_FIRMWARE_VERSION_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.OBC_SW_VERSION_CANID_OBC_FIRMWARE_VERSION_OFFSET));
        messages.OBC_Bootloader_Version = (int) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.OBC_SW_VERSION_OBC_BOOTLOADER_VERSION_MASK0) | ((data[6] & (can.SIGNLE_READ_Mask8)) << can.OBC_SW_VERSION_OBC_BOOTLOADER_VERSION_MASK1) | ((data[5] & (can.SIGNLE_READ_Mask8)) << can.OBC_SW_VERSION_OBC_BOOTLOADER_VERSION_MASK2) | (data[4] & (can.SIGNLE_READ_Mask8))) + (int) (can.OBC_SW_VERSION_CANID_OBC_BOOTLOADER_VERSION_OFFSET));

        return can.OBC_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OBC_SW_Version(ConverterInitialize.OBC_SW_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Firmware_Version = (int) (messages.OBC_Firmware_Version - can.OBC_SW_VERSION_CANID_OBC_FIRMWARE_VERSION_OFFSET);
        messages.OBC_Bootloader_Version = (int) (messages.OBC_Bootloader_Version - can.OBC_SW_VERSION_CANID_OBC_BOOTLOADER_VERSION_OFFSET);
        data[0] = (byte) ((messages.OBC_Firmware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.OBC_Firmware_Version >> can.OBC_SW_VERSION_OBC_FIRMWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.OBC_Firmware_Version >> can.OBC_SW_VERSION_OBC_FIRMWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.OBC_Firmware_Version >> can.OBC_SW_VERSION_OBC_FIRMWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.OBC_Bootloader_Version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.OBC_Bootloader_Version >> can.OBC_SW_VERSION_OBC_BOOTLOADER_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.OBC_Bootloader_Version >> can.OBC_SW_VERSION_OBC_BOOTLOADER_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.OBC_Bootloader_Version >> can.OBC_SW_VERSION_OBC_BOOTLOADER_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.OBC_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OBC_HW_Version(ConverterInitialize.OBC_HW_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Hardware_Version = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.OBC_HW_VERSION_OBC_HARDWARE_VERSION_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.OBC_HW_VERSION_OBC_HARDWARE_VERSION_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.OBC_HW_VERSION_OBC_HARDWARE_VERSION_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.OBC_HW_VERSION_CANID_OBC_HARDWARE_VERSION_OFFSET));

        return can.OBC_HW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OBC_HW_Version(ConverterInitialize.OBC_HW_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Hardware_Version = (int) (messages.OBC_Hardware_Version - can.OBC_HW_VERSION_CANID_OBC_HARDWARE_VERSION_OFFSET);
        data[0] = (byte) ((messages.OBC_Hardware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.OBC_Hardware_Version >> can.OBC_HW_VERSION_OBC_HARDWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.OBC_Hardware_Version >> can.OBC_HW_VERSION_OBC_HARDWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.OBC_Hardware_Version >> can.OBC_HW_VERSION_OBC_HARDWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.OBC_HW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ESCL_SW_Version_Info(ConverterInitialize.ESCL_SW_Version_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Firmware_version = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.ESCL_SW_VERSION_INFO_ESCL_FIRMWARE_VERSION_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.ESCL_SW_VERSION_INFO_ESCL_FIRMWARE_VERSION_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.ESCL_SW_VERSION_INFO_ESCL_FIRMWARE_VERSION_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.ESCL_SW_VERSION_INFO_CANID_ESCL_FIRMWARE_VERSION_OFFSET));
        messages.ESCL_Bootloader_version = (int) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.ESCL_SW_VERSION_INFO_ESCL_BOOTLOADER_VERSION_MASK0) | ((data[6] & (can.SIGNLE_READ_Mask8)) << can.ESCL_SW_VERSION_INFO_ESCL_BOOTLOADER_VERSION_MASK1) | ((data[5] & (can.SIGNLE_READ_Mask8)) << can.ESCL_SW_VERSION_INFO_ESCL_BOOTLOADER_VERSION_MASK2) | (data[4] & (can.SIGNLE_READ_Mask8))) + (int) (can.ESCL_SW_VERSION_INFO_CANID_ESCL_BOOTLOADER_VERSION_OFFSET));

        return can.ESCL_SW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ESCL_SW_Version_Info(ConverterInitialize.ESCL_SW_Version_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Firmware_version = (int) (messages.ESCL_Firmware_version - can.ESCL_SW_VERSION_INFO_CANID_ESCL_FIRMWARE_VERSION_OFFSET);
        messages.ESCL_Bootloader_version = (int) (messages.ESCL_Bootloader_version - can.ESCL_SW_VERSION_INFO_CANID_ESCL_BOOTLOADER_VERSION_OFFSET);
        data[0] = (byte) ((messages.ESCL_Firmware_version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.ESCL_Firmware_version >> can.ESCL_SW_VERSION_INFO_ESCL_FIRMWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.ESCL_Firmware_version >> can.ESCL_SW_VERSION_INFO_ESCL_FIRMWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.ESCL_Firmware_version >> can.ESCL_SW_VERSION_INFO_ESCL_FIRMWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.ESCL_Bootloader_version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.ESCL_Bootloader_version >> can.ESCL_SW_VERSION_INFO_ESCL_BOOTLOADER_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.ESCL_Bootloader_version >> can.ESCL_SW_VERSION_INFO_ESCL_BOOTLOADER_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.ESCL_Bootloader_version >> can.ESCL_SW_VERSION_INFO_ESCL_BOOTLOADER_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ESCL_SW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_RSC_HW_Version_Info(ConverterInitialize.RSC_HW_Version_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Hardware_Version = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.RSC_HW_VERSION_INFO_CANID_RSC_HARDWARE_VERSION_OFFSET));

        return can.RSC_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_RSC_HW_Version_Info(ConverterInitialize.RSC_HW_Version_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Hardware_Version = (long) (messages.RSC_Hardware_Version - can.RSC_HW_VERSION_INFO_CANID_RSC_HARDWARE_VERSION_OFFSET);
        data[0] = (byte) ((messages.RSC_Hardware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.RSC_Hardware_Version >> can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.RSC_Hardware_Version >> can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.RSC_Hardware_Version >> can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.RSC_Hardware_Version >> can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.RSC_Hardware_Version >> can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.RSC_Hardware_Version >> can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.RSC_Hardware_Version >> can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.RSC_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_RSC_SW_Version(ConverterInitialize.RSC_SW_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Firmware_Version = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.RSC_SW_VERSION_RSC_FIRMWARE_VERSION_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.RSC_SW_VERSION_RSC_FIRMWARE_VERSION_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.RSC_SW_VERSION_RSC_FIRMWARE_VERSION_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.RSC_SW_VERSION_CANID_RSC_FIRMWARE_VERSION_OFFSET));
        messages.RSC_Bootloader_Version = (int) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.RSC_SW_VERSION_RSC_BOOTLOADER_VERSION_MASK0) | ((data[6] & (can.SIGNLE_READ_Mask8)) << can.RSC_SW_VERSION_RSC_BOOTLOADER_VERSION_MASK1) | ((data[5] & (can.SIGNLE_READ_Mask8)) << can.RSC_SW_VERSION_RSC_BOOTLOADER_VERSION_MASK2) | (data[4] & (can.SIGNLE_READ_Mask8))) + (int) (can.RSC_SW_VERSION_CANID_RSC_BOOTLOADER_VERSION_OFFSET));

        return can.RSC_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_RSC_SW_Version(ConverterInitialize.RSC_SW_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Firmware_Version = (int) (messages.RSC_Firmware_Version - can.RSC_SW_VERSION_CANID_RSC_FIRMWARE_VERSION_OFFSET);
        messages.RSC_Bootloader_Version = (int) (messages.RSC_Bootloader_Version - can.RSC_SW_VERSION_CANID_RSC_BOOTLOADER_VERSION_OFFSET);
        data[0] = (byte) ((messages.RSC_Firmware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.RSC_Firmware_Version >> can.RSC_SW_VERSION_RSC_FIRMWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.RSC_Firmware_Version >> can.RSC_SW_VERSION_RSC_FIRMWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.RSC_Firmware_Version >> can.RSC_SW_VERSION_RSC_FIRMWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.RSC_Bootloader_Version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.RSC_Bootloader_Version >> can.RSC_SW_VERSION_RSC_BOOTLOADER_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.RSC_Bootloader_Version >> can.RSC_SW_VERSION_RSC_BOOTLOADER_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.RSC_Bootloader_Version >> can.RSC_SW_VERSION_RSC_BOOTLOADER_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.RSC_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_LSC_HW_Version_Info(ConverterInitialize.LSC_HW_Version_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Hardware_Version = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.LSC_HW_VERSION_INFO_CANID_LSC_HARDWARE_VERSION_OFFSET));

        return can.LSC_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_LSC_HW_Version_Info(ConverterInitialize.LSC_HW_Version_Info_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Hardware_Version = (long) (messages.LSC_Hardware_Version - can.LSC_HW_VERSION_INFO_CANID_LSC_HARDWARE_VERSION_OFFSET);
        data[0] = (byte) ((messages.LSC_Hardware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.LSC_Hardware_Version >> can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.LSC_Hardware_Version >> can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.LSC_Hardware_Version >> can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.LSC_Hardware_Version >> can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.LSC_Hardware_Version >> can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.LSC_Hardware_Version >> can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.LSC_Hardware_Version >> can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.LSC_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_LSC_SW_Version(ConverterInitialize.LSC_SW_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Firmware_Version = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.LSC_SW_VERSION_LSC_FIRMWARE_VERSION_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.LSC_SW_VERSION_LSC_FIRMWARE_VERSION_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.LSC_SW_VERSION_LSC_FIRMWARE_VERSION_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.LSC_SW_VERSION_CANID_LSC_FIRMWARE_VERSION_OFFSET));
        messages.LSC_Bootloader_Version = (int) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.LSC_SW_VERSION_LSC_BOOTLOADER_VERSION_MASK0) | ((data[6] & (can.SIGNLE_READ_Mask8)) << can.LSC_SW_VERSION_LSC_BOOTLOADER_VERSION_MASK1) | ((data[5] & (can.SIGNLE_READ_Mask8)) << can.LSC_SW_VERSION_LSC_BOOTLOADER_VERSION_MASK2) | (data[4] & (can.SIGNLE_READ_Mask8))) + (int) (can.LSC_SW_VERSION_CANID_LSC_BOOTLOADER_VERSION_OFFSET));

        return can.LSC_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_LSC_SW_Version(ConverterInitialize.LSC_SW_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Firmware_Version = (int) (messages.LSC_Firmware_Version - can.LSC_SW_VERSION_CANID_LSC_FIRMWARE_VERSION_OFFSET);
        messages.LSC_Bootloader_Version = (int) (messages.LSC_Bootloader_Version - can.LSC_SW_VERSION_CANID_LSC_BOOTLOADER_VERSION_OFFSET);
        data[0] = (byte) ((messages.LSC_Firmware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.LSC_Firmware_Version >> can.LSC_SW_VERSION_LSC_FIRMWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.LSC_Firmware_Version >> can.LSC_SW_VERSION_LSC_FIRMWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.LSC_Firmware_Version >> can.LSC_SW_VERSION_LSC_FIRMWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.LSC_Bootloader_Version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.LSC_Bootloader_Version >> can.LSC_SW_VERSION_LSC_BOOTLOADER_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.LSC_Bootloader_Version >> can.LSC_SW_VERSION_LSC_BOOTLOADER_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.LSC_Bootloader_Version >> can.LSC_SW_VERSION_LSC_BOOTLOADER_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.LSC_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_IMU_Data_Y(ConverterInitialize.IMU_Data_Y_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Accelerometer_Yaxis = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Y_ACCELEROMETER_YAXIS_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Y_ACCELEROMETER_YAXIS_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Y_ACCELEROMETER_YAXIS_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.IMU_DATA_Y_CANID_ACCELEROMETER_YAXIS_OFFSET));
        messages.Gyroscope_Yaxis = (int) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Y_GYROSCOPE_YAXIS_MASK0) | ((data[6] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Y_GYROSCOPE_YAXIS_MASK1) | ((data[5] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Y_GYROSCOPE_YAXIS_MASK2) | (data[4] & (can.SIGNLE_READ_Mask8))) + (int) (can.IMU_DATA_Y_CANID_GYROSCOPE_YAXIS_OFFSET));

        return can.IMU_DATA_Y_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_IMU_Data_Y(ConverterInitialize.IMU_Data_Y_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Accelerometer_Yaxis = (int) (messages.Accelerometer_Yaxis - can.IMU_DATA_Y_CANID_ACCELEROMETER_YAXIS_OFFSET);
        messages.Gyroscope_Yaxis = (int) (messages.Gyroscope_Yaxis - can.IMU_DATA_Y_CANID_GYROSCOPE_YAXIS_OFFSET);
        data[0] = (byte) ((messages.Accelerometer_Yaxis & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Accelerometer_Yaxis >> can.IMU_DATA_Y_ACCELEROMETER_YAXIS_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.Accelerometer_Yaxis >> can.IMU_DATA_Y_ACCELEROMETER_YAXIS_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Accelerometer_Yaxis >> can.IMU_DATA_Y_ACCELEROMETER_YAXIS_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Gyroscope_Yaxis & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Gyroscope_Yaxis >> can.IMU_DATA_Y_GYROSCOPE_YAXIS_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.Gyroscope_Yaxis >> can.IMU_DATA_Y_GYROSCOPE_YAXIS_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Gyroscope_Yaxis >> can.IMU_DATA_Y_GYROSCOPE_YAXIS_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.IMU_DATA_Y_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_IC_Paramter_1(ConverterInitialize.IC_Paramter_1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.LED_Temp = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.IC_PARAMTER_1_LED_TEMP_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.IC_PARAMTER_1_CANID_LED_TEMP_OFFSET));
        messages.Temp_Sensor_Input_Controller = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.IC_PARAMTER_1_TEMP_SENSOR_INPUT_CONTROLLER_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.IC_PARAMTER_1_CANID_TEMP_SENSOR_INPUT_CONTROLLER_OFFSET));
        messages.MAin_Input_Supply = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.IC_PARAMTER_1_MAIN_INPUT_SUPPLY_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.IC_PARAMTER_1_CANID_MAIN_INPUT_SUPPLY_OFFSET));
        messages.Temp_Sensor_Input_Ambient = (short) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.IC_PARAMTER_1_TEMP_SENSOR_INPUT_AMBIENT_MASK0) | (data[6] & (can.SIGNLE_READ_Mask8))) + (short) (can.IC_PARAMTER_1_CANID_TEMP_SENSOR_INPUT_AMBIENT_OFFSET));

        return can.IC_PARAMTER_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_IC_Paramter_1(ConverterInitialize.IC_Paramter_1_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.LED_Temp = (short) (messages.LED_Temp - can.IC_PARAMTER_1_CANID_LED_TEMP_OFFSET);
        messages.Temp_Sensor_Input_Controller = (short) (messages.Temp_Sensor_Input_Controller - can.IC_PARAMTER_1_CANID_TEMP_SENSOR_INPUT_CONTROLLER_OFFSET);
        messages.MAin_Input_Supply = (short) (messages.MAin_Input_Supply - can.IC_PARAMTER_1_CANID_MAIN_INPUT_SUPPLY_OFFSET);
        messages.Temp_Sensor_Input_Ambient = (short) (messages.Temp_Sensor_Input_Ambient - can.IC_PARAMTER_1_CANID_TEMP_SENSOR_INPUT_AMBIENT_OFFSET);
        data[0] = (byte) ((messages.LED_Temp & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.LED_Temp >> can.IC_PARAMTER_1_LED_TEMP_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Temp_Sensor_Input_Controller & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Temp_Sensor_Input_Controller >> can.IC_PARAMTER_1_TEMP_SENSOR_INPUT_CONTROLLER_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.MAin_Input_Supply & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.MAin_Input_Supply >> can.IC_PARAMTER_1_MAIN_INPUT_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Temp_Sensor_Input_Ambient & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Temp_Sensor_Input_Ambient >> can.IC_PARAMTER_1_TEMP_SENSOR_INPUT_AMBIENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.IC_PARAMTER_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ICM_Digital_Input(ConverterInitialize.ICM_Digital_Input_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Backlight_Driver_Fault_Input = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.ICM_DIGITAL_INPUT_CANID_BACKLIGHT_DRIVER_FAULT_INPUT_OFFSET));
        messages.Ambient_Light_Sensor_Interrupt = (byte) ((((data[0] >> can.ICM_DIGITAL_INPUT_AMBIENT_LIGHT_SENSOR_INTERRUPT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ICM_DIGITAL_INPUT_CANID_AMBIENT_LIGHT_SENSOR_INTERRUPT_OFFSET));
        messages.Ambient_Temp_Sensor_Interrupt = (byte) ((((data[0] >> can.ICM_DIGITAL_INPUT_AMBIENT_TEMP_SENSOR_INTERRUPT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ICM_DIGITAL_INPUT_CANID_AMBIENT_TEMP_SENSOR_INTERRUPT_OFFSET));
        messages.Warning_Status = (byte) ((((data[0] >> can.ICM_DIGITAL_INPUT_WARNING_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ICM_DIGITAL_INPUT_CANID_WARNING_STATUS_OFFSET));
        messages.Error_Status = (byte) ((((data[0] >> can.ICM_DIGITAL_INPUT_ERROR_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ICM_DIGITAL_INPUT_CANID_ERROR_STATUS_OFFSET));
        messages.Warning_Counter = (byte) (((data[1] & (can.SIGNLE_READ_Mask8))) + (byte) (can.ICM_DIGITAL_INPUT_CANID_WARNING_COUNTER_OFFSET));
        messages.Error_Counter = (byte) (((data[2] & (can.SIGNLE_READ_Mask8))) + (byte) (can.ICM_DIGITAL_INPUT_CANID_ERROR_COUNTER_OFFSET));
        messages.Reset_Counter = (byte) (((data[3] & (can.SIGNLE_READ_Mask8))) + (byte) (can.ICM_DIGITAL_INPUT_CANID_RESET_COUNTER_OFFSET));

        return can.ICM_DIGITAL_INPUT_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ICM_Digital_Input(ConverterInitialize.ICM_Digital_Input_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Backlight_Driver_Fault_Input = (byte) (messages.Backlight_Driver_Fault_Input - can.ICM_DIGITAL_INPUT_CANID_BACKLIGHT_DRIVER_FAULT_INPUT_OFFSET);
        messages.Ambient_Light_Sensor_Interrupt = (byte) (messages.Ambient_Light_Sensor_Interrupt - can.ICM_DIGITAL_INPUT_CANID_AMBIENT_LIGHT_SENSOR_INTERRUPT_OFFSET);
        messages.Ambient_Temp_Sensor_Interrupt = (byte) (messages.Ambient_Temp_Sensor_Interrupt - can.ICM_DIGITAL_INPUT_CANID_AMBIENT_TEMP_SENSOR_INTERRUPT_OFFSET);
        messages.Warning_Status = (byte) (messages.Warning_Status - can.ICM_DIGITAL_INPUT_CANID_WARNING_STATUS_OFFSET);
        messages.Error_Status = (byte) (messages.Error_Status - can.ICM_DIGITAL_INPUT_CANID_ERROR_STATUS_OFFSET);
        messages.Warning_Counter = (byte) (messages.Warning_Counter - can.ICM_DIGITAL_INPUT_CANID_WARNING_COUNTER_OFFSET);
        messages.Error_Counter = (byte) (messages.Error_Counter - can.ICM_DIGITAL_INPUT_CANID_ERROR_COUNTER_OFFSET);
        messages.Reset_Counter = (byte) (messages.Reset_Counter - can.ICM_DIGITAL_INPUT_CANID_RESET_COUNTER_OFFSET);
        data[0] = (byte) ((messages.Backlight_Driver_Fault_Input & (can.SIGNLE_READ_Mask1)) | ((messages.Ambient_Light_Sensor_Interrupt & (can.SIGNLE_READ_Mask1)) << can.ICM_DIGITAL_INPUT_AMBIENT_LIGHT_SENSOR_INTERRUPT_MASK0) | ((messages.Ambient_Temp_Sensor_Interrupt & (can.SIGNLE_READ_Mask1)) << can.ICM_DIGITAL_INPUT_AMBIENT_TEMP_SENSOR_INTERRUPT_MASK0) | ((messages.Warning_Status & (can.SIGNLE_READ_Mask1)) << can.ICM_DIGITAL_INPUT_WARNING_STATUS_MASK0) | ((messages.Error_Status & (can.SIGNLE_READ_Mask1)) << can.ICM_DIGITAL_INPUT_ERROR_STATUS_MASK0));
        data[1] = (byte) ((messages.Warning_Counter & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Error_Counter & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) ((messages.Reset_Counter & (can.SIGNLE_READ_Mask8)));
        return can.ICM_DIGITAL_INPUT_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_IMU_Data_Z(ConverterInitialize.IMU_Data_Z_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Accelerometer_Zaxis = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Z_ACCELEROMETER_ZAXIS_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Z_ACCELEROMETER_ZAXIS_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Z_ACCELEROMETER_ZAXIS_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.IMU_DATA_Z_CANID_ACCELEROMETER_ZAXIS_OFFSET));
        messages.Gyroscope_Zaxis = (int) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Z_GYROSCOPE_ZAXIS_MASK0) | ((data[6] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Z_GYROSCOPE_ZAXIS_MASK1) | ((data[5] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Z_GYROSCOPE_ZAXIS_MASK2) | (data[4] & (can.SIGNLE_READ_Mask8))) + (int) (can.IMU_DATA_Z_CANID_GYROSCOPE_ZAXIS_OFFSET));

        return can.IMU_DATA_Z_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_IMU_Data_Z(ConverterInitialize.IMU_Data_Z_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Accelerometer_Zaxis = (int) (messages.Accelerometer_Zaxis - can.IMU_DATA_Z_CANID_ACCELEROMETER_ZAXIS_OFFSET);
        messages.Gyroscope_Zaxis = (int) (messages.Gyroscope_Zaxis - can.IMU_DATA_Z_CANID_GYROSCOPE_ZAXIS_OFFSET);
        data[0] = (byte) ((messages.Accelerometer_Zaxis & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Accelerometer_Zaxis >> can.IMU_DATA_Z_ACCELEROMETER_ZAXIS_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.Accelerometer_Zaxis >> can.IMU_DATA_Z_ACCELEROMETER_ZAXIS_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Accelerometer_Zaxis >> can.IMU_DATA_Z_ACCELEROMETER_ZAXIS_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Gyroscope_Zaxis & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Gyroscope_Zaxis >> can.IMU_DATA_Z_GYROSCOPE_ZAXIS_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.Gyroscope_Zaxis >> can.IMU_DATA_Z_GYROSCOPE_ZAXIS_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Gyroscope_Zaxis >> can.IMU_DATA_Z_GYROSCOPE_ZAXIS_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.IMU_DATA_Z_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_SOFTWARE_VERSIONS(ConverterInitialize.BMS_SOFTWARE_VERSIONS_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Firmware_Version = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_SOFTWARE_VERSIONS_BMS_FIRMWARE_VERSION_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.BMS_SOFTWARE_VERSIONS_BMS_FIRMWARE_VERSION_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_SOFTWARE_VERSIONS_BMS_FIRMWARE_VERSION_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.BMS_SOFTWARE_VERSIONS_CANID_BMS_FIRMWARE_VERSION_OFFSET));
        messages.BMS_Bootloader_Version = (int) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_SOFTWARE_VERSIONS_BMS_BOOTLOADER_VERSION_MASK0) | ((data[6] & (can.SIGNLE_READ_Mask8)) << can.BMS_SOFTWARE_VERSIONS_BMS_BOOTLOADER_VERSION_MASK1) | ((data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_SOFTWARE_VERSIONS_BMS_BOOTLOADER_VERSION_MASK2) | (data[4] & (can.SIGNLE_READ_Mask8))) + (int) (can.BMS_SOFTWARE_VERSIONS_CANID_BMS_BOOTLOADER_VERSION_OFFSET));

        return can.BMS_SOFTWARE_VERSIONS_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_SOFTWARE_VERSIONS(ConverterInitialize.BMS_SOFTWARE_VERSIONS_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Firmware_Version = (int) (messages.BMS_Firmware_Version - can.BMS_SOFTWARE_VERSIONS_CANID_BMS_FIRMWARE_VERSION_OFFSET);
        messages.BMS_Bootloader_Version = (int) (messages.BMS_Bootloader_Version - can.BMS_SOFTWARE_VERSIONS_CANID_BMS_BOOTLOADER_VERSION_OFFSET);
        data[0] = (byte) ((messages.BMS_Firmware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.BMS_Firmware_Version >> can.BMS_SOFTWARE_VERSIONS_BMS_FIRMWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.BMS_Firmware_Version >> can.BMS_SOFTWARE_VERSIONS_BMS_FIRMWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.BMS_Firmware_Version >> can.BMS_SOFTWARE_VERSIONS_BMS_FIRMWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.BMS_Bootloader_Version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.BMS_Bootloader_Version >> can.BMS_SOFTWARE_VERSIONS_BMS_BOOTLOADER_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.BMS_Bootloader_Version >> can.BMS_SOFTWARE_VERSIONS_BMS_BOOTLOADER_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.BMS_Bootloader_Version >> can.BMS_SOFTWARE_VERSIONS_BMS_BOOTLOADER_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_SOFTWARE_VERSIONS_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ABS_Software_Version(ConverterInitialize.ABS_Software_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Firmware_version = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.ABS_SOFTWARE_VERSION_ABS_FIRMWARE_VERSION_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.ABS_SOFTWARE_VERSION_ABS_FIRMWARE_VERSION_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.ABS_SOFTWARE_VERSION_ABS_FIRMWARE_VERSION_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.ABS_SOFTWARE_VERSION_CANID_ABS_FIRMWARE_VERSION_OFFSET));
        messages.ABS_Bootloader_version = (int) ((((data[7] & (can.SIGNLE_READ_Mask8)) << can.ABS_SOFTWARE_VERSION_ABS_BOOTLOADER_VERSION_MASK0) | ((data[6] & (can.SIGNLE_READ_Mask8)) << can.ABS_SOFTWARE_VERSION_ABS_BOOTLOADER_VERSION_MASK1) | ((data[5] & (can.SIGNLE_READ_Mask8)) << can.ABS_SOFTWARE_VERSION_ABS_BOOTLOADER_VERSION_MASK2) | (data[4] & (can.SIGNLE_READ_Mask8))) + (int) (can.ABS_SOFTWARE_VERSION_CANID_ABS_BOOTLOADER_VERSION_OFFSET));

        return can.ABS_SOFTWARE_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ABS_Software_Version(ConverterInitialize.ABS_Software_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Firmware_version = (int) (messages.ABS_Firmware_version - can.ABS_SOFTWARE_VERSION_CANID_ABS_FIRMWARE_VERSION_OFFSET);
        messages.ABS_Bootloader_version = (int) (messages.ABS_Bootloader_version - can.ABS_SOFTWARE_VERSION_CANID_ABS_BOOTLOADER_VERSION_OFFSET);
        data[0] = (byte) ((messages.ABS_Firmware_version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.ABS_Firmware_version >> can.ABS_SOFTWARE_VERSION_ABS_FIRMWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.ABS_Firmware_version >> can.ABS_SOFTWARE_VERSION_ABS_FIRMWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.ABS_Firmware_version >> can.ABS_SOFTWARE_VERSION_ABS_FIRMWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.ABS_Bootloader_version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.ABS_Bootloader_version >> can.ABS_SOFTWARE_VERSION_ABS_BOOTLOADER_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.ABS_Bootloader_version >> can.ABS_SOFTWARE_VERSION_ABS_BOOTLOADER_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.ABS_Bootloader_version >> can.ABS_SOFTWARE_VERSION_ABS_BOOTLOADER_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ABS_SOFTWARE_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_HARDWARE_VERSION(ConverterInitialize.BMS_HARDWARE_VERSION_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Hardware_Version = (int) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_HARDWARE_VERSION_BMS_HARDWARE_VERSION_MASK0) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.BMS_HARDWARE_VERSION_BMS_HARDWARE_VERSION_MASK1) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_HARDWARE_VERSION_BMS_HARDWARE_VERSION_MASK2) | (data[0] & (can.SIGNLE_READ_Mask8))) + (int) (can.BMS_HARDWARE_VERSION_CANID_BMS_HARDWARE_VERSION_OFFSET));

        return can.BMS_HARDWARE_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_HARDWARE_VERSION(ConverterInitialize.BMS_HARDWARE_VERSION_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Hardware_Version = (int) (messages.BMS_Hardware_Version - can.BMS_HARDWARE_VERSION_CANID_BMS_HARDWARE_VERSION_OFFSET);
        data[0] = (byte) ((messages.BMS_Hardware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.BMS_Hardware_Version >> can.BMS_HARDWARE_VERSION_BMS_HARDWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.BMS_Hardware_Version >> can.BMS_HARDWARE_VERSION_BMS_HARDWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.BMS_Hardware_Version >> can.BMS_HARDWARE_VERSION_BMS_HARDWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_HARDWARE_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ABS_Hardware_Version(ConverterInitialize.ABS_Hardware_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Hardware_version = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.ABS_HARDWARE_VERSION_CANID_ABS_HARDWARE_VERSION_OFFSET));

        return can.ABS_HARDWARE_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ABS_Hardware_Version(ConverterInitialize.ABS_Hardware_Version_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Hardware_version = (long) (messages.ABS_Hardware_version - can.ABS_HARDWARE_VERSION_CANID_ABS_HARDWARE_VERSION_OFFSET);
        data[0] = (byte) ((messages.ABS_Hardware_version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.ABS_Hardware_version >> can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.ABS_Hardware_version >> can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.ABS_Hardware_version >> can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.ABS_Hardware_version >> can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.ABS_Hardware_version >> can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.ABS_Hardware_version >> can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.ABS_Hardware_version >> can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ABS_HARDWARE_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_Diagnostic_Request(ConverterInitialize.BMS_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Diag_Request = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.BMS_DIAGNOSTIC_REQUEST_CANID_BMS_DIAG_REQUEST_OFFSET));

        return can.BMS_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_Diagnostic_Request(ConverterInitialize.BMS_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Diag_Request = (long) (messages.BMS_Diag_Request - can.BMS_DIAGNOSTIC_REQUEST_CANID_BMS_DIAG_REQUEST_OFFSET);
        data[0] = (byte) ((messages.BMS_Diag_Request & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.BMS_Diag_Request >> can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.BMS_Diag_Request >> can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.BMS_Diag_Request >> can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.BMS_Diag_Request >> can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.BMS_Diag_Request >> can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.BMS_Diag_Request >> can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.BMS_Diag_Request >> can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_Diagnostic_Response(ConverterInitialize.BMS_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Diag_Resp = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.BMS_DIAGNOSTIC_RESPONSE_CANID_BMS_DIAG_RESP_OFFSET));

        return can.BMS_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_Diagnostic_Response(ConverterInitialize.BMS_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Diag_Resp = (long) (messages.BMS_Diag_Resp - can.BMS_DIAGNOSTIC_RESPONSE_CANID_BMS_DIAG_RESP_OFFSET);
        data[0] = (byte) ((messages.BMS_Diag_Resp & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.BMS_Diag_Resp >> can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.BMS_Diag_Resp >> can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.BMS_Diag_Resp >> can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.BMS_Diag_Resp >> can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.BMS_Diag_Resp >> can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.BMS_Diag_Resp >> can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.BMS_Diag_Resp >> can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OTA_Status(ConverterInitialize.OTA_Status_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OTA_Status_Info = (byte) (((data[0] & (can.SIGNLE_READ_Mask2))) + (byte) (can.OTA_STATUS_CANID_OTA_STATUS_INFO_OFFSET));

        return can.OTA_STATUS_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OTA_Status(ConverterInitialize.OTA_Status_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OTA_Status_Info = (byte) (messages.OTA_Status_Info - can.OTA_STATUS_CANID_OTA_STATUS_INFO_OFFSET);
        data[0] = (byte) ((messages.OTA_Status_Info & (can.SIGNLE_READ_Mask2)));
        return can.OTA_STATUS_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Vehicle_left_SW_Cube(ConverterInitialize.Vehicle_left_SW_Cube_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.High_beam = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_HIGH_BEAM_OFFSET));
        messages.Low_beam = (byte) ((((data[0] >> can.VEHICLE_LEFT_SW_CUBE_LOW_BEAM_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_LOW_BEAM_OFFSET));
        messages.Pass_beam = (byte) ((((data[0] >> can.VEHICLE_LEFT_SW_CUBE_PASS_BEAM_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_PASS_BEAM_OFFSET));
        messages.Left_Indicator = (byte) ((((data[0] >> can.VEHICLE_LEFT_SW_CUBE_LEFT_INDICATOR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_LEFT_INDICATOR_OFFSET));
        messages.Cruise_Control = (byte) ((((data[0] >> can.VEHICLE_LEFT_SW_CUBE_CRUISE_CONTROL_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_CRUISE_CONTROL_OFFSET));
        messages.Right_Indicator = (byte) ((((data[0] >> can.VEHICLE_LEFT_SW_CUBE_RIGHT_INDICATOR_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_RIGHT_INDICATOR_OFFSET));
        messages.Horn = (byte) ((((data[0] >> can.VEHICLE_LEFT_SW_CUBE_HORN_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_HORN_OFFSET));
        messages.Eco_Mode = (byte) ((((data[0] >> can.VEHICLE_LEFT_SW_CUBE_ECO_MODE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_ECO_MODE_OFFSET));
        messages.Tour_Mode = (byte) (((data[1] & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_TOUR_MODE_OFFSET));
        messages.Sports_Mode = (byte) ((((data[1] >> can.VEHICLE_LEFT_SW_CUBE_SPORTS_MODE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_SPORTS_MODE_OFFSET));
        messages.Turbo_mode = (byte) ((((data[1] >> can.VEHICLE_LEFT_SW_CUBE_TURBO_MODE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_TURBO_MODE_OFFSET));
        messages.Neutral = (byte) ((((data[1] >> can.VEHICLE_LEFT_SW_CUBE_NEUTRAL_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_NEUTRAL_OFFSET));
        messages.Park_Assist = (byte) ((((data[1] >> can.VEHICLE_LEFT_SW_CUBE_PARK_ASSIST_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_PARK_ASSIST_OFFSET));
        messages.Home = (byte) ((((data[1] >> can.VEHICLE_LEFT_SW_CUBE_HOME_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_HOME_OFFSET));
        messages.Joystick_Up = (byte) (((data[2] & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_UP_OFFSET));
        messages.Joystick_Down = (byte) ((((data[2] >> can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_DOWN_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_DOWN_OFFSET));
        messages.Joystick_Left = (byte) ((((data[2] >> can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_LEFT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_LEFT_OFFSET));
        messages.Joystick_Right = (byte) ((((data[2] >> can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_RIGHT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_RIGHT_OFFSET));
        messages.Joystick_SET_RST = (byte) ((((data[2] >> can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_SET_RST_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_SET_RST_OFFSET));
        messages.LSC_Power_Status = (byte) ((((data[2] >> can.VEHICLE_LEFT_SW_CUBE_LSC_POWER_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_LSC_POWER_STATUS_OFFSET));
        messages.Joystick_fault = (byte) ((((data[2] >> can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_FAULT_OFFSET));
        messages.Mode_Selector_Roller_fault = (byte) ((((data[2] >> can.VEHICLE_LEFT_SW_CUBE_MODE_SELECTOR_ROLLER_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_MODE_SELECTOR_ROLLER_FAULT_OFFSET));
        messages.Left_Indicator_Button_fault = (byte) (((data[3] & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_LEFT_INDICATOR_BUTTON_FAULT_OFFSET));
        messages.Cruise_Control_Button_fault = (byte) ((((data[3] >> can.VEHICLE_LEFT_SW_CUBE_CRUISE_CONTROL_BUTTON_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_CRUISE_CONTROL_BUTTON_FAULT_OFFSET));
        messages.Horn_Button_fault = (byte) ((((data[3] >> can.VEHICLE_LEFT_SW_CUBE_HORN_BUTTON_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_HORN_BUTTON_FAULT_OFFSET));
        messages.Home_Button_fault = (byte) ((((data[3] >> can.VEHICLE_LEFT_SW_CUBE_HOME_BUTTON_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_HOME_BUTTON_FAULT_OFFSET));
        messages.LSC_System_fault = (byte) ((((data[3] >> can.VEHICLE_LEFT_SW_CUBE_LSC_SYSTEM_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_LEFT_SW_CUBE_CANID_LSC_SYSTEM_FAULT_OFFSET));

        return can.VEHICLE_LEFT_SW_CUBE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Vehicle_left_SW_Cube(ConverterInitialize.Vehicle_left_SW_Cube_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.High_beam = (byte) (messages.High_beam - can.VEHICLE_LEFT_SW_CUBE_CANID_HIGH_BEAM_OFFSET);
        messages.Low_beam = (byte) (messages.Low_beam - can.VEHICLE_LEFT_SW_CUBE_CANID_LOW_BEAM_OFFSET);
        messages.Pass_beam = (byte) (messages.Pass_beam - can.VEHICLE_LEFT_SW_CUBE_CANID_PASS_BEAM_OFFSET);
        messages.Left_Indicator = (byte) (messages.Left_Indicator - can.VEHICLE_LEFT_SW_CUBE_CANID_LEFT_INDICATOR_OFFSET);
        messages.Cruise_Control = (byte) (messages.Cruise_Control - can.VEHICLE_LEFT_SW_CUBE_CANID_CRUISE_CONTROL_OFFSET);
        messages.Right_Indicator = (byte) (messages.Right_Indicator - can.VEHICLE_LEFT_SW_CUBE_CANID_RIGHT_INDICATOR_OFFSET);
        messages.Horn = (byte) (messages.Horn - can.VEHICLE_LEFT_SW_CUBE_CANID_HORN_OFFSET);
        messages.Eco_Mode = (byte) (messages.Eco_Mode - can.VEHICLE_LEFT_SW_CUBE_CANID_ECO_MODE_OFFSET);
        messages.Tour_Mode = (byte) (messages.Tour_Mode - can.VEHICLE_LEFT_SW_CUBE_CANID_TOUR_MODE_OFFSET);
        messages.Sports_Mode = (byte) (messages.Sports_Mode - can.VEHICLE_LEFT_SW_CUBE_CANID_SPORTS_MODE_OFFSET);
        messages.Turbo_mode = (byte) (messages.Turbo_mode - can.VEHICLE_LEFT_SW_CUBE_CANID_TURBO_MODE_OFFSET);
        messages.Neutral = (byte) (messages.Neutral - can.VEHICLE_LEFT_SW_CUBE_CANID_NEUTRAL_OFFSET);
        messages.Park_Assist = (byte) (messages.Park_Assist - can.VEHICLE_LEFT_SW_CUBE_CANID_PARK_ASSIST_OFFSET);
        messages.Home = (byte) (messages.Home - can.VEHICLE_LEFT_SW_CUBE_CANID_HOME_OFFSET);
        messages.Joystick_Up = (byte) (messages.Joystick_Up - can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_UP_OFFSET);
        messages.Joystick_Down = (byte) (messages.Joystick_Down - can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_DOWN_OFFSET);
        messages.Joystick_Left = (byte) (messages.Joystick_Left - can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_LEFT_OFFSET);
        messages.Joystick_Right = (byte) (messages.Joystick_Right - can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_RIGHT_OFFSET);
        messages.Joystick_SET_RST = (byte) (messages.Joystick_SET_RST - can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_SET_RST_OFFSET);
        messages.LSC_Power_Status = (byte) (messages.LSC_Power_Status - can.VEHICLE_LEFT_SW_CUBE_CANID_LSC_POWER_STATUS_OFFSET);
        messages.Joystick_fault = (byte) (messages.Joystick_fault - can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_FAULT_OFFSET);
        messages.Mode_Selector_Roller_fault = (byte) (messages.Mode_Selector_Roller_fault - can.VEHICLE_LEFT_SW_CUBE_CANID_MODE_SELECTOR_ROLLER_FAULT_OFFSET);
        messages.Left_Indicator_Button_fault = (byte) (messages.Left_Indicator_Button_fault - can.VEHICLE_LEFT_SW_CUBE_CANID_LEFT_INDICATOR_BUTTON_FAULT_OFFSET);
        messages.Cruise_Control_Button_fault = (byte) (messages.Cruise_Control_Button_fault - can.VEHICLE_LEFT_SW_CUBE_CANID_CRUISE_CONTROL_BUTTON_FAULT_OFFSET);
        messages.Horn_Button_fault = (byte) (messages.Horn_Button_fault - can.VEHICLE_LEFT_SW_CUBE_CANID_HORN_BUTTON_FAULT_OFFSET);
        messages.Home_Button_fault = (byte) (messages.Home_Button_fault - can.VEHICLE_LEFT_SW_CUBE_CANID_HOME_BUTTON_FAULT_OFFSET);
        messages.LSC_System_fault = (byte) (messages.LSC_System_fault - can.VEHICLE_LEFT_SW_CUBE_CANID_LSC_SYSTEM_FAULT_OFFSET);
        data[0] = (byte) ((messages.High_beam & (can.SIGNLE_READ_Mask1)) | ((messages.Low_beam & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_LOW_BEAM_MASK0) | ((messages.Pass_beam & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_PASS_BEAM_MASK0) | ((messages.Left_Indicator & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_LEFT_INDICATOR_MASK0) | ((messages.Cruise_Control & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_CRUISE_CONTROL_MASK0) | ((messages.Right_Indicator & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_RIGHT_INDICATOR_MASK0) | ((messages.Horn & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_HORN_MASK0) | ((messages.Eco_Mode & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_ECO_MODE_MASK0));
        data[1] = (byte) ((messages.Tour_Mode & (can.SIGNLE_READ_Mask1)) | ((messages.Sports_Mode & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_SPORTS_MODE_MASK0) | ((messages.Turbo_mode & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_TURBO_MODE_MASK0) | ((messages.Neutral & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_NEUTRAL_MASK0) | ((messages.Park_Assist & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_PARK_ASSIST_MASK0) | ((messages.Home & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_HOME_MASK0));
        data[2] = (byte) ((messages.Joystick_Up & (can.SIGNLE_READ_Mask1)) | ((messages.Joystick_Down & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_DOWN_MASK0) | ((messages.Joystick_Left & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_LEFT_MASK0) | ((messages.Joystick_Right & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_RIGHT_MASK0) | ((messages.Joystick_SET_RST & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_SET_RST_MASK0) | ((messages.LSC_Power_Status & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_LSC_POWER_STATUS_MASK0) | ((messages.Joystick_fault & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_FAULT_MASK0) | ((messages.Mode_Selector_Roller_fault & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_MODE_SELECTOR_ROLLER_FAULT_MASK0));
        data[3] = (byte) ((messages.Left_Indicator_Button_fault & (can.SIGNLE_READ_Mask1)) | ((messages.Cruise_Control_Button_fault & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_CRUISE_CONTROL_BUTTON_FAULT_MASK0) | ((messages.Horn_Button_fault & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_HORN_BUTTON_FAULT_MASK0) | ((messages.Home_Button_fault & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_HOME_BUTTON_FAULT_MASK0) | ((messages.LSC_System_fault & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_LSC_SYSTEM_FAULT_MASK0));
        return can.VEHICLE_LEFT_SW_CUBE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Vehicle_Right_SW_Cube(ConverterInitialize.Vehicle_Right_SW_Cube_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Voice_Assist = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_RIGHT_SW_CUBE_CANID_VOICE_ASSIST_OFFSET));
        messages.Regen = (byte) ((((data[0] >> can.VEHICLE_RIGHT_SW_CUBE_REGEN_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_RIGHT_SW_CUBE_CANID_REGEN_OFFSET));
        messages.Key_Ignition = (byte) ((((data[0] >> can.VEHICLE_RIGHT_SW_CUBE_KEY_IGNITION_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_RIGHT_SW_CUBE_CANID_KEY_IGNITION_OFFSET));
        messages.Start_Button = (byte) (((data[1] & (can.SIGNLE_READ_Mask1))) + (byte) (can.VEHICLE_RIGHT_SW_CUBE_CANID_START_BUTTON_OFFSET));

        return can.VEHICLE_RIGHT_SW_CUBE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Vehicle_Right_SW_Cube(ConverterInitialize.Vehicle_Right_SW_Cube_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Voice_Assist = (byte) (messages.Voice_Assist - can.VEHICLE_RIGHT_SW_CUBE_CANID_VOICE_ASSIST_OFFSET);
        messages.Regen = (byte) (messages.Regen - can.VEHICLE_RIGHT_SW_CUBE_CANID_REGEN_OFFSET);
        messages.Key_Ignition = (byte) (messages.Key_Ignition - can.VEHICLE_RIGHT_SW_CUBE_CANID_KEY_IGNITION_OFFSET);
        messages.Start_Button = (byte) (messages.Start_Button - can.VEHICLE_RIGHT_SW_CUBE_CANID_START_BUTTON_OFFSET);
        data[0] = (byte) ((messages.Voice_Assist & (can.SIGNLE_READ_Mask1)) | ((messages.Regen & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_RIGHT_SW_CUBE_REGEN_MASK0) | ((messages.Key_Ignition & (can.SIGNLE_READ_Mask1)) << can.VEHICLE_RIGHT_SW_CUBE_KEY_IGNITION_MASK0));
        data[1] = (byte) ((messages.Start_Button & (can.SIGNLE_READ_Mask1)));
        return can.VEHICLE_RIGHT_SW_CUBE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ICM_Error(ConverterInitialize.ICM_Error_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Input_OverVoltage = (byte) (((data[0] & (can.SIGNLE_READ_Mask1))) + (byte) (can.ICM_ERROR_CANID_INPUT_OVERVOLTAGE_OFFSET));
        messages.Input_UncerVoltage = (byte) ((((data[0] >> can.ICM_ERROR_INPUT_UNCERVOLTAGE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ICM_ERROR_CANID_INPUT_UNCERVOLTAGE_OFFSET));
        messages.Input_OverCurrent = (byte) ((((data[0] >> can.ICM_ERROR_INPUT_OVERCURRENT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ICM_ERROR_CANID_INPUT_OVERCURRENT_OFFSET));
        messages.Output_OverCurrent = (byte) ((((data[0] >> can.ICM_ERROR_OUTPUT_OVERCURRENT_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ICM_ERROR_CANID_OUTPUT_OVERCURRENT_OFFSET));
        messages.High_Temp = (byte) ((((data[0] >> can.ICM_ERROR_HIGH_TEMP_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ICM_ERROR_CANID_HIGH_TEMP_OFFSET));
        messages.Low_Temp = (byte) ((((data[0] >> can.ICM_ERROR_LOW_TEMP_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ICM_ERROR_CANID_LOW_TEMP_OFFSET));
        messages.Temp_Sensor_Failure = (byte) ((((data[0] >> can.ICM_ERROR_TEMP_SENSOR_FAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ICM_ERROR_CANID_TEMP_SENSOR_FAILURE_OFFSET));
        messages.Output_Short_Circuit_Failure = (byte) ((((data[0] >> can.ICM_ERROR_OUTPUT_SHORT_CIRCUIT_FAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) + (byte) (can.ICM_ERROR_CANID_OUTPUT_SHORT_CIRCUIT_FAILURE_OFFSET));
        messages.Reserved = (byte) (((data[1] & (can.SIGNLE_READ_Mask1))) + (byte) (can.ICM_ERROR_CANID_RESERVED_OFFSET));

        return can.ICM_ERROR_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ICM_Error(ConverterInitialize.ICM_Error_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Input_OverVoltage = (byte) (messages.Input_OverVoltage - can.ICM_ERROR_CANID_INPUT_OVERVOLTAGE_OFFSET);
        messages.Input_UncerVoltage = (byte) (messages.Input_UncerVoltage - can.ICM_ERROR_CANID_INPUT_UNCERVOLTAGE_OFFSET);
        messages.Input_OverCurrent = (byte) (messages.Input_OverCurrent - can.ICM_ERROR_CANID_INPUT_OVERCURRENT_OFFSET);
        messages.Output_OverCurrent = (byte) (messages.Output_OverCurrent - can.ICM_ERROR_CANID_OUTPUT_OVERCURRENT_OFFSET);
        messages.High_Temp = (byte) (messages.High_Temp - can.ICM_ERROR_CANID_HIGH_TEMP_OFFSET);
        messages.Low_Temp = (byte) (messages.Low_Temp - can.ICM_ERROR_CANID_LOW_TEMP_OFFSET);
        messages.Temp_Sensor_Failure = (byte) (messages.Temp_Sensor_Failure - can.ICM_ERROR_CANID_TEMP_SENSOR_FAILURE_OFFSET);
        messages.Output_Short_Circuit_Failure = (byte) (messages.Output_Short_Circuit_Failure - can.ICM_ERROR_CANID_OUTPUT_SHORT_CIRCUIT_FAILURE_OFFSET);
        messages.Reserved = (byte) (messages.Reserved - can.ICM_ERROR_CANID_RESERVED_OFFSET);
        data[0] = (byte) ((messages.Input_OverVoltage & (can.SIGNLE_READ_Mask1)) | ((messages.Input_UncerVoltage & (can.SIGNLE_READ_Mask1)) << can.ICM_ERROR_INPUT_UNCERVOLTAGE_MASK0) | ((messages.Input_OverCurrent & (can.SIGNLE_READ_Mask1)) << can.ICM_ERROR_INPUT_OVERCURRENT_MASK0) | ((messages.Output_OverCurrent & (can.SIGNLE_READ_Mask1)) << can.ICM_ERROR_OUTPUT_OVERCURRENT_MASK0) | ((messages.High_Temp & (can.SIGNLE_READ_Mask1)) << can.ICM_ERROR_HIGH_TEMP_MASK0) | ((messages.Low_Temp & (can.SIGNLE_READ_Mask1)) << can.ICM_ERROR_LOW_TEMP_MASK0) | ((messages.Temp_Sensor_Failure & (can.SIGNLE_READ_Mask1)) << can.ICM_ERROR_TEMP_SENSOR_FAILURE_MASK0) | ((messages.Output_Short_Circuit_Failure & (can.SIGNLE_READ_Mask1)) << can.ICM_ERROR_OUTPUT_SHORT_CIRCUIT_FAILURE_MASK0));
        data[1] = (byte) ((messages.Reserved & (can.SIGNLE_READ_Mask1)));
        return can.ICM_ERROR_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_TimeStamp_Sync_Message(ConverterInitialize.TimeStamp_Sync_Message_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_TimeStamp = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.TIMESTAMP_SYNC_MESSAGE_CANID_VCU_TIMESTAMP_OFFSET));

        return can.TIMESTAMP_SYNC_MESSAGE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_TimeStamp_Sync_Message(ConverterInitialize.TimeStamp_Sync_Message_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_TimeStamp = (long) (messages.VCU_TimeStamp - can.TIMESTAMP_SYNC_MESSAGE_CANID_VCU_TIMESTAMP_OFFSET);
        data[0] = (byte) ((messages.VCU_TimeStamp & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.VCU_TimeStamp >> can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.VCU_TimeStamp >> can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.VCU_TimeStamp >> can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.VCU_TimeStamp >> can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.VCU_TimeStamp >> can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.VCU_TimeStamp >> can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.VCU_TimeStamp >> can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.TIMESTAMP_SYNC_MESSAGE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_RSC_Diagnostic_Request(ConverterInitialize.RSC_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Diag_Req = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.RSC_DIAGNOSTIC_REQUEST_CANID_RSC_DIAG_REQ_OFFSET));

        return can.RSC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_RSC_Diagnostic_Request(ConverterInitialize.RSC_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Diag_Req = (long) (messages.RSC_Diag_Req - can.RSC_DIAGNOSTIC_REQUEST_CANID_RSC_DIAG_REQ_OFFSET);
        data[0] = (byte) ((messages.RSC_Diag_Req & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.RSC_Diag_Req >> can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.RSC_Diag_Req >> can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.RSC_Diag_Req >> can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.RSC_Diag_Req >> can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.RSC_Diag_Req >> can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.RSC_Diag_Req >> can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.RSC_Diag_Req >> can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.RSC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_RSC_Diagnostic_Response(ConverterInitialize.RSC_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Diag_Resp = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.RSC_DIAGNOSTIC_RESPONSE_CANID_RSC_DIAG_RESP_OFFSET));

        return can.RSC_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_RSC_Diagnostic_Response(ConverterInitialize.RSC_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Diag_Resp = (long) (messages.RSC_Diag_Resp - can.RSC_DIAGNOSTIC_RESPONSE_CANID_RSC_DIAG_RESP_OFFSET);
        data[0] = (byte) ((messages.RSC_Diag_Resp & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.RSC_Diag_Resp >> can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.RSC_Diag_Resp >> can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.RSC_Diag_Resp >> can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.RSC_Diag_Resp >> can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.RSC_Diag_Resp >> can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.RSC_Diag_Resp >> can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.RSC_Diag_Resp >> can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.RSC_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_LSC_Diagnostic_Request(ConverterInitialize.LSC_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Diag_Req = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.LSC_DIAGNOSTIC_REQUEST_CANID_LSC_DIAG_REQ_OFFSET));

        return can.LSC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_LSC_Diagnostic_Request(ConverterInitialize.LSC_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Diag_Req = (long) (messages.LSC_Diag_Req - can.LSC_DIAGNOSTIC_REQUEST_CANID_LSC_DIAG_REQ_OFFSET);
        data[0] = (byte) ((messages.LSC_Diag_Req & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.LSC_Diag_Req >> can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.LSC_Diag_Req >> can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.LSC_Diag_Req >> can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.LSC_Diag_Req >> can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.LSC_Diag_Req >> can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.LSC_Diag_Req >> can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.LSC_Diag_Req >> can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.LSC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_LSC_Diagnostic_Response(ConverterInitialize.LSC_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Diagnostic_Response = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.LSC_DIAGNOSTIC_RESPONSE_CANID_LSC_DIAGNOSTIC_RESPONSE_OFFSET));

        return can.LSC_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_LSC_Diagnostic_Response(ConverterInitialize.LSC_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Diagnostic_Response = (long) (messages.LSC_Diagnostic_Response - can.LSC_DIAGNOSTIC_RESPONSE_CANID_LSC_DIAGNOSTIC_RESPONSE_OFFSET);
        data[0] = (byte) ((messages.LSC_Diagnostic_Response & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.LSC_Diagnostic_Response >> can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.LSC_Diagnostic_Response >> can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.LSC_Diagnostic_Response >> can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.LSC_Diagnostic_Response >> can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.LSC_Diagnostic_Response >> can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.LSC_Diagnostic_Response >> can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.LSC_Diagnostic_Response >> can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.LSC_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Diagnostic_Request(ConverterInitialize.MCU_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Diag_Request = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.MCU_DIAGNOSTIC_REQUEST_CANID_MCU_DIAG_REQUEST_OFFSET));

        return can.MCU_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Diagnostic_Request(ConverterInitialize.MCU_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Diag_Request = (long) (messages.MCU_Diag_Request - can.MCU_DIAGNOSTIC_REQUEST_CANID_MCU_DIAG_REQUEST_OFFSET);
        data[0] = (byte) ((messages.MCU_Diag_Request & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.MCU_Diag_Request >> can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.MCU_Diag_Request >> can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.MCU_Diag_Request >> can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.MCU_Diag_Request >> can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.MCU_Diag_Request >> can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.MCU_Diag_Request >> can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.MCU_Diag_Request >> can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.MCU_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Diagnostic_Response(ConverterInitialize.MCU_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Diagnostic_Response = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.MCU_DIAGNOSTIC_RESPONSE_CANID_MCU_DIAGNOSTIC_RESPONSE_OFFSET));

        return can.MCU_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Diagnostic_Response(ConverterInitialize.MCU_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Diagnostic_Response = (long) (messages.MCU_Diagnostic_Response - can.MCU_DIAGNOSTIC_RESPONSE_CANID_MCU_DIAGNOSTIC_RESPONSE_OFFSET);
        data[0] = (byte) ((messages.MCU_Diagnostic_Response & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.MCU_Diagnostic_Response >> can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.MCU_Diagnostic_Response >> can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.MCU_Diagnostic_Response >> can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.MCU_Diagnostic_Response >> can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.MCU_Diagnostic_Response >> can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.MCU_Diagnostic_Response >> can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.MCU_Diagnostic_Response >> can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.MCU_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OBC_Diagnostic_Response(ConverterInitialize.OBC_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Diag_Resp = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.OBC_DIAGNOSTIC_RESPONSE_CANID_OBC_DIAG_RESP_OFFSET));

        return can.OBC_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OBC_Diagnostic_Response(ConverterInitialize.OBC_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Diag_Resp = (long) (messages.OBC_Diag_Resp - can.OBC_DIAGNOSTIC_RESPONSE_CANID_OBC_DIAG_RESP_OFFSET);
        data[0] = (byte) ((messages.OBC_Diag_Resp & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.OBC_Diag_Resp >> can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.OBC_Diag_Resp >> can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.OBC_Diag_Resp >> can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.OBC_Diag_Resp >> can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.OBC_Diag_Resp >> can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.OBC_Diag_Resp >> can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.OBC_Diag_Resp >> can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.OBC_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ABS_Diag_Request(ConverterInitialize.ABS_Diag_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Diag_Request = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.ABS_DIAG_REQUEST_CANID_ABS_DIAG_REQUEST_OFFSET));

        return can.ABS_DIAG_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ABS_Diag_Request(ConverterInitialize.ABS_Diag_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Diag_Request = (long) (messages.ABS_Diag_Request - can.ABS_DIAG_REQUEST_CANID_ABS_DIAG_REQUEST_OFFSET);
        data[0] = (byte) ((messages.ABS_Diag_Request & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.ABS_Diag_Request >> can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.ABS_Diag_Request >> can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.ABS_Diag_Request >> can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.ABS_Diag_Request >> can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.ABS_Diag_Request >> can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.ABS_Diag_Request >> can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.ABS_Diag_Request >> can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ABS_DIAG_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ABS_Diag_Response(ConverterInitialize.ABS_Diag_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Diag_Response = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.ABS_DIAG_RESPONSE_CANID_ABS_DIAG_RESPONSE_OFFSET));

        return can.ABS_DIAG_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ABS_Diag_Response(ConverterInitialize.ABS_Diag_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Diag_Response = (long) (messages.ABS_Diag_Response - can.ABS_DIAG_RESPONSE_CANID_ABS_DIAG_RESPONSE_OFFSET);
        data[0] = (byte) ((messages.ABS_Diag_Response & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.ABS_Diag_Response >> can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.ABS_Diag_Response >> can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.ABS_Diag_Response >> can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.ABS_Diag_Response >> can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.ABS_Diag_Response >> can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.ABS_Diag_Response >> can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.ABS_Diag_Response >> can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ABS_DIAG_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OBC_Diagnostic_Request(ConverterInitialize.OBC_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Diag_Request = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.OBC_DIAGNOSTIC_REQUEST_CANID_OBC_DIAG_REQUEST_OFFSET));

        return can.OBC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OBC_Diagnostic_Request(ConverterInitialize.OBC_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Diag_Request = (long) (messages.OBC_Diag_Request - can.OBC_DIAGNOSTIC_REQUEST_CANID_OBC_DIAG_REQUEST_OFFSET);
        data[0] = (byte) ((messages.OBC_Diag_Request & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.OBC_Diag_Request >> can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.OBC_Diag_Request >> can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.OBC_Diag_Request >> can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.OBC_Diag_Request >> can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.OBC_Diag_Request >> can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.OBC_Diag_Request >> can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.OBC_Diag_Request >> can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.OBC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_HU_Diagnostic_Response(ConverterInitialize.HU_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.HU_Diagnostic_Response = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.HU_DIAGNOSTIC_RESPONSE_CANID_HU_DIAGNOSTIC_RESPONSE_OFFSET));

        return can.HU_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_HU_Diagnostic_Response(ConverterInitialize.HU_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.HU_Diagnostic_Response = (long) (messages.HU_Diagnostic_Response - can.HU_DIAGNOSTIC_RESPONSE_CANID_HU_DIAGNOSTIC_RESPONSE_OFFSET);
        data[0] = (byte) ((messages.HU_Diagnostic_Response & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.HU_Diagnostic_Response >> can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.HU_Diagnostic_Response >> can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.HU_Diagnostic_Response >> can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.HU_Diagnostic_Response >> can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.HU_Diagnostic_Response >> can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.HU_Diagnostic_Response >> can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.HU_Diagnostic_Response >> can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.HU_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_HU_Diagnostic_Request(ConverterInitialize.HU_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.HU_Diag_Req = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.HU_DIAGNOSTIC_REQUEST_CANID_HU_DIAG_REQ_OFFSET));

        return can.HU_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_HU_Diagnostic_Request(ConverterInitialize.HU_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.HU_Diag_Req = (long) (messages.HU_Diag_Req - can.HU_DIAGNOSTIC_REQUEST_CANID_HU_DIAG_REQ_OFFSET);
        data[0] = (byte) ((messages.HU_Diag_Req & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.HU_Diag_Req >> can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.HU_Diag_Req >> can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.HU_Diag_Req >> can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.HU_Diag_Req >> can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.HU_Diag_Req >> can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.HU_Diag_Req >> can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.HU_Diag_Req >> can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.HU_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ESCL_Diagnostic_Response(ConverterInitialize.ESCL_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Diagnostic_Response = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.ESCL_DIAGNOSTIC_RESPONSE_CANID_ESCL_DIAGNOSTIC_RESPONSE_OFFSET));

        return can.ESCL_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ESCL_Diagnostic_Response(ConverterInitialize.ESCL_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Diagnostic_Response = (long) (messages.ESCL_Diagnostic_Response - can.ESCL_DIAGNOSTIC_RESPONSE_CANID_ESCL_DIAGNOSTIC_RESPONSE_OFFSET);
        data[0] = (byte) ((messages.ESCL_Diagnostic_Response & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.ESCL_Diagnostic_Response >> can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.ESCL_Diagnostic_Response >> can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.ESCL_Diagnostic_Response >> can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.ESCL_Diagnostic_Response >> can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.ESCL_Diagnostic_Response >> can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.ESCL_Diagnostic_Response >> can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.ESCL_Diagnostic_Response >> can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ESCL_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ESCL_Diagnostic_Request(ConverterInitialize.ESCL_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Diag_Req = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.ESCL_DIAGNOSTIC_REQUEST_CANID_ESCL_DIAG_REQ_OFFSET));

        return can.ESCL_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ESCL_Diagnostic_Request(ConverterInitialize.ESCL_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Diag_Req = (long) (messages.ESCL_Diag_Req - can.ESCL_DIAGNOSTIC_REQUEST_CANID_ESCL_DIAG_REQ_OFFSET);
        data[0] = (byte) ((messages.ESCL_Diag_Req & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.ESCL_Diag_Req >> can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.ESCL_Diag_Req >> can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.ESCL_Diag_Req >> can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.ESCL_Diag_Req >> can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.ESCL_Diag_Req >> can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.ESCL_Diag_Req >> can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.ESCL_Diag_Req >> can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ESCL_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BCM_Diagnostic_Response(ConverterInitialize.BCM_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BCM_Diag_Response = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.BCM_DIAGNOSTIC_RESPONSE_CANID_BCM_DIAG_RESPONSE_OFFSET));

        return can.BCM_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BCM_Diagnostic_Response(ConverterInitialize.BCM_Diagnostic_Response_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BCM_Diag_Response = (long) (messages.BCM_Diag_Response - can.BCM_DIAGNOSTIC_RESPONSE_CANID_BCM_DIAG_RESPONSE_OFFSET);
        data[0] = (byte) ((messages.BCM_Diag_Response & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.BCM_Diag_Response >> can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.BCM_Diag_Response >> can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.BCM_Diag_Response >> can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.BCM_Diag_Response >> can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.BCM_Diag_Response >> can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.BCM_Diag_Response >> can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.BCM_Diag_Response >> can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BCM_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BCM_Diagnostic_Request(ConverterInitialize.BCM_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BCM_Diag_Request = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.BCM_DIAGNOSTIC_REQUEST_CANID_BCM_DIAG_REQUEST_OFFSET));

        return can.BCM_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BCM_Diagnostic_Request(ConverterInitialize.BCM_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.BCM_Diag_Request = (long) (messages.BCM_Diag_Request - can.BCM_DIAGNOSTIC_REQUEST_CANID_BCM_DIAG_REQUEST_OFFSET);
        data[0] = (byte) ((messages.BCM_Diag_Request & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.BCM_Diag_Request >> can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.BCM_Diag_Request >> can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.BCM_Diag_Request >> can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.BCM_Diag_Request >> can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.BCM_Diag_Request >> can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.BCM_Diag_Request >> can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.BCM_Diag_Request >> can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BCM_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Func_Diagnostic_Request(ConverterInitialize.Func_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Functional_Diag_Request = (long) ((((long) (data[7] & (can.SIGNLE_READ_Mask8)) << can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK0) | ((long) (data[6] & (can.SIGNLE_READ_Mask8)) << can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK1) | ((long) (data[5] & (can.SIGNLE_READ_Mask8)) << can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK2) | ((long) (data[4] & (can.SIGNLE_READ_Mask8)) << can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK3) | ((data[3] & (can.SIGNLE_READ_Mask8)) << can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK4) | ((data[2] & (can.SIGNLE_READ_Mask8)) << can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK5) | ((data[1] & (can.SIGNLE_READ_Mask8)) << can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK6) | (data[0] & (can.SIGNLE_READ_Mask8))) + (long) (can.FUNC_DIAGNOSTIC_REQUEST_CANID_FUNCTIONAL_DIAG_REQUEST_OFFSET));

        return can.FUNC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Func_Diagnostic_Request(ConverterInitialize.Func_Diagnostic_Request_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Functional_Diag_Request = (long) (messages.Functional_Diag_Request - can.FUNC_DIAGNOSTIC_REQUEST_CANID_FUNCTIONAL_DIAG_REQUEST_OFFSET);
        data[0] = (byte) ((messages.Functional_Diag_Request & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Functional_Diag_Request >> can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) (((messages.Functional_Diag_Request >> can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Functional_Diag_Request >> can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) (((messages.Functional_Diag_Request >> can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Functional_Diag_Request >> can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) (((messages.Functional_Diag_Request >> can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte) (((messages.Functional_Diag_Request >> can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.FUNC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BATTERY_STATUS_INFO(ConverterInitialize.BATTERY_STATUS_INFO_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Battery_Current = (short) ((((data[1] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_STATUS_INFO_BATTERY_CURRENT_MASK0) | (data[0] & (can.SIGNLE_READ_Mask8))) + (short) (can.BATTERY_STATUS_INFO_CANID_BATTERY_CURRENT_OFFSET));
        messages.Battery_Pack_SoC = (short) ((((data[3] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_STATUS_INFO_BATTERY_PACK_SOC_MASK0) | (data[2] & (can.SIGNLE_READ_Mask8))) + (short) (can.BATTERY_STATUS_INFO_CANID_BATTERY_PACK_SOC_OFFSET));
        messages.Charge_Voltage_limit = (short) ((((data[5] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_STATUS_INFO_CHARGE_VOLTAGE_LIMIT_MASK0) | (data[4] & (can.SIGNLE_READ_Mask8))) + (short) (can.BATTERY_STATUS_INFO_CANID_CHARGE_VOLTAGE_LIMIT_OFFSET));
        messages.Charger_Mode_Request = (byte) (((data[6] & (can.SIGNLE_READ_Mask3))) + (byte) (can.BATTERY_STATUS_INFO_CANID_CHARGER_MODE_REQUEST_OFFSET));
        messages.Time_to_Charge_Hrs = (byte) ((((data[7] & (can.SIGNLE_READ_Mask2)) << can.BATTERY_STATUS_INFO_TIME_TO_CHARGE_HRS_MASK0) | ((data[6] >> can.BATTERY_STATUS_INFO_TIME_TO_CHARGE_HRS_MASK1) & (can.SIGNLE_READ_Mask5))) + (byte) (can.BATTERY_STATUS_INFO_CANID_TIME_TO_CHARGE_HRS_OFFSET));
        messages.Time_to_Charge_Mins = (byte) ((((data[7] >> can.BATTERY_STATUS_INFO_TIME_TO_CHARGE_MINS_MASK0) & (can.SIGNLE_READ_Mask6))) + (byte) (can.BATTERY_STATUS_INFO_CANID_TIME_TO_CHARGE_MINS_OFFSET));

        return can.BATTERY_STATUS_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BATTERY_STATUS_INFO(ConverterInitialize.BATTERY_STATUS_INFO_t messages, byte[] data) {
        ConverterInitialize can = new ConverterInitialize();
        messages.Battery_Current = (short) (messages.Battery_Current - can.BATTERY_STATUS_INFO_CANID_BATTERY_CURRENT_OFFSET);
        messages.Battery_Pack_SoC = (short) (messages.Battery_Pack_SoC - can.BATTERY_STATUS_INFO_CANID_BATTERY_PACK_SOC_OFFSET);
        messages.Charge_Voltage_limit = (short) (messages.Charge_Voltage_limit - can.BATTERY_STATUS_INFO_CANID_CHARGE_VOLTAGE_LIMIT_OFFSET);
        messages.Charger_Mode_Request = (byte) (messages.Charger_Mode_Request - can.BATTERY_STATUS_INFO_CANID_CHARGER_MODE_REQUEST_OFFSET);
        messages.Time_to_Charge_Hrs = (byte) (messages.Time_to_Charge_Hrs - can.BATTERY_STATUS_INFO_CANID_TIME_TO_CHARGE_HRS_OFFSET);
        messages.Time_to_Charge_Mins = (byte) (messages.Time_to_Charge_Mins - can.BATTERY_STATUS_INFO_CANID_TIME_TO_CHARGE_MINS_OFFSET);
        data[0] = (byte) ((messages.Battery_Current & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte) (((messages.Battery_Current >> can.BATTERY_STATUS_INFO_BATTERY_CURRENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte) ((messages.Battery_Pack_SoC & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte) (((messages.Battery_Pack_SoC >> can.BATTERY_STATUS_INFO_BATTERY_PACK_SOC_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte) ((messages.Charge_Voltage_limit & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte) (((messages.Charge_Voltage_limit >> can.BATTERY_STATUS_INFO_CHARGE_VOLTAGE_LIMIT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte) ((messages.Charger_Mode_Request & (can.SIGNLE_READ_Mask3)) | ((messages.Time_to_Charge_Hrs & (can.SIGNLE_READ_Mask5)) << can.BATTERY_STATUS_INFO_TIME_TO_CHARGE_HRS_MASK1));
        data[7] = (byte) (((messages.Time_to_Charge_Hrs >> can.BATTERY_STATUS_INFO_TIME_TO_CHARGE_HRS_MASK0) & (can.SIGNLE_READ_Mask2)) | ((messages.Time_to_Charge_Mins & (can.SIGNLE_READ_Mask6)) << can.BATTERY_STATUS_INFO_TIME_TO_CHARGE_MINS_MASK0));
        return can.BATTERY_STATUS_INFO_ID;
    }

    /*------------------------------------------------------------*/

}
