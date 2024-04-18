package com.qa.opencart.Test;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ProductPageInfoTest extends BaseTest{

	
	@BeforeClass
	public void accSetup() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@DataProvider
	public  Object[][]getproductsearchdata()
	{
		return new Object[][]
				{
					{"Macbook","MacBook Pro"},
					
				};
	}
	@Test(dataProvider="getproductsearchdata")
	public void ProductHeaderTest(String sk,String pn)
	{
		searchResultsPage=accPage.doSearch(sk);
		productInfoPage=searchResultsPage.selectProduct(pn);
		Assert.assertEquals(productInfoPage.getProductHeader(), pn);
	}
	@Test
	public void ProductInfoTest()
	{
		searchResultsPage=accPage.doSearch("macbook");
		productInfoPage=searchResultsPage.selectProduct("MacBook Pro");
		Map<String ,String> productActDetailsPage=productInfoPage.getProductDetailMap();
		Assert.assertEquals(productActDetailsPage.get("Brand"),"Apple");
	}
}
