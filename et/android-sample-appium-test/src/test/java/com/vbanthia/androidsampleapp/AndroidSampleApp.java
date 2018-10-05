package test.java.com.vbanthia.androidsampleapp;

import com.yellowpepper.Pages.*;
import io.appium.java_client.AppiumDriver;

public class Oxxo {

    private AppiumDriver driver;

    public Oxxo(AppiumDriver driver) {
        this.driver = driver;
    }

    public Start startPage() {
        return new Start(driver);
    }

    public Tutorial tutorialPage() {
        return new Tutorial(driver);
    }

    public UserRegistration userRegistrationPage() {
        return new UserRegistration(driver);
    }

    public Pin pinPage() {
        return new Pin(driver);
    }

    public CreditCard creditCardPage() {
        return new CreditCard(driver);
    }

    public Stores storesPage() {
        return new Stores(driver);
    }

    public ProductScanning productScanningPage() {
        return new ProductScanning(driver);
    }

    public Cart cartPage() {
        return new Cart(driver);
    }

    public PaymentResponse paymentResponsePage() {
        return new PaymentResponse(driver);
    }

    public Account accountPage() {
        return new Account(driver);
    }
}
