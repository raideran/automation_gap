package com.gap.atpractice.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by jporras on 6/26/2017.
 */
public class RegFormPage extends PageBase
{
    @FindBy(xpath = "//input[@id='ci_firstName']")
    private WebElement firsName;
    @FindBy(xpath = "//input[@id='ci_lastName']")
    private WebElement lasName;

    private final String CURRENT_URL = "network-performance-monitor/registration";

    public RegFormPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    protected void load()
    {
        driver.navigate().to(BASE_URL.concat(CURRENT_URL));
    }

    @Override
    protected void isLoaded() throws Error
    {
        if(!isPageLoaded("Download a free trial of Network Performance Monitor from SolarWinds"))
        {
            throw new Error("Reg Form Page was not successfully loaded");
        }
    }

    public Boolean verifyFirstLastNameFields(String fName, String lName)
    {
        Boolean result = false;
        if(firsName.getAttribute("value").equals(fName)&&lasName.getAttribute("value").equals(lName))
        {
            result = true;
        }
        return  result;
    }

}
