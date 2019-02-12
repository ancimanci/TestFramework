package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UserRegistrationPage extends PageBase {

	public UserRegistrationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//input[@value='1']")
	WebElement genderMaleRadio;

	@FindBy(xpath="//input[@value='2']")
	WebElement genderfemaleRadio;

	@FindBy(xpath="//input[@name='firstname']")
	WebElement Firstname_txt_Box;

	@FindBy(xpath="//input[@name='lastname']")
	WebElement LastName_txt_Box;

	@FindBy(xpath="//input[@name='email']")
	WebElement Email_txt_Box;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement Password_txt_Box;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement registerButton_btm;
	

	public void UserRegisteration(String firstname , String lastname , String email , String password) 
	{
		ClickButton(genderMaleRadio);
		clearField(Firstname_txt_Box);
		SetText(Firstname_txt_Box, firstname);
		clearField(LastName_txt_Box);
		SetText(LastName_txt_Box, lastname);
		clearField(Email_txt_Box);
		SetText(Email_txt_Box, email);
		clearField(Password_txt_Box);
		SetText(Password_txt_Box, password);
		ClickButton(registerButton_btm);
	}
	
	


}
