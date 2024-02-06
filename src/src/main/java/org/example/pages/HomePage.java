package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;

    private String logo = "//*[@id=\"navigation-collapse\"]/div/div[1]/a[1]";

    public HomePage(WebDriver driver) {
        this.driver = driver;
        //PageFactory.initElements(driver, this);
    }

    public boolean isLogoDisplayed() {
        return driver.findElement((By.xpath(logo))).isDisplayed();
    }
}
