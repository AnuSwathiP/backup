package driversession;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class firstdriversession {
	
  @Test
  public void driversessionTest() throws MalformedURLException {
	  //To make connection with server we are passing properties to server
	  //DesiredCapabilities is a properties class used to customize device driver session
	  //Capabilities always with key value pair
	  //few capabilities are by default provided by appium itself i.e., called vendor(appium) prefix
	  DesiredCapabilities cap= new DesiredCapabilities();
	  cap.setCapability("platformName", "Android");
	  cap.setCapability("appium:automationName", "uiAutomator2");
	  //open android studio and emulator ,right click on 3 dots and click view details->hw.device.name = pixel_xl
//	  cap.setCapability("appium:deviceName", "pixel_xl"); 
//	  cap.setCapability("appium:udid", "emulator-5554");
	  cap.setCapability("appium:deviceName", "Nexus 4"); 
	  cap.setCapability("appium:udid", "emulator-5554");
	  cap.setCapability("appium:uiautomator2ServerLaunchTimeout", 50000);
	  //appilication path to server using capability
	  //Add ApiDemos-debug.apk inside src/test/resources folder
	  String path =System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";
	  cap.setCapability("appium:app", path);
	  //open Android studio and emulator should run
	  //open cmd from windows,c../>appium enter,server will start
	  // Appium REST http interface listener started on http://0.0.0.0:4723
	  //server address
	  URL url = new URL("http://0.0.0.0:4723");
	  //server connectivity-create a  driver session
	  AppiumDriver driver =new AndroidDriver(url,cap);
	  System.out.println("SessionId"+driver.getSessionId());
	  }
  
 
}
//add io.appium and org.testng dependency
	//https://appium.io/docs/en/latest/quickstart/ is for appium official documentation
	//https://github.com/appium/appium-uiautomator2-driver?=Capabilities 
//c:\\users\ravir\AppData\Local\Android\sdk\platform-tools>adb devices enter
//1)If you get error,stop emulator and click on 3 dots->cold boot
//2)stop and start again appium server