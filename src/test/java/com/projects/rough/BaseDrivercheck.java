package com.projects.rough;

import org.openqa.selenium.WebDriver;
import org.projects.pages.HomePage;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseDrivercheck {

    HomePage homePage;
    WebDriver driver;

    @BeforeTest
    public void setup(){
        homePage = new HomePage(driver);

    }

    @Test
    public void accessHomePage(){
        homePage.goToHomePage("https://www.zoho.com/en-in/crm/");
        homePage.clickSignIn();
    }


}
