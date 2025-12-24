package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.ex_03_PUT;

import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_PUT_NON_BDDStyle {

    RequestSpecification r;
    Response response;
    ValidatableResponse vr;

    @Test
    public void test_PUT_NonBDD(){

        String token = "17de5e36e80a448";
        String bookingId = "1834";

        Faker faker = new Faker();
        String name = faker.name().fullName();
        System.out.println(name);

        String payload = "{\n" +
                "    \"firstname\" : \""+name+"\",\n" +
                "    \"lastname\" : \"Kadus\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";

        System.out.println("------ Part 1 - GIVEN ------");

        r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com");
        r.basePath("/booking/"+bookingId);
        r.relaxedHTTPSValidation();
        r.contentType(ContentType.JSON);
        r.cookie("token", token);
        r.body(payload).log().all();

        System.out.println("------ Part 2 - WHEN ------");

        response = r.when().log().all().put();

        System.out.println("------ Part 3 - THEN ------");

        vr = response.then().log().all();
        vr.statusCode(200);
    }
}
