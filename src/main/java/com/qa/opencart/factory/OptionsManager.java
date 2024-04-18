package com.qa.opencart.factory;

import java.util.Properties;

import org.openqa.selenium.chrome.ChromeOptions;

import com.qa.opencart.logger.Log;

public class OptionsManager {
	
	private ChromeOptions co;
	private Properties prop;
	
	public OptionsManager(Properties prop)
	{
		this.prop=prop;
	}
	public ChromeOptions getChromeOptions()
	{
		co=new ChromeOptions();
		if(Boolean.parseBoolean(prop.getProperty("headless").trim()))
				{
			Log.info("running chrome in headless m ode");
			co.addArguments("--headless");
				}
		return co;
	}

}
