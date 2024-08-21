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

    @FindBy(xpath = "//*[@id='inventory_container']//div[@class='inventory_item_name'][1]")
    private WebElement firstProductName;

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
        wait.until(ExpectedConditions.visibilityOf(firstProductName)).click();
    }

    public String getFirstProductName() {
        return wait.until(ExpectedConditions.visibilityOf(firstProductName)).getText();
    }
}
