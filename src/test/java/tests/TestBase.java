package tests;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import utilities.Helper;

public class TestBase{

	//this better to be static
	public static WebDriver driver;

	/*the parameter come from testng.xml 
	 * we add option i case i dont give parameter from xml file 
	 */

	@BeforeSuite
	@Parameters({"Browser"})
	public void startDriver(@Optional("chrome") String BrowserName) 
	{
		if(BrowserName.equalsIgnoreCase("Firefox")) 
		{
			System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		} else if (BrowserName.equalsIgnoreCase("chrome")) 
		{
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver2.38.exe");
			driver = new ChromeDriver();
		} 

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		driver.get("https://github.com/");
		driver.manage().deleteAllCookies();

	}
	
	// this will check after every method when test case fail take screenshot
	@AfterMethod
	public void TakeScreen(ITestResult result)
	{
		if(ITestResult.FAILURE == result.getStatus()) 
		{
			System.out.println("failed");
			System.out.println("Taking Screenshot...");
			Helper.CapureScreenShot(driver, result.getName());
		}
	}


	
	@BeforeClass
	public void waitshoya2() 
	{
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
	}
	
	@AfterSuite
	public void stopDriver() 
	{
		driver.quit();
	}
}
