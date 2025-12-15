package pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class Restful_Create_Runner {

	@Test
	public void CreateBooking() throws JsonProcessingException
	{
		
	Restful_Create_Booking_Pojo rcp = new Restful_Create_Booking_Pojo();
	rcp.setFirstname("James");
	rcp.setLastname("Brown");
	rcp.setTotalprice(111);
	rcp.setDepositpaid(true);
	
	Restful_Create_Bookingdates_Pojo rcpbook = new Restful_Create_Bookingdates_Pojo();
	rcpbook.setCheckin("2018-01-01");
	rcpbook.setCheckout("2019-01-01");

	rcp.setBookingdates(rcpbook);
	
	rcp.setAdditionalneeds("Breakfast");
	
	ObjectMapper obj = new ObjectMapper();
	String jsonData = obj.writerWithDefaultPrettyPrinter().writeValueAsString(rcp);
	
	System.out.println(jsonData);
	RestAssured.given().body(jsonData).contentType("application/json")
			.when().post("https://restful-booker.herokuapp.com/booking").then().statusCode(200).log().all();
	
	
	
	}
		
}
