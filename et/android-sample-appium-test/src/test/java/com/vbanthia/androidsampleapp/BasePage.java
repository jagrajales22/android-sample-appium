package com.vbanthia.androidsampleapp;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.remote.HideKeyboardStrategy;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class BasePage extends BaseSetup {

    protected final AppiumDriver driver;

    public BasePage(AppiumDriver driver) {

        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    public boolean isAndroid() {
        return driver.getCapabilities().getCapability("platformName") == "Android";
    }

    public boolean isIOS() {
        return driver.getCapabilities().getCapability("platformName") == "iOS";
    }

    public void takeScreenshot() {
        driver.getScreenshotAs(OutputType.BASE64);
    }

    public String getAlertTitle() {

        if (isIOS()) {
            return driver.findElement(By.xpath("//UIAAlert/UIAScrollView/UIAStaticText[1]")).getText();
        } else {
            return driver.findElement(By.id("android:id/alertTitle")).getText();
        }

    }

    public void click(MobileElement element) {
        explicitWait(1000L);
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public void type(MobileElement element, String text) {
        explicitWait(1000L);
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(element));
        element.sendKeys(text);
    }

    public void explicitWait(Long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
