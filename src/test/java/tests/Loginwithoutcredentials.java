package tests;

import data.ExcilReader;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.MyAccountPage;
import pages.UserLoginPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Loginwithoutcredentials  extends TestBase {

        HomePage HomeObject ;
        UserLoginPage LoginObject;
        MyAccountPage MyaccountObject ;


        @Test
        public void UserNoCredentials()
        {
            HomeObject = new HomePage(driver);
            driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
            HomeObject.openLoginPage();
            LoginObject = new UserLoginPage(driver);
            LoginObject.UserClick();
            try {

                driver.manage().timeouts().pageLoadTimeout(3, TimeUnit.SECONDS);

                MyaccountObject = new MyAccountPage(driver);
                Assert.assertTrue(MyaccountObject.PageTitle.getText().equalsIgnoreCase("Your account"));
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
