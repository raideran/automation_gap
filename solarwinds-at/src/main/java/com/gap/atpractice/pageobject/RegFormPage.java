package com.gap.atpractice.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by jporras on 6/26/2017.
 */
public class RegFormPage extends PageBase
{
    @FindBy(xpath = "//input[@id='first_name']")
    private WebElement firsName;
    @FindBy(xpath = "//input[@id='last_name']")
    private WebElement lasName;

    private final String CURRENT_URL = "network-performance-monitor/registration?program=607&campaign=70150000000Dlbw";

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
        if(!isPageLoaded("Download a FREE Trial of Network Performance Monitor (NPM) from SolarWinds!"))
        {
            throw new Error("Reg Form Page was not successfully loaded");
        }
    }

    public Boolean verifyFirstLastNameFiels(String fName, String lName)
    {
        Boolean result = false;
        if(firsName.getText().equals(fName)&&lasName.getText().equals(lName))
        {
            result = true;
        }
        return  result;
    }

}
