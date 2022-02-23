package com.rest.requestSpecification;

import static io.restassured.RestAssured.given;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.specification.RequestSpecification;

public class RequestSpecificationReUseTwo {

	// if we have 100 tests then we can do lie this by creating a common space for
	// requestspecification
	RequestSpecification requestSpecification;

	@BeforeClass
	public void beforeClass() { 
		requestSpecification = given().baseUri("https://api.getpostman.com").header("X-Api-Key",
				"\r\n" + "PMAK-6203df990dd32b308e6dcf70-e0272052d58a52b561d45ba52459f03a0f");
	}

	@Test
	public void responseLoging() {

		given(requestSpecification).

				when().get("/workspaces").

				then().log().all().assertThat().statusCode(200);
	}

	@Test
	public void requestmultiple() {

		given(requestSpecification).

				when().get("/workspaces").

				then().log().all().assertThat().statusCode(200);
	}

}
