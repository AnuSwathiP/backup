package generic;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;


public class Utility {
	public static WebDriver driver;
	public static void getScreenshot()
	{
		TakesScreenshot ts = ((TakesScreenshot)driver);
		//create a folder screenshots in project
		File source = ts.getScreenshotAs(OutputType.FILE);
		File destination= new File(System.getProperty("user.dir")+"//screenshots//HRM_"+System.currentTimeMillis()+".png");
		try {
			FileHandler.copy(source, destination);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
