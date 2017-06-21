package com.gap.atpractice.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by jporras on 06/04/17.
 * This class instantiate the webdriver according
 * to the browser option it receives as parameter
 */
public class SeleniumBase
{
    protected WebDriver driver;

    public WebDriver setup(String browserName, boolean capabilities)
    {
        switch(browserName)
        {
            case "Chrome":
                initChrome(capabilities);
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

    private void initChrome(boolean capabilities)
    {
        if(capabilities) {
            //System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\Chrome\\Application\\chromedriver.exe");
            ChromeOptions options = new ChromeOptions();
            DesiredCapabilities capa = new DesiredCapabilities();
            options.addArguments("start-maximized");
            //capa.
            //driver
        }
        driver = new ChromeDriver();
    }

    public void initFirefox()
    {
        driver = new FirefoxDriver();
    }

    public void initInternetExplorer()
    {
        driver = new InternetExplorerDriver();
    }
}
