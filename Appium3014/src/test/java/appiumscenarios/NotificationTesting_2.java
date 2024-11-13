package appiumscenarios;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.Utility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class NotificationTesting_2 {
  @Test
  public void testNotificationinAppium() 
  {
	  //create a driver session
	  AppiumDriver driver =Utility.createdriversession();
	  //open Notifications
	  ((AndroidDriver)(driver)).openNotifications();
	  System.out.println("Notification window is opened");
	  //find the resourceid of any notification and in search under id checkno of elements for this resource id
	  System.out.println("****Notificatoin Header*******");
	  List<WebElement> headers=driver.findElements(AppiumBy.id("android:id/title"));
	  System.out.println("Total Notifications are:"+headers.size());
	  for(WebElement i:headers)
	  {
		  //If gettext is not displayed because in opening and closing tag there is no display text available in appium inspector
		  //then go for diaplay text and get resource id
		  System.out.println(i.getText());
	  }
	  //android:id/big_text ,this will give subtext of appium setting notification
	  //android:id/text ,this will give u subtext of remaining notifications 
	  System.out.println("****Sub Headings of notification*******");
	  List<WebElement> list=driver.findElements(AppiumBy.id("android:id/text"));
	  System.out.println("Total Notifications are:"+list.size());
	  for(WebElement i:list)
	  {
		  //If gettext is not displayed because in opening and closing tag there is no display text available in appium inspector
		  //then go for diaplay text and get resource id
		  System.out.println(i.getText());
	  }
	  String text =driver.findElement(AppiumBy.id("android:id/big_text")).getText();
	  System.out.println(text);
  }
}
