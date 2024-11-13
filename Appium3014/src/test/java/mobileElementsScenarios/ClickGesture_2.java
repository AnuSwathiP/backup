package mobileElementsScenarios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import generic.Utility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ClickGesture_2 {
  @Test
  public void clickGestureTest() {
	  //create a driver session
	  AppiumDriver driver =Utility.createdriversession();
	  //element 'views'
	  WebElement element =driver.findElement(AppiumBy.accessibilityId("Views"));
	  //click gesture
	  //every mobile gesture starts with mobile prefix
	  //Map holds key value pair
	  //ImmutableMap means value which assigned will not change
	  //https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md
	  driver.executeScript("mobile: clickGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId()
			));
	  System.out.println("Click Gesture is completed");
  }
}
