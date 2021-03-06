package Rest_testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.testng.annotations.Test;

public class Extract_response {

	@Test
	public void Get_response_json() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		String requestFileLocation = "src\\main\\java\\Rest_testing\\Post1.json";
		String requestFileAsJson = null;
		try {
			requestFileAsJson = readFileAsString(requestFileLocation);
		} catch (Exception e) {
			System.out.println("ERROR: Cannot read the request file.");
		}
		
		
//		given().param("key","12345").param("token", "ABCDEFG").
//			 header.("Authorization, "Bearer" + bearerToken). 
		
		Response response = given().
				body(requestFileAsJson).
			when().
				post("/api/users").
			then().
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

	public static String readFileAsString(String file) throws Exception {
		return new String(Files.readAllBytes(Paths.get(file)));
	}

}
