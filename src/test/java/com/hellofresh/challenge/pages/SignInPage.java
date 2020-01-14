package com.hellofresh.challenge.pages;

import com.hellofresh.challenge.utilities.FakeUserUtil;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/***
 * @author
 *      Ali Pala, mailto:ali.pala@ymail.com
 * Sign in Page elements and methods
 */
public class SignInPage extends BasePage {

    FakeUserUtil user = new FakeUserUtil();

    public SignInPage(WebDriver driver) {
        super(driver);
    }


    //*********Web Elements*********
    By emailCreateBy = By.id("email_create");
    By submitCreateBy = By.id("SubmitCreate");
    By genderBy = By.id("id_gender2");
    By customerFirstNameBy = By.id("customer_firstname");
    By customerLastNameBy = By.id("customer_lastname");
    By passwordBy = By.id("passwd");
    By daysBy = By.id("days");
    By monthsBy = By.id("months");
    By yearsBy = By.id("years");
    By companyBy = By.id("company");
    By address1By = By.id("address1");
    By address2By = By.id("address2");
    By cityBy = By.id("city");
    By stateBy = By.id("id_state");
    By postcodeBy = By.id("postcode");
    By otherBy = By.id("other");
    By phoneBy = By.id("phone");
    By phoneMobileBy = By.id("phone_mobile");
    By submitAccountBy = By.id("submitAccount");

    //*********Assertions Web Elements*********
    By myAccountBy = By.cssSelector("h1");
    By accountBy = By.className("account");
    By infoAccountBy = By.className("info-account");
    By logoutBy = By.className("logout");


    /**
     * Sign in form elements
     * @param row
     * @return
     */
    public SignInPage signIn(XSSFRow row) {

        writeText(emailCreateBy, row.getCell(0).toString());
        click(submitCreateBy);
        click(genderBy);
        writeText(customerFirstNameBy, row.getCell(1).toString());
        writeText(customerLastNameBy, row.getCell(2).toString());
        writeText(passwordBy, row.getCell(3).toString());
        select(daysBy, row.getCell(4).toString());
        select(monthsBy, row.getCell(5).toString());
        select(yearsBy, row.getCell(6).toString());
        writeText(companyBy, row.getCell(7).toString());
        writeText(address1By, row.getCell(8).toString());
        writeText(address2By, row.getCell(9).toString());
        writeText(cityBy, row.getCell(10).toString());
        select(stateBy, "6");
        writeText(postcodeBy, row.getCell(11).toString());
        writeText(phoneBy, row.getCell(12).toString());
        writeText(phoneMobileBy, row.getCell(13).toString());
        click(submitAccountBy);

        return this;
    }


    /**
     * Verify sign in details with expected text
     * @param expectedText
     *              Expected text
     * @return
     */
    public SignInPage verifySignInDetails(String expectedText) {
        assertEquals(myAccountBy, expectedText);
        return this;
    }

    /**
     * Verify first name and last name after log in
     * @param row
     *          User information located in this row
     * @return
     */
    public SignInPage verifyFirstNameLastName(XSSFRow row) {

        assertEquals(accountBy, row.getCell(1).toString() + " " + row.getCell(2).toString());
        return this;
    }

    /**
     * Verify account info
     * @param expectedText
     *              Expected text
     * @return
     */
    public SignInPage verifyInfoAccount(String expectedText) {
        assertTrueContains(infoAccountBy, expectedText);
        return this;
    }

    /**
     * Verify logout link
     * @return
     */
    public SignInPage verifyLogout() {
        assertTrueIsDisplayed(logoutBy);
        return this;
    }
}
