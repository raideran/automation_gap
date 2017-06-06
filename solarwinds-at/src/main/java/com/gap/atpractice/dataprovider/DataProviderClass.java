package com.gap.atpractice.dataprovider;

import java.lang.reflect.Method;
import org.testng.annotations.DataProvider;

/**
 * Created by auto on 05/06/17.
 */
public class DataProviderClass
{
    @DataProvider(name = "getSearchData")
    public Object[][] getData(Method m)
    {
        System.out.println(String.format("Data Povider name:  %s", m.getName()));
        return new Object[][]
                {
                        {"Dato1", "network"},
                        {"Dato2", "pack"}
                };
    }
}
