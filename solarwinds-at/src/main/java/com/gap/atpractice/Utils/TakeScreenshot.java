package com.gap.atpractice.Utils;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
//package com.gap.atpractice.selenium;

/**
 * Created by auto on 24/04/17.
 */
public class TakeScreenshot
{
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
