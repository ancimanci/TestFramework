package tests;


import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.ExcilReader;
import pages.HomePage;



public class UserCanSubscripeToNewsLettersuccess extends TestBase {

	HomePage HomeObject ;
	public JavascriptExecutor jss ;

	@DataProvider(name="newsLettersuccess")
	public Object [][] Logindata() throws IOException
	{
		ExcilReader reader = new ExcilReader();
		return reader.getExcelData(5, 2) ;

	}


	@Test(dataProvider="newsLettersuccess")
	public void userSubscripeTonewsLettersuccess(String txt , String succ) throws InterruptedException 
	{
		HomeObject = new HomePage(driver);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		Thread.sleep(1000);
		try {
			jss = (JavascriptExecutor)driver;
			jss.executeScript("window.scrollBy(0,1000)");
			HomeObject.WriteinNewsLetter(txt);
			HomeObject.SubscripetoNewslteer();
			Assert.assertTrue(HomeObject.successMessage.getText().contains(succ));
		}catch(Exception e) 
		{
			System.out.println("Error happened " + e.getMessage() );
		}
	}
}