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

	@FindBy(xpath="//a[contains(@href,'login')]")
	WebElement UserLoginLink ;

	public void openLoginPage()
	{
		ClickButton(UserLoginLink);
	}

}
