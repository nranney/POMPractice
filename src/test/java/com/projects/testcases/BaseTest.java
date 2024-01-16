package com.projects.testcases;

import org.openqa.selenium.WebDriver;
import org.projects.driver.BaseDriver;
import org.projects.pages.HomePage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.logging.LogManager;

public class BaseTest {

    protected WebDriver driver;
    public final static Logger LOGGER = LoggerFactory.getLogger(BaseTest.class);
    public BaseTest(){
        BaseDriver.init();
        LOGGER.info("in constructor");
        this.driver = BaseDriver.getDriver();
        System.out.println("base class constructor called");
    }

    @AfterSuite
    public void tearDown(){
        BaseDriver.quit();
        LOGGER.info("Browser closed");
    }


}
