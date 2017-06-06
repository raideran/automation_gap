package com.gap.atpractice.testSuites;

import com.gap.atpractice.selenium.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

/**
 * Created by auto on 05/06/17.
 */
public class TestBase extends SeleniumBase
{

    protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void initSetup(String browser)
    {
        driver = super.setup(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void quitSetup()
    {
        driver.quit();
    }


}
