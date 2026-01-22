package com.mystore.config;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
    
    private static ConfigReader instance;
    private static Properties properties;

    // private constructor to load the properties file
    private ConfigReader() {
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("config.properties")) {
            properties = new Properties();
            if(input != null){
                properties.load(input);
                System.out.println("LOG: Config file loaded successfully");
            }
            else{
                throw new RuntimeException("Could not find config.properties file");
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static ConfigReader getInstance(){
        if (instance == null){
            instance = new ConfigReader();
        }
        return instance;
    }

    public String getProperty(String key){
        return properties.getProperty(key);
    }
}
