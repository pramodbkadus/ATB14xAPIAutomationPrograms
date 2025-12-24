package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.ex_04_PATCH;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_PATCH_NON_BDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_PUT_NonBDD(){

        String token = "9377ca9f45bfa66";
        String bookingId = "4130";

        Faker faker = new Faker();
        String firstName = faker.name().firstName();
        String lastName = faker.name().lastName();
        System.out.println(firstName);
        System.out.println(lastName);

        String payloadPatch = "{\n" +
                "    \"firstname\" : \""+firstName+"\",\n" +
                "    \"lastname\" : \"Brown\"\n" +
                "}";

        System.out.println("------ Part 1 - GIVEN ------");

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingId);
        r.relaxedHTTPSValidation();
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.body(payloadPatch).log().all();

        System.out.println("------ Part 2 - WHEN ------");

        response = r.when().log().all().patch();

        System.out.println("------ Part 3 - THEN ------");

        vr = response.then().log().all();
        vr.statusCode(200);
    }
}
