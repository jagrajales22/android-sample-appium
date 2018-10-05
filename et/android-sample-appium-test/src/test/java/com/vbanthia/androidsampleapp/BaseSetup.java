package com.vbanthia.androidsampleapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;


public class BaseSetup {


    private static AppiumDriver driver;
    private static final String PLATFORM_NAME = "Android";
    private static final String APP_ACTIVITY = "com.vbanthia.androidsampleapp.MainActivity";
    private static final String APP_PACKAGE = "com.vbanthia.androidsampleapp";
    private static final String DEVICE_NAME = "emulator-5554";
    private static final String LOCAL_HOST = "http://127.0.0.1:4723/wd/hub";
    private static final String PLATFORM_VERSION = "7.1.1";


    @BeforeSuite
    public void createTestRun() {
        //TODO: Logic for starting a test in a test case management tools comes here
    }

    @BeforeTest
    public void setUp() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, PLATFORM_NAME);
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, DEVICE_NAME);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, PLATFORM_VERSION);
        capabilities.setCapability("appPackage", APP_PACKAGE);
        capabilities.setCapability("appActivity", APP_ACTIVITY);
        capabilities.setCapability("autoGrantPermissions", "true");
        this.driver = new AppiumDriver(new URL(LOCAL_HOST), capabilities);
        driver.manage().timeouts().implicitlyWait(15L, TimeUnit.SECONDS);
    }

    public AppiumDriver getAppiumDriver() {
        try {
            setUp();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return driver;
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void uploadTestResults() {
        //TODO: Logic to finish and upload test results to a test case management tool
    }

}

