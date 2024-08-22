package com.codecool.webshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends BasePage {
    private WebDriver driver;
    @FindBy(id = "react-burger-menu-btn")
    private WebElement burgerMenuButton;

    @FindBy(id="back-to-products")
    private WebElement backToProductsButton;

    @FindBy(id="add-to-cart")
    private WebElement addToCartButton;

    @FindBy(css = "div.inventory_details_name.large_size")
    private WebElement productName;

    @FindBy(css = "div.inventory_details_desc.large_size")
    private WebElement productDescription;

    @FindBy(css = "div.inventory_details_price")
    private WebElement productPrice;

    public ProductPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getProductName() {
        return productName.getText();
    }

    public String getProductDescription() {
        return productDescription.getText();
    }

    public String getProductPrice() {
        return productPrice.getText();
    }


}
