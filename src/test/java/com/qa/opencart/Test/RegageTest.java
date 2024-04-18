package com.qa.opencart.Test;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;
import com.qa.opencart.utils.StringUtils;

public class RegageTest extends BaseTest{
	@BeforeClass
	public void regSetup()
	{
		regPage=loginPage.registerPage();
	}
	@DataProvider
	public  Object[][]getproductcountdata()
	{
		return new Object[][]
				{
					{"k","k","1234567890","kk@123","yes"}
					
				};
	}
	@DataProvider
	public  Object[][] getSheetData()
	{
		return ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
	}
	@Test(dataProvider= "getproductcountdata")
	public void userRegTest(String fn,String ln,String tno,String pswd,String Subscribe)
	{
		Assert.assertTrue(regPage.userRegister(fn,ln, StringUtils.getRandomemailId(),tno, pswd, Subscribe));
	}

}
