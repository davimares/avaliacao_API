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
		System.out.println("statusCode é " + statusCode);

	}
	
	@Test
	public void test_3() {
	
	Response response = RestAssured.get("https://swapi.dev/api/people/1");

	System.out.println("1º " + response.asString());
	System.out.println("2º " + response.getBody().asString());
	System.out.println("3º " + response.getStatusCode());
	System.out.println("4º " + response.getHeader("Content-Type"));
	System.out.println("5º " + response.getTime());
	System.out.println("6º " + response.getStatusLine());
	
	}
	
}
