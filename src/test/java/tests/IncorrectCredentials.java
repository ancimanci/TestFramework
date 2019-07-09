package tests;

import org.testng.annotations.AfterSuite;
import pages.AccountPage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import data.ExcilReader;
import pages.HomePage;
import pages.UserLoginPage;
import pages.InvalidLogin;


public class IncorrectCredentials extends TestBase {


    HomePage HomeObject ;
    UserLoginPage LoginObject;
    InvalidLogin InvalidObject;


    @DataProvider(name="logindata")
    public Object [][] Logindata() throws IOException
    {
        // get data from exl reader

        ExcilReader reader = new ExcilReader();
        return reader.getExcelData(1, 2) ;

    }


    @Test(dataProvider="logindata")
    public void User_Login(String mail, String Password) throws InterruptedException
    {

        HomeObject = new HomePage(driver);
        driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
        HomeObject.openLoginPage();
        LoginObject = new UserLoginPage(driver);
        LoginObject.Userlogin(mail, Password);

        try {

            driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
            InvalidObject = new pages.InvalidLogin(driver);
            Assert.assertTrue(InvalidObject.IncorrectElement.getText().contains("Incorrect"));


        } catch (Exception e) {
            System.out.println("Error happened" + e.getMessage());
        }

    }
    @AfterSuite
    public void stopDriver()
    {
        driver.quit();
    }
}
