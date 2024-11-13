package com.CRM.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.CRM.pages.HomePage;



public class HomePageTestCase extends Baseclass{
//	new->TestNG->Create TestNG class
	//Here we can apply assertion,testing functionality feature
	//rightclick->Run as->TestNG Test
  @Test(priority =1)
  public void verifyUrl() {
	
	  String acturl = hp.getAppUrl();
	  Assert.assertTrue(acturl.contains("crm"),"Test Fail:URL not matched");
	  System.out.println("Test Pass:URL matched!");
  }
  @Test(priority =2)
  public void verifyTitle() {
	  String actTitle = hp.getAppTitle();
	  Assert.assertTrue(actTitle.contains("Customer"),"Test Fail:Title not matched");
	  System.out.println("Test Pass:Title matched!");
  }
  @Test(priority =3)
  public void ValidateSignInLink() {
	  String nextpageurl = hp.getStatusoflink();
	  Assert.assertTrue(nextpageurl.contains("login"),"Test Fail:Login Page not open");
	  System.out.println("Test pass:Application navigating to login page");
  }
}
