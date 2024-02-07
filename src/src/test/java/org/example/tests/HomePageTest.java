package org.example.tests;

import org.example.pages.HomePage;
import org.example.pages.StockDetails;
import org.example.pages.StocksPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest {
    protected static WebDriver driver;
    protected static HomePage homePage;

    protected static StocksPage stocksPage;

    protected static void setupDriver() {
        testHomePageWithChrome();
    }

    private static void testHomePageWithChrome() {
        chromedriver().setup();
        driver = new ChromeDriver();
        testHomePage();
    }

    private static void testHomePageWithFirefox() {
        firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        driver = new FirefoxDriver(options);
        testHomePage();
    }

    private static void testHomePageWithEdge() {
        edgedriver().setup();
        driver = new EdgeDriver();
        testHomePage();
    }

    private static void testHomePage() {
        driver.get("https://www.xm.com");
        homePage = new HomePage(driver);
    }

    private static void testHomePageWithMaxResolution() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        testHomePage();
    }

    private static void testHomePageWith1024x768Resolution() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1024,768");
        driver = new ChromeDriver(options);
        testHomePage();
    }

    private static void testHomePageWith800x600Resolution() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=800,600");
        driver = new ChromeDriver(options);
        testHomePage();
    }

    @BeforeEach
    public void setUp() {
        setupDriver();
        homePage = new HomePage(driver);
        stocksPage = new StocksPage(driver);
    }

    @Test
    public void openHomePage() {
        assertTrue(homePage.isWelcomeDisplayed(), "Welcome text is not displayed on the home page");
    }

    @Test
    public void compareStockDetails() {
        homePage.goToStocks();
        assertEquals("Advantages of Stock CFD Trading at XM", homePage.getStockText());
        homePage.goToNorwayStocks();
        StockDetails stockDetails = stocksPage.stockDetails1();
        homePage.goToNorwayStocksDetails();
        assertEquals("ORKLA ASA (ORK.OL)", homePage.getOrklaTitle());
        StockDetails stockDetails2 = stocksPage.stockDetails2();
        assertEquals(stockDetails.getMinMaxTradeSize(), stockDetails2.getMinMaxTradeSize());
        assertEquals(stockDetails.getLimitLevels(), stockDetails2.getLimitLevels());
        assertEquals(stockDetails.getLongSwapValue(), stockDetails2.getLongSwapValue());
        assertEquals(stockDetails.getShortSwapValue(), stockDetails2.getShortSwapValue());
        assertEquals(stockDetails.getMarginPercentage(), stockDetails2.getMarginPercentage());
        assertEquals(stockDetails.getSpreadAsLow(), stockDetails2.getSpreadAsLow());
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}