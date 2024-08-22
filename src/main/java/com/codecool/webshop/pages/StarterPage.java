package com.codecool.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StarterPage extends BasePage {

    @FindBy(id="user-name")
    public WebElement userNameInput;

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(id="login-button")
    private WebElement loginButton;

    public StarterPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void fillUserNameInput(String userName){
        wait.until(ExpectedConditions.visibilityOf(userNameInput)).sendKeys(userName);
    }

    public WebElement getUserNameInput() {
        return userNameInput;
    }

    public void fillPasswordInput(String password){
        wait.until(ExpectedConditions.visibilityOf(passwordInput)).sendKeys(password);
    }

    public void clickLoginButton(){
        wait.until(ExpectedConditions.visibilityOf(loginButton)).click();
    }
}
