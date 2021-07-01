package basic.rest.get;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;
import org.testng.annotations.Test;


public class Post {
	
	public class Verify_response {
		
		@Test
		public void Post() {
			
			RestAssured.baseURI = "https://reqres.in/";
			// String bearerToken = "abcdefg";
			String data = "{\r\n"
					+ "    \"name\": \"morpheus\",\r\n"
					+ "    \"job\": \"leader\"\r\n"
					+ "}";
			
			// given().param("key","12345").param("token", "ABCDEFG").
				// header.("Authorization, "Bearer" + bearerToken). 
			given().
				body(data).
			when().
				post("/api/users").
			then().
				assertThat().statusCode(201).and().
				contentType(ContentType.JSON).and().
				body("id", equalTo(12345));
			
			System.out.println("Get test successful!");
		}


	}

}
