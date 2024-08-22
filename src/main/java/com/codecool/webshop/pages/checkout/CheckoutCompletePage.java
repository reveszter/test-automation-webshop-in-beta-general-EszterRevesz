package com.codecool.webshop.pages.checkout;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage extends CheckoutPage {
    private final String ORDER_SUCCESS_MESSAGE = "Thank you for your order!";

    @FindBy(xpath = "//h2[@class='complete-header']")
    private WebElement orderCompleteText;

    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean validateOrderSuccess() {
        return orderCompleteText.getText().equals(ORDER_SUCCESS_MESSAGE);
    }
}
