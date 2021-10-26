package restAssuredTraining;

import static org.junit.Assert.assertThat;
import io.restassured.RestAssured;
import static org.hamcrest.core.IsInstanceOf.instanceOf;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.response.Response;

public class Test1 {
	public static void main(String[] args) {
		System.out.println("Test 1 started");

		Response res = RestAssured.given().get("https://restful-booker.herokuapp.com/ping");

		System.out.println(res.getStatusCode());
		System.out.println(res.getBody().asString());
		System.out.println("Test 1 ended");
	}
}
