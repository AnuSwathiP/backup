package mobileElementsScenarios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import generic.Utility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class SwipeGestures_6 {
  @Test
  public void testswipe() throws InterruptedException {
	//create a driver session
	  AppiumDriver driver =Utility.createdriversession();
	  //element 'views'
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  Thread.sleep(2000);
	  //gallery
	  driver.findElement(AppiumBy.accessibilityId("Gallery")).click();
	  Thread.sleep(2000);
	  //photos
	  driver.findElement(AppiumBy.accessibilityId("1. Photos")).click();
	  Thread.sleep(2000);
	  //area
	  //select photo element and move to parent and select parent id
	  WebElement element=driver.findElement(AppiumBy.id("io.appium.android.apis:id/gallery"));
	driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
			 "elementId", ((RemoteWebElement) element).getId(),
			    "direction", "left",
			    "percent", 0.75
			));
	 System.out.println("Swipe Gesture is completed");
	  
  }
}
