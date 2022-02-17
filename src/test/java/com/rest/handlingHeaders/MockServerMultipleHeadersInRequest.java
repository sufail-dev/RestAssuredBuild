package com.rest.handlingHeaders;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class MockServerMultipleHeadersInRequest {
	@Test
	public void multipleHeaderProcessing() {
		HashMap<String,String> headerss=new HashMap<String,String>();
		headerss.put("myHeaderName","value2");
		headerss.put("x-mock-match-request-headers","myHeaderName");
		
		//ceating header object
//		Header header=new Header("myHeaderName","value2");
//		Header matchheader=new Header("x-mock-match-request-headers","myHeaderName");
//		Headers headers=new Headers(header,matchheader);
		
		given().baseUri("https://dbf53945-1c25-4300-b22c-5019b2fd55a8.mock.pstmn.io")
//		.header(header).header(matchheader)
		//if we have multiple headers we can use headers()
		//.headers(headers)//passing headers object
		//multiple headers using Map
		.headers(headerss)
		.when().get("/get")
		.then().log()
		.all().assertThat().
		statusCode(200);
		
		
	}
	
	
	

}
