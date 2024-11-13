package httpBasicRequest;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
//create a simple project(skip archetype)
//change all http to https in pom.xml
//add restassured dependencies,tesng dependencies in pom.xml
//This is older pattern
public class GetWithoutBDD_1 {
  @Test
  public void singleuser() {
	  //4 object oriented principles in java Encapsulation,polymorphism,inheritance,data abstraction
	  //RestAssured is class
	  //Here we have all static methods,so u can directly call from class
	  //this is method overloading,compile time polymorphism,early binding
	  Response res = RestAssured.get("https://reqres.in/api/users/2");
	  //Response is interface from rest assured library
	  System.out.println("Status code is"+res.getStatusCode());
	  System.out.println("Status line is"+res.getStatusLine());
	  System.out.println("get the time"+res.getTime());
	  System.out.println(res.getContentType());
	  System.out.println(res.asString());
	  System.out.println("***************");
	  System.out.println(res.asPrettyString());
	  Assert.assertEquals(res.getStatusCode(), 200,"Test Fail:Status code is not matched");
	  System.out.println("Test Pass:Status code matched!");
  }
  @Test
  public void getallusers()
  {
	  Response res = RestAssured.get("https://reqres.in/api/users?page=2");
	  int pagenumber = res.jsonPath().getInt("page");
	  System.out.println("Page number is"+pagenumber);
	  
  }
}
