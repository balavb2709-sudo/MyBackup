package com.botree.FebCR_Test;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.botree.FebCR.AddOnPointsInProductFilterRequirementForBiskFarm;
import com.botree.SSFA.InitialLoginPage;
import com.botree.utility.BaseTest_Listener;
import com.botree.utility.ReadExcelFile;

import io.appium.java_client.AppiumDriver;

public class AddOnPointsInProductFilterRequirementForBiskFarmTest extends BaseTest_Listener {
	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 1)
	public void userAbleToEnableAddOnPointsInProductFilterRequirement(HashMap<String, String> SSFA) throws Throwable {
		
		WebDriver webDriver = getWebDriver();
		AddOnPointsInProductFilterRequirementForBiskFarm poS = new AddOnPointsInProductFilterRequirementForBiskFarm(webDriver);
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
		 poS.selectPredefinedProductFilterYes();
		 poS.NavigatetoTopandSave();
		
	}
	
	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 2)
	public void userAbleToSetProductFilterValueInSettingsSceenAndVerifyItsReflectingIntoOrderBookingScreen(HashMap<String, String> SSFA) throws Throwable {
		
		AppiumDriver mobileDriver = getMobileDriver();
		AddOnPointsInProductFilterRequirementForBiskFarm productA = new AddOnPointsInProductFilterRequirementForBiskFarm(mobileDriver);
		InitialLoginPage loginA = new InitialLoginPage(mobileDriver);
		String userNameA = SSFA.get("UserNameA");
		String passwordA = SSFA.get("PasswordA");
		String quantity = SSFA.get("Quantity");
		String uom = SSFA.get("UOM");
		String productFilterName = SSFA.get("ProductFilterName");
		loginA.setActivity(userNameA, passwordA);
		productA.clickSettings();
		productA.selectProductFilter(productFilterName);	
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
		productA.getProductCountBeforeFilter();;
		productA.clickOrderBookingFilter();
		productA.verifyProductFilterIsDisplayed();
		productA.verifySelectedProductFilterInSettingsIsReflected(productFilterName);
		productA.selectHeirarchyLabelValue();
		productA.verifySelectedBrandNameIsReflected();
		productA.getProductCountAfterFilter();
		productA.compareBoth();
		productA.searchProduct();
		productA.enterQuantity(quantity);
		productA.selectUOM(uom);
		productA.clickNext();
		productA.verifyOrderSummaryTab();		
		productA.clickSubmit();
		
	}
	
	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 2)
	public void userAbleToVerifyNextAndPreviousFilterDataAlongWithResetFilter(HashMap<String, String> SSFA) throws Throwable {
		
		AppiumDriver mobileDriver = getMobileDriver();
		AddOnPointsInProductFilterRequirementForBiskFarm productA = new AddOnPointsInProductFilterRequirementForBiskFarm(mobileDriver);
		InitialLoginPage loginA = new InitialLoginPage(mobileDriver);
		String userNameA = SSFA.get("UserNameA");
		String passwordA = SSFA.get("PasswordA");
		String quantity = SSFA.get("Quantity");
		String uom = SSFA.get("UOM");
		loginA.setActivity(userNameA, passwordA);
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
		productA.getProductCountBeforeFilter();
		productA.clickNextFilterList();
		productA.clickNextFilterList();
		productA.clickPreviousFilterList();
		productA.verifyProductCountAfterFilter();
		productA.verifyProductIsDisplayed();
		productA.clickPreviousFilterList();		
		productA.clickOrderBookingFilter();
		productA.verifyProductFilterIsDisplayed();
		productA.clickResetFilter();
		
		productA.verifyProductFilterIsReset();
		productA.searchProduct();
		productA.enterQuantity(quantity);
		productA.selectUOM(uom);
		productA.clickNext();
		productA.verifyOrderSummaryTab();		
		productA.clickSubmit();
		
	}
	
	
	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 3)
	public void userAbleToDisableAddOnPointsInProductFilterRequirement(HashMap<String, String> SSFA) throws Throwable {
		
		WebDriver webDriver = getWebDriver();
		AddOnPointsInProductFilterRequirementForBiskFarm poS = new AddOnPointsInProductFilterRequirementForBiskFarm(webDriver);
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
		 poS.selectPredefinedProductFilterNo();
		 poS.NavigatetoTopandSave();
		
	}
	@DataProvider(name = "BotreeUAT")
	public Object[][] testDataExample() {
		String sheetName = "AddOnPtsInProFilReq";
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
