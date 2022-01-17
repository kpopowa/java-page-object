package com.popowa.tests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.popowa.pageObjects.LoginPage;
import com.popowa.pageObjects.ProductListPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCartTest {
    private WebDriver driver;

    @BeforeTest
    void setupTest() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    void teardown() {
        driver.quit();
    }

    @Test
    public void userShouldSuccessfullyAddProductToCart() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.isPageLoaded()
                 .logIn("standard_user", "secret_sauce");



        ProductListPage productListPage = new ProductListPage(driver);
        productListPage.isPageLoaded();
        productListPage.addProductToCartByName("Sauce Labs Bike Light");

        WebElement checkCart = driver.findElement(By.xpath("//span[@class='shopping_cart_badge']"));
        Assert.assertEquals(checkCart.getText(), "1");

        WebElement cartButton = driver.findElement(By.xpath("//span[@class='shopping_cart_badge]"));
        cartButton.click();



    }
}
