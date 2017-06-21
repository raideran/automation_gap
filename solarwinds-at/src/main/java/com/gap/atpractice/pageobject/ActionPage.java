package com.gap.atpractice.pageobject;

import javafx.beans.binding.BooleanExpression;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

/**
 * Created by
 * User: jporras
 * Date: 20/06/17
 * Summary: This class will have all the elements and methods needed
 * for the ActionTest class
 */
public class ActionPage extends PageBase
{

    private final String CURRENT_URL = "http://www.japscr.com/automationgap/index.html";
    /**
     * All Page elements needed
     */
    @FindBy(xpath = "//p[@id='double_click']")
    private WebElement doubleClick;
    @FindBy(xpath = "//button[@class='dropbtn']")
    private WebElement mouseHoverMenu;
    @FindBy(xpath = "//div[@class='dropdown-content']/a")
    private List<WebElement> menuElements;
    @FindBy(xpath = "//textarea")
    private WebElement textArea;
    @FindBy(xpath = "//p[@id='draggable']")
    private WebElement draggableElement;
    @FindBy(xpath = "//p[@id='droppable']")
    private WebElement droppableElement;

    public ActionPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver,this);
    }

    @Override
    protected void load()
    {
        driver.navigate().to(CURRENT_URL);
    }

    @Override
    protected void isLoaded() throws Error
    {
        if(!isPageLoaded("AutomationGapActions"))
        {
            throw new Error("Action Page was not successfully loaded");
        }
    }


    public boolean doubleClickElement()
    {
        Boolean actionSucceeded = true;
        try
        {
            botDriver.moveToElement(doubleClick);
            Thread.sleep(3000);
            botDriver.doubleClick(doubleClick);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            actionSucceeded = false;
        }
        return  actionSucceeded;
    }

    public boolean mouseHover()
    {
        Boolean actionSucceded = true;
        try
        {
            botDriver.moveToElement(mouseHoverMenu);
            Thread.sleep(3000);
            botDriver.moveToElement(menuElements.get(1));
            Thread.sleep(3000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            actionSucceded = false;
        }
        return actionSucceded;
    }

    public Boolean dragAndTextArea()
    {
        Boolean actionSucceded = true;
        try
        {
            botDriver.dragAndDropBy(textArea);
            Thread.sleep(3000);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            actionSucceded = false;
        }
        return actionSucceded;
    }

}
