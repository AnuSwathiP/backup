package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class loginpage {
	
			private WebDriver driver;
			//by locator way
			private By uname=By.name("username");
			private By pass=By.name("password");
			private By btn=By.xpath("//button[@type='submit']");
			
			//initialize driver
			public loginpage(WebDriver driver)
			{
				this.driver=driver;
			}
			//methods
			public String getAppTitle()
			{
				return driver.getTitle();
			}
			public void doLogin(String un,String psw)
			{
				driver.findElement(uname).sendKeys(un);
				driver.findElement(pass).sendKeys(psw);
				driver.findElement(btn).click();
			}	
			public String getAppUrl()
			{
				return driver.getCurrentUrl();
			}
			
}
