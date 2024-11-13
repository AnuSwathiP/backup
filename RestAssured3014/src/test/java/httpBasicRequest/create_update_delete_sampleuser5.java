package httpBasicRequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class create_update_delete_sampleuser5 {
	//for practice
	//https://github.com/vdespa/quick-introduction-to-postman/blob/main/simple-tool-rental-api.md
	int id;
  @Test(priority = 1)
  public void createuser() {
	  System.out.println("Post request using POJO");
	  //payload
	  PojoData_4 pojo = new PojoData_4();
	  pojo.setName("Kiran");
	  pojo.setJob("Tester");
	 id = given()
	 .contentType("application/json")
	  .body(pojo)
	 .when()
	 .post("https://reqres.in/api/users")
	 .jsonPath().getInt("id");
	System.out.println("User created with id:"+id);
  }
  //update test case depends on create method
  @Test(priority = 2,dependsOnMethods ="createuser" )
  public void UpdateSameUser() 
  {
	  System.out.println("same user is updating........");
	  //payload
	  PojoData_4 pojo = new PojoData_4();
	  pojo.setName("Kavitha");
	  pojo.setJob("SDET");
	 given()
	 .contentType("application/json")
	  .body(pojo)
	 .when()
	 .put("https://reqres.in/api/users/"+id)
	 .then()
	 .statusCode(200)
	  .log().body();
	 System.out.println("User updated with id:"+id);
  }
  @Test(priority = 3,dependsOnMethods ="UpdateSameUser" )
  public void deletesameuser() {
	  System.out.println("same user is deleting........");
	 given()
	 .when()
	 .delete("https://reqres.in/api/users/"+id)
	 .then()
	 .statusCode(204)
	  .log().all();
	 System.out.println("User updated with id:"+id);
  }
}
