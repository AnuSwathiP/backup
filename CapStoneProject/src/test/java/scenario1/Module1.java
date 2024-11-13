package scenario1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import generic.Utility;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
//Scenario1: Automate Orange HRM login and logout with 5 different data set including valid and invalid data set.
//1. Save data set in Excel file
//2. Write a script to read data from excel
//3. Prepare script for Login and logout
//4. Perform assertion for valid data set (use Username: Admin and Password:admin123) test case should be pass
//and invalid data set (other than given data) test case should be fail.
//5. Capture Screenshot for every login functionality
//6. Generate Extent Report for the same.
public class Module1 {

	String fPath = System.getProperty("user.dir") + "\\ExcelFiles\\ORHRM_Credentails.xlsx";
	//String fPath ="";
	        File file;
	    FileInputStream fis;
	    FileOutputStream fos;
	    XSSFWorkbook wb;
	    XSSFSheet sheet;
	    XSSFRow row;
	    XSSFCell cell;
	    int k = 1;

	    WebDriver driver;
	
	    String expUrl = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index", actUrl;
	    
	    ExtentSparkReporter htmlReport;
	    ExtentReports report;

	    ExtentTest test;
	    @Test(dataProvider = "getLoginData")
  public void loginToOHRM(String un, String ps) {
      driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(un);
      driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(ps);
      Utility.getScreenshot();
      driver.findElement(By.xpath("//button[@type='submit']")).submit();
      actUrl = driver.getCurrentUrl();
      Assert.assertEquals(actUrl, expUrl, "Invalid User name or password");
      
      
  }
	  //ITestResult is interface ,ITestResult result,result.getStatus() will give the method test result
  @AfterMethod
  public void afterMethod(ITestResult result) {
      row = sheet.getRow(k);
      cell = row.getCell(2);


      if(driver.getCurrentUrl().contains("dash"))//logout
      {
          System.out.println("Test case Pass");
          driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/header[1]/div[1]/div[3]/ul[1]/li[1]/span[i]/i[1]")).click();
          driver.findElement(By.partialLinkText("Log")).click();
          cell.setCellValue("Pass");
      }
      else//invalid credentials
      {
          System.out.println("Test case fail because of: " + driver.findElement(By.xpath("//p[text()=\"Invalid credentials\"]")).getText());
          cell.setCellValue("Fail");
      }
      k++;
      
      //result.getName() gives method name
      if(result.getStatus() == ITestResult.SUCCESS)
          test.log(Status.PASS, MarkupHelper.createLabel(result.getName(), ExtentColor.GREEN));
      else if(result.getStatus() == ITestResult.FAILURE)
          test.log(Status.FAIL, MarkupHelper.createLabel(result.getName(), ExtentColor.RED));
      else if(result.getStatus() == ITestResult.SKIP)
          test.log(Status.SKIP, MarkupHelper.createLabel(result.getName(), ExtentColor.YELLOW));
  }
  


  @DataProvider
  public Object[][] getLoginData() {
      int totalRows = sheet.getPhysicalNumberOfRows();
      String[][]loginData = new String[totalRows-1][2];//because we dont n

      for(int i = 0; i < totalRows-1; i++)//i is not equal to 1 because in loginData[0][j] we have to store 0 value also
          //totalRows-1 otherwise last value will be  null because of i+1
      {
          row = sheet.getRow(i+1);//header is not required so i+1 from starting
          for(int j = 0; j < 2; j++) //j means username,password
          {
              cell = row.getCell(j);
              loginData[i][j] = cell.getStringCellValue(); //store in this and return
          }
      }
      return loginData;
  }
  @BeforeTest
  public void beforeTest() throws IOException {
      file = new File(fPath);
      fis = new FileInputStream(file);
      wb = new XSSFWorkbook(fis);
      sheet = wb.getSheetAt(0);//call the sheet with index also
      fos = new FileOutputStream(file);

      htmlReport = new ExtentSparkReporter("MyNewReport.html");
      report = new ExtentReports();
      report.attachReporter(htmlReport);

      report.setSystemInfo("Machine Name", "Dell");
      report.setSystemInfo("Tester", "Anuswathi");
      report.setSystemInfo("OS", "Windows 11");
      report.setSystemInfo("Browser", "Google Chrome");

      //Configuration of Look and feel of report
      htmlReport.config().setDocumentTitle("My First Extent Report");
      htmlReport.config().setReportName("Google Report");
      htmlReport.config().setTheme(Theme.STANDARD);
      htmlReport.config().setTimeStampFormat("EEEE MMM dd, yyyy HH:mm:ss");
      
      test = report.createTest("Orange HRM Test");
      
      driver = new ChromeDriver();
      driver.manage().window().maximize();
      driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
      driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
      Utility.driver=driver;
  }

  @AfterTest
  public void afterTest() throws IOException {
      wb.write(fos);
      wb.close();
      fis.close();
      driver.close();
      report.flush();
  }
}
