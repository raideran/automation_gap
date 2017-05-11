package com.gap.atpractice.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by auto on 06/04/17.
 */
public class SeleniumBase
{
    private WebDriver driver;
    public WebDriver setup(String browserName)
    {
        switch(browserName)
        {
            case "Chrome":
                initChrome();
                break;
            case "Firefox":
                initFirefox();
                break;
            case "InternetExplorer":
                initInternetExplorer();
                break;
            default:
                System.out.println("Browser does not supported");
                break;

        }
        return driver;
    }

    private void initChrome()
    {
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities capa = new DesiredCapabilities();
        options.addArguments("start-maximized");
        capa.
        driver = new ChromeDriver();
    }
    public void initFirefox()
    {
        driver = new FirefoxDriver();
    }
    public void initInternetExplorer()
    {
        driver = new FirefoxDriver();
    }
}
