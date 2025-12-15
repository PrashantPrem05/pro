package jsonParsing;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class ListUsersReqres {
	@Test
	public void ListUsers()
	{
		Response response =
		RestAssured.given().header("x-api-key","reqres-free-v1").
			when().get("https://reqres.in/api/users?page=2").then().statusCode(200).extract().response();
		
		JsonPath jp = new JsonPath(response.asPrettyString());
		System.out.println(response.asPrettyString());
		String fname= jp.getString("data[1].first_name");
		System.out.println(fname);
		String lname = jp.get("data[3].last_name");
		System.out.println(lname);
		int id = jp.getInt("data[4].id");
		System.out.println(id);
	}

}
