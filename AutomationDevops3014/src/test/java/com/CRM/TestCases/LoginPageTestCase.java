package com.CRM.TestCases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class LoginPageTestCase extends Baseclass{
	//Runas->TestNg Test
	//If both Homepagetestcase and loginppagetestcase tests then create xml file
	//rightclick->testng->convert to TestNg ->change name to crm->select both ticks->ok
 @BeforeClass
 public void pagesetup()
 {
	 //we have to use this because before login signin button should click
	 hp.getStatusoflink();
 }
	@Test
  public void validatelogin() {
	  String cururl = lp.dologin("test@gmail.com","test123");
	  Assert.assertTrue(cururl.contains("customers"),"Test Fail:Login Fail");
	  System.out.println("Test Pass:Login Completed!");
  }
}
