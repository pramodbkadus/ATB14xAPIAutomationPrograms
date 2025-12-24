package com.thetestingacademy.ex_05_TestNGAdvanceExample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting018_TestNG_DependsOnMethod {

    @Test
    public void serverStartedOk(){
        System.out.println("Server Started...");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void test1(){
        System.out.println("Method 1");
        Assert.assertTrue(true);
    }

    @Test(dependsOnMethods = "serverStartedOk")
    public void test2(){
        System.out.println("Method 2");
        Assert.assertTrue(true);
    }
}
