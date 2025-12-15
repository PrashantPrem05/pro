package shopperStack;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class shopperProfile {
	@SuppressWarnings("deprecation")
	String random = RandomStringUtils.randomAlphanumeric(4);
	String r_email = "prashantp"+random+"@gmail.com";
	@Test
	public void register()
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
		then().statusCode(201).extract().response();//log().all();
	}

	@Test
	public void login()
	{
		Response response1= 
		RestAssured.given().relaxedHTTPSValidation().body("{\r\n"
				+ "  \"email\": \"prashantp0011@gmail.com\",\r\n"
				+ "  \"password\": \"Api@1010\",\r\n"
				+ "  \"role\": \"SHOPPER\"\r\n"
				+ "}").contentType("application/json").when().post("https://www.shoppersstack.com/shopping/users/login").
				then().statusCode(200).extract().response();//.log().all();

	}
	
	@Test
	public void GetSHopperID()
	{
		RestAssured.given().relaxedHTTPSValidation().pathParam("shopperId", 292783).
		auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcmFzaGFudHAwMDExQGdtYWlsLmNvbSBTSE9QUEVSIiwiZXhwIjoxNzU2OTM5NTk0LCJpYXQiOjE3NTY5MDM1OTR9.1HxT6h77ih4yn1dayPiVKO3Hr6m3dqeVdkQl0Fd9eSI").
		when().get("https://www.shoppersstack.com/shopping/shoppers/{shopperId}").
				then().statusCode(200).log().all();
	}
	
	
	@Test
	public void Update()
	{
		
		RestAssured.given().relaxedHTTPSValidation().body("{\r\n"
				+ "  \"city\": \"Bengalore\",\r\n"
				+ "  \"country\": \"India\",\r\n"
				+ "  \"email\": \"prashantp0011@gmail.com\",\r\n"
				+ "  \"firstName\": \"prashant1\",\r\n"
				+ "  \"gender\": \"MALE\",\r\n"
				+ "  \"lastName\": \"prem\",\r\n"
				+ "  \"password\": \"Api@1010\",\r\n"
				+ "  \"phone\": 9999990101,\r\n"
				+ "  \"state\": \"Karnataka\",\r\n"
				+ "  \"zoneId\": \"ALPHA\"\r\n"
				+ "}").contentType("application/json").pathParam("shopperId", 292531).
		auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcmFzaGFudHAwMDExQGdtYWlsLmNvbSBTSE9QUEVSIiwiZXhwIjoxNzU2OTM5NTk0LCJpYXQiOjE3NTY5MDM1OTR9.1HxT6h77ih4yn1dayPiVKO3Hr6m3dqeVdkQl0Fd9eSI").
		when()
		.patch("https://www.shoppersstack.com/shopping/shoppers/{shopperId}").
		then().log().all();
}
}

