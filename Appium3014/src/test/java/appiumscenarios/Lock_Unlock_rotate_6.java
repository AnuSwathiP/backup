package appiumscenarios;

import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;

import generic.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class Lock_Unlock_rotate_6 {
  @Test
  public void testDevicefunctions() {
	//create a driver session
	  AppiumDriver driver =Utility.createdriversession();
	  //LockDevice
	  //Unlock Device
	  //rotate(Screen rotation)
	  //create driver session
	  ((AndroidDriver)driver).lockDevice();
	  System.out.println("Device Locked");
	  //To unlock device
	  ((AndroidDriver)driver).unlockDevice();
	  System.out.println("Device UnLocked");
	  //rotate
	  ((AndroidDriver)driver).rotate(ScreenOrientation.LANDSCAPE);
	  System.out.println("Application rotate to landscape");
  }
}
