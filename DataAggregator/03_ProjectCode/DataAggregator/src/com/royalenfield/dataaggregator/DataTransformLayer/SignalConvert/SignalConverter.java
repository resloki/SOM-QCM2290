package com.royalenfield.dataaggregator.DataTransformLayer.SignalConvert;

public class SignalConverter implements ConverterInterface{
    public long Deserialize_VCU_to_OBC_Auth_Req( ConverterInitialize.VCU_to_OBC_Auth_Req_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_to_OBC_Seed = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.VCU_TO_OBC_AUTH_REQ_VCU_TO_OBC_SEED_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.VCU_TO_OBC_AUTH_REQ_VCU_TO_OBC_SEED_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.VCU_TO_OBC_AUTH_REQ_VCU_TO_OBC_SEED_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.VCU_TO_OBC_AUTH_REQ_VCU_TO_OBC_SEED_FACTOR)) + (can.VCU_TO_OBC_AUTH_REQ_CANID_VCU_TO_OBC_SEED_OFFSET));

        return can.VCU_TO_OBC_AUTH_REQ_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_VCU_to_OBC_Auth_Req( ConverterInitialize.VCU_to_OBC_Auth_Req_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_to_OBC_Seed=(float) (messages.VCU_to_OBC_Seed - can.VCU_TO_OBC_AUTH_REQ_CANID_VCU_TO_OBC_SEED_OFFSET);
        data[0] = (byte)(((byte)messages.VCU_to_OBC_Seed & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.VCU_to_OBC_Seed >> can.VCU_TO_OBC_AUTH_REQ_VCU_TO_OBC_SEED_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.VCU_to_OBC_Seed >> can.VCU_TO_OBC_AUTH_REQ_VCU_TO_OBC_SEED_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.VCU_to_OBC_Seed >> can.VCU_TO_OBC_AUTH_REQ_VCU_TO_OBC_SEED_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.VCU_TO_OBC_AUTH_REQ_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_VCU_to_OBC_Auth_Stat( ConverterInitialize.VCU_to_OBC_Auth_Stat_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_Auth_Res_to_OBC = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.VCU_TO_OBC_AUTH_STAT_VCU_AUTH_RES_TO_OBC_FACTOR)) + (can.VCU_TO_OBC_AUTH_STAT_CANID_VCU_AUTH_RES_TO_OBC_OFFSET));

        return can.VCU_TO_OBC_AUTH_STAT_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_VCU_to_OBC_Auth_Stat( ConverterInitialize.VCU_to_OBC_Auth_Stat_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_Auth_Res_to_OBC=(float) (messages.VCU_Auth_Res_to_OBC - can.VCU_TO_OBC_AUTH_STAT_CANID_VCU_AUTH_RES_TO_OBC_OFFSET);
        data[0] = (byte)(((byte)messages.VCU_Auth_Res_to_OBC & ( can.SIGNLE_READ_Mask1)));
        return can.VCU_TO_OBC_AUTH_STAT_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OBC_to_VCU_Auth_Resp( ConverterInitialize.OBC_to_VCU_Auth_Resp_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Key = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.OBC_TO_VCU_AUTH_RESP_OBC_KEY_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.OBC_TO_VCU_AUTH_RESP_OBC_KEY_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.OBC_TO_VCU_AUTH_RESP_OBC_KEY_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.OBC_TO_VCU_AUTH_RESP_OBC_KEY_FACTOR)) + (can.OBC_TO_VCU_AUTH_RESP_CANID_OBC_KEY_OFFSET));

        return can.OBC_TO_VCU_AUTH_RESP_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OBC_to_VCU_Auth_Resp( ConverterInitialize.OBC_to_VCU_Auth_Resp_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Key=(float) (messages.OBC_Key - can.OBC_TO_VCU_AUTH_RESP_CANID_OBC_KEY_OFFSET);
        data[0] = (byte)(((byte)messages.OBC_Key & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.OBC_Key >> can.OBC_TO_VCU_AUTH_RESP_OBC_KEY_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.OBC_Key >> can.OBC_TO_VCU_AUTH_RESP_OBC_KEY_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.OBC_Key >> can.OBC_TO_VCU_AUTH_RESP_OBC_KEY_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.OBC_TO_VCU_AUTH_RESP_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_VCU_to_MCU_Auth_Req( ConverterInitialize.VCU_to_MCU_Auth_Req_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_to_MCU_Seed = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.VCU_TO_MCU_AUTH_REQ_VCU_TO_MCU_SEED_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.VCU_TO_MCU_AUTH_REQ_VCU_TO_MCU_SEED_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.VCU_TO_MCU_AUTH_REQ_VCU_TO_MCU_SEED_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.VCU_TO_MCU_AUTH_REQ_VCU_TO_MCU_SEED_FACTOR)) + (can.VCU_TO_MCU_AUTH_REQ_CANID_VCU_TO_MCU_SEED_OFFSET));

        return can.VCU_TO_MCU_AUTH_REQ_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_VCU_to_MCU_Auth_Req( ConverterInitialize.VCU_to_MCU_Auth_Req_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_to_MCU_Seed=(float) (messages.VCU_to_MCU_Seed - can.VCU_TO_MCU_AUTH_REQ_CANID_VCU_TO_MCU_SEED_OFFSET);
        data[0] = (byte)(((byte)messages.VCU_to_MCU_Seed & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.VCU_to_MCU_Seed >> can.VCU_TO_MCU_AUTH_REQ_VCU_TO_MCU_SEED_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.VCU_to_MCU_Seed >> can.VCU_TO_MCU_AUTH_REQ_VCU_TO_MCU_SEED_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.VCU_to_MCU_Seed >> can.VCU_TO_MCU_AUTH_REQ_VCU_TO_MCU_SEED_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.VCU_TO_MCU_AUTH_REQ_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_to_VCU_Auth_Resp( ConverterInitialize.MCU_to_VCU_Auth_Resp_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Key = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.MCU_TO_VCU_AUTH_RESP_MCU_KEY_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.MCU_TO_VCU_AUTH_RESP_MCU_KEY_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.MCU_TO_VCU_AUTH_RESP_MCU_KEY_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.MCU_TO_VCU_AUTH_RESP_MCU_KEY_FACTOR)) + (can.MCU_TO_VCU_AUTH_RESP_CANID_MCU_KEY_OFFSET));

        return can.MCU_TO_VCU_AUTH_RESP_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_to_VCU_Auth_Resp( ConverterInitialize.MCU_to_VCU_Auth_Resp_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Key=(float) (messages.MCU_Key - can.MCU_TO_VCU_AUTH_RESP_CANID_MCU_KEY_OFFSET);
        data[0] = (byte)(((byte)messages.MCU_Key & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.MCU_Key >> can.MCU_TO_VCU_AUTH_RESP_MCU_KEY_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.MCU_Key >> can.MCU_TO_VCU_AUTH_RESP_MCU_KEY_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.MCU_Key >> can.MCU_TO_VCU_AUTH_RESP_MCU_KEY_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.MCU_TO_VCU_AUTH_RESP_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_VCU_to_MCU_Auth_Stat( ConverterInitialize.VCU_to_MCU_Auth_Stat_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_Auth_Resp_to_MCU = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.VCU_TO_MCU_AUTH_STAT_VCU_AUTH_RESP_TO_MCU_FACTOR)) + (can.VCU_TO_MCU_AUTH_STAT_CANID_VCU_AUTH_RESP_TO_MCU_OFFSET));

        return can.VCU_TO_MCU_AUTH_STAT_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_VCU_to_MCU_Auth_Stat( ConverterInitialize.VCU_to_MCU_Auth_Stat_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_Auth_Resp_to_MCU=(float) (messages.VCU_Auth_Resp_to_MCU - can.VCU_TO_MCU_AUTH_STAT_CANID_VCU_AUTH_RESP_TO_MCU_OFFSET);
        data[0] = (byte)(((byte)messages.VCU_Auth_Resp_to_MCU & ( can.SIGNLE_READ_Mask1)));
        return can.VCU_TO_MCU_AUTH_STAT_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Data2( ConverterInitialize.MCU_Data2_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Rotor_Angle = (float)((((( data[1] & (can.SIGNLE_READ_Mask1)) << can.MCU_DATA2_ROTOR_ANGLE_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.MCU_DATA2_ROTOR_ANGLE_FACTOR)) + (can.MCU_DATA2_CANID_ROTOR_ANGLE_OFFSET));
        messages.MCU_Riding_Mode = (float)(((((data[1] >> can.MCU_DATA2_MCU_RIDING_MODE_MASK0) & (can.SIGNLE_READ_Mask4))) * (can.MCU_DATA2_MCU_RIDING_MODE_FACTOR)) + (can.MCU_DATA2_CANID_MCU_RIDING_MODE_OFFSET));
        messages.MCU_DC_voltage = (float)((((( data[3] & (can.SIGNLE_READ_Mask5)) << can.MCU_DATA2_MCU_DC_VOLTAGE_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA2_MCU_DC_VOLTAGE_MASK1) | (( data[1] >> can.MCU_DATA2_MCU_DC_VOLTAGE_MASK2) & (can.SIGNLE_READ_Mask3))) * (can.MCU_DATA2_MCU_DC_VOLTAGE_FACTOR)) + (can.MCU_DATA2_CANID_MCU_DC_VOLTAGE_OFFSET));
        messages.Cruise_Control_Status = (float)(((((data[3] >> can.MCU_DATA2_CRUISE_CONTROL_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_DATA2_CRUISE_CONTROL_STATUS_FACTOR)) + (can.MCU_DATA2_CANID_CRUISE_CONTROL_STATUS_OFFSET));
        messages.Hill_Hold_Status = (float)(((((data[3] >> can.MCU_DATA2_HILL_HOLD_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_DATA2_HILL_HOLD_STATUS_FACTOR)) + (can.MCU_DATA2_CANID_HILL_HOLD_STATUS_OFFSET));

        return can.MCU_DATA2_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Data2( ConverterInitialize.MCU_Data2_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Rotor_Angle=(float) (messages.Rotor_Angle - can.MCU_DATA2_CANID_ROTOR_ANGLE_OFFSET);
        messages.MCU_Riding_Mode=(float) (messages.MCU_Riding_Mode - can.MCU_DATA2_CANID_MCU_RIDING_MODE_OFFSET);
        messages.MCU_DC_voltage=(float) (messages.MCU_DC_voltage - can.MCU_DATA2_CANID_MCU_DC_VOLTAGE_OFFSET);
        messages.Cruise_Control_Status=(float) (messages.Cruise_Control_Status - can.MCU_DATA2_CANID_CRUISE_CONTROL_STATUS_OFFSET);
        messages.Hill_Hold_Status=(float) (messages.Hill_Hold_Status - can.MCU_DATA2_CANID_HILL_HOLD_STATUS_OFFSET);
        data[0] = (byte)(((byte)messages.Rotor_Angle & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Rotor_Angle >> can.MCU_DATA2_ROTOR_ANGLE_MASK0) & (can.SIGNLE_READ_Mask1)) | (((byte)messages.MCU_Riding_Mode & ( can.SIGNLE_READ_Mask4)) << can.MCU_DATA2_MCU_RIDING_MODE_MASK0) | (((byte)messages.MCU_DC_voltage & (can.SIGNLE_READ_Mask3)) << can.MCU_DATA2_MCU_DC_VOLTAGE_MASK2));
        data[2] = (byte)((((byte)messages.MCU_DC_voltage >> can.MCU_DATA2_MCU_DC_VOLTAGE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.MCU_DC_voltage >> can.MCU_DATA2_MCU_DC_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask5)) | (((byte)messages.Cruise_Control_Status & ( can.SIGNLE_READ_Mask1)) << can.MCU_DATA2_CRUISE_CONTROL_STATUS_MASK0) | (((byte)messages.Hill_Hold_Status & ( can.SIGNLE_READ_Mask1)) << can.MCU_DATA2_HILL_HOLD_STATUS_MASK0));
        return can.MCU_DATA2_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_PARAMETER_1( ConverterInitialize.BMS_PARAMETER_1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Contactor_State = (float)((((data[0] & (can.SIGNLE_READ_Mask4))) * (can.BMS_PARAMETER_1_CONTACTOR_STATE_FACTOR)) + (can.BMS_PARAMETER_1_CANID_CONTACTOR_STATE_OFFSET));
        messages.Battery_Pack_Bus_Volt = (float)((((( data[2] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_1_BATTERY_PACK_BUS_VOLT_MASK0) | ( data[1] & (can.SIGNLE_READ_Mask8))) * (can.BMS_PARAMETER_1_BATTERY_PACK_BUS_VOLT_FACTOR)) + (can.BMS_PARAMETER_1_CANID_BATTERY_PACK_BUS_VOLT_OFFSET));
        messages.BMS_Board_Temp = (float)((((( data[4] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_1_BMS_BOARD_TEMP_MASK0) | ( data[3] & (can.SIGNLE_READ_Mask8))) * (can.BMS_PARAMETER_1_BMS_BOARD_TEMP_FACTOR)) + (can.BMS_PARAMETER_1_CANID_BMS_BOARD_TEMP_OFFSET));
        messages.BMS_Mode = (float)((((data[5] & (can.SIGNLE_READ_Mask4))) * (can.BMS_PARAMETER_1_BMS_MODE_FACTOR)) + (can.BMS_PARAMETER_1_CANID_BMS_MODE_OFFSET));
        messages.Battery_Precharge_Failure_Status = (float)((((data[6] & (can.SIGNLE_READ_Mask1))) * (can.BMS_PARAMETER_1_BATTERY_PRECHARGE_FAILURE_STATUS_FACTOR)) + (can.BMS_PARAMETER_1_CANID_BATTERY_PRECHARGE_FAILURE_STATUS_OFFSET));
        messages.Battery_Charge_Inhibit = (float)(((((data[6] >> can.BMS_PARAMETER_1_BATTERY_CHARGE_INHIBIT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_PARAMETER_1_BATTERY_CHARGE_INHIBIT_FACTOR)) + (can.BMS_PARAMETER_1_CANID_BATTERY_CHARGE_INHIBIT_OFFSET));
        messages.Battery_Discharge_Inhibit = (float)(((((data[6] >> can.BMS_PARAMETER_1_BATTERY_DISCHARGE_INHIBIT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_PARAMETER_1_BATTERY_DISCHARGE_INHIBIT_FACTOR)) + (can.BMS_PARAMETER_1_CANID_BATTERY_DISCHARGE_INHIBIT_OFFSET));
        messages.Battery_Derate_Drive_Curr_Flag = (float)(((((data[6] >> can.BMS_PARAMETER_1_BATTERY_DERATE_DRIVE_CURR_FLAG_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_PARAMETER_1_BATTERY_DERATE_DRIVE_CURR_FLAG_FACTOR)) + (can.BMS_PARAMETER_1_CANID_BATTERY_DERATE_DRIVE_CURR_FLAG_OFFSET));
        messages.Battery_Derate_Charge_Curr_Flag = (float)(((((data[6] >> can.BMS_PARAMETER_1_BATTERY_DERATE_CHARGE_CURR_FLAG_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_PARAMETER_1_BATTERY_DERATE_CHARGE_CURR_FLAG_FACTOR)) + (can.BMS_PARAMETER_1_CANID_BATTERY_DERATE_CHARGE_CURR_FLAG_OFFSET));
        messages.Battery_Inhibit_Regen_Fault = (float)(((((data[6] >> can.BMS_PARAMETER_1_BATTERY_INHIBIT_REGEN_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_PARAMETER_1_BATTERY_INHIBIT_REGEN_FAULT_FACTOR)) + (can.BMS_PARAMETER_1_CANID_BATTERY_INHIBIT_REGEN_FAULT_OFFSET));
        messages.Battery_Permanant_Fault = (float)(((((data[6] >> can.BMS_PARAMETER_1_BATTERY_PERMANANT_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_PARAMETER_1_BATTERY_PERMANANT_FAULT_FACTOR)) + (can.BMS_PARAMETER_1_CANID_BATTERY_PERMANANT_FAULT_OFFSET));
        messages.BMS_Short_Cir_Detection_Error = (float)(((((data[6] >> can.BMS_PARAMETER_1_BMS_SHORT_CIR_DETECTION_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_PARAMETER_1_BMS_SHORT_CIR_DETECTION_ERROR_FACTOR)) + (can.BMS_PARAMETER_1_CANID_BMS_SHORT_CIR_DETECTION_ERROR_OFFSET));
        messages.Reserved = (float)((((data[7] & (can.SIGNLE_READ_Mask1))) * (can.BMS_PARAMETER_1_RESERVED_FACTOR)) + (can.BMS_PARAMETER_1_CANID_RESERVED_OFFSET));

        return can.BMS_PARAMETER_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_PARAMETER_1( ConverterInitialize.BMS_PARAMETER_1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Contactor_State=(float) (messages.Contactor_State - can.BMS_PARAMETER_1_CANID_CONTACTOR_STATE_OFFSET);
        messages.Battery_Pack_Bus_Volt=(float) (messages.Battery_Pack_Bus_Volt - can.BMS_PARAMETER_1_CANID_BATTERY_PACK_BUS_VOLT_OFFSET);
        messages.BMS_Board_Temp=(float) (messages.BMS_Board_Temp - can.BMS_PARAMETER_1_CANID_BMS_BOARD_TEMP_OFFSET);
        messages.BMS_Mode=(float) (messages.BMS_Mode - can.BMS_PARAMETER_1_CANID_BMS_MODE_OFFSET);
        messages.Battery_Precharge_Failure_Status=(float) (messages.Battery_Precharge_Failure_Status - can.BMS_PARAMETER_1_CANID_BATTERY_PRECHARGE_FAILURE_STATUS_OFFSET);
        messages.Battery_Charge_Inhibit=(float) (messages.Battery_Charge_Inhibit - can.BMS_PARAMETER_1_CANID_BATTERY_CHARGE_INHIBIT_OFFSET);
        messages.Battery_Discharge_Inhibit=(float) (messages.Battery_Discharge_Inhibit - can.BMS_PARAMETER_1_CANID_BATTERY_DISCHARGE_INHIBIT_OFFSET);
        messages.Battery_Derate_Drive_Curr_Flag=(float) (messages.Battery_Derate_Drive_Curr_Flag - can.BMS_PARAMETER_1_CANID_BATTERY_DERATE_DRIVE_CURR_FLAG_OFFSET);
        messages.Battery_Derate_Charge_Curr_Flag=(float) (messages.Battery_Derate_Charge_Curr_Flag - can.BMS_PARAMETER_1_CANID_BATTERY_DERATE_CHARGE_CURR_FLAG_OFFSET);
        messages.Battery_Inhibit_Regen_Fault=(float) (messages.Battery_Inhibit_Regen_Fault - can.BMS_PARAMETER_1_CANID_BATTERY_INHIBIT_REGEN_FAULT_OFFSET);
        messages.Battery_Permanant_Fault=(float) (messages.Battery_Permanant_Fault - can.BMS_PARAMETER_1_CANID_BATTERY_PERMANANT_FAULT_OFFSET);
        messages.BMS_Short_Cir_Detection_Error=(float) (messages.BMS_Short_Cir_Detection_Error - can.BMS_PARAMETER_1_CANID_BMS_SHORT_CIR_DETECTION_ERROR_OFFSET);
        messages.Reserved=(float) (messages.Reserved - can.BMS_PARAMETER_1_CANID_RESERVED_OFFSET);
        data[0] = (byte)(((byte)messages.Contactor_State & ( can.SIGNLE_READ_Mask4)));
        data[1] = (byte)(((byte)messages.Battery_Pack_Bus_Volt & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.Battery_Pack_Bus_Volt >> can.BMS_PARAMETER_1_BATTERY_PACK_BUS_VOLT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)(((byte)messages.BMS_Board_Temp & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.BMS_Board_Temp >> can.BMS_PARAMETER_1_BMS_BOARD_TEMP_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)(((byte)messages.BMS_Mode & ( can.SIGNLE_READ_Mask4)));
        data[6] = (byte)(((byte)messages.Battery_Precharge_Failure_Status & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Battery_Charge_Inhibit & ( can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_1_BATTERY_CHARGE_INHIBIT_MASK0) | (((byte)messages.Battery_Discharge_Inhibit & ( can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_1_BATTERY_DISCHARGE_INHIBIT_MASK0) | (((byte)messages.Battery_Derate_Drive_Curr_Flag & ( can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_1_BATTERY_DERATE_DRIVE_CURR_FLAG_MASK0) | (((byte)messages.Battery_Derate_Charge_Curr_Flag & ( can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_1_BATTERY_DERATE_CHARGE_CURR_FLAG_MASK0) | (((byte)messages.Battery_Inhibit_Regen_Fault & ( can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_1_BATTERY_INHIBIT_REGEN_FAULT_MASK0) | (((byte)messages.Battery_Permanant_Fault & ( can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_1_BATTERY_PERMANANT_FAULT_MASK0) | (((byte)messages.BMS_Short_Cir_Detection_Error & ( can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_1_BMS_SHORT_CIR_DETECTION_ERROR_MASK0));
        data[7] = (byte)(((byte)messages.Reserved & ( can.SIGNLE_READ_Mask1)));
        return can.BMS_PARAMETER_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BATTERY_LIMITS( ConverterInitialize.BATTERY_LIMITS_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charge_Current_Limit = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_LIMITS_CHARGE_CURRENT_LIMIT_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_LIMITS_CHARGE_CURRENT_LIMIT_FACTOR)) + (can.BATTERY_LIMITS_CANID_CHARGE_CURRENT_LIMIT_OFFSET));
        messages.Discharge_Current_Limit = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_LIMITS_DISCHARGE_CURRENT_LIMIT_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_LIMITS_DISCHARGE_CURRENT_LIMIT_FACTOR)) + (can.BATTERY_LIMITS_CANID_DISCHARGE_CURRENT_LIMIT_OFFSET));

        return can.BATTERY_LIMITS_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BATTERY_LIMITS( ConverterInitialize.BATTERY_LIMITS_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charge_Current_Limit=(float) (messages.Charge_Current_Limit - can.BATTERY_LIMITS_CANID_CHARGE_CURRENT_LIMIT_OFFSET);
        messages.Discharge_Current_Limit=(float) (messages.Discharge_Current_Limit - can.BATTERY_LIMITS_CANID_DISCHARGE_CURRENT_LIMIT_OFFSET);
        data[0] = (byte)(((byte)messages.Charge_Current_Limit & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Charge_Current_Limit >> can.BATTERY_LIMITS_CHARGE_CURRENT_LIMIT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Discharge_Current_Limit & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Discharge_Current_Limit >> can.BATTERY_LIMITS_DISCHARGE_CURRENT_LIMIT_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BATTERY_LIMITS_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_PARAMETER_LIMIT_2( ConverterInitialize.BMS_PARAMETER_LIMIT_2_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Regen_Current_Limit = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_LIMIT_2_REGEN_CURRENT_LIMIT_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BMS_PARAMETER_LIMIT_2_REGEN_CURRENT_LIMIT_FACTOR)) + (can.BMS_PARAMETER_LIMIT_2_CANID_REGEN_CURRENT_LIMIT_OFFSET));
        messages.Reserved = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_LIMIT_2_RESERVED_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.BMS_PARAMETER_LIMIT_2_RESERVED_FACTOR)) + (can.BMS_PARAMETER_LIMIT_2_CANID_RESERVED_OFFSET));
        messages.Cell_Aggregate_Voltage = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_LIMIT_2_CELL_AGGREGATE_VOLTAGE_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.BMS_PARAMETER_LIMIT_2_CELL_AGGREGATE_VOLTAGE_FACTOR)) + (can.BMS_PARAMETER_LIMIT_2_CANID_CELL_AGGREGATE_VOLTAGE_OFFSET));

        return can.BMS_PARAMETER_LIMIT_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_PARAMETER_LIMIT_2( ConverterInitialize.BMS_PARAMETER_LIMIT_2_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Regen_Current_Limit=(float) (messages.Regen_Current_Limit - can.BMS_PARAMETER_LIMIT_2_CANID_REGEN_CURRENT_LIMIT_OFFSET);
        messages.Reserved=(float) (messages.Reserved - can.BMS_PARAMETER_LIMIT_2_CANID_RESERVED_OFFSET);
        messages.Cell_Aggregate_Voltage=(float) (messages.Cell_Aggregate_Voltage - can.BMS_PARAMETER_LIMIT_2_CANID_CELL_AGGREGATE_VOLTAGE_OFFSET);
        data[0] = (byte)(((byte)messages.Regen_Current_Limit & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Regen_Current_Limit >> can.BMS_PARAMETER_LIMIT_2_REGEN_CURRENT_LIMIT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Reserved & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Reserved >> can.BMS_PARAMETER_LIMIT_2_RESERVED_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Cell_Aggregate_Voltage & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Cell_Aggregate_Voltage >> can.BMS_PARAMETER_LIMIT_2_CELL_AGGREGATE_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_PARAMETER_LIMIT_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Vehicle_Mode( ConverterInitialize.Vehicle_Mode_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Vehicle_Mode_Lvl_1 = (float)((((data[0] & (can.SIGNLE_READ_Mask4))) * (can.VEHICLE_MODE_VEHICLE_MODE_LVL_1_FACTOR)) + (can.VEHICLE_MODE_CANID_VEHICLE_MODE_LVL_1_OFFSET));
        messages.Vehcile_Mode_Lvl_2 = (float)((((data[1] & (can.SIGNLE_READ_Mask6))) * (can.VEHICLE_MODE_VEHCILE_MODE_LVL_2_FACTOR)) + (can.VEHICLE_MODE_CANID_VEHCILE_MODE_LVL_2_OFFSET));
        messages.Vehicle_Mode_Lvl_3 = (float)((((data[2] & (can.SIGNLE_READ_Mask5))) * (can.VEHICLE_MODE_VEHICLE_MODE_LVL_3_FACTOR)) + (can.VEHICLE_MODE_CANID_VEHICLE_MODE_LVL_3_OFFSET));
        messages.Reserved = (float)((((data[3] & (can.SIGNLE_READ_Mask3))) * (can.VEHICLE_MODE_RESERVED_FACTOR)) + (can.VEHICLE_MODE_CANID_RESERVED_OFFSET));
        messages.Reserved2 = (float)(((((data[3] >> can.VEHICLE_MODE_RESERVED2_MASK0) & (can.SIGNLE_READ_Mask2))) * (can.VEHICLE_MODE_RESERVED2_FACTOR)) + (can.VEHICLE_MODE_CANID_RESERVED2_OFFSET));
        messages.Odometer = (float)((((( data[6] & (can.SIGNLE_READ_Mask8)) << can.VEHICLE_MODE_ODOMETER_MASK0) | (( data[5] & (can.SIGNLE_READ_Mask8)) << can.VEHICLE_MODE_ODOMETER_MASK1) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.VEHICLE_MODE_ODOMETER_FACTOR)) + (can.VEHICLE_MODE_CANID_ODOMETER_OFFSET));
        messages.HMI_StatusBar_Stt = (float)((((data[7] & (can.SIGNLE_READ_Mask4))) * (can.VEHICLE_MODE_HMI_STATUSBAR_STT_FACTOR)) + (can.VEHICLE_MODE_CANID_HMI_STATUSBAR_STT_OFFSET));

        return can.VEHICLE_MODE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Vehicle_Mode( ConverterInitialize.Vehicle_Mode_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Vehicle_Mode_Lvl_1=(float) (messages.Vehicle_Mode_Lvl_1 - can.VEHICLE_MODE_CANID_VEHICLE_MODE_LVL_1_OFFSET);
        messages.Vehcile_Mode_Lvl_2=(float) (messages.Vehcile_Mode_Lvl_2 - can.VEHICLE_MODE_CANID_VEHCILE_MODE_LVL_2_OFFSET);
        messages.Vehicle_Mode_Lvl_3=(float) (messages.Vehicle_Mode_Lvl_3 - can.VEHICLE_MODE_CANID_VEHICLE_MODE_LVL_3_OFFSET);
        messages.Reserved=(float) (messages.Reserved - can.VEHICLE_MODE_CANID_RESERVED_OFFSET);
        messages.Reserved2=(float) (messages.Reserved2 - can.VEHICLE_MODE_CANID_RESERVED2_OFFSET);
        messages.Odometer=(float) (messages.Odometer - can.VEHICLE_MODE_CANID_ODOMETER_OFFSET);
        messages.HMI_StatusBar_Stt=(float) (messages.HMI_StatusBar_Stt - can.VEHICLE_MODE_CANID_HMI_STATUSBAR_STT_OFFSET);
        data[0] = (byte)(((byte)messages.Vehicle_Mode_Lvl_1 & ( can.SIGNLE_READ_Mask4)));
        data[1] = (byte)(((byte)messages.Vehcile_Mode_Lvl_2 & ( can.SIGNLE_READ_Mask6)));
        data[2] = (byte)(((byte)messages.Vehicle_Mode_Lvl_3 & ( can.SIGNLE_READ_Mask5)));
        data[3] = (byte)(((byte)messages.Reserved & ( can.SIGNLE_READ_Mask3)) | (((byte)messages.Reserved2 & ( can.SIGNLE_READ_Mask2)) << can.VEHICLE_MODE_RESERVED2_MASK0));
        data[4] = (byte)(((byte)messages.Odometer & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Odometer >> can.VEHICLE_MODE_ODOMETER_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.Odometer >> can.VEHICLE_MODE_ODOMETER_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)(((byte)messages.HMI_StatusBar_Stt & ( can.SIGNLE_READ_Mask4)));
        return can.VEHICLE_MODE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Traction_Control( ConverterInitialize.Traction_Control_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Traction_Status = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.TRACTION_CONTROL_TRACTION_STATUS_FACTOR)) + (can.TRACTION_CONTROL_CANID_TRACTION_STATUS_OFFSET));
        messages.Lean_angle_right = (float)((((( data[1] & (can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL_LEAN_ANGLE_RIGHT_MASK0) | (( data[0] >> can.TRACTION_CONTROL_LEAN_ANGLE_RIGHT_MASK1) & (can.SIGNLE_READ_Mask7))) * (can.TRACTION_CONTROL_LEAN_ANGLE_RIGHT_FACTOR)) + (can.TRACTION_CONTROL_CANID_LEAN_ANGLE_RIGHT_OFFSET));
        messages.Lean_angle_left = (float)((((( data[2] & (can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL_LEAN_ANGLE_LEFT_MASK0) | (( data[1] >> can.TRACTION_CONTROL_LEAN_ANGLE_LEFT_MASK1) & (can.SIGNLE_READ_Mask7))) * (can.TRACTION_CONTROL_LEAN_ANGLE_LEFT_FACTOR)) + (can.TRACTION_CONTROL_CANID_LEAN_ANGLE_LEFT_OFFSET));
        messages.Throtte_1_Value = (float)((((( data[4] & (can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL_THROTTE_1_VALUE_MASK0) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.TRACTION_CONTROL_THROTTE_1_VALUE_MASK1) | (( data[2] >> can.TRACTION_CONTROL_THROTTE_1_VALUE_MASK2) & (can.SIGNLE_READ_Mask7))) * (can.TRACTION_CONTROL_THROTTE_1_VALUE_FACTOR)) + (can.TRACTION_CONTROL_CANID_THROTTE_1_VALUE_OFFSET));
        messages.Throttle_2_Value = (float)((((( data[6] & (can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL_THROTTLE_2_VALUE_MASK0) | (( data[5] & (can.SIGNLE_READ_Mask8)) << can.TRACTION_CONTROL_THROTTLE_2_VALUE_MASK1) | (( data[4] >> can.TRACTION_CONTROL_THROTTLE_2_VALUE_MASK2) & (can.SIGNLE_READ_Mask7))) * (can.TRACTION_CONTROL_THROTTLE_2_VALUE_FACTOR)) + (can.TRACTION_CONTROL_CANID_THROTTLE_2_VALUE_OFFSET));
        messages.Motor_Cut = (float)(((((data[7] >> can.TRACTION_CONTROL_MOTOR_CUT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.TRACTION_CONTROL_MOTOR_CUT_FACTOR)) + (can.TRACTION_CONTROL_CANID_MOTOR_CUT_OFFSET));

        return can.TRACTION_CONTROL_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Traction_Control( ConverterInitialize.Traction_Control_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Traction_Status=(float) (messages.Traction_Status - can.TRACTION_CONTROL_CANID_TRACTION_STATUS_OFFSET);
        messages.Lean_angle_right=(float) (messages.Lean_angle_right - can.TRACTION_CONTROL_CANID_LEAN_ANGLE_RIGHT_OFFSET);
        messages.Lean_angle_left=(float) (messages.Lean_angle_left - can.TRACTION_CONTROL_CANID_LEAN_ANGLE_LEFT_OFFSET);
        messages.Throtte_1_Value=(float) (messages.Throtte_1_Value - can.TRACTION_CONTROL_CANID_THROTTE_1_VALUE_OFFSET);
        messages.Throttle_2_Value=(float) (messages.Throttle_2_Value - can.TRACTION_CONTROL_CANID_THROTTLE_2_VALUE_OFFSET);
        messages.Motor_Cut=(float) (messages.Motor_Cut - can.TRACTION_CONTROL_CANID_MOTOR_CUT_OFFSET);
        data[0] = (byte)(((byte)messages.Traction_Status & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Lean_angle_right & (can.SIGNLE_READ_Mask7)) << can.TRACTION_CONTROL_LEAN_ANGLE_RIGHT_MASK1));
        data[1] = (byte)((((byte)messages.Lean_angle_right >> can.TRACTION_CONTROL_LEAN_ANGLE_RIGHT_MASK0) & (can.SIGNLE_READ_Mask1)) | (((byte)messages.Lean_angle_left & (can.SIGNLE_READ_Mask7)) << can.TRACTION_CONTROL_LEAN_ANGLE_LEFT_MASK1));
        data[2] = (byte)((((byte)messages.Lean_angle_left >> can.TRACTION_CONTROL_LEAN_ANGLE_LEFT_MASK0) & (can.SIGNLE_READ_Mask1)) | (((byte)messages.Throtte_1_Value & (can.SIGNLE_READ_Mask7)) << can.TRACTION_CONTROL_THROTTE_1_VALUE_MASK2));
        data[3] = (byte)((((byte)messages.Throtte_1_Value >> can.TRACTION_CONTROL_THROTTE_1_VALUE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.Throtte_1_Value >> can.TRACTION_CONTROL_THROTTE_1_VALUE_MASK0) & (can.SIGNLE_READ_Mask1)) | (((byte)messages.Throttle_2_Value & (can.SIGNLE_READ_Mask7)) << can.TRACTION_CONTROL_THROTTLE_2_VALUE_MASK2));
        data[5] = (byte)((((byte)messages.Throttle_2_Value >> can.TRACTION_CONTROL_THROTTLE_2_VALUE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.Throttle_2_Value >> can.TRACTION_CONTROL_THROTTLE_2_VALUE_MASK0) & (can.SIGNLE_READ_Mask1)));
        data[7] = (byte)((((byte)messages.Motor_Cut & ( can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL_MOTOR_CUT_MASK0));
        return can.TRACTION_CONTROL_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_SOM_Parameters_1( ConverterInitialize.SOM_Parameters_1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.SOM_HeartBeat_Failure = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.SOM_PARAMETERS_1_SOM_HEARTBEAT_FAILURE_FACTOR)) + (can.SOM_PARAMETERS_1_CANID_SOM_HEARTBEAT_FAILURE_OFFSET));
        messages.SOM_Status = (float)(((((data[0] >> can.SOM_PARAMETERS_1_SOM_STATUS_MASK0) & (can.SIGNLE_READ_Mask4))) * (can.SOM_PARAMETERS_1_SOM_STATUS_FACTOR)) + (can.SOM_PARAMETERS_1_CANID_SOM_STATUS_OFFSET));
        messages.Passcode_Authentication = (float)(((((data[0] >> can.SOM_PARAMETERS_1_PASSCODE_AUTHENTICATION_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.SOM_PARAMETERS_1_PASSCODE_AUTHENTICATION_FACTOR)) + (can.SOM_PARAMETERS_1_CANID_PASSCODE_AUTHENTICATION_OFFSET));

        return can.SOM_PARAMETERS_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_SOM_Parameters_1( ConverterInitialize.SOM_Parameters_1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.SOM_HeartBeat_Failure=(float) (messages.SOM_HeartBeat_Failure - can.SOM_PARAMETERS_1_CANID_SOM_HEARTBEAT_FAILURE_OFFSET);
        messages.SOM_Status=(float) (messages.SOM_Status - can.SOM_PARAMETERS_1_CANID_SOM_STATUS_OFFSET);
        messages.Passcode_Authentication=(float) (messages.Passcode_Authentication - can.SOM_PARAMETERS_1_CANID_PASSCODE_AUTHENTICATION_OFFSET);
        data[0] = (byte)(((byte)messages.SOM_HeartBeat_Failure & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.SOM_Status & ( can.SIGNLE_READ_Mask4)) << can.SOM_PARAMETERS_1_SOM_STATUS_MASK0) | (((byte)messages.Passcode_Authentication & ( can.SIGNLE_READ_Mask1)) << can.SOM_PARAMETERS_1_PASSCODE_AUTHENTICATION_MASK0));
        return can.SOM_PARAMETERS_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ABS_Parameters( ConverterInitialize.ABS_Parameters_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_FrontBrake_Status = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.ABS_PARAMETERS_ABS_FRONTBRAKE_STATUS_FACTOR)) + (can.ABS_PARAMETERS_CANID_ABS_FRONTBRAKE_STATUS_OFFSET));
        messages.ABS_RearBrake_Status = (float)(((((data[0] >> can.ABS_PARAMETERS_ABS_REARBRAKE_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ABS_PARAMETERS_ABS_REARBRAKE_STATUS_FACTOR)) + (can.ABS_PARAMETERS_CANID_ABS_REARBRAKE_STATUS_OFFSET));
        messages.ABS_State = (float)(((((data[0] >> can.ABS_PARAMETERS_ABS_STATE_MASK0) & (can.SIGNLE_READ_Mask4))) * (can.ABS_PARAMETERS_ABS_STATE_FACTOR)) + (can.ABS_PARAMETERS_CANID_ABS_STATE_OFFSET));
        messages.ABS_Faulty = (float)(((((data[0] >> can.ABS_PARAMETERS_ABS_FAULTY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ABS_PARAMETERS_ABS_FAULTY_FACTOR)) + (can.ABS_PARAMETERS_CANID_ABS_FAULTY_OFFSET));

        return can.ABS_PARAMETERS_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ABS_Parameters( ConverterInitialize.ABS_Parameters_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_FrontBrake_Status=(float) (messages.ABS_FrontBrake_Status - can.ABS_PARAMETERS_CANID_ABS_FRONTBRAKE_STATUS_OFFSET);
        messages.ABS_RearBrake_Status=(float) (messages.ABS_RearBrake_Status - can.ABS_PARAMETERS_CANID_ABS_REARBRAKE_STATUS_OFFSET);
        messages.ABS_State=(float) (messages.ABS_State - can.ABS_PARAMETERS_CANID_ABS_STATE_OFFSET);
        messages.ABS_Faulty=(float) (messages.ABS_Faulty - can.ABS_PARAMETERS_CANID_ABS_FAULTY_OFFSET);
        data[0] = (byte)(((byte)messages.ABS_FrontBrake_Status & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.ABS_RearBrake_Status & ( can.SIGNLE_READ_Mask1)) << can.ABS_PARAMETERS_ABS_REARBRAKE_STATUS_MASK0) | (((byte)messages.ABS_State & ( can.SIGNLE_READ_Mask4)) << can.ABS_PARAMETERS_ABS_STATE_MASK0) | (((byte)messages.ABS_Faulty & ( can.SIGNLE_READ_Mask1)) << can.ABS_PARAMETERS_ABS_FAULTY_MASK0));
        return can.ABS_PARAMETERS_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Traction_Control2( ConverterInitialize.Traction_Control2_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Throttle_1_per = (float)((((data[0] & (can.SIGNLE_READ_Mask8))) * (can.TRACTION_CONTROL2_THROTTLE_1_PER_FACTOR)) + (can.TRACTION_CONTROL2_CANID_THROTTLE_1_PER_OFFSET));
        messages.Throttle_2_per = (float)((((data[1] & (can.SIGNLE_READ_Mask8))) * (can.TRACTION_CONTROL2_THROTTLE_2_PER_FACTOR)) + (can.TRACTION_CONTROL2_CANID_THROTTLE_2_PER_OFFSET));
        messages.Throttle_Percentage = (float)((((data[2] & (can.SIGNLE_READ_Mask8))) * (can.TRACTION_CONTROL2_THROTTLE_PERCENTAGE_FACTOR)) + (can.TRACTION_CONTROL2_CANID_THROTTLE_PERCENTAGE_OFFSET));
        messages.Thottle_1_flt = (float)((((data[3] & (can.SIGNLE_READ_Mask2))) * (can.TRACTION_CONTROL2_THOTTLE_1_FLT_FACTOR)) + (can.TRACTION_CONTROL2_CANID_THOTTLE_1_FLT_OFFSET));
        messages.Throttle_2_flt = (float)(((((data[3] >> can.TRACTION_CONTROL2_THROTTLE_2_FLT_MASK0) & (can.SIGNLE_READ_Mask2))) * (can.TRACTION_CONTROL2_THROTTLE_2_FLT_FACTOR)) + (can.TRACTION_CONTROL2_CANID_THROTTLE_2_FLT_OFFSET));
        messages.Throttle_Dev_flt = (float)(((((data[3] >> can.TRACTION_CONTROL2_THROTTLE_DEV_FLT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.TRACTION_CONTROL2_THROTTLE_DEV_FLT_FACTOR)) + (can.TRACTION_CONTROL2_CANID_THROTTLE_DEV_FLT_OFFSET));
        messages.Front_Brake_Status = (float)(((((data[3] >> can.TRACTION_CONTROL2_FRONT_BRAKE_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.TRACTION_CONTROL2_FRONT_BRAKE_STATUS_FACTOR)) + (can.TRACTION_CONTROL2_CANID_FRONT_BRAKE_STATUS_OFFSET));
        messages.Rear_Brake_Status = (float)(((((data[3] >> can.TRACTION_CONTROL2_REAR_BRAKE_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.TRACTION_CONTROL2_REAR_BRAKE_STATUS_FACTOR)) + (can.TRACTION_CONTROL2_CANID_REAR_BRAKE_STATUS_OFFSET));
        messages.Regeneration_Command = (float)((((( data[4] & (can.SIGNLE_READ_Mask2)) << can.TRACTION_CONTROL2_REGENERATION_COMMAND_MASK0) | (( data[3] >> can.TRACTION_CONTROL2_REGENERATION_COMMAND_MASK1) & (can.SIGNLE_READ_Mask1))) * (can.TRACTION_CONTROL2_REGENERATION_COMMAND_FACTOR)) + (can.TRACTION_CONTROL2_CANID_REGENERATION_COMMAND_OFFSET));

        return can.TRACTION_CONTROL2_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Traction_Control2( ConverterInitialize.Traction_Control2_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Throttle_1_per=(float) (messages.Throttle_1_per - can.TRACTION_CONTROL2_CANID_THROTTLE_1_PER_OFFSET);
        messages.Throttle_2_per=(float) (messages.Throttle_2_per - can.TRACTION_CONTROL2_CANID_THROTTLE_2_PER_OFFSET);
        messages.Throttle_Percentage=(float) (messages.Throttle_Percentage - can.TRACTION_CONTROL2_CANID_THROTTLE_PERCENTAGE_OFFSET);
        messages.Thottle_1_flt=(float) (messages.Thottle_1_flt - can.TRACTION_CONTROL2_CANID_THOTTLE_1_FLT_OFFSET);
        messages.Throttle_2_flt=(float) (messages.Throttle_2_flt - can.TRACTION_CONTROL2_CANID_THROTTLE_2_FLT_OFFSET);
        messages.Throttle_Dev_flt=(float) (messages.Throttle_Dev_flt - can.TRACTION_CONTROL2_CANID_THROTTLE_DEV_FLT_OFFSET);
        messages.Front_Brake_Status=(float) (messages.Front_Brake_Status - can.TRACTION_CONTROL2_CANID_FRONT_BRAKE_STATUS_OFFSET);
        messages.Rear_Brake_Status=(float) (messages.Rear_Brake_Status - can.TRACTION_CONTROL2_CANID_REAR_BRAKE_STATUS_OFFSET);
        messages.Regeneration_Command=(float) (messages.Regeneration_Command - can.TRACTION_CONTROL2_CANID_REGENERATION_COMMAND_OFFSET);
        data[0] = (byte)(((byte)messages.Throttle_1_per & ( can.SIGNLE_READ_Mask8)));
        data[1] = (byte)(((byte)messages.Throttle_2_per & ( can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Throttle_Percentage & ( can.SIGNLE_READ_Mask8)));
        data[3] = (byte)(((byte)messages.Thottle_1_flt & ( can.SIGNLE_READ_Mask2)) | (((byte)messages.Throttle_2_flt & ( can.SIGNLE_READ_Mask2)) << can.TRACTION_CONTROL2_THROTTLE_2_FLT_MASK0) | (((byte)messages.Throttle_Dev_flt & ( can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL2_THROTTLE_DEV_FLT_MASK0) | (((byte)messages.Front_Brake_Status & ( can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL2_FRONT_BRAKE_STATUS_MASK0) | (((byte)messages.Rear_Brake_Status & ( can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL2_REAR_BRAKE_STATUS_MASK0) | (((byte)messages.Regeneration_Command & (can.SIGNLE_READ_Mask1)) << can.TRACTION_CONTROL2_REGENERATION_COMMAND_MASK1));
        data[4] = (byte)((((byte)messages.Regeneration_Command >> can.TRACTION_CONTROL2_REGENERATION_COMMAND_MASK0) & (can.SIGNLE_READ_Mask2)));
        return can.TRACTION_CONTROL2_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Vehicle_Func( ConverterInitialize.Vehicle_Func_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cruise_Control_Req = (float)(((((data[0] >> can.VEHICLE_FUNC_CRUISE_CONTROL_REQ_MASK0) & (can.SIGNLE_READ_Mask3))) * (can.VEHICLE_FUNC_CRUISE_CONTROL_REQ_FACTOR)) + (can.VEHICLE_FUNC_CANID_CRUISE_CONTROL_REQ_OFFSET));
        messages.Hill_Hold_Command = (float)(((((data[0] >> can.VEHICLE_FUNC_HILL_HOLD_COMMAND_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_FUNC_HILL_HOLD_COMMAND_FACTOR)) + (can.VEHICLE_FUNC_CANID_HILL_HOLD_COMMAND_OFFSET));
        messages.Cruise_Set_Speed = (float)((((( data[2] & (can.SIGNLE_READ_Mask5)) << can.VEHICLE_FUNC_CRUISE_SET_SPEED_MASK0) | (( data[1] >> can.VEHICLE_FUNC_CRUISE_SET_SPEED_MASK1) & (can.SIGNLE_READ_Mask6))) * (can.VEHICLE_FUNC_CRUISE_SET_SPEED_FACTOR)) + (can.VEHICLE_FUNC_CANID_CRUISE_SET_SPEED_OFFSET));
        messages.Vehicle_speed_kmph = (float)((((( data[4] & (can.SIGNLE_READ_Mask8)) << can.VEHICLE_FUNC_VEHICLE_SPEED_KMPH_MASK0) | ( data[3] & (can.SIGNLE_READ_Mask8))) * (can.VEHICLE_FUNC_VEHICLE_SPEED_KMPH_FACTOR)) + (can.VEHICLE_FUNC_CANID_VEHICLE_SPEED_KMPH_OFFSET));

        return can.VEHICLE_FUNC_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Vehicle_Func( ConverterInitialize.Vehicle_Func_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cruise_Control_Req=(float) (messages.Cruise_Control_Req - can.VEHICLE_FUNC_CANID_CRUISE_CONTROL_REQ_OFFSET);
        messages.Hill_Hold_Command=(float) (messages.Hill_Hold_Command - can.VEHICLE_FUNC_CANID_HILL_HOLD_COMMAND_OFFSET);
        messages.Cruise_Set_Speed=(float) (messages.Cruise_Set_Speed - can.VEHICLE_FUNC_CANID_CRUISE_SET_SPEED_OFFSET);
        messages.Vehicle_speed_kmph=(float) (messages.Vehicle_speed_kmph - can.VEHICLE_FUNC_CANID_VEHICLE_SPEED_KMPH_OFFSET);
        data[0] = (byte)((((byte)messages.Cruise_Control_Req & ( can.SIGNLE_READ_Mask3)) << can.VEHICLE_FUNC_CRUISE_CONTROL_REQ_MASK0) | (((byte)messages.Hill_Hold_Command & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_FUNC_HILL_HOLD_COMMAND_MASK0));
        data[1] = (byte)((((byte)messages.Cruise_Set_Speed & (can.SIGNLE_READ_Mask6)) << can.VEHICLE_FUNC_CRUISE_SET_SPEED_MASK1));
        data[2] = (byte)((((byte)messages.Cruise_Set_Speed >> can.VEHICLE_FUNC_CRUISE_SET_SPEED_MASK0) & (can.SIGNLE_READ_Mask5)));
        data[3] = (byte)(((byte)messages.Vehicle_speed_kmph & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.Vehicle_speed_kmph >> can.VEHICLE_FUNC_VEHICLE_SPEED_KMPH_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.VEHICLE_FUNC_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_PARAMETER_3( ConverterInitialize.BMS_PARAMETER_3_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Balancing_Status = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.BMS_PARAMETER_3_BALANCING_STATUS_FACTOR)) + (can.BMS_PARAMETER_3_CANID_BALANCING_STATUS_OFFSET));
        messages.Effective_Battery_Temperature = (float)((((( data[1] & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_3_EFFECTIVE_BATTERY_TEMPERATURE_MASK0) | (( data[0] >> can.BMS_PARAMETER_3_EFFECTIVE_BATTERY_TEMPERATURE_MASK1) & (can.SIGNLE_READ_Mask7))) * (can.BMS_PARAMETER_3_EFFECTIVE_BATTERY_TEMPERATURE_FACTOR)) + (can.BMS_PARAMETER_3_CANID_EFFECTIVE_BATTERY_TEMPERATURE_OFFSET));
        messages.Delta_Temp = (float)((((( data[2] & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_3_DELTA_TEMP_MASK0) | (( data[1] >> can.BMS_PARAMETER_3_DELTA_TEMP_MASK1) & (can.SIGNLE_READ_Mask7))) * (can.BMS_PARAMETER_3_DELTA_TEMP_FACTOR)) + (can.BMS_PARAMETER_3_CANID_DELTA_TEMP_OFFSET));
        messages.Delta_Voltage = (float)((((( data[4] & (can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_3_DELTA_VOLTAGE_MASK0) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_3_DELTA_VOLTAGE_MASK1) | (( data[2] >> can.BMS_PARAMETER_3_DELTA_VOLTAGE_MASK2) & (can.SIGNLE_READ_Mask7))) * (can.BMS_PARAMETER_3_DELTA_VOLTAGE_FACTOR)) + (can.BMS_PARAMETER_3_CANID_DELTA_VOLTAGE_OFFSET));
        messages.HVIL_OBC_Req = (float)(((((data[4] >> can.BMS_PARAMETER_3_HVIL_OBC_REQ_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_PARAMETER_3_HVIL_OBC_REQ_FACTOR)) + (can.BMS_PARAMETER_3_CANID_HVIL_OBC_REQ_OFFSET));
        messages.HVIL_MCU_Req = (float)(((((data[4] >> can.BMS_PARAMETER_3_HVIL_MCU_REQ_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_PARAMETER_3_HVIL_MCU_REQ_FACTOR)) + (can.BMS_PARAMETER_3_CANID_HVIL_MCU_REQ_OFFSET));
        messages.HVIL_OBC_Status = (float)(((((data[4] >> can.BMS_PARAMETER_3_HVIL_OBC_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_PARAMETER_3_HVIL_OBC_STATUS_FACTOR)) + (can.BMS_PARAMETER_3_CANID_HVIL_OBC_STATUS_OFFSET));
        messages.HVIL_MCU_Status = (float)(((((data[4] >> can.BMS_PARAMETER_3_HVIL_MCU_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_PARAMETER_3_HVIL_MCU_STATUS_FACTOR)) + (can.BMS_PARAMETER_3_CANID_HVIL_MCU_STATUS_OFFSET));
        messages.Isolation_Resistance = (float)((((( data[6] & (can.SIGNLE_READ_Mask6)) << can.BMS_PARAMETER_3_ISOLATION_RESISTANCE_MASK0) | (( data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_3_ISOLATION_RESISTANCE_MASK1) | (( data[4] >> can.BMS_PARAMETER_3_ISOLATION_RESISTANCE_MASK2) & (can.SIGNLE_READ_Mask2))) * (can.BMS_PARAMETER_3_ISOLATION_RESISTANCE_FACTOR)) + (can.BMS_PARAMETER_3_CANID_ISOLATION_RESISTANCE_OFFSET));

        return can.BMS_PARAMETER_3_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_PARAMETER_3( ConverterInitialize.BMS_PARAMETER_3_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Balancing_Status=(float) (messages.Balancing_Status - can.BMS_PARAMETER_3_CANID_BALANCING_STATUS_OFFSET);
        messages.Effective_Battery_Temperature=(float) (messages.Effective_Battery_Temperature - can.BMS_PARAMETER_3_CANID_EFFECTIVE_BATTERY_TEMPERATURE_OFFSET);
        messages.Delta_Temp=(float) (messages.Delta_Temp - can.BMS_PARAMETER_3_CANID_DELTA_TEMP_OFFSET);
        messages.Delta_Voltage=(float) (messages.Delta_Voltage - can.BMS_PARAMETER_3_CANID_DELTA_VOLTAGE_OFFSET);
        messages.HVIL_OBC_Req=(float) (messages.HVIL_OBC_Req - can.BMS_PARAMETER_3_CANID_HVIL_OBC_REQ_OFFSET);
        messages.HVIL_MCU_Req=(float) (messages.HVIL_MCU_Req - can.BMS_PARAMETER_3_CANID_HVIL_MCU_REQ_OFFSET);
        messages.HVIL_OBC_Status=(float) (messages.HVIL_OBC_Status - can.BMS_PARAMETER_3_CANID_HVIL_OBC_STATUS_OFFSET);
        messages.HVIL_MCU_Status=(float) (messages.HVIL_MCU_Status - can.BMS_PARAMETER_3_CANID_HVIL_MCU_STATUS_OFFSET);
        messages.Isolation_Resistance=(float) (messages.Isolation_Resistance - can.BMS_PARAMETER_3_CANID_ISOLATION_RESISTANCE_OFFSET);
        data[0] = (byte)(((byte)messages.Balancing_Status & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Effective_Battery_Temperature & (can.SIGNLE_READ_Mask7)) << can.BMS_PARAMETER_3_EFFECTIVE_BATTERY_TEMPERATURE_MASK1));
        data[1] = (byte)((((byte)messages.Effective_Battery_Temperature >> can.BMS_PARAMETER_3_EFFECTIVE_BATTERY_TEMPERATURE_MASK0) & (can.SIGNLE_READ_Mask1)) | (((byte)messages.Delta_Temp & (can.SIGNLE_READ_Mask7)) << can.BMS_PARAMETER_3_DELTA_TEMP_MASK1));
        data[2] = (byte)((((byte)messages.Delta_Temp >> can.BMS_PARAMETER_3_DELTA_TEMP_MASK0) & (can.SIGNLE_READ_Mask1)) | (((byte)messages.Delta_Voltage & (can.SIGNLE_READ_Mask7)) << can.BMS_PARAMETER_3_DELTA_VOLTAGE_MASK2));
        data[3] = (byte)((((byte)messages.Delta_Voltage >> can.BMS_PARAMETER_3_DELTA_VOLTAGE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.Delta_Voltage >> can.BMS_PARAMETER_3_DELTA_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask1)) | (((byte)messages.HVIL_OBC_Req & ( can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_3_HVIL_OBC_REQ_MASK0) | (((byte)messages.HVIL_MCU_Req & ( can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_3_HVIL_MCU_REQ_MASK0) | (((byte)messages.HVIL_OBC_Status & ( can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_3_HVIL_OBC_STATUS_MASK0) | (((byte)messages.HVIL_MCU_Status & ( can.SIGNLE_READ_Mask1)) << can.BMS_PARAMETER_3_HVIL_MCU_STATUS_MASK0) | (((byte)messages.Isolation_Resistance & (can.SIGNLE_READ_Mask2)) << can.BMS_PARAMETER_3_ISOLATION_RESISTANCE_MASK2));
        data[5] = (byte)((((byte)messages.Isolation_Resistance >> can.BMS_PARAMETER_3_ISOLATION_RESISTANCE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.Isolation_Resistance >> can.BMS_PARAMETER_3_ISOLATION_RESISTANCE_MASK0) & (can.SIGNLE_READ_Mask6)));
        return can.BMS_PARAMETER_3_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_PARAMETER_4( ConverterInitialize.BMS_PARAMETER_4_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Pack_Internal_Resistance = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_4_PACK_INTERNAL_RESISTANCE_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BMS_PARAMETER_4_PACK_INTERNAL_RESISTANCE_FACTOR)) + (can.BMS_PARAMETER_4_CANID_PACK_INTERNAL_RESISTANCE_OFFSET));
        messages.Pack_SOH = (float)((((data[2] & (can.SIGNLE_READ_Mask8))) * (can.BMS_PARAMETER_4_PACK_SOH_FACTOR)) + (can.BMS_PARAMETER_4_CANID_PACK_SOH_OFFSET));
        messages.Pack_SOP = (float)((((data[3] & (can.SIGNLE_READ_Mask8))) * (can.BMS_PARAMETER_4_PACK_SOP_FACTOR)) + (can.BMS_PARAMETER_4_CANID_PACK_SOP_OFFSET));
        messages.Total_Charge_Cycles = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_PARAMETER_4_TOTAL_CHARGE_CYCLES_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.BMS_PARAMETER_4_TOTAL_CHARGE_CYCLES_FACTOR)) + (can.BMS_PARAMETER_4_CANID_TOTAL_CHARGE_CYCLES_OFFSET));
        messages.Pack_DOD = (float)((((data[6] & (can.SIGNLE_READ_Mask8))) * (can.BMS_PARAMETER_4_PACK_DOD_FACTOR)) + (can.BMS_PARAMETER_4_CANID_PACK_DOD_OFFSET));

        return can.BMS_PARAMETER_4_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_PARAMETER_4( ConverterInitialize.BMS_PARAMETER_4_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Pack_Internal_Resistance=(float) (messages.Pack_Internal_Resistance - can.BMS_PARAMETER_4_CANID_PACK_INTERNAL_RESISTANCE_OFFSET);
        messages.Pack_SOH=(float) (messages.Pack_SOH - can.BMS_PARAMETER_4_CANID_PACK_SOH_OFFSET);
        messages.Pack_SOP=(float) (messages.Pack_SOP - can.BMS_PARAMETER_4_CANID_PACK_SOP_OFFSET);
        messages.Total_Charge_Cycles=(float) (messages.Total_Charge_Cycles - can.BMS_PARAMETER_4_CANID_TOTAL_CHARGE_CYCLES_OFFSET);
        messages.Pack_DOD=(float) (messages.Pack_DOD - can.BMS_PARAMETER_4_CANID_PACK_DOD_OFFSET);
        data[0] = (byte)(((byte)messages.Pack_Internal_Resistance & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Pack_Internal_Resistance >> can.BMS_PARAMETER_4_PACK_INTERNAL_RESISTANCE_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Pack_SOH & ( can.SIGNLE_READ_Mask8)));
        data[3] = (byte)(((byte)messages.Pack_SOP & ( can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Total_Charge_Cycles & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Total_Charge_Cycles >> can.BMS_PARAMETER_4_TOTAL_CHARGE_CYCLES_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Pack_DOD & ( can.SIGNLE_READ_Mask8)));
        return can.BMS_PARAMETER_4_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Battery_Energy_Cycles( ConverterInitialize.Battery_Energy_Cycles_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cycle_Energy_In = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_ENERGY_CYCLES_CYCLE_ENERGY_IN_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_ENERGY_CYCLES_CYCLE_ENERGY_IN_FACTOR)) + (can.BATTERY_ENERGY_CYCLES_CANID_CYCLE_ENERGY_IN_OFFSET));
        messages.Cycle_Enegy_Out = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_ENERGY_CYCLES_CYCLE_ENEGY_OUT_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_ENERGY_CYCLES_CYCLE_ENEGY_OUT_FACTOR)) + (can.BATTERY_ENERGY_CYCLES_CANID_CYCLE_ENEGY_OUT_OFFSET));
        messages.Total_Energy_In = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_ENERGY_CYCLES_TOTAL_ENERGY_IN_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_ENERGY_CYCLES_TOTAL_ENERGY_IN_FACTOR)) + (can.BATTERY_ENERGY_CYCLES_CANID_TOTAL_ENERGY_IN_OFFSET));
        messages.Total_Energy_Out = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_ENERGY_CYCLES_TOTAL_ENERGY_OUT_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_ENERGY_CYCLES_TOTAL_ENERGY_OUT_FACTOR)) + (can.BATTERY_ENERGY_CYCLES_CANID_TOTAL_ENERGY_OUT_OFFSET));

        return can.BATTERY_ENERGY_CYCLES_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Battery_Energy_Cycles( ConverterInitialize.Battery_Energy_Cycles_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cycle_Energy_In=(float) (messages.Cycle_Energy_In - can.BATTERY_ENERGY_CYCLES_CANID_CYCLE_ENERGY_IN_OFFSET);
        messages.Cycle_Enegy_Out=(float) (messages.Cycle_Enegy_Out - can.BATTERY_ENERGY_CYCLES_CANID_CYCLE_ENEGY_OUT_OFFSET);
        messages.Total_Energy_In=(float) (messages.Total_Energy_In - can.BATTERY_ENERGY_CYCLES_CANID_TOTAL_ENERGY_IN_OFFSET);
        messages.Total_Energy_Out=(float) (messages.Total_Energy_Out - can.BATTERY_ENERGY_CYCLES_CANID_TOTAL_ENERGY_OUT_OFFSET);
        data[0] = (byte)(((byte)messages.Cycle_Energy_In & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Cycle_Energy_In >> can.BATTERY_ENERGY_CYCLES_CYCLE_ENERGY_IN_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Cycle_Enegy_Out & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Cycle_Enegy_Out >> can.BATTERY_ENERGY_CYCLES_CYCLE_ENEGY_OUT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Total_Energy_In & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Total_Energy_In >> can.BATTERY_ENERGY_CYCLES_TOTAL_ENERGY_IN_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Total_Energy_Out & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Total_Energy_Out >> can.BATTERY_ENERGY_CYCLES_TOTAL_ENERGY_OUT_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BATTERY_ENERGY_CYCLES_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OBC_Wakeup_Info( ConverterInitialize.OBC_Wakeup_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Wakeup = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.OBC_WAKEUP_INFO_OBC_WAKEUP_FACTOR)) + (can.OBC_WAKEUP_INFO_CANID_OBC_WAKEUP_OFFSET));

        return can.OBC_WAKEUP_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OBC_Wakeup_Info( ConverterInitialize.OBC_Wakeup_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Wakeup=(float) (messages.OBC_Wakeup - can.OBC_WAKEUP_INFO_CANID_OBC_WAKEUP_OFFSET);
        data[0] = (byte)(((byte)messages.OBC_Wakeup & ( can.SIGNLE_READ_Mask1)));
        return can.OBC_WAKEUP_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BATTERY_TEMPERATURE( ConverterInitialize.BATTERY_TEMPERATURE_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Battery_Temperature_1 = (float)((((data[0] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_TEMPERATURE_BATTERY_TEMPERATURE_1_FACTOR)) + (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_1_OFFSET));
        messages.Battery_Temperature_2 = (float)((((data[1] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_TEMPERATURE_BATTERY_TEMPERATURE_2_FACTOR)) + (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_2_OFFSET));
        messages.Battery_Temperature_3 = (float)((((data[2] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_TEMPERATURE_BATTERY_TEMPERATURE_3_FACTOR)) + (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_3_OFFSET));
        messages.Battery_Temperature_4 = (float)((((data[3] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_TEMPERATURE_BATTERY_TEMPERATURE_4_FACTOR)) + (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_4_OFFSET));
        messages.Battery_Temperature_5 = (float)((((data[4] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_TEMPERATURE_BATTERY_TEMPERATURE_5_FACTOR)) + (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_5_OFFSET));
        messages.Battery_Temperature_6 = (float)((((data[5] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_TEMPERATURE_BATTERY_TEMPERATURE_6_FACTOR)) + (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_6_OFFSET));
        messages.Battery_Temperature_Min = (float)((((data[6] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_TEMPERATURE_BATTERY_TEMPERATURE_MIN_FACTOR)) + (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_MIN_OFFSET));
        messages.Battery_Temperature_Max = (float)((((data[7] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_TEMPERATURE_BATTERY_TEMPERATURE_MAX_FACTOR)) + (can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_MAX_OFFSET));

        return can.BATTERY_TEMPERATURE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BATTERY_TEMPERATURE( ConverterInitialize.BATTERY_TEMPERATURE_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Battery_Temperature_1=(float) (messages.Battery_Temperature_1 - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_1_OFFSET);
        messages.Battery_Temperature_2=(float) (messages.Battery_Temperature_2 - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_2_OFFSET);
        messages.Battery_Temperature_3=(float) (messages.Battery_Temperature_3 - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_3_OFFSET);
        messages.Battery_Temperature_4=(float) (messages.Battery_Temperature_4 - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_4_OFFSET);
        messages.Battery_Temperature_5=(float) (messages.Battery_Temperature_5 - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_5_OFFSET);
        messages.Battery_Temperature_6=(float) (messages.Battery_Temperature_6 - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_6_OFFSET);
        messages.Battery_Temperature_Min=(float) (messages.Battery_Temperature_Min - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_MIN_OFFSET);
        messages.Battery_Temperature_Max=(float) (messages.Battery_Temperature_Max - can.BATTERY_TEMPERATURE_CANID_BATTERY_TEMPERATURE_MAX_OFFSET);
        data[0] = (byte)(((byte)messages.Battery_Temperature_1 & ( can.SIGNLE_READ_Mask8)));
        data[1] = (byte)(((byte)messages.Battery_Temperature_2 & ( can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Battery_Temperature_3 & ( can.SIGNLE_READ_Mask8)));
        data[3] = (byte)(((byte)messages.Battery_Temperature_4 & ( can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Battery_Temperature_5 & ( can.SIGNLE_READ_Mask8)));
        data[5] = (byte)(((byte)messages.Battery_Temperature_6 & ( can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Battery_Temperature_Min & ( can.SIGNLE_READ_Mask8)));
        data[7] = (byte)(((byte)messages.Battery_Temperature_Max & ( can.SIGNLE_READ_Mask8)));
        return can.BATTERY_TEMPERATURE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Custom_Mode( ConverterInitialize.Custom_Mode_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Custom_Drive_Enable = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.CUSTOM_MODE_CUSTOM_DRIVE_ENABLE_FACTOR)) + (can.CUSTOM_MODE_CANID_CUSTOM_DRIVE_ENABLE_OFFSET));
        messages.Power = (float)((((( data[1] & (can.SIGNLE_READ_Mask1)) << can.CUSTOM_MODE_POWER_MASK0) | (( data[0] >> can.CUSTOM_MODE_POWER_MASK1) & (can.SIGNLE_READ_Mask7))) * (can.CUSTOM_MODE_POWER_FACTOR)) + (can.CUSTOM_MODE_CANID_POWER_OFFSET));
        messages.Throttle_performance = (float)((((( data[2] & (can.SIGNLE_READ_Mask1)) << can.CUSTOM_MODE_THROTTLE_PERFORMANCE_MASK0) | (( data[1] >> can.CUSTOM_MODE_THROTTLE_PERFORMANCE_MASK1) & (can.SIGNLE_READ_Mask7))) * (can.CUSTOM_MODE_THROTTLE_PERFORMANCE_FACTOR)) + (can.CUSTOM_MODE_CANID_THROTTLE_PERFORMANCE_OFFSET));
        messages.Regen = (float)((((( data[3] & (can.SIGNLE_READ_Mask1)) << can.CUSTOM_MODE_REGEN_MASK0) | (( data[2] >> can.CUSTOM_MODE_REGEN_MASK1) & (can.SIGNLE_READ_Mask7))) * (can.CUSTOM_MODE_REGEN_FACTOR)) + (can.CUSTOM_MODE_CANID_REGEN_OFFSET));

        return can.CUSTOM_MODE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Custom_Mode( ConverterInitialize.Custom_Mode_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Custom_Drive_Enable=(float) (messages.Custom_Drive_Enable - can.CUSTOM_MODE_CANID_CUSTOM_DRIVE_ENABLE_OFFSET);
        messages.Power=(float) (messages.Power - can.CUSTOM_MODE_CANID_POWER_OFFSET);
        messages.Throttle_performance=(float) (messages.Throttle_performance - can.CUSTOM_MODE_CANID_THROTTLE_PERFORMANCE_OFFSET);
        messages.Regen=(float) (messages.Regen - can.CUSTOM_MODE_CANID_REGEN_OFFSET);
        data[0] = (byte)(((byte)messages.Custom_Drive_Enable & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Power & (can.SIGNLE_READ_Mask7)) << can.CUSTOM_MODE_POWER_MASK1));
        data[1] = (byte)((((byte)messages.Power >> can.CUSTOM_MODE_POWER_MASK0) & (can.SIGNLE_READ_Mask1)) | (((byte)messages.Throttle_performance & (can.SIGNLE_READ_Mask7)) << can.CUSTOM_MODE_THROTTLE_PERFORMANCE_MASK1));
        data[2] = (byte)((((byte)messages.Throttle_performance >> can.CUSTOM_MODE_THROTTLE_PERFORMANCE_MASK0) & (can.SIGNLE_READ_Mask1)) | (((byte)messages.Regen & (can.SIGNLE_READ_Mask7)) << can.CUSTOM_MODE_REGEN_MASK1));
        data[3] = (byte)((((byte)messages.Regen >> can.CUSTOM_MODE_REGEN_MASK0) & (can.SIGNLE_READ_Mask1)));
        return can.CUSTOM_MODE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_VCU_Data( ConverterInitialize.VCU_Data_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charger_Plugin = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_CHARGER_PLUGIN_FACTOR)) + (can.VCU_DATA_CANID_CHARGER_PLUGIN_OFFSET));
        messages.MCU_Power_Supply = (float)(((((data[0] >> can.VCU_DATA_MCU_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_MCU_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_MCU_POWER_SUPPLY_OFFSET));
        messages.HU_Power_Supply = (float)(((((data[0] >> can.VCU_DATA_HU_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_HU_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_HU_POWER_SUPPLY_OFFSET));
        messages.Left_Indicator_Power_Supply = (float)(((((data[0] >> can.VCU_DATA_LEFT_INDICATOR_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_LEFT_INDICATOR_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_LEFT_INDICATOR_POWER_SUPPLY_OFFSET));
        messages.Right_Indicator_Power_Supply = (float)(((((data[0] >> can.VCU_DATA_RIGHT_INDICATOR_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_RIGHT_INDICATOR_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_RIGHT_INDICATOR_POWER_SUPPLY_OFFSET));
        messages.High_Beam_Power_Supply = (float)(((((data[0] >> can.VCU_DATA_HIGH_BEAM_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_HIGH_BEAM_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_HIGH_BEAM_POWER_SUPPLY_OFFSET));
        messages.Low_Beam_Power_Supply = (float)(((((data[0] >> can.VCU_DATA_LOW_BEAM_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_LOW_BEAM_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_LOW_BEAM_POWER_SUPPLY_OFFSET));
        messages.DRL_Power_Supply = (float)(((((data[0] >> can.VCU_DATA_DRL_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_DRL_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_DRL_POWER_SUPPLY_OFFSET));
        messages.Left_Switch_Cube_Power_Supply = (float)((((data[1] & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_LEFT_SWITCH_CUBE_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_LEFT_SWITCH_CUBE_POWER_SUPPLY_OFFSET));
        messages.Right_Switch_Cube_Power_Supply = (float)(((((data[1] >> can.VCU_DATA_RIGHT_SWITCH_CUBE_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_RIGHT_SWITCH_CUBE_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_RIGHT_SWITCH_CUBE_POWER_SUPPLY_OFFSET));
        messages.Horn_Power_Supply = (float)(((((data[1] >> can.VCU_DATA_HORN_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_HORN_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_HORN_POWER_SUPPLY_OFFSET));
        messages.Speaker_Power_Supply = (float)(((((data[1] >> can.VCU_DATA_SPEAKER_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_SPEAKER_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_SPEAKER_POWER_SUPPLY_OFFSET));
        messages.SOM_Power_Supply = (float)(((((data[1] >> can.VCU_DATA_SOM_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_SOM_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_SOM_POWER_SUPPLY_OFFSET));
        messages.ESCL_Power_Supply = (float)(((((data[1] >> can.VCU_DATA_ESCL_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_ESCL_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_ESCL_POWER_SUPPLY_OFFSET));
        messages.ESCL_Commands = (float)((((( data[2] & (can.SIGNLE_READ_Mask1)) << can.VCU_DATA_ESCL_COMMANDS_MASK0) | (( data[1] >> can.VCU_DATA_ESCL_COMMANDS_MASK1) & (can.SIGNLE_READ_Mask2))) * (can.VCU_DATA_ESCL_COMMANDS_FACTOR)) + (can.VCU_DATA_CANID_ESCL_COMMANDS_OFFSET));
        messages.Stop_Lamp_Power_Supply = (float)(((((data[2] >> can.VCU_DATA_STOP_LAMP_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_STOP_LAMP_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_STOP_LAMP_POWER_SUPPLY_OFFSET));
        messages.Tail_Lamp_Power_Supply = (float)(((((data[2] >> can.VCU_DATA_TAIL_LAMP_POWER_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_TAIL_LAMP_POWER_SUPPLY_FACTOR)) + (can.VCU_DATA_CANID_TAIL_LAMP_POWER_SUPPLY_OFFSET));
        messages.Charger_Info = (float)((((data[3] & (can.SIGNLE_READ_Mask1))) * (can.VCU_DATA_CHARGER_INFO_FACTOR)) + (can.VCU_DATA_CANID_CHARGER_INFO_OFFSET));

        return can.VCU_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_VCU_Data( ConverterInitialize.VCU_Data_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charger_Plugin=(float) (messages.Charger_Plugin - can.VCU_DATA_CANID_CHARGER_PLUGIN_OFFSET);
        messages.MCU_Power_Supply=(float) (messages.MCU_Power_Supply - can.VCU_DATA_CANID_MCU_POWER_SUPPLY_OFFSET);
        messages.HU_Power_Supply=(float) (messages.HU_Power_Supply - can.VCU_DATA_CANID_HU_POWER_SUPPLY_OFFSET);
        messages.Left_Indicator_Power_Supply=(float) (messages.Left_Indicator_Power_Supply - can.VCU_DATA_CANID_LEFT_INDICATOR_POWER_SUPPLY_OFFSET);
        messages.Right_Indicator_Power_Supply=(float) (messages.Right_Indicator_Power_Supply - can.VCU_DATA_CANID_RIGHT_INDICATOR_POWER_SUPPLY_OFFSET);
        messages.High_Beam_Power_Supply=(float) (messages.High_Beam_Power_Supply - can.VCU_DATA_CANID_HIGH_BEAM_POWER_SUPPLY_OFFSET);
        messages.Low_Beam_Power_Supply=(float) (messages.Low_Beam_Power_Supply - can.VCU_DATA_CANID_LOW_BEAM_POWER_SUPPLY_OFFSET);
        messages.DRL_Power_Supply=(float) (messages.DRL_Power_Supply - can.VCU_DATA_CANID_DRL_POWER_SUPPLY_OFFSET);
        messages.Left_Switch_Cube_Power_Supply=(float) (messages.Left_Switch_Cube_Power_Supply - can.VCU_DATA_CANID_LEFT_SWITCH_CUBE_POWER_SUPPLY_OFFSET);
        messages.Right_Switch_Cube_Power_Supply=(float) (messages.Right_Switch_Cube_Power_Supply - can.VCU_DATA_CANID_RIGHT_SWITCH_CUBE_POWER_SUPPLY_OFFSET);
        messages.Horn_Power_Supply=(float) (messages.Horn_Power_Supply - can.VCU_DATA_CANID_HORN_POWER_SUPPLY_OFFSET);
        messages.Speaker_Power_Supply=(float) (messages.Speaker_Power_Supply - can.VCU_DATA_CANID_SPEAKER_POWER_SUPPLY_OFFSET);
        messages.SOM_Power_Supply=(float) (messages.SOM_Power_Supply - can.VCU_DATA_CANID_SOM_POWER_SUPPLY_OFFSET);
        messages.ESCL_Power_Supply=(float) (messages.ESCL_Power_Supply - can.VCU_DATA_CANID_ESCL_POWER_SUPPLY_OFFSET);
        messages.ESCL_Commands=(float) (messages.ESCL_Commands - can.VCU_DATA_CANID_ESCL_COMMANDS_OFFSET);
        messages.Stop_Lamp_Power_Supply=(float) (messages.Stop_Lamp_Power_Supply - can.VCU_DATA_CANID_STOP_LAMP_POWER_SUPPLY_OFFSET);
        messages.Tail_Lamp_Power_Supply=(float) (messages.Tail_Lamp_Power_Supply - can.VCU_DATA_CANID_TAIL_LAMP_POWER_SUPPLY_OFFSET);
        messages.Charger_Info=(float) (messages.Charger_Info - can.VCU_DATA_CANID_CHARGER_INFO_OFFSET);
        data[0] = (byte)(((byte)messages.Charger_Plugin & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.MCU_Power_Supply & ( can.SIGNLE_READ_Mask1)) << can.VCU_DATA_MCU_POWER_SUPPLY_MASK0) | (((byte)messages.HU_Power_Supply & ( can.SIGNLE_READ_Mask1)) << can.VCU_DATA_HU_POWER_SUPPLY_MASK0) | (((byte)messages.Left_Indicator_Power_Supply & ( can.SIGNLE_READ_Mask1)) << can.VCU_DATA_LEFT_INDICATOR_POWER_SUPPLY_MASK0) | (((byte)messages.Right_Indicator_Power_Supply & ( can.SIGNLE_READ_Mask1)) << can.VCU_DATA_RIGHT_INDICATOR_POWER_SUPPLY_MASK0) | (((byte)messages.High_Beam_Power_Supply & ( can.SIGNLE_READ_Mask1)) << can.VCU_DATA_HIGH_BEAM_POWER_SUPPLY_MASK0) | (((byte)messages.Low_Beam_Power_Supply & ( can.SIGNLE_READ_Mask1)) << can.VCU_DATA_LOW_BEAM_POWER_SUPPLY_MASK0) | (((byte)messages.DRL_Power_Supply & ( can.SIGNLE_READ_Mask1)) << can.VCU_DATA_DRL_POWER_SUPPLY_MASK0));
        data[1] = (byte)(((byte)messages.Left_Switch_Cube_Power_Supply & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Right_Switch_Cube_Power_Supply & ( can.SIGNLE_READ_Mask1)) << can.VCU_DATA_RIGHT_SWITCH_CUBE_POWER_SUPPLY_MASK0) | (((byte)messages.Horn_Power_Supply & ( can.SIGNLE_READ_Mask1)) << can.VCU_DATA_HORN_POWER_SUPPLY_MASK0) | (((byte)messages.Speaker_Power_Supply & ( can.SIGNLE_READ_Mask1)) << can.VCU_DATA_SPEAKER_POWER_SUPPLY_MASK0) | (((byte)messages.SOM_Power_Supply & ( can.SIGNLE_READ_Mask1)) << can.VCU_DATA_SOM_POWER_SUPPLY_MASK0) | (((byte)messages.ESCL_Power_Supply & ( can.SIGNLE_READ_Mask1)) << can.VCU_DATA_ESCL_POWER_SUPPLY_MASK0) | (((byte)messages.ESCL_Commands & (can.SIGNLE_READ_Mask2)) << can.VCU_DATA_ESCL_COMMANDS_MASK1));
        data[2] = (byte)((((byte)messages.ESCL_Commands >> can.VCU_DATA_ESCL_COMMANDS_MASK0) & (can.SIGNLE_READ_Mask1)) | (((byte)messages.Stop_Lamp_Power_Supply & ( can.SIGNLE_READ_Mask1)) << can.VCU_DATA_STOP_LAMP_POWER_SUPPLY_MASK0) | (((byte)messages.Tail_Lamp_Power_Supply & ( can.SIGNLE_READ_Mask1)) << can.VCU_DATA_TAIL_LAMP_POWER_SUPPLY_MASK0));
        data[3] = (byte)(((byte)messages.Charger_Info & ( can.SIGNLE_READ_Mask1)));
        return can.VCU_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_STATUS( ConverterInitialize.BMS_CELL_STATUS_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Balancing_Status_Cell_1 = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_1_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_1_OFFSET));
        messages.BMS_Balancing_Status_Cell_2 = (float)(((((data[0] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_2_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_2_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_2_OFFSET));
        messages.BMS_Balancing_Status_Cell_3 = (float)(((((data[0] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_3_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_3_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_3_OFFSET));
        messages.BMS_Balancing_Status_Cell_4 = (float)(((((data[0] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_4_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_4_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_4_OFFSET));
        messages.BMS_Balancing_Status_Cell_5 = (float)(((((data[0] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_5_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_5_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_5_OFFSET));
        messages.BMS_Balancing_Status_Cell_6 = (float)(((((data[0] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_6_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_6_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_6_OFFSET));
        messages.BMS_Balancing_Status_Cell_7 = (float)(((((data[0] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_7_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_7_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_7_OFFSET));
        messages.BMS_Balancing_Status_Cell_8 = (float)(((((data[0] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_8_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_8_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_8_OFFSET));
        messages.BMS_Balancing_Status_Cell_9 = (float)((((data[1] & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_9_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_9_OFFSET));
        messages.BMS_Balancing_Status_Cell_10 = (float)(((((data[1] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_10_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_10_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_10_OFFSET));
        messages.BMS_Balancing_Status_Cell_11 = (float)(((((data[1] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_11_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_11_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_11_OFFSET));
        messages.BMS_Balancing_Status_Cell_12 = (float)(((((data[1] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_12_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_12_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_12_OFFSET));
        messages.BMS_Balancing_Status_Cell_13 = (float)(((((data[1] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_13_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_13_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_13_OFFSET));
        messages.BMS_Balancing_Status_Cell_14 = (float)(((((data[1] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_14_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_14_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_14_OFFSET));
        messages.BMS_Balancing_Status_Cell_15 = (float)(((((data[1] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_15_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_15_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_15_OFFSET));
        messages.BMS_Balancing_Status_Cell_16 = (float)(((((data[1] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_16_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_16_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_16_OFFSET));
        messages.BMS_Balancing_Status_Cell_17 = (float)((((data[2] & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_17_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_17_OFFSET));
        messages.BMS_Balancing_Status_Cell_18 = (float)(((((data[2] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_18_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_18_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_18_OFFSET));
        messages.BMS_Balancing_Status_Cell_20 = (float)(((((data[2] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_20_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_20_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_20_OFFSET));
        messages.BMS_Balancing_Status_Cell_21 = (float)(((((data[2] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_21_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_21_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_21_OFFSET));
        messages.BMS_Balancing_Status_Cell_22 = (float)(((((data[2] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_22_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_22_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_22_OFFSET));
        messages.BMS_Balancing_Status_Cell_23 = (float)(((((data[2] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_23_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_23_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_23_OFFSET));
        messages.BMS_Balancing_Status_Cell_24 = (float)(((((data[2] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_24_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_24_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_24_OFFSET));
        messages.BMS_Balancing_Status_Cell_25 = (float)((((data[3] & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_25_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_25_OFFSET));
        messages.BMS_Balancing_Status_Cell_26 = (float)(((((data[3] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_26_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_26_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_26_OFFSET));
        messages.BMS_Balancing_Status_Cell_27 = (float)(((((data[3] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_27_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_27_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_27_OFFSET));
        messages.BMS_Balancing_Status_Cell_28 = (float)(((((data[3] >> can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_28_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_28_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_28_OFFSET));
        messages.BMS_Cell_Min_Voltage = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_STATUS_BMS_CELL_MIN_VOLTAGE_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_STATUS_BMS_CELL_MIN_VOLTAGE_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_CELL_MIN_VOLTAGE_OFFSET));
        messages.BMS_Cell_Max_Voltage = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_STATUS_BMS_CELL_MAX_VOLTAGE_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_STATUS_BMS_CELL_MAX_VOLTAGE_FACTOR)) + (can.BMS_CELL_STATUS_CANID_BMS_CELL_MAX_VOLTAGE_OFFSET));

        return can.BMS_CELL_STATUS_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_STATUS( ConverterInitialize.BMS_CELL_STATUS_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Balancing_Status_Cell_1=(float) (messages.BMS_Balancing_Status_Cell_1 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_1_OFFSET);
        messages.BMS_Balancing_Status_Cell_2=(float) (messages.BMS_Balancing_Status_Cell_2 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_2_OFFSET);
        messages.BMS_Balancing_Status_Cell_3=(float) (messages.BMS_Balancing_Status_Cell_3 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_3_OFFSET);
        messages.BMS_Balancing_Status_Cell_4=(float) (messages.BMS_Balancing_Status_Cell_4 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_4_OFFSET);
        messages.BMS_Balancing_Status_Cell_5=(float) (messages.BMS_Balancing_Status_Cell_5 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_5_OFFSET);
        messages.BMS_Balancing_Status_Cell_6=(float) (messages.BMS_Balancing_Status_Cell_6 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_6_OFFSET);
        messages.BMS_Balancing_Status_Cell_7=(float) (messages.BMS_Balancing_Status_Cell_7 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_7_OFFSET);
        messages.BMS_Balancing_Status_Cell_8=(float) (messages.BMS_Balancing_Status_Cell_8 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_8_OFFSET);
        messages.BMS_Balancing_Status_Cell_9=(float) (messages.BMS_Balancing_Status_Cell_9 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_9_OFFSET);
        messages.BMS_Balancing_Status_Cell_10=(float) (messages.BMS_Balancing_Status_Cell_10 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_10_OFFSET);
        messages.BMS_Balancing_Status_Cell_11=(float) (messages.BMS_Balancing_Status_Cell_11 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_11_OFFSET);
        messages.BMS_Balancing_Status_Cell_12=(float) (messages.BMS_Balancing_Status_Cell_12 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_12_OFFSET);
        messages.BMS_Balancing_Status_Cell_13=(float) (messages.BMS_Balancing_Status_Cell_13 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_13_OFFSET);
        messages.BMS_Balancing_Status_Cell_14=(float) (messages.BMS_Balancing_Status_Cell_14 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_14_OFFSET);
        messages.BMS_Balancing_Status_Cell_15=(float) (messages.BMS_Balancing_Status_Cell_15 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_15_OFFSET);
        messages.BMS_Balancing_Status_Cell_16=(float) (messages.BMS_Balancing_Status_Cell_16 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_16_OFFSET);
        messages.BMS_Balancing_Status_Cell_17=(float) (messages.BMS_Balancing_Status_Cell_17 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_17_OFFSET);
        messages.BMS_Balancing_Status_Cell_18=(float) (messages.BMS_Balancing_Status_Cell_18 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_18_OFFSET);
        messages.BMS_Balancing_Status_Cell_20=(float) (messages.BMS_Balancing_Status_Cell_20 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_20_OFFSET);
        messages.BMS_Balancing_Status_Cell_21=(float) (messages.BMS_Balancing_Status_Cell_21 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_21_OFFSET);
        messages.BMS_Balancing_Status_Cell_22=(float) (messages.BMS_Balancing_Status_Cell_22 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_22_OFFSET);
        messages.BMS_Balancing_Status_Cell_23=(float) (messages.BMS_Balancing_Status_Cell_23 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_23_OFFSET);
        messages.BMS_Balancing_Status_Cell_24=(float) (messages.BMS_Balancing_Status_Cell_24 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_24_OFFSET);
        messages.BMS_Balancing_Status_Cell_25=(float) (messages.BMS_Balancing_Status_Cell_25 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_25_OFFSET);
        messages.BMS_Balancing_Status_Cell_26=(float) (messages.BMS_Balancing_Status_Cell_26 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_26_OFFSET);
        messages.BMS_Balancing_Status_Cell_27=(float) (messages.BMS_Balancing_Status_Cell_27 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_27_OFFSET);
        messages.BMS_Balancing_Status_Cell_28=(float) (messages.BMS_Balancing_Status_Cell_28 - can.BMS_CELL_STATUS_CANID_BMS_BALANCING_STATUS_CELL_28_OFFSET);
        messages.BMS_Cell_Min_Voltage=(float) (messages.BMS_Cell_Min_Voltage - can.BMS_CELL_STATUS_CANID_BMS_CELL_MIN_VOLTAGE_OFFSET);
        messages.BMS_Cell_Max_Voltage=(float) (messages.BMS_Cell_Max_Voltage - can.BMS_CELL_STATUS_CANID_BMS_CELL_MAX_VOLTAGE_OFFSET);
        data[0] = (byte)(((byte)messages.BMS_Balancing_Status_Cell_1 & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_Balancing_Status_Cell_2 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_2_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_3 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_3_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_4 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_4_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_5 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_5_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_6 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_6_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_7 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_7_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_8 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_8_MASK0));
        data[1] = (byte)(((byte)messages.BMS_Balancing_Status_Cell_9 & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_Balancing_Status_Cell_10 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_10_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_11 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_11_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_12 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_12_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_13 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_13_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_14 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_14_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_15 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_15_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_16 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_16_MASK0));
        data[2] = (byte)(((byte)messages.BMS_Balancing_Status_Cell_17 & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_Balancing_Status_Cell_18 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_18_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_20 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_20_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_21 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_21_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_22 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_22_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_23 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_23_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_24 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_24_MASK0));
        data[3] = (byte)(((byte)messages.BMS_Balancing_Status_Cell_25 & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_Balancing_Status_Cell_26 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_26_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_27 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_27_MASK0) | (((byte)messages.BMS_Balancing_Status_Cell_28 & ( can.SIGNLE_READ_Mask1)) << can.BMS_CELL_STATUS_BMS_BALANCING_STATUS_CELL_28_MASK0));
        data[4] = (byte)(((byte)messages.BMS_Cell_Min_Voltage & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.BMS_Cell_Min_Voltage >> can.BMS_CELL_STATUS_BMS_CELL_MIN_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.BMS_Cell_Max_Voltage & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.BMS_Cell_Max_Voltage >> can.BMS_CELL_STATUS_BMS_CELL_MAX_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_STATUS_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Charger_Parameter_1( ConverterInitialize.Charger_Parameter_1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charger_IP_AC_Volt = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.CHARGER_PARAMETER_1_CHARGER_IP_AC_VOLT_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.CHARGER_PARAMETER_1_CHARGER_IP_AC_VOLT_FACTOR)) + (can.CHARGER_PARAMETER_1_CANID_CHARGER_IP_AC_VOLT_OFFSET));
        messages.Charger_IP_AC_Current = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.CHARGER_PARAMETER_1_CHARGER_IP_AC_CURRENT_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.CHARGER_PARAMETER_1_CHARGER_IP_AC_CURRENT_FACTOR)) + (can.CHARGER_PARAMETER_1_CANID_CHARGER_IP_AC_CURRENT_OFFSET));
        messages.Charger_OP_DC_Volt = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.CHARGER_PARAMETER_1_CHARGER_OP_DC_VOLT_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.CHARGER_PARAMETER_1_CHARGER_OP_DC_VOLT_FACTOR)) + (can.CHARGER_PARAMETER_1_CANID_CHARGER_OP_DC_VOLT_OFFSET));
        messages.Charger_OP_DC_Current = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.CHARGER_PARAMETER_1_CHARGER_OP_DC_CURRENT_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.CHARGER_PARAMETER_1_CHARGER_OP_DC_CURRENT_FACTOR)) + (can.CHARGER_PARAMETER_1_CANID_CHARGER_OP_DC_CURRENT_OFFSET));

        return can.CHARGER_PARAMETER_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Charger_Parameter_1( ConverterInitialize.Charger_Parameter_1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charger_IP_AC_Volt=(float) (messages.Charger_IP_AC_Volt - can.CHARGER_PARAMETER_1_CANID_CHARGER_IP_AC_VOLT_OFFSET);
        messages.Charger_IP_AC_Current=(float) (messages.Charger_IP_AC_Current - can.CHARGER_PARAMETER_1_CANID_CHARGER_IP_AC_CURRENT_OFFSET);
        messages.Charger_OP_DC_Volt=(float) (messages.Charger_OP_DC_Volt - can.CHARGER_PARAMETER_1_CANID_CHARGER_OP_DC_VOLT_OFFSET);
        messages.Charger_OP_DC_Current=(float) (messages.Charger_OP_DC_Current - can.CHARGER_PARAMETER_1_CANID_CHARGER_OP_DC_CURRENT_OFFSET);
        data[0] = (byte)(((byte)messages.Charger_IP_AC_Volt & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Charger_IP_AC_Volt >> can.CHARGER_PARAMETER_1_CHARGER_IP_AC_VOLT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Charger_IP_AC_Current & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Charger_IP_AC_Current >> can.CHARGER_PARAMETER_1_CHARGER_IP_AC_CURRENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Charger_OP_DC_Volt & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Charger_OP_DC_Volt >> can.CHARGER_PARAMETER_1_CHARGER_OP_DC_VOLT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Charger_OP_DC_Current & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Charger_OP_DC_Current >> can.CHARGER_PARAMETER_1_CHARGER_OP_DC_CURRENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.CHARGER_PARAMETER_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OBC_HP_DCDC_Parameter_2( ConverterInitialize.OBC_HP_DCDC_Parameter_2_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_temp = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.OBC_HP_DCDC_PARAMETER_2_OBC_TEMP_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.OBC_HP_DCDC_PARAMETER_2_OBC_TEMP_FACTOR)) + (can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_TEMP_OFFSET));
        messages.HP_DCDC_Temp = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.OBC_HP_DCDC_PARAMETER_2_HP_DCDC_TEMP_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.OBC_HP_DCDC_PARAMETER_2_HP_DCDC_TEMP_FACTOR)) + (can.OBC_HP_DCDC_PARAMETER_2_CANID_HP_DCDC_TEMP_OFFSET));
        messages.OBC_OP_Enable = (float)((((data[4] & (can.SIGNLE_READ_Mask1))) * (can.OBC_HP_DCDC_PARAMETER_2_OBC_OP_ENABLE_FACTOR)) + (can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_OP_ENABLE_OFFSET));
        messages.OBC_Coolant_Fan_Status = (float)(((((data[4] >> can.OBC_HP_DCDC_PARAMETER_2_OBC_COOLANT_FAN_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.OBC_HP_DCDC_PARAMETER_2_OBC_COOLANT_FAN_STATUS_FACTOR)) + (can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_COOLANT_FAN_STATUS_OFFSET));
        messages.Control_Proximity_status = (float)(((((data[4] >> can.OBC_HP_DCDC_PARAMETER_2_CONTROL_PROXIMITY_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.OBC_HP_DCDC_PARAMETER_2_CONTROL_PROXIMITY_STATUS_FACTOR)) + (can.OBC_HP_DCDC_PARAMETER_2_CANID_CONTROL_PROXIMITY_STATUS_OFFSET));
        messages.DCDC_Conv_OP_Enable = (float)(((((data[4] >> can.OBC_HP_DCDC_PARAMETER_2_DCDC_CONV_OP_ENABLE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.OBC_HP_DCDC_PARAMETER_2_DCDC_CONV_OP_ENABLE_FACTOR)) + (can.OBC_HP_DCDC_PARAMETER_2_CANID_DCDC_CONV_OP_ENABLE_OFFSET));
        messages.OBC_FET_Temp = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.OBC_HP_DCDC_PARAMETER_2_OBC_FET_TEMP_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.OBC_HP_DCDC_PARAMETER_2_OBC_FET_TEMP_FACTOR)) + (can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_FET_TEMP_OFFSET));

        return can.OBC_HP_DCDC_PARAMETER_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OBC_HP_DCDC_Parameter_2( ConverterInitialize.OBC_HP_DCDC_Parameter_2_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_temp=(float) (messages.OBC_temp - can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_TEMP_OFFSET);
        messages.HP_DCDC_Temp=(float) (messages.HP_DCDC_Temp - can.OBC_HP_DCDC_PARAMETER_2_CANID_HP_DCDC_TEMP_OFFSET);
        messages.OBC_OP_Enable=(float) (messages.OBC_OP_Enable - can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_OP_ENABLE_OFFSET);
        messages.OBC_Coolant_Fan_Status=(float) (messages.OBC_Coolant_Fan_Status - can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_COOLANT_FAN_STATUS_OFFSET);
        messages.Control_Proximity_status=(float) (messages.Control_Proximity_status - can.OBC_HP_DCDC_PARAMETER_2_CANID_CONTROL_PROXIMITY_STATUS_OFFSET);
        messages.DCDC_Conv_OP_Enable=(float) (messages.DCDC_Conv_OP_Enable - can.OBC_HP_DCDC_PARAMETER_2_CANID_DCDC_CONV_OP_ENABLE_OFFSET);
        messages.OBC_FET_Temp=(float) (messages.OBC_FET_Temp - can.OBC_HP_DCDC_PARAMETER_2_CANID_OBC_FET_TEMP_OFFSET);
        data[0] = (byte)(((byte)messages.OBC_temp & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.OBC_temp >> can.OBC_HP_DCDC_PARAMETER_2_OBC_TEMP_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.HP_DCDC_Temp & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.HP_DCDC_Temp >> can.OBC_HP_DCDC_PARAMETER_2_HP_DCDC_TEMP_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.OBC_OP_Enable & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.OBC_Coolant_Fan_Status & ( can.SIGNLE_READ_Mask1)) << can.OBC_HP_DCDC_PARAMETER_2_OBC_COOLANT_FAN_STATUS_MASK0) | (((byte)messages.Control_Proximity_status & ( can.SIGNLE_READ_Mask1)) << can.OBC_HP_DCDC_PARAMETER_2_CONTROL_PROXIMITY_STATUS_MASK0) | (((byte)messages.DCDC_Conv_OP_Enable & ( can.SIGNLE_READ_Mask1)) << can.OBC_HP_DCDC_PARAMETER_2_DCDC_CONV_OP_ENABLE_MASK0));
        data[6] = (byte)(((byte)messages.OBC_FET_Temp & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.OBC_FET_Temp >> can.OBC_HP_DCDC_PARAMETER_2_OBC_FET_TEMP_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.OBC_HP_DCDC_PARAMETER_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_VOLTAGE_1( ConverterInitialize.BMS_CELL_VOLTAGE_1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_1 = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_1_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_1_FACTOR)) + (can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_1_OFFSET));
        messages.Cell_Voltage_Vcell_2 = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_2_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_2_FACTOR)) + (can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_2_OFFSET));
        messages.Cell_Voltage_Vcell_3 = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_3_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_3_FACTOR)) + (can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_3_OFFSET));
        messages.Cell_Voltage_Vcell_4 = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_4_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_4_FACTOR)) + (can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_4_OFFSET));

        return can.BMS_CELL_VOLTAGE_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_VOLTAGE_1( ConverterInitialize.BMS_CELL_VOLTAGE_1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_1=(float) (messages.Cell_Voltage_Vcell_1 - can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_1_OFFSET);
        messages.Cell_Voltage_Vcell_2=(float) (messages.Cell_Voltage_Vcell_2 - can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_2_OFFSET);
        messages.Cell_Voltage_Vcell_3=(float) (messages.Cell_Voltage_Vcell_3 - can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_3_OFFSET);
        messages.Cell_Voltage_Vcell_4=(float) (messages.Cell_Voltage_Vcell_4 - can.BMS_CELL_VOLTAGE_1_CANID_CELL_VOLTAGE_VCELL_4_OFFSET);
        data[0] = (byte)(((byte)messages.Cell_Voltage_Vcell_1 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Cell_Voltage_Vcell_1 >> can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_1_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Cell_Voltage_Vcell_2 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Cell_Voltage_Vcell_2 >> can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_2_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Cell_Voltage_Vcell_3 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Cell_Voltage_Vcell_3 >> can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_3_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Cell_Voltage_Vcell_4 & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Cell_Voltage_Vcell_4 >> can.BMS_CELL_VOLTAGE_1_CELL_VOLTAGE_VCELL_4_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_VOLTAGE_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_VOLTAGE_2( ConverterInitialize.BMS_CELL_VOLTAGE_2_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_5 = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_5_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_5_FACTOR)) + (can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_5_OFFSET));
        messages.Cell_Voltage_Vcell_6 = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_6_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_6_FACTOR)) + (can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_6_OFFSET));
        messages.Cell_Voltage_Vcell_7 = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_7_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_7_FACTOR)) + (can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_7_OFFSET));
        messages.Cell_Voltage_Vcell_8 = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_8_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_8_FACTOR)) + (can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_8_OFFSET));

        return can.BMS_CELL_VOLTAGE_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_VOLTAGE_2( ConverterInitialize.BMS_CELL_VOLTAGE_2_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_5=(float) (messages.Cell_Voltage_Vcell_5 - can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_5_OFFSET);
        messages.Cell_Voltage_Vcell_6=(float) (messages.Cell_Voltage_Vcell_6 - can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_6_OFFSET);
        messages.Cell_Voltage_Vcell_7=(float) (messages.Cell_Voltage_Vcell_7 - can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_7_OFFSET);
        messages.Cell_Voltage_Vcell_8=(float) (messages.Cell_Voltage_Vcell_8 - can.BMS_CELL_VOLTAGE_2_CANID_CELL_VOLTAGE_VCELL_8_OFFSET);
        data[0] = (byte)(((byte)messages.Cell_Voltage_Vcell_5 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Cell_Voltage_Vcell_5 >> can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_5_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Cell_Voltage_Vcell_6 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Cell_Voltage_Vcell_6 >> can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_6_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Cell_Voltage_Vcell_7 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Cell_Voltage_Vcell_7 >> can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_7_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Cell_Voltage_Vcell_8 & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Cell_Voltage_Vcell_8 >> can.BMS_CELL_VOLTAGE_2_CELL_VOLTAGE_VCELL_8_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_VOLTAGE_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_VOLTAGE_3( ConverterInitialize.BMS_CELL_VOLTAGE_3_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_9 = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_9_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_9_FACTOR)) + (can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_9_OFFSET));
        messages.Cell_Voltage_Vcell_10 = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_10_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_10_FACTOR)) + (can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_10_OFFSET));
        messages.Cell_Voltage_Vcell_11 = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_11_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_11_FACTOR)) + (can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_11_OFFSET));
        messages.Cell_Voltage_Vcell_12 = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_12_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_12_FACTOR)) + (can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_12_OFFSET));

        return can.BMS_CELL_VOLTAGE_3_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_VOLTAGE_3( ConverterInitialize.BMS_CELL_VOLTAGE_3_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_9=(float) (messages.Cell_Voltage_Vcell_9 - can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_9_OFFSET);
        messages.Cell_Voltage_Vcell_10=(float) (messages.Cell_Voltage_Vcell_10 - can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_10_OFFSET);
        messages.Cell_Voltage_Vcell_11=(float) (messages.Cell_Voltage_Vcell_11 - can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_11_OFFSET);
        messages.Cell_Voltage_Vcell_12=(float) (messages.Cell_Voltage_Vcell_12 - can.BMS_CELL_VOLTAGE_3_CANID_CELL_VOLTAGE_VCELL_12_OFFSET);
        data[0] = (byte)(((byte)messages.Cell_Voltage_Vcell_9 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Cell_Voltage_Vcell_9 >> can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_9_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Cell_Voltage_Vcell_10 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Cell_Voltage_Vcell_10 >> can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_10_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Cell_Voltage_Vcell_11 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Cell_Voltage_Vcell_11 >> can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_11_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Cell_Voltage_Vcell_12 & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Cell_Voltage_Vcell_12 >> can.BMS_CELL_VOLTAGE_3_CELL_VOLTAGE_VCELL_12_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_VOLTAGE_3_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_VOLTAGE_4( ConverterInitialize.BMS_CELL_VOLTAGE_4_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_13 = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_13_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_13_FACTOR)) + (can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_13_OFFSET));
        messages.Cell_Voltage_Vcell_14 = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_14_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_14_FACTOR)) + (can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_14_OFFSET));
        messages.Cell_Voltage_Vcell_15 = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_15_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_15_FACTOR)) + (can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_15_OFFSET));
        messages.Cell_Voltage_Vcell_16 = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_16_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_16_FACTOR)) + (can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_16_OFFSET));

        return can.BMS_CELL_VOLTAGE_4_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_VOLTAGE_4( ConverterInitialize.BMS_CELL_VOLTAGE_4_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_13=(float) (messages.Cell_Voltage_Vcell_13 - can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_13_OFFSET);
        messages.Cell_Voltage_Vcell_14=(float) (messages.Cell_Voltage_Vcell_14 - can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_14_OFFSET);
        messages.Cell_Voltage_Vcell_15=(float) (messages.Cell_Voltage_Vcell_15 - can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_15_OFFSET);
        messages.Cell_Voltage_Vcell_16=(float) (messages.Cell_Voltage_Vcell_16 - can.BMS_CELL_VOLTAGE_4_CANID_CELL_VOLTAGE_VCELL_16_OFFSET);
        data[0] = (byte)(((byte)messages.Cell_Voltage_Vcell_13 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Cell_Voltage_Vcell_13 >> can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_13_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Cell_Voltage_Vcell_14 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Cell_Voltage_Vcell_14 >> can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_14_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Cell_Voltage_Vcell_15 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Cell_Voltage_Vcell_15 >> can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_15_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Cell_Voltage_Vcell_16 & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Cell_Voltage_Vcell_16 >> can.BMS_CELL_VOLTAGE_4_CELL_VOLTAGE_VCELL_16_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_VOLTAGE_4_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_VOLTAGE_5( ConverterInitialize.BMS_CELL_VOLTAGE_5_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_17 = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_17_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_17_FACTOR)) + (can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_17_OFFSET));
        messages.Cell_Voltage_Vcell_18 = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_18_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_18_FACTOR)) + (can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_18_OFFSET));
        messages.Cell_Voltage_Vcell_19 = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_19_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_19_FACTOR)) + (can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_19_OFFSET));
        messages.Cell_Voltage_Vcell_20 = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_20_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_20_FACTOR)) + (can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_20_OFFSET));

        return can.BMS_CELL_VOLTAGE_5_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_VOLTAGE_5( ConverterInitialize.BMS_CELL_VOLTAGE_5_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_17=(float) (messages.Cell_Voltage_Vcell_17 - can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_17_OFFSET);
        messages.Cell_Voltage_Vcell_18=(float) (messages.Cell_Voltage_Vcell_18 - can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_18_OFFSET);
        messages.Cell_Voltage_Vcell_19=(float) (messages.Cell_Voltage_Vcell_19 - can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_19_OFFSET);
        messages.Cell_Voltage_Vcell_20=(float) (messages.Cell_Voltage_Vcell_20 - can.BMS_CELL_VOLTAGE_5_CANID_CELL_VOLTAGE_VCELL_20_OFFSET);
        data[0] = (byte)(((byte)messages.Cell_Voltage_Vcell_17 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Cell_Voltage_Vcell_17 >> can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_17_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Cell_Voltage_Vcell_18 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Cell_Voltage_Vcell_18 >> can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_18_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Cell_Voltage_Vcell_19 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Cell_Voltage_Vcell_19 >> can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_19_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Cell_Voltage_Vcell_20 & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Cell_Voltage_Vcell_20 >> can.BMS_CELL_VOLTAGE_5_CELL_VOLTAGE_VCELL_20_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_VOLTAGE_5_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_VOLTAGE_6( ConverterInitialize.BMS_CELL_VOLTAGE_6_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_21 = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_21_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_21_FACTOR)) + (can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_21_OFFSET));
        messages.Cell_Voltage_Vcell_22 = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_22_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_22_FACTOR)) + (can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_22_OFFSET));
        messages.Cell_Voltage_Vcell_23 = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_23_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_23_FACTOR)) + (can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_23_OFFSET));
        messages.Cell_Voltage_Vcell_24 = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_24_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_24_FACTOR)) + (can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_24_OFFSET));

        return can.BMS_CELL_VOLTAGE_6_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_VOLTAGE_6( ConverterInitialize.BMS_CELL_VOLTAGE_6_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_21=(float) (messages.Cell_Voltage_Vcell_21 - can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_21_OFFSET);
        messages.Cell_Voltage_Vcell_22=(float) (messages.Cell_Voltage_Vcell_22 - can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_22_OFFSET);
        messages.Cell_Voltage_Vcell_23=(float) (messages.Cell_Voltage_Vcell_23 - can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_23_OFFSET);
        messages.Cell_Voltage_Vcell_24=(float) (messages.Cell_Voltage_Vcell_24 - can.BMS_CELL_VOLTAGE_6_CANID_CELL_VOLTAGE_VCELL_24_OFFSET);
        data[0] = (byte)(((byte)messages.Cell_Voltage_Vcell_21 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Cell_Voltage_Vcell_21 >> can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_21_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Cell_Voltage_Vcell_22 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Cell_Voltage_Vcell_22 >> can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_22_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Cell_Voltage_Vcell_23 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Cell_Voltage_Vcell_23 >> can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_23_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Cell_Voltage_Vcell_24 & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Cell_Voltage_Vcell_24 >> can.BMS_CELL_VOLTAGE_6_CELL_VOLTAGE_VCELL_24_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_VOLTAGE_6_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_CELL_VOLTAGE_7( ConverterInitialize.BMS_CELL_VOLTAGE_7_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_25 = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_25_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_25_FACTOR)) + (can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_25_OFFSET));
        messages.Cell_Voltage_Vcell_26 = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_26_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_26_FACTOR)) + (can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_26_OFFSET));
        messages.Cell_Voltage_Vcell_27 = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_27_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_27_FACTOR)) + (can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_27_OFFSET));
        messages.Cell_Voltage_Vcell_28 = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_28_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_28_FACTOR)) + (can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_28_OFFSET));

        return can.BMS_CELL_VOLTAGE_7_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_CELL_VOLTAGE_7( ConverterInitialize.BMS_CELL_VOLTAGE_7_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Cell_Voltage_Vcell_25=(float) (messages.Cell_Voltage_Vcell_25 - can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_25_OFFSET);
        messages.Cell_Voltage_Vcell_26=(float) (messages.Cell_Voltage_Vcell_26 - can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_26_OFFSET);
        messages.Cell_Voltage_Vcell_27=(float) (messages.Cell_Voltage_Vcell_27 - can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_27_OFFSET);
        messages.Cell_Voltage_Vcell_28=(float) (messages.Cell_Voltage_Vcell_28 - can.BMS_CELL_VOLTAGE_7_CANID_CELL_VOLTAGE_VCELL_28_OFFSET);
        data[0] = (byte)(((byte)messages.Cell_Voltage_Vcell_25 & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Cell_Voltage_Vcell_25 >> can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_25_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Cell_Voltage_Vcell_26 & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Cell_Voltage_Vcell_26 >> can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_26_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Cell_Voltage_Vcell_27 & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Cell_Voltage_Vcell_27 >> can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_27_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Cell_Voltage_Vcell_28 & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Cell_Voltage_Vcell_28 >> can.BMS_CELL_VOLTAGE_7_CELL_VOLTAGE_VCELL_28_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_CELL_VOLTAGE_7_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Charger_status_Info( ConverterInitialize.Charger_status_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charger_Status_Signal = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_STATUS_INFO_CHARGER_STATUS_SIGNAL_FACTOR)) + (can.CHARGER_STATUS_INFO_CANID_CHARGER_STATUS_SIGNAL_OFFSET));
        messages.Charger_Mode = (float)(((((data[0] >> can.CHARGER_STATUS_INFO_CHARGER_MODE_MASK0) & (can.SIGNLE_READ_Mask4))) * (can.CHARGER_STATUS_INFO_CHARGER_MODE_FACTOR)) + (can.CHARGER_STATUS_INFO_CANID_CHARGER_MODE_OFFSET));

        return can.CHARGER_STATUS_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Charger_status_Info( ConverterInitialize.Charger_status_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Charger_Status_Signal=(float) (messages.Charger_Status_Signal - can.CHARGER_STATUS_INFO_CANID_CHARGER_STATUS_SIGNAL_OFFSET);
        messages.Charger_Mode=(float) (messages.Charger_Mode - can.CHARGER_STATUS_INFO_CANID_CHARGER_MODE_OFFSET);
        data[0] = (byte)(((byte)messages.Charger_Status_Signal & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Charger_Mode & ( can.SIGNLE_READ_Mask4)) << can.CHARGER_STATUS_INFO_CHARGER_MODE_MASK0));
        return can.CHARGER_STATUS_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Data3( ConverterInitialize.MCU_Data3_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.R_Phase_Current_MCU = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA3_R_PHASE_CURRENT_MCU_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.MCU_DATA3_R_PHASE_CURRENT_MCU_FACTOR)) + (can.MCU_DATA3_CANID_R_PHASE_CURRENT_MCU_OFFSET));
        messages.Y_Phase_Current_MCU = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA3_Y_PHASE_CURRENT_MCU_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.MCU_DATA3_Y_PHASE_CURRENT_MCU_FACTOR)) + (can.MCU_DATA3_CANID_Y_PHASE_CURRENT_MCU_OFFSET));
        messages.B_Phase_Current_MCU = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA3_B_PHASE_CURRENT_MCU_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.MCU_DATA3_B_PHASE_CURRENT_MCU_FACTOR)) + (can.MCU_DATA3_CANID_B_PHASE_CURRENT_MCU_OFFSET));
        messages.Regen_Min_Speed = (float)((((( data[7] & (can.SIGNLE_READ_Mask6)) << can.MCU_DATA3_REGEN_MIN_SPEED_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.MCU_DATA3_REGEN_MIN_SPEED_FACTOR)) + (can.MCU_DATA3_CANID_REGEN_MIN_SPEED_OFFSET));

        return can.MCU_DATA3_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Data3( ConverterInitialize.MCU_Data3_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.R_Phase_Current_MCU=(float) (messages.R_Phase_Current_MCU - can.MCU_DATA3_CANID_R_PHASE_CURRENT_MCU_OFFSET);
        messages.Y_Phase_Current_MCU=(float) (messages.Y_Phase_Current_MCU - can.MCU_DATA3_CANID_Y_PHASE_CURRENT_MCU_OFFSET);
        messages.B_Phase_Current_MCU=(float) (messages.B_Phase_Current_MCU - can.MCU_DATA3_CANID_B_PHASE_CURRENT_MCU_OFFSET);
        messages.Regen_Min_Speed=(float) (messages.Regen_Min_Speed - can.MCU_DATA3_CANID_REGEN_MIN_SPEED_OFFSET);
        data[0] = (byte)(((byte)messages.R_Phase_Current_MCU & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.R_Phase_Current_MCU >> can.MCU_DATA3_R_PHASE_CURRENT_MCU_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Y_Phase_Current_MCU & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Y_Phase_Current_MCU >> can.MCU_DATA3_Y_PHASE_CURRENT_MCU_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.B_Phase_Current_MCU & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.B_Phase_Current_MCU >> can.MCU_DATA3_B_PHASE_CURRENT_MCU_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Regen_Min_Speed & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Regen_Min_Speed >> can.MCU_DATA3_REGEN_MIN_SPEED_MASK0) & (can.SIGNLE_READ_Mask6)));
        return can.MCU_DATA3_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Data4( ConverterInitialize.MCU_Data4_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Motor_rpm = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA4_MOTOR_RPM_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.MCU_DATA4_MOTOR_RPM_FACTOR)) + (can.MCU_DATA4_CANID_MOTOR_RPM_OFFSET));
        messages.Regen_status = (float)((((data[2] & (can.SIGNLE_READ_Mask3))) * (can.MCU_DATA4_REGEN_STATUS_FACTOR)) + (can.MCU_DATA4_CANID_REGEN_STATUS_OFFSET));

        return can.MCU_DATA4_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Data4( ConverterInitialize.MCU_Data4_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Motor_rpm=(float) (messages.Motor_rpm - can.MCU_DATA4_CANID_MOTOR_RPM_OFFSET);
        messages.Regen_status=(float) (messages.Regen_status - can.MCU_DATA4_CANID_REGEN_STATUS_OFFSET);
        data[0] = (byte)(((byte)messages.Motor_rpm & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Motor_rpm >> can.MCU_DATA4_MOTOR_RPM_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Regen_status & ( can.SIGNLE_READ_Mask3)));
        return can.MCU_DATA4_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Data1( ConverterInitialize.MCU_Data1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_DC_Current = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA1_MCU_DC_CURRENT_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.MCU_DATA1_MCU_DC_CURRENT_FACTOR)) + (can.MCU_DATA1_CANID_MCU_DC_CURRENT_OFFSET));
        messages.MCU_Temperature = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA1_MCU_TEMPERATURE_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.MCU_DATA1_MCU_TEMPERATURE_FACTOR)) + (can.MCU_DATA1_CANID_MCU_TEMPERATURE_OFFSET));
        messages.Motor_temp = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA1_MOTOR_TEMP_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.MCU_DATA1_MOTOR_TEMP_FACTOR)) + (can.MCU_DATA1_CANID_MOTOR_TEMP_OFFSET));
        messages.Motor_Torque = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA1_MOTOR_TORQUE_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.MCU_DATA1_MOTOR_TORQUE_FACTOR)) + (can.MCU_DATA1_CANID_MOTOR_TORQUE_OFFSET));

        return can.MCU_DATA1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Data1( ConverterInitialize.MCU_Data1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_DC_Current=(float) (messages.MCU_DC_Current - can.MCU_DATA1_CANID_MCU_DC_CURRENT_OFFSET);
        messages.MCU_Temperature=(float) (messages.MCU_Temperature - can.MCU_DATA1_CANID_MCU_TEMPERATURE_OFFSET);
        messages.Motor_temp=(float) (messages.Motor_temp - can.MCU_DATA1_CANID_MOTOR_TEMP_OFFSET);
        messages.Motor_Torque=(float) (messages.Motor_Torque - can.MCU_DATA1_CANID_MOTOR_TORQUE_OFFSET);
        data[0] = (byte)(((byte)messages.MCU_DC_Current & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.MCU_DC_Current >> can.MCU_DATA1_MCU_DC_CURRENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.MCU_Temperature & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.MCU_Temperature >> can.MCU_DATA1_MCU_TEMPERATURE_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Motor_temp & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Motor_temp >> can.MCU_DATA1_MOTOR_TEMP_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Motor_Torque & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Motor_Torque >> can.MCU_DATA1_MOTOR_TORQUE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.MCU_DATA1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Disconnect_ACK( ConverterInitialize.MCU_Disconnect_ACK_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Disconnect_ACK = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.MCU_DISCONNECT_ACK_DISCONNECT_ACK_FACTOR)) + (can.MCU_DISCONNECT_ACK_CANID_DISCONNECT_ACK_OFFSET));

        return can.MCU_DISCONNECT_ACK_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Disconnect_ACK( ConverterInitialize.MCU_Disconnect_ACK_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Disconnect_ACK=(float) (messages.Disconnect_ACK - can.MCU_DISCONNECT_ACK_CANID_DISCONNECT_ACK_OFFSET);
        data[0] = (byte)(((byte)messages.Disconnect_ACK & ( can.SIGNLE_READ_Mask1)));
        return can.MCU_DISCONNECT_ACK_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Fault_Data( ConverterInitialize.MCU_Fault_Data_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.MotorOC_protect_U_ph = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MOTOROC_PROTECT_U_PH_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MOTOROC_PROTECT_U_PH_OFFSET));
        messages.MotorOC_protect_V_ph = (float)(((((data[0] >> can.MCU_FAULT_DATA_MOTOROC_PROTECT_V_PH_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MOTOROC_PROTECT_V_PH_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MOTOROC_PROTECT_V_PH_OFFSET));
        messages.MotorOC_protect_W_ph = (float)(((((data[0] >> can.MCU_FAULT_DATA_MOTOROC_PROTECT_W_PH_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MOTOROC_PROTECT_W_PH_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MOTOROC_PROTECT_W_PH_OFFSET));
        messages.Mcu_Flt_Wrong_Offset_Fault = (float)(((((data[0] >> can.MCU_FAULT_DATA_MCU_FLT_WRONG_OFFSET_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_WRONG_OFFSET_FAULT_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_WRONG_OFFSET_FAULT_OFFSET));
        messages.MCU_over_temperature_warning = (float)(((((data[0] >> can.MCU_FAULT_DATA_MCU_OVER_TEMPERATURE_WARNING_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_OVER_TEMPERATURE_WARNING_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_OVER_TEMPERATURE_WARNING_OFFSET));
        messages.Motor_over_temperature_warning = (float)(((((data[0] >> can.MCU_FAULT_DATA_MOTOR_OVER_TEMPERATURE_WARNING_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MOTOR_OVER_TEMPERATURE_WARNING_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MOTOR_OVER_TEMPERATURE_WARNING_OFFSET));
        messages.MCU_Unintended_Direction = (float)(((((data[0] >> can.MCU_FAULT_DATA_MCU_UNINTENDED_DIRECTION_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_UNINTENDED_DIRECTION_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_UNINTENDED_DIRECTION_OFFSET));
        messages.Encoder_Failure = (float)(((((data[0] >> can.MCU_FAULT_DATA_ENCODER_FAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_ENCODER_FAILURE_FACTOR)) + (can.MCU_FAULT_DATA_CANID_ENCODER_FAILURE_OFFSET));
        messages.DCbus_undervoltage = (float)((((data[1] & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_DCBUS_UNDERVOLTAGE_FACTOR)) + (can.MCU_FAULT_DATA_CANID_DCBUS_UNDERVOLTAGE_OFFSET));
        messages.DCbus_overvoltage = (float)(((((data[1] >> can.MCU_FAULT_DATA_DCBUS_OVERVOLTAGE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_DCBUS_OVERVOLTAGE_FACTOR)) + (can.MCU_FAULT_DATA_CANID_DCBUS_OVERVOLTAGE_OFFSET));
        messages.DCbus_overcurrent = (float)(((((data[1] >> can.MCU_FAULT_DATA_DCBUS_OVERCURRENT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_DCBUS_OVERCURRENT_FACTOR)) + (can.MCU_FAULT_DATA_CANID_DCBUS_OVERCURRENT_OFFSET));
        messages.MCU_Over_speed_fault = (float)(((((data[1] >> can.MCU_FAULT_DATA_MCU_OVER_SPEED_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_OVER_SPEED_FAULT_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_OVER_SPEED_FAULT_OFFSET));
        messages.Mcu_Flt_DCBus_Voltagesensor_STG = (float)(((((data[1] >> can.MCU_FAULT_DATA_MCU_FLT_DCBUS_VOLTAGESENSOR_STG_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_DCBUS_VOLTAGESENSOR_STG_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_DCBUS_VOLTAGESENSOR_STG_OFFSET));
        messages.Mcu_Flt_DCBus_VoltgeSensor_STB = (float)(((((data[1] >> can.MCU_FAULT_DATA_MCU_FLT_DCBUS_VOLTGESENSOR_STB_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_DCBUS_VOLTGESENSOR_STB_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_DCBUS_VOLTGESENSOR_STB_OFFSET));
        messages.MCU_Flt_KL30_Sensor_STG = (float)(((((data[1] >> can.MCU_FAULT_DATA_MCU_FLT_KL30_SENSOR_STG_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_KL30_SENSOR_STG_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_KL30_SENSOR_STG_OFFSET));
        messages.MCU_Flt_KL30_Sensor_STB = (float)(((((data[1] >> can.MCU_FAULT_DATA_MCU_FLT_KL30_SENSOR_STB_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_KL30_SENSOR_STB_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_KL30_SENSOR_STB_OFFSET));
        messages.Mcu_Flt_BoardTempSensorSTG = (float)((((data[2] & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_BOARDTEMPSENSORSTG_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_BOARDTEMPSENSORSTG_OFFSET));
        messages.Mcu_Flt_BoardTempSensorSTB = (float)(((((data[2] >> can.MCU_FAULT_DATA_MCU_FLT_BOARDTEMPSENSORSTB_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_BOARDTEMPSENSORSTB_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_BOARDTEMPSENSORSTB_OFFSET));
        messages.Mcu_Flt_RphaseSTG = (float)(((((data[2] >> can.MCU_FAULT_DATA_MCU_FLT_RPHASESTG_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_RPHASESTG_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_RPHASESTG_OFFSET));
        messages.Mcu_Flt_RphaseSTB = (float)(((((data[2] >> can.MCU_FAULT_DATA_MCU_FLT_RPHASESTB_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_RPHASESTB_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_RPHASESTB_OFFSET));
        messages.Loss_of_Tractioncontrol2msg = (float)(((((data[2] >> can.MCU_FAULT_DATA_LOSS_OF_TRACTIONCONTROL2MSG_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_LOSS_OF_TRACTIONCONTROL2MSG_FACTOR)) + (can.MCU_FAULT_DATA_CANID_LOSS_OF_TRACTIONCONTROL2MSG_OFFSET));
        messages.LV_supplyOvervoltage = (float)(((((data[2] >> can.MCU_FAULT_DATA_LV_SUPPLYOVERVOLTAGE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_LV_SUPPLYOVERVOLTAGE_FACTOR)) + (can.MCU_FAULT_DATA_CANID_LV_SUPPLYOVERVOLTAGE_OFFSET));
        messages.LV_supplyUndervoltage = (float)(((((data[2] >> can.MCU_FAULT_DATA_LV_SUPPLYUNDERVOLTAGE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_LV_SUPPLYUNDERVOLTAGE_FACTOR)) + (can.MCU_FAULT_DATA_CANID_LV_SUPPLYUNDERVOLTAGE_OFFSET));
        messages.Mcu_Flt_YphaseSTG = (float)(((((data[2] >> can.MCU_FAULT_DATA_MCU_FLT_YPHASESTG_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_YPHASESTG_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_YPHASESTG_OFFSET));
        messages.Mcu_Flt_YphaseSTB = (float)((((data[3] & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_YPHASESTB_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_YPHASESTB_OFFSET));
        messages.Mcu_Flt_BphaseSTG = (float)(((((data[3] >> can.MCU_FAULT_DATA_MCU_FLT_BPHASESTG_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_BPHASESTG_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_BPHASESTG_OFFSET));
        messages.Mcu_Flt_BphaseSTB = (float)(((((data[3] >> can.MCU_FAULT_DATA_MCU_FLT_BPHASESTB_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_BPHASESTB_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_BPHASESTB_OFFSET));
        messages.MCU_Flt_MachineTempSensorSTB = (float)(((((data[3] >> can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMPSENSORSTB_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMPSENSORSTB_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_MACHINETEMPSENSORSTB_OFFSET));
        messages.MCU_Flt_MachineTempSensorSTG = (float)(((((data[3] >> can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMPSENSORSTG_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMPSENSORSTG_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_MACHINETEMPSENSORSTG_OFFSET));
        messages.Mcu_Flt_DCCurrentSensorSTG = (float)(((((data[3] >> can.MCU_FAULT_DATA_MCU_FLT_DCCURRENTSENSORSTG_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_DCCURRENTSENSORSTG_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_DCCURRENTSENSORSTG_OFFSET));
        messages.Mcu_Flt_DCCurrentSensorSTB = (float)(((((data[3] >> can.MCU_FAULT_DATA_MCU_FLT_DCCURRENTSENSORSTB_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_DCCURRENTSENSORSTB_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_DCCURRENTSENSORSTB_OFFSET));
        messages.Mcu_Flt_BuckConvert5V_overvolt = (float)(((((data[3] >> can.MCU_FAULT_DATA_MCU_FLT_BUCKCONVERT5V_OVERVOLT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_BUCKCONVERT5V_OVERVOLT_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_BUCKCONVERT5V_OVERVOLT_OFFSET));
        messages.Mcu_Flt_BuckConvert5v_undervolt = (float)((((data[4] & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_BUCKCONVERT5V_UNDERVOLT_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_BUCKCONVERT5V_UNDERVOLT_OFFSET));
        messages.MCU_dio_over_volt_status = (float)(((((data[4] >> can.MCU_FAULT_DATA_MCU_DIO_OVER_VOLT_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_DIO_OVER_VOLT_STATUS_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_DIO_OVER_VOLT_STATUS_OFFSET));
        messages.MCU_dio_over_curr_status = (float)(((((data[4] >> can.MCU_FAULT_DATA_MCU_DIO_OVER_CURR_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_DIO_OVER_CURR_STATUS_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_DIO_OVER_CURR_STATUS_OFFSET));
        messages.MCU_dio_phase_ctrl_status = (float)(((((data[4] >> can.MCU_FAULT_DATA_MCU_DIO_PHASE_CTRL_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_DIO_PHASE_CTRL_STATUS_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_DIO_PHASE_CTRL_STATUS_OFFSET));
        messages.Mcu_Flt_MachineTemp_Low = (float)(((((data[4] >> can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMP_LOW_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMP_LOW_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_MACHINETEMP_LOW_OFFSET));
        messages.Mcu_Flt_BoardTemp_Low = (float)(((((data[4] >> can.MCU_FAULT_DATA_MCU_FLT_BOARDTEMP_LOW_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_BOARDTEMP_LOW_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_BOARDTEMP_LOW_OFFSET));
        messages.Mcu_Flt_Rotor_Stall = (float)(((((data[4] >> can.MCU_FAULT_DATA_MCU_FLT_ROTOR_STALL_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_ROTOR_STALL_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_ROTOR_STALL_OFFSET));
        messages.Mcu_Flt_MOSFET_HighTemp = (float)(((((data[4] >> can.MCU_FAULT_DATA_MCU_FLT_MOSFET_HIGHTEMP_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_MOSFET_HIGHTEMP_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_MOSFET_HIGHTEMP_OFFSET));
        messages.MCU_Flt_MOSFET_STG = (float)((((data[5] & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_MOSFET_STG_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_MOSFET_STG_OFFSET));
        messages.MCU_Flt_MOSFET_STB = (float)(((((data[5] >> can.MCU_FAULT_DATA_MCU_FLT_MOSFET_STB_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_MCU_FLT_MOSFET_STB_FACTOR)) + (can.MCU_FAULT_DATA_CANID_MCU_FLT_MOSFET_STB_OFFSET));
        messages.Throttle_ideal_percentage_error = (float)(((((data[5] >> can.MCU_FAULT_DATA_THROTTLE_IDEAL_PERCENTAGE_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.MCU_FAULT_DATA_THROTTLE_IDEAL_PERCENTAGE_ERROR_FACTOR)) + (can.MCU_FAULT_DATA_CANID_THROTTLE_IDEAL_PERCENTAGE_ERROR_OFFSET));

        return can.MCU_FAULT_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Fault_Data( ConverterInitialize.MCU_Fault_Data_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.MotorOC_protect_U_ph=(float) (messages.MotorOC_protect_U_ph - can.MCU_FAULT_DATA_CANID_MOTOROC_PROTECT_U_PH_OFFSET);
        messages.MotorOC_protect_V_ph=(float) (messages.MotorOC_protect_V_ph - can.MCU_FAULT_DATA_CANID_MOTOROC_PROTECT_V_PH_OFFSET);
        messages.MotorOC_protect_W_ph=(float) (messages.MotorOC_protect_W_ph - can.MCU_FAULT_DATA_CANID_MOTOROC_PROTECT_W_PH_OFFSET);
        messages.Mcu_Flt_Wrong_Offset_Fault=(float) (messages.Mcu_Flt_Wrong_Offset_Fault - can.MCU_FAULT_DATA_CANID_MCU_FLT_WRONG_OFFSET_FAULT_OFFSET);
        messages.MCU_over_temperature_warning=(float) (messages.MCU_over_temperature_warning - can.MCU_FAULT_DATA_CANID_MCU_OVER_TEMPERATURE_WARNING_OFFSET);
        messages.Motor_over_temperature_warning=(float) (messages.Motor_over_temperature_warning - can.MCU_FAULT_DATA_CANID_MOTOR_OVER_TEMPERATURE_WARNING_OFFSET);
        messages.MCU_Unintended_Direction=(float) (messages.MCU_Unintended_Direction - can.MCU_FAULT_DATA_CANID_MCU_UNINTENDED_DIRECTION_OFFSET);
        messages.Encoder_Failure=(float) (messages.Encoder_Failure - can.MCU_FAULT_DATA_CANID_ENCODER_FAILURE_OFFSET);
        messages.DCbus_undervoltage=(float) (messages.DCbus_undervoltage - can.MCU_FAULT_DATA_CANID_DCBUS_UNDERVOLTAGE_OFFSET);
        messages.DCbus_overvoltage=(float) (messages.DCbus_overvoltage - can.MCU_FAULT_DATA_CANID_DCBUS_OVERVOLTAGE_OFFSET);
        messages.DCbus_overcurrent=(float) (messages.DCbus_overcurrent - can.MCU_FAULT_DATA_CANID_DCBUS_OVERCURRENT_OFFSET);
        messages.MCU_Over_speed_fault=(float) (messages.MCU_Over_speed_fault - can.MCU_FAULT_DATA_CANID_MCU_OVER_SPEED_FAULT_OFFSET);
        messages.Mcu_Flt_DCBus_Voltagesensor_STG=(float) (messages.Mcu_Flt_DCBus_Voltagesensor_STG - can.MCU_FAULT_DATA_CANID_MCU_FLT_DCBUS_VOLTAGESENSOR_STG_OFFSET);
        messages.Mcu_Flt_DCBus_VoltgeSensor_STB=(float) (messages.Mcu_Flt_DCBus_VoltgeSensor_STB - can.MCU_FAULT_DATA_CANID_MCU_FLT_DCBUS_VOLTGESENSOR_STB_OFFSET);
        messages.MCU_Flt_KL30_Sensor_STG=(float) (messages.MCU_Flt_KL30_Sensor_STG - can.MCU_FAULT_DATA_CANID_MCU_FLT_KL30_SENSOR_STG_OFFSET);
        messages.MCU_Flt_KL30_Sensor_STB=(float) (messages.MCU_Flt_KL30_Sensor_STB - can.MCU_FAULT_DATA_CANID_MCU_FLT_KL30_SENSOR_STB_OFFSET);
        messages.Mcu_Flt_BoardTempSensorSTG=(float) (messages.Mcu_Flt_BoardTempSensorSTG - can.MCU_FAULT_DATA_CANID_MCU_FLT_BOARDTEMPSENSORSTG_OFFSET);
        messages.Mcu_Flt_BoardTempSensorSTB=(float) (messages.Mcu_Flt_BoardTempSensorSTB - can.MCU_FAULT_DATA_CANID_MCU_FLT_BOARDTEMPSENSORSTB_OFFSET);
        messages.Mcu_Flt_RphaseSTG=(float) (messages.Mcu_Flt_RphaseSTG - can.MCU_FAULT_DATA_CANID_MCU_FLT_RPHASESTG_OFFSET);
        messages.Mcu_Flt_RphaseSTB=(float) (messages.Mcu_Flt_RphaseSTB - can.MCU_FAULT_DATA_CANID_MCU_FLT_RPHASESTB_OFFSET);
        messages.Loss_of_Tractioncontrol2msg=(float) (messages.Loss_of_Tractioncontrol2msg - can.MCU_FAULT_DATA_CANID_LOSS_OF_TRACTIONCONTROL2MSG_OFFSET);
        messages.LV_supplyOvervoltage=(float) (messages.LV_supplyOvervoltage - can.MCU_FAULT_DATA_CANID_LV_SUPPLYOVERVOLTAGE_OFFSET);
        messages.LV_supplyUndervoltage=(float) (messages.LV_supplyUndervoltage - can.MCU_FAULT_DATA_CANID_LV_SUPPLYUNDERVOLTAGE_OFFSET);
        messages.Mcu_Flt_YphaseSTG=(float) (messages.Mcu_Flt_YphaseSTG - can.MCU_FAULT_DATA_CANID_MCU_FLT_YPHASESTG_OFFSET);
        messages.Mcu_Flt_YphaseSTB=(float) (messages.Mcu_Flt_YphaseSTB - can.MCU_FAULT_DATA_CANID_MCU_FLT_YPHASESTB_OFFSET);
        messages.Mcu_Flt_BphaseSTG=(float) (messages.Mcu_Flt_BphaseSTG - can.MCU_FAULT_DATA_CANID_MCU_FLT_BPHASESTG_OFFSET);
        messages.Mcu_Flt_BphaseSTB=(float) (messages.Mcu_Flt_BphaseSTB - can.MCU_FAULT_DATA_CANID_MCU_FLT_BPHASESTB_OFFSET);
        messages.MCU_Flt_MachineTempSensorSTB=(float) (messages.MCU_Flt_MachineTempSensorSTB - can.MCU_FAULT_DATA_CANID_MCU_FLT_MACHINETEMPSENSORSTB_OFFSET);
        messages.MCU_Flt_MachineTempSensorSTG=(float) (messages.MCU_Flt_MachineTempSensorSTG - can.MCU_FAULT_DATA_CANID_MCU_FLT_MACHINETEMPSENSORSTG_OFFSET);
        messages.Mcu_Flt_DCCurrentSensorSTG=(float) (messages.Mcu_Flt_DCCurrentSensorSTG - can.MCU_FAULT_DATA_CANID_MCU_FLT_DCCURRENTSENSORSTG_OFFSET);
        messages.Mcu_Flt_DCCurrentSensorSTB=(float) (messages.Mcu_Flt_DCCurrentSensorSTB - can.MCU_FAULT_DATA_CANID_MCU_FLT_DCCURRENTSENSORSTB_OFFSET);
        messages.Mcu_Flt_BuckConvert5V_overvolt=(float) (messages.Mcu_Flt_BuckConvert5V_overvolt - can.MCU_FAULT_DATA_CANID_MCU_FLT_BUCKCONVERT5V_OVERVOLT_OFFSET);
        messages.Mcu_Flt_BuckConvert5v_undervolt=(float) (messages.Mcu_Flt_BuckConvert5v_undervolt - can.MCU_FAULT_DATA_CANID_MCU_FLT_BUCKCONVERT5V_UNDERVOLT_OFFSET);
        messages.MCU_dio_over_volt_status=(float) (messages.MCU_dio_over_volt_status - can.MCU_FAULT_DATA_CANID_MCU_DIO_OVER_VOLT_STATUS_OFFSET);
        messages.MCU_dio_over_curr_status=(float) (messages.MCU_dio_over_curr_status - can.MCU_FAULT_DATA_CANID_MCU_DIO_OVER_CURR_STATUS_OFFSET);
        messages.MCU_dio_phase_ctrl_status=(float) (messages.MCU_dio_phase_ctrl_status - can.MCU_FAULT_DATA_CANID_MCU_DIO_PHASE_CTRL_STATUS_OFFSET);
        messages.Mcu_Flt_MachineTemp_Low=(float) (messages.Mcu_Flt_MachineTemp_Low - can.MCU_FAULT_DATA_CANID_MCU_FLT_MACHINETEMP_LOW_OFFSET);
        messages.Mcu_Flt_BoardTemp_Low=(float) (messages.Mcu_Flt_BoardTemp_Low - can.MCU_FAULT_DATA_CANID_MCU_FLT_BOARDTEMP_LOW_OFFSET);
        messages.Mcu_Flt_Rotor_Stall=(float) (messages.Mcu_Flt_Rotor_Stall - can.MCU_FAULT_DATA_CANID_MCU_FLT_ROTOR_STALL_OFFSET);
        messages.Mcu_Flt_MOSFET_HighTemp=(float) (messages.Mcu_Flt_MOSFET_HighTemp - can.MCU_FAULT_DATA_CANID_MCU_FLT_MOSFET_HIGHTEMP_OFFSET);
        messages.MCU_Flt_MOSFET_STG=(float) (messages.MCU_Flt_MOSFET_STG - can.MCU_FAULT_DATA_CANID_MCU_FLT_MOSFET_STG_OFFSET);
        messages.MCU_Flt_MOSFET_STB=(float) (messages.MCU_Flt_MOSFET_STB - can.MCU_FAULT_DATA_CANID_MCU_FLT_MOSFET_STB_OFFSET);
        messages.Throttle_ideal_percentage_error=(float) (messages.Throttle_ideal_percentage_error - can.MCU_FAULT_DATA_CANID_THROTTLE_IDEAL_PERCENTAGE_ERROR_OFFSET);
        data[0] = (byte)(((byte)messages.MotorOC_protect_U_ph & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.MotorOC_protect_V_ph & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MOTOROC_PROTECT_V_PH_MASK0) | (((byte)messages.MotorOC_protect_W_ph & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MOTOROC_PROTECT_W_PH_MASK0) | (((byte)messages.Mcu_Flt_Wrong_Offset_Fault & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_WRONG_OFFSET_FAULT_MASK0) | (((byte)messages.MCU_over_temperature_warning & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_OVER_TEMPERATURE_WARNING_MASK0) | (((byte)messages.Motor_over_temperature_warning & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MOTOR_OVER_TEMPERATURE_WARNING_MASK0) | (((byte)messages.MCU_Unintended_Direction & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_UNINTENDED_DIRECTION_MASK0) | (((byte)messages.Encoder_Failure & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_ENCODER_FAILURE_MASK0));
        data[1] = (byte)(((byte)messages.DCbus_undervoltage & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.DCbus_overvoltage & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_DCBUS_OVERVOLTAGE_MASK0) | (((byte)messages.DCbus_overcurrent & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_DCBUS_OVERCURRENT_MASK0) | (((byte)messages.MCU_Over_speed_fault & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_OVER_SPEED_FAULT_MASK0) | (((byte)messages.Mcu_Flt_DCBus_Voltagesensor_STG & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_DCBUS_VOLTAGESENSOR_STG_MASK0) | (((byte)messages.Mcu_Flt_DCBus_VoltgeSensor_STB & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_DCBUS_VOLTGESENSOR_STB_MASK0) | (((byte)messages.MCU_Flt_KL30_Sensor_STG & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_KL30_SENSOR_STG_MASK0) | (((byte)messages.MCU_Flt_KL30_Sensor_STB & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_KL30_SENSOR_STB_MASK0));
        data[2] = (byte)(((byte)messages.Mcu_Flt_BoardTempSensorSTG & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Mcu_Flt_BoardTempSensorSTB & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_BOARDTEMPSENSORSTB_MASK0) | (((byte)messages.Mcu_Flt_RphaseSTG & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_RPHASESTG_MASK0) | (((byte)messages.Mcu_Flt_RphaseSTB & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_RPHASESTB_MASK0) | (((byte)messages.Loss_of_Tractioncontrol2msg & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_LOSS_OF_TRACTIONCONTROL2MSG_MASK0) | (((byte)messages.LV_supplyOvervoltage & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_LV_SUPPLYOVERVOLTAGE_MASK0) | (((byte)messages.LV_supplyUndervoltage & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_LV_SUPPLYUNDERVOLTAGE_MASK0) | (((byte)messages.Mcu_Flt_YphaseSTG & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_YPHASESTG_MASK0));
        data[3] = (byte)(((byte)messages.Mcu_Flt_YphaseSTB & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Mcu_Flt_BphaseSTG & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_BPHASESTG_MASK0) | (((byte)messages.Mcu_Flt_BphaseSTB & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_BPHASESTB_MASK0) | (((byte)messages.MCU_Flt_MachineTempSensorSTB & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMPSENSORSTB_MASK0) | (((byte)messages.MCU_Flt_MachineTempSensorSTG & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMPSENSORSTG_MASK0) | (((byte)messages.Mcu_Flt_DCCurrentSensorSTG & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_DCCURRENTSENSORSTG_MASK0) | (((byte)messages.Mcu_Flt_DCCurrentSensorSTB & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_DCCURRENTSENSORSTB_MASK0) | (((byte)messages.Mcu_Flt_BuckConvert5V_overvolt & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_BUCKCONVERT5V_OVERVOLT_MASK0));
        data[4] = (byte)(((byte)messages.Mcu_Flt_BuckConvert5v_undervolt & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.MCU_dio_over_volt_status & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_DIO_OVER_VOLT_STATUS_MASK0) | (((byte)messages.MCU_dio_over_curr_status & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_DIO_OVER_CURR_STATUS_MASK0) | (((byte)messages.MCU_dio_phase_ctrl_status & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_DIO_PHASE_CTRL_STATUS_MASK0) | (((byte)messages.Mcu_Flt_MachineTemp_Low & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_MACHINETEMP_LOW_MASK0) | (((byte)messages.Mcu_Flt_BoardTemp_Low & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_BOARDTEMP_LOW_MASK0) | (((byte)messages.Mcu_Flt_Rotor_Stall & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_ROTOR_STALL_MASK0) | (((byte)messages.Mcu_Flt_MOSFET_HighTemp & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_MOSFET_HIGHTEMP_MASK0));
        data[5] = (byte)(((byte)messages.MCU_Flt_MOSFET_STG & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.MCU_Flt_MOSFET_STB & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_MCU_FLT_MOSFET_STB_MASK0) | (((byte)messages.Throttle_ideal_percentage_error & ( can.SIGNLE_READ_Mask1)) << can.MCU_FAULT_DATA_THROTTLE_IDEAL_PERCENTAGE_ERROR_MASK0));
        return can.MCU_FAULT_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Display_info( ConverterInitialize.Display_info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Side_Stand_Status = (float)((((data[0] & (can.SIGNLE_READ_Mask3))) * (can.DISPLAY_INFO_SIDE_STAND_STATUS_FACTOR)) + (can.DISPLAY_INFO_CANID_SIDE_STAND_STATUS_OFFSET));
        messages.Display_SoC = (float)((((( data[1] & (can.SIGNLE_READ_Mask3)) << can.DISPLAY_INFO_DISPLAY_SOC_MASK0) | (( data[0] >> can.DISPLAY_INFO_DISPLAY_SOC_MASK1) & (can.SIGNLE_READ_Mask5))) * (can.DISPLAY_INFO_DISPLAY_SOC_FACTOR)) + (can.DISPLAY_INFO_CANID_DISPLAY_SOC_OFFSET));
        messages.Vehicle_Range = (float)((((( data[2] & (can.SIGNLE_READ_Mask3)) << can.DISPLAY_INFO_VEHICLE_RANGE_MASK0) | (( data[1] >> can.DISPLAY_INFO_VEHICLE_RANGE_MASK1) & (can.SIGNLE_READ_Mask5))) * (can.DISPLAY_INFO_VEHICLE_RANGE_FACTOR)) + (can.DISPLAY_INFO_CANID_VEHICLE_RANGE_OFFSET));
        messages.Indicators_TTL = (float)(((((data[2] >> can.DISPLAY_INFO_INDICATORS_TTL_MASK0) & (can.SIGNLE_READ_Mask4))) * (can.DISPLAY_INFO_INDICATORS_TTL_FACTOR)) + (can.DISPLAY_INFO_CANID_INDICATORS_TTL_OFFSET));
        messages.FrontLight_TTL = (float)((((( data[3] & (can.SIGNLE_READ_Mask3)) << can.DISPLAY_INFO_FRONTLIGHT_TTL_MASK0) | (( data[2] >> can.DISPLAY_INFO_FRONTLIGHT_TTL_MASK1) & (can.SIGNLE_READ_Mask1))) * (can.DISPLAY_INFO_FRONTLIGHT_TTL_FACTOR)) + (can.DISPLAY_INFO_CANID_FRONTLIGHT_TTL_OFFSET));
        messages.Charge_TTL = (float)(((((data[3] >> can.DISPLAY_INFO_CHARGE_TTL_MASK0) & (can.SIGNLE_READ_Mask3))) * (can.DISPLAY_INFO_CHARGE_TTL_FACTOR)) + (can.DISPLAY_INFO_CANID_CHARGE_TTL_OFFSET));
        messages.DRL_Lamp_TTL = (float)(((((data[3] >> can.DISPLAY_INFO_DRL_LAMP_TTL_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.DISPLAY_INFO_DRL_LAMP_TTL_FACTOR)) + (can.DISPLAY_INFO_CANID_DRL_LAMP_TTL_OFFSET));
        messages.Low_Battery_Alert_TTL = (float)(((((data[3] >> can.DISPLAY_INFO_LOW_BATTERY_ALERT_TTL_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.DISPLAY_INFO_LOW_BATTERY_ALERT_TTL_FACTOR)) + (can.DISPLAY_INFO_CANID_LOW_BATTERY_ALERT_TTL_OFFSET));
        messages.Display_Vehicle_Speed = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.DISPLAY_INFO_DISPLAY_VEHICLE_SPEED_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.DISPLAY_INFO_DISPLAY_VEHICLE_SPEED_FACTOR)) + (can.DISPLAY_INFO_CANID_DISPLAY_VEHICLE_SPEED_OFFSET));
        messages.Fog_Lamp_TTL = (float)((((data[6] & (can.SIGNLE_READ_Mask1))) * (can.DISPLAY_INFO_FOG_LAMP_TTL_FACTOR)) + (can.DISPLAY_INFO_CANID_FOG_LAMP_TTL_OFFSET));

        return can.DISPLAY_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Display_info( ConverterInitialize.Display_info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Side_Stand_Status=(float) (messages.Side_Stand_Status - can.DISPLAY_INFO_CANID_SIDE_STAND_STATUS_OFFSET);
        messages.Display_SoC=(float) (messages.Display_SoC - can.DISPLAY_INFO_CANID_DISPLAY_SOC_OFFSET);
        messages.Vehicle_Range=(float) (messages.Vehicle_Range - can.DISPLAY_INFO_CANID_VEHICLE_RANGE_OFFSET);
        messages.Indicators_TTL=(float) (messages.Indicators_TTL - can.DISPLAY_INFO_CANID_INDICATORS_TTL_OFFSET);
        messages.FrontLight_TTL=(float) (messages.FrontLight_TTL - can.DISPLAY_INFO_CANID_FRONTLIGHT_TTL_OFFSET);
        messages.Charge_TTL=(float) (messages.Charge_TTL - can.DISPLAY_INFO_CANID_CHARGE_TTL_OFFSET);
        messages.DRL_Lamp_TTL=(float) (messages.DRL_Lamp_TTL - can.DISPLAY_INFO_CANID_DRL_LAMP_TTL_OFFSET);
        messages.Low_Battery_Alert_TTL=(float) (messages.Low_Battery_Alert_TTL - can.DISPLAY_INFO_CANID_LOW_BATTERY_ALERT_TTL_OFFSET);
        messages.Display_Vehicle_Speed=(float) (messages.Display_Vehicle_Speed - can.DISPLAY_INFO_CANID_DISPLAY_VEHICLE_SPEED_OFFSET);
        messages.Fog_Lamp_TTL=(float) (messages.Fog_Lamp_TTL - can.DISPLAY_INFO_CANID_FOG_LAMP_TTL_OFFSET);
        data[0] = (byte)(((byte)messages.Side_Stand_Status & ( can.SIGNLE_READ_Mask3)) | (((byte)messages.Display_SoC & (can.SIGNLE_READ_Mask5)) << can.DISPLAY_INFO_DISPLAY_SOC_MASK1));
        data[1] = (byte)((((byte)messages.Display_SoC >> can.DISPLAY_INFO_DISPLAY_SOC_MASK0) & (can.SIGNLE_READ_Mask3)) | (((byte)messages.Vehicle_Range & (can.SIGNLE_READ_Mask5)) << can.DISPLAY_INFO_VEHICLE_RANGE_MASK1));
        data[2] = (byte)((((byte)messages.Vehicle_Range >> can.DISPLAY_INFO_VEHICLE_RANGE_MASK0) & (can.SIGNLE_READ_Mask3)) | (((byte)messages.Indicators_TTL & ( can.SIGNLE_READ_Mask4)) << can.DISPLAY_INFO_INDICATORS_TTL_MASK0) | (((byte)messages.FrontLight_TTL & (can.SIGNLE_READ_Mask1)) << can.DISPLAY_INFO_FRONTLIGHT_TTL_MASK1));
        data[3] = (byte)((((byte)messages.FrontLight_TTL >> can.DISPLAY_INFO_FRONTLIGHT_TTL_MASK0) & (can.SIGNLE_READ_Mask3)) | (((byte)messages.Charge_TTL & ( can.SIGNLE_READ_Mask3)) << can.DISPLAY_INFO_CHARGE_TTL_MASK0) | (((byte)messages.DRL_Lamp_TTL & ( can.SIGNLE_READ_Mask1)) << can.DISPLAY_INFO_DRL_LAMP_TTL_MASK0) | (((byte)messages.Low_Battery_Alert_TTL & ( can.SIGNLE_READ_Mask1)) << can.DISPLAY_INFO_LOW_BATTERY_ALERT_TTL_MASK0));
        data[4] = (byte)(((byte)messages.Display_Vehicle_Speed & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Display_Vehicle_Speed >> can.DISPLAY_INFO_DISPLAY_VEHICLE_SPEED_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Fog_Lamp_TTL & ( can.SIGNLE_READ_Mask1)));
        return can.DISPLAY_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Environment_Data( ConverterInitialize.Environment_Data_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Ambient_Light_Sensor_Value = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.ENVIRONMENT_DATA_AMBIENT_LIGHT_SENSOR_VALUE_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.ENVIRONMENT_DATA_AMBIENT_LIGHT_SENSOR_VALUE_FACTOR)) + (can.ENVIRONMENT_DATA_CANID_AMBIENT_LIGHT_SENSOR_VALUE_OFFSET));
        messages.Ambient_Temp_Sensor_Value = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.ENVIRONMENT_DATA_AMBIENT_TEMP_SENSOR_VALUE_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.ENVIRONMENT_DATA_AMBIENT_TEMP_SENSOR_VALUE_FACTOR)) + (can.ENVIRONMENT_DATA_CANID_AMBIENT_TEMP_SENSOR_VALUE_OFFSET));

        return can.ENVIRONMENT_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Environment_Data( ConverterInitialize.Environment_Data_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Ambient_Light_Sensor_Value=(float) (messages.Ambient_Light_Sensor_Value - can.ENVIRONMENT_DATA_CANID_AMBIENT_LIGHT_SENSOR_VALUE_OFFSET);
        messages.Ambient_Temp_Sensor_Value=(float) (messages.Ambient_Temp_Sensor_Value - can.ENVIRONMENT_DATA_CANID_AMBIENT_TEMP_SENSOR_VALUE_OFFSET);
        data[0] = (byte)(((byte)messages.Ambient_Light_Sensor_Value & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Ambient_Light_Sensor_Value >> can.ENVIRONMENT_DATA_AMBIENT_LIGHT_SENSOR_VALUE_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Ambient_Temp_Sensor_Value & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Ambient_Temp_Sensor_Value >> can.ENVIRONMENT_DATA_AMBIENT_TEMP_SENSOR_VALUE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ENVIRONMENT_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_Fault_1( ConverterInitialize.BMS_Fault_1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_V_Sensor_Failure_Cell1 = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL1_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL1_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell2 = (float)(((((data[0] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL2_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL2_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL2_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell3 = (float)(((((data[0] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL3_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL3_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL3_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell4 = (float)(((((data[0] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL4_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL4_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL4_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell5 = (float)(((((data[0] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL5_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL5_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL5_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell6 = (float)(((((data[0] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL6_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL6_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL6_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell7 = (float)(((((data[0] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL7_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL7_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL7_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell8 = (float)(((((data[0] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL8_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL8_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL8_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell9 = (float)((((data[1] & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL9_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL9_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell10 = (float)(((((data[1] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL10_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL10_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL10_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell11 = (float)(((((data[1] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL11_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL11_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL11_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell12 = (float)(((((data[1] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL12_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL12_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL12_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell13 = (float)(((((data[1] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL13_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL13_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL13_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell14 = (float)(((((data[1] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL14_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL14_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL14_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell15 = (float)(((((data[1] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL15_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL15_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL15_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell16 = (float)(((((data[1] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL16_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL16_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL16_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell17 = (float)((((data[2] & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL17_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL17_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell18 = (float)(((((data[2] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL18_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL18_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL18_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell19 = (float)(((((data[2] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL19_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL19_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL19_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell20 = (float)(((((data[2] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL20_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL20_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL20_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell21 = (float)(((((data[2] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL21_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL21_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL21_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell22 = (float)(((((data[2] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL22_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL22_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL22_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell23 = (float)(((((data[2] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL23_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL23_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL23_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell24 = (float)(((((data[2] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL24_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL24_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL24_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell25 = (float)((((data[3] & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL25_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL25_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell26 = (float)(((((data[3] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL26_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL26_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL26_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell27 = (float)(((((data[3] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL27_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL27_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL27_OFFSET));
        messages.BMS_V_Sensor_Failure_Cell28 = (float)(((((data[3] >> can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL28_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL28_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL28_OFFSET));
        messages.BMS_V_Out_of_Range_Cell1 = (float)(((((data[3] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL1_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL1_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL1_OFFSET));
        messages.BMS_V_Out_of_Range_Cell2 = (float)(((((data[3] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL2_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL2_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL2_OFFSET));
        messages.BMS_V_Out_of_Range_Cell3 = (float)(((((data[3] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL3_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL3_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL3_OFFSET));
        messages.BMS_V_Out_of_Range_Cell4 = (float)(((((data[3] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL4_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL4_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL4_OFFSET));
        messages.BMS_V_Out_of_Range_Cell5 = (float)((((data[4] & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL5_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL5_OFFSET));
        messages.BMS_V_Out_of_Range_Cell6 = (float)(((((data[4] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL6_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL6_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL6_OFFSET));
        messages.BMS_V_Out_of_Range_Cell7 = (float)(((((data[4] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL7_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL7_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL7_OFFSET));
        messages.BMS_V_Out_of_Range_Cell8 = (float)(((((data[4] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL8_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL8_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL8_OFFSET));
        messages.BMS_V_Out_of_Range_Cell9 = (float)(((((data[4] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL9_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL9_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL9_OFFSET));
        messages.BMS_V_Out_of_Range_Cell10 = (float)(((((data[4] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL10_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL10_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL10_OFFSET));
        messages.BMS_V_Out_of_Range_Cell11 = (float)(((((data[4] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL11_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL11_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL11_OFFSET));
        messages.BMS_V_Out_of_Range_Cell12 = (float)(((((data[4] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL12_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL12_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL12_OFFSET));
        messages.BMS_V_Out_of_Range_Cell13 = (float)((((data[5] & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL13_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL13_OFFSET));
        messages.BMS_V_Out_of_Range_Cell14 = (float)(((((data[5] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL14_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL14_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL14_OFFSET));
        messages.BMS_V_Out_of_Range_Cell15 = (float)(((((data[5] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL15_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL15_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL15_OFFSET));
        messages.BMS_V_Out_of_Range_Cell16 = (float)(((((data[5] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL16_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL16_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL16_OFFSET));
        messages.BMS_V_Out_of_Range_Cell17 = (float)(((((data[5] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL17_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL17_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL17_OFFSET));
        messages.BMS_V_Out_of_Range_Cell18 = (float)(((((data[5] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL18_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL18_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL18_OFFSET));
        messages.BMS_V_Out_of_Range_Cell19 = (float)(((((data[5] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL19_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL19_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL19_OFFSET));
        messages.BMS_V_Out_of_Range_Cell20 = (float)(((((data[5] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL20_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL20_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL20_OFFSET));
        messages.BMS_V_Out_of_Range_Cell21 = (float)((((data[6] & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL21_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL21_OFFSET));
        messages.BMS_V_Out_of_Range_Cell22 = (float)(((((data[6] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL22_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL22_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL22_OFFSET));
        messages.BMS_V_Out_of_Range_Cell23 = (float)(((((data[6] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL23_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL23_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL23_OFFSET));
        messages.BMS_V_Out_of_Range_Cell24 = (float)(((((data[6] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL24_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL24_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL24_OFFSET));
        messages.BMS_V_Out_of_Range_Cell25 = (float)(((((data[6] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL25_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL25_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL25_OFFSET));
        messages.BMS_V_Out_of_Range_Cell26 = (float)(((((data[6] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL26_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL26_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL26_OFFSET));
        messages.BMS_V_Out_of_Range_Cell27 = (float)(((((data[6] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL27_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL27_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL27_OFFSET));
        messages.BMS_V_Out_of_Range_Cell28 = (float)(((((data[6] >> can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL28_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL28_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL28_OFFSET));
        messages.BMS_BatteryPackTemp_1_SensFail = (float)((((data[7] & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_1_SENSFAIL_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_1_SENSFAIL_OFFSET));
        messages.BMS_BatteryPackTemp_2_SensFail = (float)(((((data[7] >> can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_2_SENSFAIL_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_2_SENSFAIL_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_2_SENSFAIL_OFFSET));
        messages.BMS_BatteryPackTemp_3_SensFail = (float)(((((data[7] >> can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_3_SENSFAIL_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_3_SENSFAIL_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_3_SENSFAIL_OFFSET));
        messages.BMS_BatteryPackTemp_4_SensFail = (float)(((((data[7] >> can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_4_SENSFAIL_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_4_SENSFAIL_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_4_SENSFAIL_OFFSET));
        messages.BMS_BatteryPackTemp_5_SensFail = (float)(((((data[7] >> can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_5_SENSFAIL_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_5_SENSFAIL_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_5_SENSFAIL_OFFSET));
        messages.BMS_BatteryPackTemp_6_SensFail = (float)(((((data[7] >> can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_6_SENSFAIL_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_6_SENSFAIL_FACTOR)) + (can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_6_SENSFAIL_OFFSET));

        return can.BMS_FAULT_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_Fault_1( ConverterInitialize.BMS_Fault_1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_V_Sensor_Failure_Cell1=(float) (messages.BMS_V_Sensor_Failure_Cell1 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL1_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell2=(float) (messages.BMS_V_Sensor_Failure_Cell2 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL2_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell3=(float) (messages.BMS_V_Sensor_Failure_Cell3 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL3_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell4=(float) (messages.BMS_V_Sensor_Failure_Cell4 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL4_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell5=(float) (messages.BMS_V_Sensor_Failure_Cell5 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL5_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell6=(float) (messages.BMS_V_Sensor_Failure_Cell6 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL6_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell7=(float) (messages.BMS_V_Sensor_Failure_Cell7 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL7_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell8=(float) (messages.BMS_V_Sensor_Failure_Cell8 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL8_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell9=(float) (messages.BMS_V_Sensor_Failure_Cell9 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL9_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell10=(float) (messages.BMS_V_Sensor_Failure_Cell10 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL10_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell11=(float) (messages.BMS_V_Sensor_Failure_Cell11 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL11_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell12=(float) (messages.BMS_V_Sensor_Failure_Cell12 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL12_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell13=(float) (messages.BMS_V_Sensor_Failure_Cell13 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL13_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell14=(float) (messages.BMS_V_Sensor_Failure_Cell14 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL14_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell15=(float) (messages.BMS_V_Sensor_Failure_Cell15 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL15_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell16=(float) (messages.BMS_V_Sensor_Failure_Cell16 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL16_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell17=(float) (messages.BMS_V_Sensor_Failure_Cell17 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL17_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell18=(float) (messages.BMS_V_Sensor_Failure_Cell18 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL18_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell19=(float) (messages.BMS_V_Sensor_Failure_Cell19 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL19_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell20=(float) (messages.BMS_V_Sensor_Failure_Cell20 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL20_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell21=(float) (messages.BMS_V_Sensor_Failure_Cell21 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL21_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell22=(float) (messages.BMS_V_Sensor_Failure_Cell22 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL22_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell23=(float) (messages.BMS_V_Sensor_Failure_Cell23 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL23_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell24=(float) (messages.BMS_V_Sensor_Failure_Cell24 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL24_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell25=(float) (messages.BMS_V_Sensor_Failure_Cell25 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL25_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell26=(float) (messages.BMS_V_Sensor_Failure_Cell26 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL26_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell27=(float) (messages.BMS_V_Sensor_Failure_Cell27 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL27_OFFSET);
        messages.BMS_V_Sensor_Failure_Cell28=(float) (messages.BMS_V_Sensor_Failure_Cell28 - can.BMS_FAULT_1_CANID_BMS_V_SENSOR_FAILURE_CELL28_OFFSET);
        messages.BMS_V_Out_of_Range_Cell1=(float) (messages.BMS_V_Out_of_Range_Cell1 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL1_OFFSET);
        messages.BMS_V_Out_of_Range_Cell2=(float) (messages.BMS_V_Out_of_Range_Cell2 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL2_OFFSET);
        messages.BMS_V_Out_of_Range_Cell3=(float) (messages.BMS_V_Out_of_Range_Cell3 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL3_OFFSET);
        messages.BMS_V_Out_of_Range_Cell4=(float) (messages.BMS_V_Out_of_Range_Cell4 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL4_OFFSET);
        messages.BMS_V_Out_of_Range_Cell5=(float) (messages.BMS_V_Out_of_Range_Cell5 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL5_OFFSET);
        messages.BMS_V_Out_of_Range_Cell6=(float) (messages.BMS_V_Out_of_Range_Cell6 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL6_OFFSET);
        messages.BMS_V_Out_of_Range_Cell7=(float) (messages.BMS_V_Out_of_Range_Cell7 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL7_OFFSET);
        messages.BMS_V_Out_of_Range_Cell8=(float) (messages.BMS_V_Out_of_Range_Cell8 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL8_OFFSET);
        messages.BMS_V_Out_of_Range_Cell9=(float) (messages.BMS_V_Out_of_Range_Cell9 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL9_OFFSET);
        messages.BMS_V_Out_of_Range_Cell10=(float) (messages.BMS_V_Out_of_Range_Cell10 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL10_OFFSET);
        messages.BMS_V_Out_of_Range_Cell11=(float) (messages.BMS_V_Out_of_Range_Cell11 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL11_OFFSET);
        messages.BMS_V_Out_of_Range_Cell12=(float) (messages.BMS_V_Out_of_Range_Cell12 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL12_OFFSET);
        messages.BMS_V_Out_of_Range_Cell13=(float) (messages.BMS_V_Out_of_Range_Cell13 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL13_OFFSET);
        messages.BMS_V_Out_of_Range_Cell14=(float) (messages.BMS_V_Out_of_Range_Cell14 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL14_OFFSET);
        messages.BMS_V_Out_of_Range_Cell15=(float) (messages.BMS_V_Out_of_Range_Cell15 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL15_OFFSET);
        messages.BMS_V_Out_of_Range_Cell16=(float) (messages.BMS_V_Out_of_Range_Cell16 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL16_OFFSET);
        messages.BMS_V_Out_of_Range_Cell17=(float) (messages.BMS_V_Out_of_Range_Cell17 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL17_OFFSET);
        messages.BMS_V_Out_of_Range_Cell18=(float) (messages.BMS_V_Out_of_Range_Cell18 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL18_OFFSET);
        messages.BMS_V_Out_of_Range_Cell19=(float) (messages.BMS_V_Out_of_Range_Cell19 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL19_OFFSET);
        messages.BMS_V_Out_of_Range_Cell20=(float) (messages.BMS_V_Out_of_Range_Cell20 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL20_OFFSET);
        messages.BMS_V_Out_of_Range_Cell21=(float) (messages.BMS_V_Out_of_Range_Cell21 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL21_OFFSET);
        messages.BMS_V_Out_of_Range_Cell22=(float) (messages.BMS_V_Out_of_Range_Cell22 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL22_OFFSET);
        messages.BMS_V_Out_of_Range_Cell23=(float) (messages.BMS_V_Out_of_Range_Cell23 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL23_OFFSET);
        messages.BMS_V_Out_of_Range_Cell24=(float) (messages.BMS_V_Out_of_Range_Cell24 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL24_OFFSET);
        messages.BMS_V_Out_of_Range_Cell25=(float) (messages.BMS_V_Out_of_Range_Cell25 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL25_OFFSET);
        messages.BMS_V_Out_of_Range_Cell26=(float) (messages.BMS_V_Out_of_Range_Cell26 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL26_OFFSET);
        messages.BMS_V_Out_of_Range_Cell27=(float) (messages.BMS_V_Out_of_Range_Cell27 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL27_OFFSET);
        messages.BMS_V_Out_of_Range_Cell28=(float) (messages.BMS_V_Out_of_Range_Cell28 - can.BMS_FAULT_1_CANID_BMS_V_OUT_OF_RANGE_CELL28_OFFSET);
        messages.BMS_BatteryPackTemp_1_SensFail=(float) (messages.BMS_BatteryPackTemp_1_SensFail - can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_1_SENSFAIL_OFFSET);
        messages.BMS_BatteryPackTemp_2_SensFail=(float) (messages.BMS_BatteryPackTemp_2_SensFail - can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_2_SENSFAIL_OFFSET);
        messages.BMS_BatteryPackTemp_3_SensFail=(float) (messages.BMS_BatteryPackTemp_3_SensFail - can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_3_SENSFAIL_OFFSET);
        messages.BMS_BatteryPackTemp_4_SensFail=(float) (messages.BMS_BatteryPackTemp_4_SensFail - can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_4_SENSFAIL_OFFSET);
        messages.BMS_BatteryPackTemp_5_SensFail=(float) (messages.BMS_BatteryPackTemp_5_SensFail - can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_5_SENSFAIL_OFFSET);
        messages.BMS_BatteryPackTemp_6_SensFail=(float) (messages.BMS_BatteryPackTemp_6_SensFail - can.BMS_FAULT_1_CANID_BMS_BATTERYPACKTEMP_6_SENSFAIL_OFFSET);
        data[0] = (byte)(((byte)messages.BMS_V_Sensor_Failure_Cell1 & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_V_Sensor_Failure_Cell2 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL2_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell3 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL3_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell4 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL4_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell5 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL5_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell6 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL6_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell7 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL7_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell8 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL8_MASK0));
        data[1] = (byte)(((byte)messages.BMS_V_Sensor_Failure_Cell9 & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_V_Sensor_Failure_Cell10 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL10_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell11 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL11_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell12 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL12_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell13 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL13_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell14 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL14_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell15 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL15_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell16 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL16_MASK0));
        data[2] = (byte)(((byte)messages.BMS_V_Sensor_Failure_Cell17 & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_V_Sensor_Failure_Cell18 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL18_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell19 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL19_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell20 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL20_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell21 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL21_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell22 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL22_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell23 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL23_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell24 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL24_MASK0));
        data[3] = (byte)(((byte)messages.BMS_V_Sensor_Failure_Cell25 & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_V_Sensor_Failure_Cell26 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL26_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell27 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL27_MASK0) | (((byte)messages.BMS_V_Sensor_Failure_Cell28 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_SENSOR_FAILURE_CELL28_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell1 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL1_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell2 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL2_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell3 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL3_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell4 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL4_MASK0));
        data[4] = (byte)(((byte)messages.BMS_V_Out_of_Range_Cell5 & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_V_Out_of_Range_Cell6 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL6_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell7 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL7_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell8 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL8_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell9 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL9_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell10 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL10_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell11 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL11_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell12 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL12_MASK0));
        data[5] = (byte)(((byte)messages.BMS_V_Out_of_Range_Cell13 & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_V_Out_of_Range_Cell14 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL14_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell15 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL15_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell16 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL16_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell17 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL17_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell18 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL18_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell19 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL19_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell20 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL20_MASK0));
        data[6] = (byte)(((byte)messages.BMS_V_Out_of_Range_Cell21 & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_V_Out_of_Range_Cell22 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL22_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell23 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL23_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell24 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL24_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell25 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL25_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell26 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL26_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell27 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL27_MASK0) | (((byte)messages.BMS_V_Out_of_Range_Cell28 & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_V_OUT_OF_RANGE_CELL28_MASK0));
        data[7] = (byte)(((byte)messages.BMS_BatteryPackTemp_1_SensFail & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_BatteryPackTemp_2_SensFail & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_2_SENSFAIL_MASK0) | (((byte)messages.BMS_BatteryPackTemp_3_SensFail & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_3_SENSFAIL_MASK0) | (((byte)messages.BMS_BatteryPackTemp_4_SensFail & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_4_SENSFAIL_MASK0) | (((byte)messages.BMS_BatteryPackTemp_5_SensFail & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_5_SENSFAIL_MASK0) | (((byte)messages.BMS_BatteryPackTemp_6_SensFail & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_1_BMS_BATTERYPACKTEMP_6_SENSFAIL_MASK0));
        return can.BMS_FAULT_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_Fault_2( ConverterInitialize.BMS_Fault_2_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_LowTempCharge_Error = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_LOWTEMPCHARGE_ERROR_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_LOWTEMPCHARGE_ERROR_OFFSET));
        messages.BMS_LowTempDrive_Warning = (float)(((((data[0] >> can.BMS_FAULT_2_BMS_LOWTEMPDRIVE_WARNING_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_LOWTEMPDRIVE_WARNING_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_LOWTEMPDRIVE_WARNING_OFFSET));
        messages.BMS_LowTempDrive_Error = (float)(((((data[0] >> can.BMS_FAULT_2_BMS_LOWTEMPDRIVE_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_LOWTEMPDRIVE_ERROR_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_LOWTEMPDRIVE_ERROR_OFFSET));
        messages.OverTimetoFastCharge_Error = (float)(((((data[0] >> can.BMS_FAULT_2_OVERTIMETOFASTCHARGE_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_OVERTIMETOFASTCHARGE_ERROR_FACTOR)) + (can.BMS_FAULT_2_CANID_OVERTIMETOFASTCHARGE_ERROR_OFFSET));
        messages.Battery_Discharge_Inhibit = (float)(((((data[0] >> can.BMS_FAULT_2_BATTERY_DISCHARGE_INHIBIT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BATTERY_DISCHARGE_INHIBIT_FACTOR)) + (can.BMS_FAULT_2_CANID_BATTERY_DISCHARGE_INHIBIT_OFFSET));
        messages.Battery_Derate_Drive_Cur_Flag = (float)(((((data[0] >> can.BMS_FAULT_2_BATTERY_DERATE_DRIVE_CUR_FLAG_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BATTERY_DERATE_DRIVE_CUR_FLAG_FACTOR)) + (can.BMS_FAULT_2_CANID_BATTERY_DERATE_DRIVE_CUR_FLAG_OFFSET));
        messages.Battery_Derate_Charge_Cur_Flag = (float)(((((data[0] >> can.BMS_FAULT_2_BATTERY_DERATE_CHARGE_CUR_FLAG_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BATTERY_DERATE_CHARGE_CUR_FLAG_FACTOR)) + (can.BMS_FAULT_2_CANID_BATTERY_DERATE_CHARGE_CUR_FLAG_OFFSET));
        messages.Battery_Inhibit_regen_Fault = (float)(((((data[0] >> can.BMS_FAULT_2_BATTERY_INHIBIT_REGEN_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BATTERY_INHIBIT_REGEN_FAULT_FACTOR)) + (can.BMS_FAULT_2_CANID_BATTERY_INHIBIT_REGEN_FAULT_OFFSET));
        messages.Battery_Volt_Deviation_Error = (float)((((data[1] & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BATTERY_VOLT_DEVIATION_ERROR_FACTOR)) + (can.BMS_FAULT_2_CANID_BATTERY_VOLT_DEVIATION_ERROR_OFFSET));
        messages.BMS_Batt_PackTemp_1_OutofRange = (float)(((((data[1] >> can.BMS_FAULT_2_BMS_BATT_PACKTEMP_1_OUTOFRANGE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_BATT_PACKTEMP_1_OUTOFRANGE_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_1_OUTOFRANGE_OFFSET));
        messages.BMS_Batt_PackTemp_2_OutofRange = (float)(((((data[1] >> can.BMS_FAULT_2_BMS_BATT_PACKTEMP_2_OUTOFRANGE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_BATT_PACKTEMP_2_OUTOFRANGE_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_2_OUTOFRANGE_OFFSET));
        messages.BMS_Batt_PackTemp_3_OutofRange = (float)(((((data[1] >> can.BMS_FAULT_2_BMS_BATT_PACKTEMP_3_OUTOFRANGE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_BATT_PACKTEMP_3_OUTOFRANGE_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_3_OUTOFRANGE_OFFSET));
        messages.BMS_Batt_PackTemp_4_OutofRange = (float)(((((data[1] >> can.BMS_FAULT_2_BMS_BATT_PACKTEMP_4_OUTOFRANGE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_BATT_PACKTEMP_4_OUTOFRANGE_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_4_OUTOFRANGE_OFFSET));
        messages.BMS_Batt_PackTemp_5_OutofRange = (float)(((((data[1] >> can.BMS_FAULT_2_BMS_BATT_PACKTEMP_5_OUTOFRANGE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_BATT_PACKTEMP_5_OUTOFRANGE_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_5_OUTOFRANGE_OFFSET));
        messages.BMS_Batt_PackTemp_6_OutofRange = (float)(((((data[1] >> can.BMS_FAULT_2_BMS_BATT_PACKTEMP_6_OUTOFRANGE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_BATT_PACKTEMP_6_OUTOFRANGE_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_6_OUTOFRANGE_OFFSET));
        messages.BMS_Curr_Sens_Failure_OpenCir = (float)(((((data[1] >> can.BMS_FAULT_2_BMS_CURR_SENS_FAILURE_OPENCIR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_CURR_SENS_FAILURE_OPENCIR_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_CURR_SENS_FAILURE_OPENCIR_OFFSET));
        messages.BMS_Curr_Sens_Failure_ShortCir = (float)((((data[2] & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_CURR_SENS_FAILURE_SHORTCIR_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_CURR_SENS_FAILURE_SHORTCIR_OFFSET));
        messages.BMS_OverCurrCharge_Warn = (float)(((((data[2] >> can.BMS_FAULT_2_BMS_OVERCURRCHARGE_WARN_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_OVERCURRCHARGE_WARN_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_OVERCURRCHARGE_WARN_OFFSET));
        messages.BMS_OverCurrCharge_Error = (float)(((((data[2] >> can.BMS_FAULT_2_BMS_OVERCURRCHARGE_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_OVERCURRCHARGE_ERROR_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_OVERCURRCHARGE_ERROR_OFFSET));
        messages.BMS_PreChargeTooFast_Info = (float)(((((data[2] >> can.BMS_FAULT_2_BMS_PRECHARGETOOFAST_INFO_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_PRECHARGETOOFAST_INFO_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_PRECHARGETOOFAST_INFO_OFFSET));
        messages.BMS_PreChargeTooSlow_Info = (float)(((((data[2] >> can.BMS_FAULT_2_BMS_PRECHARGETOOSLOW_INFO_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_PRECHARGETOOSLOW_INFO_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_PRECHARGETOOSLOW_INFO_OFFSET));
        messages.BMS_PreChargeFailure = (float)(((((data[2] >> can.BMS_FAULT_2_BMS_PRECHARGEFAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_PRECHARGEFAILURE_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_PRECHARGEFAILURE_OFFSET));
        messages.BMS_MOSFETsConnFailed = (float)(((((data[2] >> can.BMS_FAULT_2_BMS_MOSFETSCONNFAILED_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_MOSFETSCONNFAILED_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_MOSFETSCONNFAILED_OFFSET));
        messages.BMS_MOSFETsDisconnFailed = (float)(((((data[2] >> can.BMS_FAULT_2_BMS_MOSFETSDISCONNFAILED_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_MOSFETSDISCONNFAILED_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_MOSFETSDISCONNFAILED_OFFSET));
        messages.BMS_PDU_TempWarn_Info = (float)((((data[3] & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_PDU_TEMPWARN_INFO_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_PDU_TEMPWARN_INFO_OFFSET));
        messages.BMS_PDU_Temp_Error = (float)(((((data[3] >> can.BMS_FAULT_2_BMS_PDU_TEMP_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_PDU_TEMP_ERROR_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_PDU_TEMP_ERROR_OFFSET));
        messages.BMS_OverVChargeWarnInfo = (float)(((((data[3] >> can.BMS_FAULT_2_BMS_OVERVCHARGEWARNINFO_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_OVERVCHARGEWARNINFO_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_OVERVCHARGEWARNINFO_OFFSET));
        messages.BMS_OverVChargeError = (float)(((((data[3] >> can.BMS_FAULT_2_BMS_OVERVCHARGEERROR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_OVERVCHARGEERROR_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_OVERVCHARGEERROR_OFFSET));
        messages.BMS_OverVChar_Perm_Fault = (float)(((((data[3] >> can.BMS_FAULT_2_BMS_OVERVCHAR_PERM_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_OVERVCHAR_PERM_FAULT_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_OVERVCHAR_PERM_FAULT_OFFSET));
        messages.BMS_OverV_Regen_Warn_Info = (float)(((((data[3] >> can.BMS_FAULT_2_BMS_OVERV_REGEN_WARN_INFO_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_OVERV_REGEN_WARN_INFO_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_OVERV_REGEN_WARN_INFO_OFFSET));
        messages.BMS_OverV_Regen_Error = (float)(((((data[3] >> can.BMS_FAULT_2_BMS_OVERV_REGEN_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_OVERV_REGEN_ERROR_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_OVERV_REGEN_ERROR_OFFSET));
        messages.BMS_UndV_Warn_Info = (float)(((((data[3] >> can.BMS_FAULT_2_BMS_UNDV_WARN_INFO_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_UNDV_WARN_INFO_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_UNDV_WARN_INFO_OFFSET));
        messages.BMS_UndV_Error = (float)((((data[4] & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_UNDV_ERROR_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_UNDV_ERROR_OFFSET));
        messages.BMS_UndV_Perm_fault = (float)(((((data[4] >> can.BMS_FAULT_2_BMS_UNDV_PERM_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_UNDV_PERM_FAULT_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_UNDV_PERM_FAULT_OFFSET));
        messages.BMS_OverTempCharWarnInfo = (float)(((((data[4] >> can.BMS_FAULT_2_BMS_OVERTEMPCHARWARNINFO_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_OVERTEMPCHARWARNINFO_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_OVERTEMPCHARWARNINFO_OFFSET));
        messages.BMS_OverTempCharError = (float)(((((data[4] >> can.BMS_FAULT_2_BMS_OVERTEMPCHARERROR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_OVERTEMPCHARERROR_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_OVERTEMPCHARERROR_OFFSET));
        messages.BMS_OverTempDriveWarnInfo = (float)(((((data[4] >> can.BMS_FAULT_2_BMS_OVERTEMPDRIVEWARNINFO_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_OVERTEMPDRIVEWARNINFO_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_OVERTEMPDRIVEWARNINFO_OFFSET));
        messages.BMS_OverTempDriveError = (float)(((((data[4] >> can.BMS_FAULT_2_BMS_OVERTEMPDRIVEERROR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_OVERTEMPDRIVEERROR_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_OVERTEMPDRIVEERROR_OFFSET));
        messages.BMS_OvTemp_CellVentError = (float)(((((data[4] >> can.BMS_FAULT_2_BMS_OVTEMP_CELLVENTERROR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_OVTEMP_CELLVENTERROR_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_OVTEMP_CELLVENTERROR_OFFSET));
        messages.BMS_OvTemp_CellVentFailure = (float)(((((data[4] >> can.BMS_FAULT_2_BMS_OVTEMP_CELLVENTFAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_OVTEMP_CELLVENTFAILURE_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_OVTEMP_CELLVENTFAILURE_OFFSET));
        messages.BMS_ShortCir_DetectError = (float)((((data[5] & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_SHORTCIR_DETECTERROR_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_SHORTCIR_DETECTERROR_OFFSET));
        messages.BMS_ShortCir_Detect_PermFault = (float)(((((data[5] >> can.BMS_FAULT_2_BMS_SHORTCIR_DETECT_PERMFAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_SHORTCIR_DETECT_PERMFAULT_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_SHORTCIR_DETECT_PERMFAULT_OFFSET));
        messages.BMS_Cell_Failure_PermFault = (float)(((((data[5] >> can.BMS_FAULT_2_BMS_CELL_FAILURE_PERMFAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_CELL_FAILURE_PERMFAULT_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_CELL_FAILURE_PERMFAULT_OFFSET));
        messages.BMS_ParaCell_DisconFault = (float)(((((data[5] >> can.BMS_FAULT_2_BMS_PARACELL_DISCONFAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_PARACELL_DISCONFAULT_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_PARACELL_DISCONFAULT_OFFSET));
        messages.BMS_LowTemp_CharWarnInfo = (float)(((((data[5] >> can.BMS_FAULT_2_BMS_LOWTEMP_CHARWARNINFO_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.BMS_FAULT_2_BMS_LOWTEMP_CHARWARNINFO_FACTOR)) + (can.BMS_FAULT_2_CANID_BMS_LOWTEMP_CHARWARNINFO_OFFSET));

        return can.BMS_FAULT_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_Fault_2( ConverterInitialize.BMS_Fault_2_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_LowTempCharge_Error=(float) (messages.BMS_LowTempCharge_Error - can.BMS_FAULT_2_CANID_BMS_LOWTEMPCHARGE_ERROR_OFFSET);
        messages.BMS_LowTempDrive_Warning=(float) (messages.BMS_LowTempDrive_Warning - can.BMS_FAULT_2_CANID_BMS_LOWTEMPDRIVE_WARNING_OFFSET);
        messages.BMS_LowTempDrive_Error=(float) (messages.BMS_LowTempDrive_Error - can.BMS_FAULT_2_CANID_BMS_LOWTEMPDRIVE_ERROR_OFFSET);
        messages.OverTimetoFastCharge_Error=(float) (messages.OverTimetoFastCharge_Error - can.BMS_FAULT_2_CANID_OVERTIMETOFASTCHARGE_ERROR_OFFSET);
        messages.Battery_Discharge_Inhibit=(float) (messages.Battery_Discharge_Inhibit - can.BMS_FAULT_2_CANID_BATTERY_DISCHARGE_INHIBIT_OFFSET);
        messages.Battery_Derate_Drive_Cur_Flag=(float) (messages.Battery_Derate_Drive_Cur_Flag - can.BMS_FAULT_2_CANID_BATTERY_DERATE_DRIVE_CUR_FLAG_OFFSET);
        messages.Battery_Derate_Charge_Cur_Flag=(float) (messages.Battery_Derate_Charge_Cur_Flag - can.BMS_FAULT_2_CANID_BATTERY_DERATE_CHARGE_CUR_FLAG_OFFSET);
        messages.Battery_Inhibit_regen_Fault=(float) (messages.Battery_Inhibit_regen_Fault - can.BMS_FAULT_2_CANID_BATTERY_INHIBIT_REGEN_FAULT_OFFSET);
        messages.Battery_Volt_Deviation_Error=(float) (messages.Battery_Volt_Deviation_Error - can.BMS_FAULT_2_CANID_BATTERY_VOLT_DEVIATION_ERROR_OFFSET);
        messages.BMS_Batt_PackTemp_1_OutofRange=(float) (messages.BMS_Batt_PackTemp_1_OutofRange - can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_1_OUTOFRANGE_OFFSET);
        messages.BMS_Batt_PackTemp_2_OutofRange=(float) (messages.BMS_Batt_PackTemp_2_OutofRange - can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_2_OUTOFRANGE_OFFSET);
        messages.BMS_Batt_PackTemp_3_OutofRange=(float) (messages.BMS_Batt_PackTemp_3_OutofRange - can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_3_OUTOFRANGE_OFFSET);
        messages.BMS_Batt_PackTemp_4_OutofRange=(float) (messages.BMS_Batt_PackTemp_4_OutofRange - can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_4_OUTOFRANGE_OFFSET);
        messages.BMS_Batt_PackTemp_5_OutofRange=(float) (messages.BMS_Batt_PackTemp_5_OutofRange - can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_5_OUTOFRANGE_OFFSET);
        messages.BMS_Batt_PackTemp_6_OutofRange=(float) (messages.BMS_Batt_PackTemp_6_OutofRange - can.BMS_FAULT_2_CANID_BMS_BATT_PACKTEMP_6_OUTOFRANGE_OFFSET);
        messages.BMS_Curr_Sens_Failure_OpenCir=(float) (messages.BMS_Curr_Sens_Failure_OpenCir - can.BMS_FAULT_2_CANID_BMS_CURR_SENS_FAILURE_OPENCIR_OFFSET);
        messages.BMS_Curr_Sens_Failure_ShortCir=(float) (messages.BMS_Curr_Sens_Failure_ShortCir - can.BMS_FAULT_2_CANID_BMS_CURR_SENS_FAILURE_SHORTCIR_OFFSET);
        messages.BMS_OverCurrCharge_Warn=(float) (messages.BMS_OverCurrCharge_Warn - can.BMS_FAULT_2_CANID_BMS_OVERCURRCHARGE_WARN_OFFSET);
        messages.BMS_OverCurrCharge_Error=(float) (messages.BMS_OverCurrCharge_Error - can.BMS_FAULT_2_CANID_BMS_OVERCURRCHARGE_ERROR_OFFSET);
        messages.BMS_PreChargeTooFast_Info=(float) (messages.BMS_PreChargeTooFast_Info - can.BMS_FAULT_2_CANID_BMS_PRECHARGETOOFAST_INFO_OFFSET);
        messages.BMS_PreChargeTooSlow_Info=(float) (messages.BMS_PreChargeTooSlow_Info - can.BMS_FAULT_2_CANID_BMS_PRECHARGETOOSLOW_INFO_OFFSET);
        messages.BMS_PreChargeFailure=(float) (messages.BMS_PreChargeFailure - can.BMS_FAULT_2_CANID_BMS_PRECHARGEFAILURE_OFFSET);
        messages.BMS_MOSFETsConnFailed=(float) (messages.BMS_MOSFETsConnFailed - can.BMS_FAULT_2_CANID_BMS_MOSFETSCONNFAILED_OFFSET);
        messages.BMS_MOSFETsDisconnFailed=(float) (messages.BMS_MOSFETsDisconnFailed - can.BMS_FAULT_2_CANID_BMS_MOSFETSDISCONNFAILED_OFFSET);
        messages.BMS_PDU_TempWarn_Info=(float) (messages.BMS_PDU_TempWarn_Info - can.BMS_FAULT_2_CANID_BMS_PDU_TEMPWARN_INFO_OFFSET);
        messages.BMS_PDU_Temp_Error=(float) (messages.BMS_PDU_Temp_Error - can.BMS_FAULT_2_CANID_BMS_PDU_TEMP_ERROR_OFFSET);
        messages.BMS_OverVChargeWarnInfo=(float) (messages.BMS_OverVChargeWarnInfo - can.BMS_FAULT_2_CANID_BMS_OVERVCHARGEWARNINFO_OFFSET);
        messages.BMS_OverVChargeError=(float) (messages.BMS_OverVChargeError - can.BMS_FAULT_2_CANID_BMS_OVERVCHARGEERROR_OFFSET);
        messages.BMS_OverVChar_Perm_Fault=(float) (messages.BMS_OverVChar_Perm_Fault - can.BMS_FAULT_2_CANID_BMS_OVERVCHAR_PERM_FAULT_OFFSET);
        messages.BMS_OverV_Regen_Warn_Info=(float) (messages.BMS_OverV_Regen_Warn_Info - can.BMS_FAULT_2_CANID_BMS_OVERV_REGEN_WARN_INFO_OFFSET);
        messages.BMS_OverV_Regen_Error=(float) (messages.BMS_OverV_Regen_Error - can.BMS_FAULT_2_CANID_BMS_OVERV_REGEN_ERROR_OFFSET);
        messages.BMS_UndV_Warn_Info=(float) (messages.BMS_UndV_Warn_Info - can.BMS_FAULT_2_CANID_BMS_UNDV_WARN_INFO_OFFSET);
        messages.BMS_UndV_Error=(float) (messages.BMS_UndV_Error - can.BMS_FAULT_2_CANID_BMS_UNDV_ERROR_OFFSET);
        messages.BMS_UndV_Perm_fault=(float) (messages.BMS_UndV_Perm_fault - can.BMS_FAULT_2_CANID_BMS_UNDV_PERM_FAULT_OFFSET);
        messages.BMS_OverTempCharWarnInfo=(float) (messages.BMS_OverTempCharWarnInfo - can.BMS_FAULT_2_CANID_BMS_OVERTEMPCHARWARNINFO_OFFSET);
        messages.BMS_OverTempCharError=(float) (messages.BMS_OverTempCharError - can.BMS_FAULT_2_CANID_BMS_OVERTEMPCHARERROR_OFFSET);
        messages.BMS_OverTempDriveWarnInfo=(float) (messages.BMS_OverTempDriveWarnInfo - can.BMS_FAULT_2_CANID_BMS_OVERTEMPDRIVEWARNINFO_OFFSET);
        messages.BMS_OverTempDriveError=(float) (messages.BMS_OverTempDriveError - can.BMS_FAULT_2_CANID_BMS_OVERTEMPDRIVEERROR_OFFSET);
        messages.BMS_OvTemp_CellVentError=(float) (messages.BMS_OvTemp_CellVentError - can.BMS_FAULT_2_CANID_BMS_OVTEMP_CELLVENTERROR_OFFSET);
        messages.BMS_OvTemp_CellVentFailure=(float) (messages.BMS_OvTemp_CellVentFailure - can.BMS_FAULT_2_CANID_BMS_OVTEMP_CELLVENTFAILURE_OFFSET);
        messages.BMS_ShortCir_DetectError=(float) (messages.BMS_ShortCir_DetectError - can.BMS_FAULT_2_CANID_BMS_SHORTCIR_DETECTERROR_OFFSET);
        messages.BMS_ShortCir_Detect_PermFault=(float) (messages.BMS_ShortCir_Detect_PermFault - can.BMS_FAULT_2_CANID_BMS_SHORTCIR_DETECT_PERMFAULT_OFFSET);
        messages.BMS_Cell_Failure_PermFault=(float) (messages.BMS_Cell_Failure_PermFault - can.BMS_FAULT_2_CANID_BMS_CELL_FAILURE_PERMFAULT_OFFSET);
        messages.BMS_ParaCell_DisconFault=(float) (messages.BMS_ParaCell_DisconFault - can.BMS_FAULT_2_CANID_BMS_PARACELL_DISCONFAULT_OFFSET);
        messages.BMS_LowTemp_CharWarnInfo=(float) (messages.BMS_LowTemp_CharWarnInfo - can.BMS_FAULT_2_CANID_BMS_LOWTEMP_CHARWARNINFO_OFFSET);
        data[0] = (byte)(((byte)messages.BMS_LowTempCharge_Error & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_LowTempDrive_Warning & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_LOWTEMPDRIVE_WARNING_MASK0) | (((byte)messages.BMS_LowTempDrive_Error & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_LOWTEMPDRIVE_ERROR_MASK0) | (((byte)messages.OverTimetoFastCharge_Error & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_OVERTIMETOFASTCHARGE_ERROR_MASK0) | (((byte)messages.Battery_Discharge_Inhibit & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BATTERY_DISCHARGE_INHIBIT_MASK0) | (((byte)messages.Battery_Derate_Drive_Cur_Flag & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BATTERY_DERATE_DRIVE_CUR_FLAG_MASK0) | (((byte)messages.Battery_Derate_Charge_Cur_Flag & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BATTERY_DERATE_CHARGE_CUR_FLAG_MASK0) | (((byte)messages.Battery_Inhibit_regen_Fault & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BATTERY_INHIBIT_REGEN_FAULT_MASK0));
        data[1] = (byte)(((byte)messages.Battery_Volt_Deviation_Error & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_Batt_PackTemp_1_OutofRange & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_BATT_PACKTEMP_1_OUTOFRANGE_MASK0) | (((byte)messages.BMS_Batt_PackTemp_2_OutofRange & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_BATT_PACKTEMP_2_OUTOFRANGE_MASK0) | (((byte)messages.BMS_Batt_PackTemp_3_OutofRange & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_BATT_PACKTEMP_3_OUTOFRANGE_MASK0) | (((byte)messages.BMS_Batt_PackTemp_4_OutofRange & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_BATT_PACKTEMP_4_OUTOFRANGE_MASK0) | (((byte)messages.BMS_Batt_PackTemp_5_OutofRange & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_BATT_PACKTEMP_5_OUTOFRANGE_MASK0) | (((byte)messages.BMS_Batt_PackTemp_6_OutofRange & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_BATT_PACKTEMP_6_OUTOFRANGE_MASK0) | (((byte)messages.BMS_Curr_Sens_Failure_OpenCir & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_CURR_SENS_FAILURE_OPENCIR_MASK0));
        data[2] = (byte)(((byte)messages.BMS_Curr_Sens_Failure_ShortCir & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_OverCurrCharge_Warn & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERCURRCHARGE_WARN_MASK0) | (((byte)messages.BMS_OverCurrCharge_Error & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERCURRCHARGE_ERROR_MASK0) | (((byte)messages.BMS_PreChargeTooFast_Info & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_PRECHARGETOOFAST_INFO_MASK0) | (((byte)messages.BMS_PreChargeTooSlow_Info & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_PRECHARGETOOSLOW_INFO_MASK0) | (((byte)messages.BMS_PreChargeFailure & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_PRECHARGEFAILURE_MASK0) | (((byte)messages.BMS_MOSFETsConnFailed & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_MOSFETSCONNFAILED_MASK0) | (((byte)messages.BMS_MOSFETsDisconnFailed & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_MOSFETSDISCONNFAILED_MASK0));
        data[3] = (byte)(((byte)messages.BMS_PDU_TempWarn_Info & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_PDU_Temp_Error & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_PDU_TEMP_ERROR_MASK0) | (((byte)messages.BMS_OverVChargeWarnInfo & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERVCHARGEWARNINFO_MASK0) | (((byte)messages.BMS_OverVChargeError & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERVCHARGEERROR_MASK0) | (((byte)messages.BMS_OverVChar_Perm_Fault & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERVCHAR_PERM_FAULT_MASK0) | (((byte)messages.BMS_OverV_Regen_Warn_Info & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERV_REGEN_WARN_INFO_MASK0) | (((byte)messages.BMS_OverV_Regen_Error & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERV_REGEN_ERROR_MASK0) | (((byte)messages.BMS_UndV_Warn_Info & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_UNDV_WARN_INFO_MASK0));
        data[4] = (byte)(((byte)messages.BMS_UndV_Error & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_UndV_Perm_fault & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_UNDV_PERM_FAULT_MASK0) | (((byte)messages.BMS_OverTempCharWarnInfo & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERTEMPCHARWARNINFO_MASK0) | (((byte)messages.BMS_OverTempCharError & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERTEMPCHARERROR_MASK0) | (((byte)messages.BMS_OverTempDriveWarnInfo & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERTEMPDRIVEWARNINFO_MASK0) | (((byte)messages.BMS_OverTempDriveError & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVERTEMPDRIVEERROR_MASK0) | (((byte)messages.BMS_OvTemp_CellVentError & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVTEMP_CELLVENTERROR_MASK0) | (((byte)messages.BMS_OvTemp_CellVentFailure & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_OVTEMP_CELLVENTFAILURE_MASK0));
        data[5] = (byte)(((byte)messages.BMS_ShortCir_DetectError & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.BMS_ShortCir_Detect_PermFault & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_SHORTCIR_DETECT_PERMFAULT_MASK0) | (((byte)messages.BMS_Cell_Failure_PermFault & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_CELL_FAILURE_PERMFAULT_MASK0) | (((byte)messages.BMS_ParaCell_DisconFault & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_PARACELL_DISCONFAULT_MASK0) | (((byte)messages.BMS_LowTemp_CharWarnInfo & ( can.SIGNLE_READ_Mask1)) << can.BMS_FAULT_2_BMS_LOWTEMP_CHARWARNINFO_MASK0));
        return can.BMS_FAULT_2_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ESCL_Data( ConverterInitialize.ESCL_Data_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Supply_Voltage = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DATA_ESCL_SUPPLY_VOLTAGE_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.ESCL_DATA_ESCL_SUPPLY_VOLTAGE_FACTOR)) + (can.ESCL_DATA_CANID_ESCL_SUPPLY_VOLTAGE_OFFSET));
        messages.Motor_Stall_Current = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DATA_MOTOR_STALL_CURRENT_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.ESCL_DATA_MOTOR_STALL_CURRENT_FACTOR)) + (can.ESCL_DATA_CANID_MOTOR_STALL_CURRENT_OFFSET));
        messages.ESCL_Status = (float)((((data[4] & (can.SIGNLE_READ_Mask3))) * (can.ESCL_DATA_ESCL_STATUS_FACTOR)) + (can.ESCL_DATA_CANID_ESCL_STATUS_OFFSET));
        messages.ESCL_Hall1_Status = (float)(((((data[4] >> can.ESCL_DATA_ESCL_HALL1_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ESCL_DATA_ESCL_HALL1_STATUS_FACTOR)) + (can.ESCL_DATA_CANID_ESCL_HALL1_STATUS_OFFSET));
        messages.ESCL_Hall2_Status = (float)(((((data[4] >> can.ESCL_DATA_ESCL_HALL2_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ESCL_DATA_ESCL_HALL2_STATUS_FACTOR)) + (can.ESCL_DATA_CANID_ESCL_HALL2_STATUS_OFFSET));
        messages.ESCL_Power_Status = (float)(((((data[4] >> can.ESCL_DATA_ESCL_POWER_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ESCL_DATA_ESCL_POWER_STATUS_FACTOR)) + (can.ESCL_DATA_CANID_ESCL_POWER_STATUS_OFFSET));
        messages.ESCL_Plunger_Status = (float)(((((data[4] >> can.ESCL_DATA_ESCL_PLUNGER_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ESCL_DATA_ESCL_PLUNGER_STATUS_FACTOR)) + (can.ESCL_DATA_CANID_ESCL_PLUNGER_STATUS_OFFSET));
        messages.ESCL_Motor_Temp_Fault = (float)(((((data[4] >> can.ESCL_DATA_ESCL_MOTOR_TEMP_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ESCL_DATA_ESCL_MOTOR_TEMP_FAULT_FACTOR)) + (can.ESCL_DATA_CANID_ESCL_MOTOR_TEMP_FAULT_OFFSET));
        messages.ESCL_Motor_Open_Fault = (float)((((data[5] & (can.SIGNLE_READ_Mask1))) * (can.ESCL_DATA_ESCL_MOTOR_OPEN_FAULT_FACTOR)) + (can.ESCL_DATA_CANID_ESCL_MOTOR_OPEN_FAULT_OFFSET));
        messages.ESCL_Motor_Short_Fault = (float)(((((data[5] >> can.ESCL_DATA_ESCL_MOTOR_SHORT_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ESCL_DATA_ESCL_MOTOR_SHORT_FAULT_FACTOR)) + (can.ESCL_DATA_CANID_ESCL_MOTOR_SHORT_FAULT_OFFSET));
        messages.ESCL_Lock_Unlock_Error = (float)(((((data[5] >> can.ESCL_DATA_ESCL_LOCK_UNLOCK_ERROR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ESCL_DATA_ESCL_LOCK_UNLOCK_ERROR_FACTOR)) + (can.ESCL_DATA_CANID_ESCL_LOCK_UNLOCK_ERROR_OFFSET));
        messages.ESCL_Sleep_Ack = (float)(((((data[5] >> can.ESCL_DATA_ESCL_SLEEP_ACK_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ESCL_DATA_ESCL_SLEEP_ACK_FACTOR)) + (can.ESCL_DATA_CANID_ESCL_SLEEP_ACK_OFFSET));

        return can.ESCL_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ESCL_Data( ConverterInitialize.ESCL_Data_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Supply_Voltage=(float) (messages.ESCL_Supply_Voltage - can.ESCL_DATA_CANID_ESCL_SUPPLY_VOLTAGE_OFFSET);
        messages.Motor_Stall_Current=(float) (messages.Motor_Stall_Current - can.ESCL_DATA_CANID_MOTOR_STALL_CURRENT_OFFSET);
        messages.ESCL_Status=(float) (messages.ESCL_Status - can.ESCL_DATA_CANID_ESCL_STATUS_OFFSET);
        messages.ESCL_Hall1_Status=(float) (messages.ESCL_Hall1_Status - can.ESCL_DATA_CANID_ESCL_HALL1_STATUS_OFFSET);
        messages.ESCL_Hall2_Status=(float) (messages.ESCL_Hall2_Status - can.ESCL_DATA_CANID_ESCL_HALL2_STATUS_OFFSET);
        messages.ESCL_Power_Status=(float) (messages.ESCL_Power_Status - can.ESCL_DATA_CANID_ESCL_POWER_STATUS_OFFSET);
        messages.ESCL_Plunger_Status=(float) (messages.ESCL_Plunger_Status - can.ESCL_DATA_CANID_ESCL_PLUNGER_STATUS_OFFSET);
        messages.ESCL_Motor_Temp_Fault=(float) (messages.ESCL_Motor_Temp_Fault - can.ESCL_DATA_CANID_ESCL_MOTOR_TEMP_FAULT_OFFSET);
        messages.ESCL_Motor_Open_Fault=(float) (messages.ESCL_Motor_Open_Fault - can.ESCL_DATA_CANID_ESCL_MOTOR_OPEN_FAULT_OFFSET);
        messages.ESCL_Motor_Short_Fault=(float) (messages.ESCL_Motor_Short_Fault - can.ESCL_DATA_CANID_ESCL_MOTOR_SHORT_FAULT_OFFSET);
        messages.ESCL_Lock_Unlock_Error=(float) (messages.ESCL_Lock_Unlock_Error - can.ESCL_DATA_CANID_ESCL_LOCK_UNLOCK_ERROR_OFFSET);
        messages.ESCL_Sleep_Ack=(float) (messages.ESCL_Sleep_Ack - can.ESCL_DATA_CANID_ESCL_SLEEP_ACK_OFFSET);
        data[0] = (byte)(((byte)messages.ESCL_Supply_Voltage & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.ESCL_Supply_Voltage >> can.ESCL_DATA_ESCL_SUPPLY_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Motor_Stall_Current & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Motor_Stall_Current >> can.ESCL_DATA_MOTOR_STALL_CURRENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.ESCL_Status & ( can.SIGNLE_READ_Mask3)) | (((byte)messages.ESCL_Hall1_Status & ( can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_HALL1_STATUS_MASK0) | (((byte)messages.ESCL_Hall2_Status & ( can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_HALL2_STATUS_MASK0) | (((byte)messages.ESCL_Power_Status & ( can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_POWER_STATUS_MASK0) | (((byte)messages.ESCL_Plunger_Status & ( can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_PLUNGER_STATUS_MASK0) | (((byte)messages.ESCL_Motor_Temp_Fault & ( can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_MOTOR_TEMP_FAULT_MASK0));
        data[5] = (byte)(((byte)messages.ESCL_Motor_Open_Fault & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.ESCL_Motor_Short_Fault & ( can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_MOTOR_SHORT_FAULT_MASK0) | (((byte)messages.ESCL_Lock_Unlock_Error & ( can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_LOCK_UNLOCK_ERROR_MASK0) | (((byte)messages.ESCL_Sleep_Ack & ( can.SIGNLE_READ_Mask1)) << can.ESCL_DATA_ESCL_SLEEP_ACK_MASK0));
        return can.ESCL_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_DATA( ConverterInitialize.MCU_DATA_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Motor_rpm = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.MCU_DATA_MOTOR_RPM_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.MCU_DATA_MOTOR_RPM_FACTOR)) + (can.MCU_DATA_CANID_MOTOR_RPM_OFFSET));

        return can.MCU_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_DATA( ConverterInitialize.MCU_DATA_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Motor_rpm=(float) (messages.Motor_rpm - can.MCU_DATA_CANID_MOTOR_RPM_OFFSET);
        data[6] = (byte)(((byte)messages.Motor_rpm & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Motor_rpm >> can.MCU_DATA_MOTOR_RPM_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.MCU_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Charger_Fault_Info( ConverterInitialize.Charger_Fault_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_IP_AC_overVoltage = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_OBC_IP_AC_OVERVOLTAGE_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_OBC_IP_AC_OVERVOLTAGE_OFFSET));
        messages.OBC_IP_AC_UnderV = (float)(((((data[0] >> can.CHARGER_FAULT_INFO_OBC_IP_AC_UNDERV_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_OBC_IP_AC_UNDERV_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_OBC_IP_AC_UNDERV_OFFSET));
        messages.OBC_IP_Overcurrent = (float)(((((data[0] >> can.CHARGER_FAULT_INFO_OBC_IP_OVERCURRENT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_OBC_IP_OVERCURRENT_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_OBC_IP_OVERCURRENT_OFFSET));
        messages.OBC_OP_Overcurrent = (float)(((((data[0] >> can.CHARGER_FAULT_INFO_OBC_OP_OVERCURRENT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_OBC_OP_OVERCURRENT_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_OBC_OP_OVERCURRENT_OFFSET));
        messages.OBC_High_temp = (float)(((((data[0] >> can.CHARGER_FAULT_INFO_OBC_HIGH_TEMP_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_OBC_HIGH_TEMP_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_OBC_HIGH_TEMP_OFFSET));
        messages.OBC_Low_temp = (float)(((((data[0] >> can.CHARGER_FAULT_INFO_OBC_LOW_TEMP_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_OBC_LOW_TEMP_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_OBC_LOW_TEMP_OFFSET));
        messages.OBC_Temp_Sensor_fail = (float)(((((data[0] >> can.CHARGER_FAULT_INFO_OBC_TEMP_SENSOR_FAIL_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_OBC_TEMP_SENSOR_FAIL_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_OBC_TEMP_SENSOR_FAIL_OFFSET));
        messages.OBC_Current_Sensor_fail = (float)(((((data[0] >> can.CHARGER_FAULT_INFO_OBC_CURRENT_SENSOR_FAIL_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_OBC_CURRENT_SENSOR_FAIL_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_OBC_CURRENT_SENSOR_FAIL_OFFSET));
        messages.OBC_ContactorRelay_fail = (float)((((data[1] & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_OBC_CONTACTORRELAY_FAIL_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_OBC_CONTACTORRELAY_FAIL_OFFSET));
        messages.OBC_OP_Open_Circuit = (float)(((((data[1] >> can.CHARGER_FAULT_INFO_OBC_OP_OPEN_CIRCUIT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_OBC_OP_OPEN_CIRCUIT_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_OBC_OP_OPEN_CIRCUIT_OFFSET));
        messages.OBC_OP_Short_Circuit = (float)(((((data[1] >> can.CHARGER_FAULT_INFO_OBC_OP_SHORT_CIRCUIT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_OBC_OP_SHORT_CIRCUIT_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_OBC_OP_SHORT_CIRCUIT_OFFSET));
        messages.OBC_OP_Over_Vol_flt = (float)(((((data[1] >> can.CHARGER_FAULT_INFO_OBC_OP_OVER_VOL_FLT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_OBC_OP_OVER_VOL_FLT_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_OBC_OP_OVER_VOL_FLT_OFFSET));
        messages.OBC_OP_Under_Vol_flt = (float)(((((data[1] >> can.CHARGER_FAULT_INFO_OBC_OP_UNDER_VOL_FLT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_OBC_OP_UNDER_VOL_FLT_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_OBC_OP_UNDER_VOL_FLT_OFFSET));
        messages.DCDC_OP_Over_Vol_flt = (float)(((((data[1] >> can.CHARGER_FAULT_INFO_DCDC_OP_OVER_VOL_FLT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_DCDC_OP_OVER_VOL_FLT_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_DCDC_OP_OVER_VOL_FLT_OFFSET));
        messages.DCDC_IP_Over_Voltage = (float)(((((data[1] >> can.CHARGER_FAULT_INFO_DCDC_IP_OVER_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_DCDC_IP_OVER_VOLTAGE_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_DCDC_IP_OVER_VOLTAGE_OFFSET));
        messages.DCDC_IP_Under_Voltage = (float)(((((data[1] >> can.CHARGER_FAULT_INFO_DCDC_IP_UNDER_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_DCDC_IP_UNDER_VOLTAGE_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_DCDC_IP_UNDER_VOLTAGE_OFFSET));
        messages.DCDC_IP_Over_Current = (float)((((data[2] & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_DCDC_IP_OVER_CURRENT_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_DCDC_IP_OVER_CURRENT_OFFSET));
        messages.DCDC_OP_Over_Current = (float)(((((data[2] >> can.CHARGER_FAULT_INFO_DCDC_OP_OVER_CURRENT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_DCDC_OP_OVER_CURRENT_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_DCDC_OP_OVER_CURRENT_OFFSET));
        messages.DCDC_High_Temp = (float)(((((data[2] >> can.CHARGER_FAULT_INFO_DCDC_HIGH_TEMP_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_DCDC_HIGH_TEMP_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_DCDC_HIGH_TEMP_OFFSET));
        messages.DCDC_Low_Temp = (float)(((((data[2] >> can.CHARGER_FAULT_INFO_DCDC_LOW_TEMP_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_DCDC_LOW_TEMP_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_DCDC_LOW_TEMP_OFFSET));
        messages.DCDC_TempSensor_Failure = (float)(((((data[2] >> can.CHARGER_FAULT_INFO_DCDC_TEMPSENSOR_FAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_DCDC_TEMPSENSOR_FAILURE_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_DCDC_TEMPSENSOR_FAILURE_OFFSET));
        messages.DCDC_Current_Sensor_Failure = (float)(((((data[2] >> can.CHARGER_FAULT_INFO_DCDC_CURRENT_SENSOR_FAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_DCDC_CURRENT_SENSOR_FAILURE_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_DCDC_CURRENT_SENSOR_FAILURE_OFFSET));
        messages.DCDC_Contactor_or_Relay_Failure = (float)(((((data[2] >> can.CHARGER_FAULT_INFO_DCDC_CONTACTOR_OR_RELAY_FAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_DCDC_CONTACTOR_OR_RELAY_FAILURE_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_DCDC_CONTACTOR_OR_RELAY_FAILURE_OFFSET));
        messages.DCDC_OP_Open_Circuit = (float)(((((data[2] >> can.CHARGER_FAULT_INFO_DCDC_OP_OPEN_CIRCUIT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_DCDC_OP_OPEN_CIRCUIT_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_DCDC_OP_OPEN_CIRCUIT_OFFSET));
        messages.DCDC_OP_Short_Circuit = (float)((((data[3] & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_DCDC_OP_SHORT_CIRCUIT_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_DCDC_OP_SHORT_CIRCUIT_OFFSET));
        messages.DCDC_OP_Under_Vol_flt = (float)(((((data[3] >> can.CHARGER_FAULT_INFO_DCDC_OP_UNDER_VOL_FLT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.CHARGER_FAULT_INFO_DCDC_OP_UNDER_VOL_FLT_FACTOR)) + (can.CHARGER_FAULT_INFO_CANID_DCDC_OP_UNDER_VOL_FLT_OFFSET));

        return can.CHARGER_FAULT_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Charger_Fault_Info( ConverterInitialize.Charger_Fault_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_IP_AC_overVoltage=(float) (messages.OBC_IP_AC_overVoltage - can.CHARGER_FAULT_INFO_CANID_OBC_IP_AC_OVERVOLTAGE_OFFSET);
        messages.OBC_IP_AC_UnderV=(float) (messages.OBC_IP_AC_UnderV - can.CHARGER_FAULT_INFO_CANID_OBC_IP_AC_UNDERV_OFFSET);
        messages.OBC_IP_Overcurrent=(float) (messages.OBC_IP_Overcurrent - can.CHARGER_FAULT_INFO_CANID_OBC_IP_OVERCURRENT_OFFSET);
        messages.OBC_OP_Overcurrent=(float) (messages.OBC_OP_Overcurrent - can.CHARGER_FAULT_INFO_CANID_OBC_OP_OVERCURRENT_OFFSET);
        messages.OBC_High_temp=(float) (messages.OBC_High_temp - can.CHARGER_FAULT_INFO_CANID_OBC_HIGH_TEMP_OFFSET);
        messages.OBC_Low_temp=(float) (messages.OBC_Low_temp - can.CHARGER_FAULT_INFO_CANID_OBC_LOW_TEMP_OFFSET);
        messages.OBC_Temp_Sensor_fail=(float) (messages.OBC_Temp_Sensor_fail - can.CHARGER_FAULT_INFO_CANID_OBC_TEMP_SENSOR_FAIL_OFFSET);
        messages.OBC_Current_Sensor_fail=(float) (messages.OBC_Current_Sensor_fail - can.CHARGER_FAULT_INFO_CANID_OBC_CURRENT_SENSOR_FAIL_OFFSET);
        messages.OBC_ContactorRelay_fail=(float) (messages.OBC_ContactorRelay_fail - can.CHARGER_FAULT_INFO_CANID_OBC_CONTACTORRELAY_FAIL_OFFSET);
        messages.OBC_OP_Open_Circuit=(float) (messages.OBC_OP_Open_Circuit - can.CHARGER_FAULT_INFO_CANID_OBC_OP_OPEN_CIRCUIT_OFFSET);
        messages.OBC_OP_Short_Circuit=(float) (messages.OBC_OP_Short_Circuit - can.CHARGER_FAULT_INFO_CANID_OBC_OP_SHORT_CIRCUIT_OFFSET);
        messages.OBC_OP_Over_Vol_flt=(float) (messages.OBC_OP_Over_Vol_flt - can.CHARGER_FAULT_INFO_CANID_OBC_OP_OVER_VOL_FLT_OFFSET);
        messages.OBC_OP_Under_Vol_flt=(float) (messages.OBC_OP_Under_Vol_flt - can.CHARGER_FAULT_INFO_CANID_OBC_OP_UNDER_VOL_FLT_OFFSET);
        messages.DCDC_OP_Over_Vol_flt=(float) (messages.DCDC_OP_Over_Vol_flt - can.CHARGER_FAULT_INFO_CANID_DCDC_OP_OVER_VOL_FLT_OFFSET);
        messages.DCDC_IP_Over_Voltage=(float) (messages.DCDC_IP_Over_Voltage - can.CHARGER_FAULT_INFO_CANID_DCDC_IP_OVER_VOLTAGE_OFFSET);
        messages.DCDC_IP_Under_Voltage=(float) (messages.DCDC_IP_Under_Voltage - can.CHARGER_FAULT_INFO_CANID_DCDC_IP_UNDER_VOLTAGE_OFFSET);
        messages.DCDC_IP_Over_Current=(float) (messages.DCDC_IP_Over_Current - can.CHARGER_FAULT_INFO_CANID_DCDC_IP_OVER_CURRENT_OFFSET);
        messages.DCDC_OP_Over_Current=(float) (messages.DCDC_OP_Over_Current - can.CHARGER_FAULT_INFO_CANID_DCDC_OP_OVER_CURRENT_OFFSET);
        messages.DCDC_High_Temp=(float) (messages.DCDC_High_Temp - can.CHARGER_FAULT_INFO_CANID_DCDC_HIGH_TEMP_OFFSET);
        messages.DCDC_Low_Temp=(float) (messages.DCDC_Low_Temp - can.CHARGER_FAULT_INFO_CANID_DCDC_LOW_TEMP_OFFSET);
        messages.DCDC_TempSensor_Failure=(float) (messages.DCDC_TempSensor_Failure - can.CHARGER_FAULT_INFO_CANID_DCDC_TEMPSENSOR_FAILURE_OFFSET);
        messages.DCDC_Current_Sensor_Failure=(float) (messages.DCDC_Current_Sensor_Failure - can.CHARGER_FAULT_INFO_CANID_DCDC_CURRENT_SENSOR_FAILURE_OFFSET);
        messages.DCDC_Contactor_or_Relay_Failure=(float) (messages.DCDC_Contactor_or_Relay_Failure - can.CHARGER_FAULT_INFO_CANID_DCDC_CONTACTOR_OR_RELAY_FAILURE_OFFSET);
        messages.DCDC_OP_Open_Circuit=(float) (messages.DCDC_OP_Open_Circuit - can.CHARGER_FAULT_INFO_CANID_DCDC_OP_OPEN_CIRCUIT_OFFSET);
        messages.DCDC_OP_Short_Circuit=(float) (messages.DCDC_OP_Short_Circuit - can.CHARGER_FAULT_INFO_CANID_DCDC_OP_SHORT_CIRCUIT_OFFSET);
        messages.DCDC_OP_Under_Vol_flt=(float) (messages.DCDC_OP_Under_Vol_flt - can.CHARGER_FAULT_INFO_CANID_DCDC_OP_UNDER_VOL_FLT_OFFSET);
        data[0] = (byte)(((byte)messages.OBC_IP_AC_overVoltage & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.OBC_IP_AC_UnderV & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_IP_AC_UNDERV_MASK0) | (((byte)messages.OBC_IP_Overcurrent & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_IP_OVERCURRENT_MASK0) | (((byte)messages.OBC_OP_Overcurrent & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_OP_OVERCURRENT_MASK0) | (((byte)messages.OBC_High_temp & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_HIGH_TEMP_MASK0) | (((byte)messages.OBC_Low_temp & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_LOW_TEMP_MASK0) | (((byte)messages.OBC_Temp_Sensor_fail & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_TEMP_SENSOR_FAIL_MASK0) | (((byte)messages.OBC_Current_Sensor_fail & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_CURRENT_SENSOR_FAIL_MASK0));
        data[1] = (byte)(((byte)messages.OBC_ContactorRelay_fail & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.OBC_OP_Open_Circuit & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_OP_OPEN_CIRCUIT_MASK0) | (((byte)messages.OBC_OP_Short_Circuit & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_OP_SHORT_CIRCUIT_MASK0) | (((byte)messages.OBC_OP_Over_Vol_flt & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_OP_OVER_VOL_FLT_MASK0) | (((byte)messages.OBC_OP_Under_Vol_flt & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_OBC_OP_UNDER_VOL_FLT_MASK0) | (((byte)messages.DCDC_OP_Over_Vol_flt & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_OP_OVER_VOL_FLT_MASK0) | (((byte)messages.DCDC_IP_Over_Voltage & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_IP_OVER_VOLTAGE_MASK0) | (((byte)messages.DCDC_IP_Under_Voltage & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_IP_UNDER_VOLTAGE_MASK0));
        data[2] = (byte)(((byte)messages.DCDC_IP_Over_Current & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.DCDC_OP_Over_Current & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_OP_OVER_CURRENT_MASK0) | (((byte)messages.DCDC_High_Temp & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_HIGH_TEMP_MASK0) | (((byte)messages.DCDC_Low_Temp & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_LOW_TEMP_MASK0) | (((byte)messages.DCDC_TempSensor_Failure & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_TEMPSENSOR_FAILURE_MASK0) | (((byte)messages.DCDC_Current_Sensor_Failure & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_CURRENT_SENSOR_FAILURE_MASK0) | (((byte)messages.DCDC_Contactor_or_Relay_Failure & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_CONTACTOR_OR_RELAY_FAILURE_MASK0) | (((byte)messages.DCDC_OP_Open_Circuit & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_OP_OPEN_CIRCUIT_MASK0));
        data[3] = (byte)(((byte)messages.DCDC_OP_Short_Circuit & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.DCDC_OP_Under_Vol_flt & ( can.SIGNLE_READ_Mask1)) << can.CHARGER_FAULT_INFO_DCDC_OP_UNDER_VOL_FLT_MASK0));
        return can.CHARGER_FAULT_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_HP_DCDC_Parameter1( ConverterInitialize.HP_DCDC_Parameter1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.HP_DCDC_IP_DC_Current = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.HP_DCDC_PARAMETER1_HP_DCDC_IP_DC_CURRENT_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.HP_DCDC_PARAMETER1_HP_DCDC_IP_DC_CURRENT_FACTOR)) + (can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_IP_DC_CURRENT_OFFSET));
        messages.HP_DCDC_IP_DC_Voltage = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.HP_DCDC_PARAMETER1_HP_DCDC_IP_DC_VOLTAGE_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.HP_DCDC_PARAMETER1_HP_DCDC_IP_DC_VOLTAGE_FACTOR)) + (can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_IP_DC_VOLTAGE_OFFSET));
        messages.HP_DCDC_OP_DC_Current = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.HP_DCDC_PARAMETER1_HP_DCDC_OP_DC_CURRENT_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.HP_DCDC_PARAMETER1_HP_DCDC_OP_DC_CURRENT_FACTOR)) + (can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_OP_DC_CURRENT_OFFSET));
        messages.HP_DCDC_OP_DC_Voltage = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.HP_DCDC_PARAMETER1_HP_DCDC_OP_DC_VOLTAGE_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.HP_DCDC_PARAMETER1_HP_DCDC_OP_DC_VOLTAGE_FACTOR)) + (can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_OP_DC_VOLTAGE_OFFSET));

        return can.HP_DCDC_PARAMETER1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_HP_DCDC_Parameter1( ConverterInitialize.HP_DCDC_Parameter1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.HP_DCDC_IP_DC_Current=(float) (messages.HP_DCDC_IP_DC_Current - can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_IP_DC_CURRENT_OFFSET);
        messages.HP_DCDC_IP_DC_Voltage=(float) (messages.HP_DCDC_IP_DC_Voltage - can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_IP_DC_VOLTAGE_OFFSET);
        messages.HP_DCDC_OP_DC_Current=(float) (messages.HP_DCDC_OP_DC_Current - can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_OP_DC_CURRENT_OFFSET);
        messages.HP_DCDC_OP_DC_Voltage=(float) (messages.HP_DCDC_OP_DC_Voltage - can.HP_DCDC_PARAMETER1_CANID_HP_DCDC_OP_DC_VOLTAGE_OFFSET);
        data[0] = (byte)(((byte)messages.HP_DCDC_IP_DC_Current & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.HP_DCDC_IP_DC_Current >> can.HP_DCDC_PARAMETER1_HP_DCDC_IP_DC_CURRENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.HP_DCDC_IP_DC_Voltage & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.HP_DCDC_IP_DC_Voltage >> can.HP_DCDC_PARAMETER1_HP_DCDC_IP_DC_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.HP_DCDC_OP_DC_Current & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.HP_DCDC_OP_DC_Current >> can.HP_DCDC_PARAMETER1_HP_DCDC_OP_DC_CURRENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.HP_DCDC_OP_DC_Voltage & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.HP_DCDC_OP_DC_Voltage >> can.HP_DCDC_PARAMETER1_HP_DCDC_OP_DC_VOLTAGE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.HP_DCDC_PARAMETER1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_SOM_Settings_Data( ConverterInitialize.SOM_Settings_Data_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Setting = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.SOM_SETTINGS_DATA_ABS_SETTING_FACTOR)) + (can.SOM_SETTINGS_DATA_CANID_ABS_SETTING_OFFSET));
        messages.Regen_Setting = (float)(((((data[0] >> can.SOM_SETTINGS_DATA_REGEN_SETTING_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.SOM_SETTINGS_DATA_REGEN_SETTING_FACTOR)) + (can.SOM_SETTINGS_DATA_CANID_REGEN_SETTING_OFFSET));
        messages.Speed_Limit_Setting = (float)(((((data[0] >> can.SOM_SETTINGS_DATA_SPEED_LIMIT_SETTING_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.SOM_SETTINGS_DATA_SPEED_LIMIT_SETTING_FACTOR)) + (can.SOM_SETTINGS_DATA_CANID_SPEED_LIMIT_SETTING_OFFSET));
        messages.Haptic_Setting = (float)(((((data[0] >> can.SOM_SETTINGS_DATA_HAPTIC_SETTING_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.SOM_SETTINGS_DATA_HAPTIC_SETTING_FACTOR)) + (can.SOM_SETTINGS_DATA_CANID_HAPTIC_SETTING_OFFSET));
        messages.Hill_Hold_Setting = (float)(((((data[0] >> can.SOM_SETTINGS_DATA_HILL_HOLD_SETTING_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.SOM_SETTINGS_DATA_HILL_HOLD_SETTING_FACTOR)) + (can.SOM_SETTINGS_DATA_CANID_HILL_HOLD_SETTING_OFFSET));
        messages.Traction_Control_Setting = (float)(((((data[0] >> can.SOM_SETTINGS_DATA_TRACTION_CONTROL_SETTING_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.SOM_SETTINGS_DATA_TRACTION_CONTROL_SETTING_FACTOR)) + (can.SOM_SETTINGS_DATA_CANID_TRACTION_CONTROL_SETTING_OFFSET));
        messages.Cruise_Control_Setting = (float)(((((data[0] >> can.SOM_SETTINGS_DATA_CRUISE_CONTROL_SETTING_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.SOM_SETTINGS_DATA_CRUISE_CONTROL_SETTING_FACTOR)) + (can.SOM_SETTINGS_DATA_CANID_CRUISE_CONTROL_SETTING_OFFSET));
        messages.Set_Max_Speed = (float)((((data[1] & (can.SIGNLE_READ_Mask8))) * (can.SOM_SETTINGS_DATA_SET_MAX_SPEED_FACTOR)) + (can.SOM_SETTINGS_DATA_CANID_SET_MAX_SPEED_OFFSET));

        return can.SOM_SETTINGS_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_SOM_Settings_Data( ConverterInitialize.SOM_Settings_Data_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Setting=(float) (messages.ABS_Setting - can.SOM_SETTINGS_DATA_CANID_ABS_SETTING_OFFSET);
        messages.Regen_Setting=(float) (messages.Regen_Setting - can.SOM_SETTINGS_DATA_CANID_REGEN_SETTING_OFFSET);
        messages.Speed_Limit_Setting=(float) (messages.Speed_Limit_Setting - can.SOM_SETTINGS_DATA_CANID_SPEED_LIMIT_SETTING_OFFSET);
        messages.Haptic_Setting=(float) (messages.Haptic_Setting - can.SOM_SETTINGS_DATA_CANID_HAPTIC_SETTING_OFFSET);
        messages.Hill_Hold_Setting=(float) (messages.Hill_Hold_Setting - can.SOM_SETTINGS_DATA_CANID_HILL_HOLD_SETTING_OFFSET);
        messages.Traction_Control_Setting=(float) (messages.Traction_Control_Setting - can.SOM_SETTINGS_DATA_CANID_TRACTION_CONTROL_SETTING_OFFSET);
        messages.Cruise_Control_Setting=(float) (messages.Cruise_Control_Setting - can.SOM_SETTINGS_DATA_CANID_CRUISE_CONTROL_SETTING_OFFSET);
        messages.Set_Max_Speed=(float) (messages.Set_Max_Speed - can.SOM_SETTINGS_DATA_CANID_SET_MAX_SPEED_OFFSET);
        data[0] = (byte)(((byte)messages.ABS_Setting & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Regen_Setting & ( can.SIGNLE_READ_Mask1)) << can.SOM_SETTINGS_DATA_REGEN_SETTING_MASK0) | (((byte)messages.Speed_Limit_Setting & ( can.SIGNLE_READ_Mask1)) << can.SOM_SETTINGS_DATA_SPEED_LIMIT_SETTING_MASK0) | (((byte)messages.Haptic_Setting & ( can.SIGNLE_READ_Mask1)) << can.SOM_SETTINGS_DATA_HAPTIC_SETTING_MASK0) | (((byte)messages.Hill_Hold_Setting & ( can.SIGNLE_READ_Mask1)) << can.SOM_SETTINGS_DATA_HILL_HOLD_SETTING_MASK0) | (((byte)messages.Traction_Control_Setting & ( can.SIGNLE_READ_Mask1)) << can.SOM_SETTINGS_DATA_TRACTION_CONTROL_SETTING_MASK0) | (((byte)messages.Cruise_Control_Setting & ( can.SIGNLE_READ_Mask1)) << can.SOM_SETTINGS_DATA_CRUISE_CONTROL_SETTING_MASK0));
        data[1] = (byte)(((byte)messages.Set_Max_Speed & ( can.SIGNLE_READ_Mask8)));
        return can.SOM_SETTINGS_DATA_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_IMU_Data_X( ConverterInitialize.IMU_Data_X_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Accelerometer_Xaxis = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_X_ACCELEROMETER_XAXIS_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_X_ACCELEROMETER_XAXIS_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_X_ACCELEROMETER_XAXIS_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.IMU_DATA_X_ACCELEROMETER_XAXIS_FACTOR)) + (can.IMU_DATA_X_CANID_ACCELEROMETER_XAXIS_OFFSET));
        messages.Gyroscope_Xaxis = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_X_GYROSCOPE_XAXIS_MASK0) | (( data[6] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_X_GYROSCOPE_XAXIS_MASK1) | (( data[5] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_X_GYROSCOPE_XAXIS_MASK2) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.IMU_DATA_X_GYROSCOPE_XAXIS_FACTOR)) + (can.IMU_DATA_X_CANID_GYROSCOPE_XAXIS_OFFSET));

        return can.IMU_DATA_X_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_IMU_Data_X( ConverterInitialize.IMU_Data_X_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Accelerometer_Xaxis=(float) (messages.Accelerometer_Xaxis - can.IMU_DATA_X_CANID_ACCELEROMETER_XAXIS_OFFSET);
        messages.Gyroscope_Xaxis=(float) (messages.Gyroscope_Xaxis - can.IMU_DATA_X_CANID_GYROSCOPE_XAXIS_OFFSET);
        data[0] = (byte)(((byte)messages.Accelerometer_Xaxis & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Accelerometer_Xaxis >> can.IMU_DATA_X_ACCELEROMETER_XAXIS_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.Accelerometer_Xaxis >> can.IMU_DATA_X_ACCELEROMETER_XAXIS_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Accelerometer_Xaxis >> can.IMU_DATA_X_ACCELEROMETER_XAXIS_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Gyroscope_Xaxis & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Gyroscope_Xaxis >> can.IMU_DATA_X_GYROSCOPE_XAXIS_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.Gyroscope_Xaxis >> can.IMU_DATA_X_GYROSCOPE_XAXIS_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Gyroscope_Xaxis >> can.IMU_DATA_X_GYROSCOPE_XAXIS_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.IMU_DATA_X_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_SW_Version( ConverterInitialize.MCU_SW_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Firmware_OEM_Version = (float)((((data[0] & (can.SIGNLE_READ_Mask8))) * (can.MCU_SW_VERSION_MCU_FIRMWARE_OEM_VERSION_FACTOR)) + (can.MCU_SW_VERSION_CANID_MCU_FIRMWARE_OEM_VERSION_OFFSET));
        messages.MCU_Firmware_Main_Version = (float)((((data[1] & (can.SIGNLE_READ_Mask8))) * (can.MCU_SW_VERSION_MCU_FIRMWARE_MAIN_VERSION_FACTOR)) + (can.MCU_SW_VERSION_CANID_MCU_FIRMWARE_MAIN_VERSION_OFFSET));
        messages.MCU_Firmware_Sub_Version = (float)((((data[2] & (can.SIGNLE_READ_Mask8))) * (can.MCU_SW_VERSION_MCU_FIRMWARE_SUB_VERSION_FACTOR)) + (can.MCU_SW_VERSION_CANID_MCU_FIRMWARE_SUB_VERSION_OFFSET));
        messages.MCU_Bootloader_OEM_Version = (float)((((data[3] & (can.SIGNLE_READ_Mask8))) * (can.MCU_SW_VERSION_MCU_BOOTLOADER_OEM_VERSION_FACTOR)) + (can.MCU_SW_VERSION_CANID_MCU_BOOTLOADER_OEM_VERSION_OFFSET));
        messages.MCU_Bootloader_Main_Version = (float)((((data[4] & (can.SIGNLE_READ_Mask8))) * (can.MCU_SW_VERSION_MCU_BOOTLOADER_MAIN_VERSION_FACTOR)) + (can.MCU_SW_VERSION_CANID_MCU_BOOTLOADER_MAIN_VERSION_OFFSET));
        messages.MCU_Hardware_OEM_Version = (float)((((data[5] & (can.SIGNLE_READ_Mask8))) * (can.MCU_SW_VERSION_MCU_HARDWARE_OEM_VERSION_FACTOR)) + (can.MCU_SW_VERSION_CANID_MCU_HARDWARE_OEM_VERSION_OFFSET));
        messages.MCU_Hardware_Main_Version = (float)((((data[6] & (can.SIGNLE_READ_Mask8))) * (can.MCU_SW_VERSION_MCU_HARDWARE_MAIN_VERSION_FACTOR)) + (can.MCU_SW_VERSION_CANID_MCU_HARDWARE_MAIN_VERSION_OFFSET));
        messages.MCU_Hardware_Sub_Version = (float)((((data[7] & (can.SIGNLE_READ_Mask8))) * (can.MCU_SW_VERSION_MCU_HARDWARE_SUB_VERSION_FACTOR)) + (can.MCU_SW_VERSION_CANID_MCU_HARDWARE_SUB_VERSION_OFFSET));

        return can.MCU_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_SW_Version( ConverterInitialize.MCU_SW_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Firmware_OEM_Version=(float) (messages.MCU_Firmware_OEM_Version - can.MCU_SW_VERSION_CANID_MCU_FIRMWARE_OEM_VERSION_OFFSET);
        messages.MCU_Firmware_Main_Version=(float) (messages.MCU_Firmware_Main_Version - can.MCU_SW_VERSION_CANID_MCU_FIRMWARE_MAIN_VERSION_OFFSET);
        messages.MCU_Firmware_Sub_Version=(float) (messages.MCU_Firmware_Sub_Version - can.MCU_SW_VERSION_CANID_MCU_FIRMWARE_SUB_VERSION_OFFSET);
        messages.MCU_Bootloader_OEM_Version=(float) (messages.MCU_Bootloader_OEM_Version - can.MCU_SW_VERSION_CANID_MCU_BOOTLOADER_OEM_VERSION_OFFSET);
        messages.MCU_Bootloader_Main_Version=(float) (messages.MCU_Bootloader_Main_Version - can.MCU_SW_VERSION_CANID_MCU_BOOTLOADER_MAIN_VERSION_OFFSET);
        messages.MCU_Hardware_OEM_Version=(float) (messages.MCU_Hardware_OEM_Version - can.MCU_SW_VERSION_CANID_MCU_HARDWARE_OEM_VERSION_OFFSET);
        messages.MCU_Hardware_Main_Version=(float) (messages.MCU_Hardware_Main_Version - can.MCU_SW_VERSION_CANID_MCU_HARDWARE_MAIN_VERSION_OFFSET);
        messages.MCU_Hardware_Sub_Version=(float) (messages.MCU_Hardware_Sub_Version - can.MCU_SW_VERSION_CANID_MCU_HARDWARE_SUB_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.MCU_Firmware_OEM_Version & ( can.SIGNLE_READ_Mask8)));
        data[1] = (byte)(((byte)messages.MCU_Firmware_Main_Version & ( can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.MCU_Firmware_Sub_Version & ( can.SIGNLE_READ_Mask8)));
        data[3] = (byte)(((byte)messages.MCU_Bootloader_OEM_Version & ( can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.MCU_Bootloader_Main_Version & ( can.SIGNLE_READ_Mask8)));
        data[5] = (byte)(((byte)messages.MCU_Hardware_OEM_Version & ( can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.MCU_Hardware_Main_Version & ( can.SIGNLE_READ_Mask8)));
        data[7] = (byte)(((byte)messages.MCU_Hardware_Sub_Version & ( can.SIGNLE_READ_Mask8)));
        return can.MCU_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ICM_HW_Version_Info( ConverterInitialize.ICM_HW_Version_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ICM_Hardware_Version = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_FACTOR)) + (can.ICM_HW_VERSION_INFO_CANID_ICM_HARDWARE_VERSION_OFFSET));

        return can.ICM_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ICM_HW_Version_Info( ConverterInitialize.ICM_HW_Version_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ICM_Hardware_Version=(double) (messages.ICM_Hardware_Version - can.ICM_HW_VERSION_INFO_CANID_ICM_HARDWARE_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.ICM_Hardware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.ICM_Hardware_Version >> can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.ICM_Hardware_Version >> can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.ICM_Hardware_Version >> can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.ICM_Hardware_Version >> can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.ICM_Hardware_Version >> can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.ICM_Hardware_Version >> can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.ICM_Hardware_Version >> can.ICM_HW_VERSION_INFO_ICM_HARDWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ICM_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ICM_SW_Version( ConverterInitialize.ICM_SW_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ICM_Firmware_Version = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.ICM_SW_VERSION_ICM_FIRMWARE_VERSION_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.ICM_SW_VERSION_ICM_FIRMWARE_VERSION_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.ICM_SW_VERSION_ICM_FIRMWARE_VERSION_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.ICM_SW_VERSION_ICM_FIRMWARE_VERSION_FACTOR)) + (can.ICM_SW_VERSION_CANID_ICM_FIRMWARE_VERSION_OFFSET));
        messages.ICM_Bootloader_Version = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.ICM_SW_VERSION_ICM_BOOTLOADER_VERSION_MASK0) | (( data[6] & (can.SIGNLE_READ_Mask8)) << can.ICM_SW_VERSION_ICM_BOOTLOADER_VERSION_MASK1) | (( data[5] & (can.SIGNLE_READ_Mask8)) << can.ICM_SW_VERSION_ICM_BOOTLOADER_VERSION_MASK2) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.ICM_SW_VERSION_ICM_BOOTLOADER_VERSION_FACTOR)) + (can.ICM_SW_VERSION_CANID_ICM_BOOTLOADER_VERSION_OFFSET));

        return can.ICM_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ICM_SW_Version( ConverterInitialize.ICM_SW_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ICM_Firmware_Version=(float) (messages.ICM_Firmware_Version - can.ICM_SW_VERSION_CANID_ICM_FIRMWARE_VERSION_OFFSET);
        messages.ICM_Bootloader_Version=(float) (messages.ICM_Bootloader_Version - can.ICM_SW_VERSION_CANID_ICM_BOOTLOADER_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.ICM_Firmware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.ICM_Firmware_Version >> can.ICM_SW_VERSION_ICM_FIRMWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.ICM_Firmware_Version >> can.ICM_SW_VERSION_ICM_FIRMWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.ICM_Firmware_Version >> can.ICM_SW_VERSION_ICM_FIRMWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.ICM_Bootloader_Version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.ICM_Bootloader_Version >> can.ICM_SW_VERSION_ICM_BOOTLOADER_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.ICM_Bootloader_Version >> can.ICM_SW_VERSION_ICM_BOOTLOADER_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.ICM_Bootloader_Version >> can.ICM_SW_VERSION_ICM_BOOTLOADER_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ICM_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ESCL_HW_Version_Info( ConverterInitialize.ESCL_HW_Version_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Hardware_Version = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_FACTOR)) + (can.ESCL_HW_VERSION_INFO_CANID_ESCL_HARDWARE_VERSION_OFFSET));

        return can.ESCL_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ESCL_HW_Version_Info( ConverterInitialize.ESCL_HW_Version_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Hardware_Version=(double) (messages.ESCL_Hardware_Version - can.ESCL_HW_VERSION_INFO_CANID_ESCL_HARDWARE_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.ESCL_Hardware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.ESCL_Hardware_Version >> can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.ESCL_Hardware_Version >> can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.ESCL_Hardware_Version >> can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.ESCL_Hardware_Version >> can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.ESCL_Hardware_Version >> can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.ESCL_Hardware_Version >> can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.ESCL_Hardware_Version >> can.ESCL_HW_VERSION_INFO_ESCL_HARDWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ESCL_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OBC_SW_Version( ConverterInitialize.OBC_SW_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Firmware_Version = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.OBC_SW_VERSION_OBC_FIRMWARE_VERSION_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.OBC_SW_VERSION_OBC_FIRMWARE_VERSION_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.OBC_SW_VERSION_OBC_FIRMWARE_VERSION_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.OBC_SW_VERSION_OBC_FIRMWARE_VERSION_FACTOR)) + (can.OBC_SW_VERSION_CANID_OBC_FIRMWARE_VERSION_OFFSET));
        messages.OBC_Bootloader_Version = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.OBC_SW_VERSION_OBC_BOOTLOADER_VERSION_MASK0) | (( data[6] & (can.SIGNLE_READ_Mask8)) << can.OBC_SW_VERSION_OBC_BOOTLOADER_VERSION_MASK1) | (( data[5] & (can.SIGNLE_READ_Mask8)) << can.OBC_SW_VERSION_OBC_BOOTLOADER_VERSION_MASK2) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.OBC_SW_VERSION_OBC_BOOTLOADER_VERSION_FACTOR)) + (can.OBC_SW_VERSION_CANID_OBC_BOOTLOADER_VERSION_OFFSET));

        return can.OBC_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OBC_SW_Version( ConverterInitialize.OBC_SW_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Firmware_Version=(float) (messages.OBC_Firmware_Version - can.OBC_SW_VERSION_CANID_OBC_FIRMWARE_VERSION_OFFSET);
        messages.OBC_Bootloader_Version=(float) (messages.OBC_Bootloader_Version - can.OBC_SW_VERSION_CANID_OBC_BOOTLOADER_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.OBC_Firmware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.OBC_Firmware_Version >> can.OBC_SW_VERSION_OBC_FIRMWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.OBC_Firmware_Version >> can.OBC_SW_VERSION_OBC_FIRMWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.OBC_Firmware_Version >> can.OBC_SW_VERSION_OBC_FIRMWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.OBC_Bootloader_Version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.OBC_Bootloader_Version >> can.OBC_SW_VERSION_OBC_BOOTLOADER_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.OBC_Bootloader_Version >> can.OBC_SW_VERSION_OBC_BOOTLOADER_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.OBC_Bootloader_Version >> can.OBC_SW_VERSION_OBC_BOOTLOADER_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.OBC_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OBC_HW_Version( ConverterInitialize.OBC_HW_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Hardware_Version = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.OBC_HW_VERSION_OBC_HARDWARE_VERSION_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.OBC_HW_VERSION_OBC_HARDWARE_VERSION_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.OBC_HW_VERSION_OBC_HARDWARE_VERSION_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.OBC_HW_VERSION_OBC_HARDWARE_VERSION_FACTOR)) + (can.OBC_HW_VERSION_CANID_OBC_HARDWARE_VERSION_OFFSET));

        return can.OBC_HW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OBC_HW_Version( ConverterInitialize.OBC_HW_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Hardware_Version=(float) (messages.OBC_Hardware_Version - can.OBC_HW_VERSION_CANID_OBC_HARDWARE_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.OBC_Hardware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.OBC_Hardware_Version >> can.OBC_HW_VERSION_OBC_HARDWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.OBC_Hardware_Version >> can.OBC_HW_VERSION_OBC_HARDWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.OBC_Hardware_Version >> can.OBC_HW_VERSION_OBC_HARDWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.OBC_HW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ESCL_SW_Version_Info( ConverterInitialize.ESCL_SW_Version_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Firmware_version = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.ESCL_SW_VERSION_INFO_ESCL_FIRMWARE_VERSION_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.ESCL_SW_VERSION_INFO_ESCL_FIRMWARE_VERSION_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.ESCL_SW_VERSION_INFO_ESCL_FIRMWARE_VERSION_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.ESCL_SW_VERSION_INFO_ESCL_FIRMWARE_VERSION_FACTOR)) + (can.ESCL_SW_VERSION_INFO_CANID_ESCL_FIRMWARE_VERSION_OFFSET));
        messages.ESCL_Bootloader_version = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.ESCL_SW_VERSION_INFO_ESCL_BOOTLOADER_VERSION_MASK0) | (( data[6] & (can.SIGNLE_READ_Mask8)) << can.ESCL_SW_VERSION_INFO_ESCL_BOOTLOADER_VERSION_MASK1) | (( data[5] & (can.SIGNLE_READ_Mask8)) << can.ESCL_SW_VERSION_INFO_ESCL_BOOTLOADER_VERSION_MASK2) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.ESCL_SW_VERSION_INFO_ESCL_BOOTLOADER_VERSION_FACTOR)) + (can.ESCL_SW_VERSION_INFO_CANID_ESCL_BOOTLOADER_VERSION_OFFSET));

        return can.ESCL_SW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ESCL_SW_Version_Info( ConverterInitialize.ESCL_SW_Version_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Firmware_version=(float) (messages.ESCL_Firmware_version - can.ESCL_SW_VERSION_INFO_CANID_ESCL_FIRMWARE_VERSION_OFFSET);
        messages.ESCL_Bootloader_version=(float) (messages.ESCL_Bootloader_version - can.ESCL_SW_VERSION_INFO_CANID_ESCL_BOOTLOADER_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.ESCL_Firmware_version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.ESCL_Firmware_version >> can.ESCL_SW_VERSION_INFO_ESCL_FIRMWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.ESCL_Firmware_version >> can.ESCL_SW_VERSION_INFO_ESCL_FIRMWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.ESCL_Firmware_version >> can.ESCL_SW_VERSION_INFO_ESCL_FIRMWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.ESCL_Bootloader_version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.ESCL_Bootloader_version >> can.ESCL_SW_VERSION_INFO_ESCL_BOOTLOADER_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.ESCL_Bootloader_version >> can.ESCL_SW_VERSION_INFO_ESCL_BOOTLOADER_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.ESCL_Bootloader_version >> can.ESCL_SW_VERSION_INFO_ESCL_BOOTLOADER_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ESCL_SW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_RSC_HW_Version_Info( ConverterInitialize.RSC_HW_Version_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Hardware_Version = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_FACTOR)) + (can.RSC_HW_VERSION_INFO_CANID_RSC_HARDWARE_VERSION_OFFSET));

        return can.RSC_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_RSC_HW_Version_Info( ConverterInitialize.RSC_HW_Version_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Hardware_Version=(double) (messages.RSC_Hardware_Version - can.RSC_HW_VERSION_INFO_CANID_RSC_HARDWARE_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.RSC_Hardware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.RSC_Hardware_Version >> can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.RSC_Hardware_Version >> can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.RSC_Hardware_Version >> can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.RSC_Hardware_Version >> can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.RSC_Hardware_Version >> can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.RSC_Hardware_Version >> can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.RSC_Hardware_Version >> can.RSC_HW_VERSION_INFO_RSC_HARDWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.RSC_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_RSC_SW_Version( ConverterInitialize.RSC_SW_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Firmware_Version = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.RSC_SW_VERSION_RSC_FIRMWARE_VERSION_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.RSC_SW_VERSION_RSC_FIRMWARE_VERSION_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.RSC_SW_VERSION_RSC_FIRMWARE_VERSION_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.RSC_SW_VERSION_RSC_FIRMWARE_VERSION_FACTOR)) + (can.RSC_SW_VERSION_CANID_RSC_FIRMWARE_VERSION_OFFSET));
        messages.RSC_Bootloader_Version = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.RSC_SW_VERSION_RSC_BOOTLOADER_VERSION_MASK0) | (( data[6] & (can.SIGNLE_READ_Mask8)) << can.RSC_SW_VERSION_RSC_BOOTLOADER_VERSION_MASK1) | (( data[5] & (can.SIGNLE_READ_Mask8)) << can.RSC_SW_VERSION_RSC_BOOTLOADER_VERSION_MASK2) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.RSC_SW_VERSION_RSC_BOOTLOADER_VERSION_FACTOR)) + (can.RSC_SW_VERSION_CANID_RSC_BOOTLOADER_VERSION_OFFSET));

        return can.RSC_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_RSC_SW_Version( ConverterInitialize.RSC_SW_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Firmware_Version=(float) (messages.RSC_Firmware_Version - can.RSC_SW_VERSION_CANID_RSC_FIRMWARE_VERSION_OFFSET);
        messages.RSC_Bootloader_Version=(float) (messages.RSC_Bootloader_Version - can.RSC_SW_VERSION_CANID_RSC_BOOTLOADER_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.RSC_Firmware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.RSC_Firmware_Version >> can.RSC_SW_VERSION_RSC_FIRMWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.RSC_Firmware_Version >> can.RSC_SW_VERSION_RSC_FIRMWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.RSC_Firmware_Version >> can.RSC_SW_VERSION_RSC_FIRMWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.RSC_Bootloader_Version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.RSC_Bootloader_Version >> can.RSC_SW_VERSION_RSC_BOOTLOADER_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.RSC_Bootloader_Version >> can.RSC_SW_VERSION_RSC_BOOTLOADER_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.RSC_Bootloader_Version >> can.RSC_SW_VERSION_RSC_BOOTLOADER_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.RSC_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_LSC_HW_Version_Info( ConverterInitialize.LSC_HW_Version_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Hardware_Version = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_FACTOR)) + (can.LSC_HW_VERSION_INFO_CANID_LSC_HARDWARE_VERSION_OFFSET));

        return can.LSC_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_LSC_HW_Version_Info( ConverterInitialize.LSC_HW_Version_Info_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Hardware_Version=(double) (messages.LSC_Hardware_Version - can.LSC_HW_VERSION_INFO_CANID_LSC_HARDWARE_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.LSC_Hardware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.LSC_Hardware_Version >> can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.LSC_Hardware_Version >> can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.LSC_Hardware_Version >> can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.LSC_Hardware_Version >> can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.LSC_Hardware_Version >> can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.LSC_Hardware_Version >> can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.LSC_Hardware_Version >> can.LSC_HW_VERSION_INFO_LSC_HARDWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.LSC_HW_VERSION_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_LSC_SW_Version( ConverterInitialize.LSC_SW_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Firmware_Version = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.LSC_SW_VERSION_LSC_FIRMWARE_VERSION_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.LSC_SW_VERSION_LSC_FIRMWARE_VERSION_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.LSC_SW_VERSION_LSC_FIRMWARE_VERSION_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.LSC_SW_VERSION_LSC_FIRMWARE_VERSION_FACTOR)) + (can.LSC_SW_VERSION_CANID_LSC_FIRMWARE_VERSION_OFFSET));
        messages.LSC_Bootloader_Version = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.LSC_SW_VERSION_LSC_BOOTLOADER_VERSION_MASK0) | (( data[6] & (can.SIGNLE_READ_Mask8)) << can.LSC_SW_VERSION_LSC_BOOTLOADER_VERSION_MASK1) | (( data[5] & (can.SIGNLE_READ_Mask8)) << can.LSC_SW_VERSION_LSC_BOOTLOADER_VERSION_MASK2) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.LSC_SW_VERSION_LSC_BOOTLOADER_VERSION_FACTOR)) + (can.LSC_SW_VERSION_CANID_LSC_BOOTLOADER_VERSION_OFFSET));

        return can.LSC_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_LSC_SW_Version( ConverterInitialize.LSC_SW_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Firmware_Version=(float) (messages.LSC_Firmware_Version - can.LSC_SW_VERSION_CANID_LSC_FIRMWARE_VERSION_OFFSET);
        messages.LSC_Bootloader_Version=(float) (messages.LSC_Bootloader_Version - can.LSC_SW_VERSION_CANID_LSC_BOOTLOADER_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.LSC_Firmware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.LSC_Firmware_Version >> can.LSC_SW_VERSION_LSC_FIRMWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.LSC_Firmware_Version >> can.LSC_SW_VERSION_LSC_FIRMWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.LSC_Firmware_Version >> can.LSC_SW_VERSION_LSC_FIRMWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.LSC_Bootloader_Version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.LSC_Bootloader_Version >> can.LSC_SW_VERSION_LSC_BOOTLOADER_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.LSC_Bootloader_Version >> can.LSC_SW_VERSION_LSC_BOOTLOADER_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.LSC_Bootloader_Version >> can.LSC_SW_VERSION_LSC_BOOTLOADER_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.LSC_SW_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_IMU_Data_Y( ConverterInitialize.IMU_Data_Y_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Accelerometer_Yaxis = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Y_ACCELEROMETER_YAXIS_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Y_ACCELEROMETER_YAXIS_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Y_ACCELEROMETER_YAXIS_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.IMU_DATA_Y_ACCELEROMETER_YAXIS_FACTOR)) + (can.IMU_DATA_Y_CANID_ACCELEROMETER_YAXIS_OFFSET));
        messages.Gyroscope_Yaxis = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Y_GYROSCOPE_YAXIS_MASK0) | (( data[6] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Y_GYROSCOPE_YAXIS_MASK1) | (( data[5] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Y_GYROSCOPE_YAXIS_MASK2) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.IMU_DATA_Y_GYROSCOPE_YAXIS_FACTOR)) + (can.IMU_DATA_Y_CANID_GYROSCOPE_YAXIS_OFFSET));

        return can.IMU_DATA_Y_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_IMU_Data_Y( ConverterInitialize.IMU_Data_Y_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Accelerometer_Yaxis=(float) (messages.Accelerometer_Yaxis - can.IMU_DATA_Y_CANID_ACCELEROMETER_YAXIS_OFFSET);
        messages.Gyroscope_Yaxis=(float) (messages.Gyroscope_Yaxis - can.IMU_DATA_Y_CANID_GYROSCOPE_YAXIS_OFFSET);
        data[0] = (byte)(((byte)messages.Accelerometer_Yaxis & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Accelerometer_Yaxis >> can.IMU_DATA_Y_ACCELEROMETER_YAXIS_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.Accelerometer_Yaxis >> can.IMU_DATA_Y_ACCELEROMETER_YAXIS_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Accelerometer_Yaxis >> can.IMU_DATA_Y_ACCELEROMETER_YAXIS_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Gyroscope_Yaxis & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Gyroscope_Yaxis >> can.IMU_DATA_Y_GYROSCOPE_YAXIS_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.Gyroscope_Yaxis >> can.IMU_DATA_Y_GYROSCOPE_YAXIS_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Gyroscope_Yaxis >> can.IMU_DATA_Y_GYROSCOPE_YAXIS_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.IMU_DATA_Y_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_IC_Paramter_1( ConverterInitialize.IC_Paramter_1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.LED_Temp = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.IC_PARAMTER_1_LED_TEMP_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.IC_PARAMTER_1_LED_TEMP_FACTOR)) + (can.IC_PARAMTER_1_CANID_LED_TEMP_OFFSET));
        messages.Temp_Sensor_Input_Controller = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.IC_PARAMTER_1_TEMP_SENSOR_INPUT_CONTROLLER_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.IC_PARAMTER_1_TEMP_SENSOR_INPUT_CONTROLLER_FACTOR)) + (can.IC_PARAMTER_1_CANID_TEMP_SENSOR_INPUT_CONTROLLER_OFFSET));
        messages.MAin_Input_Supply = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.IC_PARAMTER_1_MAIN_INPUT_SUPPLY_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.IC_PARAMTER_1_MAIN_INPUT_SUPPLY_FACTOR)) + (can.IC_PARAMTER_1_CANID_MAIN_INPUT_SUPPLY_OFFSET));
        messages.Temp_Sensor_Input_Ambient = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.IC_PARAMTER_1_TEMP_SENSOR_INPUT_AMBIENT_MASK0) | ( data[6] & (can.SIGNLE_READ_Mask8))) * (can.IC_PARAMTER_1_TEMP_SENSOR_INPUT_AMBIENT_FACTOR)) + (can.IC_PARAMTER_1_CANID_TEMP_SENSOR_INPUT_AMBIENT_OFFSET));

        return can.IC_PARAMTER_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_IC_Paramter_1( ConverterInitialize.IC_Paramter_1_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.LED_Temp=(float) (messages.LED_Temp - can.IC_PARAMTER_1_CANID_LED_TEMP_OFFSET);
        messages.Temp_Sensor_Input_Controller=(float) (messages.Temp_Sensor_Input_Controller - can.IC_PARAMTER_1_CANID_TEMP_SENSOR_INPUT_CONTROLLER_OFFSET);
        messages.MAin_Input_Supply=(float) (messages.MAin_Input_Supply - can.IC_PARAMTER_1_CANID_MAIN_INPUT_SUPPLY_OFFSET);
        messages.Temp_Sensor_Input_Ambient=(float) (messages.Temp_Sensor_Input_Ambient - can.IC_PARAMTER_1_CANID_TEMP_SENSOR_INPUT_AMBIENT_OFFSET);
        data[0] = (byte)(((byte)messages.LED_Temp & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.LED_Temp >> can.IC_PARAMTER_1_LED_TEMP_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Temp_Sensor_Input_Controller & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Temp_Sensor_Input_Controller >> can.IC_PARAMTER_1_TEMP_SENSOR_INPUT_CONTROLLER_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.MAin_Input_Supply & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.MAin_Input_Supply >> can.IC_PARAMTER_1_MAIN_INPUT_SUPPLY_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Temp_Sensor_Input_Ambient & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Temp_Sensor_Input_Ambient >> can.IC_PARAMTER_1_TEMP_SENSOR_INPUT_AMBIENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.IC_PARAMTER_1_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ICM_Digital_Input( ConverterInitialize.ICM_Digital_Input_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Backlight_Driver_Fault_Input = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.ICM_DIGITAL_INPUT_BACKLIGHT_DRIVER_FAULT_INPUT_FACTOR)) + (can.ICM_DIGITAL_INPUT_CANID_BACKLIGHT_DRIVER_FAULT_INPUT_OFFSET));
        messages.Ambient_Light_Sensor_Interrupt = (float)(((((data[0] >> can.ICM_DIGITAL_INPUT_AMBIENT_LIGHT_SENSOR_INTERRUPT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ICM_DIGITAL_INPUT_AMBIENT_LIGHT_SENSOR_INTERRUPT_FACTOR)) + (can.ICM_DIGITAL_INPUT_CANID_AMBIENT_LIGHT_SENSOR_INTERRUPT_OFFSET));
        messages.Ambient_Temp_Sensor_Interrupt = (float)(((((data[0] >> can.ICM_DIGITAL_INPUT_AMBIENT_TEMP_SENSOR_INTERRUPT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ICM_DIGITAL_INPUT_AMBIENT_TEMP_SENSOR_INTERRUPT_FACTOR)) + (can.ICM_DIGITAL_INPUT_CANID_AMBIENT_TEMP_SENSOR_INTERRUPT_OFFSET));
        messages.Warning_Status = (float)(((((data[0] >> can.ICM_DIGITAL_INPUT_WARNING_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ICM_DIGITAL_INPUT_WARNING_STATUS_FACTOR)) + (can.ICM_DIGITAL_INPUT_CANID_WARNING_STATUS_OFFSET));
        messages.Error_Status = (float)(((((data[0] >> can.ICM_DIGITAL_INPUT_ERROR_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ICM_DIGITAL_INPUT_ERROR_STATUS_FACTOR)) + (can.ICM_DIGITAL_INPUT_CANID_ERROR_STATUS_OFFSET));
        messages.Warning_Counter = (float)((((data[1] & (can.SIGNLE_READ_Mask8))) * (can.ICM_DIGITAL_INPUT_WARNING_COUNTER_FACTOR)) + (can.ICM_DIGITAL_INPUT_CANID_WARNING_COUNTER_OFFSET));
        messages.Error_Counter = (float)((((data[2] & (can.SIGNLE_READ_Mask8))) * (can.ICM_DIGITAL_INPUT_ERROR_COUNTER_FACTOR)) + (can.ICM_DIGITAL_INPUT_CANID_ERROR_COUNTER_OFFSET));
        messages.Reset_Counter = (float)((((data[3] & (can.SIGNLE_READ_Mask8))) * (can.ICM_DIGITAL_INPUT_RESET_COUNTER_FACTOR)) + (can.ICM_DIGITAL_INPUT_CANID_RESET_COUNTER_OFFSET));

        return can.ICM_DIGITAL_INPUT_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ICM_Digital_Input( ConverterInitialize.ICM_Digital_Input_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Backlight_Driver_Fault_Input=(float) (messages.Backlight_Driver_Fault_Input - can.ICM_DIGITAL_INPUT_CANID_BACKLIGHT_DRIVER_FAULT_INPUT_OFFSET);
        messages.Ambient_Light_Sensor_Interrupt=(float) (messages.Ambient_Light_Sensor_Interrupt - can.ICM_DIGITAL_INPUT_CANID_AMBIENT_LIGHT_SENSOR_INTERRUPT_OFFSET);
        messages.Ambient_Temp_Sensor_Interrupt=(float) (messages.Ambient_Temp_Sensor_Interrupt - can.ICM_DIGITAL_INPUT_CANID_AMBIENT_TEMP_SENSOR_INTERRUPT_OFFSET);
        messages.Warning_Status=(float) (messages.Warning_Status - can.ICM_DIGITAL_INPUT_CANID_WARNING_STATUS_OFFSET);
        messages.Error_Status=(float) (messages.Error_Status - can.ICM_DIGITAL_INPUT_CANID_ERROR_STATUS_OFFSET);
        messages.Warning_Counter=(float) (messages.Warning_Counter - can.ICM_DIGITAL_INPUT_CANID_WARNING_COUNTER_OFFSET);
        messages.Error_Counter=(float) (messages.Error_Counter - can.ICM_DIGITAL_INPUT_CANID_ERROR_COUNTER_OFFSET);
        messages.Reset_Counter=(float) (messages.Reset_Counter - can.ICM_DIGITAL_INPUT_CANID_RESET_COUNTER_OFFSET);
        data[0] = (byte)(((byte)messages.Backlight_Driver_Fault_Input & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Ambient_Light_Sensor_Interrupt & ( can.SIGNLE_READ_Mask1)) << can.ICM_DIGITAL_INPUT_AMBIENT_LIGHT_SENSOR_INTERRUPT_MASK0) | (((byte)messages.Ambient_Temp_Sensor_Interrupt & ( can.SIGNLE_READ_Mask1)) << can.ICM_DIGITAL_INPUT_AMBIENT_TEMP_SENSOR_INTERRUPT_MASK0) | (((byte)messages.Warning_Status & ( can.SIGNLE_READ_Mask1)) << can.ICM_DIGITAL_INPUT_WARNING_STATUS_MASK0) | (((byte)messages.Error_Status & ( can.SIGNLE_READ_Mask1)) << can.ICM_DIGITAL_INPUT_ERROR_STATUS_MASK0));
        data[1] = (byte)(((byte)messages.Warning_Counter & ( can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Error_Counter & ( can.SIGNLE_READ_Mask8)));
        data[3] = (byte)(((byte)messages.Reset_Counter & ( can.SIGNLE_READ_Mask8)));
        return can.ICM_DIGITAL_INPUT_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_IMU_Data_Z( ConverterInitialize.IMU_Data_Z_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Accelerometer_Zaxis = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Z_ACCELEROMETER_ZAXIS_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Z_ACCELEROMETER_ZAXIS_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Z_ACCELEROMETER_ZAXIS_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.IMU_DATA_Z_ACCELEROMETER_ZAXIS_FACTOR)) + (can.IMU_DATA_Z_CANID_ACCELEROMETER_ZAXIS_OFFSET));
        messages.Gyroscope_Zaxis = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Z_GYROSCOPE_ZAXIS_MASK0) | (( data[6] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Z_GYROSCOPE_ZAXIS_MASK1) | (( data[5] & (can.SIGNLE_READ_Mask8)) << can.IMU_DATA_Z_GYROSCOPE_ZAXIS_MASK2) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.IMU_DATA_Z_GYROSCOPE_ZAXIS_FACTOR)) + (can.IMU_DATA_Z_CANID_GYROSCOPE_ZAXIS_OFFSET));

        return can.IMU_DATA_Z_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_IMU_Data_Z( ConverterInitialize.IMU_Data_Z_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Accelerometer_Zaxis=(float) (messages.Accelerometer_Zaxis - can.IMU_DATA_Z_CANID_ACCELEROMETER_ZAXIS_OFFSET);
        messages.Gyroscope_Zaxis=(float) (messages.Gyroscope_Zaxis - can.IMU_DATA_Z_CANID_GYROSCOPE_ZAXIS_OFFSET);
        data[0] = (byte)(((byte)messages.Accelerometer_Zaxis & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Accelerometer_Zaxis >> can.IMU_DATA_Z_ACCELEROMETER_ZAXIS_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.Accelerometer_Zaxis >> can.IMU_DATA_Z_ACCELEROMETER_ZAXIS_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Accelerometer_Zaxis >> can.IMU_DATA_Z_ACCELEROMETER_ZAXIS_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Gyroscope_Zaxis & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Gyroscope_Zaxis >> can.IMU_DATA_Z_GYROSCOPE_ZAXIS_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.Gyroscope_Zaxis >> can.IMU_DATA_Z_GYROSCOPE_ZAXIS_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Gyroscope_Zaxis >> can.IMU_DATA_Z_GYROSCOPE_ZAXIS_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.IMU_DATA_Z_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_SOFTWARE_VERSIONS( ConverterInitialize.BMS_SOFTWARE_VERSIONS_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Firmware_Version = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_SOFTWARE_VERSIONS_BMS_FIRMWARE_VERSION_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.BMS_SOFTWARE_VERSIONS_BMS_FIRMWARE_VERSION_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_SOFTWARE_VERSIONS_BMS_FIRMWARE_VERSION_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BMS_SOFTWARE_VERSIONS_BMS_FIRMWARE_VERSION_FACTOR)) + (can.BMS_SOFTWARE_VERSIONS_CANID_BMS_FIRMWARE_VERSION_OFFSET));
        messages.BMS_Bootloader_Version = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_SOFTWARE_VERSIONS_BMS_BOOTLOADER_VERSION_MASK0) | (( data[6] & (can.SIGNLE_READ_Mask8)) << can.BMS_SOFTWARE_VERSIONS_BMS_BOOTLOADER_VERSION_MASK1) | (( data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_SOFTWARE_VERSIONS_BMS_BOOTLOADER_VERSION_MASK2) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.BMS_SOFTWARE_VERSIONS_BMS_BOOTLOADER_VERSION_FACTOR)) + (can.BMS_SOFTWARE_VERSIONS_CANID_BMS_BOOTLOADER_VERSION_OFFSET));

        return can.BMS_SOFTWARE_VERSIONS_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_SOFTWARE_VERSIONS( ConverterInitialize.BMS_SOFTWARE_VERSIONS_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Firmware_Version=(float) (messages.BMS_Firmware_Version - can.BMS_SOFTWARE_VERSIONS_CANID_BMS_FIRMWARE_VERSION_OFFSET);
        messages.BMS_Bootloader_Version=(float) (messages.BMS_Bootloader_Version - can.BMS_SOFTWARE_VERSIONS_CANID_BMS_BOOTLOADER_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.BMS_Firmware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.BMS_Firmware_Version >> can.BMS_SOFTWARE_VERSIONS_BMS_FIRMWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.BMS_Firmware_Version >> can.BMS_SOFTWARE_VERSIONS_BMS_FIRMWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.BMS_Firmware_Version >> can.BMS_SOFTWARE_VERSIONS_BMS_FIRMWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.BMS_Bootloader_Version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.BMS_Bootloader_Version >> can.BMS_SOFTWARE_VERSIONS_BMS_BOOTLOADER_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.BMS_Bootloader_Version >> can.BMS_SOFTWARE_VERSIONS_BMS_BOOTLOADER_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.BMS_Bootloader_Version >> can.BMS_SOFTWARE_VERSIONS_BMS_BOOTLOADER_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_SOFTWARE_VERSIONS_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ABS_Software_Version( ConverterInitialize.ABS_Software_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Firmware_version = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.ABS_SOFTWARE_VERSION_ABS_FIRMWARE_VERSION_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.ABS_SOFTWARE_VERSION_ABS_FIRMWARE_VERSION_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.ABS_SOFTWARE_VERSION_ABS_FIRMWARE_VERSION_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.ABS_SOFTWARE_VERSION_ABS_FIRMWARE_VERSION_FACTOR)) + (can.ABS_SOFTWARE_VERSION_CANID_ABS_FIRMWARE_VERSION_OFFSET));
        messages.ABS_Bootloader_version = (float)((((( data[7] & (can.SIGNLE_READ_Mask8)) << can.ABS_SOFTWARE_VERSION_ABS_BOOTLOADER_VERSION_MASK0) | (( data[6] & (can.SIGNLE_READ_Mask8)) << can.ABS_SOFTWARE_VERSION_ABS_BOOTLOADER_VERSION_MASK1) | (( data[5] & (can.SIGNLE_READ_Mask8)) << can.ABS_SOFTWARE_VERSION_ABS_BOOTLOADER_VERSION_MASK2) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.ABS_SOFTWARE_VERSION_ABS_BOOTLOADER_VERSION_FACTOR)) + (can.ABS_SOFTWARE_VERSION_CANID_ABS_BOOTLOADER_VERSION_OFFSET));

        return can.ABS_SOFTWARE_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ABS_Software_Version( ConverterInitialize.ABS_Software_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Firmware_version=(float) (messages.ABS_Firmware_version - can.ABS_SOFTWARE_VERSION_CANID_ABS_FIRMWARE_VERSION_OFFSET);
        messages.ABS_Bootloader_version=(float) (messages.ABS_Bootloader_version - can.ABS_SOFTWARE_VERSION_CANID_ABS_BOOTLOADER_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.ABS_Firmware_version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.ABS_Firmware_version >> can.ABS_SOFTWARE_VERSION_ABS_FIRMWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.ABS_Firmware_version >> can.ABS_SOFTWARE_VERSION_ABS_FIRMWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.ABS_Firmware_version >> can.ABS_SOFTWARE_VERSION_ABS_FIRMWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.ABS_Bootloader_version & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.ABS_Bootloader_version >> can.ABS_SOFTWARE_VERSION_ABS_BOOTLOADER_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.ABS_Bootloader_version >> can.ABS_SOFTWARE_VERSION_ABS_BOOTLOADER_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.ABS_Bootloader_version >> can.ABS_SOFTWARE_VERSION_ABS_BOOTLOADER_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ABS_SOFTWARE_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_HARDWARE_VERSION( ConverterInitialize.BMS_HARDWARE_VERSION_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Hardware_Version = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_HARDWARE_VERSION_BMS_HARDWARE_VERSION_MASK0) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.BMS_HARDWARE_VERSION_BMS_HARDWARE_VERSION_MASK1) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_HARDWARE_VERSION_BMS_HARDWARE_VERSION_MASK2) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BMS_HARDWARE_VERSION_BMS_HARDWARE_VERSION_FACTOR)) + (can.BMS_HARDWARE_VERSION_CANID_BMS_HARDWARE_VERSION_OFFSET));

        return can.BMS_HARDWARE_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_HARDWARE_VERSION( ConverterInitialize.BMS_HARDWARE_VERSION_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Hardware_Version=(float) (messages.BMS_Hardware_Version - can.BMS_HARDWARE_VERSION_CANID_BMS_HARDWARE_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.BMS_Hardware_Version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.BMS_Hardware_Version >> can.BMS_HARDWARE_VERSION_BMS_HARDWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.BMS_Hardware_Version >> can.BMS_HARDWARE_VERSION_BMS_HARDWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.BMS_Hardware_Version >> can.BMS_HARDWARE_VERSION_BMS_HARDWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_HARDWARE_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ABS_Hardware_Version( ConverterInitialize.ABS_Hardware_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Hardware_version = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_FACTOR)) + (can.ABS_HARDWARE_VERSION_CANID_ABS_HARDWARE_VERSION_OFFSET));

        return can.ABS_HARDWARE_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ABS_Hardware_Version( ConverterInitialize.ABS_Hardware_Version_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Hardware_version=(double) (messages.ABS_Hardware_version - can.ABS_HARDWARE_VERSION_CANID_ABS_HARDWARE_VERSION_OFFSET);
        data[0] = (byte)(((byte)messages.ABS_Hardware_version & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.ABS_Hardware_version >> can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.ABS_Hardware_version >> can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.ABS_Hardware_version >> can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.ABS_Hardware_version >> can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.ABS_Hardware_version >> can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.ABS_Hardware_version >> can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.ABS_Hardware_version >> can.ABS_HARDWARE_VERSION_ABS_HARDWARE_VERSION_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ABS_HARDWARE_VERSION_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_Diagnostic_Request( ConverterInitialize.BMS_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Diag_Request = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_FACTOR)) + (can.BMS_DIAGNOSTIC_REQUEST_CANID_BMS_DIAG_REQUEST_OFFSET));

        return can.BMS_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_Diagnostic_Request( ConverterInitialize.BMS_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Diag_Request=(double) (messages.BMS_Diag_Request - can.BMS_DIAGNOSTIC_REQUEST_CANID_BMS_DIAG_REQUEST_OFFSET);
        data[0] = (byte)(((byte)messages.BMS_Diag_Request & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.BMS_Diag_Request >> can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.BMS_Diag_Request >> can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.BMS_Diag_Request >> can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.BMS_Diag_Request >> can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.BMS_Diag_Request >> can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.BMS_Diag_Request >> can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.BMS_Diag_Request >> can.BMS_DIAGNOSTIC_REQUEST_BMS_DIAG_REQUEST_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BMS_Diagnostic_Response( ConverterInitialize.BMS_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Diag_Resp = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_FACTOR)) + (can.BMS_DIAGNOSTIC_RESPONSE_CANID_BMS_DIAG_RESP_OFFSET));

        return can.BMS_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BMS_Diagnostic_Response( ConverterInitialize.BMS_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BMS_Diag_Resp=(double) (messages.BMS_Diag_Resp - can.BMS_DIAGNOSTIC_RESPONSE_CANID_BMS_DIAG_RESP_OFFSET);
        data[0] = (byte)(((byte)messages.BMS_Diag_Resp & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.BMS_Diag_Resp >> can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.BMS_Diag_Resp >> can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.BMS_Diag_Resp >> can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.BMS_Diag_Resp >> can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.BMS_Diag_Resp >> can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.BMS_Diag_Resp >> can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.BMS_Diag_Resp >> can.BMS_DIAGNOSTIC_RESPONSE_BMS_DIAG_RESP_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BMS_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OTA_Status( ConverterInitialize.OTA_Status_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OTA_Status_Info = (float)((((data[0] & (can.SIGNLE_READ_Mask2))) * (can.OTA_STATUS_OTA_STATUS_INFO_FACTOR)) + (can.OTA_STATUS_CANID_OTA_STATUS_INFO_OFFSET));

        return can.OTA_STATUS_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OTA_Status( ConverterInitialize.OTA_Status_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OTA_Status_Info=(float) (messages.OTA_Status_Info - can.OTA_STATUS_CANID_OTA_STATUS_INFO_OFFSET);
        data[0] = (byte)(((byte)messages.OTA_Status_Info & ( can.SIGNLE_READ_Mask2)));
        return can.OTA_STATUS_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Vehicle_left_SW_Cube( ConverterInitialize.Vehicle_left_SW_Cube_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.High_beam = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_HIGH_BEAM_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_HIGH_BEAM_OFFSET));
        messages.Low_beam = (float)(((((data[0] >> can.VEHICLE_LEFT_SW_CUBE_LOW_BEAM_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_LOW_BEAM_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_LOW_BEAM_OFFSET));
        messages.Pass_beam = (float)(((((data[0] >> can.VEHICLE_LEFT_SW_CUBE_PASS_BEAM_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_PASS_BEAM_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_PASS_BEAM_OFFSET));
        messages.Left_Indicator = (float)(((((data[0] >> can.VEHICLE_LEFT_SW_CUBE_LEFT_INDICATOR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_LEFT_INDICATOR_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_LEFT_INDICATOR_OFFSET));
        messages.Cruise_Control = (float)(((((data[0] >> can.VEHICLE_LEFT_SW_CUBE_CRUISE_CONTROL_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_CRUISE_CONTROL_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_CRUISE_CONTROL_OFFSET));
        messages.Right_Indicator = (float)(((((data[0] >> can.VEHICLE_LEFT_SW_CUBE_RIGHT_INDICATOR_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_RIGHT_INDICATOR_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_RIGHT_INDICATOR_OFFSET));
        messages.Horn = (float)(((((data[0] >> can.VEHICLE_LEFT_SW_CUBE_HORN_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_HORN_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_HORN_OFFSET));
        messages.Eco_Mode = (float)(((((data[0] >> can.VEHICLE_LEFT_SW_CUBE_ECO_MODE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_ECO_MODE_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_ECO_MODE_OFFSET));
        messages.Tour_Mode = (float)((((data[1] & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_TOUR_MODE_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_TOUR_MODE_OFFSET));
        messages.Sports_Mode = (float)(((((data[1] >> can.VEHICLE_LEFT_SW_CUBE_SPORTS_MODE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_SPORTS_MODE_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_SPORTS_MODE_OFFSET));
        messages.Turbo_mode = (float)(((((data[1] >> can.VEHICLE_LEFT_SW_CUBE_TURBO_MODE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_TURBO_MODE_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_TURBO_MODE_OFFSET));
        messages.Neutral = (float)(((((data[1] >> can.VEHICLE_LEFT_SW_CUBE_NEUTRAL_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_NEUTRAL_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_NEUTRAL_OFFSET));
        messages.Park_Assist = (float)(((((data[1] >> can.VEHICLE_LEFT_SW_CUBE_PARK_ASSIST_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_PARK_ASSIST_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_PARK_ASSIST_OFFSET));
        messages.Home = (float)(((((data[1] >> can.VEHICLE_LEFT_SW_CUBE_HOME_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_HOME_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_HOME_OFFSET));
        messages.Joystick_Up = (float)((((data[2] & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_UP_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_UP_OFFSET));
        messages.Joystick_Down = (float)(((((data[2] >> can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_DOWN_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_DOWN_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_DOWN_OFFSET));
        messages.Joystick_Left = (float)(((((data[2] >> can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_LEFT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_LEFT_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_LEFT_OFFSET));
        messages.Joystick_Right = (float)(((((data[2] >> can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_RIGHT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_RIGHT_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_RIGHT_OFFSET));
        messages.Joystick_SET_RST = (float)(((((data[2] >> can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_SET_RST_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_SET_RST_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_SET_RST_OFFSET));
        messages.LSC_Power_Status = (float)(((((data[2] >> can.VEHICLE_LEFT_SW_CUBE_LSC_POWER_STATUS_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_LSC_POWER_STATUS_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_LSC_POWER_STATUS_OFFSET));
        messages.Joystick_fault = (float)(((((data[2] >> can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_FAULT_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_FAULT_OFFSET));
        messages.Mode_Selector_Roller_fault = (float)(((((data[2] >> can.VEHICLE_LEFT_SW_CUBE_MODE_SELECTOR_ROLLER_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_MODE_SELECTOR_ROLLER_FAULT_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_MODE_SELECTOR_ROLLER_FAULT_OFFSET));
        messages.Left_Indicator_Button_fault = (float)((((data[3] & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_LEFT_INDICATOR_BUTTON_FAULT_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_LEFT_INDICATOR_BUTTON_FAULT_OFFSET));
        messages.Cruise_Control_Button_fault = (float)(((((data[3] >> can.VEHICLE_LEFT_SW_CUBE_CRUISE_CONTROL_BUTTON_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_CRUISE_CONTROL_BUTTON_FAULT_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_CRUISE_CONTROL_BUTTON_FAULT_OFFSET));
        messages.Horn_Button_fault = (float)(((((data[3] >> can.VEHICLE_LEFT_SW_CUBE_HORN_BUTTON_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_HORN_BUTTON_FAULT_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_HORN_BUTTON_FAULT_OFFSET));
        messages.Home_Button_fault = (float)(((((data[3] >> can.VEHICLE_LEFT_SW_CUBE_HOME_BUTTON_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_HOME_BUTTON_FAULT_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_HOME_BUTTON_FAULT_OFFSET));
        messages.LSC_System_fault = (float)(((((data[3] >> can.VEHICLE_LEFT_SW_CUBE_LSC_SYSTEM_FAULT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_LEFT_SW_CUBE_LSC_SYSTEM_FAULT_FACTOR)) + (can.VEHICLE_LEFT_SW_CUBE_CANID_LSC_SYSTEM_FAULT_OFFSET));

        return can.VEHICLE_LEFT_SW_CUBE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Vehicle_left_SW_Cube( ConverterInitialize.Vehicle_left_SW_Cube_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.High_beam=(float) (messages.High_beam - can.VEHICLE_LEFT_SW_CUBE_CANID_HIGH_BEAM_OFFSET);
        messages.Low_beam=(float) (messages.Low_beam - can.VEHICLE_LEFT_SW_CUBE_CANID_LOW_BEAM_OFFSET);
        messages.Pass_beam=(float) (messages.Pass_beam - can.VEHICLE_LEFT_SW_CUBE_CANID_PASS_BEAM_OFFSET);
        messages.Left_Indicator=(float) (messages.Left_Indicator - can.VEHICLE_LEFT_SW_CUBE_CANID_LEFT_INDICATOR_OFFSET);
        messages.Cruise_Control=(float) (messages.Cruise_Control - can.VEHICLE_LEFT_SW_CUBE_CANID_CRUISE_CONTROL_OFFSET);
        messages.Right_Indicator=(float) (messages.Right_Indicator - can.VEHICLE_LEFT_SW_CUBE_CANID_RIGHT_INDICATOR_OFFSET);
        messages.Horn=(float) (messages.Horn - can.VEHICLE_LEFT_SW_CUBE_CANID_HORN_OFFSET);
        messages.Eco_Mode=(float) (messages.Eco_Mode - can.VEHICLE_LEFT_SW_CUBE_CANID_ECO_MODE_OFFSET);
        messages.Tour_Mode=(float) (messages.Tour_Mode - can.VEHICLE_LEFT_SW_CUBE_CANID_TOUR_MODE_OFFSET);
        messages.Sports_Mode=(float) (messages.Sports_Mode - can.VEHICLE_LEFT_SW_CUBE_CANID_SPORTS_MODE_OFFSET);
        messages.Turbo_mode=(float) (messages.Turbo_mode - can.VEHICLE_LEFT_SW_CUBE_CANID_TURBO_MODE_OFFSET);
        messages.Neutral=(float) (messages.Neutral - can.VEHICLE_LEFT_SW_CUBE_CANID_NEUTRAL_OFFSET);
        messages.Park_Assist=(float) (messages.Park_Assist - can.VEHICLE_LEFT_SW_CUBE_CANID_PARK_ASSIST_OFFSET);
        messages.Home=(float) (messages.Home - can.VEHICLE_LEFT_SW_CUBE_CANID_HOME_OFFSET);
        messages.Joystick_Up=(float) (messages.Joystick_Up - can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_UP_OFFSET);
        messages.Joystick_Down=(float) (messages.Joystick_Down - can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_DOWN_OFFSET);
        messages.Joystick_Left=(float) (messages.Joystick_Left - can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_LEFT_OFFSET);
        messages.Joystick_Right=(float) (messages.Joystick_Right - can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_RIGHT_OFFSET);
        messages.Joystick_SET_RST=(float) (messages.Joystick_SET_RST - can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_SET_RST_OFFSET);
        messages.LSC_Power_Status=(float) (messages.LSC_Power_Status - can.VEHICLE_LEFT_SW_CUBE_CANID_LSC_POWER_STATUS_OFFSET);
        messages.Joystick_fault=(float) (messages.Joystick_fault - can.VEHICLE_LEFT_SW_CUBE_CANID_JOYSTICK_FAULT_OFFSET);
        messages.Mode_Selector_Roller_fault=(float) (messages.Mode_Selector_Roller_fault - can.VEHICLE_LEFT_SW_CUBE_CANID_MODE_SELECTOR_ROLLER_FAULT_OFFSET);
        messages.Left_Indicator_Button_fault=(float) (messages.Left_Indicator_Button_fault - can.VEHICLE_LEFT_SW_CUBE_CANID_LEFT_INDICATOR_BUTTON_FAULT_OFFSET);
        messages.Cruise_Control_Button_fault=(float) (messages.Cruise_Control_Button_fault - can.VEHICLE_LEFT_SW_CUBE_CANID_CRUISE_CONTROL_BUTTON_FAULT_OFFSET);
        messages.Horn_Button_fault=(float) (messages.Horn_Button_fault - can.VEHICLE_LEFT_SW_CUBE_CANID_HORN_BUTTON_FAULT_OFFSET);
        messages.Home_Button_fault=(float) (messages.Home_Button_fault - can.VEHICLE_LEFT_SW_CUBE_CANID_HOME_BUTTON_FAULT_OFFSET);
        messages.LSC_System_fault=(float) (messages.LSC_System_fault - can.VEHICLE_LEFT_SW_CUBE_CANID_LSC_SYSTEM_FAULT_OFFSET);
        data[0] = (byte)(((byte)messages.High_beam & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Low_beam & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_LOW_BEAM_MASK0) | (((byte)messages.Pass_beam & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_PASS_BEAM_MASK0) | (((byte)messages.Left_Indicator & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_LEFT_INDICATOR_MASK0) | (((byte)messages.Cruise_Control & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_CRUISE_CONTROL_MASK0) | (((byte)messages.Right_Indicator & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_RIGHT_INDICATOR_MASK0) | (((byte)messages.Horn & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_HORN_MASK0) | (((byte)messages.Eco_Mode & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_ECO_MODE_MASK0));
        data[1] = (byte)(((byte)messages.Tour_Mode & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Sports_Mode & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_SPORTS_MODE_MASK0) | (((byte)messages.Turbo_mode & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_TURBO_MODE_MASK0) | (((byte)messages.Neutral & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_NEUTRAL_MASK0) | (((byte)messages.Park_Assist & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_PARK_ASSIST_MASK0) | (((byte)messages.Home & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_HOME_MASK0));
        data[2] = (byte)(((byte)messages.Joystick_Up & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Joystick_Down & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_DOWN_MASK0) | (((byte)messages.Joystick_Left & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_LEFT_MASK0) | (((byte)messages.Joystick_Right & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_RIGHT_MASK0) | (((byte)messages.Joystick_SET_RST & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_SET_RST_MASK0) | (((byte)messages.LSC_Power_Status & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_LSC_POWER_STATUS_MASK0) | (((byte)messages.Joystick_fault & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_JOYSTICK_FAULT_MASK0) | (((byte)messages.Mode_Selector_Roller_fault & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_MODE_SELECTOR_ROLLER_FAULT_MASK0));
        data[3] = (byte)(((byte)messages.Left_Indicator_Button_fault & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Cruise_Control_Button_fault & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_CRUISE_CONTROL_BUTTON_FAULT_MASK0) | (((byte)messages.Horn_Button_fault & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_HORN_BUTTON_FAULT_MASK0) | (((byte)messages.Home_Button_fault & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_HOME_BUTTON_FAULT_MASK0) | (((byte)messages.LSC_System_fault & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_LEFT_SW_CUBE_LSC_SYSTEM_FAULT_MASK0));
        return can.VEHICLE_LEFT_SW_CUBE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Vehicle_Right_SW_Cube( ConverterInitialize.Vehicle_Right_SW_Cube_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Voice_Assist = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_RIGHT_SW_CUBE_VOICE_ASSIST_FACTOR)) + (can.VEHICLE_RIGHT_SW_CUBE_CANID_VOICE_ASSIST_OFFSET));
        messages.Regen = (float)(((((data[0] >> can.VEHICLE_RIGHT_SW_CUBE_REGEN_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_RIGHT_SW_CUBE_REGEN_FACTOR)) + (can.VEHICLE_RIGHT_SW_CUBE_CANID_REGEN_OFFSET));
        messages.Key_Ignition = (float)(((((data[0] >> can.VEHICLE_RIGHT_SW_CUBE_KEY_IGNITION_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_RIGHT_SW_CUBE_KEY_IGNITION_FACTOR)) + (can.VEHICLE_RIGHT_SW_CUBE_CANID_KEY_IGNITION_OFFSET));
        messages.Start_Button = (float)((((data[1] & (can.SIGNLE_READ_Mask1))) * (can.VEHICLE_RIGHT_SW_CUBE_START_BUTTON_FACTOR)) + (can.VEHICLE_RIGHT_SW_CUBE_CANID_START_BUTTON_OFFSET));

        return can.VEHICLE_RIGHT_SW_CUBE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Vehicle_Right_SW_Cube( ConverterInitialize.Vehicle_Right_SW_Cube_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Voice_Assist=(float) (messages.Voice_Assist - can.VEHICLE_RIGHT_SW_CUBE_CANID_VOICE_ASSIST_OFFSET);
        messages.Regen=(float) (messages.Regen - can.VEHICLE_RIGHT_SW_CUBE_CANID_REGEN_OFFSET);
        messages.Key_Ignition=(float) (messages.Key_Ignition - can.VEHICLE_RIGHT_SW_CUBE_CANID_KEY_IGNITION_OFFSET);
        messages.Start_Button=(float) (messages.Start_Button - can.VEHICLE_RIGHT_SW_CUBE_CANID_START_BUTTON_OFFSET);
        data[0] = (byte)(((byte)messages.Voice_Assist & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Regen & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_RIGHT_SW_CUBE_REGEN_MASK0) | (((byte)messages.Key_Ignition & ( can.SIGNLE_READ_Mask1)) << can.VEHICLE_RIGHT_SW_CUBE_KEY_IGNITION_MASK0));
        data[1] = (byte)(((byte)messages.Start_Button & ( can.SIGNLE_READ_Mask1)));
        return can.VEHICLE_RIGHT_SW_CUBE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ICM_Error( ConverterInitialize.ICM_Error_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Input_OverVoltage = (float)((((data[0] & (can.SIGNLE_READ_Mask1))) * (can.ICM_ERROR_INPUT_OVERVOLTAGE_FACTOR)) + (can.ICM_ERROR_CANID_INPUT_OVERVOLTAGE_OFFSET));
        messages.Input_UncerVoltage = (float)(((((data[0] >> can.ICM_ERROR_INPUT_UNCERVOLTAGE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ICM_ERROR_INPUT_UNCERVOLTAGE_FACTOR)) + (can.ICM_ERROR_CANID_INPUT_UNCERVOLTAGE_OFFSET));
        messages.Input_OverCurrent = (float)(((((data[0] >> can.ICM_ERROR_INPUT_OVERCURRENT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ICM_ERROR_INPUT_OVERCURRENT_FACTOR)) + (can.ICM_ERROR_CANID_INPUT_OVERCURRENT_OFFSET));
        messages.Output_OverCurrent = (float)(((((data[0] >> can.ICM_ERROR_OUTPUT_OVERCURRENT_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ICM_ERROR_OUTPUT_OVERCURRENT_FACTOR)) + (can.ICM_ERROR_CANID_OUTPUT_OVERCURRENT_OFFSET));
        messages.High_Temp = (float)(((((data[0] >> can.ICM_ERROR_HIGH_TEMP_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ICM_ERROR_HIGH_TEMP_FACTOR)) + (can.ICM_ERROR_CANID_HIGH_TEMP_OFFSET));
        messages.Low_Temp = (float)(((((data[0] >> can.ICM_ERROR_LOW_TEMP_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ICM_ERROR_LOW_TEMP_FACTOR)) + (can.ICM_ERROR_CANID_LOW_TEMP_OFFSET));
        messages.Temp_Sensor_Failure = (float)(((((data[0] >> can.ICM_ERROR_TEMP_SENSOR_FAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ICM_ERROR_TEMP_SENSOR_FAILURE_FACTOR)) + (can.ICM_ERROR_CANID_TEMP_SENSOR_FAILURE_OFFSET));
        messages.Output_Short_Circuit_Failure = (float)(((((data[0] >> can.ICM_ERROR_OUTPUT_SHORT_CIRCUIT_FAILURE_MASK0) & (can.SIGNLE_READ_Mask1))) * (can.ICM_ERROR_OUTPUT_SHORT_CIRCUIT_FAILURE_FACTOR)) + (can.ICM_ERROR_CANID_OUTPUT_SHORT_CIRCUIT_FAILURE_OFFSET));
        messages.Reserved = (float)((((data[1] & (can.SIGNLE_READ_Mask1))) * (can.ICM_ERROR_RESERVED_FACTOR)) + (can.ICM_ERROR_CANID_RESERVED_OFFSET));

        return can.ICM_ERROR_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ICM_Error( ConverterInitialize.ICM_Error_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Input_OverVoltage=(float) (messages.Input_OverVoltage - can.ICM_ERROR_CANID_INPUT_OVERVOLTAGE_OFFSET);
        messages.Input_UncerVoltage=(float) (messages.Input_UncerVoltage - can.ICM_ERROR_CANID_INPUT_UNCERVOLTAGE_OFFSET);
        messages.Input_OverCurrent=(float) (messages.Input_OverCurrent - can.ICM_ERROR_CANID_INPUT_OVERCURRENT_OFFSET);
        messages.Output_OverCurrent=(float) (messages.Output_OverCurrent - can.ICM_ERROR_CANID_OUTPUT_OVERCURRENT_OFFSET);
        messages.High_Temp=(float) (messages.High_Temp - can.ICM_ERROR_CANID_HIGH_TEMP_OFFSET);
        messages.Low_Temp=(float) (messages.Low_Temp - can.ICM_ERROR_CANID_LOW_TEMP_OFFSET);
        messages.Temp_Sensor_Failure=(float) (messages.Temp_Sensor_Failure - can.ICM_ERROR_CANID_TEMP_SENSOR_FAILURE_OFFSET);
        messages.Output_Short_Circuit_Failure=(float) (messages.Output_Short_Circuit_Failure - can.ICM_ERROR_CANID_OUTPUT_SHORT_CIRCUIT_FAILURE_OFFSET);
        messages.Reserved=(float) (messages.Reserved - can.ICM_ERROR_CANID_RESERVED_OFFSET);
        data[0] = (byte)(((byte)messages.Input_OverVoltage & ( can.SIGNLE_READ_Mask1)) | (((byte)messages.Input_UncerVoltage & ( can.SIGNLE_READ_Mask1)) << can.ICM_ERROR_INPUT_UNCERVOLTAGE_MASK0) | (((byte)messages.Input_OverCurrent & ( can.SIGNLE_READ_Mask1)) << can.ICM_ERROR_INPUT_OVERCURRENT_MASK0) | (((byte)messages.Output_OverCurrent & ( can.SIGNLE_READ_Mask1)) << can.ICM_ERROR_OUTPUT_OVERCURRENT_MASK0) | (((byte)messages.High_Temp & ( can.SIGNLE_READ_Mask1)) << can.ICM_ERROR_HIGH_TEMP_MASK0) | (((byte)messages.Low_Temp & ( can.SIGNLE_READ_Mask1)) << can.ICM_ERROR_LOW_TEMP_MASK0) | (((byte)messages.Temp_Sensor_Failure & ( can.SIGNLE_READ_Mask1)) << can.ICM_ERROR_TEMP_SENSOR_FAILURE_MASK0) | (((byte)messages.Output_Short_Circuit_Failure & ( can.SIGNLE_READ_Mask1)) << can.ICM_ERROR_OUTPUT_SHORT_CIRCUIT_FAILURE_MASK0));
        data[1] = (byte)(((byte)messages.Reserved & ( can.SIGNLE_READ_Mask1)));
        return can.ICM_ERROR_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_TimeStamp_Sync_Message( ConverterInitialize.TimeStamp_Sync_Message_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_TimeStamp = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_FACTOR)) + (can.TIMESTAMP_SYNC_MESSAGE_CANID_VCU_TIMESTAMP_OFFSET));

        return can.TIMESTAMP_SYNC_MESSAGE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_TimeStamp_Sync_Message( ConverterInitialize.TimeStamp_Sync_Message_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.VCU_TimeStamp=(double) (messages.VCU_TimeStamp - can.TIMESTAMP_SYNC_MESSAGE_CANID_VCU_TIMESTAMP_OFFSET);
        data[0] = (byte)(((byte)messages.VCU_TimeStamp & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.VCU_TimeStamp >> can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.VCU_TimeStamp >> can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.VCU_TimeStamp >> can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.VCU_TimeStamp >> can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.VCU_TimeStamp >> can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.VCU_TimeStamp >> can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.VCU_TimeStamp >> can.TIMESTAMP_SYNC_MESSAGE_VCU_TIMESTAMP_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.TIMESTAMP_SYNC_MESSAGE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_RSC_Diagnostic_Request( ConverterInitialize.RSC_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Diag_Req = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_FACTOR)) + (can.RSC_DIAGNOSTIC_REQUEST_CANID_RSC_DIAG_REQ_OFFSET));

        return can.RSC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_RSC_Diagnostic_Request( ConverterInitialize.RSC_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Diag_Req=(double) (messages.RSC_Diag_Req - can.RSC_DIAGNOSTIC_REQUEST_CANID_RSC_DIAG_REQ_OFFSET);
        data[0] = (byte)(((byte)messages.RSC_Diag_Req & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.RSC_Diag_Req >> can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.RSC_Diag_Req >> can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.RSC_Diag_Req >> can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.RSC_Diag_Req >> can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.RSC_Diag_Req >> can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.RSC_Diag_Req >> can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.RSC_Diag_Req >> can.RSC_DIAGNOSTIC_REQUEST_RSC_DIAG_REQ_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.RSC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_RSC_Diagnostic_Response( ConverterInitialize.RSC_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Diag_Resp = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_FACTOR)) + (can.RSC_DIAGNOSTIC_RESPONSE_CANID_RSC_DIAG_RESP_OFFSET));

        return can.RSC_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_RSC_Diagnostic_Response( ConverterInitialize.RSC_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.RSC_Diag_Resp=(double) (messages.RSC_Diag_Resp - can.RSC_DIAGNOSTIC_RESPONSE_CANID_RSC_DIAG_RESP_OFFSET);
        data[0] = (byte)(((byte)messages.RSC_Diag_Resp & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.RSC_Diag_Resp >> can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.RSC_Diag_Resp >> can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.RSC_Diag_Resp >> can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.RSC_Diag_Resp >> can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.RSC_Diag_Resp >> can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.RSC_Diag_Resp >> can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.RSC_Diag_Resp >> can.RSC_DIAGNOSTIC_RESPONSE_RSC_DIAG_RESP_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.RSC_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_LSC_Diagnostic_Request( ConverterInitialize.LSC_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Diag_Req = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_FACTOR)) + (can.LSC_DIAGNOSTIC_REQUEST_CANID_LSC_DIAG_REQ_OFFSET));

        return can.LSC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_LSC_Diagnostic_Request( ConverterInitialize.LSC_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Diag_Req=(double) (messages.LSC_Diag_Req - can.LSC_DIAGNOSTIC_REQUEST_CANID_LSC_DIAG_REQ_OFFSET);
        data[0] = (byte)(((byte)messages.LSC_Diag_Req & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.LSC_Diag_Req >> can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.LSC_Diag_Req >> can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.LSC_Diag_Req >> can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.LSC_Diag_Req >> can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.LSC_Diag_Req >> can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.LSC_Diag_Req >> can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.LSC_Diag_Req >> can.LSC_DIAGNOSTIC_REQUEST_LSC_DIAG_REQ_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.LSC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_LSC_Diagnostic_Response( ConverterInitialize.LSC_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Diagnostic_Response = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_FACTOR)) + (can.LSC_DIAGNOSTIC_RESPONSE_CANID_LSC_DIAGNOSTIC_RESPONSE_OFFSET));

        return can.LSC_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_LSC_Diagnostic_Response( ConverterInitialize.LSC_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.LSC_Diagnostic_Response=(double) (messages.LSC_Diagnostic_Response - can.LSC_DIAGNOSTIC_RESPONSE_CANID_LSC_DIAGNOSTIC_RESPONSE_OFFSET);
        data[0] = (byte)(((byte)messages.LSC_Diagnostic_Response & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.LSC_Diagnostic_Response >> can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.LSC_Diagnostic_Response >> can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.LSC_Diagnostic_Response >> can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.LSC_Diagnostic_Response >> can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.LSC_Diagnostic_Response >> can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.LSC_Diagnostic_Response >> can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.LSC_Diagnostic_Response >> can.LSC_DIAGNOSTIC_RESPONSE_LSC_DIAGNOSTIC_RESPONSE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.LSC_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Diagnostic_Request( ConverterInitialize.MCU_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Diag_Request = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_FACTOR)) + (can.MCU_DIAGNOSTIC_REQUEST_CANID_MCU_DIAG_REQUEST_OFFSET));

        return can.MCU_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Diagnostic_Request( ConverterInitialize.MCU_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Diag_Request=(double) (messages.MCU_Diag_Request - can.MCU_DIAGNOSTIC_REQUEST_CANID_MCU_DIAG_REQUEST_OFFSET);
        data[0] = (byte)(((byte)messages.MCU_Diag_Request & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.MCU_Diag_Request >> can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.MCU_Diag_Request >> can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.MCU_Diag_Request >> can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.MCU_Diag_Request >> can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.MCU_Diag_Request >> can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.MCU_Diag_Request >> can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.MCU_Diag_Request >> can.MCU_DIAGNOSTIC_REQUEST_MCU_DIAG_REQUEST_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.MCU_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_MCU_Diagnostic_Response( ConverterInitialize.MCU_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Diagnostic_Response = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_FACTOR)) + (can.MCU_DIAGNOSTIC_RESPONSE_CANID_MCU_DIAGNOSTIC_RESPONSE_OFFSET));

        return can.MCU_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_MCU_Diagnostic_Response( ConverterInitialize.MCU_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.MCU_Diagnostic_Response=(double) (messages.MCU_Diagnostic_Response - can.MCU_DIAGNOSTIC_RESPONSE_CANID_MCU_DIAGNOSTIC_RESPONSE_OFFSET);
        data[0] = (byte)(((byte)messages.MCU_Diagnostic_Response & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.MCU_Diagnostic_Response >> can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.MCU_Diagnostic_Response >> can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.MCU_Diagnostic_Response >> can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.MCU_Diagnostic_Response >> can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.MCU_Diagnostic_Response >> can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.MCU_Diagnostic_Response >> can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.MCU_Diagnostic_Response >> can.MCU_DIAGNOSTIC_RESPONSE_MCU_DIAGNOSTIC_RESPONSE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.MCU_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OBC_Diagnostic_Response( ConverterInitialize.OBC_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Diag_Resp = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_FACTOR)) + (can.OBC_DIAGNOSTIC_RESPONSE_CANID_OBC_DIAG_RESP_OFFSET));

        return can.OBC_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OBC_Diagnostic_Response( ConverterInitialize.OBC_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Diag_Resp=(double) (messages.OBC_Diag_Resp - can.OBC_DIAGNOSTIC_RESPONSE_CANID_OBC_DIAG_RESP_OFFSET);
        data[0] = (byte)(((byte)messages.OBC_Diag_Resp & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.OBC_Diag_Resp >> can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.OBC_Diag_Resp >> can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.OBC_Diag_Resp >> can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.OBC_Diag_Resp >> can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.OBC_Diag_Resp >> can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.OBC_Diag_Resp >> can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.OBC_Diag_Resp >> can.OBC_DIAGNOSTIC_RESPONSE_OBC_DIAG_RESP_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.OBC_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ABS_Diag_Request( ConverterInitialize.ABS_Diag_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Diag_Request = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_FACTOR)) + (can.ABS_DIAG_REQUEST_CANID_ABS_DIAG_REQUEST_OFFSET));

        return can.ABS_DIAG_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ABS_Diag_Request( ConverterInitialize.ABS_Diag_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Diag_Request=(double) (messages.ABS_Diag_Request - can.ABS_DIAG_REQUEST_CANID_ABS_DIAG_REQUEST_OFFSET);
        data[0] = (byte)(((byte)messages.ABS_Diag_Request & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.ABS_Diag_Request >> can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.ABS_Diag_Request >> can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.ABS_Diag_Request >> can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.ABS_Diag_Request >> can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.ABS_Diag_Request >> can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.ABS_Diag_Request >> can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.ABS_Diag_Request >> can.ABS_DIAG_REQUEST_ABS_DIAG_REQUEST_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ABS_DIAG_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ABS_Diag_Response( ConverterInitialize.ABS_Diag_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Diag_Response = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_FACTOR)) + (can.ABS_DIAG_RESPONSE_CANID_ABS_DIAG_RESPONSE_OFFSET));

        return can.ABS_DIAG_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ABS_Diag_Response( ConverterInitialize.ABS_Diag_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ABS_Diag_Response=(double) (messages.ABS_Diag_Response - can.ABS_DIAG_RESPONSE_CANID_ABS_DIAG_RESPONSE_OFFSET);
        data[0] = (byte)(((byte)messages.ABS_Diag_Response & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.ABS_Diag_Response >> can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.ABS_Diag_Response >> can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.ABS_Diag_Response >> can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.ABS_Diag_Response >> can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.ABS_Diag_Response >> can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.ABS_Diag_Response >> can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.ABS_Diag_Response >> can.ABS_DIAG_RESPONSE_ABS_DIAG_RESPONSE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ABS_DIAG_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_OBC_Diagnostic_Request( ConverterInitialize.OBC_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Diag_Request = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_FACTOR)) + (can.OBC_DIAGNOSTIC_REQUEST_CANID_OBC_DIAG_REQUEST_OFFSET));

        return can.OBC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_OBC_Diagnostic_Request( ConverterInitialize.OBC_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.OBC_Diag_Request=(double) (messages.OBC_Diag_Request - can.OBC_DIAGNOSTIC_REQUEST_CANID_OBC_DIAG_REQUEST_OFFSET);
        data[0] = (byte)(((byte)messages.OBC_Diag_Request & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.OBC_Diag_Request >> can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.OBC_Diag_Request >> can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.OBC_Diag_Request >> can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.OBC_Diag_Request >> can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.OBC_Diag_Request >> can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.OBC_Diag_Request >> can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.OBC_Diag_Request >> can.OBC_DIAGNOSTIC_REQUEST_OBC_DIAG_REQUEST_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.OBC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_HU_Diagnostic_Response( ConverterInitialize.HU_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.HU_Diagnostic_Response = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_FACTOR)) + (can.HU_DIAGNOSTIC_RESPONSE_CANID_HU_DIAGNOSTIC_RESPONSE_OFFSET));

        return can.HU_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_HU_Diagnostic_Response( ConverterInitialize.HU_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.HU_Diagnostic_Response=(double) (messages.HU_Diagnostic_Response - can.HU_DIAGNOSTIC_RESPONSE_CANID_HU_DIAGNOSTIC_RESPONSE_OFFSET);
        data[0] = (byte)(((byte)messages.HU_Diagnostic_Response & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.HU_Diagnostic_Response >> can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.HU_Diagnostic_Response >> can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.HU_Diagnostic_Response >> can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.HU_Diagnostic_Response >> can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.HU_Diagnostic_Response >> can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.HU_Diagnostic_Response >> can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.HU_Diagnostic_Response >> can.HU_DIAGNOSTIC_RESPONSE_HU_DIAGNOSTIC_RESPONSE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.HU_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_HU_Diagnostic_Request( ConverterInitialize.HU_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.HU_Diag_Req = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_FACTOR)) + (can.HU_DIAGNOSTIC_REQUEST_CANID_HU_DIAG_REQ_OFFSET));

        return can.HU_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_HU_Diagnostic_Request( ConverterInitialize.HU_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.HU_Diag_Req=(double) (messages.HU_Diag_Req - can.HU_DIAGNOSTIC_REQUEST_CANID_HU_DIAG_REQ_OFFSET);
        data[0] = (byte)(((byte)messages.HU_Diag_Req & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.HU_Diag_Req >> can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.HU_Diag_Req >> can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.HU_Diag_Req >> can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.HU_Diag_Req >> can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.HU_Diag_Req >> can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.HU_Diag_Req >> can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.HU_Diag_Req >> can.HU_DIAGNOSTIC_REQUEST_HU_DIAG_REQ_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.HU_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ESCL_Diagnostic_Response( ConverterInitialize.ESCL_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Diagnostic_Response = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_FACTOR)) + (can.ESCL_DIAGNOSTIC_RESPONSE_CANID_ESCL_DIAGNOSTIC_RESPONSE_OFFSET));

        return can.ESCL_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ESCL_Diagnostic_Response( ConverterInitialize.ESCL_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Diagnostic_Response=(double) (messages.ESCL_Diagnostic_Response - can.ESCL_DIAGNOSTIC_RESPONSE_CANID_ESCL_DIAGNOSTIC_RESPONSE_OFFSET);
        data[0] = (byte)(((byte)messages.ESCL_Diagnostic_Response & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.ESCL_Diagnostic_Response >> can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.ESCL_Diagnostic_Response >> can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.ESCL_Diagnostic_Response >> can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.ESCL_Diagnostic_Response >> can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.ESCL_Diagnostic_Response >> can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.ESCL_Diagnostic_Response >> can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.ESCL_Diagnostic_Response >> can.ESCL_DIAGNOSTIC_RESPONSE_ESCL_DIAGNOSTIC_RESPONSE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ESCL_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_ESCL_Diagnostic_Request( ConverterInitialize.ESCL_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Diag_Req = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_FACTOR)) + (can.ESCL_DIAGNOSTIC_REQUEST_CANID_ESCL_DIAG_REQ_OFFSET));

        return can.ESCL_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_ESCL_Diagnostic_Request( ConverterInitialize.ESCL_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.ESCL_Diag_Req=(double) (messages.ESCL_Diag_Req - can.ESCL_DIAGNOSTIC_REQUEST_CANID_ESCL_DIAG_REQ_OFFSET);
        data[0] = (byte)(((byte)messages.ESCL_Diag_Req & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.ESCL_Diag_Req >> can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.ESCL_Diag_Req >> can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.ESCL_Diag_Req >> can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.ESCL_Diag_Req >> can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.ESCL_Diag_Req >> can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.ESCL_Diag_Req >> can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.ESCL_Diag_Req >> can.ESCL_DIAGNOSTIC_REQUEST_ESCL_DIAG_REQ_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.ESCL_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BCM_Diagnostic_Response( ConverterInitialize.BCM_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BCM_Diag_Response = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_FACTOR)) + (can.BCM_DIAGNOSTIC_RESPONSE_CANID_BCM_DIAG_RESPONSE_OFFSET));

        return can.BCM_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BCM_Diagnostic_Response( ConverterInitialize.BCM_Diagnostic_Response_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BCM_Diag_Response=(double) (messages.BCM_Diag_Response - can.BCM_DIAGNOSTIC_RESPONSE_CANID_BCM_DIAG_RESPONSE_OFFSET);
        data[0] = (byte)(((byte)messages.BCM_Diag_Response & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.BCM_Diag_Response >> can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.BCM_Diag_Response >> can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.BCM_Diag_Response >> can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.BCM_Diag_Response >> can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.BCM_Diag_Response >> can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.BCM_Diag_Response >> can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.BCM_Diag_Response >> can.BCM_DIAGNOSTIC_RESPONSE_BCM_DIAG_RESPONSE_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BCM_DIAGNOSTIC_RESPONSE_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BCM_Diagnostic_Request( ConverterInitialize.BCM_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BCM_Diag_Request = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_FACTOR)) + (can.BCM_DIAGNOSTIC_REQUEST_CANID_BCM_DIAG_REQUEST_OFFSET));

        return can.BCM_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BCM_Diagnostic_Request( ConverterInitialize.BCM_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.BCM_Diag_Request=(double) (messages.BCM_Diag_Request - can.BCM_DIAGNOSTIC_REQUEST_CANID_BCM_DIAG_REQUEST_OFFSET);
        data[0] = (byte)(((byte)messages.BCM_Diag_Request & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.BCM_Diag_Request >> can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.BCM_Diag_Request >> can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.BCM_Diag_Request >> can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.BCM_Diag_Request >> can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.BCM_Diag_Request >> can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.BCM_Diag_Request >> can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.BCM_Diag_Request >> can.BCM_DIAGNOSTIC_REQUEST_BCM_DIAG_REQUEST_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.BCM_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_Func_Diagnostic_Request( ConverterInitialize.Func_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Functional_Diag_Request = (double)(((((long)( data[7] & (can.SIGNLE_READ_Mask8)) << can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK0) | ((long)( data[6] & (can.SIGNLE_READ_Mask8)) << can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK1) | ((long)( data[5] & (can.SIGNLE_READ_Mask8)) << can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK2) | ((long)( data[4] & (can.SIGNLE_READ_Mask8)) << can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK3) | (( data[3] & (can.SIGNLE_READ_Mask8)) << can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK4) | (( data[2] & (can.SIGNLE_READ_Mask8)) << can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK5) | (( data[1] & (can.SIGNLE_READ_Mask8)) << can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK6) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_FACTOR)) + (can.FUNC_DIAGNOSTIC_REQUEST_CANID_FUNCTIONAL_DIAG_REQUEST_OFFSET));

        return can.FUNC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_Func_Diagnostic_Request( ConverterInitialize.Func_Diagnostic_Request_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Functional_Diag_Request=(double) (messages.Functional_Diag_Request - can.FUNC_DIAGNOSTIC_REQUEST_CANID_FUNCTIONAL_DIAG_REQUEST_OFFSET);
        data[0] = (byte)(((byte)messages.Functional_Diag_Request & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Functional_Diag_Request >> can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK6) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)((((byte)messages.Functional_Diag_Request >> can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK5) & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Functional_Diag_Request >> can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK4) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)((((byte)messages.Functional_Diag_Request >> can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK3) & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Functional_Diag_Request >> can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK2) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)((((byte)messages.Functional_Diag_Request >> can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK1) & (can.SIGNLE_READ_Mask8)));
        data[7] = (byte)((((byte)messages.Functional_Diag_Request >> can.FUNC_DIAGNOSTIC_REQUEST_FUNCTIONAL_DIAG_REQUEST_MASK0) & (can.SIGNLE_READ_Mask8)));
        return can.FUNC_DIAGNOSTIC_REQUEST_ID;
    }

    /*------------------------------------------------------------*/

    public long Deserialize_BATTERY_STATUS_INFO( ConverterInitialize.BATTERY_STATUS_INFO_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Battery_Current = (float)((((( data[1] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_STATUS_INFO_BATTERY_CURRENT_MASK0) | ( data[0] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_STATUS_INFO_BATTERY_CURRENT_FACTOR)) + (can.BATTERY_STATUS_INFO_CANID_BATTERY_CURRENT_OFFSET));
        messages.Battery_Pack_SoC = (float)((((( data[3] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_STATUS_INFO_BATTERY_PACK_SOC_MASK0) | ( data[2] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_STATUS_INFO_BATTERY_PACK_SOC_FACTOR)) + (can.BATTERY_STATUS_INFO_CANID_BATTERY_PACK_SOC_OFFSET));
        messages.Charge_Voltage_limit = (float)((((( data[5] & (can.SIGNLE_READ_Mask8)) << can.BATTERY_STATUS_INFO_CHARGE_VOLTAGE_LIMIT_MASK0) | ( data[4] & (can.SIGNLE_READ_Mask8))) * (can.BATTERY_STATUS_INFO_CHARGE_VOLTAGE_LIMIT_FACTOR)) + (can.BATTERY_STATUS_INFO_CANID_CHARGE_VOLTAGE_LIMIT_OFFSET));
        messages.Charger_Mode_Request = (float)((((data[6] & (can.SIGNLE_READ_Mask3))) * (can.BATTERY_STATUS_INFO_CHARGER_MODE_REQUEST_FACTOR)) + (can.BATTERY_STATUS_INFO_CANID_CHARGER_MODE_REQUEST_OFFSET));
        messages.Time_to_Charge_Hrs = (float)((((( data[7] & (can.SIGNLE_READ_Mask2)) << can.BATTERY_STATUS_INFO_TIME_TO_CHARGE_HRS_MASK0) | (( data[6] >> can.BATTERY_STATUS_INFO_TIME_TO_CHARGE_HRS_MASK1) & (can.SIGNLE_READ_Mask5))) * (can.BATTERY_STATUS_INFO_TIME_TO_CHARGE_HRS_FACTOR)) + (can.BATTERY_STATUS_INFO_CANID_TIME_TO_CHARGE_HRS_OFFSET));
        messages.Time_to_Charge_Mins = (float)(((((data[7] >> can.BATTERY_STATUS_INFO_TIME_TO_CHARGE_MINS_MASK0) & (can.SIGNLE_READ_Mask6))) * (can.BATTERY_STATUS_INFO_TIME_TO_CHARGE_MINS_FACTOR)) + (can.BATTERY_STATUS_INFO_CANID_TIME_TO_CHARGE_MINS_OFFSET));

        return can.BATTERY_STATUS_INFO_ID;
    }

    /*------------------------------------------------------------*/

    public long Serialize_BATTERY_STATUS_INFO( ConverterInitialize.BATTERY_STATUS_INFO_t messages, byte[] data)
    {
        ConverterInitialize can = new ConverterInitialize();
        messages.Battery_Current=(float) (messages.Battery_Current - can.BATTERY_STATUS_INFO_CANID_BATTERY_CURRENT_OFFSET);
        messages.Battery_Pack_SoC=(float) (messages.Battery_Pack_SoC - can.BATTERY_STATUS_INFO_CANID_BATTERY_PACK_SOC_OFFSET);
        messages.Charge_Voltage_limit=(float) (messages.Charge_Voltage_limit - can.BATTERY_STATUS_INFO_CANID_CHARGE_VOLTAGE_LIMIT_OFFSET);
        messages.Charger_Mode_Request=(float) (messages.Charger_Mode_Request - can.BATTERY_STATUS_INFO_CANID_CHARGER_MODE_REQUEST_OFFSET);
        messages.Time_to_Charge_Hrs=(float) (messages.Time_to_Charge_Hrs - can.BATTERY_STATUS_INFO_CANID_TIME_TO_CHARGE_HRS_OFFSET);
        messages.Time_to_Charge_Mins=(float) (messages.Time_to_Charge_Mins - can.BATTERY_STATUS_INFO_CANID_TIME_TO_CHARGE_MINS_OFFSET);
        data[0] = (byte)(((byte)messages.Battery_Current & (can.SIGNLE_READ_Mask8)));
        data[1] = (byte)((((byte)messages.Battery_Current >> can.BATTERY_STATUS_INFO_BATTERY_CURRENT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[2] = (byte)(((byte)messages.Battery_Pack_SoC & (can.SIGNLE_READ_Mask8)));
        data[3] = (byte)((((byte)messages.Battery_Pack_SoC >> can.BATTERY_STATUS_INFO_BATTERY_PACK_SOC_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[4] = (byte)(((byte)messages.Charge_Voltage_limit & (can.SIGNLE_READ_Mask8)));
        data[5] = (byte)((((byte)messages.Charge_Voltage_limit >> can.BATTERY_STATUS_INFO_CHARGE_VOLTAGE_LIMIT_MASK0) & (can.SIGNLE_READ_Mask8)));
        data[6] = (byte)(((byte)messages.Charger_Mode_Request & ( can.SIGNLE_READ_Mask3)) | (((byte)messages.Time_to_Charge_Hrs & (can.SIGNLE_READ_Mask5)) << can.BATTERY_STATUS_INFO_TIME_TO_CHARGE_HRS_MASK1));
        data[7] = (byte)((((byte)messages.Time_to_Charge_Hrs >> can.BATTERY_STATUS_INFO_TIME_TO_CHARGE_HRS_MASK0) & (can.SIGNLE_READ_Mask2)) | (((byte)messages.Time_to_Charge_Mins & ( can.SIGNLE_READ_Mask6)) << can.BATTERY_STATUS_INFO_TIME_TO_CHARGE_MINS_MASK0));
        return can.BATTERY_STATUS_INFO_ID;
    }

    /*------------------------------------------------------------*/

}
