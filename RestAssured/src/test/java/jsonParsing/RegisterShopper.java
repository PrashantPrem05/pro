package jsonParsing;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class RegisterShopper {
	@Test
	public void CreateShopper()
	{
		
		String random = RandomStringUtils.randomAlphanumeric(4);
		String r_email= "prashant"+random+"@gmail.com";
		Response response =
		RestAssured.given().relaxedHTTPSValidation().body("{\r\n"
				+ "  \"city\": \"string\",\r\n"
				+ "  \"country\": \"string\",\r\n"
				+ "  \"email\": \""+r_email+"\",\r\n"
				+ "  \"firstName\": \"string\",\r\n"
				+ "  \"gender\": \"MALE\",\r\n"
				+ "  \"lastName\": \"string\",\r\n"
				+ "  \"password\": \"Api@10101\",\r\n"
				+ "  \"phone\": 9980767656,\r\n"
				+ "  \"state\": \"string\",\r\n"
				+ "  \"zoneId\": \"ALPHA\"\r\n"
				+ "}").contentType("application/json").
			when().post("https://www.shoppersstack.com/shopping/shoppers").
			then().extract().response();
		System.out.println(response.asPrettyString());
		JsonPath jp = new JsonPath(response.asPrettyString());
		String remail = jp.getString("data.email");
		System.out.println(remail);
		int shopperID = jp.getInt("data.shopperID");
		System.out.println(shopperID);
		
	}

}
