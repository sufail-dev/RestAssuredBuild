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
				"PMAK-6203df990dd32b308e6dcf70-e0272052d58a52b561d45ba52459f03a0f").
		
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
