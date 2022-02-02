package Rest_testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;


public class Post {
	
	public class Verify_response {
		
		@Test
		public void Post() {
			
			RestAssured.baseURI = "https://reqres.in/";
			// String bearerToken = "abcdefg";
			String request_body = "{\r\n"
					+ "    \"email\": \"sydney@fife\",\r\n"
					+ "}";
			
			// given().param("key","12345").param("token", "ABCDEFG").
				// header.("Authorization, "Bearer" + bearerToken). 
			Response response = given().
					body(request_body).
				when().
					post("/api/register").
				then().
					assertThat().statusCode(400).and().
					contentType(ContentType.JSON).and().
				extract().response();
			
			String jsonResponse = response.asString();
			System.out.println("Response as it is --> " + jsonResponse);
			JsonPath responseBody = new JsonPath(jsonResponse);
			String responseErrorMessage = responseBody.get("error");
			Assert.assertEquals(responseErrorMessage, "Missing email or username");
			
		}


	}

}
