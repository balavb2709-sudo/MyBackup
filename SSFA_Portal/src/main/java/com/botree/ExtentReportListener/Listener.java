package com.botree.ExtentReportListener;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


public class Listener extends ExtentManager implements ITestListener{
	
	
	public void onTestStart(ITestResult result) {
		test = extent.createTest(result.getName());
	}
	
	
	public void onTestSuccess(ITestResult result) {
		if(result.getStatus() == ITestResult.SUCCESS) {
 			
			test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+"Test Case Passed",ExtentColor.GREEN));
			
 		}
 		
	}
	
	
	public void onTestFailure(ITestResult result) {		
		if(result.getStatus() == ITestResult.FAILURE) {
			if (com.botree.ExtentReportListener.Listener.test != null) {
 			test.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + "- Test Case Failed", ExtentColor.RED));
 			test.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable()+ "- Test Case Failed", ExtentColor.RED));
 			
 			String pathString = mobileScreenShot(result.getName());
 			String pathString1 = webScreenShot(result.getName());
 		   try {
 			   Thread.sleep(1000);
 		    test.addScreenCaptureFromPath(pathString);
 		   test.addScreenCaptureFromPath(pathString1);
 		   } catch (IOException | InterruptedException e) {
 		    // TODO Auto-generated catch block
 		    e.printStackTrace();
 		   }
 		}		
		} else {
		    System.out.println("Test object is null. Check initialization.");
		}
	}
	
	
	public void onTestSkipped(ITestResult result) {
		if(result.getStatus() == ITestResult.SKIP) {
 			
			test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+"Test case Skkiped",ExtentColor.ORANGE));
 		}
	}
	
	
	public void onStart(ITestContext context) {
		ITestListener.super.onStart(context);
	}

}
