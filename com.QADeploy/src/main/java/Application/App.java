package Application;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import org.apache.bcel.generic.IF_ACMPEQ;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.xalan.xsltc.DOM;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.w3c.dom.DOMConfiguration;





import Utilities.*;
import PageObjects.*;


public class App extends UtilCommon{

	ExcelFunctionality data = new ExcelFunctionality();
	
	
	
	@BeforeMethod
	public void SetUp() throws InterruptedException, FileNotFoundException, IOException
	{
		//commit aa
		data.getData("TC002", "D:\\ExcelFile\\RumbleOnData.xlsx");
		System.out.println("Printed Value from data "+data.Browser);
		System.out.println("Printed Value from data "+data.Environment);
		System.out.println("Printed Value from data "+data.TestCaseDesc);
		System.out.println("Printed Value from data "+data.Title);
		System.out.println("Printed Value from data "+data.URL);
		System.out.println("Printed Value from data "+data.UserName);
		System.out.println("Printed Value from data "+data.Password);
		
		
		DOMConfigurator.configure("log4j.xml");
		
		OpenBrowser(data.Browser);
		captureScreenShot(data.TestCaseID, "");
		Log.info("OpeingBrowser:InfoMainTest");
		Thread.sleep(10000);
		NavigateToURL(data.URL);
		captureScreenShot(data.TestCaseID, "");
		Log.debug("Navigate: From Main test");	
	}
	
	
	@Test 
	public void TC001_Login() throws InterruptedException
	{
		LogInPage.LogInWithCredentials(data.UserName, data.Password, data.TestCaseID);
	}
	
	//test
//	@Test 
//	public void TC002_SignUp() throws InterruptedException
//	{
//		WaitforElementVisisble(By.xpath("//div[@class='sticknav']//a[contains(text(),'SIGN IN / SIGN UP')]"), "Clicking on Sign Up Button", 60).click();
//		
//		
//		WebElement element = driver.findElement(By.xpath("//div[@class='sticknav']//a[contains(text(),'SIGN IN / SIGN UP')]"));
//		Click(element);
//		//driver.findElement(By.xpath("//div[@class='sticknav']//a[contains(text(),'SIGN IN / SIGN UP')]")).click();
//		element = driver.findElement(By.xpath("//p[contains(text(),'Don’t have an account? ')]/span"));
//		Click(element);
//		//driver.findElement(By.xpath("//p[contains(text(),'Don’t have an account? ')]/span")).click();
//		element = driver.findElement(By.xpath("//input[@id='first_name']"));
//		Highlight(element);
//		driver.findElement(By.xpath("//input[@id='first_name']")).sendKeys("TestUser1");
//		driver.findElement(By.xpath("//input[@id='last_name']")).sendKeys("TestLastName");
//		driver.findElement(By.xpath("//input[@id='phone_number']")).sendKeys("9197490012");
//		driver.findElement(By.xpath("//input[@id='email_id']")).sendKeys("newuser1234@gmail.com");
//		driver.findElement(By.xpath("//input[@id='signup_password']")).sendKeys("Pass1234");
//		driver.findElement(By.xpath("//input[@id='signup_Cpassword']")).sendKeys("Pass1234");
//		driver.findElement(By.xpath("//input[@id='zip_code']")).sendKeys("75063");
//		Thread.sleep(20000);
//		driver.findElement(By.id("btnsignup")).click();
//		Thread.sleep(20000);
//		String regText = driver.findElement(By.xpath("//p[@id='pAlertMessage']")).getText();
//		assertEquals(regText, "You have registered successfully.");
//		driver.findElement(By.xpath("//div[@id='divAlertPopUp']//button[@id='btnOk']")).click();
//		Thread.sleep(5000);
//		driver.findElement(By.xpath("//div[@class='sticknav']//div[@class='profile_pic']")).click();
//		
//		
//		List<WebElement> MyAccountList = driver.findElements(By.xpath("//a[text()='My Account']"));
//		
//		for (WebElement webElement : MyAccountList) {
//			if(webElement.isDisplayed())
//			{
//				webElement.click();
//			}
//			
//		}
//		
//		Thread.sleep(20000);
//	}
	
	
	@AfterMethod
	public void tearDown() {
		if(driver!=null) {
			//resultScreenshot(data.TestCaseID);
			Log.info("BrowserClose: From Main test");
			System.out.println("SysOut: Closing Browser");
			driver.quit();
		}
	}
	
}
