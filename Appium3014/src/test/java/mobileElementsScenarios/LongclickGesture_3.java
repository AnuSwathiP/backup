package mobileElementsScenarios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import generic.Utility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class LongclickGesture_3 {
  @Test
  public void longclickTest() throws InterruptedException {
	  //create a driver session
	  AppiumDriver driver =Utility.createdriversession();
	  //element 'views'
	  WebElement element =driver.findElement(AppiumBy.accessibilityId("Views"));
//	  driver.executeScript("mobile: clickGesture", ImmutableMap.of(
//			    "elementId", ((RemoteWebElement) element).getId()
//			));
	  //----------or--------------
	  element.click();
	  Thread.sleep(2000);
	//Drag and drop
	  //In Appium Inspector after selcting views,click on tap right side icon,and if screen is still showing previous page,click on refresh icon
	  driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	  Thread.sleep(2000);
	//first dot
	  WebElement ele = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));
	  //Long Click
	  //By default duration is 500 means 0.5 second
	  driver.executeScript("mobile: longClickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) ele).getId()
			,"duration",3000));//3 sec
	  System.out.println("Long click is completed for 3 seconds");
	  
	  
  }
}
