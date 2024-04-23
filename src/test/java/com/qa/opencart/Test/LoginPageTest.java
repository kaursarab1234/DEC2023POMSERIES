package com.qa.opencart.Test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.errors.AppError;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;
@Epic("Epic 100:Design open cart page")
@Story("US 101:LOGIN PAGE FEATURES")
@Feature("FEATURE200")
public class LoginPageTest extends BaseTest{
	@Description("checking login page title")
	@Severity(SeverityLevel.MINOR)
	@Test(priority = 1)
	public void loginPageTitleTest() {
		String actTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actTitle, AppConstants.LOGIN_PAGE_TITLE,AppError.TITLE_MISSING);
	}

	@Test(priority = 2)
	public void loginPageURLTest() {
		String actURL = loginPage.getLoginPageURL();
		Assert.assertTrue(actURL.contains(AppConstants.LOGIN_PAGE_URL_FRACTION));
	}

	@Test(priority = 3)
	public void forgotPwdLinkExistTest() {
		Assert.assertTrue(loginPage.isForgotPwdLinkExist());
	}

	@Test(priority = 4)
	public void loginTest() {
		accPage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		Assert.assertEquals(accPage.getAccPageTitle(), AppConstants.ACCOUNTS_PAGE_TITLE);
	}
}
