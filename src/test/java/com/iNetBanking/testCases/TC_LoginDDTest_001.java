package com.iNetBanking.testCases;
import java.io.IOException;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.iNetBanking.PageObjects.LoginPage;
import com.iNetBanking.utilities.XLUtils;

public class TC_LoginDDTest_001 extends BaseClass
{
  @Test(dataProvider="LoginData")
  public void loginDDTest(String user, String pwd) 
  {
	  LoginPage lp = new LoginPage(driver);
	  lp.setUserName(user);
	  lp.setPassword(pwd);
	  lp.clickLogin();
	  if(isAlertPresent()==true)
	  {
		  driver.switchTo().alert().accept();
		  driver.switchTo().defaultContent();
		  Assert.assertTrue(false);
	  }
	  else
	  {
		 lp.clickLogout();
		 driver.switchTo().alert().accept();
		 driver.switchTo().defaultContent();
		 Assert.assertTrue(true);
	  }
  }
  
  public boolean isAlertPresent()
  {
	  try
	  {
		 driver.switchTo().alert();
		 return true;
	  }
	  catch(NoAlertPresentException e)
	  {
		  return false;
	  }
  }
  
  @DataProvider(name="LoginData")
  
  String[][] getData() throws IOException
  {
	  String excel_path = System.getProperty("user.dir")+"/src/test/java/com/iNetBanking/testData/LoginData.xlsx";
	  int rowCount = XLUtils.getRowCount(excel_path, "Data");
	  int colCount = XLUtils.getCellCount(excel_path, "Data", 1);
	  String logindata[][] = new String[rowCount][colCount];
	  for(int i=1;i<=rowCount;i++)
	  {
		  for(int j=0;j<colCount;j++)
		  {
			  logindata[i-1][j] =  XLUtils.getCellData(excel_path, "Data", i, j);
		  }
	  }
	  return logindata;
  }
	
}
