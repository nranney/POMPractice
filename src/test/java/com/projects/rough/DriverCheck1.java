package com.projects.rough;

//import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class DriverCheck1 {
    public static WebDriver driver;
    public static void main(String[] args){
        ChromeOptions chromeOptions = configureChromeOptions();
        try {
            driver = new ChromeDriver(chromeOptions);
            System.out.println("configured chrome options");
           } catch(Exception e){
            System.out.println("error : "+e.getMessage());
        }
        finally {
            driver.manage().deleteAllCookies();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("launching website");
        // Launch Website
        driver.get("https://www.zoho.com/en-in/crm/");

    }

    private static ChromeOptions configureChromeOptions() {

       // Proxy proxy = new Proxy();
       // proxy.setAutodetect(true);
        ChromeOptions chromeOptions = new ChromeOptions();
        //chromeOptions.setCapability(CapabilityType.PROXY, proxy);
        //Map<String, Object> prefs = new HashMap<>();
       // prefs.put("download.default_directory", exportReportfile.getAbsolutePath());
        //chromeOptions.setExperimentalOption("prefs", prefs);
        chromeOptions.addArguments(
                "--verbose",
             //   "--headless",
                // following handles same origin policy - https://www.scaler.com/topics/same-origin-policy-in-selenium/
                "--disable-web-security",
                // accept insecure SSL certs
                "--ignore-certificate-errors",

                "--allow-running-insecure-content",

                "--allow-insecure-localhost",
                "--no-sandbox",
                // used to disable graphics processing unit .. used mostly with headless mode where gpu acceleration can cause issues
                "--disable-gpu",
                "--window-size=1920,1080"
        );
        chromeOptions.setBrowserVersion("stable");

        return chromeOptions;
    }

}
