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
            if (base.getAddTestCasesToPlan())
            {
                TestLink testLink = new TestLink(base.getTestLinkURL(), base.getDevKey());
                try
                {
                    addStatus = testLink.addTestLinkTestCasesToTestPlan(base.getTcId(), base.getProjectName(), base.getTestPlanName(), 1, 1, 1, base.getTestBuildName());
                }
                catch(Exception e)
                {
                    addStatus = -2;
                    e.printStackTrace();
                }
                switch(addStatus)
                {
                    case 0: //Correctly Added Status
                        System.out.println("Test Case: " + base.getTcId() + " correctly added to Test Plan: " + base.getTestPlanName());
                        break;
                    case -2:
                        System.out.println("An exception was thrown while trying to add Test Case:" + base.getTcId() + " to the Test Plan: " + base.getTestPlanName());
                        break;
                    case -1: //Correctly Added Status
                        System.out.println("Test Case: " + base.getTcId() + " already exists in Test Plan: " + base.getTestPlanName());
                        break;
                    default:
                        System.out.println("Unknown Status was retrieved when trying to add the Test Case:" + base.getTcId() + " to the Test Plan: " + base.getTestPlanName());
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
     *It will print the summary of the test in the printTestCaseSummary method
     */
    public void onTestSuccess(ITestResult result)
    {
        printTestCaseSummary(result);
        updateRunStatus(result);

    }

    /*
     *This method will be triggered if the test fails
     *It will print the summary of the test in the printTestCaseSummary method
     */
    public void onTestFailure(ITestResult result)
    {
        printTestCaseSummary(result);
        TestBase base = (TestBase) (result.getInstance());
        TakeScreenshot.takeScreenshot(base.getDriver(),"./src/main/resources/screenshots/");
        updateRunStatus(result);

    }

    /*
     *This method will be triggered if the test is skipped
     *It will print the summary of the test in the printTestCaseSummary method
     */
    public void onTestSkipped(ITestResult result)
    {
        printTestCaseSummary(result);
        updateRunStatus(result);
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
    private void printTestCaseSummary(ITestResult result)
{
    System.out.println("*******************************************************************************");
    System.out.println("*------------------------------------SUMMARY----------------------------------*");
    System.out.println("*******************************************************************************");
    System.out.println("||-- Test Class: ".concat(result.getInstanceName()));
    System.out.println("||-- Test Name: ".concat(result.getName()));
    Long executionTime = (result.getEndMillis()-result.getStartMillis())/1000;
    System.out.println("||-- Execution Time: ".concat(executionTime.toString())+ " seconds");
    System.out.println("||-- Status: ".concat(getStatusName(result.getStatus())));
    System.out.println("*******************************************************************************");

}

    /*
     *This Method will convert the ITestResult status which is an integer
     *to the corresponding text
     */
    private String getStatusName(Integer statusId)
    {
        String statusName;
        switch (statusId)
        {
            case ITestResult.SUCCESS:
                statusName = "PASSED";
                break;
            case ITestResult.FAILURE:
                statusName = "FAILED";
                break;
            case ITestResult.SKIP:
                statusName = "SKIPPED";
                break;
            default:
                statusName = "TEST CASE STATUS NOT RECOGNIZED";
                break;
        }
        return statusName;
    }

    private ExecutionStatus getExecutionStatus(Integer statusId)
    {
        ExecutionStatus executionStatus;
        switch (statusId)
        {
            case ITestResult.SUCCESS:
                executionStatus = ExecutionStatus.PASSED;
                break;
            case ITestResult.FAILURE:
                executionStatus = ExecutionStatus.FAILED;
                break;
            case ITestResult.SKIP:
                executionStatus = ExecutionStatus.BLOCKED;
                break;
            default:
                executionStatus = ExecutionStatus.NOT_RUN;
        }
        return executionStatus;
    }

    private void updateRunStatus(ITestResult result)
    {
        try
        {
            TestBase base = (TestBase) (result.getInstance());
            TestLink testLink = new TestLink(base.getTestLinkURL(),base.getDevKey());
            Integer planId = testLink.getTestLinkPlanByName(base.getTestPlanName(),base.getProjectName()).getId();
            Integer buildId=testLink.getBuildID(planId, base.getTestBuildName());
            String note = "TestCase" + base.getTcId() + " " + getStatusName(result.getStatus());
            testLink.updateTestCaseRunStatus(base.getTcId(), null, planId ,
                    getExecutionStatus(result.getStatus()), buildId , base.getTestBuildName(),
                    note, true, null, null, null,
                    null, true);
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
    }



}