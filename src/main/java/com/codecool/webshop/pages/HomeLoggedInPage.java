package com.codecool.webshop.pages;

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

    @FindBy(xpath = "//select[@data-test='product-sort-container']")
    private WebElement orderDropdown;

    @FindBy(xpath = "//div[@class='inventory_item'][1]//div[contains(@class, 'inventory_item_name')]")
    private WebElement firstProductName;

    @FindBy(xpath = "//*[@id='inventory_container']//div[@class='inventory_item_name'][last()]")
    private WebElement lastProductName;

    @FindBy(xpath = "//*[@id='inventory_container']//div[@class='inventory_item_name'][1]/following::div[@class='inventory_item_price'][1]")
    private WebElement firstProductPrice;

    @FindBy(xpath = "//*[@id='inventory_container']//div[@class='inventory_item_name'][last()]/following::div[@class='inventory_item_price'][1]")
    private WebElement lastProductPrice;


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


    public String getLastProductName() {
        return wait.until(ExpectedConditions.visibilityOf(lastProductName)).getText();
    }

    public String getFirstProductPrice() {
        return wait.until(ExpectedConditions.visibilityOf(firstProductPrice)).getText();
    }

    public String getLastProductPrice() {
        return wait.until(ExpectedConditions.visibilityOf(lastProductPrice)).getText();
    }



}
