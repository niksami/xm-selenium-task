package org.example.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.SneakyThrows;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePage {
    protected static WebDriver driver;

    @FindBy(xpath = "//*[@id=\"hero-content\"]/div[3]/div[1]/div[4]/div/div/a/div[1]")
    protected static WebElement welcomeText;

    @FindBy(xpath = "//*[@id=\"main-nav\"]/li[2]/a")
    protected static WebElement tradingLink;

    @FindBy(xpath = "//*[@id=\"main-nav\"]/li[2]/div/div/div[1]/div[2]/ul/li[3]/a")
    protected static WebElement stocksLink;

    @FindBy(xpath = "//*[@id=\"top\"]/div[3]/div/div[6]/h2")
    protected static WebElement stocksText;

    @FindBy(xpath = "//*[@id=\"cookieModal\"]/div/div/div[1]/div[3]/div[2]/div[3]/button")
    protected static WebElement acceptCookies;

    @FindBy(xpath = "//*[@id=\"cash\"]/div/div[1]/button[12]")
    protected static WebElement norwayStocks;

    @FindBy(xpath = "//*[@id=\"DataTables_Table_0_filter\"]/label/input")
    protected static WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[9]/a")
    protected static WebElement orklaMore;

    @FindBy(xpath = "//*[@id=\"top\"]/div[3]/div/div[3]/div/div/div[1]/h1")
    protected static WebElement orklaTitle;


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

    @SneakyThrows
    public void goToStocks() {
        reInitiatePage();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(visibilityOf(acceptCookies));
        acceptCookies.click();
        webDriverWait.until(visibilityOf(tradingLink));
        tradingLink.click();
        webDriverWait.until(visibilityOf(stocksLink));
        stocksLink.click();
        webDriverWait.until(visibilityOf(stocksText));
    }

    @SneakyThrows
    public void goToNorwayStocks() {
        reInitiatePage();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(20));
        webDriverWait.until(visibilityOf(norwayStocks));
        scrollToElement(norwayStocks);
        norwayStocks.click();
        webDriverWait.until(visibilityOf(searchBar));
        searchBar.sendKeys("Orkla");
        webDriverWait.until(visibilityOf(orklaMore));
        orklaMore.click();
    }

    public String getStockText() {
        return stocksText.getText();
    }

    public String getOrklaTitle() {
        return orklaTitle.getText();
    }

    public void scrollToElement(WebElement element) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

}
