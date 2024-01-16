package org.projects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.projects.driver.BasePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SignInPage extends BasePage {

    public static final String SIGN_IN_HEADER = "//span[@id='headtitle']";
    public static final String LOGIN_ID_INPUT = "//input[@id='login_id']";
    public static final String NEXT_BTN = "//span[text()='Next']";
    public static final String PASSWORD_INPUT = "//input[@id='password']";
    public static final String SIGN_IN_BTN = "//button[@id='nextbtn']/span[text()='Sign in']";
    public final static Logger LOGGER = LoggerFactory.getLogger(SignInPage.class);

    @FindBy(how= How.XPATH, using = SIGN_IN_HEADER )
    private WebElement signInHeader;

    @FindBy(how= How.XPATH, using = LOGIN_ID_INPUT )
    private WebElement loginIdInput;

    @FindBy(how= How.XPATH, using = NEXT_BTN )
    private WebElement nextBtn;
    @FindBy(how= How.XPATH, using = PASSWORD_INPUT )
    private WebElement passwordInput;

    @FindBy(how= How.XPATH, using = SIGN_IN_BTN )
    private WebElement signInBtn;

    public SignInPage(WebDriver driver){
        super(driver);
    }

    public String signInHeader(){
        waitForElementToAppear(signInHeader);
        return signInHeader.getText();
    }
    public void loginToUrl(String loginId, String password){
        waitForElementToAppear(loginIdInput);
        loginIdInput.clear();
        loginIdInput.sendKeys(loginId);
        nextBtn.click();
        waitForElementToAppear(passwordInput);
        passwordInput.clear();
        passwordInput.sendKeys(password);
        LOGGER.info("Sign in button being clicked : "+ signInBtn.getText());
        signInBtn.click();
        LOGGER.info("Sign in button clicked");
        pauseTest(2000);
        waitForURLToContainString("verify-email");
       // pauseTest(2000);
       }
}
