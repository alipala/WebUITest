package com.hellofresh.challenge.pages;

import io.qameta.allure.Step;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/***
 * @author
 *      Ali Pala, mailto:ali.pala@ymail.com
 *
 *  LoginPage class consists of Login page elements and methods
 */
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
    By infoAccountBy = By.className("info-account");
    By logoutBy = By.className("logout");


    /**
     * Login method with credentials comes from excel sheet
     * @param row
     *          User information located in this row
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
     * Login method get credentials from user directly
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
     *          User information located in this row
     * @return
     */
    public LoginPage verifyLoginUserName (XSSFRow row) {
        assertEquals(UsernameBy, row.getCell(1).toString() + " " + row.getCell(2).toString());
        return this;
    }

    /**
     * Verify Invalid Username Condition
     * @param expectedText
     *              Expected test to verify the message in invalid user attempt
     * @return
     */
    public LoginPage verifyInvalidUserMessage (String expectedText) {
        assertEquals(errorMessageInvalidUsernameBy, expectedText);
        return this;
    }

    /**
     * Verify Empty Username Condition
     * @param expectedText
     *              Expected test to verify the message in empty user attempt
     * @return
     */
    public LoginPage verifyEmptyUserMessage (String expectedText) {
        assertEquals(errorMessageEmptyUsernameBy, expectedText);
        return this;
    }


    /**
     * Verify the logged in account is correct
     * @param expectedText
     *              expected info account text
     * @return
     */
    public LoginPage verifyInfoAccount(String expectedText) {
        assertTrueContains(infoAccountBy, expectedText);
        return this;
    }

    /**
     * Verify logout button
     * @return
     */
    public LoginPage verifyLogout() {
        assertTrueIsDisplayed(logoutBy);
        return this;
    }
}
