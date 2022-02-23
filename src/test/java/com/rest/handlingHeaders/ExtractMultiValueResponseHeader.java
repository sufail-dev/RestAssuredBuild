package com.rest.handlingHeaders;

import static io.restassured.RestAssured.given;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class ExtractMultiValueResponseHeader {
	@Test
public void extractMultivalueHeader() {
	Header header1=new Header("multivalueHeader","value1");
	Header header2=new Header("multivalueHeader","value2");
		Headers headers=new Headers(header1,header2);
		Headers extractedHeader=given().baseUri("https://dbf53945-1c25-4300-b22c-5019b2fd55a8.mock.pstmn.io")
		.headers(headers)
		.when().get("/get")
		.then().log()
		.all().assertThat().
		statusCode(200).extract().headers();
		
		List<String> values=extractedHeader.getValues("multiValueHeader");
		for(String value:values) {
			System.out.println(value);
		}
				
				
}}

