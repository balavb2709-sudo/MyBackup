package com.botree.Jun_CR_Test;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.botree.DSR_Page.BookOrder;
import com.botree.SSFA.InitialLoginPage;
import com.botree.utility.BaseTest_Listener;
import com.botree.utility.ReadExcelFile;

import io.appium.java_client.AppiumDriver;

public class ProductGroupWiseContribution extends BaseTest_Listener{
	
	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 1)
	public void verifyUserAbleToBookOrderAndCheckProductGroupWiseComtribution(HashMap<String, String> SSFA) throws Throwable {
		AppiumDriver driver = getDriver();
		BookOrder bookOrder = new BookOrder(driver);
		InitialLoginPage Login = new InitialLoginPage(driver);
		String userName = SSFA.get("UserName");
		String password = SSFA.get("Password");
		String quantity = SSFA.get("Quantity");
		String uom = SSFA.get("UOM");
		// String remarks = SSFA.get("Remarks");
		String discount = SSFA.get("Discount");
		Login.setActivity(userName, password);
		
		bookOrder.beatSelection();
		bookOrder.verifyOutletVisitTab();
		bookOrder.clickPendingOutlets();
		bookOrder.verifyRetailerisDisplayed();
		bookOrder.clickRetailer();
		bookOrder.marketVisitPopupAndCaptureImage();
		bookOrder.clickRemarksDone();
		bookOrder.clickRetailerInfoOk();
		bookOrder.verifyOutletInfoTab();
		bookOrder.verifyRetailerTab();
		bookOrder.clickOrderBooking();
		bookOrder.verifyOrderBookingTab();
		bookOrder.verifyRetailerTabAfterClickingOrderBooking();
		bookOrder.getProductCountBeforeSearch();
		bookOrder.searchProduct();
		bookOrder.getProductCountAfterSearch();
		bookOrder.compareBoth();
		bookOrder.enterQuantity(quantity);
		bookOrder.selectUOM(uom);
		bookOrder.clickNext();
		bookOrder.verifyOrderSummaryTab();
		bookOrder.verifyProductPlaced();
	//	bookOrder.AddSignature();
	//	bookOrder.applyDiscount(discount);
		bookOrder.clickSubmit();
		
	}
	@DataProvider(name = "BotreeUAT")
	public Object[][] testDataExample() {
		String sheetName = "StockTakeOptionInOrderBooking";
		String fileName = System.getProperty("user.dir") + "\\resource\\DataDriven\\DSR.xlsx";
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
