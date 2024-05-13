package com.qa.opencart.factory;

import java.util.HashMap;
import java.util.Map;
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
		if (Boolean.parseBoolean(prop.getProperty("remote"))) {
			co.setCapability("browserName", "chrome");
			co.setBrowserVersion(prop.getProperty("browserversion").trim());
			Map<String, Object> selenoidOptions = new HashMap<>();
			selenoidOptions.put("screenResolution", "1280x1024x24");
			selenoidOptions.put("enableVNC", true);
			selenoidOptions.put("name", prop.getProperty("testname"));
			co.setCapability("selenoid:options", selenoidOptions);
		}
		if(Boolean.parseBoolean(prop.getProperty("headless").trim()))
				{
			Log.info("running chrome in headless m ode");
			co.addArguments("--headless");
				}
		return co;
	}

}
