package org.example.tests;

import org.example.pages.HomePage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.safari.SafariDriver;

import static io.github.bonigarcia.wdm.WebDriverManager.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomePageTest {
    protected static WebDriver driver;
    protected static HomePage homePage;

    protected static void setupDriver() {
        testHomePageWith1024x768Resolution();
    }

    private static void testHomePageWithChrome() {
        chromedriver().setup();
        driver = new ChromeDriver();
        testHomePage(driver);
    }

    private static void testHomePageWithFirefox() {
        firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--width=2560");
        options.addArguments("--height=1440");
        driver = new FirefoxDriver(options);
    }

    private static void testHomePageWithEdge() {
        edgedriver().setup();
        driver = new EdgeDriver();
        testHomePage(driver);
    }

    private static void testHomePageWithSafari() {
        driver = new SafariDriver();
        testHomePage(driver);
    }

    private static void testHomePage(WebDriver driver) {
        driver.manage().window().maximize();
        driver.get("https://www.xm.com");
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isLogoDisplayed(), "Logo is not displayed on the home page");
    }

    private static void testHomePageWithMaxResolution() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.xm.com");
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isLogoDisplayed(), "Logo is not displayed on the home page");
    }

    private static void testHomePageWith1024x768Resolution() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1024,768");
        driver = new ChromeDriver(options);
        driver.get("https://www.xm.com");
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isLogoDisplayed(), "Logo is not displayed on the home page");
    }

    private static void testHomePageWith800x600Resolution() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=800,600");
        driver = new ChromeDriver(options);
        driver.get("https://www.xm.com");
        HomePage homePage = new HomePage(driver);
        assertTrue(homePage.isLogoDisplayed(), "Logo is not displayed on the home page");
    }

    @BeforeEach
    public void setUp() {
        setupDriver();
        homePage = new HomePage(driver);
    }

    @Test
    public void openHomePage() {
        assertTrue(homePage.isLogoDisplayed(), "Logo is not displayed on the home page");
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}