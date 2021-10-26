package restAssuredTraining;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class DeserializationTest5 {
	public static void main(String[] args) {

		System.out.println("Test 1 started");

		Header hd = new Header("accept", "application/json");

		Response res = RestAssured.given().header(hd).get("https://restful-booker.herokuapp.com/booking/1");

		res.body().prettyPrint();
		BookingResponse bookingResponse = res.as(BookingResponse.class);
		System.out.println("First NAME=" + bookingResponse.getFirstname());
		System.out.println("Last NAME=" + bookingResponse.getLastname());
		System.out.println("Total Price=" + bookingResponse.getTotalprice());
		System.out.println("Deposit Paid=" + bookingResponse.isDepositpaid());
		System.out.println("Check In=" + bookingResponse.getBookingdates().getCheckin());
		System.out.println("CHeck Out=" + bookingResponse.getBookingdates().getCheckout());

		System.out.println("ended");

	}
}
