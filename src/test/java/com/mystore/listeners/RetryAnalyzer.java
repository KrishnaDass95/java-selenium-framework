package com.mystore.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class RetryAnalyzer implements IRetryAnalyzer{

    private static final Logger logger = LoggerFactory.getLogger(RetryAnalyzer.class);

    private int retryCount = 0;
    private static final int maxRetryCount = 1;

    @Override
    public boolean retry(ITestResult result){

        if (retryCount < maxRetryCount) {
            retryCount++;

            Throwable cause = result.getThrowable();
            if (cause != null) {
            logger.warn("FAILURE REASON: {}", cause.getMessage());
        }

            logger.warn("RETRYING test: [{}] | Attempt: {} of {}", 
                result.getName(), retryCount, maxRetryCount);

            return true;
        }

        logger.error(" Max retries reached for test: [{}]. Moving to failure.", result.getName());
        return false;

    }
    
}
