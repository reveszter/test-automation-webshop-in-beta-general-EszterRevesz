package com.codecool.webshop.stepdefinitions;

import com.codecool.webshop.pages.StarterPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public abstract class Utils {
    private StarterPage starterPage;

    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected final String BASE_URL = "https://www.saucedemo.com/";
    protected final String HOME_URL = "https://www.saucedemo.com/inventory.html";
    protected final String USERNAME = "standard_user";
    protected final String PASSWORD = "secret_sauce";

    public void openNewDriver(String browser) throws MalformedURLException {
        String remoteWebDriverUrl = "http://localhost:4444/wd/hub";
        switch (browser.toLowerCase()) {
            case "edge":
                webDriver = new RemoteWebDriver(new URL(remoteWebDriverUrl), new EdgeOptions());
                break;
            case "firefox":
                webDriver = new RemoteWebDriver(new URL(remoteWebDriverUrl), new FirefoxOptions());
                break;
            case "chrome":
                webDriver = new RemoteWebDriver(new URL(remoteWebDriverUrl), new ChromeOptions());
                break;
            default:
                throw new IllegalArgumentException("Browser not supported: " + browser);
        }
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        webDriver.get(BASE_URL);
    }

//    public void openNewDriver() {
//        webDriver = new FirefoxDriver();
//        wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
//        webDriver.get(BASE_URL);
//    }

    public void quitDriver() {
        webDriver.quit();
    }

    public void loginUser() {
        starterPage = new StarterPage(webDriver);
        starterPage.fillUserNameInput(USERNAME);
        starterPage.fillPasswordInput(PASSWORD);
        starterPage.clickLoginButton();
    }

    public void waitForElementVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (Exception ignored) {
        }
    }

    public void tearDown() {
        quitDriver();
    }
}
