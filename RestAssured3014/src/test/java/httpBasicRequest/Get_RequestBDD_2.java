package httpBasicRequest;
import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import  org.testng.annotations.Test;

public class Get_RequestBDD_2 {
	//given() //it is a method where u can pass precondition(Pre requisite) 
	//request header,request payload,query and path parameters,cookies,authentication
	//when() //to generate any request (API request)
//	GET,POST,PUT,PATCH,DELETE
	//then() //for validation
//	status code,message,time,response payload,headers,cookies
  @Test
  public void getsingleUsers() {
//	  https://github.com/rest-assured/rest-assured/wiki/usage#static-imports
//	  In order to use REST assured effectively it's recommended to statically import methods from the following classes:
//	  io.restassured.RestAssured.*
//	  io.restassured.matcher.RestAssuredMatchers.*
//	  org.hamcrest.Matchers.*
	  given()
	  .when()
	  .get("https://reqres.in/api/users/2")
	  .then()
	  .statusCode(200)
//	  .log().body();//it will show all body
//	  .log().headers();
//	  .log().all();
	  .body("data.id", equalTo(2))//from hamcrest package
	  .body("support.url", equalTo("https://reqres.in/#support-heading"))
	  .log().all();
  }
  @Test
  public void getListofUsers() {
	  given()
	  .when()
	  .get("https://reqres.in/api/users?page=2")
	  .then()
	  .statusCode(200)
	  //equalto()=>test equality for data
	  //hasitems()=>check all elements are in collection
	  //contains()=>check all elements are in collection and in a strict order
	  .body("data[1].id", equalTo(8))
	  .body("data.id", hasItems(7,8,9,10,11,12))
	  .body("data.id", hasItems(7,10,12))
	  .body("data.id", hasItems(10,7,12))
	  .body("data.id", contains(7,8,9,10,11,12))
//	  .body("data.id", contains(7,8,9))//fails
//	  .body("data.id", contains(8,7,9,10,11,12))//fails
	  .log().body();
	  
  }
  
  
}
