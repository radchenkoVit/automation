package com.skillup.automation.utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

import static com.skillup.automation.configuration.ConfigurationLoader.getScreenShotPath;

public class CaptureScreenshot {

    public static void takeScreenShot(WebDriver driver, String methodName) throws IOException {
        String screenShotName = getScreenshotName(methodName);

        File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String destPath = getScreenShotPath(screenShotName);
        FileUtils.copyFile(source, new File(destPath));
    }

    private static String getScreenshotName(String methodName) {
        return String.format("screenshot_%s_%s.png", methodName, System.currentTimeMillis());
    }
}
