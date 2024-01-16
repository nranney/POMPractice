package org.projects.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.Objects.isNull;
import static org.openqa.selenium.support.ui.ExpectedConditions.urlContains;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class BasePage {

    protected WebDriver driver;
    private static final int TIMEOUT = 50;
    protected final WebDriverWait wait;
    public final static Logger LOGGER = LoggerFactory.getLogger(BasePage.class);


    public BasePage(WebDriver driver){
        if(isNull(driver)){
            System.out.println("driver is null in basepage constructor");
        }

        this.driver = driver;
        PageFactory.initElements(new AjaxElementLocatorFactory(this.driver, TIMEOUT),this);
        this.wait = new WebDriverWait (this.driver, Duration.ofSeconds(TIMEOUT));
    }

    protected void waitForElementToAppear(WebElement element){
        wait.until(visibilityOf(element));
    }

    protected void pauseTest(int timeInMilliSecs){
        try {
            TimeUnit.MILLISECONDS.sleep(timeInMilliSecs);
        } catch(InterruptedException e ) {
            LOGGER.error("ERror - ",e);
        }
    }

    protected void waitForURLToContainString(String url){
        wait.until(urlContains(url));
    }
}
