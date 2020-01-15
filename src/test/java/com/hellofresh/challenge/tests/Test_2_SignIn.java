package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.constants.Constants;
import com.hellofresh.challenge.listeners.TestAllureListener;
import com.hellofresh.challenge.pages.HomePage;
import com.hellofresh.challenge.pages.SignInPage;
import com.hellofresh.challenge.utilities.ExcelUtil;
import com.hellofresh.challenge.utilities.LogUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


/***
 * @author
 *      Ali Pala, mailto:ali.pala@ymail.com
 */

@Listeners({TestAllureListener.class})
public class Test_2_SignIn extends BaseTest {
    String heading = "MY ACCOUNT";

    @BeforeTest
    public void setUpTestData() throws Exception {
        LogUtil.info("Setup Test Level Data");
        ExcelUtil.setExcelFileSheet("SigninData");
    }

    @Test(priority = 0, description = "Valid Sign In Test")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Sign In Scenario")
    @Story("Sign In Test")
    public void validSignInTest() throws Exception {
        LogUtil.info("Valid Sign In Test Started");
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);

        homePage.gotoHomePage()
                .goToLoginPage();

        signInPage.signIn(ExcelUtil.getRowData(0))
                .verifySignInDetails(heading)
                .verifyFirstNameLastName(ExcelUtil.getRowData(0))
                .verifyInfoAccount(Constants.INFO_ACCOUNT_MESSAGE)
                .verifyLogout();
    }

    @Test(priority = 0, description = "Invalid Sign In Test")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Sign In Scenario")
    @Story("Sign In Test")
    public void invalidSignInTest_WithExistingAccount() throws Exception {
        LogUtil.info("Invalid Signin with Existing Account Test Started");
        HomePage homePage = new HomePage(driver);
        SignInPage signInPage = new SignInPage(driver);

        homePage.gotoHomePage()
                .goToLoginPage();

        signInPage.enterExistingEmail(ExcelUtil.getRowData(0))
                .verifyAccountRegistered(Constants.ACCOUNT_ALREADY_REGISTERED_MESSAGE);


    }
}
