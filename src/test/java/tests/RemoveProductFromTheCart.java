package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ShopingCartPage;

public class RemoveProductFromTheCart extends TestBase {

	HomePage homepageObject ;
	ShopingCartPage ShopingCartPageObject ;

	@Test
	public void RemoveFromCartMethod() {
		try {
			// add product to cart
			AddProductTocartTest AddProductTocartTestObject2 = new AddProductTocartTest();
			AddProductTocartTestObject2.AddProductTocartMethod();


			// here open cart page
			homepageObject = new HomePage(driver);
			driver.navigate().to("http://mazloum-home.netservex.com/cart?action=show");
			//homepageObject.GoToCartPage();

			// remove from cart

			ShopingCartPageObject = new ShopingCartPage(driver);
			ShopingCartPageObject.removeFromCart();


			Assert.assertTrue(ShopingCartPageObject.assertMessage.getText().contains("There are no more items in your cart"));
		} catch(Exception e) 
		{
			System.out.println("Error happened"  + e.getMessage());
		}
	}
}
