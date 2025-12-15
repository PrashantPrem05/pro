package shopperStack;

import io.restassured.RestAssured;

public class RegisterShopper {

	public static void main(String[] args) {
		
		RestAssured.given().relaxedHTTPSValidation().body("{\r\n"
				+ "  \"city\": \"Bengalore\",\r\n"
				+ "  \"country\": \"India\",\r\n"
				+ "  \"email\": \"prashantp002@gmail.com\",\r\n"
				+ "  \"firstName\": \"prashant\",\r\n"
				+ "  \"gender\": \"MALE\",\r\n"
				+ "  \"lastName\": \"prem\",\r\n"
				+ "  \"password\": \"Api@1010\",\r\n"
				+ "  \"phone\": 9999990101,\r\n"
				+ "  \"state\": \"Karnataka\",\r\n"
				+ "  \"zoneId\": \"ALPHA\"\r\n"
				+ "}").contentType("application/json").when()
		.post("https://www.shoppersstack.com/shopping/shoppers").
		then().log().all();
	}

}
