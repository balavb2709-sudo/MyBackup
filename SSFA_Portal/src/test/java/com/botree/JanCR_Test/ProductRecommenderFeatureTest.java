package com.botree.JanCR_Test;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.botree.DecCR.Demo;
import com.botree.JanCR.ProductRecommenderFeature;
import com.botree.SSFA.InitialLoginPage;
import com.botree.utility.BaseTest_Listener;
import com.botree.utility.ReadExcelFile;

import io.appium.java_client.AppiumDriver;

public class ProductRecommenderFeatureTest extends BaseTest_Listener {

	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 1)
	public void verifyUserAbleToDoOrderBooking(HashMap<String, String> SSFA) throws Throwable {
		AppiumDriver mobileDriver = getMobileDriver();
		ProductRecommenderFeature productA = new ProductRecommenderFeature(mobileDriver);
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
		productA.verifyRetailerTabAfterClickingOrderBooking();
		productA.getProductCountBeforeSearch();
		productA.searchProduct();
		productA.getProductCountAfterSearch();
		productA.compareBoth();
		productA.enterQuantity(quantity);
		productA.selectUOM(uom);
		productA.clickNext();
		productA.verifyOrderSummaryTab();
		productA.verifyProductPlaced();
		// productA.AddSignature();
		productA.clickSubmit();


	}

	
	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 2)
	public void verifyUserAbleToDoOrderInfoReportOrderDT(HashMap<String, String> SSFA) throws Throwable {
		WebDriver webDriver = getWebDriver();
		ProductRecommenderFeature productS = new ProductRecommenderFeature(webDriver);
		InitialLoginPage loginS = new InitialLoginPage(webDriver);
		String userNameS = SSFA.get("UserNameS");
		String passwordS = SSFA.get("PasswordS");
		String distributorCode = SSFA.get("DistributorCode");
		loginS.enterWebCredentials(userNameS, passwordS);
		productS.clickReport();
		productS.selectOrderInfoReport();
		productS.selectDistributor(distributorCode);
		productS.selectDate();
		productS.selectOrderDt();
		productS.clickSearchButton();
		productS.verifyOrderSummaryScreenIsDisplayed();
		productS.clickViewButton();
		productS.verifyOrderTypeField();

	}

	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 1)
	public void verifyUserAbleToDoOrderInfoReportSynDT(HashMap<String, String> SSFA) throws Throwable {
		WebDriver webDriver = getWebDriver();
		ProductRecommenderFeature productS = new ProductRecommenderFeature(webDriver);
		InitialLoginPage loginS = new InitialLoginPage(webDriver);
		String userNameS = SSFA.get("UserNameS");
		String passwordS = SSFA.get("PasswordS");		
		String distributorCode = SSFA.get("DistributorCode");	
		loginS.enterWebCredentials(userNameS, passwordS);
		productS.clickReport();
		productS.selectOrderInfoReport();
		productS.selectDistributor(distributorCode);
		productS.selectDate();
		productS.selectSynDt();
		productS.clickSearchButton();
		productS.verifyOrderSummaryScreenIsDisplayed();
		productS.clickViewButton();
		productS.verifyOrderTypeField();

	}

	@DataProvider(name = "BotreeUAT")
	public Object[][] testDataExample() {
		String sheetName = "ProductReco";
		String fileName = System.getProperty("user.dir") + "\\resource\\DataDriven\\JanCr.xlsx";
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
