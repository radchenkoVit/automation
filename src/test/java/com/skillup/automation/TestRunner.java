package com.skillup.automation;

import com.skillup.automation.pages.LoginPage;
import com.skillup.automation.pages.OnboardingPage;
import com.skillup.automation.pages.SignUpPage;
import com.skillup.automation.pages.WallPage;
import com.skillup.automation.utils.CaptureScreenshot;
import com.skillup.automation.utils.WebDriverFactory;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.skillup.automation.configuration.ConfigurationLoader.getBrowserName;
import static com.skillup.automation.configuration.Wait.FIVE_SECONDS;

public class TestRunner {
    protected WebDriver driver = null;
    protected LoginPage loginPage;
    protected WallPage wallPage;
    protected SignUpPage signUpPage;
    protected OnboardingPage onboardingPage;

    private static Logger log = Logger.getLogger(TestRunner.class.getName());

    @BeforeSuite
    public void beforeSuite() {
        WebDriverFactory.setUpBrowserDrivers();
    }

    @BeforeMethod
    public void beforeMethod(Method info) {
        driver = WebDriverFactory.initDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FIVE_SECONDS, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        wallPage = new WallPage(driver);
        onboardingPage = new OnboardingPage(driver);
        logTestStartedInfo(info);
    }

    public void logTestStartedInfo(Method info) {
        log.info(String.format("Test started: %s\n" +
                "Browser: %s\n\n\n", info.getName(), getBrowserName()));
    }

    public void logTestFinishedInfo(ITestResult result) {
        log.info(String.format("\n\n\nTest finished: %s\n" +
                "Browser: %s\n", result.getMethod().getMethodName(), getBrowserName()));
    }

    @AfterMethod
    public void saveScreenShot(ITestResult result) throws IOException {
        logTestFinishedInfo(result);
        if(!result.isSuccess()) {
            CaptureScreenshot.takeScreenShot(driver, result.getMethod().getMethodName());
        }

        if (driver != null) {
            driver.quit();
        }
    }

//    @AfterMethod
//    public void afterMethod() {
//
//    }

    private void closeNotUsedTabs() {
        String currentTab = driver.getWindowHandle();
        List<String> allTabs = new ArrayList<String>(driver.getWindowHandles());

        for (int i = 0; i < allTabs.size(); i++) {
            String tab = allTabs.get(i);
            if (!tab.equals(currentTab)) {
                driver.switchTo().window(tab);
                driver.close();
            }
        }

        driver.switchTo().window(currentTab);
    }

}
