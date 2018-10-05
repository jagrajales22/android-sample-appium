package test.java.com.vbanthia.androidsampleapp.Pages;

import test.java.com.vbanthia.androidsampleapp.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class UserRegistration extends BasePage {

    @AndroidFindBy(id = "et_name")
    public MobileElement nameTextField;

    @AndroidFindBy(id = "et_surname")
    public MobileElement surnameTextField;

    @AndroidFindBy(id = "et_email")
    public MobileElement emailTextField;

    @AndroidFindBy(id = "et_phone")
    public MobileElement phoneTextField;

    @AndroidFindBy(id = "cb_terms_conditions")
    public MobileElement termsAndConditionsCheckBox;

    @AndroidFindBy(id = "bt_next")
    public MobileElement nextButton;

    @AndroidFindBy(id = "android:id/button1")
    public MobileElement acceptButton;


    public UserRegistration(AppiumDriver driver) {
        super(driver);
    }

    public void userFullRegistration(String name, String surname, String email, String phone) {

        explicitWait(1000L);
        click(nameTextField);
        type(nameTextField, name);
        type(surnameTextField, surname);
        type(emailTextField, email);
        type(phoneTextField, phone);
        click(termsAndConditionsCheckBox);
        click(nextButton);
    }

    public void clickNextButton() {
        click(nextButton);
    }

    public void clickAcceptButton() {
        click(acceptButton);
    }

}