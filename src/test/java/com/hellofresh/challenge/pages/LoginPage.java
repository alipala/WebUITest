package com.hellofresh.challenge.pages;

import io.qameta.allure.Step;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    By emailBy = By.id("email");
    By passwordBy = By.id("passwd");
    By submitButtonBy = By.id("SubmitLogin");
    By UsernameBy = By.cssSelector(".account > span:nth-child(1)");
    By errorMessageInvalidUsernameBy = By.xpath("//li[contains(text(),'Invalid email address.')]");
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
        writeText(emailBy, row.getCell(0).toString());
        writeText(passwordBy, row.getCell(3).toString());
        click(submitButtonBy);
        return this;
    }

    /**
     * @return
     */
    @Step("Login Step with username: {0}, password: {1}, for method: {method}")
    public LoginPage login(String username, String password) {
        writeText(emailBy, username);
        writeText(passwordBy, password);
        click(submitButtonBy);
        return this;
    }

    /**
     * Verify Valid Username Condition
     * @param row
     * @return
     */
    public LoginPage verifyLoginUserName (XSSFRow row) {
        assertEquals(UsernameBy, row.getCell(1).toString() + " " + row.getCell(2).toString());
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
