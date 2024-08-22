package com.codecool.webshop.stepdefinitions;

import com.codecool.webshop.pages.HomeLoggedInPage;
import com.codecool.webshop.pages.ProductPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

public class ShowProductSteps extends Utils{

    private HomeLoggedInPage homeLoggedInPage;
    private ProductPage productPage;

    @Given("User is logged in on the homepage")
    public void user_is_logged_in_on_the_homepage(String browser){
        openNewDriver(browser);
        loginUser();
    }

    @When("User select an item by clicking")
    public void user_select_an_item_by_clicking(){
        homeLoggedInPage = new HomeLoggedInPage(webDriver);
        homeLoggedInPage.clickOnFirstProductInTheList();
    }

    @Then("Details of the selected product can be seen on the screen")
    public void details_of_the_selected_product_can_be_seen_on_the_screen(){
        productPage = new ProductPage(webDriver);
        String productDescription = productPage.getProductDescription();
        Assertions.assertNotNull(productDescription, "Product description should not be null");
        Assertions.assertFalse(productDescription.isEmpty(), "Product description should not be empty");
        webDriver.quit();
    }
}
