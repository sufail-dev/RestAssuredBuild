package com.rest.RestAssured;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import java.util.Collections;

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
		.header("X-Api-Key","").
		
		when()
		.get("/workspaces").
		
		then().log()
		.all()
		.assertThat()
		.statusCode(200).body("workspaces.name", contains("My Workspace","Team Workspace","Practice"),
				
			"workspaces.name",containsInAnyOrder("My Workspace","Practice","Team Workspace"),
			"workspaces.name",empty(),
			"workspaces.name",is(not(empty())),
			"workspaces.name",hasSize(3),
			"worspaces.name",everyItem(startsWith("p")),
			"workspaces[0]",hasKey("id"),
			"workspaces[0]",hasValue("Team Workspace"),
			"workspaces[0]",hasEntry("id","86dc7153-3f42-430b-a1b6-8a44b467359c"),
			"workspaces[0]",equalTo(Collections.EMPTY_MAP),
			"workspaces[0]",not(equalTo(Collections.EMPTY_MAP))
				)
		.extract().response();// Extracting response
		//System.out.println(res);
//		JsonPath jsonpath=new JsonPath(res.asString());
//		assertThat(jsonpath.getString("workspaces[0].name"),equalTo("My Workspace"));
		//Assert.assertEquals(jsonpath.getString("workspaces[0].name"), equalTo("My Workspace")); using testNg*
		
	}
}
