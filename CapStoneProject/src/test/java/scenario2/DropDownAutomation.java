package scenario2;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DropDownAutomation {
  @Test
  public void testcase() {
	  WebDriver driver = new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		//username
		driver.findElement(By.name("username")).sendKeys("Admin");
		
		//password
		driver.findElement(By.name("password")).sendKeys("admin123");
		//login
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		//admin
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'][1]
		driver.findElement(By.xpath("//span[text()='Admin']")).click();
		driver.findElement(By.xpath("//i[contains(@class,'oxd-select-text--arrow')])[1]")).click();
		List<WebElement> list = driver.findElements(By.xpath("//div[@role='listbox']//div//span"));
		for(WebElement i:list)
		{
			if(i.getText().contains("Admin"))
			{
				i.click();
				break;
			}
		}
  }
}
