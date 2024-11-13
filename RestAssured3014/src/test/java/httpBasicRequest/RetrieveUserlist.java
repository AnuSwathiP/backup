package httpBasicRequest;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

public class RetrieveUserlist {
  @Test
  public void list() {
	  given()
	  .when()
	  .get("https://reqres.in/api/users?page=1")
	  .then()
	  .statusCode(200)
	  .log().body();
  }
}
