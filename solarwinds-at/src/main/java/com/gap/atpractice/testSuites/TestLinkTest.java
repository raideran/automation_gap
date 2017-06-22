package com.gap.atpractice.testSuites;

import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.gap.atpractice.testlinktest.TestLink;

/**
 * Created by jporras on 19/06/17.
 */

/**
 * This is a class to test the creation of test plans and builds
 */
public class TestLinkTest extends TestBase
{


    /**
     * This method will create the test plan in testlink
     * TODO: Make it dynamic in order to create plans accordingly to the situation
     * @param projectName String: Project Name
     * @param testPlanName String: Test Plan Name
     * @param testPlanNotes String: Test Plan Notes
     * @param testPlanIsActive Boolean: Defines if the Test Plan is Active
     * @param testPlanIsPublic Boolean: Defines if the Test Plan is Active
     */
    @Test(groups = "testLink", enabled = false)
    @Parameters({"projectName","testPlanName","testPlanNotes","testPlanIsActive","testPlanIsPublic"})
    public void testLinkPlan(String projectName,String testPlanName,String testPlanNotes,Boolean testPlanIsActive,Boolean testPlanIsPublic)
    {
        try
        {
            TestLink testLink = new TestLink(super.testLinkURL, super.devKey);
            TestPlan testPlan = testLink.createTestPlan(testPlanName,projectName,testPlanNotes,testPlanIsActive,testPlanIsPublic);
            Assert.assertEquals(testPlan.getName(),testPlanName);
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
    @Test(groups = "testLink", enabled = false)
    @Parameters({"projectName","testPlanName","testBuildName","testBuildNotes"})
    public void testLinkBuild(String projectName,String testPlanName,String testBuildName,String testBuildNotes)
    {
        try
        {
            TestLink testLink = new TestLink(super.testLinkURL, super.devKey);
            Build build = testLink.createTestLinkBuild(testPlanName,projectName,testBuildName,testBuildNotes);
            Assert.assertEquals(build.getName(),testBuildName);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Test(groups = "testLink")
    @Parameters({"projectName","testPlanName","SearchTextTCID"})
    public void testLinkAddTestCaseToPlan(String projectName, String testPlanName, Integer searchTextTCID)
    {
        try
        {
            Integer expectedStatus = 2346;
            TestLink testLink = new TestLink(super.testLinkURL, super.devKey);
            Integer addStatus = testLink.addTestLinkTestCasesToTestPlan(searchTextTCID, projectName, testPlanName, 1, 1, 1);
            Assert.assertEquals(addStatus,expectedStatus);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
