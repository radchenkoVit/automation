package com.skillup.automation;

import com.skillup.automation.pages.LoginPage;
import com.skillup.automation.pages.OnboardingPage;
import com.skillup.automation.pages.SignUpPage;
import com.skillup.automation.pages.WallPage;
import com.skillup.automation.utils.WebDriverFactory;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.skillup.automation.configuration.Wait.FIVE_SECONDS;

public class TestRunner {
    protected WebDriver driver = null;
    protected LoginPage loginPage;
    protected WallPage wallPage;
    protected SignUpPage signUpPage;
    protected OnboardingPage onboardingPage;

    @BeforeSuite
    public void beforeSuite() {
        WebDriverFactory.setUpBrowserDrivers();
    }

    @BeforeMethod
    public void beforeMethod() {
        driver = WebDriverFactory.initDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FIVE_SECONDS, TimeUnit.SECONDS);

        loginPage = new LoginPage(driver);
        signUpPage = new SignUpPage(driver);
        wallPage = new WallPage(driver);
        onboardingPage = new OnboardingPage(driver);
    }

    @AfterMethod
    public void saveScreenShot(ITestResult result) throws IOException {
        if(!result.isSuccess()) {
            String screenShotName = String.format("screenshot_%s_%s.png", result.getMethod().getMethodName(), System.currentTimeMillis());
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String destPath = Paths.get(System.getProperty("user.dir"), "screenshots", screenShotName).toAbsolutePath().toString();

            FileUtils.copyFile(source, new File(destPath));
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
