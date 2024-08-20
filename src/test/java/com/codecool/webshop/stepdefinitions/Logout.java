package com.codecool.webshop.stepdefinitions;


import com.codecool.webshop.pages.HomeLoggedInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Logout extends Utils{
    protected final String BASE_URL = "https://www.saucedemo.com/";
    protected WebDriver webDriver;
    public void openNewDriver() {
        webDriver = new FirefoxDriver();
        webDriver.get(BASE_URL);
    }

    private HomeLoggedInPage homeLoggedInPage;

    @Given("user is logged in with {string} and {string} and is on the logged in homepage")
    public void user_is_logged_in_and_is_on_the_logged_in_homepage(String usnername, String password) {
        openNewDriver();
        loginUser(usnername, password);

        homeLoggedInPage = new HomeLoggedInPage(webDriver);

    }

    @When("user clicks on the burger menu")
    public void user_clicks_on_the_burger_menu() {
        homeLoggedInPage.clickOnBurgerMenuButton();
    }

    @Then("user clicks on the Logout button")
    public void user_clicks_on_the_logout_button() {
        homeLoggedInPage.clickOnLogoutButton();
    }

    @Given("user should be logged out and others can login after this step")
    public void user_should_be_logged_out_and_others_can_login_after_this_step() {
        String expectedURL = "https://www.saucedemo.com/";
        assertEquals(expectedURL, webdriver.getCurrentUrl());
    }
}
