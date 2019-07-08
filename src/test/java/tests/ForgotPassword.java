package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserLoginPage;
import util.WebDriverUtil;

import java.util.concurrent.TimeUnit;


public class ForgotPassword extends TestBase {

    HomePage HomeObject ;
    UserLoginPage LoginObject;
    @FindBy(xpath="//input[@id='email_field']")
    WebDriver webmail;


    @Test
    public void ForgotPassword()
    {
        HomeObject = new HomePage(driver);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        HomeObject.openLoginPage();
        LoginObject = new UserLoginPage(driver);
        LoginObject.ForgetPassWordMethod();
        try {

            driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
            Assert.assertTrue(WebDriverUtil.isElementDisplayed(driver, By.xpath("//input[@id='email_field']")));

        }catch(Exception e)
        {
            System.out.println("Error happened" + e.getMessage());
        }
    }
    @AfterMethod
    public void close(){
        driver.close();

    }

}

