package pojo;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;

public class Merchant_runner_pojo {
	
	@Test
	public void create() throws JsonProcessingException
	{
	Merchant_adress_pojo objadd = new Merchant_adress_pojo();
	objadd.setAddressId(123);
	objadd.setBuildingInfo("Qspider");
	objadd.setCity("Banglore");
	objadd.setCountry("India");
	objadd.setLandmark("Rajajinagar");
	objadd.setName("PrashantMerchant");
	objadd.setPhone("9522337787");
	objadd.setPincode("560022");	
	objadd.setState("Karanataka");
	objadd.setStreetInfo("Rajajinagar");
	objadd.setType("HOME");
	
	Merchant_company_pojo mrc = new Merchant_company_pojo();
	mrc.setAddress(objadd);
	mrc.setCompanyId(1231);
	mrc.setEmail("prashant1@gmail.com");
	mrc.setGstn("ABC123");
	mrc.setName("alpha");
	mrc.setPhone("9522337789");
	mrc.setRegisterNumber("ABD123");
	mrc.setWebAddress("www.alpha.com");
	
	Merchant_main_pojo main = new Merchant_main_pojo();
	main.setCity("Banglore");
	main.setCommission(25);
	main.setCompany(mrc);
	main.setCountry("INDIA");
	main.setCreatedDateTime("2025-09-13T11:23:04.523Z");
	main.setDob("1994-10-11");
	main.setEmail("prashant1@gmail.com");
	main.setFirstName("PRASHANT");
	main.setGender("MALE");
	main.setImageId("");
	main.setJwtToken("");
	main.setLastName("prem");
	main.setPassword("Api@1010");
	main.setPhone("9522337789");
	main.setProductAdded(7);
	main.setProductLimit(10);
	main.setRole("MERCHANT");
	main.setState("");
	main.setStatus("ACTIVE");
	main.setToken(null);
	main.setZoneId("ALPHA");
	
	ObjectMapper obj = new ObjectMapper();
	String jsonData = obj.writerWithDefaultPrettyPrinter().writeValueAsString(main);
	
	System.out.println(jsonData);
	RestAssured.
	given().relaxedHTTPSValidation().body(jsonData).contentType("application/json").
	when()
	.post("https://www.shoppersstack.com/shopping/merchants").
	then().statusCode(201).log().all();
	
	
	
	
	}
}
