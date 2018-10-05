package com.vbanthia.androidsampleapp;

import com.vbanthia.androidsampleapp.Pages.MainPage;
import io.appium.java_client.AppiumDriver;

public class AndroidSampleApp {

    private AppiumDriver driver;

    public AndroidSampleApp(AppiumDriver driver) {
        this.driver = driver;
    }

    public MainPage startPage() {
        return new MainPage(driver);
    }

}
