package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.ex_01_GET;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_GET_Non_BDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;
    String pincode;

    @Test
    public void test_GET_NON_BDD_STYLE(){
        pincode = "560049";

        //Divide your program into 3 parts

        // Part 1 - GIVEN
        r = RestAssured.given();
        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/"+pincode);

        // Part 2 - WHEN
        response = r.when().log().all().get();
        System.out.println(response.asString());

        // Part 3 - THEN - Validation
        vr = response.then().log().all();
        vr.statusCode(200);

    }
}
