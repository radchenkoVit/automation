package com.skillup.automation.login;

import com.skillup.automation.TestRunner;
import com.skillup.automation.pagesByFactory.LoginPageByFactory;
import org.testng.annotations.Test;

public class NegativeLoginByFactoryTest extends TestRunner {

    private static final String EXPECTED_ERROR_MESSAGE = "Please enter a password.";

    @Test
    public void test() {
        LoginPageByFactory loginPage = new LoginPageByFactory(driver);

        loginPage
                .open()
                .enterEmail("myemail@email.com")
                .enterPassword("")
                .clickLoginButton()
                .assertEmailErrorMessage(EXPECTED_ERROR_MESSAGE);
    }

}
