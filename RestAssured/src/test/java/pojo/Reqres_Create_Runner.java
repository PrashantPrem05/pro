package pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class Reqres_Create_Runner 
{
	
	@Test
	public void Create() throws JsonProcessingException
	{
		//""
		
		Reqres_Create_Pojo rcp = new Reqres_Create_Pojo();
		rcp.setName("morpheus");
		rcp.setJob("leader");
		
		ObjectMapper obj = new ObjectMapper();
		String jsondata = obj.writeValueAsString(rcp);
		RestAssured.given().body(jsondata).
		contentType("application/json").header("x-api-key","reqres-free-v1")
		.when().post("https://reqres.in/api/users").then()
		.statusCode(201).log().all();
	}
}
