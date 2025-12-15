package spec_builder;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Reqres_Spec_Runner {
	
	@Test
	public void Create()
	{
		
		Reqres_spec_builder s = new Reqres_spec_builder();
		RequestSpecification req = s.request("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}", "application/json");
		
		 ResponseSpecification	res=s.response(201, "HTTP/1.1 201 Created", 3000L);
		
		RestAssured.given().header("x-api-key","reqres-free-v1").spec(req)
		.when().post("https://reqres.in/api/users").then().spec(res).log().all();
		
	}
	
}
