package com.vbanthia.androidsampleapp;


import com.github.javafaker.Faker;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


/**
 * Oxxo happy flow .
 */
public class AppTest extends BaseSetup {

    protected AndroidSampleApp app;

    private String firstOperand;
    private String secondOperand;


    @BeforeTest
    public void setUpAndroidSampleApp() {
        app = new AndroidSampleApp(getAppiumDriver());
    }

    @Test
    public void addition() {

        // Arrange: Test data generation
        setUpData();

        //Act: Test flow for addition operation
        app.startPage().setOperands(firstOperand, secondOperand);

        app.startPage().doAddition();

        //Assert: Make sure result corresponds to the addition of the operands
        app.startPage().checkAddition(firstOperand, secondOperand);
    }

    @Test
    //Note: This test will fail since the operation result is like addition operation was selected
    public void substraction() {

        // Arrange: Test data generation
        setUpData();

        //Act: Test flow for substraction operation
        app.startPage().setOperands(firstOperand, secondOperand);

        app.startPage().doSubstraction();

        //Assert: Make sure result corresponds to the substraction of the operands
        app.startPage().checkSubstraction(firstOperand, secondOperand);
    }

    @Test
    public void multiplication() {

        // Arrange: Test data generation
        setUpData();

        //Act: Test flow for multiplication operation
        app.startPage().setOperands(firstOperand, secondOperand);

        app.startPage().doMultiplication();

        //Assert: Make sure result corresponds to the multiplication of the operands
        app.startPage().checkMultiplication(firstOperand, secondOperand);
    }

    @Test
    public void division() {

        // Arrange: Test data generation
        setUpData();

        //Act: Test flow for division operation
        app.startPage().setOperands(firstOperand, secondOperand);

        app.startPage().doDivision();

        //Assert: Make sure result corresponds to the division of the operands
        app.startPage().checkDivision(firstOperand, secondOperand);
    }

    public void setUpData() {
        Faker faker = new Faker();
        this.firstOperand = Double.toString(faker.number().randomDouble(2, 0, 256));
        this.secondOperand = Double.toString(faker.number().randomDouble(2, 0, 256));
    }

}
