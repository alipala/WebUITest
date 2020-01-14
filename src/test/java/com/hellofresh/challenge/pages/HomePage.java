package com.hellofresh.challenge.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/***
 * @author
 *      Ali Pala, mailto:ali.pala@ymail.com
 *
 * The HomePage class consists of url, initial login button in homepage
 * gotoHomePage() method and goToLoginPage()
 */
public class HomePage extends BasePage {

    // Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    String baseURL = "http://automationpractice.com/index.php";

    //*********Web Elements*********
    By loginButtonBy = By.className("login");

    //*********Page Methods*********
    //Go to Homepage
    public HomePage gotoHomePage (){
        driver.get(baseURL);
        return this;
    }
    //Go to LoginPage
    public LoginPage goToLoginPage (){
        click(loginButtonBy);
        return new LoginPage(driver);
    }

}
