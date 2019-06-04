package com.skillup.automation.dou;

import com.skillup.automation.TestRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DouTest extends TestRunner {

    @Test
    public void qaJobsTest() {
        DouHomePage douHomePage = new DouHomePage(driver);
        DouJobPage douJobPage = new DouJobPage(driver);
        String city = "Киев";

        douHomePage
                .open()
                .navigateToJobPage();

        Assert.fail();

        douJobPage
                .chooseQaJobs()
                .selectJobCategory("QA");

        String vacancyNumber = douJobPage.getCityJobNumber(city);

        douJobPage
                .clickCityJobs(city)
                .clickTillMoreJobsButtonExists()
                .assertVacancyNumber(vacancyNumber);
    }

    @Test
    public void selectJobsTest() {
        DouHomePage douHomePage = new DouHomePage(driver);
        DouJobPage douJobPage = new DouJobPage(driver);
        String city = "Львов";

        douHomePage
                .open()
                .navigateToJobPage();

        douJobPage
                .chooseQaJobs()
                .selectJobCategory("Java");

        String vacancyNumber = douJobPage.getCityJobNumber(city);

        douJobPage
                .clickCityJobs(city)
                .clickTillMoreJobsButtonExists()
                .assertVacancyNumber(vacancyNumber);
    }
}
