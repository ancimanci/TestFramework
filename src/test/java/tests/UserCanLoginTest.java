package tests;

import org.testng.annotations.AfterSuite;
import pages.AccountPage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import data.ExcilReader;
import pages.HomePage;
import pages.UserLoginPage;


public class UserCanLoginTest extends TestBase {


	HomePage HomeObject ;
	UserLoginPage LoginObject;
	AccountPage AccountObject;


	@DataProvider(name="logindata")
	public Object [][] Logindata() throws IOException
	{
		// get data from exl reader

		ExcilReader reader = new ExcilReader();
		return reader.getExcelData(0, 2) ;

	}

	
	@Test(dataProvider="logindata")
	public void User_Login(String mail, String Password) throws InterruptedException
	{

		HomeObject = new HomePage(driver);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		HomeObject.openLoginPage();
		LoginObject = new UserLoginPage(driver);
		LoginObject.Userlogin(mail, Password);

		try {

			driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
			AccountObject = new AccountPage(driver);
			Assert.assertTrue(AccountObject.NewButton.getText().contains("New"));


		} catch (Exception e) {
			System.out.println("Error happened" + e.getMessage());
		}

	}
	@AfterSuite
	public void stopDriver()
	{
		driver.quit();
	}
}
