package com.gap.atpractice.testSuites;
import com.gap.atpractice.Utils.TakeScreenshot;
import com.gap.atpractice.pageobject.HomePage;
import com.gap.atpractice.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import java.util.concurrent.TimeUnit;

/**
 * Created by auto on 06/04/17.
 */
public class LoginTest
{
    private static SeleniumBase seleniumBase;
    //Home page elements
    private static WebElement searchText, searchButton;
    //Search page elements
    private static WebElement searchBoxInput, tabProduct, tabDocument, tabResource, tabEverything,
    downloadButton, nextLink;

    public static void main(String [] args){

        seleniumBase = new SeleniumBase();
        WebDriver driver = seleniumBase.setup("Chrome");

        try
        {
            HomePage hPage = new HomePage(driver);

            hPage.gotoHomePage("http://www.solarwinds.com/");
            if(!hPage.isPageLoaded("IT Management Software & Monitoring Tools | SolarWinds"))
            {
                System.out.println("HomePage Not Correctly Loaded");
                //System.exit(0);
            }
            hPage.searchText("network");



            /*driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("http://www.solarwinds.com/");
            searchButton = driver.findElement(By.xpath("//button[@class='btn btn-warning btn-sm']"));
            searchText = driver.findElement(By.id("SearchText"));
            Thread.sleep(5000);  // Let the user actually see something!
            searchText.sendKeys("network");
            searchButton.click();
            Thread.sleep(5000);  // Let the user actually see something!
            */


            JavascriptExecutor js = (JavascriptExecutor) driver;
            searchBoxInput = driver.findElement(By.id("searchBoxInput"));
            js.executeScript("arguments[0].click();", searchBoxInput);




            tabProduct = driver.findElement(By.xpath("//li/a[text()=\"Products\"]"));
            tabDocument  = driver.findElement(By.xpath("//li/a[text()=\"Documentation\"]"));
            tabResource = driver.findElement(By.xpath("//li/a[text()=\"Resources\"]"));
            tabEverything = driver.findElement(By.xpath("//li/a[text()=\"Everything\"]"));


            if(!driver.findElement(By.cssSelector(".NextPage")).isDisplayed())
                System.out.println("Next Page link is not present");

            if(!driver.findElement(By.cssSelector(".downloadBtn")).isDisplayed())
                System.out.println("Download Button is not present");

            //TakeScreenshot.takeScreenshot(driver,"./src/main/resources/screenshots");



            driver.quit();


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
