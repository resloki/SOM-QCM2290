package com.royalenfield.dataaggregator.strategicIoLayer.dbHandler;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * DatabaseConfigLoader loads database configuration properties from a file named "database_config.properties"
 * located in the assets directory of the Android application. It provides a static method to load the properties
 * into a Properties object.
 *
 * @author Jayanth S (jayanth.s@sloki.in)
 */
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
