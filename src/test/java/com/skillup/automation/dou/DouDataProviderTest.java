package com.skillup.automation.dou;

import com.skillup.automation.TestRunner;
import com.skillup.automation.data.DouDataProvider;
import org.testng.annotations.Test;

public class DouDataProviderTest extends TestRunner {

    @Test(dataProvider = "douData", dataProviderClass = DouDataProvider.class)
    public void selectJobsTest(String city, String category) {
        DouHomePage douHomePage = new DouHomePage(driver);
        DouJobPage douJobPage = new DouJobPage(driver);

        douHomePage
                .open()
                .navigateToJobPage();

        douJobPage
                .chooseQaJobs()
                .selectJobCategory(category);

        String vacancyNumber = douJobPage.getCityJobNumber(city);

        douJobPage
                .clickCityJobs(city)
                .clickTillMoreJobsButtonExists()
                .assertVacancyNumber(vacancyNumber);
    }
}
