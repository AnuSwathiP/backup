package scenario2;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pages.adminpage;
import pages.loginpage;

public class Baseclass {
	public WebDriver driver;
	public loginpage lp;
	public adminpage ap;
	@BeforeTest
	public void setUp()
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

		lp=new loginpage(driver);
		ap=new adminpage(driver);
		 
	}
	@BeforeClass
	public void pageSetup()
	{
		System.out.println("Login Test");
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		  //The below line should add for admin testing ,
		lp.doLogin("Admin","admin123");
		
	}
	
}
