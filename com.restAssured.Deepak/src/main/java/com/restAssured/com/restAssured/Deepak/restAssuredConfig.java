package com.restAssured.com.restAssured.Deepak;

import org.testng.annotations.BeforeSuite;

import io.restassured.RestAssured;

public class restAssuredConfig {

  @BeforeSuite
  public void beforeSuite() {
	  
	  
	
	  RestAssured.baseURI="http://services.groupkt.com/state/get/IND/all";
	  
	  
	  
  }

}
