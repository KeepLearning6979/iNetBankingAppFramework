package com.iNetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.PageObjects.LoginPage;

public class TC_LoginTest_001 extends BaseClass
{
	 @Test
	 public void LoginTest() throws InterruptedException
	 {
		 
		 LoginPage lg = new LoginPage(driver);
		 lg.setUserName(confi.getUsername());
		 logger.info("Entered User Name");
		 lg.setPassword(confi.getPassword());
		 logger.info("Entered Password");
		 lg.clickLogin();
		 logger.info("Submitted");
		 Thread.sleep(3000);
		 if(driver.getTitle().equals("GTPL Bank Manager HomePage"))
		 {
			 Assert.assertTrue(true);
			 logger.info("Application successfully Navigated to Home Page");
		 }
		 else {
			 Assert.assertFalse(false);
			 logger.info("Application is not successfully Navigated to Home Page");
		 }
	 }

}
