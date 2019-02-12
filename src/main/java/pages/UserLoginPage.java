package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase {

	public UserLoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath=".//input[@name='email']")
	WebElement mailTxtField ;

	@FindBy(xpath=".//input[@name='password']")
	WebElement PasswordTxtField ;

	@FindBy(linkText="Forgot your password?")
	WebElement forgetPasswordLink ;

	@FindBy(id="submit-login")
	WebElement LoginButton ;
	
	@FindBy(linkText="No account? Create one here")
	WebElement registerLink ;
	
	

	public void Userlogin(String Mail , String password) 
	{
		SetText(mailTxtField, Mail);
		SetText(PasswordTxtField, password);
		ClickButton(LoginButton);
	}
	
	public void ForgetPassWordMethod() 
	{
		ClickButton(forgetPasswordLink);
	}
	
	public void OpenregisterLink() 
	{
		ClickButton(registerLink);
	}
	
}
