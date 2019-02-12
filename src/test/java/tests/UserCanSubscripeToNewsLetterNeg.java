package tests;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcilReader;
import pages.HomePage;
import pages.MyAccountPage;
import pages.UserLoginPage;


public class UserCanSubscripeToNewsLetterNeg extends TestBase {

	HomePage HomeObject ;
	UserLoginPage LoginObject;
	MyAccountPage MyaccountObject ;
	public JavascriptExecutor jss ;

	@DataProvider(name="newsLetter")
	public Object [][] Logindata() throws IOException
	{
		ExcilReader reader = new ExcilReader();
		return reader.getExcelData(4, 2) ;

	}


	@Test(dataProvider="newsLetter")
	public void userSubscripeTonewsLetter(String txt , String error) throws InterruptedException 
	{
		HomeObject = new HomePage(driver);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
		try {
			jss = (JavascriptExecutor)driver;
			jss.executeScript("window.scrollBy(0,1000)");
			HomeObject.WriteinNewsLetter(txt);
			HomeObject.SubscripetoNewslteer();
			Assert.assertTrue(HomeObject.errorMessage.getText().contains(error));
		}catch(Exception e) 
		{
			System.out.println("Error happened " + e.getMessage() );
		}
	}
}