package com.automation.tests;

import com.automation.pages.LoginPage;
import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class DownloadAppTest extends AbstractBaseTest {

    @FindBy(xpath = "//a[span[text()='Windows']]")
    private WebElement windowsApp;

    @FindBy(xpath = "//a[span[text()='Mac OS']]")
    private WebElement macOSApp;

    @FindBy(xpath = "//a[span[text()='Linux']]")
    private WebElement linuxApp;

    private DownloadAppTest() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @Test
    public void downloadApp() {
        extentTest = extentReports.createTest("Verify user is able to download Windows app");

        LoginPage loginPage = new LoginPage();
        loginPage.login();

        getApp(windowsApp);

        //wait.until(ExpectedConditions.visibilityOf(windowsApp)).click();

    }

    public void getApp(WebElement appLocator) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(appLocator);
        actions.perform();
        actions.click(appLocator);
        actions.perform();
    }

}
