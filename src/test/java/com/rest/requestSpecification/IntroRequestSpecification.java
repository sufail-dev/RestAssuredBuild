package com.rest.requestSpecification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class IntroRequestSpecification {
	@Test
	public void responseLoging() {
		RequestSpecification requestSpecification=
	given()
		.baseUri("https://api.getpostman.com")
		.header("X-Api-Key","\r\n" + 
				"");
		
		given(requestSpecification).
		
		when()
		.get("/workspaces").
		
		then().log()			
		.all()					
		.assertThat()
		.statusCode(200);
}
}
