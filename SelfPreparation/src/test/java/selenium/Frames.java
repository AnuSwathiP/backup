package selenium;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
public class Frames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		 WebDriver driver=new ChromeDriver();
		 WebDriver driver=new FirefoxDriver();
		 driver.manage().window().maximize();
	        driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_confirm");

	       
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
//	        Locating iframe using index
//	        1)frame(index)
//	        driver.switchTo().frame(0);
//	        2)frame(Name of Frame)
//	        driver.switchTo().frame(“name of the frame”);
//	        3)frame(WebElement element)
//	        driver.switchTo().frame(driver.findElements(By.tagName(“iframe”).get(0))
//	        Select Parent Window
//	        driver.switchTo().defaultContent()
//	        driver.switchTo().frame("iframeResult");
	        WebElement w=driver.findElement(By.xpath("//iframe[@id='iframeResult']"));
	        driver.switchTo().frame(w);



	        //click try button

	        driver.findElement(By.xpath("//button[@onclick='myFunction()']")).click();
	        //or
//	        driver.findElement(By.xpath("//button[text()=\"Try it\"]")).click();


	        //driver.switchTo().alert().accept();

	        driver.switchTo().alert().dismiss();
	        driver.switchTo().defaultContent();
	        WebElement text = driver.findElement(By.xpath("//span[text()='The Window Object']"));
	        System.out.println("text="+text.getText());
	}

}
