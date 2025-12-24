package com.thetestingacademy.ex_05_TestNGAdvanceExample;

import org.testng.annotations.Test;

public class APITesting022_TestNG_InvocationCount {

    @Test(invocationCount = 2)
    public void test1(){
        System.out.println("test1");
    }

    @Test(invocationCount = 3)
    public void test2(){
        System.out.println("test2");
    }
}
