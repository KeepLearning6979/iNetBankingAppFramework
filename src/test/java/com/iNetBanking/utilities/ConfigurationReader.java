package com.iNetBanking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader 
{
	 Properties prop;
	public ConfigurationReader() throws IOException
	{
		File src = new File("C:\\Users\\satti\\OneDrive\\Desktop\\BankingFramework\\iNetBankingAppFramework\\Configuration\\config.properties");
		FileInputStream fis = new FileInputStream(src);
		 prop = new Properties();
		prop.load(fis);
	}
	
	// Actions Methods
	
	public String getAppURL()
	{
		String url = prop.getProperty("AppURL");
		return url;
	}
	

	public String getUsername()
	{
		String uname = prop.getProperty("username");
		return uname;
	}
	
	public String getPassword()
	{
		String password = prop.getProperty("password");
		return password;
	}
			

}
