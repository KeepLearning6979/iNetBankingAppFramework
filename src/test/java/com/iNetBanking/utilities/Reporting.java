package com.iNetBanking.utilities;

// Listener Class used to Generate the reports 

import java.io.File;
import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter
{
	public ExtentHtmlReporter htmlReporter;
	public ExtentReports extent;
	public ExtentTest logger;
	  public WebDriver driver;
	
		
	public void onStart(ITestContext testContext)
	{
		String format = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());//time stamp
		String reportName="Test-Report-"+format+".html";
		//specify location of the reports and Generate the report
		htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+ "/test-output/"+reportName);
		htmlReporter.loadXMLConfig(System.getProperty("user.dir")+ "/extent-config.xml");
		// ExtentReports used to add the Entries on the Report
		extent=new ExtentReports();
		extent.attachReporter(htmlReporter);
		extent.setSystemInfo("Host name","localhost");
		extent.setSystemInfo("Environemnt","QA");
		extent.setSystemInfo("username","Sumanth Durga");
		// Generate the Title of Report
		htmlReporter.config().setDocumentTitle("iNet Banking  Application Test"); 
		// Generate the Report Name
		htmlReporter.config().setReportName("Functional Test Automation Report"); 
		//location of the chart
		//htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP); 
		htmlReporter.config().setTheme(Theme.DARK);
	}
	
	public void onTestSuccess(ITestResult tr)
	{ 
		// It will create a Test information name in the Report
		logger=extent.createTest(tr.getName()); 
		// Get the Test case status and present on the reports 
		logger.log(Status.PASS,MarkupHelper.createLabel(tr.getName(),ExtentColor.GREEN)); 
	}
	
	public void onTestFailure(ITestResult tr)
	{
		// It will create a Test information name in the Report
		logger=extent.createTest(tr.getName());
		// Get the Test case status and present on the reports 
		logger.log(Status.FAIL,MarkupHelper.createLabel(tr.getName(),ExtentColor.RED)); 
		
		String screenshotPath=System.getProperty("user.dir")+"\\Screenshot\\"+tr.getName()+".png";
		
		File f = new File(screenshotPath); 
		
		if(f.exists())
		{
		try {
			logger.fail("Screenshot is below:" + logger.addScreenCaptureFromPath(screenshotPath));
			} 
		catch (IOException e) 
				{
				e.printStackTrace();
				}
		}
		
	}
	
	
	public void onTestSkipped(ITestResult tr)
	{
		// It will create a Test information name in the Report
		logger=extent.createTest(tr.getName()); 
		// Get the Test case status and present on the reports
		logger.log(Status.SKIP,MarkupHelper.createLabel(tr.getName(),ExtentColor.ORANGE));
	}
	
	public void onFinish(ITestContext testContext)
	{
		// Clear the previous report and generate the new report
		extent.flush();
	}
}
