package tests;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ListingPage;
import pages.ProductPage;

public class AddProductTocartTest extends TestBase {


	HomePage homeObject ;
	ListingPage listPageObject ;
	ProductPage ProductPageObject ;

	@Test
	public void AddProductTocartMethod() 
	{
		try {
			// open listing page
			homeObject = new HomePage(driver);
			homeObject.OpenLinkFromMenu();
			listPageObject = new ListingPage(driver);
			Assert.assertTrue(listPageObject.ListingPageCount.getText().contains("Showing 1-12 of 153 item"));

			// click on one product to go to product page

			listPageObject.SelectProduct("Aspire10305");

			// add product to cart

			ProductPageObject = new ProductPage(driver);
			ProductPageObject.IncreaseQyt();
			ProductPageObject.AddToCart();

			// assert the success message

			WebDriverWait wait = new WebDriverWait(driver, 5);
			wait.until(ExpectedConditions.visibilityOf(ProductPageObject.SuccessMessage));

			System.out.print(ProductPageObject.SuccessMessage.getText());
			Assert.assertTrue(ProductPageObject.SuccessMessage.getText().contains("PRODUCT SUCCESSFULLY ADDED TO YOUR"));

			// close the popup
			ProductPageObject.CloseSuccessPopup();
		}catch(Exception e) 
		{
			System.out.println("Error happened"  + e.getMessage());
		}
	}
}

