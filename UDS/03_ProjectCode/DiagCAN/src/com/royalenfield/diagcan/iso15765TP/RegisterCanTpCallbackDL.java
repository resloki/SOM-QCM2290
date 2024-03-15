package com.royalenfield.diagcan.iso15765TP;

import com.royalenfield.diagcan.FlexCanMsgPkt;

public interface RegisterCanTpCallbackDL {
    void sendDataToNetworkLayer(FlexCanMsgPkt canMsg);
}
