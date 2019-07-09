package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import util.WebDriverUtil;

public class AccountPage extends PageBase {

    public AccountPage(WebDriver driver) {
        super(driver);
        js = (JavascriptExecutor) driver;
        action = new Actions(driver);
    }


    @FindBy(xpath = "//div/h2/a")
    public WebElement NewButton;

    }
