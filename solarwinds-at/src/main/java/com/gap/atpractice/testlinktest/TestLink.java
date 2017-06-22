package com.gap.atpractice.testlinktest;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import br.eti.kinoshita.testlinkjavaapi.model.TestProject;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import br.eti.kinoshita.testlinkjavaapi.constants.ExecutionStatus;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.PublicKey;
import java.util.Map;

/**
 * Created by jporras on 15/06/17.
 * This class will handle all the methods used to interact witn Testlink API
 */
public class TestLink extends TestLinkAPI
{


     /**
     * TestLinkTest constructor
     * @param URL URL: TestLink API URL
     * @param devKey String: TestLink key
     * @throws TestLinkAPIException
     * @throws MalformedURLException
     */
    public TestLink(String tesLinkUrl, String devKey) throws TestLinkAPIException, MalformedURLException
    {
        super(new URL(tesLinkUrl),devKey);
    }

    /**
     * createTestlinkProject method creates a new Project in TestLink
     * @param testProjectName String: Project name
     * @param testProjectPrefix String: Project prefix
     * @param notes String: Notes
     * @param enableRequirements Boolean: Enable Requirements
     * @param enableTestPriority Boolean: Enable Test Priority
     * @param enableAutomation Boolean: Enable Automation
     * @param enableInventory Boolean: Enable Inventory
     * @param isActive Boolean: Define if project is Active
     * @param isPublic Boolean: Define if project is Public
     * @return TestProject object
     */
    public TestProject createTestlinkProject(String testProjectName, String testProjectPrefix, String notes, Boolean
                                             enableRequirements, Boolean enableTestPriority, Boolean enableAutomation,
                                             Boolean enableInventory, Boolean isActive, Boolean isPublic)
    {

        return this.createTestProject(testProjectName, testProjectPrefix, notes, enableRequirements, enableTestPriority,
                enableAutomation, enableInventory, isActive, isPublic);

    }


    /**
     * createTestLinkPlan method create a new TestLink Plan
     * @param testPlanName String: Plan name
     * @param testProjectName String: Project Name, needs to be already created
     * @param notes String: Notes
     * @param isActive Boolean: Define if plan is Active
     * @param isPublic Boolean: Define if plan is Public
     * @return TestPlan object
     */
    public TestPlan createTestLinkPlan(String testPlanName, String testProjectName, String notes, Boolean isActive, Boolean isPublic)
    {
        return this.createTestPlan(testPlanName, testProjectName, notes, isActive, isPublic);
    }

    /**createTestLinkBuild method create a new test Build in a Test Plan using ID
    * @param testPlanId Integer: Test Plan ID
    * @param buildName String: Build name
    * @param buildNotes String; Notes
    * @return Build Object
    */
    public Build createTestLinkBuild (Integer testplanId, String buildName, String buildNotes)
    {
        return this.createBuild(testplanId, buildName, buildNotes);
    }

    /**createTestLinkBuild method create a new test Build in a Test Plan project and plan name
     * @param testPlanId Integer: Test Plan ID
     * @param buildName String: Build name
     * @param buildNotes String; Notes
     * @return Build Object
     */
    public Build createTestLinkBuild (String testPlanName,String testProjectName, String buildName, String buildNotes)
    {
        return this.createBuild(getTestLinkPlanByName(testPlanName, testProjectName).getId(), buildName, buildNotes);
    }


    /**
     * This method adds a Test Case To its corresponding plan in Test Link
     * @param testCaseId Integer: Test Case Id (Internal ID in Test Link)
     * @param testProjectId Integer: Project ID
     * @param testPlanId Integer: Plan ID
     * @param version Integer: Version
     * @param platformId Integer: Platform ID
     * @param order Integer: Order
     * @param urgency Integer Urgency number
     * @return Integer with status code(2264 added successfully)
     */
    public int addTestLinkTestCasesToTestPlan(Integer testCaseId, Integer testProjectId, Integer testPlanId, Integer version, Integer platformId, Integer order, Integer urgency)
    {
        return this.addTestCaseToTestPlan(testProjectId, testPlanId, testCaseId, version, platformId, 0, urgency);
    }

    public int addTestLinkTestCasesToTestPlan(Integer testCaseId,String projectName, String planName, Integer version, Integer platformId, Integer urgency)
    {
        TestProject testProject = getTestProjectByName(projectName);
        TestPlan testPlan = getTestPlanByName(planName, projectName);
        return this.addTestCaseToTestPlan(testProject.getId(), testPlan.getId(), testCaseId, version, platformId, 0, urgency);
    }


    /**
     * This Methos updates the test case status after running
     * @param testCaseId Integer: Test case ID
     * @param testCaseExternalId Integer: Test case external id number
     * @param testPlanId Integer: test plan id
     * @param status ExecutionStatus: Status Code
     * @param buildId Integer: Build id
     * @param buildName String: build name
     * @param notes String: Notes
     * @param guess Boolean: guess parameter
     * @param bugId String: Bug id
     * @param platformId Integer: platform id
     * @param platformName String: Platform name
     * @param customFields Map<String, String>: Custom field Map of strings
     * @param overwrite Boolean: Override
     */
    public void updateTestCaseRunStatus(Integer testCaseId, Integer testCaseExternalId, Integer testPlanId, ExecutionStatus status, Integer buildId, String buildName,
                                     String notes, Boolean guess, String bugId, Integer platformId, String platformName, Map<String, String> customFields, Boolean overwrite)
    {
        this.setTestCaseExecutionResult(testCaseId, testCaseExternalId, testPlanId, status, buildId, buildName, notes, guess, bugId, platformId, platformName, customFields, overwrite);
    }




    /**
     * This Methid returns the Test Link Plan by Name and Project Name.
     * @param testPlanName String: Plan Name
     * @param testProjectName String: Project Name
     * @return TesPlan Object
     */
    public TestPlan getTestLinkPlanByName(String testPlanName,String testProjectName)
    {
        return this.getTestPlanByName(testPlanName,testProjectName);
    }

    public TestProject getTestProject(String testProjectName)
    {
        return this.getTestProjectByName(testProjectName);
    }

    public Integer getBuildID(Integer planId, String buildName)
    {
        Build[] builds = this.getBuildsForTestPlan(planId);
        Integer buildId = null;
        for(int i = 0; i<builds.length; i++)
        {
            if(builds[i].getName().equals(buildName))
            {
                buildId = builds[i].getId();
            }
        }
        return  buildId;
    }


}
