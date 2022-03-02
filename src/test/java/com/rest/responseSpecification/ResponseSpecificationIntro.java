package com.rest.responseSpecification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecificationIntro {
	ResponseSpecification responseSpecification;
	@Test
	public void responseLoging() {
		responseSpecification=RestAssured.expect().statusCode(200).contentType(ContentType.JSON);
		
		
		
		
		RequestSpecification requestSpecification=
	given()
		.baseUri("https://api.getpostman.com")
		.header("X-Api-Key","");
		
		given(requestSpecification).get("/workspaces").then().spec(responseSpecification)
		.log().all().extract().response();
		
		
		
	
		
	
}
}
