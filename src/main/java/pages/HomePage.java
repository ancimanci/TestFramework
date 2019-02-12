package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}


	// use anotation find by for page factory
	@FindBy(id="searchIco")
	WebElement SearchButton ;

	@FindBy(xpath="//input[@placeholder='Search our catalog']")
	WebElement SearchTextBox ;

	@FindBy(xpath="//button[@type='submit']")
	WebElement Searchsubmit ;

	@FindBy(id="_desktop_user_info")
	WebElement UserLoginLink ;

	@FindBy(id="dropdownMenuButton")
	WebElement UserDropDown ;

	@FindBy(xpath="//a[@class='dropdown-item logout']")
	WebElement UserLogOut ;

	@FindBy(xpath=".//a[@class='dropdown-item account']/i")
	public WebElement UserName ;

	@FindBy(xpath=".//span[contains(text(),'contact us')]")
	WebElement ContactLink ;
	
	@FindBy(xpath="//input[@placeholder='Enter Your email address']")
	WebElement newsletterTxt ;
	
	@FindBy(xpath="//input[@value='Subscribe']")
	WebElement NewsLettericon ;
	
	@FindBy(xpath = "//p[@class='alert alert-danger']")
	public WebElement errorMessage ;
	
	@FindBy(xpath = "//p[@class='alert alert-success']")
	public WebElement successMessage ;
	
	@FindBy(xpath="//span[contains(text(),'shop')]")
	WebElement ShopLink ;

	@FindBy(xpath="//a[contains(@class,'category-sub-link')][contains(text(),'Accessories (153)')]")
	WebElement Accessories ;
	
	@FindBy(xpath=".//*[@id=\"_desktop_cart\"]/div[1]/div/a")
	WebElement CartLink ;
	
	
	public void openLoginPage() 
	{
		ClickButton(UserLoginLink);
	}

	public void opneuserDropDown() 
	{
		ClickButton(UserDropDown);
	}

	public void UserLogOut() 
	{
		ClickButton(UserLogOut);
	}

	public void openSearch() 
	{
		ClickButton(SearchButton);
	}

	public void WriteinSearch(String Searchtext) 
	{
		SetText(SearchTextBox , Searchtext);
	}

	public void clicksearch() 
	{
		ClickButton(Searchsubmit);
	}
	
	public void openContactPage() 
	{
		ClickButton(ContactLink);
	}
	
	public void WriteinNewsLetter(String txt) 
	{
		clearField(newsletterTxt);
		SetText(newsletterTxt , txt);
	}
	
	public void SubscripetoNewslteer() 
	{
		ClickButton(NewsLettericon);
	}
	
	public void OpenLinkFromMenu() throws InterruptedException 
	{
		action.moveToElement(ShopLink).moveToElement(Accessories);
		Thread.sleep(3000);
		action.click()
		.build()
		.perform();
	}

	public void GoToCartPage() 
	{
		ClickButton(CartLink);
	}
}
