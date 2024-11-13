package apiscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class cookiesvaidation_7 {
	//cookies are dynamic
  @Test(priority = 1)
  public void getAllcookies() {
	  given()
	  .when()
	  .get("https://www.google.com")
	  .then()
	  .log().cookies();
  }
  @Test(priority = 2)
  public void getSingleCookie() {
	  System.out.println("GTest for single cookie");
	  Response res = given()
	  .when()
	  .get("https://www.google.com");
	 String actcookie = res.getCookie("AEC");
	 System.out.println(actcookie);
	 String Exp = "AVYB7crAkhEaowoXePmv7mYu7S9SDLgEuTfyTyT2P5B0VSwy-b5vdID5AAk";
	 //cookies are dynamic
	 Assert.assertFalse(actcookie.equals(Exp),"Test fail:As cookies are same");
	 System.out.println("Test PAss:As cookies are dynamic");
  }
}
