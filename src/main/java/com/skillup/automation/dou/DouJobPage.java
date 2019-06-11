package com.skillup.automation.dou;

import com.skillup.automation.configuration.Wait;
import com.skillup.automation.pages.CommonPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.List;

import static com.skillup.automation.configuration.Wait.TWO_SECONDS;

public class DouJobPage extends CommonPage {
    private static final String QA_JOBS_LINK ="a[href*='category=QA']";
    private static final String JOB_LINK_PATTERN = "//a[contains(text(), '%s')]";
    private static final String JOB_NUMBER_PATTERN = "//a[contains(text(), '%s')]//following-sibling::em";
    private static final String MORE_JOBS_BUTTON = ".more-btn a";
    private static final String ALL_JOBS_LINKS = "#vacancyListId li.l-vacancy";
    private static final String SELECT_JOB_CATEGORY = "select[name='category']";

    public DouJobPage(WebDriver driver) {
        super(driver);
    }

    public DouJobPage chooseQaJobs() {
        click(QA_JOBS_LINK);
        return this;
    }

    public DouJobPage selectJobCategory(String category) {
        selectFromDropDown(SELECT_JOB_CATEGORY, category);
        Wait.waitFor(Wait.ONE_SECOND);
        return this;
    }

    public DouJobPage clickCityJobs(String city) {
        String locator = String.format(JOB_LINK_PATTERN, city);

        click(locator);
        return this;
    }

    public String getCityJobNumber(String city) {
        String locator = String.format(JOB_NUMBER_PATTERN, city);
        return getText(locator);
    }

    public DouJobPage clickTillMoreJobsButtonExists() {
        while (waitTillElementClickable(MORE_JOBS_BUTTON, TWO_SECONDS)) {
            click(MORE_JOBS_BUTTON);
            Wait.waitFor(Wait.ONE_SECOND);//HARDCODED but leave it as it is
        }

        return this;
    }

    public DouJobPage assertVacancyNumber(String expectedNumber) {
        List<WebElement> allVacancies = driver.findElements(find(ALL_JOBS_LINKS));
        String actualNumber = String.valueOf(allVacancies.size());

        Assert.assertEquals(actualNumber, expectedNumber, "Number of jobs is incorrect");
        return this;
    }
}
