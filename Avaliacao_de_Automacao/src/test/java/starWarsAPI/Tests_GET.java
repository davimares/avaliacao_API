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

	public void test_01() {
		Response response = RestAssured.get("https://swapi.dev/api/people/1");

		int code = 200;
		int statusCode = response.getStatusCode();
		Assert.assertEquals(code, statusCode);
		System.out.println("statusCode é " + statusCode);

	}

}
