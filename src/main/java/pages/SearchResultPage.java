package pages;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultPage extends PageBase{

	public SearchResultPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath="//h2[@class=\"product-title\"]/a")
	List<WebElement> ProductLink ;

	public void ClickOnProductlikFromSearch(String productname)

	{
		int Listsize = ProductLink.size();
		for(int i = 0 ; i < Listsize ; i++) 
		{
			if(ProductLink.get(i).getText().equalsIgnoreCase(productname))
			{
				ProductLink.get(i).click();
			}
		}
	}

}
