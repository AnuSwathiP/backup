package apiscenarios;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class Query_pathparameters_6 {
  @Test
  public void path_Queryparameter() {
//	  https://reqres.in/api/users?page=2
	  given()
	  .pathParam("path", "users")
	  .queryParam("page", 2)
	  .when()
	  //we dont need toset up query parameter because by dafault path parameter has query parameters also
	  .get("https://reqres.in/api/{path}")
	  .then()
	  .statusCode(200)
	  .log().body();
  }
}
