package com.gap.atpractice.testSuites;
import com.gap.atpractice.Utils.TakeScreenshot;
import com.gap.atpractice.dataprovider.DataProviderClass;
import com.gap.atpractice.pageobject.HomePage;
import com.gap.atpractice.pageobject.SearchPage;
import com.gap.atpractice.selenium.SeleniumBase;
import java.lang.String;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * Created by auto on 06/04/17.
 */
public class LoginTest extends TestBase
{
    /*private static SeleniumBase seleniumBase;
    private static WebDriver driver;*/


    /*@BeforeClass(groups = {"smoke"})
    @Parameters({"browser"})
    private static void initTest(String browser)
    {
        seleniumBase = new SeleniumBase();
        driver = seleniumBase.setup(browser);
    }*/


    @Test(groups = {"smoke"})
    @Parameters({"searchText"})
    public void loginTest(String searchText)
    {

        try
        {
            //initTest("Chrome");
            HomePage hPage = (HomePage)new HomePage(driver).get();
            SearchPage sPage = hPage.searchText(searchText);

            if(!sPage.isPageLoaded("Search"))
            {
                System.out.println("SearchPage Not Correctly Loaded");
                //System.exit(0);
            }

            sPage.pageValidations();
            //TakeScreenshot.takeScreenshot(driver,"./src/main/resources/screenshots");
            //driver.quit();

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test(groups = "dataprovider", dataProvider = "getSearchData", dataProviderClass = DataProviderClass.class)
    public void searchTest(String dato, String searchText)
    {

        try
        {
            //initTest("Chrome");
            HomePage hPage = (HomePage)new HomePage(driver).get();
            SearchPage sPage = hPage.searchText(searchText);

            if(!sPage.isPageLoaded("Search"))
            {
                System.out.println("SearchPage Not Correctly Loaded");
            }

            Assert.assertTrue(sPage.pageValidations(),"Search page didn't load correctly some component");
            TakeScreenshot.takeScreenshot(driver,"./src/main/resources/screenshots");

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }

}
