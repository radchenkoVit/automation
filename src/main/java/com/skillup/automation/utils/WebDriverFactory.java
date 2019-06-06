package com.skillup.automation.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static com.skillup.automation.configuration.ConfigurationLoader.getBrowserName;

public class WebDriverFactory {

    public static void setUpBrowserDrivers() {
        String browser = getBrowserName();

        if ("chrome".equals(browser)) {
            WebDriverManager.chromedriver().setup();
        } else if ("ff".equals(browser)) {
            WebDriverManager.firefoxdriver().setup();
        }
    }

    public static WebDriver initDriver() {
        WebDriver driver = null;
        String browser = getBrowserName();
        //browser.equals("chrome"); //--> NUllPOINTER Exception
        //"chrome".equals(null);// --> false
        if ("chrome".equals(browser)) {
            driver = new ChromeDriver();
        } else if ("ff".equals(browser)) {
            driver = new FirefoxDriver();
        } else {
            driver = new ChromeDriver();
        }


        return driver;
    }
}
