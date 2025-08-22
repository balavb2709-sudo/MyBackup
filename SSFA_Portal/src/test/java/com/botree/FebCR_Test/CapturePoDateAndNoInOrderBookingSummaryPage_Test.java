package com.botree.FebCR_Test;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.botree.FebCR.CapturePoDateAndNoInOrderBookingSummaryPage;
import com.botree.SSFA.InitialLoginPage;
import com.botree.utility.BaseTest_Listener;
import com.botree.utility.ReadExcelFile;

import io.appium.java_client.AppiumDriver;

public class CapturePoDateAndNoInOrderBookingSummaryPage_Test extends BaseTest_Listener {
	
	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 1)
	public void userAbleToDisablePoNumberAndDateConfiguration(HashMap<String, String> SSFA) throws Throwable {
		
		AppiumDriver mobileDriver = getMobileDriver();
		WebDriver webDriver = getWebDriver();
		CapturePoDateAndNoInOrderBookingSummaryPage poS = new CapturePoDateAndNoInOrderBookingSummaryPage(webDriver);
		InitialLoginPage LoginS = new InitialLoginPage(webDriver);
		String AppconfHeader = SSFA.get("AppconfHeader");
		String UserNameEnter = SSFA.get("UserNameS");
		String Password1 = SSFA.get("PasswordS");	
		 LoginS.enterWebCredentials(UserNameEnter, Password1);
		 poS.clickconfigurartion();
		 poS.clickApplicationConfiguration();
		 poS.verifyAppConfHeader(AppconfHeader);
		 poS.clickMarketVisit();
		 poS.scrollToTheConfiguration();
		 poS.poNumAndDateconfigurationNo();
		 poS.NavigatetoTopandSave();
		
	}
	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 2)
	public void userAbleToVerifyPoCaptureModuleIsDisabled(HashMap<String, String> SSFA) throws Throwable {
		
		AppiumDriver mobileDriver = getMobileDriver();
		WebDriver webDriver = getWebDriver();
		CapturePoDateAndNoInOrderBookingSummaryPage productA = new CapturePoDateAndNoInOrderBookingSummaryPage(mobileDriver);
		InitialLoginPage loginA = new InitialLoginPage(mobileDriver);
		String userNameA = SSFA.get("UserNameA");
		String passwordA = SSFA.get("PasswordA");
		String quantity = SSFA.get("Quantity");
		String uom = SSFA.get("UOM");
		loginA.setActivity(userNameA, passwordA);
		loginA.syncDownload();
		productA.beatSelection();
		productA.verifyOutletVisitTab();
		productA.clickPendingOutlets();
		productA.verifyRetailerisDisplayed();
		productA.clickRetailer();
		productA.marketVisitPopupAndCaptureImage();
		productA.clickRemarksDone();
		productA.clickRetailerInfoOk();
		productA.verifyOutletInfoTab();
		productA.verifyRetailerTab();
		productA.clickOrderBooking();
		productA.verifyOrderBookingTab();	
		productA.searchProduct();
		productA.enterQuantity(quantity);
		productA.selectUOM(uom);
		productA.clickNext();
		productA.verifyOrderSummaryTab();
		productA.verifyPoCaptureInDisableMode();
		productA.clickSubmit();
		
	}
	
	
	
	
	
	
	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 3)
	public void userAbleToEnablePoNumberAndDateConfiguration(HashMap<String, String> SSFA) throws Throwable {
		
		AppiumDriver mobileDriver = getMobileDriver();
		WebDriver webDriver = getWebDriver();
		CapturePoDateAndNoInOrderBookingSummaryPage poS = new CapturePoDateAndNoInOrderBookingSummaryPage(webDriver);
		InitialLoginPage LoginS = new InitialLoginPage(webDriver);
		String AppconfHeader = SSFA.get("AppconfHeader");
		String UserNameEnter = SSFA.get("UserNameS");
		String Password1 = SSFA.get("PasswordS");	
		 LoginS.enterWebCredentials(UserNameEnter, Password1);
		 poS.clickconfigurartion();
		 poS.clickApplicationConfiguration();
		 poS.verifyAppConfHeader(AppconfHeader);
		 poS.clickMarketVisit();
		 poS.scrollToTheConfiguration();
		 poS.poNumAndDateconfigurationYes();
		 poS.NavigatetoTopandSave();
		
	}
	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 4)
	public void userAbleToVerifyPoCaptureModuleIsEnabledAndCompleteOrderBooking(HashMap<String, String> SSFA) throws Throwable {
		
		AppiumDriver mobileDriver = getMobileDriver();
		WebDriver webDriver = getWebDriver();
		CapturePoDateAndNoInOrderBookingSummaryPage productA = new CapturePoDateAndNoInOrderBookingSummaryPage(mobileDriver);
		InitialLoginPage loginA = new InitialLoginPage(mobileDriver);
		String userNameA = SSFA.get("UserNameA");
		String passwordA = SSFA.get("PasswordA");
		String quantity = SSFA.get("Quantity");
		String uom = SSFA.get("UOM");
		String poNumber = SSFA.get("PoNumber");
		String poRemarks = SSFA.get("poRemarks");
		loginA.setActivity(userNameA, passwordA);
		loginA.syncDownload();
		productA.beatSelection();
		productA.verifyOutletVisitTab();
		productA.clickPendingOutlets();
		productA.verifyRetailerisDisplayed();
		productA.clickRetailer();
		productA.marketVisitPopupAndCaptureImage();
		productA.clickRemarksDone();
		productA.clickRetailerInfoOk();
		productA.verifyOutletInfoTab();
		productA.verifyRetailerTab();
		productA.clickOrderBooking();
		productA.verifyOrderBookingTab();	
		productA.searchProduct();
		productA.enterQuantity(quantity);
		productA.selectUOM(uom);
		productA.clickNext();
		productA.verifyOrderSummaryTab();
		productA.verifyPoCaptureIsInEnableMode();
		productA.verifyPoCaptureScreenIsDisplayed();
		productA.enterPoNumber(poNumber);
		productA.selectPoDate();
		productA.enterPoRemarks(poRemarks);
		productA.CapturePoImage();
		productA.clickPoCaptureSubmit();
		productA.clickSubmit();
		
	}
	
	
	
	@DataProvider(name = "BotreeUAT")
	public Object[][] testDataExample() {
		String sheetName = "PoNoDate";
		String fileName = System.getProperty("user.dir") + "\\resource\\DataDriven\\FebCr.xlsx";
		ReadExcelFile orderCreation = new ReadExcelFile(fileName);
		int col = orderCreation.getColumnCount(sheetName, 0);
		HashMap<String, String> orderBooking = new HashMap<String, String>();
		for (int i = 0; i < col; i++) {
			String key = orderCreation.getData(sheetName, 0, i);
			String value = orderCreation.getData(sheetName, 1, i);
			orderBooking.putIfAbsent(key, value);
		}
		return new Object[][] { { orderBooking } };
	}  

}
