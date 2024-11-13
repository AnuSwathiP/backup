package generic;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
//import java.util.logging.FileHandler;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class Utility {
	public static AppiumDriver driver;
	public static AppiumDriver createdriversession() {
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
		return driver;
	}
	public static void scrollDown(WebElement area) {
		//scroll gesture
		  driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
				  "elementId", ((RemoteWebElement) area).getId(), "direction", "down",
				    "percent", 0.75
				));
	}
	public static void scrollUp(WebElement area) {
		//scroll gesture
		  driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
				  "elementId", ((RemoteWebElement) area).getId(), "direction", "up",
				    "percent", 0.75
				));
	}
	public static void scrollDownAsPerCount(WebElement area,int count) {
		for(int i=1;i<=count;i++)
		{
		//scroll gesture
		  driver.executeScript("mobile: scrollGesture", ImmutableMap.of(
				  "elementId", ((RemoteWebElement) area).getId(), "direction", "down",
				    "percent", 0.75
				));
		  System.out.println("count iteration is :"+i);
		}
	}
	public static void swipeleft(WebElement area) {
		//swipe gesture
		driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
				 "elementId", ((RemoteWebElement) area).getId(),
				    "direction", "left",
				    "percent", 0.75
				));
	}
	public static void swiperight(WebElement area) {
		//swipe gesture
		driver.executeScript("mobile: swipeGesture", ImmutableMap.of(
				 "elementId", ((RemoteWebElement) area).getId(),
				    "direction", "right",
				    "percent", 0.75
				));
	}
	public static void getScreenshot()
	{
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
