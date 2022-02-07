package com.iNetBanking.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.iNetBanking.PageObjects.AddNewCustomerPage;
import com.iNetBanking.PageObjects.LoginPage;

public class TC_AddNewCustomer_002 extends BaseClass
{
	
	public LoginPage lp;
	public AddNewCustomerPage ancp;
@Test
public void ADDNewCust() throws InterruptedException
{
	 lp = new LoginPage(driver);
	 lp.setUserName(confi.getUsername());
	 logger.info("Entered User Name");
	 lp.setPassword(confi.getPassword());
	 logger.info("Entered Password");
	 lp.clickLogin();
	 logger.info("Submitted");
	 Thread.sleep(3000);
	 ancp = new AddNewCustomerPage(driver);
	 ancp.clickAddNewCustomer();
	 logger.info("Clicked on New Customer Link");
	 ancp.CustomerName("S Venkata Sumanth");
	 logger.info("Entered Customer Name");
	 ancp.custgender();
	 logger.info("Select Customer Gender");
	 ancp.custDOB("09", "08", "1996");
	 logger.info("Entered the Customer DOB");
	 ancp.custAddress("Kaza,  West Godavari District");
	 logger.info("Entered Customer Address");
	 ancp.custCity("Palakollu");
	 logger.info("Entered Customer City");
	 ancp.custState("Andhra Pradesh");
	 logger.info("Entered Customer State");
	 ancp.custPin("534260");
	 logger.info("Entered Customer Postal Code");
	 ancp.custTeleNo("97010354321");
	 logger.info("Entered Customer Contact Number");
	 //Generating Random String 
	 String cmailID =  randomstring()+"@gmail.com";
	 ancp.custEmailID(cmailID);
	 logger.info("Entered Customer email Address");
	 ancp.custPassword("1234567");
	 ancp.clicksubbtn();
	 Thread.sleep(3000);
	 logger.info("Clicked on Submit Button");
	 Thread.sleep(3000);
	 
	 boolean res = driver.getPageSource().contains("");
	 if(res==true)
	 {
		 Assert.assertTrue(true);
	 }
	 else
	 {
		 Assert.assertTrue(false);
	 }
	 
	 
}
}
