package spec_builder;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Shopper_Spec_Runner 
{
	
	String email1;
	int ShopperID;
	String token;
	String random = RandomStringUtils.randomAlphanumeric(4);
	String r_email= "prashant"+random+"@gmail.com";

	
	@Test
	public void shop()
	{
		Shopper_Spec_Builder s = new Shopper_Spec_Builder();
		RequestSpecification req= s.request("{\r\n"
				+ "  \"city\": \"Bengalore\",\r\n"
				+ "  \"country\": \"India\",\r\n"
				+ "  \"email\": \""+r_email+"\",\r\n"
				+ "  \"firstName\": \"prashant\",\r\n"
				+ "  \"gender\": \"MALE\",\r\n"
				+ "  \"lastName\": \"prem\",\r\n"
				+ "  \"password\": \"Api@1010\",\r\n"
				+ "  \"phone\": 9999990101,\r\n"
				+ "  \"state\": \"Karnataka\",\r\n"
				+ "  \"zoneId\": \"ALPHA\"\r\n"
				+ "}", "application/json");
		
		ResponseSpecification	res =s.response(201, "HTTP/1.1 201 ", 10000L);
		
		Response response=
		RestAssured.given().relaxedHTTPSValidation().spec(req).when()
		.post("https://www.shoppersstack.com/shopping/shoppers").
		then().spec(res).extract().response();
		JsonPath jp = new JsonPath(response.asPrettyString());
		email1 = jp.getString("data.email");
		ShopperID = jp.getInt("data.userId");
		System.out.println(response.asPrettyString());
		System.out.println("Successfully Created");
		System.out.println(email1);
	}
	
	@Test(dependsOnMethods = "shop")
	public void login()
	{
		
		Shopper_Spec_Builder s = new Shopper_Spec_Builder();
		RequestSpecification requestspec= s.request("{\r\n"
				+ "  \"email\": \""+email1+"\",\r\n"
				+ "  \"password\": \"Api@1010\",\r\n"
				+ "  \"role\": \"SHOPPER\"\r\n"
				+ "}", "application/json");
		
		ResponseSpecification	responsespec =s.response(200, "HTTP/1.1 200 ", 10000L);
		
		Response res =
		RestAssured.given().relaxedHTTPSValidation().spec(requestspec).when().
		post("https://www.shoppersstack.com/shopping/users/login").
				then().spec(responsespec).extract().response();
		
		System.out.println("Successfully logged in");
		JsonPath jp = new JsonPath(res.asPrettyString());
		token  =jp.getString("data.jwtToken");
		System.out.println(res.asPrettyString());
	}
	
}
