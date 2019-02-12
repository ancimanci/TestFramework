package tests;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ListingPage;

public class UserCanUseFilterBrandInListingPageTest extends TestBase {

	HomePage homeObject ;
	ListingPage listPageObject ;
	
	@Test
	public void UserCanFilterByBrand() throws InterruptedException 
	{
		homeObject = new HomePage(driver);
		homeObject.OpenLinkFromMenu();
		listPageObject = new ListingPage(driver);
		Assert.assertTrue(listPageObject.ListingPageCount.getText().contains("Showing 1-12 of 153 item"));
		listPageObject.OpenBrand();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		listPageObject.FilterByKeiner();
		Assert.assertTrue(listPageObject.ListingPageCount.getText().contains("Showing 1-11 of 11 item(s"));
		
		
	}
}
