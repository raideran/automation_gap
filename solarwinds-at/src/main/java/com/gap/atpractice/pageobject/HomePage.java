package com.gap.atpractice.pageobject;

import com.gap.atpractice.botstyletest.BotStyle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import java.util.concurrent.TimeUnit;

/**
 * Created by auto on 15/05/17.
 */
public class HomePage extends PageBase
{


    @FindBy(id = "SearchText")
    private WebElement searchText;
    @FindBy(xpath = "//button[@class='btn btn-warning btn-sm']")
    private WebElement searchButton;

    public HomePage(WebDriver driver)
    {
        super(driver);

        PageFactory.initElements(driver,this);

    }

    @Override
    protected void load()
    {
        driver.navigate().to("http://www.solarwinds.com/");
    }

    @Override
    protected void isLoaded() throws Error
    {
        Assert.assertTrue(isPageLoaded("IT Management Software & Monitoring Tools | SolarWinds"));
    }

    public Boolean isPageLoaded(String Title)
    {
        if(getPageTitle().equals(Title))
            return  true;
        else
            return false;

    }

    public SearchPage searchText(String textToSearch)
    {
        searchText.clear();
        botDriver.Type(searchText,textToSearch);
        searchButton.click();
        return new SearchPage(this.driver);
    }

}
