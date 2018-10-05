package com.vbanthia.androidsampleapp.Pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.testng.Assert;
import com.vbanthia.androidsampleapp.BasePage;

import java.util.Locale;


public class MainPage extends BasePage {

    @AndroidFindBy(id = "inputFieldLeft")
    public MobileElement inputLeftField;

    @AndroidFindBy(id = "inputFieldRight")
    public MobileElement inputRightField;

    @AndroidFindBy(id = "additionButton")
    public MobileElement additionButton;

    @AndroidFindBy(id = "subtractButton")
    public MobileElement substractionButton;

    @AndroidFindBy(id = "multiplicationButton")
    public MobileElement multiplicationButton;

    @AndroidFindBy(id = "divisionButton")
    public MobileElement divisionButton;

    @AndroidFindBy(id = "resetButton")
    public MobileElement resetButton;

    @AndroidFindBy(id = "resultTextView")
    public MobileElement resultTextView;


    public MainPage(AppiumDriver driver) {
        super(driver);
    }

    public void setOperands(String firstOperand, String secondOperand) {

        explicitWait(1000L);
        click(resetButton);
        type(inputLeftField, firstOperand);
        type(inputRightField, secondOperand);
    }

    public void doAddition() {
        click(additionButton);
    }

    public void doSubstraction() {
        click(substractionButton);
    }

    public void doMultiplication() {
        click(multiplicationButton);
    }

    public void doDivision() {
        click(divisionButton);
    }

    public void checkAddition(String firstOperand, String secondOperand) {
        double additionResult = Double.parseDouble(firstOperand) + Double.parseDouble(secondOperand);

        String displayedAdditionResult = firstOperand + " + " + secondOperand + " = " +
                String.format(Locale.ROOT, "%.2f", additionResult);

        Assert.assertEquals(resultTextView.getText(),
                displayedAdditionResult,
                "Check result corresponds to addition of operands");
    }

    public void checkSubstraction(String firstOperand, String secondOperand) {
        double substractionResult = Double.parseDouble(firstOperand) - Double.parseDouble(secondOperand);

        String displayedSubstractionResult = firstOperand + " - " +
                secondOperand + " = " + String.format(Locale.ROOT,"%.2f", substractionResult);

        Assert.assertEquals(resultTextView.getText(),
                displayedSubstractionResult,
                "Check result corresponds to substraction of operands");
    }

    public void checkMultiplication(String firstOperand, String secondOperand) {
        double multiplicationResult = Double.parseDouble(firstOperand) * Double.parseDouble(secondOperand);

        String displayedMultiplicationResult = firstOperand + " * " +
                secondOperand + " = " + String.format(Locale.ROOT,"%.2f", multiplicationResult);

        Assert.assertEquals(resultTextView.getText(),
                displayedMultiplicationResult,
                "Check result corresponds to multiplication of operands");
    }

    public void checkDivision(String firstOperand, String secondOperand) {
        double divisionResult = Double.parseDouble(firstOperand) / Double.parseDouble(secondOperand);

        String displayedDivisionResult = firstOperand + " / " +
                secondOperand + " = " + String.format(Locale.ROOT,"%.2f", divisionResult);

        Assert.assertEquals(resultTextView.getText(),
                displayedDivisionResult,
                "Check result corresponds to division of operands");
    }

}