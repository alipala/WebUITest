package com.hellofresh.challenge.pages;

import io.qameta.allure.Step;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import sun.rmi.runtime.Log;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    By emailBy = By.id("email");
    By passwordBy = By.id("passwd");
    By submitButtonBy = By.id("SubmitLogin");
    By UsernameBy = By.cssSelector(".account > span:nth-child(1)");
    By errorMessageInvalidUsernameBy = By.xpath("//li[contains(text(),'Authentication failed.')]");
    By errorMessageEmptyUsernameBy = By.xpath("//li[contains(text(),'An email address required.')]");

    //*********Assertions Web Elements*********
    By accountBy = By.className("account");
    By infoAccountBy = By.className("info-account");
    By logoutBy = By.className("logout");


    /**
     * @param row
     * @return
     */
    @Step("Login Step with username: {0}, password: {1}, for method: {method}")
    public LoginPage login(XSSFRow row) {
        writeText(emailBy, row.getCell(1).toString());
        writeText(passwordBy, row.getCell(2).toString());
        click(submitButtonBy);
        return this;
    }

    /**
     * Verify Valid Username Condition
     * @param expectedText
     * @return
     */
    public LoginPage verifyLoginUserName (String expectedText) {
        assertEquals(UsernameBy, expectedText);
        return this;
    }

    /**
     * Verify Invalid Username Condition
     * @param expectedText
     * @return
     */
    public LoginPage verifyInvalidUserMessage (String expectedText) {
        assertEquals(errorMessageInvalidUsernameBy, expectedText);
        return this;
    }

    /**
     * Verify Empty Username Condition
     * @param expectedText
     * @return
     */
    public LoginPage verifyEmptyUserMessage (String expectedText) {
        assertEquals(errorMessageEmptyUsernameBy, expectedText);
        return this;
    }


    /**
     * @param expectedText
     * @return
     */
    public LoginPage verifyInfoAccount(String expectedText) {
        assertTrueContains(infoAccountBy, expectedText);
        return this;
    }

    /**
     * @return
     */
    public LoginPage verifyLogout() {
        assertTrueIsDisplayed(logoutBy);
        return this;
    }
}
