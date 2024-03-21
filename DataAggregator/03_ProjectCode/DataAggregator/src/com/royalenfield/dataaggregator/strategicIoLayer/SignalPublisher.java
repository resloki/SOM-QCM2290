package com.royalenfield.dataaggregator.strategicIoLayer;

import android.content.Context;
import android.content.Intent;

public class SignalPublisher {
    private Context context;
    public SignalPublisher(Context context){
        this.context=context;
    }
    public void SignalBroadcast(int canid,String signalName,Object data,String formattedTimestamp){
        Intent broadcastIntent = new Intent();
        broadcastIntent.setAction("com.royalenfield.dataaggregator.ENGINEERING_SIGNALS_BROADCAST");
        broadcastIntent.putExtra("canid", canid);
        broadcastIntent.putExtra("signalName", signalName);
        broadcastIntent.putExtra("data", data.toString());
        broadcastIntent.putExtra("timestamp", formattedTimestamp);
        context.sendBroadcast(broadcastIntent);
    }
}
