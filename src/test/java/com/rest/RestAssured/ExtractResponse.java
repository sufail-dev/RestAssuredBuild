package com.rest.RestAssured;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

import io.restassured.response.Response;


public class ExtractResponse {
	@Test
	public void extractResponse() {
		Response res=given()
		.baseUri("https://api.getpostman.com")
		.header("X-Api-Key","\r\n" + 
				"").
		
		when()
		.get("/workspaces").
		
		then().log()
		.all()
		.assertThat()
		.statusCode(200)
		.extract().response();// Extracting response
		System.out.println("Response= "+res.asString()); //we have to use asString
	}
	

}
