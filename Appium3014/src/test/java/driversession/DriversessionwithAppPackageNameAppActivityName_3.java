package driversession;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class DriversessionwithAppPackageNameAppActivityName_3 {
	
  @Test
  public void createDriverSession() throws MalformedURLException {
	  UiAutomator2Options options = new UiAutomator2Options();
	  options.setPlatformName("Android");
	  options.setCapability("appium:uiautomator2ServerLaunchTimeout", 50000);
	  //open Application in android studio
	  //in cmd ->adb shell
//	  $ dumpsys window | grep -E mCurrentFocus
	  //u will get apppackage and app activity names
	  options.setCapability("appium:appPackage", "io.appium.android.apis");
	  options.setCapability("appium:appActivity", "io.appium.android.apis.ApiDemos");
	//server address
	  URL url = new URL("http://0.0.0.0:4723");
	//server connectivity-create a  driver session
	  AppiumDriver driver =new AndroidDriver(url,options);
	  System.out.println("SessionId : "+driver.getSessionId());
  }
}
