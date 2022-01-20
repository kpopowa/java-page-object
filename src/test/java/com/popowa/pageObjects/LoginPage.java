package com.popowa.pageObjects;

import io.qameta.allure.Step;
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
     @Step ("Определить видимость кнопки Login")
    public boolean isDisplayed() {
        return driver.findElement(By.xpath("//input[@type='submit']")) != null;
    }
    @Step ("Открыть Log in page")
    public LoginPage open(){
        driver.get("https://www.saucedemo.com/");
        return this;
    }
    @Step ("Fill login input")
    public LoginPage fillLogin(String login) {
        WebElement enterUsername = driver.findElement(By.name("user-name"));
        enterUsername.sendKeys(login);
        return this;
    }
    @Step ("Fill password input")
    public LoginPage fillPassword(String password) {
        WebElement enterUsername = driver.findElement(By.name("password"));
        enterUsername.sendKeys(password);
        return this;
    }
    @Step ("Click login button")
    public void clickLogin() {
        WebElement pressLogInButton = driver.findElement(By.xpath("//input[@type='submit']"));
        pressLogInButton.click();
    }
    @Step ("Log in")
    public LoginPage logIn(String login, String password) {
        open();
        fillLogin(login);
        fillPassword(password);
        clickLogin();
        return this;

    }
    @Step ("Check if the page is loaded")
    public LoginPage isPageLoaded(){
        (new WebDriverWait(driver, 20))
                .until(ExpectedConditions.elementToBeClickable(By.id("login-button")));
        return this;
    }
}
