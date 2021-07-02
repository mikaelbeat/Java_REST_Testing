package Rest_testing;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;

import org.testng.annotations.Test;



public class Verify_response {
	
	@Test
	public void Verify_response_header() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		//given().param("key","12345").param("token", "ABCDEFG").
		when().
			get("/api/users?page=2").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().
			header("Server", "cloudflare").
			header("Content-Type", "application/json; charset=utf-8");
		
		System.out.println("Get test successful!");
	}
	
	
	@Test
	public void Verify_response_body() {
		
		RestAssured.baseURI = "https://reqres.in/";
		
		//given().param("key","12345").param("token", "ABCDEFG").
		when().
			get("/api/users?page=2").
		then().
			assertThat().statusCode(200).and().
			contentType(ContentType.JSON).and().
			body("data[0].id", equalTo(7)).
			body("data[0].email", equalTo("michael.lawson@reqres.in"));
		
		System.out.println("Get test successful!");
	}


}
