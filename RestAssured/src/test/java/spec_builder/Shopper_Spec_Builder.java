package spec_builder;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Shopper_Spec_Builder 
{
	@BeforeMethod
	public RequestSpecification request(String body,String content) 
	{
		RequestSpecBuilder reqSpec = new RequestSpecBuilder();
		RequestSpecification req = reqSpec.setBody(body).setContentType(content).build();
		
		return req;
	}
	
	@AfterMethod
	public ResponseSpecification response(int code,String line,long time)
	{
		
		ResponseSpecBuilder resSpec = new ResponseSpecBuilder();
		
		ResponseSpecification res= resSpec.expectStatusCode(code).expectStatusLine(line).
		expectResponseTime(Matchers.lessThanOrEqualTo(time)).build();
		
		return res;
		
	}
	

}
