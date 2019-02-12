package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShopingCartPage extends PageBase {

	public ShopingCartPage(WebDriver driver) {
		super(driver);
		
	}

	@FindBy(xpath=".//a[@class=\"remove-from-cart\"]")
	public WebElement removeIcon ;
	
	@FindBy(xpath="//span[@class='no-items']")
	public WebElement assertMessage ;
	
	@FindBy(xpath="//a[@class='btn btn-primary']")
	WebElement GoToCheckOutButton ;
	
	public void removeFromCart() 
	{
		ClickButton(removeIcon);
	}
	
	public void GoToCheckOut() 
	{
		ClickButton(GoToCheckOutButton);
	}
}
