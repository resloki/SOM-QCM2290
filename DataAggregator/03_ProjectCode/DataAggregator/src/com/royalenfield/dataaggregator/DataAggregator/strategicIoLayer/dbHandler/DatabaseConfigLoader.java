package com.royalenfield.dataaggregator.DataAggregator.strategicIoLayer.dbHandler;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DatabaseConfigLoader {

    public static Properties loadDatabaseConfig(Context context) {
        Properties properties = new Properties();
        try {
            InputStream inputStream = context.getAssets().open("database_config.properties");
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }
}
