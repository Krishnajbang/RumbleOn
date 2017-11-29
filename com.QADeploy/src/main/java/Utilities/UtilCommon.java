
package Utilities;

import java.awt.List;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import java.io.IOException;
import java.util.*;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.record.PageBreakRecord.Break;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.interactions.*;



public class UtilCommon{
	static WebElement elementProcess;
	public static WebDriver driver;
	//Logger log = Logger.getLogger("devpinoyLogger");
	
	
	public void OpenBrowser(String browserName)
	{
		String driverPath = "D:/Selenium_Net/drivers/";
		//log.debug("Opening Browser"+browserName);
		
		
		System.out.println("Launching "+browserName+" Browser");
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", driverPath+"chromedriver.exe");
			driver = new ChromeDriver();
		}
		if(browserName.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver", driverPath+"IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		if(browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", driverPath+"MicrosoftWebDriver.exe");
			driver = new EdgeDriver();
		}
		if(browserName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", driverPath+"geckodriver.exe");
			driver = new FirefoxDriver();
		}
		driver.manage().window().maximize();
	}
	
	public void NavigateToURL(String URL)
	{
		System.out.println("Navigating to URL: "+URL);
		driver.navigate().to(URL);
		String strPageTitle = driver.getTitle();
		System.out.println("Page title: - "+strPageTitle);
	}

	public void Highlight(WebElement element)
	{
		if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].setAttribute('style', 'background: yellow; border: 2px solid black;');", element);
	    }
	}

	public void Click(By locator) throws InterruptedException
	{
		Highlight(driver.findElement(locator));
		Thread.sleep(1000);
		driver.findElement(locator).click();
	}
	
	public void CloseCurrentWindow()
	{
		driver.close();
	}
	
	public void CloseAllWindows()
	{
		driver.quit();
	}
	
	public String StoreWindowHandle()
	{
		String windowHandle = driver.getWindowHandle();
		return windowHandle;
	}
	
	public void SwitchToWindow(String Title)
	{
		String NewWindowHandle = "";
		//java.util.List<String> no_of_windows = new ArrayList<String>();
		Set<String> no_of_windows = driver.getWindowHandles();
		for(String eachWindow : no_of_windows)
		{
			if(driver.switchTo().window(eachWindow).getTitle().contains(Title))
			{
				NewWindowHandle = eachWindow;
				break;
			}
		}
		driver.switchTo().window(NewWindowHandle);
	}
	
	public void SelectDropdownByText(By locator , String text)
	{
		Select selectElement = new Select(driver.findElement(locator));
		selectElement.selectByVisibleText(text);
	}
	
	public void SelectDropdownByValue(By locator , String value)
	{
		Select selectElement = new Select(driver.findElement(locator));
		selectElement.selectByValue(value);
	}
	
	public void SelectDropdownByIndex(By locator , int index)
	{
		Select selectElement = new Select(driver.findElement(locator));
		selectElement.selectByIndex(index);
	}
	
	public void HandleAlert(String msg)
	{
		Alert objAlert = driver.switchTo().alert();
		if(msg.equalsIgnoreCase("Accept"))
		{
			objAlert.accept();
		}
		else if(msg.equalsIgnoreCase("Dismiss"))
		{
			objAlert.accept();
		}
	}
	
	public String AlertText()
	{
		Alert objAlert = driver.switchTo().alert();
		objAlert = driver.switchTo().alert();
		return objAlert.getText();
	}
	
	public void MouseHover(By locator)
	{
		Actions builder = new Actions(driver);
        Action mouseOverElement = builder.moveToElement(driver.findElement(locator)).build();
        mouseOverElement.perform();
	}
	
	public void DragAndDrop(By locatorSource ,By locatorDestinaion)
	{
		Actions builder = new Actions(driver);
        Action dragAndDropElement = builder.dragAndDrop(driver.findElement(locatorSource), driver.findElement(locatorDestinaion)).build();
        dragAndDropElement.perform();
	}
	
	public void DoubleClick(By locator)
	{
		Actions builder = new Actions(driver);
        Action doubleClickElement = builder.doubleClick(driver.findElement(locator)).build();
        doubleClickElement.perform();
	}

	public void ScrollDownToPage()
	{
	        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	 
	public void scrollIntoView(By locator)
	{
	        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(locator));
	}
	
	public void MouseHoverJavaScript()
	{
		
	}
	
	//MouseHoverJavaScript
	//CheckCompleteState
	//DragAndDrop
	//ValidateText
	//ClickJavaScript
	//RandomString
	//RandomNumber
	
	
	
//	public void ScrollTo(By locator)
//	{
//		Highlight(driver.findElement(locator));
//		WebElement element = driver.findElement(locator);
//		if (driver instanceof JavascriptExecutor) {
//	        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView(true);”, element);
//	    }
//	}
	
	public static WebElement WaitforElementVisisble(By locator, String stepDescription, int timeoutinSec) throws InterruptedException
	{
		elementProcess = driver.findElement(locator);
	for(int i=0; i<timeoutinSec; i++)
	{
		if(elementProcess.isDisplayed())
		{
			break;
		}
		else
		{
			Thread.sleep(1000);
		}
	}
	Log.info(stepDescription);
	System.out.println(stepDescription);
	return elementProcess;
	}
	
	
	
	public static void captureScreenShot(String path,String imgName)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
	                driver.findElement(By.xpath("//html")), "color: yellow; border: 3px solid yellow;");
	    File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try 
		{
	    	if(imgName!="")
	    	{
	    		FileUtils.copyFile(src, new File("D:/Selenium_Net/"+path+"/"+imgName+".png"));
	    	}
	    	else
	    	{
	    		FileUtils.copyFile(src, new File("D:/Selenium_Net/"+path+"/"+System.currentTimeMillis()+".png"));
	    	}
		}
		catch (IOException e)
		{
			System.out.println(e.getMessage());
		}
	    js.executeScript("arguments[0].setAttribute('style', arguments[1]);",
	                driver.findElement(By.xpath("//html")), "");
	}
	
	public void resultScreenshot(String path)
	{
		ITestResult result = null;
		if(ITestResult.FAILURE==result.getStatus())
		{
			captureScreenShot(path, "FailedAtThisPoint");
		}
	}
}

//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);


