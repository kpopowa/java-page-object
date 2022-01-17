package com.popowa.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDisplayed() {
        return driver.findElement(By.xpath("//input[@type='submit']")) != null;
    }

    public void open(){
        driver.get("https://www.saucedemo.com/");
    }

    public void fillLogin(String login) {
        WebElement enterUsername = driver.findElement(By.name("user-name"));
        enterUsername.sendKeys(login);
    }

    public void fillPassword(String password) {
        WebElement enterUsername = driver.findElement(By.name("password"));
        enterUsername.sendKeys(password);
    }

    public void clickLogin() {
        WebElement pressLogInButton = driver.findElement(By.xpath("//input[@type='submit']"));
        pressLogInButton.click();
    }

    public void logIn(String login, String password) {
        open();
        fillLogin(login);
        fillPassword(password);
        clickLogin();

    }

    public void isPageLoaded(){
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
    }
}
