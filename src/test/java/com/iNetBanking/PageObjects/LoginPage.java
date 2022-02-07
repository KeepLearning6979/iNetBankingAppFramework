package com.iNetBanking.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage 
{
	WebDriver ldriver;
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
    
	// Finding Elements
	
	@FindBy(name="uid")
	//This annotation, when applied over a WebElement, instructs Selenium to 
	//keep a cache of the WebElement instead of searching for the WebElement every 
	//time from the WebPage. This helps us save a lot of time
	@CacheLookup  
	WebElement txtUserName;
	
	@FindBy(name="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="btnLogin")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(xpath= "//a[text()='Log out']")
	@CacheLookup
	WebElement logout;
	
	// Action Methods
	
	public void setUserName(String uName)
	{
		txtUserName.sendKeys(uName);
	}
	
	public void setPassword(String pwd)
	{
		txtPassword.sendKeys(pwd);
	}
	
	public void clickLogin()
	{
		btnLogin.click();
	}
	
	public void clickLogout()
	{
		logout.click();
	}
}
