package apiscenarios;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class AuthenticationDemo {
	/*given() //u can pass precondition(Pre requisite) 
	request header,request payload,query and path parameters,cookies,authentication
	when() //to pass request (API request)
	GET,POST,PUT,PATCH,DELETE
	then() //for validation
	status code,message,time,response payload,headers,cookies*/
//	Authentication is always at precondition
  @Test
  public void basicAuth() {
	  given()
	  .auth().basic("postman", "password")
	  .when()
	  .get("https://postman-echo.com/basic-auth")
	  .then()
	  .statusCode(200)
	  .body("authenticated", equalTo(true))
	  .log().body();
	  System.out.println("Basic Authentication is completed");
  }

  @Test
  public void bearertokenAuth() {
	  given()
	  .header("Authorization", "Bearer 12345")
	  .when()
	  .get("https://postman-echo.com/")
	  .then()
	  .statusCode(200)
//	  .body("authenticated", equalTo(true))
	  .log().all();
	  System.out.println("Bearer Authentication is completed");
  }
  //twitter is working on OAuth 1.0,All latest applications using oAUTH 2.0
  @Test
  public void oauth2Test() {
	  given()
	  .auth().oauth2("12345")
	  .when()
	  .get("https://postman-echo.com/")
	  .then()
	  .statusCode(200)
//	  .body("authenticated", equalTo(true))
	  .log().all();
	  System.out.println("oAUTH2 Authentication is completed");
  }
}
