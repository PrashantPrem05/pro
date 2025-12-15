package shopperStack;

import io.restassured.RestAssured;

public class ShopperLogin {

	public static void main(String[] args) {
		RestAssured.given().relaxedHTTPSValidation().body("{\r\n"
				+ "  \"email\": \"prashantp001@gmail.com\",\r\n"
				+ "  \"password\": \"Api@1010\",\r\n"
				+ "  \"role\": \"SHOPPER\"\r\n"
				+ "}").contentType("application/json").when().post("https://www.shoppersstack.com/shopping/users/login").
				then().statusCode(200).log().all();

	}

}
