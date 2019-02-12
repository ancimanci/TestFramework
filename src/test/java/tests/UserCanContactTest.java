package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import data.ExcilReader;
import pages.ContactUsPage;
import pages.HomePage;

public class UserCanContactTest extends TestBase {

	HomePage HomeObject ;
	ContactUsPage contactusobject ;
	
	
	
	@DataProvider(name="contactdata")
	public Object [][] Logindata() throws IOException
	{
		// get data from exl reader
		ExcilReader reader = new ExcilReader();
		return reader.getExcelData(2, 5) ;

	}
	
	
	@Test(dataProvider="contactdata")
	public void UserCanContactUsMethod(String Fname, String Lname, String Email, String phone,String message)
	{
		HomeObject = new HomePage(driver);
		HomeObject.openContactPage();
		contactusobject = new ContactUsPage(driver);
		//contactusobject.ScrollToBottom();
		contactusobject.SendContactUsForm(Fname, Lname, Email, phone, message);
		
	}
}
