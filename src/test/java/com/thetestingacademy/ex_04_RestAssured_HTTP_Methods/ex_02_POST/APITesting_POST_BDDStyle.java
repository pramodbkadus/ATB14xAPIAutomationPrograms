package com.thetestingacademy.ex_04_RestAssured_HTTP_Methods.ex_02_POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class APITesting_POST_BDDStyle {

    @Test
    public void test_POST_AUTH_TOKEN(){

        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        RestAssured
                .given()
                    .relaxedHTTPSValidation()
                    .baseUri("https://restful-booker.herokuapp.com")
                    .basePath("/auth")
                    .body(payload)
                    .contentType(ContentType.JSON)
                    .log().all()
                .when()
                    .log().all()
                    .post()
                .then()
                    .log().all()
                    .statusCode(200);
    }
}
