package starWarsAPI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
public class Tests_GET {

	@Test
	public void test_1 () {
		
		given().
		   get("https://swapi.dev/api/films/").
		then().
		   statusCode(200).
		   body("results.title[0]",equalTo("A New Hope")).			      
	       log().all();	
		
	}
	
	@Test
	public void test_2() {
		Response response = RestAssured.get("https://swapi.dev/api/people/1");

		int code = 200;
		int statusCode = response.getStatusCode();
		Assert.assertEquals(code, statusCode);
		System.out.println("statusCode � " + statusCode);

	}
	
	@Test
	public void test_3() {
	
	Response response = RestAssured.get("https://swapi.dev/api/people/1");

	System.out.println("1� " + response.asString());
	System.out.println("2� " + response.getBody().asString());
	System.out.println("3� " + response.getStatusCode());
	System.out.println("4� " + response.getHeader("Content-Type"));
	System.out.println("5� " + response.getTime());
	System.out.println("6� " + response.getStatusLine());
	
	}
	
}
