package com.popowa.tests;

import com.popowa.pageObjects.LoginPage;
import com.popowa.utils.AllureUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTest {

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

    @Test (priority = 3, description = "User should Login Successfully With Valid Credentials")
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open();
        loginPage.isPageLoaded();
        loginPage.fillLogin("standard_user");
        loginPage.fillPassword("secret_sauce");
        loginPage.clickLogin();

        WebElement confirmLogIn = driver.findElement(By.xpath("//span[@class='title']"));
        Assert.assertTrue(confirmLogIn.isDisplayed());
    }

    @Test
    public void userShouldNotLoginSuccessfullyWithNotValidCredentials() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.open()
                 .fillLogin("standard_user")
                 .fillPassword("wrong_password")
                 .clickLogin();

        Assert.assertTrue(loginPage.isDisplayed());

        AllureUtils.takeScreenshot(driver);
    }
}
