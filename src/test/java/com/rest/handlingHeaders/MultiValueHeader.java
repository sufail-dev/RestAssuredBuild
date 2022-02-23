package com.rest.handlingHeaders;

import static io.restassured.RestAssured.given;

import java.util.HashMap;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;

public class MultiValueHeader {
	
	@Test
	public void multiValuedHeaderImpliments() {
		Header header1=new Header("multivalueHeader","value1");
	Header header2=new Header("multivalueHeader","value2");
		Headers headers=new Headers(header1,header2);
//		HashMap<String,String> headerss=new HashMap<String,String>();
//		headerss.put("myHeaderName","value2");
//		headerss.put("x-mock-match-request-headers","myHeaderName");
		given().baseUri("https://dbf53945-1c25-4300-b22c-5019b2fd55a8.mock.pstmn.io")
//		
//		.header("multiValueHead","value1","value2").log().headers()
		.headers(headers)
		.when().get("/get")
		.then().log()
		.all().assertThat().
		//for response we can validate header
		statusCode(200).headers("responseHeader", "resheaderValu1",
				"X-RateLimit-Remaining","118"
				
				
				);
	}

}
