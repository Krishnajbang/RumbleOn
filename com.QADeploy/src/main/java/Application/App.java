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
import org.openqa.selenium.support.ui.Select;
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
	boolean valTrue=true;
	
	public void SetUp() throws InterruptedException, FileNotFoundException, IOException
	{
		DOMConfigurator.configure("log4j.xml");
		Log.startTestCase(data.TestCaseDesc+" "+data.TestCaseID);
		String MethodName = Thread.currentThread().getStackTrace()[2].getMethodName();
		System.out.println("Executing: "+MethodName);
		data.getData(MethodName, "D:\\ExcelFile\\TestData.xlsx");
		OpenBrowser(data.Browser);
		captureScreenShot(data.TestCaseID, MethodName);
		Log.info("OpeingBrowser:InfoMainTest");
		NavigateToURL(data.URL);
		captureScreenShot(data.TestCaseID, "");
		Log.debug("Navigate: From Main test");	 
	}
	
	@Test(enabled=true)
	//TC001_Login
	public void TC001_Login() throws InterruptedException, FileNotFoundException, IOException
	{
		System.out.println("1st");
		SetUp();
		LogInPage.LogInWithCredentials(data.UserName, data.Password, data.TestCaseID);
		
	}
	
	@Test
	//TC002_Login
	public void TC002_Login() throws InterruptedException, FileNotFoundException, IOException
	{
		System.out.println("2nd");
		SetUp();
		LogInPage.LogInWithCredentials(data.UserName, data.Password, data.TestCaseID);
	}
	
	@Test
	//TC003_Login
	public void TC003_Login() throws InterruptedException, FileNotFoundException, IOException
	{
		System.out.println("2nd");
		SetUp();
		LogInPage.LogInWithCredentials(data.UserName, data.Password, data.TestCaseID);
	}
	
	@Test
	//TC004_Login
	public void TC004_Login() throws InterruptedException, FileNotFoundException, IOException
	{
		System.out.println("2nd");
		SetUp();
		LogInPage.LogInWithCredentials(data.UserName, data.Password, data.TestCaseID);
	}
	
	@Test
	//TC005_Login
	public void TC005_Login() throws InterruptedException, FileNotFoundException, IOException
	{
		System.out.println("2nd");
		SetUp();
		LogInPage.LogInWithCredentials(data.UserName, data.Password, data.TestCaseID);
	}
	
	
	
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
