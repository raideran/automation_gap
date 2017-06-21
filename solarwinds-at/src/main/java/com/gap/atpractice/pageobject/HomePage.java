package com.gap.atpractice.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by auto on 15/05/17.
 */
public class HomePage extends PageBase
{
    @FindBy(id = "SearchText")
    private WebElement searchText;
    @FindBy(xpath = "//button[@class='btn btn-warning btn-sm']")
    private WebElement searchButton;

    public HomePage(WebDriver driver)
    {
        super(driver);

        PageFactory.initElements(driver,this);
    }

    @Override
    protected void load()
    {
        driver.navigate().to(super.BASE_URL);
    }

    @Override
    protected void isLoaded() throws Error
    {
        if(!isPageLoaded("IT Management Software & Monitoring Tools | SolarWinds"))
        {
            throw new Error("Home Page was not successfully loaded");
        }
    }

    public SearchPage searchText(String textToSearch)
    {
        botDriver.type(searchText,textToSearch);
        searchButton.click();
        return new SearchPage(this.driver);
    }

}
