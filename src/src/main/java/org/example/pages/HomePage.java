package org.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    protected WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isWelcomeDisplayed() {
        String text = "//*[@id=\"hero-content\"]/div[3]/div[1]/div[4]/div/div/a/div[1]";
        return driver.findElement((By.xpath(text))).isDisplayed();
    }
}
