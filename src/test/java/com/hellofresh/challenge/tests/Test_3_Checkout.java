package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.pages.CheckoutPage;
import com.hellofresh.challenge.pages.HomePage;
import com.hellofresh.challenge.utilities.ExcelUtil;
import com.hellofresh.challenge.utilities.LogUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class Test_3_Checkout extends BaseTest{

    String heading = "ORDER CONFIRMATION";
    String orderCompleteMessage = "Your order on My Store is complete.";

    @BeforeTest
    public void setUpTestData() {
        LogUtil.info("Setup Test Level Data");
        ExcelUtil.setExcelFileSheet("LoginData");
    }

    @Test(priority = 0, description = "Valid Checkout  Test")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test Description: Checkout Scenario")
    @Story("Checkout Test")
    public void validCheckoutTest() throws Exception {
        HomePage homePage = new HomePage(driver);
        CheckoutPage checkoutPage = new CheckoutPage(driver);

        LogUtil.info("Checkout test started");

        homePage.gotoHomePage()
                .goToLoginPage()
                .login(ExcelUtil.getRowData(1));

        checkoutPage.checkout()
                .verifyCheckoutHeading(heading)
                .verifyShipping()
                .verifyPayment()
                .verifyOrderComplete(orderCompleteMessage);


    }


}
