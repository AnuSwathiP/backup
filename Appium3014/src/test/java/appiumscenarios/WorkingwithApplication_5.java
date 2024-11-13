package appiumscenarios;

import java.time.Duration;

import org.testng.annotations.Test;

import generic.Utility;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class WorkingwithApplication_5 {
  @Test
  public void testApp() throws InterruptedException 
  {
	//create a driver session
	  AppiumDriver driver =Utility.createdriversession();
	  System.out.println("CurrentStateofApplication : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));
	 //terminate App 
	  ((AndroidDriver)driver).terminateApp("io.appium.android.apis");
	  System.out.println("After Terminate status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));
	  //Activate App
	  Thread.sleep(5000);
	  ((AndroidDriver)driver).activateApp("io.appium.android.apis");
	  System.out.println("After Activate status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));
	 //uninstall-removeapp()
	  Thread.sleep(3000);
	  ((AndroidDriver)driver).removeApp("io.appium.android.apis");
	  System.out.println("After uninstallation status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));
	  //install
	  Thread.sleep(5000);
	  //C:\Users\ravir\eclipse-workspace\Appium3014\src\test\resources\ApiDemos-debug.apk
	  String path = System.getProperty("user.dir")+"//src//test//resources//ApiDemos-debug.apk";
	  ((AndroidDriver)driver).installApp(path);
	  System.out.println("After Installation status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));
	  //Activate
	  Thread.sleep(5000);
	  ((AndroidDriver)driver).activateApp("io.appium.android.apis");
	  System.out.println("After Activate status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));
       //background
	  Thread.sleep(5000);
	  ((AndroidDriver)driver).runAppInBackground(Duration.ofMillis(5000));
	  System.out.println("After BAckground Execution status is : "+((AndroidDriver)driver).queryAppState("io.appium.android.apis"));

  }
  //In Appium Inspector->start session->commands->App Management->isappinstalled,appid->give 'io.appium.android.apis' and excecute->true
  //similarly terminateapp means close app not uninstall
  //activateapp means app will come forward
}
