package com.gap.atpractice.testlinktest;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import br.eti.kinoshita.testlinkjavaapi.model.Build;
import br.eti.kinoshita.testlinkjavaapi.model.TestPlan;
import br.eti.kinoshita.testlinkjavaapi.model.TestProject;
import br.eti.kinoshita.testlinkjavaapi.util.TestLinkAPIException;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.security.PublicKey;

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

    public TestPlan getTestLinkPlanByName(String testPlanName,String testProjectName)
    {
        return this.getTestPlanByName(testPlanName,testProjectName);
    }

}
