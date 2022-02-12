package com.rest.RestAssured;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ExtractSingleValueFromResponse {
	@Test
	public void extractSingleValueFromResponse() {
		String res=given()
		.baseUri("https://api.getpostman.com")
		.header("X-Api-Key","\r\n" + 
				"PMAK-6203df990dd32b308e6dcf70-e0272052d58a52b561d45ba52459f03a0f").
		
		when()
		.get("/workspaces").
		
		then().log()
		.all()
		.assertThat()
		.statusCode(200)
		.extract().response().asString();// Extracting response
		//method1
		//creating JsonPath Instance
//		JsonPath jsonpath=new JsonPath(res.asString());
//		System.out.println("Response= "+jsonpath.getString("workspaces[0].name"));
		//method2
		//System.out.println("Response= "+res.path("workspaces[0].name"));//path is used to get a value from response body using JsonPath or xmlPath
	
	//method3
		JsonPath.from(res) //at this stage we have to use String instead of Response,response().asString() we will provide
		.getString("workspaces[0].name");
		
	
	
	}
}
