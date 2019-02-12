package tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ListingPage;


public class UserCanOpenLinkFromMenuTest extends TestBase {

	HomePage homeObject ;
	ListingPage listPageObject ;
	
	@Test
	public void UserCanOpenLinkFromMenu() throws InterruptedException 
	{
		homeObject = new HomePage(driver);
		homeObject.OpenLinkFromMenu();
		listPageObject = new ListingPage(driver);
		Assert.assertTrue(listPageObject.ListingPageCount.getText().contains("Showing 1-12 of 153 item"));
		
	}
}
