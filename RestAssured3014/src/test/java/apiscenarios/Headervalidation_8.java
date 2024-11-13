package apiscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

public class Headervalidation_8 {
  @Test(priority = 1)
  public void getAllHeaders() {
	  System.out.println("Get all headers");
	  given()
	  .when()
	  .get("https://www.google.com")
	  .then()
	  .log().headers();
  }
  @Test(priority = 2)
  public void testHeader() {
	  System.out.println("Test header");
	  Response res = given()
	  .when()
	  .get("https://www.google.com");
	 String actheader = res.getHeader("Content-Type");
	 System.out.println(actheader);
	 String Exp = "text/html; charset=ISO-8859-1";
	 //Headers are static
	 Assert.assertEquals(actheader,Exp,"Test fail:Headers are not  same");
	 System.out.println("Test PAss:As Headers are static");
  }
}
