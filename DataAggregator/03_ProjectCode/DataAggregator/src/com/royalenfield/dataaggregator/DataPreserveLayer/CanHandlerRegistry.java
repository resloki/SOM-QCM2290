package com.royalenfield.dataaggregator.DataPreserveLayer;


import android.content.Context;

import com.royalenfield.dataaggregator.DataTransformLayer.CanDataProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.BiConsumer;

/**
 * CanHandlerRegistry class is responsible for dynamically managing the mappings between CAN IDs and their corresponding handler methods,
 * as well as loading necessary classes based on properties provided in configuration files.
 * It initializes these mappings in the constructor based on the provided CanDataProcessor instance and loads ConverterInitializer and SignalConverter classes
 * dynamically using properties from configuration files.
 * The mappings are stored in a HashMap, where the key is the CAN ID and the value is the corresponding CanHandler.
 * This class ensures flexibility and extensibility by dynamically configuring the mappings and classes through properties files.
 *
 * @author Jayanth S (jayanth.s@sloki.in)
 */

public class CanHandlerRegistry {
    private final Map<Integer, CanHandler> mapHandlers = new HashMap<>();
    private final String packageName = "com.royalenfield.dataaggregator.ConfigurationFile.SignalConverterConfig";
    private final CanDataProcessor canProcessor;
    private String dbcFileNamePropertyFile = "dbc_conversion_files.properties";
    private String dbcCanMappingPropertyFile = "can_mapping_config.properties";
    private Context context;
    private Object ConverterInitialize;
    private Object SignalConverter;
    private final ExecutorService executorService = Executors.newFixedThreadPool(10);


    public CanHandlerRegistry(CanDataProcessor canProcessor, Context context) {
        this.context = context;
        this.canProcessor = canProcessor;
        loadConverterInitialize();
    }

    /**
     * Loads ConverterInitializer class and SignalConverter class based on properties provided in configuration files.
     * Reads properties from dbc_conversion_files.properties and initializes ConverterInitializer and SignalConverter classes accordingly.
     */
    void loadConverterInitialize() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = context.getAssets().open(dbcFileNamePropertyFile);
            properties.load(inputStream);
            String ConverterInitializeClassName = properties.getProperty("ConverterInitialize");
            String SignalConverterClassName = properties.getProperty("SignalConverter");
            if ((ConverterInitializeClassName != null) && (SignalConverterClassName != null)) {
                try {
                    Class<?> ConverterInitializeConverterClass = Class.forName(packageName + "." + ConverterInitializeClassName);
                    Class<?> SignalConverterConverterClass = Class.forName(packageName + "." + SignalConverterClassName);
                    ConverterInitialize = ConverterInitializeConverterClass.getDeclaredConstructor().newInstance();
                    SignalConverter = SignalConverterConverterClass.getDeclaredConstructor().newInstance();
                } catch (ReflectiveOperationException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Initializes the handler methods based on mappings provided in can_mapping_config.properties file.
     * Reads CAN ID mappings and corresponding handler methods from the properties file and initializes the handlers.
     */
    protected void initializeHandlers() {
        Properties properties = new Properties();
        try {
            InputStream inputStream = context.getAssets().open(dbcCanMappingPropertyFile);
            properties.load(inputStream);

            for (String propertyName : properties.stringPropertyNames()) {
                if (propertyName.endsWith("_ID")) {
                    int canId;
                    String[] propertyValueParts = properties.getProperty(propertyName).split(",");
                    if (propertyValueParts.length != 2) {
                        continue;
                    }
                    try {
                        String canIdHex = propertyValueParts[0].trim();
                        canId = Integer.parseInt(canIdHex.substring(2), 16);
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                        continue;
                    }

                    String methodName = propertyValueParts[1].trim();
                    String className = methodName.toUpperCase() + "_t";

                    Class<?> nestedClass = null;
                    try {
                        Class<?> converterInitializeClass = ConverterInitialize.getClass();
                        Class<?>[] declaredClasses = converterInitializeClass.getDeclaredClasses();
                        for (Class<?> clazz : declaredClasses) {
                            if (clazz.getSimpleName().equals(className)) {
                                nestedClass = clazz;
                                break;
                            }
                        }
                    } catch (SecurityException e) {
                        e.printStackTrace();
                    }

                    if (nestedClass == null) {
                        System.err.println(" class " + className + " not found.");
                        continue;
                    }

                    BiConsumer<Object, byte[]> deserializer = null;
                    try {
                        Method deserializerMethod = SignalConverter.getClass().getMethod("Deserialize_" + methodName.toUpperCase(), nestedClass, byte[].class);
                        deserializer = (messageType, data) -> {
                            try {
                                deserializerMethod.invoke(SignalConverter, messageType, data);
                            } catch (IllegalAccessException | InvocationTargetException e) {
                                e.printStackTrace();
                            }
                        };
                    } catch (NoSuchMethodException e) {
                        e.printStackTrace();
                    }
                    final BiConsumer<Object, byte[]> deserializerCopy = deserializer;
                    mapHandlers.put(canId, (receivedData, interval) -> {
                        Object messageType = getMessageType(methodName);
                        executorService.submit(() ->
                                canProcessor.handleCanMessage(receivedData, interval, messageType, deserializerCopy)
                        );
                    });
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Retrieves the message type object based on the method name.
     * @param methodName The name of the method.
     * @return The message type object.
     */
    private Object getMessageType(String methodName) {
        try {
            String converterInitializeClassName = ConverterInitialize.getClass().getName();
            String className = converterInitializeClassName + "$" + methodName.toUpperCase() + "_t";
            return Class.forName(className).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Retrieves the CanHandler object associated with the given CAN ID.
     * @param canId The CAN ID.
     * @return The CanHandler object associated with the given CAN ID.
     */
    public CanHandler getHandler(int canId) {
        return mapHandlers.get(canId);
    }
}
