package com.gap.atpractice.testSuites;

import com.gap.atpractice.pageobject.LicensedPage;
import com.gap.atpractice.pageobject.RegFormPage;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

/**
 * Created by jporras on 6/26/2017.
 */
public class FirstLastNameTest extends TestBase
{
    @BeforeMethod(alwaysRun = true)
    @Parameters({"FirstLastNameTCID"})
    private void setTestCaseID(Integer tcID)
    {
        this.tcID = tcID;
    }

    @Test(groups = {"smoke"})
    @Parameters({"firstName", "lastName"})
    public void firstLastNameTest(String firstName, String lastName)
    {
        try
        {
            LicensedPage hPage = (LicensedPage) new LicensedPage(driver).get();
            RegFormPage sPage = hPage.sendFirstLasNameData(firstName, lastName);
            Assert.assertTrue(sPage.isPageLoaded("Download a free trial of Network Performance Monitor from SolarWinds"), "Regform page was not correctly loaded");
            Assert.assertTrue(sPage.verifyFirstLastNameFields(firstName,lastName), "Regform page didn't loaded correctly the firstname and Lastname fields");
        }
        catch (Exception e)
        {
            Assert.fail(e.getMessage());
        }
    }

}
