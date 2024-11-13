package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class adminpage {
	
private WebDriver driver;
//locators
   //first testcase
	private By menu=By.xpath("//ul[@class='oxd-main-menu']//li//span");	
	//second testcase
	private By usernametextbox=By.xpath("(//input[contains(@class,'oxd-input')])[2]");
	private By searchbtn=By.xpath("//button[@type='submit']");
	private By recordmsg=By.xpath("//div[contains(@class,'orangehrm-horizontal-padding')]//span[contains(@class,'oxd-text')]");
	private By resetbtn=By.xpath("//button[normalize-space()='Reset']");
	//third testcase
	private By userroledropdown=By.xpath("(//i[contains(@class,'bi-caret-down-fill')])[2]");
	private By userROptions=By.xpath("//div[contains(@class,\"oxd-select-option\")]");
	//fourth testcase
	private By statusdropdown=By.xpath("(//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow'])[2]");
	private By statusoptions=By.xpath("//div[@role='option']//span");
	
	public adminpage(WebDriver driver)
	{
		this.driver=driver;
	}
	//methods
	public void getMenu()
	{
		List<WebElement> list=driver.findElements(menu);
		
		System.out.println("Total menu options are: "+list.size());
		
		for(WebElement i:list)
		{
			System.out.println(i.getText());
			if(i.getText().contains("Admin"))
			{
				i.click();
				break;
			}
		}	
	}
	
	public void searchEmpByUsername(String name)
	{
		System.out.println("Search Employee by UserName:"+name);
		driver.findElement(usernametextbox).sendKeys(name);	
		driver.findElement(searchbtn).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.findElement(recordmsg).getText());
		driver.navigate().refresh();
	}
	public void searchEmpByUserRole(String role)
	{		System.out.println("Search Employee by UserRole:"+role);
		driver.findElement(userroledropdown).click();
		//Admin,Ess options you cant able to inspect directly,because they r not showing to inspect
		//for that in DOM,click ctrl+shift+p ,Run->Emulate a focused page(select)->click on inspect icon and move to Admin and click and find locator
		List<WebElement> list=driver.findElements(userROptions);
		for(WebElement i:list)
		{
			if(i.getText().contains(role))
			{
				i.click();
				break;
			}
		}	
		driver.findElement(searchbtn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.findElement(recordmsg).getText());	
		driver.navigate().refresh();
	}
	
	
	public void searchEmpByStatus(String stat)
	{
		System.out.println("Search Employee by Status:"+stat);

		driver.findElement(statusdropdown).click();
		List<WebElement> list=driver.findElements(statusoptions);
		for(WebElement i:list)
		{
			if(i.getText().contains(stat))
			{
				i.click();
				break;
			}
		}
		
		driver.findElement(searchbtn).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(driver.findElement(recordmsg).getText());
		
	}
	
	
}
