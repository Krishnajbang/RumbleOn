package PageObjects;
import org.openqa.selenium.*;

import Utilities.Log;
import Utilities.UtilCommon;

public class LogInPage extends UtilCommon{

	public static By ButtonSignUp = By.xpath("//div[@class='sticknav']//a[contains(text(),'SIGN IN / SIGN UP')]");
	public static By ButtonCustomer = By.xpath("//a[contains(text(),'CUSTOMER')]");
	public static By WebEditUserName = By.xpath("//input[@id='user_name']");
	public static By WebEditPassword = By.xpath("//input[@id='login_password']");
	public static By ButtonLogin  = By.xpath("//button[@id='btnLogin']");
	public static By ProfilePic = By.xpath("//div[@class='sticknav']//div[@class='profile_pic']");

	public static void LogInWithCredentials(String Username, String Password, String ScreenshotPath) throws InterruptedException
	{
		WaitforElementVisisble(ButtonSignUp, "Clicking on Sign-Up Button", 30).click();
		WaitforElementVisisble(ButtonCustomer, "Clicking on Customer Button", 30).click();
		WaitforElementVisisble(WebEditUserName, "Entering User Name", 30).sendKeys(Username);
		WaitforElementVisisble(WebEditPassword, "Entering Password", 30).sendKeys(Password);
		WaitforElementVisisble(ButtonLogin, "Clicking on LogIn Button", 30).click();
		Thread.sleep(10000);
		WaitforElementVisisble(ProfilePic, "Customer profile check for login", 30).isDisplayed();
		captureScreenShot(ScreenshotPath, "LoginOnce");
	}
	
	public static void LogInWithGoogle(String Username, String Password, String ScreenshotPath) throws InterruptedException
	{
		WaitforElementVisisble(ButtonSignUp, "Clicking on Sign-Up Button", 30).click();
		WaitforElementVisisble(ButtonCustomer, "Clicking on Customer Button", 30).click();
		
	}
}
