package mobileElementsScenarios;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import generic.Utility;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class screenshotassignment {
	 AppiumDriver driver;
  @Test
  public void assignment() throws InterruptedException {
	//create a driver session
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
	
	  //element 'views'
	  driver.findElement(AppiumBy.accessibilityId("Views")).click();
	  Thread.sleep(2000);
	  //screenshot
	  TakesScreenshot ts = (TakesScreenshot)driver;
		//create a folder screenshots in project
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination= new File(System.getProperty("user.dir")+"//screenshots//appium"+System.currentTimeMillis()+".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
  }
}
