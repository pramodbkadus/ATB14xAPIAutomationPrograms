package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.ex_02_POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_POST_NON_BDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;



    @Test
    public void test_POST_NonBDD_AUTH_TOKEN(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        System.out.println("------ Part 1 - GIVEN ------");

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/auth");
        r.relaxedHTTPSValidation();
        r.contentType(ContentType.JSON);
        r.body(payload).log().all();

        System.out.println("------ Part 2 - WHEN ------");

        response = r.when().log().all().post();

        System.out.println("------ Part 3 - THEN ------");

        vr = response.then().log().all();
        vr.statusCode(200);


    }
}
