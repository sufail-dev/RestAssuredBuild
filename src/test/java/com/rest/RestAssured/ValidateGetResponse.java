package com.rest.RestAssured;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import org.testng.annotations.Test;

public class ValidateGetResponse {
	
	
	@Test
	public void validateGetStatus() {
		given()
		.baseUri("https://api.getpostman.com")
		.header("X-Api-Key","\r\n" + 
				"").
		
		when()
		.get("/workspaces").
		
		then()   //before assertThat we are using log
		.log().all()
		.assertThat().statusCode(200)
		.body("workspaces.name", hasItems("My Workspace","Team Workspace","Practice"),
				"workspaces.type", hasItems("personal","team","team"),
				"workspaces[0].name",equalTo("My Workspace"),
				"workspaces.size()",equalTo(3),
				"workspaces.name",hasItem("My Workspace")
				
				
				);
	}

}
