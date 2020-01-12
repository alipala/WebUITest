package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage{
    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    //*********Web Elements*********
    By womenBy = By.linkText("Women");
    By thsirtBy = By.xpath("//a[@title='Faded Short Sleeve T-shirts']/ancestor::li");
    By submitBy = By.name("Submit");
    By proceedToCheckoutBy = By.xpath("//*[@id='layer_cart']//a[@class and @title='Proceed to checkout']");
    By cartNavigationProceedToCheckoutBy = By.xpath("//*[contains(@class,'cart_navigation')]/a[@title='Proceed to checkout']");
    By processAddressBy = By.name("processAddress");
    By uniformBy = By.id("uniform-cgv");
    By processCarrierBy = By.name("processCarrier");
    By bankwire = By.className("bankwire");
    By cartNavigationButtonBy = By.xpath("//*[@id='cart_navigation']/button");
    By headingBy = By.cssSelector("h1");

    //*********Assertions Web Elements*********
    By shippingBy = By.xpath("//li[@class='step_done step_done_last four']"); //Shipping displayed
    By paymentBy = By.xpath("//li[@id='step_end' and @class='step_current last']"); //Payment displayed
    By orderCompleteBy = By.xpath("//*[@class='cheque-indent']/strong"); //Order Complete contains

    /**
     * @return
     */
    public CheckoutPage checkout() {
        click(womenBy);
        click(thsirtBy);
        click(submitBy);
        click(proceedToCheckoutBy);
        click(cartNavigationProceedToCheckoutBy);
        click(processAddressBy);
        click(uniformBy);
        click(processCarrierBy);
        click(bankwire);
        click(cartNavigationButtonBy);

        return this;
    }

    /**
     * @param expectedText
     * @return
     */
    public CheckoutPage verifyCheckoutHeading(String expectedText) {
        assertEquals(headingBy, expectedText);
        return this;
    }

    public CheckoutPage verifyShipping() {
        assertTrueIsDisplayed(shippingBy);
        return this;
    }

    public CheckoutPage verifyPayment() {
        assertTrueIsDisplayed(paymentBy);
        return this;
    }

    public CheckoutPage verifyOrderComplete(String expectedText) {
        assertTrueContains(orderCompleteBy, expectedText);
        return this;
    }
}
