package com.codecool.webshop.stepdefinitions;

import com.codecool.webshop.pages.StarterPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.net.MalformedURLException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps extends Utils{
    private StarterPage starterPage;

    @Given("the user is on the login page using {string}")
    public void the_user_is_on_the_login_page(String browser) throws MalformedURLException {
        openNewDriver(browser);
        starterPage = new StarterPage(webDriver);
    }

    @When("the user enters a valid username")
    public void the_user_enters_a_valid_username() {
//        wait.until(ExpectedConditions.visibilityOf(starterPage.getUserNameInput()));
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
