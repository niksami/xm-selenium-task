package org.example.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.PageFactory.initElements;

public class HomePage {
    protected static WebDriver driver;

    @FindBy(xpath = "//*[@id=\"hero-content\"]/div[3]/div[1]/div[4]/div/div/a/div[1]")
    protected static WebElement welcomeText;

    public HomePage(WebDriver driver) {
        HomePage.driver = driver;
    }

    private void reInitiatePage() {
        initElements(new AppiumFieldDecorator(driver, ofSeconds(10)), this);
    }


    public boolean isWelcomeDisplayed() {
        reInitiatePage();
        return welcomeText.isDisplayed();
    }
}
