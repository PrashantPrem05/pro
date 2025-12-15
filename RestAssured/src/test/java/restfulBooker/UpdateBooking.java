package restfulBooker;

import io.restassured.RestAssured;

public class UpdateBooking {

	public static void main(String[] args) {

		RestAssured.given().pathParam("id", 1014
				).body("{\r\n"
				+ "    \"firstname\" : \"Prashant\",\r\n"
				+ "    \"lastname\" : \"Brown\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}").contentType("application/json").auth().preemptive().
		basic("admin","password123")
		.when()
		.put("https://restful-booker.herokuapp.com/booking/{id}").
		then().log().all();
		
	}

}
