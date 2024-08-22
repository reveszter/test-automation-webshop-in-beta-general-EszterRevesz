package com.codecool.webshop.pages.checkout;

import com.codecool.webshop.exceptions.InvalidPricesShownException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class CheckoutSecondPage extends CheckoutPage {

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishBtn;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement subTotalLabel;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement taxLabel;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    private WebElement totalLabel;

    @FindBy(xpath = "//div[@class='cart-list']/div[@class='inventory_item_price']")
    private List<WebElement> itemPriceList;

    public CheckoutSecondPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    private double getMoneyValueOutOfText(String text) {
        // Remove everything up to and including the dollar sign
        String cleaned = text.replaceAll("^.*\\$", "");

        String priceStr = cleaned.replace("$", "").trim();
        return Double.parseDouble(priceStr);
    }

    private double getSubTotalValue() {
        return getMoneyValueOutOfText(subTotalLabel.getText());
    }

    private double getTaxValue() {
        return getMoneyValueOutOfText(taxLabel.getText());
    }

    private double getTotalValue() {
        return getMoneyValueOutOfText(totalLabel.getText());
    }

    public void validateShownPrices() {
        double itemTotal = getSubTotalValue();
        double tax = getTaxValue();
        double total = getTotalValue();

        if (itemTotal + tax != total) throw new InvalidPricesShownException("subTotal + tax doesn't equal total despite the website showing that");

    }

    public void clickFinishBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
    }
}
