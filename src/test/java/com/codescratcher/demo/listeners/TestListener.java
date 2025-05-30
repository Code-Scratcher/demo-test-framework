package com.codescratcher.demo.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestListener implements ITestListener {
    private static final Logger log = LoggerFactory.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("[TEST STARTING] {}", result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("[TEST PASSED] {}", result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("[TEST FAILED] {}", result.getName());
        log.error("Failure details: ", result.getThrowable());
    }

    @Override
    public void onStart(ITestContext context) {
        log.info("=== Test Execution Starting ===");
    }

    @Override
    public void onFinish(ITestContext context) {
        log.info("=== Test Execution Finished ===");
    }
}

