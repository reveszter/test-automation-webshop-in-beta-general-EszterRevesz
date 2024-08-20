package com.codecool.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeLoggedInPage extends StarterPage{

    @FindBy(id = "react-burger-menu-button")
    private WebElement burgerMenuButton;

    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItemsButton;

    @FindBy(id = "about_sidebar_link")
    private WebElement aboutButton;

    @FindBy(id = "logout_sidebar_link")
    private WebElement logoutButton;

    @FindBy(id = "reset_sidebar_link")
    private WebElement resetButton;

    public HomeLoggedInPage(WebDriver driver) {
//        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void clickOnBurgerMenuButton() {
        burgerMenuButton.click();
    }

    public void clickOnAllItemsButton() {
        allItemsButton.click();
    }

    public void clickOnAboutButton() {
        aboutButton.click();
    }

    public void clickOnLogoutButton() {
        logoutButton.click();
    }

    public void clickOnResetButton() {
        resetButton.click();
    }

}
