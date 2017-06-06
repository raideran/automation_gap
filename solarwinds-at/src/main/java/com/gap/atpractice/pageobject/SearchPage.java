package com.gap.atpractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by auto on 15/05/17.
 */
public class SearchPage extends PageBase
{

    @FindBy(id = "searchBoxInput")
    private WebElement searchBoxInput;
    @FindBy(xpath = "//li/a[text()=\"Products\"]")
    private WebElement tabProduct;
    @FindBy(xpath = "//li/a[text()=\"Documentation\"]")
    private WebElement tabDocument;
    @FindBy(xpath = "//li/a[text()=\"Resources\"]")
    private WebElement tabResource;
    @FindBy(xpath = "//li/a[text()=\"Everything\"]")
    private WebElement tabEverything;

    public SearchPage(WebDriver driver)
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
        Assert.assertTrue(isPageLoaded("Search"));
    }

    public Boolean isPageLoaded(String Title)
    {
        if(getPageTitle().equals(Title))
            return  true;
        else
            return false;

    }

    public boolean pageValidations()
    {
        boolean validations = true;
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", searchBoxInput);

        if (tabProduct.getSize().equals(0))
        {
            System.out.println("Product tab is not present in the page");
            validations = false;
        }

        if(!driver.findElement(By.cssSelector(".NextPage")).isDisplayed())
        {
            System.out.println("Next Page link is not visible");
            validations = false;
        }

        if(!driver.findElement(By.cssSelector(".downloadBtn")).isDisplayed())
        {
            System.out.println("Download Button is not visible");
            validations = false;
        }
        return validations;
    }
}
