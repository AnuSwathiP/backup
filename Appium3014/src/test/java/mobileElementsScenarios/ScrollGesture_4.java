package mobileElementsScenarios;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import generic.Utility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class ScrollGesture_4 {
  @Test
  public void scrollTest() throws InterruptedException {
	//create a driver session
	  AppiumDriver driver =Utility.createdriversession();
	  //element 'views'
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  Thread.sleep(2000);
	  //area
	  //select any element and move towards parent element where all list selected and take that id
	  WebElement area = driver.findElement(AppiumBy.id("android:id/list"));
	  /* This will work
	  //scroll gesture
	  driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
			  "elementId", ((RemoteWebElement) area).getId(), "direction", "down",
			    "percent", 0.75
			));
			*/
	  //scroll gesture using utility class
	  Utility.scrollDown(area);
	  Utility.getScreenshot();
	  Thread.sleep(3000);
	  Utility.scrollUp(area);
	  Utility.getScreenshot();
	  Thread.sleep(2000);
	  Utility.scrollDownAsPerCount(area,3);
	  Utility.getScreenshot();
	  System.out.println("Scroll down is completed");
	  //After the projrct success,refresh the screenshots folder to see new screenshots
  }
}
