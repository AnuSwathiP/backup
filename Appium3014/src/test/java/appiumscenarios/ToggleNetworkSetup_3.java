package appiumscenarios;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generic.Utility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ToggleNetworkSetup_3 {
  @Test
  public void testTogglesetup() throws InterruptedException {
	  /*
	   * togglewifi()
	   * toggledata-mobileData
	   * toggleAirplaneMode
	   * 
	   */
	//create a driver session
	  AppiumDriver driver =Utility.createdriversession();
	  System.out.println("Initially wifi is onState");
	  //ON->OFF
	  ((AndroidDriver)driver).toggleWifi();
	  
	  System.out.println("Wifi State is OFF");
	  Thread.sleep(2000);
	  //OFF->ON
	  ((AndroidDriver)driver).toggleWifi();
	  
	  System.out.println("Wifi State is ON");
	  //swipe left, if mobile data icon in next screen when u swipe left
//	  WebElement area = driver.findElement(AppiumBy.id("com.android.systemui:id/title_page"));
//	  Utility.swipeleft(area);
//	  Thread.sleep(2000);
	  System.out.println("Mobile data state is ON");
	 //MobileData
	  ((AndroidDriver)driver).toggleData();
	  System.out.println("Mobile data state is OFF");
	  Thread.sleep(2000);
	  ((AndroidDriver)driver).toggleData();
	  System.out.println("Mobile data state is ON");
	  //Airplane mode
	  System.out.println("Airplane Mode state is OFF");
	  Thread.sleep(1000);
	  ((AndroidDriver)driver).toggleAirplaneMode();
	  Thread.sleep(1000);
	  System.out.println("Airplane Mode state is ON");
	  Thread.sleep(1000);
	  ((AndroidDriver)driver).toggleAirplaneMode();
	  System.out.println("Airplane Mode state is OFF");
	  
	 
	  
  }
}
