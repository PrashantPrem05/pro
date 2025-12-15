package restfulBooker;

import io.restassured.RestAssured;

public class GetBooking {

	public static void main(String[] args) {

		RestAssured.given().pathParam("id", 1260).when().
		get("https://restful-booker.herokuapp.com/booking/{id}").then().
		log().all();
	}

}
