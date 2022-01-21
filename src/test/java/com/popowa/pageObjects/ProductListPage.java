package com.popowa.pageObjects;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

public class ProductListPage {
        private WebDriver driver;

        public ProductListPage(WebDriver driver) {
            this.driver = driver;
        }
    @Step ("Add product to card by name")
    public ProductListPage addProductToCartByName(String productName) {
            String[] wordsInLowerCase = productName.toLowerCase(Locale.ROOT).split(" ");
            String elementId = Arrays.stream(wordsInLowerCase).collect(Collectors.joining("-"));
            WebElement addToCartButton = driver.findElement(By.id("add-to-cart-" + elementId));
            addToCartButton.click();
            return this;

        }
    @Step ("Check if the page is loaded")
    public ProductListPage isPageLoaded(){
            (new WebDriverWait(driver, 20))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Products']")));
            return this;
        }
}
