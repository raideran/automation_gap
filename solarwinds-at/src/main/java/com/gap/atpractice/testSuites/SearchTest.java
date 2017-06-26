package com.gap.atpractice.testSuites;
import com.gap.atpractice.Utils.TakeScreenshot;
import com.gap.atpractice.dataprovider.DataProviderClass;
import com.gap.atpractice.pageobject.HomePage;
import com.gap.atpractice.pageobject.SearchPage;
import java.lang.String;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


/**
 * Created by jporras on 06/04/17.
 * This class contains all the test cases
 * related to the search functionality
 * in Solarwinds page
 */
public class SearchTest extends TestBase
{


    @BeforeMethod(alwaysRun = true)
    @Parameters({"SearchTextTCID"})
    private void setTestCaseID(Integer tcID)
    {
        this.tcID = tcID;
    }


    @Test(groups = {"smoke"})
    @Parameters({"searchText"})
    public void searchTest(String searchText)
    {
        try {
            HomePage hPage = (HomePage) new HomePage(driver).get();
            SearchPage sPage = hPage.searchText(searchText);
            Assert.assertTrue(sPage.isPageLoaded("Search"), "SearchPage was not correctly loaded");
            Assert.assertTrue(sPage.isTabProductPresent(), "Search page didn't load correctly some component");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * This test case verify that the serach Page is loaded
     * from the home page.
     * It uses the Data Provider class to send parameters
     */
    @Test(groups = "dataprovider", dataProvider = "getSearchData", dataProviderClass = DataProviderClass.class)
    public void searchTestProvider(String dato, String searchText) {
        try {
            HomePage hPage = (HomePage) new HomePage(driver).get();
            SearchPage sPage = hPage.searchText(searchText);
            Assert.assertTrue(sPage.isPageLoaded("Search"), "SearchPage was not correctly loaded");
            Assert.assertTrue(sPage.isTabProductPresent(), "Search page didn't load correctly some component");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




}

