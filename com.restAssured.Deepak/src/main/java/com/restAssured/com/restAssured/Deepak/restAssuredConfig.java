package com.restAssured.com.restAssured.Deepak;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class restAssuredConfig {

  @BeforeSuite
  public RequestSpecification getRestAssuredSpecifications() {
	  
	  
	
	  RestAssured.baseURI="http://services.groupkt.com";
	  RestAssured.basePath="/state";
	
	  
	  
	  
	return null;
	  
	  
  }

}
