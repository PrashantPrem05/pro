package shopperStack;

import io.restassured.RestAssured;

public class ShopperDataID {

	public static void main(String[] args) {
		RestAssured.given().relaxedHTTPSValidation().pathParam("shopperId", 292531).
		auth().oauth2("eyJhbGciOiJIUzI1NiJ9.eyJz"
				+ "dWIiOiJwcmFzaGFudHAwMDFAZ21haWwuY29tIFNIT1BQRVIiLCJleHAiOjE3NTY4NjQ3M"
				+ "jQsImlhdCI6MTc1NjgyODcyNH0.jh8gsbOrHVJwa-APpZ7md9t1XUFxgba6oYUX-fTEM98").
		when().get("https://www.shoppersstack.com/shopping/shoppers/{shopperId}").
				then().statusCode(200).log().all();
	}

}
