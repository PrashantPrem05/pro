package shopperStack;

import io.restassured.RestAssured;

public class UpdateShopper {

	public static void main(String[] args) {
		RestAssured.given().relaxedHTTPSValidation().body("{\r\n"
				+ "  \"city\": \"Bengalore\",\r\n"
				+ "  \"country\": \"India\",\r\n"
				+ "  \"email\": \"prashantp001@gmail.com\",\r\n"
				+ "  \"firstName\": \"prashant1\",\r\n"
				+ "  \"gender\": \"MALE\",\r\n"
				+ "  \"lastName\": \"prem\",\r\n"
				+ "  \"password\": \"Api@1010\",\r\n"
				+ "  \"phone\": 9999990101,\r\n"
				+ "  \"state\": \"Karnataka\",\r\n"
				+ "  \"zoneId\": \"ALPHA\"\r\n"
				+ "}").contentType("application/json").pathParam("shopperId", 292531).
		auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJwcmFzaGFudHAwMDFAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3NTY4NjQ3MjQsIm"
				+ "lhdCI6MTc1NjgyODcyNH0.jh8gsbOrHVJwa-APpZ7md9t1XUFxgba6oYUX-fTEM98").
		when()
		.patch("https://www.shoppersstack.com/shopping/shoppers/{shopperId}").
		then().log().all();

	}

}
