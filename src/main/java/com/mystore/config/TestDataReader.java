package com.mystore.config;

import java.io.InputStream;
import java.util.Properties;

public class TestDataReader {

    private static TestDataReader instance;
    private static Properties properties;

    //private constructor
    private TestDataReader(){
        try (InputStream input = 
            getClass().getClassLoader()
            .getResourceAsStream("testdata.properties")) {

                // map to store the properties
                properties = new Properties();
                if(input != null){
                    properties.load(input);
                }
                else{
                    throw new RuntimeException("testdata.properties file not found");
                }
            }

        catch (Exception e){
            throw new RuntimeException("Failed to load test data", e);
        }
    }

    public static TestDataReader getInstance(){
        if (instance == null){
            instance = new TestDataReader();
        }
        return instance;
    }

    public String get(String key){
        return properties.getProperty(key);
    }

    
}
