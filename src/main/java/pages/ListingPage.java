package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ListingPage extends PageBase {

	public ListingPage(WebDriver driver) {
		super(driver);

	}

	@FindBy(xpath=".//nav[@class='pagination']/div[1]")
	public WebElement ListingPageCount;

	@FindBy(xpath="//span[contains(text(),'Brand')]")
	WebElement BrandLink;

	@FindBy(xpath="//div[@class='product-description']/h2/a")
	public List<WebElement> ProductName;

	@FindBy(linkText="Aspire (11)")
	WebElement Brandasspier ;

	public void OpenBrand() 
	{
		ClickButton(BrandLink);
	}

	public void FilterByKeiner() 
	{

		ClickButton(Brandasspier);
	}

	public void SelectProduct(String productN) 
	{
		selectlinkfrompage(ProductName, productN);
	}


}
