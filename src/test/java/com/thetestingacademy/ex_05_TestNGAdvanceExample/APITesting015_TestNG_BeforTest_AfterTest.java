package com.thetestingacademy.ex_05_TestNGAdvanceExample;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting015_TestNG_BeforTest_AfterTest {

    // PUT Request
    // 1. getToken
    // 2. getBookingId
    // 3. test_PUT
    // 4. closeAllThings

    @BeforeTest
    public void getToken(){
        System.out.println("GET TOKEN");
    }

    @BeforeTest
    public void getBookingId(){
        System.out.println("GET BOOKING ID");
    }

    @Test
    public void test_PUT(){
        System.out.println("PUT REQUEST");
    }

    @AfterTest
    public void closeAllThings(){
        System.out.println("CLOSE");
    }
}
