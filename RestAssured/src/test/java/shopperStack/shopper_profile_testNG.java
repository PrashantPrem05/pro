package shopperStack;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class shopper_profile_testNG {
	
	@Test
	public void register()
	{
		RestAssured.given().relaxedHTTPSValidation().body("{\r\n"
				+ "  \"city\": \"Bengalore\",\r\n"
				+ "  \"country\": \"India\",\r\n"
				+ "  \"email\": \"prashantp002@gmail.com\",\r\n"
				+ "  \"firstName\": \"prashant\",\r\n"
				+ "  \"gender\": \"MALE\",\r\n"
				+ "  \"lastName\": \"prem\",\r\n"
				+ "  \"password\": \"Api@1010\",\r\n"
				+ "  \"phone\": 9999990101,\r\n"
				+ "  \"state\": \"Karnataka\",\r\n"
				+ "  \"zoneId\": \"ALPHA\"\r\n"
				+ "}").contentType("application/json").when()
		.post("https://www.shoppersstack.com/shopping/shoppers").
		then().log().all();
	}

	
	@Test
	public void login()
	{
		RestAssured.given().relaxedHTTPSValidation().body("{\r\n"
				+ "  \"email\": \"prashantp001@gmail.com\",\r\n"
				+ "  \"password\": \"Api@1010\",\r\n"
				+ "  \"role\": \"SHOPPER\"\r\n"
				+ "}").contentType("application/json").when().post("https://www.shoppersstack.com/shopping/users/login").
				then().statusCode(200).log().all();

	}
	
	

	
	
}

	
	
