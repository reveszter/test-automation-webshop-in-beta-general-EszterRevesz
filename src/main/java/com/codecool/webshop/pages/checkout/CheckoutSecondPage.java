package com.codecool.webshop.pages.checkout;

import com.codecool.webshop.exceptions.InvalidPricesShownException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class CheckoutSecondPage extends CheckoutPage {

    @FindBy(xpath = "//button[@id='finish']")
    private WebElement finishBtn;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement subTotalLabel;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement taxLabel;

    @FindBy(xpath = "//div[@class='summary_total_label']")
    private WebElement totalLabel;

    @FindBy(xpath = "//div[@class='cart_list']//div[@class='inventory_item_price']")
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

    private List<Double> getAllProductPrices() {
        return itemPriceList.stream()
                .map(priceElement -> Double.parseDouble(priceElement.getText().replace("$", "").trim()))
                .collect(Collectors.toList());
    }

    public boolean validateShownPrices(Double subTotalData, Double taxData, Double totalData) {
        double itemTotal = getSubTotalValue();
        double tax = getTaxValue();
        double total = getTotalValue();

        List<Double> itemStandalonePrices = getAllProductPrices();
        double manualItemTotal = 0;
        for (Double price : itemStandalonePrices) {
            manualItemTotal += price;
        }

        if (itemTotal != manualItemTotal) return false;
        if (itemTotal != subTotalData) return false;
        if (tax != taxData) return false;
        if (total != totalData) return false;
        if (itemTotal + tax != total) return false;
        if (itemTotal + tax != totalData) return false;

        return true;
    }

    public void clickFinishBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
    }
}
