package pages;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

public class PageBase {

	protected  WebDriver driver;
	public JavascriptExecutor js ;
	public Actions action; 

	//create constructor
	public PageBase(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
	}

	//this method for click button and i use it is the other classes
	protected static void  ClickButton(WebElement button)
	{

		button.click();
		
	}


	//this method for send text and i use it is the other classes
	protected static void  SetText(WebElement txt , String val) 
	{
		txt.sendKeys(val);

	}
	

	//this method for clear text and i use it is the other classes
	protected static void  clearField(WebElement txt) 
	{
		txt.clear();

	}
	
	protected static void  Select(WebElement txt , String val) 
	{
		org.openqa.selenium.support.ui.Select select = new org.openqa.selenium.support.ui.Select(txt);
		select.selectByVisibleText(val);

	}
	
	protected static void  selectlinkfrompage(List<WebElement> list , String val) 
	{

		for(int i = 0 ; i < list.size();  i++) 
		{
			if(list.get(i).getText().equalsIgnoreCase(val)) 
			{
				list.get(i).click();
			}
		}

	}

	protected static void checkBox(WebElement checkbox) 
	{
		if(checkbox.isDisplayed())
		{
			if (!checkbox.isSelected()) 
			{
				checkbox.click();
			}
		} else 
		{
			System.out.println("the checbox not displayed");
		}
	}

	public void ScrollToBottom()
	{
		js.executeScript("window.scrollBy(0,700)");
	}

}