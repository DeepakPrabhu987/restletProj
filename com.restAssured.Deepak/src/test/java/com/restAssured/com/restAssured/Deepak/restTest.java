package com.restAssured.com.restAssured.Deepak;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bin.BaseClass;
import bin.RestResponse;
import bin.Result;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class restTest {
	
	

RestAssuredConfiguration restSpec = new RestAssuredConfiguration();


  @Test
  public void restAssuredTest() {

Response  r = restSpec.getResponseType().queryParam("text", "pradesh").get(Endpoint.QUERY_PARAM);
BaseClass b = r.as(BaseClass.class, ObjectMapperType.GSON);
SoftAssert softAssert = new SoftAssert();

List<Result> items = b.getRestResponse().getResult();

for(Result item: items)
{
	
	softAssert.assertTrue(item.getCapital().equalsIgnoreCase("Bhopal"), "I got passed");
	
	
	
	
	
}

	
	
	

  }
}
