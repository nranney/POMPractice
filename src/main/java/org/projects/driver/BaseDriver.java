package org.projects.driver;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseDriver {
    @Getter
    private static WebDriver driver = null;
    private static String browserName= "chrome";
    public final static Logger LOGGER = LoggerFactory.getLogger(BaseDriver.class);

    // private constructor to avoid creation of new instances of class
    private BaseDriver(){

    }
    public static void init() {
        if (driver == null) {
            if (browserName.equalsIgnoreCase("chrome")) {
                ChromeOptions chromeOptions = configureChromeOptions();
                try {
                    driver = new ChromeDriver(chromeOptions);
                    System.out.println("configured chrome options");
                } catch(Exception e){
                    System.out.println("error : "+e.getMessage());
                }

            }
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        LOGGER.debug("Driver Initialized");
    }

    private static ChromeOptions configureChromeOptions() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments(
                "--verbose",
                  "--headless",
                "--disable-web-security",
                "--ignore-certificate-errors",
                "--allow-running-insecure-content",
                "--allow-insecure-localhost",
                "--no-sandbox",
                "--disable-gpu",
                "--window-size=1920,1080"
        );
        chromeOptions.setBrowserVersion("stable");

        return chromeOptions;
    }

    public static void quit() {
        driver.quit();
        driver=null;
    }

}
