package com.gap.atpractice.testSuites;
import com.gap.atpractice.Utils.TakeScreenshot;
import com.gap.atpractice.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * Created by auto on 04/05/17.
 */
public class ActionTest
{
    /*quitar
    private static SeleniumBase seleniumBase;
    //Home page elements
    private static WebElement searchText, searchButton;
    //Search page elements
    private static WebElement searchBoxInput, tabProduct, tabDocument, tabResource, tabEverything,
            downloadButton, nextLink;

    public static void main(String [] args){

        seleniumBase = new SeleniumBase();
        WebDriver driver = seleniumBase.setup("Chrome");
        String url = new File("src/main/resources/html/index.html").getAbsolutePath();
        try
        {


            //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get(url);
            /*searchButton = driver.findElement(By.xpath("//button[@id=\"SubmitButton\"]"));
            searchText = driver.findElement(By.id("SearchText"));
            Thread.sleep(5000);  // Let the user actually see something!
            searchText.sendKeys("network");
            searchButton.click();*/


    /*quitar
            Thread.sleep(5000);  // Let the user actually see something!



            driver.quit();


        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }


    }quitar*/
}
