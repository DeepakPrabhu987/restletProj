package com.restAssured.com.restAssured.Deepak;

import org.apache.http.client.config.RequestConfig;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.config.RestAssuredConfig;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class restTest {
	
public	String country;
	

  @Test
  public void restAssuredTest() {

	System.out.println(given().queryParam("text", "").get(Endpoint.QUERY_PARAM).asString());

	  
  }
}
