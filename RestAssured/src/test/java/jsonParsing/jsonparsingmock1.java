package jsonParsing;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class jsonparsingmock1 {
	@Test
	public void Register()
	{
		
		String random = RandomStringUtils.randomAlphanumeric(4);
		String r_email= "prashant"+random+"@gmail.com";
		
		Response res =
		RestAssured.given().relaxedHTTPSValidation().body("{\r\n"
				+ "  \"city\": \"Bengaluru\",\r\n"
				+ "  \"country\": \"India\",\r\n"
				+ "  \"email\": \""+r_email+"\",\r\n"
				+ "  \"firstName\": \"Prashant\",\r\n"
				+ "  \"gender\": \"MALE\",\r\n"
				+ "  \"lastName\": \"Prem\",\r\n"
				+ "  \"password\": \"Api@10101\",\r\n"
				+ "  \"phone\": 9999901234,\r\n"
				+ "  \"state\": \"Karnataka\",\r\n"
				+ "  \"zoneId\": \"ALPHA\"\r\n"
				+ "}").contentType("application/json").
			when().post("https://www.shoppersstack.com/shopping/shoppers").
			then().statusCode(201).extract().response();
		
		
		
		
		System.out.println(res.asPrettyString());
		//json parsing
		JsonPath jp = new JsonPath(res.asPrettyString());
		String remail = jp.getString("data.email");
		
		System.out.println(remail);
		int shopperID = jp.getInt("data.userId");
		System.out.println(shopperID);
		
	}

}
