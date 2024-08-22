package com.codecool.webshop.stepdefinitions;


import com.codecool.webshop.pages.HomeLoggedInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Logout extends Utils{
    private HomeLoggedInPage homeLoggedInPage;

    @Given("user is logged in and is on the logged in homepage")
    public void user_is_logged_in_and_is_on_the_logged_in_homepage(String browser) {
        openNewDriver(browser);
        loginUser();
        homeLoggedInPage = new HomeLoggedInPage(webDriver);
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", webDriver.getCurrentUrl());
    }

    @When("user clicks on the burger menu")
    public void user_clicks_on_the_burger_menu() {
        homeLoggedInPage.clickOnBurgerMenuButton();
    }

    @And("user clicks on the Logout button")
    public void user_clicks_on_the_logout_button() {
        homeLoggedInPage.clickOnLogoutButton();
    }

    @Then("user should be logged out and others can login after this step")
    public void user_should_be_logged_out_and_others_can_login_after_this_step() {
        assertEquals(BASE_URL, webDriver.getCurrentUrl());
        quitDriver();
    }
}
