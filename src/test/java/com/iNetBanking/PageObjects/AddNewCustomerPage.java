package com.iNetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddNewCustomerPage 
{
	WebDriver ldriver;
	public AddNewCustomerPage(WebDriver rdriver)
	{
		ldriver = rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	// Finding the Element
	
	@FindBy(xpath = "//a[text()='New Customer']")
	@CacheLookup
	WebElement lnknewcustomer;
	
	@FindBy(name = "name")
	@CacheLookup
	WebElement txtcustomerName;
	
	@FindBy(xpath = "//input[@name='rad1'][1]")
	@CacheLookup
	WebElement rdgender;
	
	@FindBy(xpath = "//input[@id='dob']")
	@CacheLookup
	WebElement txtdob;
	
	@FindBy(name = "addr")
	@CacheLookup
	WebElement txtaddress;
	
	@FindBy(name = "city")
	@CacheLookup
	WebElement txtcity;
	
	@FindBy(name = "state")
	@CacheLookup
	WebElement txtstate;
	
	@FindBy(name = "pinno")
	@CacheLookup
	WebElement txtpinno;
	
	@FindBy(name = "telephoneno")
	@CacheLookup
	WebElement txttelephoneno;
	
	@FindBy(name = "emailid")
	@CacheLookup
	WebElement txtemailid;
	
	@FindBy(name = "password")
	@CacheLookup
	WebElement txtpwd;
	
	@FindBy(name = "sub")
	@CacheLookup
	WebElement btnsubmit;
	
	// Actions
	
	public void clickAddNewCustomer()
	{
		lnknewcustomer.click();
	}
	
	public void CustomerName(String cname)
	{
		txtcustomerName.sendKeys(cname);
	}
	
	public void custgender()
	{
		rdgender.click();
	}
	
	public void custDOB(String day, String mm, String year)
	{
		txtdob.sendKeys(day);
		txtdob.sendKeys(mm);
		txtdob.sendKeys(year);
	}
	
	public void custAddress(String cadr)
	{
		txtaddress.sendKeys(cadr);
	}
	
	public void custCity(String ccity)
	{
		txtcity.sendKeys(ccity);
	}
	
	public void custState(String cstate)
	{
		txtstate.sendKeys(cstate);
	}
	
	public void custPin(String cpinno)
	{
		txtpinno.sendKeys(String.valueOf(cpinno));
	}
	
	public void custTeleNo(String ctelpnno)
	{
		txttelephoneno.sendKeys(ctelpnno);
	}
	
	public void custEmailID(String cemailid)
	{
		txtemailid.sendKeys(cemailid);
	}
	
	public void custPassword(String pwd)
	{
		txtpwd.sendKeys(pwd);
	}
	public void clicksubbtn()
	{
		btnsubmit.click();
	}
}
