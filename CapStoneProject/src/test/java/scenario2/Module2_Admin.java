package scenario2;

import org.testng.annotations.Test;
//Scenario 2:
//Create a Page Object Model for two pages LoginPage and Admin Page and write automation script
//for Login functionality and Admin search feature
//Create a Page and Class for LoginPage and automate the functionality of OrangeHRM login for Valid
//Test Data: (username: Admin and Password: admin123).
//Create a Page and classfor Admin where you can prepare 4 important test cases
//1. Create testcase to get all 12 options from leftside menu and print the count which should be 12
//from that list click on Admin then Admin page get open.
//2. Create test case for search For Existing Employee searchByUserName() : here send username
//Admin to username text box and click on search button and display total record found and 
//refresh page.
//3. Create test case for search For Existing Employee searchByUserRole() : here automate dropdown
//and select Role Admin and click on search button and display total record found and refresh page.
//4. Create test case for search For Existing Employee searchByUserStatus() : here automate dropdown
//and select status Enabled or Disabled then click on search button and display total record found.
//Note: In the Second scenario use Selenium +TestNG and Design Page Object Model where you can implement Object 
//Oriented Principle
public class Module2_Admin extends Baseclass {
//	1. Create testcase to get all 12 options from leftside menu and print the count which should be 12
	//from that list click on Admin then Admin page get open
	  @Test(priority=1)
	  public void verifyAdmin() 
	  {
		  ap.getMenu();
	  }
	//2. Create test case for search For Existing Employee searchByUserName() : here send username
	//Admin to username text box and click on search button and display total record found and 
	//refresh page.
	  @Test(priority=2)
	  public void VerifySearchWithUsername() 
	  {
		  ap.searchEmpByUsername("Admin");
	  }
	//3. Create test case for search For Existing Employee searchByUserRole() : here automate dropdown
	//and select Role Admin and click on search button and display total record found and refresh page.
	  @Test(priority=3)
	  public void VerifySearchWithUserRole()
	  {
		  ap.searchEmpByUserRole("Admin");
	  }
	//4. Create test case for search For Existing Employee searchByUserStatus() : here automate dropdown
	//and select status Enabled or Disabled then click on search button and display total record found.
	  @Test(priority=4)
	  public void VerifySearchWithUserStatus()
	  {
		  ap.searchEmpByStatus("Enabled");
	  }
}
