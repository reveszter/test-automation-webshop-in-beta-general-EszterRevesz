package com.codecool.webshop.stepdefinitions;

import com.codecool.webshop.pages.HomeLoggedInPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class OrderedList extends Utils {
    private HomeLoggedInPage homeLoggedInPage;

    @Given("user is on the homepage already authenticated")
    public void user_is_logged_in_and_is_on_the_logged_in_homepage() {
        openNewDriver();
        loginUser();
        homeLoggedInPage = new HomeLoggedInPage(webDriver);
        Assertions.assertEquals("https://www.saucedemo.com/inventory.html", webDriver.getCurrentUrl());
    }

    @When("user chooses {string} order")
    public void user_chooses_order(String orderType) {
        switch (orderType.toLowerCase().replace(" ", "")) {
            case "atoz":
                homeLoggedInPage.clickOnOrderDropdownContainer();
                homeLoggedInPage.chooseFromOrderType("az");
                break;
            case "ztoa":
                homeLoggedInPage.clickOnOrderDropdownContainer();
                homeLoggedInPage.chooseFromOrderType("za");
                break;
            case "lowtohighprice":
                homeLoggedInPage.clickOnOrderDropdownContainer();
                homeLoggedInPage.chooseFromOrderType("lohi");
                break;
            case "hightolowprice":
                homeLoggedInPage.clickOnOrderDropdownContainer();
                homeLoggedInPage.chooseFromOrderType("hilo");
                break;
            default:
                throw new IllegalArgumentException("Invalid order type: " + orderType);
        }
    }

    @Then("user can see the products in {string} order")
    public void user_can_see_the_products_in_order(String orderType) {
        List<String> displayedProductNames = homeLoggedInPage.getAllProductNames();
        List<Double> displayedProductPrices = homeLoggedInPage.getAllProductPrices();

        List<String> expectedProductNames = new ArrayList<>(displayedProductNames);
        List<Double> expectedProductPrices = new ArrayList<>(displayedProductPrices);

        switch (orderType) {
            case "a to z":
                expectedProductNames.sort(String::compareTo);
                Assertions.assertEquals(expectedProductNames, displayedProductNames);
                quitDriver();
                break;
            case "z to a":
                expectedProductNames.sort(Collections.reverseOrder(String::compareTo));
                Assertions.assertEquals(expectedProductNames, displayedProductNames);
                quitDriver();
                break;
            case "low to high price":
                expectedProductPrices.sort(Double::compareTo);
                Assertions.assertEquals(expectedProductPrices, displayedProductPrices);
                quitDriver();
                break;
            case "high to low price":
                expectedProductPrices.sort(Collections.reverseOrder());
                Assertions.assertEquals(expectedProductPrices, displayedProductPrices);
                quitDriver();
                break;
            default:
                throw new IllegalArgumentException("Invalid order type: " + orderType);
        }
    }
}
