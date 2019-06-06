package com.skillup.automation.configuration;

import java.nio.file.Paths;

public class ConfigurationLoader {

    public static String getBaseDir() {
        return System.getProperty("user.dir");
    }

    public static String getScreenShotPath(String screenShotName) {
        return Paths.get(getBaseDir(), "target", "screenshots", screenShotName).toAbsolutePath().toString();
    }

    public static String getBrowserName() {
        return System.getProperty("browser");
    }
}
