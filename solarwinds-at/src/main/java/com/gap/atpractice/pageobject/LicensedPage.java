package com.gap.atpractice.pageobject;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by jporras on 6/26/2017.
 */
public class LicensedPage extends PageBase
{
    @FindBy(xpath = "//input[@id='CTAFirstName']")
    private WebElement firsName;
    @FindBy(xpath = "//input[@id='CTALastName']")
    private WebElement lasName;
    @FindBy(xpath = "//div[@class=\"col-sm-8 form-fields\"]/a[@class=\"btnGreen solarTrack\"]")
    private WebElement downloadButtonn;

    private final String CURRENT_URL = "network-performance-monitor";

    public LicensedPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    protected void load()
    {
        /*driver.navigate().to(BASE_URL);
        Cookie ck = new Cookie("AWS", "smart");
        driver.manage().addCookie(ck);*/
        driver.navigate().to(BASE_URL.concat(CURRENT_URL));
    }

    @Override
    protected void isLoaded() throws Error
    {
        if(!isPageLoaded("Network Monitoring Software | SolarWinds NPM 12.1"))
        {
            throw new Error("Licensed Page was not successfully loaded");
        }
    }


    public RegFormPage sendFirstLasNameData(String fName, String lName)
    {
        botDriver.type(firsName,fName);
        botDriver.type(lasName, lName);
        downloadButtonn.click();
        return new RegFormPage(this.driver);
    }
}
