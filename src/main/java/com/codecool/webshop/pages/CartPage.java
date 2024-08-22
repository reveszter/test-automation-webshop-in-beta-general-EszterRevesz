package com.codecool.webshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class CartPage extends BasePage {
    private By cartItemBy = By.xpath(".//div[@class='cart_item']");
    private By inventoryItemNameBy = By.xpath(".//div[@class='inventory_item_name']");

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkoutBtn;

    public CartPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public boolean canFindCartItemByName(String productName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        List<WebElement> cartItems = driver.findElements(cartItemBy);
        for (WebElement cartItem : cartItems) {
            String pName = cartItem.findElement(inventoryItemNameBy).getText();
            if (pName.equals(productName)) return true;
        }

        return false;
    }

    public void clickOnRemoveByProductName(String productName) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        List<WebElement> cartItems = driver.findElements(cartItemBy);
        for (WebElement cartItem : cartItems) {
            String pName = cartItem.findElement(inventoryItemNameBy).getText();
            if (pName.equals(productName)) {
                cartItem.findElement(By.xpath(".//button[contains(@id, 'remove-')]")).click();
                return;
            }
        }

    }

    public boolean isCartEmpty() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        List<WebElement> cartItems = driver.findElements(cartItemBy);
        return cartItems.isEmpty();
    }

    public void clickCheckoutBtn() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutBtn)).click();
    }
}
