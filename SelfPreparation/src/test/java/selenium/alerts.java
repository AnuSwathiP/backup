package selenium;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class alerts {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
//        WebDriver driver = new ChromeDriver(); 
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("http://omayo.blogspot.com/");
        driver.findElement(By.id("prompt")).click();
        
        Alert alert = driver.switchTo().alert();
       Thread.sleep(1000);
        alert.sendKeys("Anu"); //In chrome driver display problem is there,then use firefox driver here
//        alert.dismiss() ;
//        alert.accept() ;
//        alert.getText();
	}

}
