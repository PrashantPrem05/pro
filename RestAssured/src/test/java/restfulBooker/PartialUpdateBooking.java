package restfulBooker;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PartialUpdateBooking {

	public static void main(String[] args) {

		RestAssured.given().pathParam("id", 1952).
		body("{\r\n"
				+ "    \"firstname\" : \"Jame\",\r\n"
				+ "    \"lastname\" : \"Brown\"\r\n"
				+ "}").contentType("application/json").
		auth().preemptive().
		basic("admin","password123")
		.when()
		.patch("https://restful-booker.herokuapp.com/booking/{id}").
		then().
		log().all();;
	}

}
