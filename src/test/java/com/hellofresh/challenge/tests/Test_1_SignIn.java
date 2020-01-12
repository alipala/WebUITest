package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.WebTest;
import com.hellofresh.challenge.pages.HomePage;
import com.hellofresh.challenge.pages.SignInPage;
import com.hellofresh.challenge.utilities.ExcelUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Date;

public class Test_1_SignIn extends BaseTest{
    Logger log = Logger.getLogger(WebTest.class.getName());
    String timestamp = String.valueOf(new Date().getTime());
    String userEmail = "hf_challenge_" + timestamp + "@hf" + timestamp.substring(7) + ".com";
    String name = "Firstname";
    String surname = "Lastname";
    String password = "Qwerty";
    String days = "1";
    String months = "1";
    String years = "2000";
    String company = "Company";
    String address1 = "Qwerty, 123";
    String address2 = "zxcvb";
    String city = "Qwerty";
    String id_state = "6"; //Colorado
    String postcode = "12345";
    String other = "Qwerty";
    String phone = "12345123123";
    String phone_mobile = "12345123123";
    String alias = "hf";
    String heading = "MY ACCOUNT";

    @BeforeTest
    public void setUpTestData() {
        log.info("Setup Test Level Data");
        ExcelUtil.setExcelFileSheet("LoginData");
    }

    @Test(priority = 0, description = "Valid Sign In Test")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Sign In Scenario")
    @Story("Sign In Test")
    public void validSignInTest() throws Exception {
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);

        log.info("User email: " + userEmail);

        homePage.gotoHomePage()
                .goToLoginPage();

        signInPage.addUsertoTestData(userEmail,1,1)
                .signIn(userEmail, name, surname, password, days, months, years, company, address1, address2, city, id_state, postcode, other, phone, phone_mobile, alias)
                .verifySignInDetails(heading);
    }
}
