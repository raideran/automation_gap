package com.gap.atpractice.pageobject;

import com.gap.atpractice.botstyletest.BotStyle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.LoadableComponent;

/**
 * Created by auto on 29/05/17.
 */
public abstract class PageBase extends LoadableComponent<PageBase>
{
    protected WebDriver driver;
    protected BotStyle botDriver;


    public PageBase(WebDriver driver)
    {
        this.driver = driver;
        botDriver = new BotStyle(driver);
    }

    public String getPageTitle() {
        return this.driver.getTitle();
    }
}
