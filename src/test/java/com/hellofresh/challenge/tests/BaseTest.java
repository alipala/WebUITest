package com.hellofresh.challenge.tests;

import com.ctc.wstx.evt.WEntityDeclaration;
import com.hellofresh.challenge.utilities.FakeUserUtil;
import com.hellofresh.challenge.utilities.LogUtil;
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

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", "src/test/resources/geckodriver.exe");
        driver = new FirefoxDriver();
        wait = new WebDriverWait(driver, 10, 50);
        //Maximize Window
        driver.manage().window().maximize();
        LogUtil.startLog("Driver is initialized");
    }

    @AfterClass
    public void cleanUp() {
        driver.quit();
        LogUtil.endLog("Test is finished");
    }
}
