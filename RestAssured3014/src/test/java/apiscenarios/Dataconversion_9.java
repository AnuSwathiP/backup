package apiscenarios;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import httpBasicRequest.PojoData_4;

public class Dataconversion_9 {
	/*
	 * Serialization POJO->JSON
	 * Deserialization JSON->POJO
	 */
  @Test(priority = 1)
  public void testserialization() throws JsonProcessingException {
	  PojoData_4 data = new PojoData_4();
	  data.setName("Tanvi");
	  data.setJob("QA");
	  ObjectMapper obj = new ObjectMapper();
	  String json = obj.writerWithDefaultPrettyPrinter().writeValueAsString(data);
	  System.out.println(json);
//	  output:- pojo data convert to json
//	  {
//	    "name" : "Tanvi",
//	    "job" : "QA"
//	  }
  }
  @Test(priority = 2)
  public void testDeserialization() throws JsonProcessingException {
	  //copy paste json value in double quotes
	  String json=" {\n"
	  		+ "	    \"name\" : \"Tanvi\",\n"
	  		+ "	    \"job\" : \"QA\"\n"
	  		+ "	  }";
	  ObjectMapper obj = new ObjectMapper();
	  PojoData_4 data =obj.readValue(json, PojoData_4.class);
	  System.out.println(data.getName());
	  System.out.println(data.getJob());
//	  output:- json to pojo data 
//	  Tanvi
//	  QA
  }
}
