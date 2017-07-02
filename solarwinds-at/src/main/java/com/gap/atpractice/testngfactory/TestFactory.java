package com.gap.atpractice.testngfactory;

import com.gap.atpractice.testSuites.SearchTest;
import org.testng.annotations.Factory;

/**
 * Created by jporras on 15/06/17.
 */
public class TestFactory
{

    //Factory implementation, This defines the number of iterations a testCall will be ran.
    @Factory
    public Object[] CreateInstances()
    {

        Object[] result = new Object[4];
        for (int i=0; i<4; i++)
        {
            result[i] = new SearchTest();
        }
        return result;
    }

}