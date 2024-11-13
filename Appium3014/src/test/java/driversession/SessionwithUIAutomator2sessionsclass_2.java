package driversession;

import java.net.MalformedURLException;
import java.net.URL;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class SessionwithUIAutomator2sessionsclass_2 {
  @Test
  public void createDriverSession() throws MalformedURLException {
	  UiAutomator2Options options = new UiAutomator2Options();
	  options.setPlatformName("Android");
	  options.setCapability("appium:uiautomator2ServerLaunchTimeout", 50000);
	  //application path
	  String path =System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";
	  options.setCapability("appium:app", path);
	//server address
	  URL url = new URL("http://0.0.0.0:4723");
	//server connectivity-create a  driver session
	  AppiumDriver driver =new AndroidDriver(url,options);
	  System.out.println("SessionId : "+driver.getSessionId());
  }
}
