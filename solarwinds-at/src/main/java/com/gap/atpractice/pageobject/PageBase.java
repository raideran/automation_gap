package com.gap.atpractice.pageobject;

import com.gap.atpractice.botstyletest.BotStyle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * Created by jporras on 29/05/17.
 */
public abstract class PageBase extends LoadableComponent<PageBase>
{
    protected WebDriver driver;
    protected BotStyle botDriver;
    protected final String BASE_URL = "http://www.solarwinds.com/";

    public PageBase(WebDriver driver)
    {
        this.driver = driver;
        botDriver = new BotStyle(this.driver);
    }

    public String getPageTitle()
    {
        return this.driver.getTitle();
    }

    public Boolean isPageLoaded(String Title)
    {
        if(getPageTitle().equals(Title))
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
