package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.constants.Constants;
import com.hellofresh.challenge.pages.HomePage;
import com.hellofresh.challenge.utilities.ExcelUtil;
import com.hellofresh.challenge.utilities.LogUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test_3_Login extends BaseTest {

    @BeforeTest
    public void setUpTestData() {
        LogUtil.info("Setup Test Level Data");
        ExcelUtil.setExcelFileSheet("SigninData");
    }

    @Test(priority = 0, description = "Invalid Login Test with Invalid Credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login Scenario")
    @Story("Login Test")
    public void invalidLoginTest_InvalidUserNameInvalidPassword() throws Exception{

        LogUtil.info("Invalid Login Test with Invalid Credentials");

        HomePage homePage = new HomePage(driver);
        homePage.gotoHomePage()
                .goToLoginPage()
                .login(ExcelUtil.getRowData(1))
                .verifyInvalidUserMessage(Constants.INVALID_USERNAME_MESSAGE);

    }

    @Test(priority = 1, description = "Invalid Login Test with Empty Credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login Scenario")
    @Story("Login Test")
    public void invalidLoginTest_EmptyUserNameEmptyPassword() throws Exception {

        LogUtil.info("Invalid Login Test with Empty Credentials");

        HomePage homePage = new HomePage(driver);
        homePage.gotoHomePage()
                .goToLoginPage()
                .login(ExcelUtil.getRowData(3))
                .verifyEmptyUserMessage(Constants.EMPTY_USERNAME_MESSAGE);
    }

    @Test(priority = 2, description = "Valid Login Test")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login Scenario")
    @Story("Login Test")
    public void validLoginTest_ValidUserNameValidPassword() throws Exception {

        LogUtil.info("Valid Login Test");

        HomePage homePage = new HomePage(driver);
        homePage.gotoHomePage()
                .goToLoginPage()
                .login(ExcelUtil.getRowData(0))
                .verifyLoginUserName(ExcelUtil.getRowData(0))
                .verifyInfoAccount(Constants.INFO_ACCOUNT_MESSAGE)
                .verifyLogout();


    }
}
