package restAssuredTraining;

import java.io.File;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class BDDFormatRest {

	@Test
	public void main() {
		System.out.println("started");
		File jsonFile = new File(
				"D:\\AndeSwathi\\EclipseWorkplace\\CucumberTraining\\src\\test\\java\\restAssuredPojo\\Payload.json");
		RestAssured
		//GIVEN
			.given()
				.baseUri("https://restful-booker.herokuapp.com/auth")
				.contentType(ContentType.JSON)
				.body(jsonFile)
		//WHEN
			.when()
				.post()
		//THEN
			.then()
				.log()
					.ifValidationFails()
						.statusCode(200);



System.out.println("ended");

	}

}
