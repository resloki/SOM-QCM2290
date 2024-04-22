package com.royalenfield.dataaggregator.StrategicIoLayer.DataTransmitter;

import android.content.Context;
import android.content.Intent;

/**
 * SignalPublisher class facilitates broadcasting of engineering signals to interested components
 * within the application. It constructs and sends a broadcast intent containing information such as
 * CAN ID, signal name, data, and timestamp.
 *
 * @author Jayanth S (jayanth.s@sloki.in)
 */
public class SignalPublisher {
    private Context context;
    public SignalPublisher(Context context){
        this.context=context;
    }
    public void signalBroadcast(int canid, String signalName, Object data, long formattedTimestamp){
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction("com.royalenfield.dataaggregator.ENGINEERING_SIGNALS_BROADCAST");
        broadcastIntent.putExtra("canid", canid);
        broadcastIntent.putExtra("signalName", signalName);
        broadcastIntent.putExtra("data", data.toString());
        broadcastIntent.putExtra("timestamp", formattedTimestamp);
        context.sendBroadcast(broadcastIntent);
    }
}
