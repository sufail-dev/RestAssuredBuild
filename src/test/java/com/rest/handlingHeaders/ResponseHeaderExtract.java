package com.rest.handlingHeaders;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class ResponseHeaderExtract {
	@Test
	public void responseHeaderExtract() {
		Header header1=new Header("multivalueHeader","value1");
		Header header2=new Header("multivalueHeader","value2");
			Headers headers=new Headers(header1,header2);
		Headers outputHeaders=	given().baseUri("https://dbf53945-1c25-4300-b22c-5019b2fd55a8.mock.pstmn.io")
			.headers(headers)
			.when().get("/get")
			.then().log()
			.all().assertThat().
			statusCode(200).extract().headers();
		
		
		for(Header header:outputHeaders) {
			System.out.println("HeaderName : "+header.getName());
			System.out.println("HeaderName : "+header.getValue());
		}
//		System.out.println(outputHeaders.get("responseHeader").getName()); // getting the value
//		System.out.println(outputHeaders.get("responseHeader").getValue());
//		System.out.println(outputHeaders.getValue("responseHeader"));
	}

}
