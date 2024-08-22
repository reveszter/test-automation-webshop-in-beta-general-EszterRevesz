package com.codecool.webshop.stepdefinitions;

import com.codecool.webshop.pages.CartPage;
import com.codecool.webshop.pages.HomeLoggedInPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class CartSteps extends Utils {
    private HomeLoggedInPage homeLoggedInPage;
    private CartPage cartPage;
    private final String SHOPPING_CART_URL = "https://www.saucedemo.com/cart.html";

    @Given("the user successfully logged in")
    public void the_user_successfully_logged_in() {
        openNewDriver();
        loginUser();
    }

    @And("is currently on the page where he sees the products")
    public void is_currently_on_the_page_where_he_sees_the_products() {
        homeLoggedInPage = new HomeLoggedInPage(webDriver);
    }

    @When("he clicks on the {string} product's 'Add to cart' button")
    public void he_clicks_on_the_products_Add_to_cart_button(String productName) {
        homeLoggedInPage.clickOnAddToCartButtonByProductName(productName);
    }

    @And("opens the shopping cart")
    public void opens_the_shopping_cart() {
        homeLoggedInPage.clickOnShoppingCartButton();
        cartPage = new CartPage(webDriver);
    }

    @Then("the user should be able to see the selected product {string} in the cart")
    public void the_user_should_be_able_to_see_the_selected_product_in_the_cart(String productName) {
        boolean result = cartPage.canFindCartItemByName(productName);
        assertTrue(result);
        tearDown();
    }


    // SCENARIO: User can remove product from the shopping cart
    @And("already has {string} in the shopping cart")
    public void already_has_the_selected_product_in_the_shopping_cart(String productName) {
        is_currently_on_the_page_where_he_sees_the_products();
        he_clicks_on_the_products_Add_to_cart_button(productName);
        webDriver.get(SHOPPING_CART_URL);
        cartPage = new CartPage(webDriver);
        boolean isProductPresentInCart = cartPage.canFindCartItemByName(productName);
        assertTrue(isProductPresentInCart);
    }

    @When("he opens the shopping cart by clicking on it")
    public void he_opens_the_shopping_cart_by_clicking_on_it() {
        webDriver.get(HOME_URL);
        homeLoggedInPage = new HomeLoggedInPage(webDriver);
        homeLoggedInPage.clickOnShoppingCartButton();
        cartPage = new CartPage(webDriver);
    }

    @And("clicks on the 'Remove' button of {string}")
    public void clicks_on_the_remove_button(String productName) {
        cartPage.clickOnRemoveByProductName(productName);
    }

    @Then("the product should disappear from the shopping cart")
    public void the_product_should_disappear_from_the_shopping_cart() {
        boolean isEmpty = cartPage.isCartEmpty();
        assertTrue(isEmpty);
        tearDown();
    }
}
