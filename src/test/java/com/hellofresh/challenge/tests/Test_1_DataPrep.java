package com.hellofresh.challenge.tests;

import com.hellofresh.challenge.utilities.ExcelUtil;
import com.hellofresh.challenge.utilities.FakeUserUtil;
import com.hellofresh.challenge.utilities.LogUtil;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/***
 * @author
 *      Ali Pala, mailto:ali.pala@ymail.com
 */
public class Test_1_DataPrep {

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
        FakeUserUtil user = new FakeUserUtil();
        user.addUsersTestData();

    }

}
