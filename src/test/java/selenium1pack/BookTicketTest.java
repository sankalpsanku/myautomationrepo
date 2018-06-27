package selenium1pack;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import pages.LoginPage;
import utility.ExcelUtility;


public class BookTicketTest {
  
	private WebDriver driver;
	private int colNum = 2;
	private int rowNum = 1;
	private static Logger Log = Logger.getLogger(BookTicketTest.class.getSimpleName());
	@Test(priority=1,dataProvider="logindata")
  public void login(String txtusername, String txtpassword) throws Exception {
		try {
		
		Log.info("Entering the username");	
		LoginPage.uname.sendKeys(txtusername);
		Log.info("Entering the password");
		LoginPage.pass.sendKeys(txtpassword);
		LoginPage.login_button.click();
		//Assert.assertEquals("Find a Flight: Mercury Tours:", driver.getTitle());
		ExcelUtility.setExcelData(rowNum, colNum, "Pass");
		rowNum++;
		driver.navigate().back();
		}
		catch(AssertionError e)
		{
			Log.error("assertion error");
			ExcelUtility.setExcelData(rowNum, colNum, "Fail");
		}
		finally {
			rowNum++;
		}
  }
	
	/*@Test(priority=2)
	public void findFlight()
	{
		driver.findElement(By.xpath("/html/body/div/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[5]/td/form/table/tbody/tr[2]/td[2]/b/font/input[2]")).click();
		
		Select passengers = new Select(driver.findElement(By.name("passCount")));	
		passengers.selectByVisibleText("3");
		
		Select from = new Select(driver.findElement(By.name("fromPort")));
		from.selectByVisibleText("London");
		
		Select month = new Select(driver.findElement(By.name("fromMonth")));
		month.selectByVisibleText("August");
		
		Select day = new Select(driver.findElement(By.name("fromDay")));
		day.selectByVisibleText("15");
		
		Select to = new Select(driver.findElement(By.name("toPort")));
		to.selectByVisibleText("Sydney");
		
		driver.findElement(By.name("findFlights")).click();
		
		
	
	}*/
	
	@DataProvider(name="logindata")
	public String[][] login_data() throws Exception
	{
		ExcelUtility.setExcelPath("Sheet1", "C:\\Users\\A06438_P5.Training\\Desktop\\santest\\Sheet1.xlsx");
		//String username = ExcelUtility.getCellData(1, 1);
		//String password = ExcelUtility.getCellData(1, 2);
		String[][] excelData = ExcelUtility.getExcelTable();
		return excelData;
				
			
				
	}
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Selenium Drivers\\chromedriver_win32(1)\\chromedriver.exe\\");
	  driver = new ChromeDriver();
	  //System.setProperty("webdriver.gecko.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Selenium Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	  //driver=new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://newtours.demoaut.com/");
	  PageFactory.initElements(driver, LoginPage.class);
	  DOMConfigurator.configure("Log4j.xml");
  }

  @AfterTest
  public void afterTest() {
  }

}
