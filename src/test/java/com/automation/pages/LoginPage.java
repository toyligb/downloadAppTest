package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPageBase{

    @FindBy(name = "USER_LOGIN")
    private WebElement username;

    @FindBy(name = "USER_PASSWORD")
    private WebElement password;

    @FindBy(className = "login-btn")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css = "[class='errortext']")
    private WebElement warningMessage;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(),this);
    }

    public String getWarningMessageText() {
        return warningMessage.getText();
    }

    public void login() {
        username.sendKeys(ConfigurationReader.getProperty("hr"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.waitForPageToLoad(10);
        BrowserUtils.wait(3);
    }

    public void login(String usernameValue,String passwordValue) {
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue);
        BrowserUtils.wait(3);
    }

}