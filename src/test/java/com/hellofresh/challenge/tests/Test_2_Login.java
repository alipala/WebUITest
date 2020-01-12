package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.pages.HomePage;
import com.hellofresh.challenge.pages.LoginPage;
import com.hellofresh.challenge.utilities.ExcelUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import javafx.stage.FileChooser;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

public class Test_2_Login extends BaseTest {

    String expectedFullName = "Firstname Lastname";
    String invalidUsernameMessage = "Authentication failed.";
    String emptyUsernameMessage = "An email address required.";

    @BeforeTest
    public void setUpTestData() {
        log.info("Setup Test Level Data");
        ExcelUtil.setExcelFileSheet("LoginData");
    }

    @Test(priority = 0, description = "Invalid Login Test with Invalid Credentials")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test Description: Login Scenario")
    @Story("Login Test")
    public void invalidLoginTest_InvalidUserNameInvalidPassword() throws Exception{

        log.info("Invalid Login Test with Invalid Credentials");
        HomePage homePage = new HomePage(driver);
        homePage.gotoHomePage()
                .goToLoginPage()
                .login(ExcelUtil.getRowData(2))
                .verifyInvalidUserMessage(invalidUsernameMessage);

    }

    @Test(priority = 1, description = "Invalid Login Test with Empty Credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login Scenario")
    @Story("Login Test")
    public void invalidLoginTest_EmptyUserNameEmptyPassword() throws Exception {

        log.info("Invalid Login Test with Empty Credentials");
        HomePage homePage = new HomePage(driver);
        homePage.gotoHomePage()
                .goToLoginPage()
                .login(ExcelUtil.getRowData(3))
                .verifyEmptyUserMessage(emptyUsernameMessage);
    }

    @Test(priority = 2, description = "Valid Login Test")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test Description: Login Scenario")
    @Story("Login Test")
    public void validLoginTest_ValidUserNameValidPassword() throws Exception {

        log.info("Valid Login Test");
        HomePage homePage = new HomePage(driver);
        homePage.gotoHomePage()
                .goToLoginPage()
                .login(ExcelUtil.getRowData(1))
                .verifyLoginUserName(expectedFullName);

    }
}
