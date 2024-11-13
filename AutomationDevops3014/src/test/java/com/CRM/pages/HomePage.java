package com.CRM.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class HomePage {
//Page class follows encapsulation(wrapping of data and function together into single unit) principles i.e., we shoulh have locators,variable.method
	//encapusulation = private data+public method
	
	private WebDriver driver;
	//initilize driver
	//constructor always help to intialize the object
//	public HomePage() 
//	{
//		
//	//If you dont initialize here,you will get this.driver = null means nullpointer exception
//	}
	public HomePage(WebDriver driver) //base class driver
	{
		
		// TODO Auto-generated constructor stub
		this.driver = driver;
	
	}
	//By is a class
	//data member(locator)
	By link =By.linkText("Sign In");
	//method(functionality to test)
	public String getAppUrl()
	{
		return driver.getCurrentUrl();
	}
	public String getAppTitle()
	{
		return driver.getTitle();
	}
	public String getStatusoflink()
	{
		driver.findElement(link).click();
		return driver.getCurrentUrl();
	}
}
