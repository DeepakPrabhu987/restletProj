package com.restAssured.com.restAssured.Deepak;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import bin.BaseClass;
import bin.RestResponse;
import bin.Result;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class restTest extends cf {
	
/**
 * @Author: Deepak Prabhu
 * @Date: 05/09/2017
 */

RestAssuredConfiguration restSpec = new RestAssuredConfiguration();


@BeforeTest
public void before(){

}



  @Test
  public void restAssuredTest() {

Response  response = restSpec.getResponseType().queryParam("text", "Pradesh").get(Endpoint.QUERY_PARAM);

System.out.println(response.asString());

BaseClass b = response.as(BaseClass.class, ObjectMapperType.GSON);

List<Result> items = b.getRestResponse().getResult();

for(Result item: items)
{
	if(item.getName().equalsIgnoreCase("Andhra Pradesh")){

		updateTestLog(item.getCapital().toString(), "Hyderabad, India","PASS");
		
	}else {
		System.out.println("this is my change that needs to staged for commit");
	}
	
	
}	

  }
}
