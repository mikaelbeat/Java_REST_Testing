package basic.rest.get;


import io.restassured.RestAssured;
import io.restassured.RestAssured.*;
import static io.restassured.RestAssured.*;



public class Get {
	
	// BaseURI
	public static String baseURI = "https://reqres.in/";
	
	
	public static void main(String[] args) {
		RestAssured.baseURI = baseURI;
		
		//given().param("key","12345").param("token", "ABCDEFG").
		when().
			get("/api/users?page=2").
		then().
			assertThat().statusCode(200);
		
		System.out.println("Get test successful!");
	}

}
