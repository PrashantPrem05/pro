package shopperStack;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RandomemailGenerator
{
	String email1;
	int ShopperID;
	String token;
	String random = RandomStringUtils.randomAlphanumeric(4);
	String r_email= "prashant"+random+"@gmail.com";

	
	@Test
	public void shop()
	{
		
		Response response=
		RestAssured.given().relaxedHTTPSValidation().body("{\r\n"
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
				+ "}").contentType("application/json").when()
		.post("https://www.shoppersstack.com/shopping/shoppers").
		then().statusCode(201).extract().response();
		
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
		Response res =
		RestAssured.given().relaxedHTTPSValidation().body("{\r\n"
				+ "  \"email\": \""+email1+"\",\r\n"
				+ "  \"password\": \"Api@1010\",\r\n"
				+ "  \"role\": \"SHOPPER\"\r\n"
				+ "}").contentType("application/json").when().post("https://www.shoppersstack.com/shopping/users/login").
				then().statusCode(200).extract().response();
		
		System.out.println("Successfully logged in");
		JsonPath jp = new JsonPath(res.asPrettyString());
		token  =jp.getString("data.jwtToken");
		System.out.println(res.asPrettyString());
	}
	
	@Test(priority =2)
	public void GetSHopperID()
	{
		Response res	=
		RestAssured.given().relaxedHTTPSValidation().pathParam("shopperId", ShopperID).
		auth().oauth2(token).
		when().get("https://www.shoppersstack.com/shopping/shoppers/{shopperId}").
				then().statusCode(200).extract().response();
		System.out.println(res.asPrettyString());
		
		System.out.println("Successfully fetched shopper detail");
	}
	
	
	
}
