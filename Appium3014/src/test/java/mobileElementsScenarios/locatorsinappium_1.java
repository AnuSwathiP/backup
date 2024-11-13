package mobileElementsScenarios;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.Utility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class locatorsinappium_1 {
	//This script prepared based on Inspector
	//1:44:18
  @Test
  public void testMobileElements() throws InterruptedException 
  {
	  //driver creating session is there in generic package->Utility class
	  AppiumDriver driver = Utility.createdriversession();
	  //Locators
	  //accessibility-id  is a primary locator in appium
	  //element1'Access'ability'
	  WebElement element1 = driver.findElement(AppiumBy.accessibilityId("Access'ibility"));
	  System.out.println("Text of Element1"+element1.getText());
	  element1.click();
	  Thread.sleep(2000);
	  //come back tpo previous page
	  //Navigate method returns navigation interface object
	  driver.navigate().back();
	  //element2'Accessability' xpath
	  WebElement element2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Accessibility\"]"));
	  System.out.println("Element2 Text is "+element2.getText());
	  element2.click();
	  Thread.sleep(2000);
	  driver.navigate().back();
	  //element3'Animation' classname
	  //in appium inspector ,after copying class Name,put it in search and check for duplicacy
	  //If call to '10' failed comes means =>quit session and start session again
	  //or message in appium as 'interactions are not available for this element',then also =>quit session and start session again
	  //in search we have 13 elements for this classname
	  //WebElement element3 = driver.findElement(AppiumBy.className("android.widget.TextView"));
	  //The above line return 1st element i.e, APIDEMOS
	  WebElement element3 = driver.findElements(AppiumBy.className("android.widget.TextView")).get(3);
	  System.out.println("Element3 Text is "+element3.getText());
	  element3.click();
	  driver.navigate().back();
	  //element4'APP' resourceid(This is available in mobile only)
	  //in search under id check the copied resourceid,we have 12 elements for this resourceid
	  WebElement element4 = driver.findElements(AppiumBy.id("android:id/text1")).get(3);
	  System.out.println("Element4 Text is "+element4.getText());
	  element4.click();
	  driver.navigate().back();
	//element5'content' uiautomator2(This will work only if visible taxt available)
	  //copy text attribute value
	  //ui related framework
	  WebElement element5 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"Content\")"));
	  System.out.println("Element5 Text is "+element5.getText());
	  element5.click();
	  driver.navigate().back();
  }
}