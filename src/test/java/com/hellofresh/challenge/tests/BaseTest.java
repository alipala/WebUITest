package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.WebTest;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {
    public WebDriver driver;
    public WebDriverWait wait;

    // Test data excel file
    public static final String testDataExcelFileName = "testdata.xlsx";
    Logger log = Logger.getLogger(WebTest.class.getName());

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10, 50);
        //Maximize Window
        driver.manage().window().maximize();
        log.info("Driver is initialized");
    }

    @AfterClass
    public void cleanUp() {
        driver.quit();
        log.info("Browser closed");
    }
}
