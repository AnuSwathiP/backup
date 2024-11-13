package scenario2;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginpageTest extends Baseclass{
	@Test(priority=1)
	  public void verifyTitle()
	  {
		 
		  String act=lp.getAppTitle();
		  Assert.assertTrue(act.contains("HRM"),"Error-Title not match");
		  System.out.println("Title matched!");
	  }
	  
	  @Test(priority=2)
	  public void verifyLogin()
	  {
		
		 lp.doLogin("Admin","admin123");
		 System.out.println("successfully clicked!");
	  }
	  
	  @Test(priority=3)
	  public void verifyCurrentUrl()
	  {
		  System.out.println("Current url after logged in"+lp.getAppUrl());
	  }
}
