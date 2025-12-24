package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.ex_05_DELETE;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_DELETE_NON_BDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_PUT_NonBDD(){

        String token = "75226e109cfec0a";
        String bookingId = "540";

        System.out.println("------ Part 1 - GIVEN ------");

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingId);
        r.relaxedHTTPSValidation();
        r.contentType(ContentType.JSON);
        r.cookie("token", token);

        System.out.println("------ Part 2 - WHEN ------");

        response = r.when().log().all().delete();

        System.out.println("------ Part 3 - THEN ------");

        vr = response.then().log().all();
        vr.statusCode(201);
    }
}
