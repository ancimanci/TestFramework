package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class UserLoginPage extends PageBase {
	public UserLoginPage(WebDriver driver) {
		super(driver);
		js = (JavascriptExecutor) driver;
		action = new Actions(driver);
	}


	@FindBy(xpath="//input[@id='login_field']")
	WebElement mailTxtField ;

	@FindBy(xpath="//input[@id='password']")
	WebElement PasswordTxtField ;

	@FindBy(xpath="//*[@id='login']//a[@class='label-link']")
	WebElement forgetPasswordLink ;


	@FindBy(xpath="//input[@type='submit']")
	WebElement LoginButton ;




	public void Userlogin(String Mail , String password)
	{
		SetText(mailTxtField, Mail);
		SetText(PasswordTxtField, password);
		ClickButton(LoginButton);

	}



	public void UserClick()
	{
		ClickButton(LoginButton);
	}
	public void ForgetPassWordMethod()
	{
		ClickButton(forgetPasswordLink);
	}

}
