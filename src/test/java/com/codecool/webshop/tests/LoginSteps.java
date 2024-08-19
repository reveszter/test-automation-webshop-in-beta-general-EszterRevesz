package com.codecool.webshop.tests;

import com.codecool.webshop.pages.StarterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    private StarterPage starterPage;
    private WebDriver webDriver;
    private WebDriverWait wait;
    private final String BASE_URL = "https://www.saucedemo.com/";  // TODO -- use .env file
    private final String HOME_URL = "https://www.saucedemo.com/inventory.html";  // TODO -- use .env file
    private final String USERNAME = "standard_user"; // TODO -- use .env file
    private final String PASSWORD = "secret_sauce";  // TODO -- use .env file

    @Given("the user is on the login page")
    public void the_user_is_on_the_login_page() {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\Tibor\\codecool\\ADVANCED\\webdriver\\geckodriver-v0.35.0-win32\\geckodriver.exe");
        webDriver = new FirefoxDriver();
        //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Tibor\\codecool\\ADVANCED\\webdriver\\chromedriver-win64\\chromedriver.exe");
        //webDriver = new ChromeDriver();
        starterPage = new StarterPage(webDriver);
        webDriver.get(BASE_URL);
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    @When("the user enters a valid username")
    public void the_user_enters_a_valid_username() {
        wait.until(ExpectedConditions.visibilityOf(starterPage.getUserNameInput()));
        starterPage.fillUserNameInput(USERNAME);
    }

    @And("the user enters a valid password")
    public void the_user_enters_a_valid_password() {
        starterPage.fillPasswordInput(PASSWORD);
    }

    @And("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        starterPage.clickLoginButton();
    }

    @Then("the user should be redirected to the homepage")
    public void the_user_should_be_redirected_to_the_homepage() {
        assertEquals(HOME_URL, webDriver.getCurrentUrl());
    }

    @And("the user should have access to features that require identification")
    public void the_user_should_have_access_to_features_that_require_identification() {
        WebElement cartButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("shopping_cart_container")));
        assertTrue(cartButton.isDisplayed(), "The cart button should be displayed");
        webDriver.quit();
    }
}
