package com.gap.atpractice.testlistener;

import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import com.gap.atpractice.Utils.TakeScreenshot;
import com.gap.atpractice.testSuites.TestBase;
import com.gap.atpractice.testlinktest.TestLink;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.net.MalformedURLException;
/**
 * Created by jporras on 19/06/17.
 */

/**
 * This class will implement the ITestListener Interfase
 * in order to handle the different scenarios/statuses of the test cases
 */
public class Listener implements ITestListener
{

    public void onTestStart(ITestResult result)
    {
        TestBase base = (TestBase) (result.getInstance());
        Integer addStatus;
        try
        {
            if (base.getAddTestCasesToPlan()) {
                TestLink testLink = new TestLink(base.getTestLinkURL(), base.getDevKey());
                try
                {
                    addStatus = testLink.addTestLinkTestCasesToTestPlan(base.getTcId(), base.getProjectName(), base.getTestPlanName(), 1, 1, 1);
                }
                catch(Exception e)
                {
                    addStatus = 333;
                }
                switch (addStatus) {
                    case 2346: //Correctly Added Status
                        System.out.println("Test Case: " + base.getTcId() + "correctly added to Test Plan: " + base.getTestPlanName());
                        break;
                    case 333:
                        System.out.println("Test Case: " + base.getTcId() + "already exists in Test Plan: " + base.getTestPlanName());
                        break;
                    default:
                        System.out.println("Unknown Status was retrieved when trying to add the Test Case:" + base.getTcId() + "to the Test Plan: " + base.getTestPlanName());
                }
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }

    /*
     *This Method will be triggered if the Test finished successfully
     *It will print the summary of the test in the printStatus method
     */
    public void onTestSuccess(ITestResult result)
    {
        try
        {
            printStatus(result);
            TestBase base = (TestBase) (result.getInstance());
            TestLink testLink = new TestLink(base.getTestLinkURL(),base.getDevKey());
            Integer planId = testLink.getTestLinkPlanByName(base.getTestPlanName(),base.getProjectName()).getId();
            Integer buildId=testLink.getBuildID(planId, base.getTestBuildName());
            String note = "TestCase" + base.getTcId() + " Ran Successfully";
            testLink.updateTestCaseRunStatus(base.getTcId(), null, planId ,
                                             ExecutionStatus.PASSED, buildId , base.getTestBuildName(),
                                             note, true, null, null, null,
                                             null, true);

        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

    }

    /*
     *This method will be triggered if the test fails
     *It will print the summary of the test in the printStatus method
     */
    public void onTestFailure(ITestResult result)
    {
        printStatus(result);
        TestBase base = (TestBase) (result.getInstance());
        TakeScreenshot.takeScreenshot(base.getDriver(),"./src/main/resources/screenshots/");
        try
        {
            TestLink testLink = new TestLink(base.getTestLinkURL(),base.getDevKey());
            Integer planId = testLink.getTestLinkPlanByName(base.getTestPlanName(),base.getProjectName()).getId();
            Integer buildId=testLink.getBuildID(planId, base.getTestBuildName());
            String note = "TestCase" + base.getTcId() + " Failed";
            testLink.updateTestCaseRunStatus(base.getTcId(), null, planId ,
                    ExecutionStatus.FAILED, buildId , base.getTestBuildName(),
                    note, true, null, null, null,
                    null, true);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }

    }

    /*
     *This method will be triggered if the test is skipped
     *It will print the summary of the test in the printStatus method
     */
    public void onTestSkipped(ITestResult result)
    {
        printStatus(result);
        try
        {
            TestBase base = (TestBase) (result.getInstance());
            TestLink testLink = new TestLink(base.getTestLinkURL(),base.getDevKey());
            Integer planId = testLink.getTestLinkPlanByName(base.getTestPlanName(),base.getProjectName()).getId();
            Integer buildId=testLink.getBuildID(planId, base.getTestBuildName());
            String note = "TestCase" + base.getTcId() + " Failed";
            testLink.updateTestCaseRunStatus(base.getTcId(), null, planId ,
                    ExecutionStatus.NOT_RUN, buildId , base.getTestBuildName(),
                    note, true, null, null, null,
                    null, true);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }


    public void onStart(ITestContext context)
    {


    }


    public void onFinish(ITestContext context)
    {
        /*System.out.println("****************TestRun Report Header ********************" );
        System.out.println("Total Passed" +  context.getPassedTests());
        System.out.println("Total Failed" +  context.getFailedTests());
        System.out.println("Total Skipped" + context.getSkippedTests());
        System.out.println("*****************TestRun Report Footer ********************" );
        */
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {
        //TODO Auto-generated method stub

    }


    /**
     * This method will print the summary of the test result,
     */
    private void printStatus(ITestResult result)
{
    System.out.println("*****************************************************");
    System.out.println("SUMMARY");
    System.out.println("*****************************************************");
    System.out.println("|-- Test Class: ".concat(result.getInstanceName()));
    System.out.println("|-- Method: ".concat(result.getName()));
    Long runningDuration = result.getEndMillis()-result.getStartMillis();
    System.out.println("|-- Execution Time: ".concat(runningDuration.toString()));
    System.out.println("|-- Status: ".concat(getStatus(result.getStatus())));
    System.out.println("*****************************************************");
    System.out.println("");
    System.out.println("");
}

    /*
     *This Method will convert the ITestResult status which is an integer
     *to the corresponding text
     */
    private String getStatus(int status)
{
    switch (status)
    {
        case ITestResult.SUCCESS:
            return "PASSED";
        case ITestResult.FAILURE:
            return "FAILED";
        case ITestResult.SKIP:
            return "SKIPPED";
        default:
            return "RESULT CODE NOT RECOGNIZED";
    }
}

}