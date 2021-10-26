package restAssuredTraining;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class JsonXmlTest {
	
	public static void main(String[] args) {
		System.out.println("started");
		File xmlFile = new File(
				"D:\\AndeSwathi\\EclipseWorkplace\\CucumberTraining\\src\\test\\java\\restAssuredPojo\\Payload.json");

		Response response = RestAssured.given().contentType(ContentType.JSON).body(xmlFile)
				.post("https://restful-booker.herokuapp.com/auth");
		response.body().prettyPrint();

		
		System.out.println("ended");
	}


}
