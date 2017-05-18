package com.gap.atpractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by auto on 15/05/17.
 */
public class SearchPage
{

    WebDriver driver;
    /*PO without Factory
    By bySearchBoxInput = By.id("searchBoxInput");
    By byTabProduct = By.xpath("//li/a[text()=\"Products\"]");
    By byTabDocument  = By.xpath("//li/a[text()=\"Documentation\"]");
    By byTabResource = By.xpath("//li/a[text()=\"Resources\"]");
    By byTabEverything = By.xpath("//li/a[text()=\"Everything\"]");
    */

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

    SearchPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);

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


    public void pageValidations()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //searchBoxInput = driver.findElement(bySearchBoxInput);
        js.executeScript("arguments[0].click();", searchBoxInput);

        /*
        tabProduct = driver.findElement(byTabProduct);
        tabDocument  = driver.findElement(byTabDocument);
        tabResource = driver.findElement(byTabResource);
        tabEverything = driver.findElement(byTabEverything);
        */

        if (tabProduct.getSize().equals(0))
            System.out.println("Product tab is not present in the page");


        if(!driver.findElement(By.cssSelector(".NextPage")).isDisplayed())
            System.out.println("Next Page link is not visible");

        if(!driver.findElement(By.cssSelector(".downloadBtn")).isDisplayed())
            System.out.println("Download Button is not visible");
    }
}
