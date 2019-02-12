package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase{

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	@FindBy(xpath=".//input[@name='firstname']")
	WebElement firstname ;
	
	@FindBy(xpath=".//input[@name='lastname']")
	WebElement lastname ;
	
	@FindBy(xpath=".//input[@name='email']")
	WebElement emailAddress ;
	
	@FindBy(xpath=".//input[@name='phone']")
	WebElement phonenum;
	
	@FindBy(xpath="//a[@rel='2']")
	WebElement subjectlocator ;
	
	@FindBy(id="Enquiry")
	WebElement YourMessage ;
	
	
	
	public void SendContactUsForm (String Fname , String Lname , String Email , String phone , String message)
	{
		clearField(firstname);
		SetText(firstname, Fname);
		clearField(lastname);
		SetText(lastname, Lname);
		clearField(emailAddress);
		SetText(emailAddress, Email);
		clearField(phonenum);
		SetText(phonenum, phone);
		ClickButton(subjectlocator);
		
	}
	
}
