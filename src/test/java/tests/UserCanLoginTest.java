package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterSuite;
import util.WebDriverUtil;
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


public String Avatar = "//a[@class='avatar']";

	@DataProvider(name="logindata")
	public Object [][] Logindata() throws IOException
	{
		// get data from exl reader

		ExcilReader reader = new ExcilReader();
		return reader.getExcelData(0, 2) ;

	}

	
	@Test(dataProvider="logindata")
	public void User_Login(String mail, String Password) {

		HomeObject = new HomePage(driver);
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		HomeObject.openLoginPage();
		LoginObject = new UserLoginPage(driver);
		LoginObject.Userlogin(mail, Password);

		try {

			driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
			WebDriverUtil.waitForVisible(driver, 5, By.xpath(Avatar)).click();

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
