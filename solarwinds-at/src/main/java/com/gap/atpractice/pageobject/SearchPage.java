package com.gap.atpractice.pageobject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


/**
 * Created by jporras on 15/05/17.
 */
public class SearchPage extends PageBase
{
    @FindBy(id = "searchBoxInput")
    private WebElement searchBoxInput;
    @FindBy(xpath = "//li/a[text()=\"Products\"]")
    private WebElement tabProduct;
    @FindBy(xpath = "//li/a[text()=\"Documentation\"]")
    private WebElement tabDocument;
    @FindBy(xpath = "//li/a[text()=\"Resources\"]")
    private WebElement tabResource;
    @FindBy(xpath = "//li/a[text()=\"Everything\"]")
    private WebElement tabEverything;
    @FindBy(css = ".NextPage")
    private WebElement nextPage;
    @FindBy(css = ".downloadBtn")
    private WebElement downloadBtn;

    private final String CURRENT_URL = "Search";

    public SearchPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    protected void load()
    {
        driver.navigate().to(BASE_URL.concat(CURRENT_URL));
    }

    @Override
    protected void isLoaded() throws Error
    {
        if(!isPageLoaded("Search"))
        {
            throw new Error("Search Page was not successfully loaded");
        }
    }

    public boolean isTabProductPresent()
    {
        boolean validations = true;
        if (tabProduct.getSize().equals(0))
        {
            System.out.println("Product tab is not present in the page");
            validations = false;
        }
        return  validations;
    }

    public boolean isNextPageLinkDisplayed()
    {
        boolean validations = true;
        if(!nextPage.isDisplayed())
        {
            System.out.println("Next Page link is not visible");
            validations = false;
        }
        return validations;
    }

    public boolean isDownladButtonDisplayed()
    {
        boolean validations = true;
        if(!downloadBtn.isDisplayed())
        {
            System.out.println("Download Button is not visible");
            validations = false;
        }
        return validations;
    }

    public void exampleJavascriptExecutor()
    {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", searchBoxInput);
    }
}
