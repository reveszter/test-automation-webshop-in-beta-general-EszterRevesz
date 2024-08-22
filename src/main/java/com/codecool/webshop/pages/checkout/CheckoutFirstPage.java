package com.codecool.webshop.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutFirstPage extends CheckoutPage {

    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement postalCodeInput;

    @FindBy(xpath = "//*[@id='continue']")
    private WebElement continueBtn;

    public CheckoutFirstPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillFirstNameInputField(String input) {
        wait.until(ExpectedConditions.visibilityOf(firstNameInput)).sendKeys(input);
    }

    public void fillLastNameInputField(String input) {
        wait.until(ExpectedConditions.visibilityOf(lastNameInput)).sendKeys(input);
    }

    public void fillPostalCodeInputField(String input) {
        wait.until(ExpectedConditions.visibilityOf(postalCodeInput)).sendKeys(input);
    }

    public void clickOnContinueBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(continueBtn)).click();
    }
}
