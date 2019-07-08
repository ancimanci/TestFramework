package tests;

import org.openqa.selenium.By;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.UserLoginPage;
import util.WebDriverUtil;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;



public class Loginwithoutcredentials  extends TestBase {

        HomePage HomeObject ;
        UserLoginPage LoginObject;



        @Test
        public void UserNoCredentials()throws InterruptedException
        {
            HomeObject = new HomePage(driver);
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            HomeObject.openLoginPage();
            LoginObject = new UserLoginPage(driver);
            LoginObject.UserClick();
            try {

                driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);
           // Assert.assertTrue(WebDriverUtil.isElementDisplayed(driver, ));

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
