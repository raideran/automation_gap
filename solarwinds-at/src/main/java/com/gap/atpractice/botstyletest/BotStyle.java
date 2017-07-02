package com.gap.atpractice.botstyletest;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by jporras on 18/05/17.
 */
public class BotStyle
{
    private WebDriver driver;
    private Actions actionElement;

    public BotStyle(WebDriver driver)
    {

        this.driver = driver;
        actionElement = new Actions(this.driver);
    }

    public WebDriver getDriver()
    {
        return this.driver;
    }

    public void waitForPageTitle(int timeToWaitSecs, final String title)
    {

        (new WebDriverWait(driver, timeToWaitSecs)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(title.toLowerCase());
            }
        });
    }

    public WebElement waitForElementPresentBy(final By byElement, int timeoutInSeconds)
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

    public void waitForElementPresent(final WebElement element, int timeoutInSeconds)
    {
        Wait<WebDriver> wait = new WebDriverWait(driver, timeoutInSeconds);

        wait.until(ExpectedConditions.visibilityOf(element));

    }

    public void type(WebElement wElement, String text)
    {
        wElement.clear();
        wElement.sendKeys(text);
    }


    //Region Actions Methods
    public void doubleClick(WebElement element)
    {
        actionElement.doubleClick(element).perform();
    }

    public void moveToElement(WebElement element)
    {
        actionElement.moveToElement(element).perform();
    }

    public void dragAndDropBy(WebElement element)
    {
        actionElement.dragAndDropBy(element, 300, 300).build().perform();

    }
    //endregion



}
