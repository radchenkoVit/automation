package com.skillup.automation.data;

import org.testng.annotations.DataProvider;

import static com.skillup.automation.utils.StringRandomGenerator.getRandomEmail;

public class DouDataProvider {


    @DataProvider(name = "douData")
    public Object[][] getData() {
        Object[][] data = new Object[][]{
                {"Киев", "QA"},
                {"Львов", "Java"}
        };

        return data;
    }
}
