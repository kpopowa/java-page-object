package com.popowa.pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

    public class AddProductPage {
        private WebDriver driver;

        public AddProductPage(WebDriver driver) {
            this.driver = driver;

       public void chooseProduct(){
        driver.get("//input[@type='submit']");
            }

            public void fillLogIn(String login){
           WebDriver enterUserName = driver.findElement(By.name("user-name"));
           enterUserName.sendK
            }
        }
}
