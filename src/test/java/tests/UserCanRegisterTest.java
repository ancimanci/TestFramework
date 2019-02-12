package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcilReader;
import pages.HomePage;
import pages.UserLoginPage;
import pages.UserRegistrationPage;

public class UserCanRegisterTest extends TestBase {

	HomePage homeobject ;
	UserLoginPage loginPageObject ;
	UserRegistrationPage registerPageObject ;
	WebDriverWait wait ;
	
	
	@DataProvider(name="registerdata")
	public Object [][] Logindata() throws IOException
	{
		// get data from exl reader
		ExcilReader reader = new ExcilReader();
		return reader.getExcelData(0, 4) ;

	}
	
	
	@Test(dataProvider="registerdata")
	public void UserCanRegisterSuccessfully(String Fname, String Lname, String mail, String Password) 
	{
		
		homeobject = new HomePage(driver);
		homeobject.openLoginPage();
		loginPageObject = new UserLoginPage(driver);
		loginPageObject.OpenregisterLink();
		registerPageObject = new UserRegistrationPage(driver);
		registerPageObject.UserRegisteration(Fname, Lname, mail , Password);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		homeobject.opneuserDropDown();
		try {
			homeobject.UserLogOut();
		}catch(Exception e)
		{
			System.out.println("Error happened" + e.getMessage());
		}
		
	}
}
