package jsonParsing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class Createreqres 
{
	@Test
	public void Create()
	{
		Response response =
		RestAssured.given().body("{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}").contentType("application/json").header("x-api-key","reqres-free-v1").
			when().post("https://reqres.in/api/users").then().statusCode(201).extract().response();
		System.out.println(response.asPrettyString());
		System.out.println(response.statusCode());
		System.out.println(response.statusLine());
		
		JsonPath jp = new JsonPath(response.asPrettyString());
		String keyName = jp.getString("name");
		System.out.println(keyName);
		String keyJob = jp.getString("job");
		System.out.println(keyJob);
		Object keyId = jp.get("id");
		System.out.println(keyId);
	}
}
