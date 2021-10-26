package restAssuredTraining;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import restAssuredPojo.RestAuthPostManPOJO;
import restAssuredPojo.TokenClass;

public class RestAuthPostMan {

	@Test
	public void main() throws JsonParseException, JsonMappingException, IOException {
		System.out.println("started");
		String sRemove="<b>Warning</b>: mysqli::mysqli(): Headers and client library minor version mismatch. Headers:100508 Library:100236 in <b>/home/u942925711/domains/upskills.in/public_html/rest-api/system/library/db/mysqli.php</b> on line <b>7</b>";
		Header acceptHeader=new Header("accept", "application/json");
		
		File jsonFile = new File(
				"D:\\AndeSwathi\\EclipseWorkplace\\CucumberTraining\\src\\test\\java\\restAssuredPojo\\Payload.json");
		
		Response response =RestAssured
			.given()
				.baseUri("http://rest-api.upskills.in/api/rest_admin/oauth2/token/client_credentials")
				.accept(ContentType.JSON)
				.header("Authorization","Basic dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9jbGllbnQ6dXBza2lsbHNfcmVzdF9hZG1pbl9vYXV0aF9zZWNyZXQ=")
				//WHEN
					.when()
						.post();
		String sBody=response.body().asString();
		sBody=sBody.replace(sRemove, "");
		System.out.println(sBody);
		
		ObjectMapper obj = new ObjectMapper();
		
		RestAuthPostManPOJO token = obj.readValue(sBody, RestAuthPostManPOJO.class);
		String accssToken = token.getData().getAccess_token();
		System.out.println(accssToken);
		System.out.println("ended");
	}
}
