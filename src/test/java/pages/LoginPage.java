package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	@FindBy(how = How.NAME, using="userName")
	public static WebElement uname;
	
	@FindBy(how = How.NAME, using="password")
	public static WebElement pass;
	
	@FindBy(how = How.NAME, using="login")
	public static WebElement login_button;
}
