package selenium;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectBaseDropDown_2 {
	//DropDown Automation
//	1)<select> based dropdown
//	Select class is used to handle a Dropdown List (Combobox) or List Box
//	Note: DROPDOWN LIST IS HAVING <select>HTML TAG.
//	2)Dynamic/Auto-Suggestive/Bootstrap DropDown ,<UI>,<li>,<div>,<button>


//Methods
//1. getFirstSelectedOption() => Return the selected element from dropdown list. (WebElement)
	//To get all options from dropdown
//2. getOptions() => Return list of all the elements / options from the dropdown list. (List<WebElement>)
	//To select single value
//3. selectByVisibleText() => Selects the option with its text. 
//4. selectByValue() => You can pass the value of attribute value for selecting the option.
//5. selectByIndex() => You need to pass the index of element. 
	//To test drop down support multiple values selection
//6. isMultiple() => Returns true if it is Listbox & returns false if it is Dropdown list (boolean)
//7. getAllSelectedOptions() => Returns list of all the selected items from Listbox 
//8.deselectByIndex
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
         WebDriver driver = new ChromeDriver();
         driver.get("https://www.amazon.in/");
         //locator
         WebElement Element1 = driver.findElement(By.id("searchDropdownBox"));
         //Selenium webdriver provides Select Class which can be used only for dropdown created using <select> HTML TAG
         Select dropdown = new Select(Element1);
         System.out.println("Is dropdown support Multiple values:"+dropdown.isMultiple());
         //To select single value
         dropdown.selectByIndex(3);
         //static wait in selenium is thread.sleep
         Thread.sleep(2000);
         dropdown.selectByValue("search-alias=todays-deals");
         Thread.sleep(2000);
         dropdown.selectByVisibleText("Prime Video");
         //all options
         //List is a collection interface and ale=ways return in order list and duplicacy allowed
         List<WebElement> alloptions =dropdown.getOptions();
         System.out.println("Total options are:"+alloptions.size());
         for(WebElement i :alloptions)
         {
        	 System.out.println(i.getText());
        	 if(i.getText().contains("Video Games"))
        	 {
        		 i.click();
        		 break;
        	 }
         }
         
         
	}

}
