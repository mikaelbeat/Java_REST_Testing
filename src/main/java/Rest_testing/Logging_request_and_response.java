package Rest_testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.testng.annotations.Test;



public class Logging_request_and_response {
	
	@Test
	public void Logging() {
		
		RestAssured.baseURI = "https://reqres.in/";
		// String bearerToken = "abcdefg";
		String request_body = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"leader\"\r\n"
				+ "}";
		
		// given().param("key","12345").param("token", "ABCDEFG").
			// header.("Authorization, "Bearer" + bearerToken). 
		
		Response response = given().log().all().
				body(request_body).
			when().
				post("/api/users").
			then().log().all().
				assertThat().statusCode(201).and().
				contentType(ContentType.JSON).
			extract().response();
		
		System.out.println("Get test successful!");
		System.out.println(response.asString());
		System.out.println("\n*****************************\n");
		
		String json_response = response.asString();
		JsonPath responseBody = new JsonPath(json_response);
		System.out.println("id -> " + responseBody.get("id"));
		System.out.println("timestamp -> " + responseBody.get("createdAt"));
	}


}
