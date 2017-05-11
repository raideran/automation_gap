package com.gap.atpractice.testSuites;

import com.gap.atpractice.selenium.SeleniumBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by auto on 08/05/17.
 */
public class CapabilitiesTest
{
    private static SeleniumBase seleniumBase;

    public static void main(String [] args)
    {
        seleniumBase = new SeleniumBase();
        WebDriver driver = seleniumBase.setup("Chrome");
        //WebDriver driver = seleniumBase.setup("Firefox");
        //WebDriver driver = seleniumBase.setup("InternetExplorer");

    }

}
