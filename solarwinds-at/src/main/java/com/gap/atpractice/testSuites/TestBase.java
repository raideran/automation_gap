package com.gap.atpractice.testSuites;

import com.gap.atpractice.selenium.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Created by jporras on 05/06/17.
 * This class contains all the common methods
 * that the test cases will inherit
 */
public class TestBase extends SeleniumBase
{

    protected String testLinkURL;
    protected String devKey;

    /*
     * This method will run before every testcase
     * and will setup the browser driver
     */
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser","testlinkUrl", "devKey"})
    public void initSetup(String browser, String testLinkURL, String devKey)
    {
        driver = super.setup(browser,true);
        this.testLinkURL = testLinkURL;
        this.devKey = devKey;
    }

    /*
     * This method will run after every testcase
     * and will shutdown the webdriver instance
     */
    @AfterMethod(alwaysRun = true)
    public void quitSetup()
    {
        driver.quit();
    }

    public WebDriver getDriver()
    {
        return super.driver;
    }


    public String getDevKey()
    {
        return devKey;
    }

    public String getTestLinkURL()
    {
        return testLinkURL;
    }
}
