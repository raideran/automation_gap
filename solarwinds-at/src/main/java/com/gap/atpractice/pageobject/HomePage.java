package com.gap.atpractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.sql.Time;
import java.util.concurrent.TimeUnit;

/**
 * Created by auto on 15/05/17.
 */
public class HomePage
{
    WebDriver driver;
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
        PageFactory.initElements(driver,this);

    }

    public String getPageTitle()
    {
        return  this.driver.getTitle();
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
        searchText.sendKeys("network");
        searchButton.click();
        return new SearchPage(this.driver);
    }

}
