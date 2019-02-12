package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends PageBase{

	public CheckoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(linkText="Sign in")
	WebElement signinlink ;

	@FindBy(xpath="//form[@id='login-form']//input[@name='email']")
	WebElement mailTxtField ;

	@FindBy(xpath="//form[@id='login-form']//input[@name='password']")
	WebElement PasswordTxtField ;

	@FindBy(xpath=".//button[@data-link-action='sign-in']")
	WebElement ContinueButton ;

	@FindBy(xpath="//p[contains(text(),'The selected address will be used both as your per')]")
	public WebElement addressHint ;

	@FindBy(xpath="//span[contains(text(),'Delivery fees offered')]")
	public WebElement ShippingHint ;

	@FindBy(xpath="//div[@id='delivery-address']//input[@name='firstname']")
	WebElement FirstName ;

	@FindBy(xpath="//div[@id='delivery-address']//input[@name='lastname']")
	WebElement lastname ;

	@FindBy(xpath="//div[@id='delivery-address']//input[@name='address1']")
	WebElement address1 ;

	@FindBy(xpath="//div[@id='delivery-address']//input[@name='city']")
	WebElement city1 ;

	@FindBy(xpath="//div[@id='delivery-address']//input[@name='postcode']")
	WebElement postcode ;

	@FindBy(xpath="//div[@id='delivery-address']//button[@name='confirm-addresses']")
	WebElement confirmAddresses ;
	
	@FindBy(xpath=".//button[@name='confirm-addresses'][@value='1']")
	WebElement SubmitAddress ;
	
	@FindBy(id="delivery_option_6")
	WebElement ShippingMethod  ;

	@FindBy(xpath="//section[@id='checkout-delivery-step']//button[@name='confirmDeliveryOption']")
	WebElement confirmDeliveryOption ;

	public void openSigninTab() 
	{
		ClickButton(signinlink);
	}

	public void Userlogin(String Mail , String password) 
	{
		SetText(mailTxtField, Mail);
		SetText(PasswordTxtField, password);
		ClickButton(ContinueButton);
	}

	public void FillAddress(String Fname , String LName , String Address , String city , String PostalCode) 
	{
		clearField(FirstName);
		SetText(FirstName, Fname);

		clearField(lastname);
		SetText(lastname, LName);

		clearField(address1);
		SetText(address1, Address);

		clearField(city1);
		SetText(city1, city);

		clearField(postcode);
		SetText(postcode, PostalCode);
	}
	
	public void SubmitAddressForm() 
	{
		ClickButton(confirmAddresses);
	}
	
	public void SubmitAddressSection() 
	{
		ClickButton(SubmitAddress);
	}

	public void CLickOnShippingMethod() 
	{
		checkBox(ShippingMethod);
		ClickButton(confirmDeliveryOption);
	}
	
}

