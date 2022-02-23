package com.rest.requestSpecification;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BDDToNonBDDThree {
	RequestSpecification requestSpecification;
	@BeforeClass
	public void beforeClass() { 
		requestSpecification = given().baseUri("https://api.getpostman.com").header("X-Api-Key",
				"\r\n" + "").log().all();
	}

	@Test
	public void responseLoging() {
		//RequestSpecification requestSpecification=
		Response response=requestSpecification.get("/workspaces").then().log().all()
				.extract().response();
		//assertThat(response.statusCode(),is(equalTo(200)));
		//assertThat(response.path("workspaces[0].name").toString().equalTo("Team Workspace"));
		

}
}
