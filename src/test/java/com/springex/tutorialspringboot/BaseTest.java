package com.springex.tutorialspringboot;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
   public static RequestSpecification httpRequest;

    public BaseTest() {
        RestAssured.baseURI = "http://localhost:8080";
        httpRequest = RestAssured.given().auth().basic("Admin", "password");
    }
}
