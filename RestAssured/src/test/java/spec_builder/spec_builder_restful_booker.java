package spec_builder;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class spec_builder_restful_booker {
	
	
	@BeforeMethod
	public RequestSpecification request(String body,String content) 
	{
		RequestSpecBuilder reqSpec = new RequestSpecBuilder();
		RequestSpecification req = reqSpec.setBody(body).setContentType(content).build();
		
		return req;
	}
	
	@AfterMethod
	public ResponseSpecification response(int code,String line,long time,String Key ,String value,String content,String Key1, String value2)
	{
		
		ResponseSpecBuilder resSpec = new ResponseSpecBuilder();
		
		ResponseSpecification res= resSpec.expectStatusCode(code).expectStatusLine(line).
		expectResponseTime(Matchers.lessThanOrEqualTo(time)).
		expectBody(Key,Matchers.equalTo(value)).
		expectContentType(content).
		expectHeader(Key1, Matchers.equalTo(value2)).
		build();
		
		return res;
		
	}
	

}
