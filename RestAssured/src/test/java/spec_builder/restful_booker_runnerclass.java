package spec_builder;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class restful_booker_runnerclass

{

	@Test
	public void create()
	{
		
		spec_builder_restful_booker s = new spec_builder_restful_booker();
		RequestSpecification	req=s.request("{\r\n"
				+ "    \"firstname\" : \"Jim\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}", "application/json");
		
		ResponseSpecification	res = s.response(200, "HTTP/1.1 200 OK", 10000L, "booking.firstname", 
				"Jim","application/json","Server" ,"Heroku");
		
		RestAssured.given().spec(req).when().post("https://restful-booker.herokuapp.com/booking\r\n"
				+ "").then().spec(res).log().all();
		
		
	}
	
	
	
}
