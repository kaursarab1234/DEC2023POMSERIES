package com.qa.opencart.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import com.qa.opencart.errors.AppError;
import com.qa.opencart.exceptions.BrowserException;
import com.qa.opencart.exceptions.FrameworkException;
import com.qa.opencart.logger.Log;

public class DriverFactory {
	WebDriver driver;
	Properties prop;
	OptionsManager op;
	public static ThreadLocal<WebDriver> tdriver=new ThreadLocal<WebDriver>();
	public WebDriver initDriver(Properties prop) {

		String browserName = prop.getProperty("browser");
        op=new OptionsManager(prop);
		//System.out.println("browser name is : " + browserName);
		Log.info("browser name is :"+browserName);
        switch (browserName.trim().toLowerCase()) {
		case "chrome":

			//driver = new ChromeDriver(op.getChromeOptions());
			tdriver.set(new ChromeDriver(op.getChromeOptions()));
			break;

		

		default:
			//System.out.println("plz pass the right browser...." + browserName);
			Log.error("pl pass the right browser "+browserName);
			throw new BrowserException("NO BROWSER FOUND..." + browserName);
		}

        getdriver().manage().deleteAllCookies();
        getdriver().manage().window().maximize();
        getdriver().get(prop.getProperty("url"));
		
		return getdriver();
	}
	public static WebDriver getdriver()
	{
		 return tdriver.get();
	}

	public Properties initProp() {
		FileInputStream ip=null;
		String en = System.getProperty("env");
		System.out.println("running test on qa");
		
		if(en==null)
		{
			 try {
				ip = new FileInputStream("./src/test/resources/config.qa.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		else
		{
		switch (en.toLowerCase().trim()) {
		case "qa":
			 try {
				ip = new FileInputStream("./src/test/resources/config.qa.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			break;

		default:
			System.out.println("pl pass right env");
			throw new FrameworkException(AppError.ENV_MISSING);
			
		}
		}
		prop = new Properties();
		try {
			//FileInputStream ip = new FileInputStream("./src/test/resource/config/configproperties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	

}
	
	public static String getScreenshot(String methodName) {
		File srcFile = ((TakesScreenshot) getdriver()).getScreenshotAs(OutputType.FILE);//temp directory
		String path = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" + System.currentTimeMillis()
				+ ".png";

		File destination = new File(path);

		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}
}
