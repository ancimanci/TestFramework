package pages;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class InvalidLogin extends PageBase {

    public InvalidLogin(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }


    @FindBy(xpath = "//*[@id='js-flash-container']")
    public WebElement IncorrectElement;

}
