package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends PageBase {

	public SearchPage(WebDriver driver) {
		super(driver);
	}


	@FindBy(xpath=".//nav[@class='pagination']/div[1]")
	public WebElement SearchResultCount ;
	
	
}