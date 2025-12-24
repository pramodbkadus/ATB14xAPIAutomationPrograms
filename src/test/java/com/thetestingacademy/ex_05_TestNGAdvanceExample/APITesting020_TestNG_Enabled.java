package com.thetestingacademy.ex_05_TestNGAdvanceExample;

import org.testng.annotations.Test;

public class APITesting020_TestNG_Enabled {

    @Test
    public void test1(){
        System.out.println("test1");
    }

    @Test(enabled = false)
    public void test2(){
        System.out.println("test2");
    }

    @Test(enabled = true)
    public void test3(){
        System.out.println("test3");
    }
}
