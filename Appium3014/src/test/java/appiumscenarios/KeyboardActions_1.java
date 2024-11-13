package appiumscenarios;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.Utility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class KeyboardActions_1 {
  @Test
  public void testkeboardAction() {
	  //create a driver session
	  AppiumDriver driver =Utility.createdriversession();
	  //global wait or implicit wait
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  WebElement area2 = driver.findElement(AppiumBy.id("android:id/list"));
	  Utility.scrollDown(area2);
	  //views
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  //area//select any element and scroll up to get parent id
	  WebElement area = driver.findElement(AppiumBy.id("android:id/list"));
	  //scroll down action
	  Utility.scrollDownAsPerCount(area, 4);
	  //textview
	  driver.findElement(AppiumBy.accessibilityId("TextFields")).click();
	  //typearea
	  WebElement typearea = driver.findElement(AppiumBy.id("io.appium.android.apis:id/edit"));
//	  typearea.sendKeys("Hello All!");
	  //KeyEvent Class
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.H));
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.E));
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.L));
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.L));
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.O));
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.ENTER));
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.A));
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.L));
	  ((AndroidDriver)driver).pressKey(new KeyEvent(AndroidKey.L));
	  
	  
}
}
