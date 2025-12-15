package spec_builder;

import org.hamcrest.Matchers;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Reqres_spec_builder {
	
	@BeforeMethod
	public RequestSpecification request(String body,String content)
	{
		RequestSpecBuilder rs = new RequestSpecBuilder();
		
			RequestSpecification req = rs.setBody(body).setContentType(content).build();
			return req;
	}
	
	

	@AfterMethod
	public ResponseSpecification response(int code,String line,long time)
	{
		ResponseSpecBuilder rs = new ResponseSpecBuilder();
			ResponseSpecification	res=rs.expectStatusCode(code).expectStatusLine(line).
		expectResponseTime(Matchers.lessThanOrEqualTo(time)).build();
			return res;
		
		
	}

}
