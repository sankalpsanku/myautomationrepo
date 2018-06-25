package selenium1pack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.LoginPage;
import utility.ExcelUtility;


public class BookTicketTest {
  
	WebDriver driver;
	
	@Test(priority=1,dataProvider="logindata")
  public void login(String txtusername, String txtpassword) {
		LoginPage.uname.sendKeys(txtusername);
		LoginPage.pass.sendKeys(txtpassword);
		LoginPage.login_button.click();
				
  }
	
	@DataProvider(name="logindata")
	public String[][] login_data() throws Exception
	{
		ExcelUtility.setExcelPath("Sheet1", "C:\\Users\\A06438_P5.Training\\Desktop\\santest\\Sheet1.xlsx");
		String username = ExcelUtility.getCellData(1, 1);
		String password = ExcelUtility.getCellData(1, 2);
		return new String[][]
				{
			new String[] {username, password}
				};
	}
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.gecko.driver", "C:\\Users\\A06438_P5.Training\\Desktop\\Selenium Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");
	  driver=new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  driver.get("http://newtours.demoaut.com/");
	  PageFactory.initElements(driver, LoginPage.class);
  }

  @AfterTest
  public void afterTest() {
  }

}
