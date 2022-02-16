package com.rest.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class RequestAndResponseLoging {
	@Test
	public void responseLoging() {
	given()
		.baseUri("https://api.getpostman.com")
		.header("X-Api-Key","").
		
		
		log().all(). //log().header()->for logging header informationl
		
		when()
		.get("/workspaces").
		
		then().log()			//log().ifError()->can be used to log if any error in execution
		.all()					// log().ifValidationFails()
		.assertThat()
		.statusCode(200);
}
}
