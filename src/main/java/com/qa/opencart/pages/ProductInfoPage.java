package com.qa.opencart.pages;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtil;

public class ProductInfoPage {
	
	private WebDriver driver;
	private ElementUtil eleUtil;
	private Map<String,String> productMap=new LinkedHashMap<String,String>();

	// 1. Private By Locators

	private By productHeader = By.tagName("h1");
	private By images=By.cssSelector("//ul[@class='thumbnails']/li");
    private By productMetaData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[1]/li");
   private By productPriceData=By.xpath("(//div[@id='content']//ul[@class='list-unstyled'])[2]/li");
   
    		
    		// 2. Public Page Class Const...
	public ProductInfoPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}
	public String getProductHeader()
	{
		String Header=eleUtil.doGetElementText(productHeader);
		System.out.println(Header);
		return Header;
	}
	public int getProductImagesCount()
	{
		int totalImages=eleUtil.waitForElementsVisible(images, 10).size();
		System.out.println(totalImages);
		return totalImages;
	}
	public void getProductMetaData()
	{
		List<WebElement> metaList = eleUtil.getElements(productMetaData);
		for(WebElement e:metaList)
		{
			String t=e.getText();
			String metaKey=t.split(":")[0].trim();
			String metaValue=t.split(":")[1].trim();
			productMap.put(metaKey, metaValue);
		}
		}
	
	public void getProductPriceData()
	{
		List<WebElement> priceList = eleUtil.getElements(productPriceData);
		String price=priceList.get(0).getText();
		String exTaxPrice=priceList.get(1).getText().split(":")[1].trim();
		productMap.put("productPrice", price);
		productMap.put("exTaxPrice", exTaxPrice);
		}
	
	public Map<String,String> getProductDetailMap()
	{
		productMap.put("header", getProductHeader());
		productMap.put("productImages",String.valueOf(getProductImagesCount()));
		getProductMetaData();
		getProductPriceData();
		return productMap;
	}
	

}
