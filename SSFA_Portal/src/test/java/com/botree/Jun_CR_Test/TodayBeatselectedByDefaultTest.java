package com.botree.Jun_CR_Test;

import java.util.HashMap;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import com.botree.JunCR.TodayBeatSelectedByDefault;
import com.botree.SSFA.InitialLoginPage;
import com.botree.utility.BaseTest_Listener;
import com.botree.utility.ReadExcelFile;

import io.appium.java_client.AppiumDriver;

public class TodayBeatselectedByDefaultTest extends BaseTest_Listener {

	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 1)
	public void userAbleToEnableTodayBeatselectedByDefault(HashMap<String, String> SSFA) throws Throwable {
		
		WebDriver webDriver = getWebDriver();
		TodayBeatSelectedByDefault stockTakeS = new TodayBeatSelectedByDefault(webDriver);
		InitialLoginPage LoginS = new InitialLoginPage(webDriver);
		String AppconfHeader = SSFA.get("AppconfHeader");
		String UserNameEnter = SSFA.get("UserNameS");
		String Password1 = SSFA.get("PasswordS");	
		 LoginS.enterWebCredentials(UserNameEnter, Password1);
		 stockTakeS.clickconfigurartion();
		 stockTakeS.clickApplicationConfiguration();
		 stockTakeS.verifyAppConfHeader(AppconfHeader);
		 stockTakeS.clickMarketVisit();
		 stockTakeS.scrollToTheConfiguration();
		 stockTakeS.selectStockTakeOptionInOrderBookingScreenYes();;
		 stockTakeS.NavigatetoTopandSave();
		
	}
		
	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 2)
	public void userAbleToVerifyBookOrderAlongWithStockTakeEnabledInDSR(HashMap<String, String> SSFA) throws Throwable {
		AppiumDriver driver = getMobileDriver();
		TodayBeatSelectedByDefault stockTakeS = new TodayBeatSelectedByDefault(driver);
		InitialLoginPage Login = new InitialLoginPage(driver);
		String userName = SSFA.get("UserNameDsr");
		String password = SSFA.get("PasswordDsr");
		String quantity = SSFA.get("Quantity");
		String uom = SSFA.get("UOM");
		String stockTakeQty = SSFA.get("StockTakeQty");
		String StockTakeUOM = SSFA.get("StockTakeUOM");
		Login.setActivity(userName, password);
		Login.syncDownload();
		orderBookingA.beatSelection();
		orderBookingA.verifyOutletVisitTab();
		orderBookingA.clickPendingOutlets();
		orderBookingA.verifyRetailerisDisplayed();
		orderBookingA.clickRetailer();
		orderBookingA.marketVisitPopupAndCaptureImage();
		orderBookingA.clickRemarksDone();
		orderBookingA.clickRetailerInfoOk();
		orderBookingA.verifyOutletInfoTab();
		orderBookingA.verifyRetailerTab();
		orderBookingA.clickOrderBooking();
		orderBookingA.verifyOrderBookingTab();
//		orderBookingA.verifyRetailerTabAfterClickingOrderBooking();
		orderBookingA.getProductCountBeforeSearch();
		orderBookingA.searchProduct();
		orderBookingA.getProductCountAfterSearch();
		orderBookingA.compareBoth();
		orderBookingA.enterQuantity(quantity);
		orderBookingA.selectUOM(uom);
		orderBookingA.verifyStockTakeTextBoxIsDisplayed();
		orderBookingA.enterStockTake(stockTakeQty, StockTakeUOM);
		orderBookingA.clickNext();
		orderBookingA.verifyOrderSummaryTab();
		orderBookingA.verifyProductPlaced();
		orderBookingA.clickSubmit();

	}

	

	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 3)
	public void verifyUserAbleToBookOrderAlongWithStockTakeEnabledInMDSR(HashMap<String, String> SSFA) throws Throwable {
		AppiumDriver driver = getMobileDriver();
		StockTakeOptionInOrderBooking orderBookingA = new StockTakeOptionInOrderBooking(driver);
		InitialLoginPage Login = new InitialLoginPage(driver);
		String userName = SSFA.get("UserNameMdsr");
		String password = SSFA.get("PasswordMdsr");
		String Directpartyorsuperstockist = SSFA.get("Directpartyorsuperstockist");
		String smtDistributor = SSFA.get("smtDistributor");
		String quantity = SSFA.get("Quantity");
		String uom = SSFA.get("UOM");
		String stockTakeQty = SSFA.get("StockTakeQty");
		String StockTakeUOM = SSFA.get("StockTakeUOM");
		Login.setActivitySwitchUser(userName, password);
		orderBookingA.clickSSVisit();
	//	orderBookingA.SelectDistributor(Directpartyorsuperstockist, smtDistributor);
		Thread.sleep(5000);
		orderBookingA.beatSelection();
		orderBookingA.verifyOutletVisitTab();
		orderBookingA.clickPendingOutlets();
		orderBookingA.verifyRetailerisDisplayed();
		orderBookingA.clickRetailer();
		orderBookingA.marketVisitPopupAndCaptureImage();
		orderBookingA.clickRemarksDone();
		orderBookingA.clickRetailerInfoOk();
		orderBookingA.ClosePointsDetail();
		orderBookingA.verifyRetailerTab();
		orderBookingA.clickOrderBooking();
		orderBookingA.verifyOrderBookingTab();

		orderBookingA.getProductCountBeforeSearch();
		orderBookingA.searchProduct();
		orderBookingA.getProductCountAfterSearch();
		orderBookingA.compareBoth();
		orderBookingA.enterQuantity(quantity);
		orderBookingA.selectUOM(uom);
		orderBookingA.verifyStockTakeTextBoxIsDisplayed();
		orderBookingA.enterStockTake(stockTakeQty, StockTakeUOM);
		
		orderBookingA.clickNext();
		orderBookingA.verifyOrderSummaryTab();
		orderBookingA.verifyProductPlaced();
		orderBookingA.clickSubmit();

	}

	

	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 4)
	public void userAbleToDoOrderBookingAlongWithStockTakeEnabledInCompanyUser(HashMap<String, String> SSFA) throws Throwable {
		AppiumDriver driver = getMobileDriver();
		StockTakeOptionInOrderBooking orderBookingA = new StockTakeOptionInOrderBooking(driver);
		InitialLoginPage Login = new InitialLoginPage(driver);
		String userName = SSFA.get("UserNameCompany");
		String password = SSFA.get("PasswordCompany");
		
		
		String titleMarketVisit = SSFA.get("titleMarketVisit");
		String headerMarketVisit = SSFA.get("headerMarketVisit");
		String headerFilter = SSFA.get("headerFilter");
		String headerStationMaster = SSFA.get("headerStationMaster");
		String distributor = SSFA.get("distributor");
		String salesman = SSFA.get("salesman");
		String quantitiy1 = SSFA.get("quantitiy1");
		String quantitiy2 = SSFA.get("quantitiy2");
		String stockTakeQty = SSFA.get("stockTakeQty");
		String StockTakeUOM = SSFA.get("StockTakeUOM");
		Login.setActivitySwitchUser(userName, password);		
		orderBookingA.verifyUserNameisDisplayed();
		orderBookingA.ClickMenuIcon();
		orderBookingA.VerifyprofileName();
		orderBookingA.ClickMarketVisit(titleMarketVisit);
		orderBookingA.VerifyMarketVistTitle(headerMarketVisit);
		orderBookingA.ClickFilter();
		orderBookingA.VerifyFilterTitle(headerFilter);
		orderBookingA.SelectDistributor(distributor);
		orderBookingA.SelectSalesMan(salesman);
		orderBookingA.VerifyDistributorandSalesmanSelectedSucessfully();
		orderBookingA.ClickApplyButton();
		orderBookingA.VerifyStationMasterHeader(headerStationMaster);
		orderBookingA.SelectStationMaster();
		orderBookingA.SelectRoute();
	//	orderBookingA.verifyStartingpercentage();				
	//	orderBookingA.verifyRetailerisDisplayed1();	
	//	orderBookingA.ClickRetailer1();
		orderBookingA.ClickMoreicon();
		orderBookingA.ClickCompanyUserOrderBooking();
		orderBookingA.verifyOrderBookingheader();
		orderBookingA.VerifyTheRetailer();
		orderBookingA.Selectproducandenterquantity(quantitiy1,quantitiy2);
		orderBookingA.verifyStockTakeTextBoxIsDisplayed();
		orderBookingA.enterStockTake(stockTakeQty, StockTakeUOM);
		orderBookingA.cmpUserOrderBookingNext();
		orderBookingA.VerifyAdnSumbitOrderBooking();
		
		
	}
	
	

	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 5)
	public void userAbleToDisableStockTakeOptionInOrderBookingScreen(HashMap<String, String> SSFA) throws Throwable {
		
		WebDriver webDriver = getWebDriver();
		StockTakeOptionInOrderBooking stockTakeS = new StockTakeOptionInOrderBooking(webDriver);
		InitialLoginPage LoginS = new InitialLoginPage(webDriver);
		String AppconfHeader = SSFA.get("AppconfHeader");
		String UserNameEnter = SSFA.get("UserNameS");
		String Password1 = SSFA.get("PasswordS");	
		 LoginS.enterWebCredentials(UserNameEnter, Password1);
		 stockTakeS.clickconfigurartion();
		 stockTakeS.clickApplicationConfiguration();
		 stockTakeS.verifyAppConfHeader(AppconfHeader);
		 stockTakeS.clickMarketVisit();
		 stockTakeS.scrollToTheConfiguration();
		 stockTakeS.selectStockTakeOptionInOrderBookingScreenNo();;
		 stockTakeS.NavigatetoTopandSave();
		
	}
	
	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 6)
	public void userAbleToVerifyBookOrderAlongWithStockTakeDisableInDSR(HashMap<String, String> SSFA) throws Throwable {
		AppiumDriver driver = getMobileDriver();
		StockTakeOptionInOrderBooking orderBookingA = new StockTakeOptionInOrderBooking(driver);
		InitialLoginPage Login = new InitialLoginPage(driver);
		String userName = SSFA.get("UserNameDsr");
		String password = SSFA.get("PasswordDsr");
		String quantity = SSFA.get("Quantity");
		String uom = SSFA.get("UOM");
		Login.setActivitySwitchUser(userName, password);
		Login.syncDownload();
		orderBookingA.beatSelection();
		orderBookingA.verifyOutletVisitTab();
		orderBookingA.clickPendingOutlets();
		orderBookingA.verifyRetailerisDisplayed();
		orderBookingA.clickRetailer();
		orderBookingA.marketVisitPopupAndCaptureImage();
		orderBookingA.clickRemarksDone();
		orderBookingA.clickRetailerInfoOk();
		orderBookingA.verifyOutletInfoTab();
		orderBookingA.verifyRetailerTab();
		orderBookingA.clickOrderBooking();
		orderBookingA.verifyOrderBookingTab();
//		orderBookingA.verifyRetailerTabAfterClickingOrderBooking();
		orderBookingA.getProductCountBeforeSearch();
		orderBookingA.searchProduct();
		orderBookingA.getProductCountAfterSearch();
		orderBookingA.compareBoth();
		orderBookingA.enterQuantity(quantity);
		orderBookingA.selectUOM(uom);
		orderBookingA.verifyStockTakeTextBoxIsDisabled();
		
		orderBookingA.clickNext();
		orderBookingA.verifyOrderSummaryTab();
		orderBookingA.verifyProductPlaced();
		orderBookingA.clickSubmit();

	}

	

	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 7)
	public void verifyUserAbleToBookOrderAlongWithStockTakeDisableInMDSR(HashMap<String, String> SSFA) throws Throwable {
		AppiumDriver driver = getMobileDriver();
		StockTakeOptionInOrderBooking orderBookingA = new StockTakeOptionInOrderBooking(driver);
		InitialLoginPage Login = new InitialLoginPage(driver);
		String userName = SSFA.get("UserNameMdsr");
		String password = SSFA.get("PasswordMdsr");
		String Directpartyorsuperstockist = SSFA.get("Directpartyorsuperstockist");
		String smtDistributor = SSFA.get("smtDistributor");
		String quantity = SSFA.get("Quantity");
		String uom = SSFA.get("UOM");
		
		Login.setActivitySwitchUser(userName, password);
		orderBookingA.clickSSVisit();
	//	orderBookingA.SelectDistributor(Directpartyorsuperstockist, smtDistributor);
		Thread.sleep(5000);
		orderBookingA.beatSelection();
		orderBookingA.verifyOutletVisitTab();
		orderBookingA.clickPendingOutlets();
		orderBookingA.verifyRetailerisDisplayed();
		orderBookingA.clickRetailer();
		orderBookingA.marketVisitPopupAndCaptureImage();
		orderBookingA.clickRemarksDone();
		orderBookingA.clickRetailerInfoOk();
		orderBookingA.ClosePointsDetail();
		orderBookingA.verifyRetailerTab();
		orderBookingA.clickOrderBooking();
		orderBookingA.verifyOrderBookingTab();
//		orderBookingA.verifyRetailerTabAfterClickingOrderBooking();
		orderBookingA.getProductCountBeforeSearch();
		orderBookingA.searchProduct();
		orderBookingA.getProductCountAfterSearch();
		orderBookingA.compareBoth();
		orderBookingA.enterQuantity(quantity);
		orderBookingA.selectUOM(uom);
		orderBookingA.verifyStockTakeTextBoxIsDisabled();
		
		orderBookingA.clickNext();
		orderBookingA.verifyOrderSummaryTab();
		orderBookingA.verifyProductPlaced();
		orderBookingA.clickSubmit();

	}

	

	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 8)
	public void userAbleToDoOrderBookingAlongWithStockTakeDisableInCompanyUser(HashMap<String, String> SSFA) throws Throwable {
		AppiumDriver driver = getMobileDriver();
		StockTakeOptionInOrderBooking orderBookingA = new StockTakeOptionInOrderBooking(driver);
		InitialLoginPage Login = new InitialLoginPage(driver);
		String userName = SSFA.get("UserNameCompany");
		String password = SSFA.get("PasswordCompany");
		
		
		String titleMarketVisit = SSFA.get("titleMarketVisit");
		String headerMarketVisit = SSFA.get("headerMarketVisit");
		String headerFilter = SSFA.get("headerFilter");
		String headerStationMaster = SSFA.get("headerStationMaster");
		String distributor = SSFA.get("distributor");
		String salesman = SSFA.get("salesman");
		String quantitiy1 = SSFA.get("quantitiy1");
		String quantitiy2 = SSFA.get("quantitiy2");
		Login.setActivity(userName, password);		
		orderBookingA.verifyUserNameisDisplayed();
		orderBookingA.ClickMenuIcon();
		orderBookingA.VerifyprofileName();
		orderBookingA.ClickMarketVisit(titleMarketVisit);
		orderBookingA.VerifyMarketVistTitle(headerMarketVisit);
		orderBookingA.ClickFilter();
		orderBookingA.VerifyFilterTitle(headerFilter);
		orderBookingA.SelectDistributor(distributor);
		orderBookingA.SelectSalesMan(salesman);
		orderBookingA.VerifyDistributorandSalesmanSelectedSucessfully();
		orderBookingA.ClickApplyButton();
		orderBookingA.VerifyStationMasterHeader(headerStationMaster);
		orderBookingA.SelectStationMaster();
		orderBookingA.SelectRoute();
	//	orderBookingA.verifyStartingpercentage();				
	//	orderBookingA.verifyRetailerisDisplayed1();	
	//	orderBookingA.ClickRetailer1();
		orderBookingA.ClickMoreicon();
		orderBookingA.ClickCompanyUserOrderBooking();
		orderBookingA.verifyOrderBookingheader();
		orderBookingA.VerifyTheRetailer();
		orderBookingA.Selectproducandenterquantity(quantitiy1,quantitiy2);
		orderBookingA.verifyStockTakeTextBoxIsDisabled();
		orderBookingA.cmpUserOrderBookingNext();
		orderBookingA.VerifyAdnSumbitOrderBooking();
		
		
	}
	
	

	@DataProvider(name = "BotreeUAT")
	public Object[][] testDataExample() {
		String sheetName = "StockTakeOptionInOrder";
		String fileName = System.getProperty("user.dir") + "\\resource\\DataDriven\\March25.xlsx";
		ReadExcelFile orderCreation = new ReadExcelFile(fileName);
		int col = orderCreation.getColumnCount(sheetName, 0);
		HashMap<String, String> orderBookingA = new HashMap<String, String>();
		for (int i = 0; i < col; i++) {
			String key = orderCreation.getData(sheetName, 0, i);
			String value = orderCreation.getData(sheetName, 1, i);
			orderBookingA.putIfAbsent(key, value);
		}
		return new Object[][] { { orderBookingA } };
	}

}
