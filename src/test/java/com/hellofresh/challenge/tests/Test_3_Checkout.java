package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.WebTest;
import com.hellofresh.challenge.pages.CheckoutPage;
import com.hellofresh.challenge.pages.HomePage;
import com.hellofresh.challenge.pages.LoginPage;
import com.hellofresh.challenge.utilities.ExcelUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test_3_Checkout extends BaseTest{
    Logger log = Logger.getLogger(WebTest.class.getName());
    String heading = "ORDER CONFIRMATION";

    @BeforeTest
    public void setUpTestData() {
        log.info("Setup Test Level Data");
        ExcelUtil.setExcelFileSheet("LoginData");
    }

    @Test(priority = 0, description = "Valid Checkout  Test")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Checkout Scenario")
    @Story("Checkout Test")
    public void validCheckoutTest() throws Exception {
        HomePage homePage = new HomePage(driver);
        LoginPage loginPage = new LoginPage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        log.info("Checkout test started");

        homePage.gotoHomePage()
                .goToLoginPage()
                .login(ExcelUtil.getRowData(1));

        checkoutPage.checkout()
                .verifyCheckoutDetails(heading);

    }
}
