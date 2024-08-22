package com.codecool.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class HomeLoggedInPage extends StarterPage{

    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuButton;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsButton;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetButton;

    @FindBy(className = "product_sort_container")
    private WebElement orderDropdownContainer;

    @FindBy(xpath = "//div[@class='inventory_item'][1]//div[contains(@class, 'inventory_item_name ')]")
    private WebElement firstProductName;

    @FindBy(xpath = "//div[@class='inventory_item'][last()]//div[contains(@class, 'inventory_item_name ')]")
    private WebElement lastProductName;

    @FindBy(xpath = "//div[@class='inventory_item'][1]//div[@class='inventory_item_price']")
    private WebElement firstProductPrice;

    @FindBy(xpath = "//div[@class='inventory_item'][last()]//div[@class='inventory_item_price']")
    private WebElement lastProductPrice;

    @FindBy(xpath = "//div[@class='inventory_item']//div[contains(@class, 'inventory_item_name ')]")
    private List<WebElement> productNames;

    @FindBy(xpath = "//div[@class='inventory_item']//div[@class='inventory_item_price']")
    private List<WebElement> productPrices;

    public HomeLoggedInPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnBurgerMenuButton() {
        wait.until(ExpectedConditions.visibilityOf(burgerMenuButton)).click();
    }

    public void clickOnAllItemsButton() {
        wait.until(ExpectedConditions.visibilityOf(allItemsButton)).click();
    }

    public void clickOnAboutButton() {
        wait.until(ExpectedConditions.visibilityOf(aboutButton)).click();
    }

    public void clickOnLogoutButton() {
        wait.until(ExpectedConditions.visibilityOf(logoutButton)).click();
    }

    public void clickOnResetButton() {
        wait.until(ExpectedConditions.visibilityOf(resetButton)).click();
    }

    public void clickOnOrderDropdownContainer() {
        wait.until(ExpectedConditions.elementToBeClickable(orderDropdownContainer)).click();
    }
    public void chooseFromOrderType(String orderType) {
        Select select = new Select(orderDropdownContainer);

        switch (orderType) {
            case "az":
                select.selectByValue("az");
                break;
            case "za":
                select.selectByValue("za");
                break;
            case "lohi":
                select.selectByValue("lohi");
                break;
            case "hilo":
                select.selectByValue("hilo");
                break;
            default:
                throw new IllegalArgumentException("Invalid order type: " + orderType);
        }
    }

    public void clickOnFirstProductInTheList() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProductName)).click();
    }

    public String getFirstProductName() {
        return wait.until(ExpectedConditions.visibilityOf(firstProductName)).getText();
    }


    public String getLastProductName() {
        return wait.until(ExpectedConditions.visibilityOf(lastProductName)).getText();
    }

    public Double getFirstProductPrice() {
        String priceText = firstProductPrice.getText().replace("$", "").trim();
        return Double.parseDouble(priceText);
    }

    public Double getLastProductPrice() {
        String priceText = lastProductPrice.getText().replace("$", "").trim();
        return Double.parseDouble(priceText);
    }

    public List<String> getAllProductNames() {
        return productNames.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public List<Double> getAllProductPrices() {
        return productPrices.stream()
                .map(priceElement -> Double.parseDouble(priceElement.getText().replace("$", "").trim()))
                .collect(Collectors.toList());
    }

    public List<Double> sortByPriceHighToLow(List<Double> prices) {
        List<Double> sortedPrices = new ArrayList<>(prices);
        sortedPrices.sort(Collections.reverseOrder());
        return sortedPrices;
    }

    public List<Double> sortByPriceLowToHigh(List<Double> prices) {
        List<Double> sortedPrices = new ArrayList<>(prices);
        sortedPrices.sort(Double::compareTo);
        return sortedPrices;
    }
}
