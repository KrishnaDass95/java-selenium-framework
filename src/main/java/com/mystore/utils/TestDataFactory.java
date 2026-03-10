package com.mystore.utils;

public class TestDataFactory {
    
    public static String generateUserEmail(){
        return "user" + System.currentTimeMillis() + "@test.com";
    }
}
