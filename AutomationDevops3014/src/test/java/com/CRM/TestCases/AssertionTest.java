package com.CRM.TestCases;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AssertionTest {
  @Test
  public void hardAssertionTest() {
	  //if second line get assertion fail,it will not go to next line.it is hard assertion
	  String act = "Selenium Webdriver is  API for WebUI Test";
	  String exp = "Selenium Webdriver is  API for WebUI Test";
	  //If assertion Fail:-you will get assertion error not exception .It will get from java.lang package
	  Assert.assertEquals(act, exp,"Test Fail:Strings are not equal");
	  System.out.println("Test Pass:Strings are equal");
  }
}
