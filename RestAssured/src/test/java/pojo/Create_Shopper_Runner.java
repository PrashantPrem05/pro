package pojo;

import org.apache.commons.lang3.RandomStringUtils;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

public class Create_Shopper_Runner {
	
	@Test
	public void Create_Shopper() throws JsonProcessingException
	{
		String random = RandomStringUtils.randomAlphanumeric(4);
		String email = "prashant"+random+"@gmail.com";
		System.out.println(email);
		Create_Shopper_pojo rcp = new Create_Shopper_pojo();
		rcp.setCity("Bengalore");
		rcp.setCountry("India");
		rcp.setEmail(""+email+"");
		rcp.setFirstName("prashant");
		rcp.setGender("MALE");
		rcp.setLastName("prem");
		rcp.setPassword("Api@1010");
		rcp.setPhone(9987865432L);
		rcp.setState("Karnataka");
		rcp.setZoneId("ALPHA");
		
		ObjectMapper obj = new ObjectMapper();
		String jsonData = obj.writerWithDefaultPrettyPrinter().writeValueAsString(rcp);
		
		System.out.println(jsonData);
		RestAssured.
		given().relaxedHTTPSValidation().body(jsonData).contentType("application/json").
		when()
		.post("https://www.shoppersstack.com/shopping/shoppers").
		then().statusCode(201).log().all();
		
		
		
		
	}

}
