package com.automation.tests;

import com.automation.pages.LoginPage;
import com.automation.utilities.ConfigurationReader;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends AbstractBaseTest{

    @Test
    public void login() {
        setupTest("verifyUserName");
        extentTest = extentReports.createTest("Verify user name");

        LoginPage loginPage = new LoginPage();
        loginPage.login();
        Assert.assertEquals(loginPage.getCurrentUserName(), ConfigurationReader.getProperty("hr"));
        extentTest.pass("Username verified");
    }

}
