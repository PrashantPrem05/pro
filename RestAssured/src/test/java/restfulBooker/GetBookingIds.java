package restfulBooker;

import io.restassured.RestAssured;

public class GetBookingIds {
	
	public static void main(String[] args)
	{
		RestAssured.
		given().
		when().get("https://restful-booker.herokuapp.com/booking").then().log().all();
	}

	
}

