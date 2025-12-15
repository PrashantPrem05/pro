package restfulBooker;

import static org.testng.Assert.assertEquals;

import org.hamcrest.Matchers;
import org.junit.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateBooking {

	@Test
	public static void Create() {
		
		Response response=
		RestAssured.
		given().body("{\r\n"
				+ "    \"firstname\" : \"Prashant\",\r\n"
				+ "    \"lastname\" : \"Prem\",\r\n"
				+ "    \"totalprice\" : 111,\r\n"
				+ "    \"depositpaid\" : true,\r\n"
				+ "    \"bookingdates\" : {\r\n"
				+ "        \"checkin\" : \"2018-01-01\",\r\n"
				+ "        \"checkout\" : \"2019-01-01\"\r\n"
				+ "    },\r\n"
				+ "    \"additionalneeds\" : \"Breakfast\"\r\n"
				+ "}").contentType("application/json").when().
		post("https://restful-booker.herokuapp.com/booking").
		then().statusCode(200).
		and().statusLine("HTTP/1.1 200 OK").
		and().time(Matchers.lessThanOrEqualTo(10000L)).
		and().contentType("application/json").
		and().body("booking.firstname", Matchers.equalTo("Prashant")).
		and().header("Server", Matchers.equalTo("Heroku")).extract().response();
		
		System.out.println(response.asPrettyString());
		//log().all();
		
		//this assertion is from testNg
		//Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
