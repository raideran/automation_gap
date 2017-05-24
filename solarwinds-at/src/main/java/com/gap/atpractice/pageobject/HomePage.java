package com.gap.atpractice.pageobject;

import com.gap.atpractice.botstyletest.BotStyle;
//import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.testng.Assert;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by auto on 15/05/17.
 */
public class HomePage extends LoadableComponent<HomePage>
{
    WebDriver driver;
    BotStyle botDriver;
    /*PO without Factory
    By bySearchText= By.id("SearchText");
    By bySearchButton = By.xpath("//button[@class='btn btn-warning btn-sm']");
    */
    @FindBy(id = "SearchText")
    private WebElement searchText;
    @FindBy(xpath = "//button[@class='btn btn-warning btn-sm']")
    private WebElement searchButton;


    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        botDriver = new BotStyle(driver);
        PageFactory.initElements(driver,this);

    }

    @Override
    protected void load()
    {
        driver.navigate().to("http://www.solarwinds.com/");
    }

    public String getPageTitle()
    {
        return  this.driver.getTitle();
    }

    @Override
    protected void isLoaded() throws Error
    {

        //String url = driver.getCurrentUrl();
        //assertTrue("Not on the issue entry page: " + url, url.endsWith("/new"));
        Assert.assertTrue(isPageLoaded("IT Management Software & Monitoring Tools | SolarWinds"));
        /*if(!isPageLoaded("IT Management Software & Monitoring Tools | SolarWinds"))
        {
            System.out.println("Not on the issue entry page: " + url);

        }
        */

    }



    public void gotoHomePage(String url)
    {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.navigate().to(url);
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
        /*PO without Factory
        searchText = driver.findElement(bySearchText);
        searchButton = driver.findElement(bySearchButton);
        */
        botDriver.Type(searchText,"network");
        searchButton.click();
        return new SearchPage(this.driver);
    }

}
