package com.botree.ExtentReportListener;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.botree.utility.BaseTest_Listener;

import io.appium.java_client.AppiumDriver;

public class ExtentManager extends BaseTest_Listener {

	AppiumDriver mobileDriver = getMobileDriver();
	WebDriver webDriver = getWebDriver();
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlreport;
	public static ExtentTest test;
	


	public static void setExtent() {

		htmlreport = new ExtentHtmlReporter(System.getProperty("user.dir") + "//test-output//ExtentReports//Report.html");

		htmlreport.config().setDocumentTitle("Test Report");

		extent = new ExtentReports();
		extent.attachReporter(htmlreport);
		extent.setSystemInfo("OS","WINDOWS");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("User Name","Balaji");
	//	htmlreport.config().setChartVisibilityOnOpen(true);
		htmlreport.config().setDocumentTitle("AutomationTesting.Report");
		htmlreport.config().setReportName("Report");
	//		htmlreport.config().setTestViewChartLocation(ChartLocation.TOP);
		htmlreport.config().setTheme(Theme.DARK);

	}


	public static void endReport() throws InterruptedException {
		extent.flush();
		Thread.sleep(5000);
	}
	
	 @BeforeSuite(alwaysRun=true)
	   
	    public void setUp() throws MalformedURLException {
	    	ExtentManager.setExtent();
	  
	    }
	    
	    @AfterSuite
	    public void tearDown() throws InterruptedException {
	   
	        ExtentManager.endReport();
	    
	    }
}
