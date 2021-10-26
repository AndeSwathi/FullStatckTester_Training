package restAssuredTraining;

import static org.junit.Assert.assertThat;
import io.restassured.RestAssured;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class Test3 {
	public static void main(String[] args) {
		
		Header hd = new Header("accept", "application/json");
		System.out.println("Test 1 started");

		Response res = RestAssured.given().header(hd).get("https://restful-booker.herokuapp.com/booking/1");

		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asString());
		
		
		String body = res.getBody().print();
		
		System.out.println("Test 1 ended");
		
	}
}
