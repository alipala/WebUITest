package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/***
 * @author
 *      Ali Pala, mailto:ali.pala@ymail.com
 *
 * BasePage class consists of methods like;
 * to sendkeys, waitvisibility of the element,
 * select dropbox value and read data from an element
 */

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    /**
     * Constructor
     *
     * @param driver Webdriver
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }


    /**
     * Wait Wrapper Method
     *
     * @param elementBy element locator object
     */
    public void waitVisibility(By elementBy) {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(elementBy));
    }


    /**
     * Click Method
     *
     * @param elementBy element locator object
     */
    public void click(By elementBy) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).click();
    }


    /**
     * Select Method
     *
     * @param elementBy element locator object
     * @param value     desired value in dropbox
     */
    public void select(By elementBy, String value) {
        Select select = new Select(driver.findElement(elementBy));
        select.selectByValue(value);
    }


    /**
     * Write Text
     *
     * @param elementBy element locator object
     * @param text      send desired text to the element
     */
    public void writeText(By elementBy, String text) {
        waitVisibility(elementBy);
        driver.findElement(elementBy).sendKeys(text);
    }

    /***
     * Read Text
     * @param elementBy
     *          element locator object
     * @return
     *
     */
    public String readText(By elementBy) {
        waitVisibility(elementBy);
        return driver.findElement(elementBy).getText();
    }


    /**
     * Assert Equals
     *
     * @param elementBy    element locator object
     * @param expectedText expected test to be used in assertion
     */
    public void assertEquals(By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertEquals(readText(elementBy), expectedText);
    }


    /**
     * Assert True assertion to verify the element is displayed
     *
     * @param elementBy element locator object
     */
    public void assertTrueIsDisplayed(By elementBy) {
        waitVisibility(elementBy);
        Assert.assertTrue(driver.findElement(elementBy).isDisplayed());
    }


    /**
     * Assert True assertion to verify the element contains the correct data
     *
     * @param elementBy    element locator object
     * @param expectedText expected test to be used in assertion
     */
    public void assertTrueContains(By elementBy, String expectedText) {
        waitVisibility(elementBy);
        Assert.assertTrue(driver.findElement(elementBy).getText().contains(expectedText));
    }

}
