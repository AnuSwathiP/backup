package mobileElementsScenarios;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import generic.Utility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;

public class AlertsInAppium_7 {
  @Test
  public void testAlert() throws InterruptedException {
	  //Handle Alerts with Alert Interface
	  //4 methods in alerts.They are getetxt,accept,dismiss,if alert is prompt type use sendkeys
	  //accept()==>for ok
	  //dismiss()==>cancel
	  //getText()==>Text for alert
	  //sendkeys()==>Prompt
	  //Create a driver session
	  AppiumDriver driver =Utility.createdriversession();
	  //App
	  driver.findElement(AppiumBy.accessibilityId("App")).click();
	  Thread.sleep(2000);
	  //Alert dialog
	  driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
	  Thread.sleep(2000);
	  //Alert
	  driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
	  Thread.sleep(2000);
	  //Alert open
	  Alert alert1 = driver.switchTo().alert();
	  System.out.println("Alert Text is "+alert1.getText());
	  alert1.accept();
	  
	  
  }
 
}
