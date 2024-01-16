package com.projects.testcases;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
import org.projects.pages.HomePage;
import org.projects.pages.SignInPage;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest{
    HomePage homePage;
    SignInPage signInPage;

    @BeforeTest
    public void setup(){
        homePage = new HomePage(super.driver);
    }

    @Test(priority = 0, description = "Invalid Login Scenario with wrong username and password.")
    @Description("Test Description: Login test with wrong username and wrong password.")
    @Severity(SeverityLevel.BLOCKER)
    @Story("Invalid username and password login test")
    public void accessHomePage(){
        homePage.goToHomePage("https://www.zoho.com/en-in/crm/");
        signInPage= homePage.clickSignIn();
        Assert.assertEquals(signInPage.signInHeader(),"Sign in");
        signInPage.loginToUrl("itsnats@yahoo.co.uk","Sharma2005");
        Assert.assertTrue(driver.getCurrentUrl().contains("verify-email"));
        System.out.println("Final URL : " + driver.getCurrentUrl());
    }
}
