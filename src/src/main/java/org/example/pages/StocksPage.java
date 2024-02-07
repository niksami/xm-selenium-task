package org.example.pages;

import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import lombok.SneakyThrows;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import static java.time.Duration.ofSeconds;
import static org.openqa.selenium.support.PageFactory.initElements;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class StocksPage {
    protected static WebDriver driver;
    @FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[6]")
    protected static WebElement longSwapValueField;
    @FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[7]")
    protected static WebElement shortSwapValueField;
    @FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[8]")
    protected static WebElement limitLevelField;
    @FindBy(xpath = "//*[@id=\"instrument-inner-page\"]/div[1]/div/div[2]/table/tbody/tr[3]/td[2]/span")
    protected static WebElement longSwapValueField2;
    @FindBy(xpath = "//*[@id=\"instrument-inner-page\"]/div[1]/div/div[2]/table/tbody/tr[4]/td[2]/span")
    protected static WebElement shortSwapValueField2;
    @FindBy(xpath = "//*[@id=\"instrument-inner-page\"]/div[1]/div/div[2]/table/tbody/tr[5]/td[2]/span")
    protected static WebElement limitLevelField2;
    protected StockDetails stockDetails1;
    protected StockDetails stockDetails2;
    @FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[3]")
    protected WebElement spreadAsLowField;
    @FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[4]")
    protected WebElement minMaxTradeSizeField;
    @FindBy(xpath = "//*[@id=\"DataTables_Table_0\"]/tbody/tr/td[5]")
    protected WebElement marginPercentageField;
    @FindBy(xpath = "//*[@id=\"instrument-inner-page\"]/div[1]/div/div[2]/table/tbody/tr[1]/td[2]/span/strong")
    protected WebElement spreadAsLowField2;
    @FindBy(xpath = "//*[@id=\"instrument-inner-page\"]/div[1]/div/div[2]/table/tbody/tr[2]/td[2]")
    protected WebElement minMaxTradeSizeField2;
    @FindBy(xpath = "//*[@id=\"instrument-inner-page\"]/div[1]/div/div[1]/table/tbody/tr[1]/td[2]/span/strong")
    protected WebElement marginPercentageField2;

    public StocksPage(WebDriver driver) {
        this.driver = driver;
    }

    private void reInitiatePage() {
        initElements(new AppiumFieldDecorator(driver, ofSeconds(10)), this);
    }

    @SneakyThrows
    public StockDetails stockDetails1() {
        reInitiatePage();
        WebDriverWait webDriverWait = new WebDriverWait(driver, ofSeconds(20));
        webDriverWait.until(visibilityOf(spreadAsLowField));
        return stockDetails1 = new StockDetails(spreadAsLowField.getText(), minMaxTradeSizeField.getText(), marginPercentageField.getText(), longSwapValueField.getText(), shortSwapValueField.getText(), limitLevelField.getText());
    }

    @SneakyThrows
    public StockDetails stockDetails2() {
        reInitiatePage();
        WebDriverWait webDriverWait = new WebDriverWait(driver, ofSeconds(20));
        webDriverWait.until(visibilityOf(spreadAsLowField2));
        return stockDetails2 = new StockDetails(spreadAsLowField2.getText(), minMaxTradeSizeField2.getText(), marginPercentageField2.getText(), longSwapValueField2.getText(), shortSwapValueField2.getText(), limitLevelField2.getText());
    }

}
