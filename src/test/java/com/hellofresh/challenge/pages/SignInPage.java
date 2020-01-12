package com.hellofresh.challenge.pages;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static com.hellofresh.challenge.utilities.ExcelUtil.setCellData;

public class SignInPage extends BasePage {
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
    By aliasBy = By.id("alias");
    By submitAccountBy = By.id("submitAccount");

    //*********Assertions Web Elements*********
    By myAccountBy = By.cssSelector("h1");
    By accountBy = By.className("account");
    By infoAccountBy = By.className("info-account");
    By logoutBy = By.className("logout");


    /**
     * @param emailCreate
     * @param customerFirstName
     * @param customerLastName
     * @param password
     * @param day
     * @param month
     * @param year
     * @param company
     * @param address1
     * @param address2
     * @param city
     * @param state
     * @param postcode
     * @param other
     * @param phone
     * @param mobile
     * @param alias
     * @return
     */
    public SignInPage signIn(String emailCreate, String customerFirstName, String customerLastName, String password, String day, String month, String year,
                             String company, String address1, String address2, String city, String state, String postcode, String other, String phone, String mobile, String alias){
        writeText(emailCreateBy, emailCreate);
        click(submitCreateBy);
        click(genderBy);
        writeText(customerFirstNameBy, customerFirstName);
        writeText(customerLastNameBy, customerLastName);
        writeText(passwordBy, password);
        select(daysBy, day);
        select(monthsBy, month);
        select(yearsBy, year);
        writeText(companyBy, company);
        writeText(address1By, address1);
        writeText(address2By, address2);
        writeText(cityBy, city);
        select(stateBy, state);
        writeText(postcodeBy, postcode);
        writeText(otherBy, other);
        writeText(phoneBy, phone);
        writeText(phoneMobileBy, mobile);
        writeText(aliasBy, alias);
        click(submitAccountBy);

        return this;
    }

    /**
     * @return
     */
    public SignInPage addUsertoTestData(String value, int RowNum, int ColNum) throws Exception {
        setCellData(value, RowNum, ColNum);
        return this;
    }

    /**
     * @param expectedText
     * @return
     */
    public SignInPage verifySignInDetails(String expectedText) {
        assertEquals(myAccountBy, expectedText);
        return this;
    }

    /**
     * @param expectedName
     * @param expectedSurname
     * @return
     */
    public SignInPage verifyFirstNameLastName(String expectedName, String expectedSurname) {
        assertEquals(accountBy, expectedName + " " + expectedSurname);
        return this;
    }

    /**
     * @param expectedText
     * @return
     */
    public SignInPage verifyInfoAccount(String expectedText) {
        assertTrueContains(infoAccountBy, expectedText);
        return this;
    }

    /**
     * @return
     */
    public SignInPage verifyLogout() {
        assertTrueIsDisplayed(logoutBy);
        return this;
    }
}
