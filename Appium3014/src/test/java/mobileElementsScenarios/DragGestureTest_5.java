package mobileElementsScenarios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import generic.Utility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class DragGestureTest_5 {
  @Test
  public void testDragGesture() throws InterruptedException {
	//create a driver session
	  AppiumDriver driver =Utility.createdriversession();
	  WebElement area = driver.findElement(AppiumBy.id("android:id/list"));
	  Utility.scrollDown(area);
	  //element 'views'
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  Thread.sleep(2000);
	//Drag and drop
	  driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
	  Thread.sleep(2000);
	  //dot3
	  WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_3"));
	  //draggesture
	  //click 'tap/swipe by coordinates' button to get the x and y coordinates of dot to be dragged 
	 driver.executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "endX", 850,
			    "endY", 1250
			));
	 Thread.sleep(1000);
//	//dropped message
	  String resultmessage = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();
	  System.out.println("After Drag Gesture Result Message is:"+resultmessage);
  }
}