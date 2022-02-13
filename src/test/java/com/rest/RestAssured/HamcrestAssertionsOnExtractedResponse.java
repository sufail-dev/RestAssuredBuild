package com.rest.RestAssured;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;
import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import junit.framework.Assert;



public class HamcrestAssertionsOnExtractedResponse {
	@Test
	public void extractResponse() {
		Response res=given()
		.baseUri("https://api.getpostman.com")
		.header("X-Api-Key","PMAK-6203df990dd32b308e6dcf70-e0272052d58a52b561d45ba52459f03a0f").
		
		when()
		.get("/workspaces").
		
		then().log()
		.all()
		.assertThat()
		.statusCode(200)
		.extract().response();// Extracting response
		//System.out.println(res);
		JsonPath jsonpath=new JsonPath(res.asString());
		assertThat(jsonpath.getString("workspaces[0].name"),equalTo("My Workspace"));
		//Assert.assertEquals(jsonpath.getString("workspaces[0].name"), equalTo("My Workspace")); using testNg*
		
	}
}
