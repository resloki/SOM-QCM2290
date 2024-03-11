package com.royalenfield.dataaggregator.DataAggregator.DataPreserveLayer;

import android.util.Log;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Scheduler class manages the scheduling of tasks based on specific intervals.
 * It utilizes a Timer to schedule tasks for processing buffered data at predefined intervals.
 */
public class Scheduler {
    CanMapping canMapping;
    Timer timer;

    Scheduler(CanMapping canMapping) {
        this.canMapping = canMapping;
        this.timer = new Timer();
    }

    private final String TAG = "Time_scheduler";

    public void createTimer(final Intervals interval, long delay) {
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                try {
                    Log.d(TAG, "Entered to the scheduler of " + interval);
                    switch (interval) {
                        case Milliseconds_10:
                            canMapping.processBufferedData(canMapping.buffer10ms, interval);
                            canMapping.flag10ms = false;
                            break;
                        case Milliseconds_50:
                            canMapping.processBufferedData(canMapping.buffer50ms, interval);
                            canMapping.flag50ms = false;
                            break;
                        case Milliseconds_500:
                            canMapping.processBufferedData(canMapping.buffer500ms, interval);
                            canMapping.flag500ms = false;
                            break;
                        default:
                            Log.e(TAG, "Invalid interval");
                            break;
                    }
                    Log.d(TAG, "Sent Data to processBufferedData");
                } catch (Exception e) {
                    Log.e(TAG, "Error: " + e.getMessage());
                    e.printStackTrace(); // or log the exception
                }
            }
        }, delay);
    }

}
