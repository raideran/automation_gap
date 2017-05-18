package com.gap.atpractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by auto on 15/05/17.
 */
public class SearchPage
{

    WebDriver driver;
    By bySearchBoxInput = By.id("searchBoxInput");
    By byTabProduct = By.xpath("//li/a[text()=\"Products\"]");
    By byTabDocument  = By.xpath("//li/a[text()=\"Documentation\"]");
    By byTabResource = By.xpath("//li/a[text()=\"Resources\"]");
    By byTabEverything = By.xpath("//li/a[text()=\"Everything\"]");


    private static WebElement searchBoxInput, tabProduct, tabDocument, tabResource, tabEverything;

    SearchPage(WebDriver driver)
    {
        this.driver = driver;

    }


    public String getPageTitle()
    {
        return  this.driver.getTitle();
    }

    public Boolean isPageLoaded(String Title)
    {
        if(getPageTitle().equals(Title))
            return  true;
        else
            return false;

    }
}
