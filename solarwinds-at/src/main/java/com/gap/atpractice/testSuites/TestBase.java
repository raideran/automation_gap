package com.gap.atpractice.testSuites;

import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import com.gap.atpractice.selenium.SeleniumBase;
import com.gap.atpractice.testlinktest.TestLink;
import org.apache.xpath.operations.Bool;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

/**
 * Created by jporras on 05/06/17.
 * This class contains all the common methods
 * that the test cases will inherit
 */
public class TestBase extends SeleniumBase
{

    //TestLink Access Data
    protected String testLinkURL;
    protected String devKey;
    //TestLink Run Data
    protected String projectName;
    protected String testPlanName;
    protected String testBuildName;
    protected Boolean addTestCasesToPlan;
    protected Integer tcID;

    @BeforeSuite(alwaysRun = true)
    @BeforeMethod(alwaysRun = true)
    @Parameters({"testlinkUrl", "devKey","projectName", "testPlanName", "testBuildName", "addTestCasesToPlan"})
    public void TestLinkSetup(String testLinkURL, String devKey, String projectName, String testPlanName, String testBuildName,Boolean addTestCasesToPlan)
    {
        this.testLinkURL = testLinkURL;
        this.devKey = devKey;
        this.projectName = projectName;
        this.testPlanName = testPlanName;
        this.testBuildName = testBuildName;
        this.addTestCasesToPlan = addTestCasesToPlan;
    }

    /**
     * This method will create the test plan in testlink
     * TODO: Make it dynamic in order to create plans accordingly to the situation
     * @param projectName String: Project Name
     * @param testPlanName String: Test Plan Name
     * @param testPlanNotes String: Test Plan Notes
     * @param testPlanIsActive Boolean: Defines if the Test Plan is Active
     * @param testPlanIsPublic Boolean: Defines if the Test Plan is Active
     */
    @BeforeSuite(alwaysRun = true)
    @Parameters({"projectName","testPlanName","testPlanNotes","testPlanIsActive","testPlanIsPublic", "createTestPlan"})
    public void createTestLinkPlan(String projectName,String testPlanName,String testPlanNotes,Boolean testPlanIsActive,Boolean testPlanIsPublic, Boolean createTestPlan)
    {
        try
        {
            if(createTestPlan)
            {
                TestLink testLink = new TestLink(this.testLinkURL, this.devKey);
                TestPlan testPlan = testLink.createTestPlan(testPlanName, projectName, testPlanNotes, testPlanIsActive, testPlanIsPublic);
                Assert.assertEquals(testPlan.getName(), testPlanName);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * This method will create the build in test link
     * TODO: Make it dynamic in order to create build accordingly to the situation
     * @param projectName String: Project Name
     * @param testPlanName String: Test Plan Name
     * @param testBuildName String: Build Name
     * @param testBuildNotes String: Build Notes
     */
    @BeforeSuite(alwaysRun = true)
    @Parameters({"projectName","testPlanName","testBuildName","testBuildNotes", "createBuild"})
    public void testLinkBuild(String projectName,String testPlanName,String testBuildName,String testBuildNotes,  Boolean createBuild)
    {
        try
        {
            if(createBuild)
            {
                TestLink testLink = new TestLink(this.testLinkURL, this.devKey);
                Build build = testLink.createTestLinkBuild(testPlanName, projectName, testBuildName, testBuildNotes);
                Assert.assertEquals(build.getName(), testBuildName);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /*
     * This method will run before every testcase
     * and will setup the browser driver
     */
    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void initSetup(String browser)
    {
        driver = super.setup(browser,true);

    }

    /*
     * This method will run after every testcase
     * and will shutdown the webdriver instance
     */
    @AfterMethod(alwaysRun = true)
    public void quitSetup()
    {
        driver.quit();
    }

    public WebDriver getDriver()
    {
        return super.driver;
    }

    public String getDevKey()
    {
        return devKey;
    }

    public String getTestLinkURL()
    {
        return testLinkURL;
    }

    public String getProjectName() {
        return projectName;
    }

    public String getTestPlanName()
    {
        return testPlanName;
    }

    public String getTestBuildName()
    {
        return testBuildName;
    }

    public Boolean getAddTestCasesToPlan()
    {
        return addTestCasesToPlan;
    }

    public Integer getTcId() {
        return tcID;
    }
}
