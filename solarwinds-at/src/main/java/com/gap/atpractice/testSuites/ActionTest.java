package com.gap.atpractice.testSuites;


import com.gap.atpractice.pageobject.ActionPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import javax.swing.*;

/**
 * Created by jporras on 04/05/17.
 */
public class ActionTest extends TestBase
{
    @Test(groups = {"smoke"}, enabled = false)
    public void validateActions()
    {
        Boolean result;
        try
        {
            ActionPage actionPage = (ActionPage)new ActionPage(driver).get();
            result = actionPage.doubleClickElement();
            result = actionPage.mouseHover();
            result = actionPage.dragAndTextArea();
            Assert.assertTrue(result);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }


    }
}
