package com.gap.atpractice.testlistener;

import com.gap.atpractice.Utils.TakeScreenshot;
import com.gap.atpractice.testSuites.TestBase;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
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

    }

    /*
     *This Method will be triggered if the Test finished successfully
     *It will print the summary of the test in the printStatus method
     */
    public void onTestSuccess(ITestResult result)
    {
        printStatus(result);
    }

    /*
     *This method will be triggered if the test fails
     *It will print the summary of the test in the printStatus method
     */
    public void onTestFailure(ITestResult result)
    {
        printStatus(result);
        WebDriver driver = ((TestBase)(result.getInstance())).getDriver();
        TakeScreenshot.takeScreenshot(driver,"./src/main/resources/screenshots/");
    }

    /*
     *This method will be triggered if the test is skipped
     *It will print the summary of the test in the printStatus method
     */
    public void onTestSkipped(ITestResult result)
    {
        printStatus(result);
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