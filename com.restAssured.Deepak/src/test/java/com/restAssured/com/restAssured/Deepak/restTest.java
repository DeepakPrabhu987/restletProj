package com.restAssured.com.restAssured.Deepak;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class restTest {
  @Test
  public void f() {
	  
	  
	System.out.println(given().get("http://services.groupkt.com/state/get/IND/all").asString());
	  
	  
  }
}
