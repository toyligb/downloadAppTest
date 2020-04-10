package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPageBase {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,25);

    @FindBy(css = "#user-name")
    protected WebElement currentUser;

    public AbstractPageBase()
    {
        PageFactory.initElements(driver,this);
    }

    public String getCurrentUserName()
    {
        BrowserUtils.waitForPageToLoad(10);
        wait.until(ExpectedConditions.visibilityOf(currentUser));
        return currentUser.getText().trim();
    }

    public void navigateTo(String tabName)
    {
        String tabNameXpath = "//span[@class ='menu-item-link-text' and contains(text() ,'" + tabName + "')]";

        WebElement tabElement = driver.findElement(By.xpath(tabNameXpath));

        Actions actions = new Actions(driver);
        BrowserUtils.wait(4);

        actions.moveToElement(tabElement).pause(2000).click().build().perform();
    }

}
