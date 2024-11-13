package httpBasicRequest;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;



public class POST_BDD_3 {
	//Run as->TestNGTest
  @Test(priority = 1)
  public void PostUsingHashmap() {
	  //post call sing 2 techniques
	  //1)Hashmap
	  //)POJO class( plain old java object which internally implements encapsulation of java)
//	  Add dependencies of json,json-schema-validator,gson,json-path
	  System.out.println("Post request using HashMap");
	  //payload
	  HashMap<String, Object> map= new HashMap<String,Object>();
	  map.put("name", "Jay");
	  map.put("job", "QA");
	  given()
	  .contentType("application/json")
	  .body(map)
	  .when()
	  .post("https://reqres.in/api/users")
	  .then()
	  .statusCode(201)
	  .body("name", equalTo("Jay"))
	  .body("job", equalTo("QA"))
	  .log().all();
  }
  @Test(priority = 2)
  public void PostUsingPoJo() 
  {
	  System.out.println("Post request using POJO");
	  //payload
	  PojoData_4 data = new PojoData_4();
	  data.setName("Sarang");
	  data.setJob("QA");
	 given()
	 .contentType("application/json")
	  .body(data)
	 .when()
	 .post("https://reqres.in/api/users")
	 .then()
	 .statusCode(201)
	 .body("name", equalTo("Sarang"))
	  .body("job", equalTo("QA"))
	  .log().all();
  }
  @Test(priority = 3)
  public void testpojoresponse() 
  {
	  System.out.println("Post response");
	  //payload
	  PojoData_4 data = new PojoData_4();
	  data.setName("Surabhi");
	  data.setJob("Developer");
	  //This is one way
/*	 Response res = given()
	 .contentType("application/json")
	  .body(data)
	 .when()
	 .post("https://reqres.in/api/users");
	  
     System.out.println(res.asPrettyString());
     String name =res.jsonPath().getString("name");
     Assert.assertEquals(name.equals("Surabhi"), "Test Fail:NAme not matched");
     System.out.println("Test Pass:Name is matched!");*/
     int id = given()
	 .contentType("application/json")
	  .body(data)
	 .when()
	 .post("https://reqres.in/api/users")
	 .jsonPath().getInt("id");
     System.out.println("Geenerated Id is"+id);
  }
}
