package restfulBooker;

import io.restassured.RestAssured;

public class DeleteBooking {

	public static void main(String[] args) {
		RestAssured.given().auth().preemptive().basic("admin", "password123").
		when().delete("https://restful-booker.herokuapp.com/booking/1260").then().log().all();

}
}

