package com.thetestingacademy.ex_05_TestNGAdvanceExample;

import org.testng.annotations.Test;

public class APITesting021_TestNG_AlwaysRun {

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test(alwaysRun = true)
    public void test2(){
        System.out.println("test2");
    }

    @Test(enabled = true)
    public void test3(){
        System.out.println("test3");
    }
}
