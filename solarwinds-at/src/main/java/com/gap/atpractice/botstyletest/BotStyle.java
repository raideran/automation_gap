package com.gap.atpractice.botstyletest;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by auto on 18/05/17.
 */
public class BotStyle
{
    private WebDriver driver;

    public BotStyle(WebDriver driver)
    {
        this.driver = driver;
    }

    public WebDriver getDriver()
    {
        return this.driver;
    }

    public void waitForPageTitle(int timeToWaitSecs, final String title){

        (new WebDriverWait(driver, timeToWaitSecs)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(title.toLowerCase());
            }
        });
    }

    public WebElement waitForElementPresent(final By byElement, int timeoutInSeconds)
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, timeoutInSeconds);

        WebElement we = wait.until(new Function<WebDriver, WebElement>()
        {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(byElement);
            }
        });
        return we;
    }

    public void Type(WebElement wElement, String text)
    {
        wElement.clear();
        wElement.sendKeys(text);
    }

}
