package com.codecool.webshop.stepdefinitions;

import com.codecool.webshop.pages.CartPage;
import com.codecool.webshop.pages.HomeLoggedInPage;
import com.codecool.webshop.pages.checkout.CheckoutCompletePage;
import com.codecool.webshop.pages.checkout.CheckoutFirstPage;
import com.codecool.webshop.pages.checkout.CheckoutSecondPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.jupiter.api.Assertions;

public class CheckoutSteps extends Utils {
    private HomeLoggedInPage homeLoggedInPage;
    private CartPage cartPage;
    private CheckoutFirstPage checkoutFirstPage;
    private CheckoutSecondPage checkoutSecondPage;
    private CheckoutCompletePage checkoutCompletePage;

    @Given("the user is logged in and already has {string} and {string} in the shopping cart using {string}")
    public void the_user_is_logged_in_and_already_has_and_in_the_shopping_cart_using(String firstProductName, String secondProductName, String browser) {
        openNewDriver(browser);
        loginUser();
        homeLoggedInPage = new HomeLoggedInPage(webDriver);
        homeLoggedInPage.clickOnAddToCartButtonByProductName(firstProductName);
        homeLoggedInPage.clickOnAddToCartButtonByProductName(secondProductName);
        homeLoggedInPage.clickOnShoppingCartButton();
        cartPage = new CartPage(webDriver);
    }

    @And("clicked checkout button in the shopping cart")
    public void clicked_checkout_button_in_the_shopping_cart() {
        cartPage.clickCheckoutBtn();
    }

    @When("the user fills out the checkout information form with valid information {string} {string} {string}")
    public void the_user_fills_out_the_checkout_information_form_with_valid_information(String firstName, String lastName, String postalCode) {
        checkoutFirstPage = new CheckoutFirstPage(webDriver);
        checkoutFirstPage.fillFirstNameInputField(firstName);
        checkoutFirstPage.fillLastNameInputField(lastName);
        checkoutFirstPage.fillPostalCodeInputField(postalCode);
        checkoutFirstPage.clickOnContinueBtn();
    }

    @And("completes the necessary checkout steps")
    public void completes_the_necessary_checkout_steps() {
        checkoutSecondPage = new CheckoutSecondPage(webDriver);
        checkoutSecondPage.clickFinishBtn();
    }

    @Then("the user should be able to successfully complete their order")
    public void the_user_should_be_able_to_successfully_complete_their_order() {
        checkoutCompletePage = new CheckoutCompletePage(webDriver);
        boolean isOrderSuccessful = checkoutCompletePage.validateOrderSuccess();
        tearDown();
        Assertions.assertTrue(isOrderSuccessful);
    }


    // _________________________________________________________________________________________________________________


    @When("the user fills out the checkout information form with the following information {string} {string} {string}")
    public void the_user_filled_out_the_checkout_information_form_with_the_following_information(String firstName, String lastName, String postalCode) {
        cartPage.clickCheckoutBtn();
        checkoutFirstPage = new CheckoutFirstPage(webDriver);
        checkoutFirstPage.fillFirstNameInputField(firstName);
        checkoutFirstPage.fillLastNameInputField(lastName);
        checkoutFirstPage.fillPostalCodeInputField(postalCode);
        checkoutFirstPage.clickOnContinueBtn();
    }

    @Then("the overview displayed the correct prices {string} {string} {string} are shown")
    public void the_overview_is_displayed_the_correct_prices_are_shown(String itemTotal, String tax, String total) {
        checkoutSecondPage = new CheckoutSecondPage(webDriver);
        boolean isPriceCorrect = checkoutSecondPage.validateShownPrices(
                Double.parseDouble(itemTotal), Double.parseDouble(tax), Double.parseDouble(total));
        checkoutSecondPage.clickFinishBtn();

        checkoutCompletePage = new CheckoutCompletePage(webDriver);
        boolean isOrderSuccessful = checkoutCompletePage.validateOrderSuccess();

        tearDown();
        Assertions.assertEquals(isOrderSuccessful, isPriceCorrect);
    }
}
