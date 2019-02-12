package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ListingPage;
import pages.ProductPage;


public class UserCanSeeProductDescriptionTest extends TestBase {

	HomePage homeObject ;
	ListingPage listPageObject ;
	ProductPage ProductPageObject ;

	@Test
	public void UserSeeProductDescription() throws InterruptedException {
		
		homeObject = new HomePage(driver);
		homeObject.OpenLinkFromMenu();
		listPageObject = new ListingPage(driver);
		Assert.assertTrue(listPageObject.ListingPageCount.getText().contains("Showing 1-12 of 153 item"));

		// click on one product to go to product page

		listPageObject.SelectProduct("Aspire10305");

		// open Deliver info tab

		ProductPageObject = new ProductPage(driver);
		ProductPageObject.opendeliveryInfoTab();
		
		// Assert The data
		Assert.assertTrue(ProductPageObject.deliveryInfoData.getText().contains("Shipping fees include handling and packing fees as well as postage costs. Handling fees are fixed, whereas transport fees vary according to total weight of the shipment. We advise you to group your items in one order. We cannot group two distinct orders placed separately, and shipping fees will apply to each of them. Your package will be dispatched at your own risk, but special care is taken to protect fragile objects"));
	}
}
