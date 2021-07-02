package Rest_testing;


import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.CoreMatchers.*;



public class Get {
	
	// BaseURI
	public static String baseURI = "https://reqres.in/";
	
	
	public static void main(String[] args) {
		RestAssured.baseURI = baseURI;
		
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
