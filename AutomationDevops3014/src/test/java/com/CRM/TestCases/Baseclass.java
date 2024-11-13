package com.CRM.TestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

import com.CRM.pages.HomePage;
import com.CRM.pages.LoginPage;

public class Baseclass {
//For Pre Condition and post Condition 
	public WebDriver driver;
	public HomePage hp;
	public LoginPage lp;
	@BeforeTest
	public void setup()
	{
		driver = new ChromeDriver();
		driver.get("https://automationplayground.com/crm/");
		   hp = new HomePage(driver);
		   lp = new LoginPage(driver);
	}
}
