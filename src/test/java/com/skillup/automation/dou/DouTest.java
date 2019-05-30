package com.skillup.automation.dou;

import com.skillup.automation.TestRunner;
import org.testng.annotations.Test;

public class DouTest extends TestRunner {

    @Test
    public void qaJobsTest() {
        DouHomePage douHomePage = new DouHomePage(driver);
        DouJobPage douJobPage = new DouJobPage(driver);

        douHomePage
                .open()
                .navigateToJobPage();

        douJobPage
                .chooseQaJobs();

        String vacancyNumber = douJobPage.getKievJobNumber();

        douJobPage
                .clickKievJobs()
                .clickTillMoreJobsButtonExists()
                .assertVacancyNumber(vacancyNumber);
    }
}
