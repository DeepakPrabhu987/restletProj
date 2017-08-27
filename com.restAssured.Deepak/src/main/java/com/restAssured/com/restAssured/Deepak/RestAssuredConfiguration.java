package com.restAssured.com.restAssured.Deepak;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredConfiguration {
	


  @BeforeSuite
  public void getRestAssuredSpecifications() {
	    
	  RestAssured.baseURI="http://services.groupkt.com";
	  RestAssured.basePath="/state";
	  
  }  
	  
 
	public RequestSpecification getResponseType(){
		
	 
		return RestAssured.given().contentType(ContentType.JSON);
		
	}
	  
	  
  }


