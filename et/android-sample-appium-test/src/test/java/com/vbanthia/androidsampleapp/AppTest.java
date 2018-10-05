package com.yellowpepper;


import com.github.javafaker.Faker;
import com.yellowpepper.Pages.Cart;
import com.yellowpepper.Pages.Stores;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Oxxo happy flow .
 */
public class AppTest extends BaseSetup {

    protected Oxxo app;

    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String pinCode;
    private String creditCardNumber;
    private String creditCardExpirationDate;
    private String creditCardCvv;
    private int selectedStore;
    private String sku;
    private int addingProductQuantity;

    @BeforeTest
    public void setUpOxxo() {
        app = new Oxxo(getAppiumDriver());
    }

    @Test
    public void newRegisteredUserCheckout() {

        // Arrange: Test data generation for user registration

        setUpData();

        //Act: Test flow for user registration after home screen
        app.startPage().newUser();

        app.tutorialPage().signUp();

        app.userRegistrationPage().userFullRegistration(firstName, lastName, email, phoneNumber);

        app.pinPage().createNewPin(pinCode);

        app.userRegistrationPage().clickNextButton();
        app.userRegistrationPage().clickAcceptButton();

        app.creditCardPage().creditCardRegistration(creditCardNumber, creditCardExpirationDate, creditCardCvv);

        app.storesPage().selectStore(selectedStore);

        app.productScanningPage().productManualInput(sku);

        app.cartPage().increaseProductQuantity(addingProductQuantity);
        app.cartPage().checkout();

        //Assert:

        app.paymentResponsePage().checkTransactionWasApproved();

        app.paymentResponsePage().goodRating();
        app.storesPage().myAccount();

        app.accountPage().logOut();
    }

    @Test
    public void newGuestUserCheckout() {

        // Arrange: Test data generation for user registration

        setUpData();

        //Act: Test flow for user registration after home screen
        app.startPage().newUser();

        app.tutorialPage().skip();

        app.storesPage().selectStore(selectedStore);

        app.productScanningPage().productManualInput(sku);

        app.cartPage().increaseProductQuantity(addingProductQuantity);
        app.cartPage().checkout();

        app.startPage().newUser();

        app.tutorialPage().signUp();

        app.userRegistrationPage().userFullRegistration(firstName, lastName, email, phoneNumber);

        app.pinPage().createNewPin(pinCode);

        app.userRegistrationPage().clickNextButton();
        app.userRegistrationPage().clickAcceptButton();

        app.creditCardPage().creditCardRegistration(creditCardNumber, creditCardExpirationDate, creditCardCvv);

        app.storesPage().selectStore(selectedStore);

        app.productScanningPage().goToCart();

        app.cartPage().checkout();

        //Assert:

        app.paymentResponsePage().checkTransactionWasApproved();

        app.paymentResponsePage().goodRating();
        app.storesPage().myAccount();

        app.accountPage().logOut();
    }

    public void setUpData() {
        Faker faker = new Faker();
        this.firstName = faker.name().firstName();
        this.lastName = faker.name().lastName();
        this.email = faker.internet().emailAddress();
        this.phoneNumber = faker.number().digits(13);
        this.pinCode = "505050"; // I will fix it for the moment
        this.creditCardNumber = "4242424242424242"; // fixed, but there are services for BIN generation
        this.creditCardExpirationDate = "12/32";
        this.creditCardCvv = "123";
        this.selectedStore = faker.number().numberBetween(1, Stores.REGISTERED_STORES);
        this.sku = "123456";
        this.addingProductQuantity = faker.number().numberBetween(0, Cart.MAXIMUM_ALLOWED_ADDITIONS);
    }

}
