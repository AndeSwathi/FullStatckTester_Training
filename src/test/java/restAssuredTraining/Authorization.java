package restAssuredTraining;

import bsh.Token;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import restAssuredPojo.Authentication;
import restAssuredPojo.TokenClass;

public class Authorization {

	public static void main(String[] args) {
		System.out.println("started");
		Authentication authReq = new Authentication();
		authReq.setUsername("admin");
		authReq.setPassword("password123");
		
		Header acceptHeader = new Header("Content-Type", "application/json");
		Response response = RestAssured.given().header(acceptHeader).body(authReq)
				.post("https://restful-booker.herokuapp.com/auth");
		response.body().prettyPrint();
		
		TokenClass TokenResponse = response.as(TokenClass.class);
		System.out.println(TokenResponse.getToken());
		
		System.out.println("ended");
	}

}
