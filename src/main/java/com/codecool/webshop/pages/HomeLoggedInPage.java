package com.codecool.webshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

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

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private WebElement shoppingCartBtn;

    @FindBy(xpath = "//select[@data-test='product-sort-container']")
    private WebElement orderDropdown;

    @FindBy(xpath = "//div[@class='inventory_item'][1]//div[contains(@class, 'inventory_item_name')]")
    private WebElement firstProductName;

    @FindBy(xpath = "//div[@class='inventory_item'][1]//button[contains(@id, 'add-to-cart')]")
    private WebElement firstAddToCartBtn;

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

    public void clickOnOrderDropDown() {
        wait.until(ExpectedConditions.visibilityOf(orderDropdown)).click();
    }

    public void chooseFromOrderType(String orderType) {
        wait.until(ExpectedConditions.visibilityOf(orderDropdown));
        Select select = new Select(orderDropdown);
        select.selectByValue(orderType);
    }

    public void clickOnFirstProductInTheList() {
        wait.until(ExpectedConditions.elementToBeClickable(firstProductName)).click();
    }

    public String getFirstProductName() {
        return wait.until(ExpectedConditions.visibilityOf(firstProductName)).getText();
    }

    public void clickOnShoppingCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(shoppingCartBtn)).click();
    }

    public void clickOnFirstAddToCartButton() {
        wait.until(ExpectedConditions.elementToBeClickable(firstAddToCartBtn)).click();
    }

    public void clickOnAddToCartButtonByProductName(String productName) {
        String transformedProductName = productName.toLowerCase().replace(' ', '-');

        String customCartId = "add-to-cart-" + transformedProductName;
        WebElement btn = driver.findElement(By.xpath("//button[contains(@id, '" + customCartId + "')]"));

        wait.until(ExpectedConditions.elementToBeClickable(btn)).click();
    }
}
