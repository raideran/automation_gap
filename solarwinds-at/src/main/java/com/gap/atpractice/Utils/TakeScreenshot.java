package com.gap.atpractice.Utils;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Jporras on 24/04/17.
 * This class wil handle the screenshots taken in the application
 */

public class TakeScreenshot
{
    /*
     * This method takes the browser screenshot
     * using the path given. It saves the file
     * in jpg format and adds the timestamp in oder to make
     * the file unique
     */
    public static void takeScreenshot(WebDriver driver, String path)
    {
        File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try
        {
            DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy h-m-s");
            Date date = new Date();
            FileUtils.copyFile(src, new File(path + "_" + dateFormat.format(date) + ".jpg"));
        }
        catch (IOException e)
        {
            System.out.println(e.getMessage());
        }
    }
}