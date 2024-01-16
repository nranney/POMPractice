package org.projects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.projects.driver.BasePage;


public class HomePage extends BasePage {

    public static final String SIGN_IN_LINK = "//a[@class='zgh-login']";

    @FindBy(how= How.XPATH, using = SIGN_IN_LINK )
    private WebElement signInLink;

    public HomePage(WebDriver driver){
        super(driver);
    }

    public void goToHomePage(String url){
        driver.navigate().to(url);
    }

    public SignInPage clickSignIn(){
        waitForElementToAppear(signInLink);
        signInLink.click();
        return new SignInPage(driver);
    }
}
