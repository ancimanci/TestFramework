package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcilReader;
import pages.CheckoutPage;
import pages.HomePage;
import pages.ShopingCartPage;

public class CreateOrderTest extends TestBase{

	
	@DataProvider(name="logindata")
	public Object [][] Logindata() throws IOException
	{
		// get data from exl reader
		ExcilReader reader = new ExcilReader();
		return reader.getExcelData(0, 4) ;
	}
	
	
	HomePage homepageObject ;
	ShopingCartPage ShopingCartPageObject ;
	CheckoutPage CheckoutPageObject ;
	WebDriverWait wait ;
	
	@Test(dataProvider="logindata")
	public void CreateOrderMethod(String Fname, String Lname, String mail, String Password)  
	{
		
		ShopingCartPageObject = new ShopingCartPage(driver);

		 // add product to cart
		AddProductTocartTest AddProductTocartTestObject2 = new AddProductTocartTest();
		AddProductTocartTestObject2.AddProductTocartMethod();
		
		
		// here open cart page
		homepageObject = new HomePage(driver);
		driver.navigate().to("http://mazloum-home.netservex.com/cart?action=show");
		
		
		// go to checkout page
		ShopingCartPageObject.GoToCheckOut();
		
		
		CheckoutPageObject = new CheckoutPage(driver);
		// open sign in tab
		CheckoutPageObject.openSigninTab();
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		
		// enter your data and click continue
		CheckoutPageObject.Userlogin(mail , Password);
		
		// start enter the address
		wait = new WebDriverWait(driver, 3);
		wait.until(ExpectedConditions.visibilityOf(CheckoutPageObject.addressHint));
		
		CheckoutPageObject.FillAddress("meena", "antoun", "61 al ades al sharif", "Mohandseen" , "55412");
		
		// submit Address Form
		CheckoutPageObject.SubmitAddressForm();
		
		// submit Address Section
		CheckoutPageObject.SubmitAddressSection();
		
		// choose the shipping
		wait.until(ExpectedConditions.visibilityOf(CheckoutPageObject.ShippingHint));
		
		CheckoutPageObject.CLickOnShippingMethod();
		
	}
}
