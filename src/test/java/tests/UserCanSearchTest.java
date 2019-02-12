package tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import data.ExcilReader;
import pages.HomePage;
import pages.SearchPage;

public class UserCanSearchTest extends TestBase{

	HomePage HomeObject ;
	SearchPage searchobject ;
	
	@DataProvider(name="searchData")
	public Object [][] Logindata() throws IOException
	{
		// get data from exl reader
		ExcilReader reader = new ExcilReader();
		return reader.getExcelData(1, 2) ;

	}
	
	@Test(dataProvider="searchData")
	public void UserCanSearchMethod(String searchtxt , String result)
	{
		HomeObject = new HomePage(driver);
		HomeObject.openSearch();
		HomeObject.WriteinSearch(searchtxt);
		HomeObject.clicksearch();
		
		try 
		{
			searchobject = new SearchPage(driver);
			Assert.assertTrue(searchobject.SearchResultCount.getText().contains(result));
		}catch(Exception e) 
		{
			System.out.println("Error happened" + e.getMessage());
		}
		
	}
	
}
