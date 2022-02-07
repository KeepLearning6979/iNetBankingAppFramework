package com.iNetBanking.testCases;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.iNetBanking.PageObjects.LoginPage;
import com.iNetBanking.utilities.ConfigurationReader;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass 
{
	public static WebDriver driver;
	public  static Logger logger;
	public ConfigurationReader confi;
	public Properties prop;
	
	
	@BeforeClass
	@Parameters("BrowserName")
	public void setUp(String BrowserName) throws IOException, InterruptedException
	{
		prop = new Properties();
		confi = new ConfigurationReader();
		logger = Logger.getLogger("iBANKING");
		PropertyConfigurator.configure("./log4j.properties");
		if(BrowserName.equals("chrome"))
		{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		}
		else if(BrowserName.equals("Edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
		else
		{
			System.out.println("Invalid Browser Name");
			
		}
		logger.info("Browser Driver Initiated");
		driver.manage().window().maximize();
		logger.info("Browser Maximized");
		 driver.get(confi.getAppURL());
		 Thread.sleep(3000);
		 logger.info("Application Launched");
		 driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
		logger.info("Closing the Browser");
	}

	public String randomstring()
	{
		String generateRandomString = RandomStringUtils.randomAlphabetic(6);
		return generateRandomString;
	}
	
	public String randomAlpNum()
	{
		String generateRandomAlpNum = RandomStringUtils.randomNumeric(4);
		return generateRandomAlpNum;
	}
	

}
