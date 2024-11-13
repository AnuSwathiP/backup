package selenium;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BootstrapDropDown_3 {
	public static void main(String[] args)
	{
		WebDriver driver = new ChromeDriver();
		//implicit wait
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.redbus.in/");
		WebElement ele= driver.findElement(By.id("src"));//we have <div> tag not <select> tag
		ele.click();
		ele.sendKeys("pu");
		List<WebElement> srclist=driver.findElements(By.xpath("//ul[@class='sc-dnqmqq dZhbJF']/li//text[@class='placeHolderMainText']"));
		System.out.println("Total Options are:"+srclist.size());
		for(WebElement i:srclist)
		{
			System.out.println(i.getText());
			if(i.getText().contains("Viman Nagar"))
			{
				i.click();
				break;
			}
		}
	}
}
