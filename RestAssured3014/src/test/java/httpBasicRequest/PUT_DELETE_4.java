package httpBasicRequest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
public class PUT_DELETE_4 {
  @Test
  public void update_putcall() {
	  PojoData_4 pojo = new PojoData_4();
	  pojo.setName("Anitha");
	  pojo.setJob("SDET");
	 given()
	 .contentType("application/json")
	  .body(pojo)
	 .when()
	 .put("https://reqres.in/api/users/2")
	 .then()
	 .statusCode(200)
	  .log().all();
  }
  @Test
  public void delete() {
	
	 given()
	 .when()
	 .delete("https://reqres.in/api/users/2")
	 .then()
	 .statusCode(204)
	  .log().all();
  }
}
