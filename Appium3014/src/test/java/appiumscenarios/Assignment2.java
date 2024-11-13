package appiumscenarios;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Assignment2 {
	AppiumDriver driver ;
  @Test
  public void testforstate() throws InterruptedException {
	  UiAutomator2Options options = new UiAutomator2Options();
	  options.setPlatformName("Android");
	  options.setCapability("appium:uiautomator2ServerLaunchTimeout", 50000);
	  //application path
	  String path =System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";
	  options.setCapability("appium:app", path);
	//server address
	  URL url;
	try {
		url = new URL("http://0.0.0.0:4723");
		//server connectivity-create a  driver session
		   driver =new AndroidDriver(url,options);
		  System.out.println("SessionId : "+driver.getSessionId());
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//a)test application currentstate
	System.out.println("CurrentStateofApplication : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));
	 //b)send application in background and capture current state
	  Thread.sleep(5000);
	  ((AndroidDriver)driver).runAppInBackground(Duration.ofMillis(5000));
	  Thread.sleep(5000);
	  System.out.println("After BAckground Execution status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));
	  //c)uninstall-removeapp()
	  Thread.sleep(3000);
	  ((AndroidDriver)driver).removeApp("io.appium.android.apis");
	  System.out.println("After uninstallation status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));
	  //d)install
	  Thread.sleep(5000);
	 
	  String apppath = System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";
	  ((AndroidDriver)driver).installApp(apppath);
	  System.out.println("After Installation status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));
	  //Activate
	  Thread.sleep(2000);
	  ((AndroidDriver)driver).activateApp("io.appium.android.apis");
	  Thread.sleep(5000);
	  System.out.println("After Activate status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));

  }
}
//C:\Users\ravir\eclipse-workspace\Appium3014\src\test\resources\ApiDemos-debug.apk