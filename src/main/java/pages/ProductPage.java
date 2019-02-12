package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage extends PageBase{

	public ProductPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//span[@class='input-group-btn-vertical']//button[1]")
	WebElement IncreaseQyt ;
	
	@FindBy(xpath="//span[@class='input-group-btn-vertical']//button[2]")
	WebElement DecreaseQyt ;
	
	@FindBy(xpath="//div[@class='add']//button[@type='submit']")
	WebElement AddToCartButton ;
	
	@FindBy(xpath="//h4[@id='myModalLabel']")
	public WebElement SuccessMessage ;
	
	@FindBy(xpath="//div[@class='modal-header']//button[@type='button']")
	public WebElement Closepopup ;
	
	@FindBy(xpath=".//div[@id='headingDeliveryInformations']/h5/div[1]")
	WebElement deliveryInfo ;
	
	@FindBy(xpath="//div[@class='card-body']//p")
	public WebElement deliveryInfoData ;
	
	
	
	
	public void IncreaseQyt() 
	{
		ClickButton(IncreaseQyt);
	}
	
	public void DecreaseQyt() 
	{
		ClickButton(DecreaseQyt);
	}
	
	public void AddToCart() 
	{
		ClickButton(AddToCartButton);
	}
	
	public void CloseSuccessPopup() 
	{
		ClickButton(Closepopup);
	}
	
	public void opendeliveryInfoTab() 
	{
		ClickButton(deliveryInfo);
	}
	
	
}