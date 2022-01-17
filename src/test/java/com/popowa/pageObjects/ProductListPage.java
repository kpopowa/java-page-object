package com.popowa.pageObjects;
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

        public ProductListPage addProductToCartByName(String productName) {
            String[] wordsInLowerCase = productName.toLowerCase(Locale.ROOT).split(" ");
            String elementId = Arrays.stream(wordsInLowerCase).collect(Collectors.joining("-"));
            WebElement addToCartButton = driver.findElement(By.id("add-to-cart-" + elementId));
            addToCartButton.click();
            return this;

        }

        public ProductListPage isPageLoaded(){
            (new WebDriverWait(driver, 20))
                    .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[text()='Products']")));
            return this;
        }
}
