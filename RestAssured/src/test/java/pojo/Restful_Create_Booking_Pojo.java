package pojo;

public class Restful_Create_Booking_Pojo {
	private String firstname;
	private String lastname;
	private int totalprice;
	private boolean depositpaid;
	private Restful_Create_Bookingdates_Pojo bookingdates;
	private String additionalneeds;
	
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public int getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(int totalprice) {
		this.totalprice = totalprice;
	}
	public boolean isDepositpaid() {
		return depositpaid;
	}
	public void setDepositpaid(boolean depositpaid) {
		this.depositpaid = depositpaid;
	}
	public Restful_Create_Bookingdates_Pojo getBookingdates() {
		return bookingdates;
	}
	public void setBookingdates(Restful_Create_Bookingdates_Pojo bookingdates) {
		this.bookingdates = bookingdates;
	}
	public String getAdditionalneeds() {
		return additionalneeds;
	}
	public void setAdditionalneeds(String additionalneeds) {
		this.additionalneeds = additionalneeds;
	}
		
	}


