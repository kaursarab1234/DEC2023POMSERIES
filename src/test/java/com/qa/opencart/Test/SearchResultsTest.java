package com.qa.opencart.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SearchResultsTest extends BaseTest{
	@BeforeClass
	public void searchResultSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@DataProvider
	public  Object[][]getproductcountdata()
	{
		return new Object[][]
				{
					{"Macbook",3},
					
				};
	}

	@Test(dataProvider="getproductcountdata")
	public void searchResultTest(String sk,int pc)
	{
		searchResultsPage=accPage.doSearch(sk);
		Assert.assertEquals(searchResultsPage.getSearchProductCount(),pc);
	}
}
