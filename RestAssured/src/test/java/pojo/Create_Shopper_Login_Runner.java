package pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class Create_Shopper_Login_Runner 

{
		@Test
		public void Create_Shopper_Login() throws JsonProcessingException
		{
			
		Create_Shopper_Login_pojo rcp = new Create_Shopper_Login_pojo();
		rcp.setEmail("prashantps11@gmail.com");
		rcp.setPassword("Api@1010");
		rcp.setRole("SHOPPER");
		
		ObjectMapper obj = new ObjectMapper();
		String jsondata = obj.writerWithDefaultPrettyPrinter().writeValueAsString(rcp);
		
		RestAssured.given().relaxedHTTPSValidation().body(jsondata).contentType("application/json")
		.when().post("https://www.shoppersstack.com/shopping/users/login").
				then().statusCode(200).log().all();
		
		
		
		}
		
}
