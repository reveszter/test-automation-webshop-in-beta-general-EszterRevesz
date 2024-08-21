package com.codecool.webshop.stepdefinitions;

import com.codecool.webshop.pages.HomeLoggedInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class OrderedList extends Utils{
    private HomeLoggedInPage homeLoggedInPage;
    private final String ATOZORDER = "az";
    private final String ZTOAORDER = "za";
    private final String PRICELOWTOHIGH = "lohi";
    private final String PRICEHIGHTOLOW = "hilo";

    @Given("user is logged in and is on the logged in homepage")
    public void user_is_logged_in_and_is_on_the_logged_in_homepage() {
        openNewDriver();
        loginUser();
        homeLoggedInPage = new HomeLoggedInPage(webDriver);
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", webDriver.getCurrentUrl());
    }

    @When("user can choose of the order of the list")
    public void user_can_choose_of_the_order_of_the_list() {
        homeLoggedInPage.chooseFromOrderType(ATOZORDER);
    }

    @And("user can click on any product")
    public void user_can_click_on_any_product() {
        homeLoggedInPage.clickOnFirstProductInTheList();
    }

    @Then("user will land on the chosen product detail page")
    public void user_will_land_on_the_chosen_product_detail_page() {

    }
}
