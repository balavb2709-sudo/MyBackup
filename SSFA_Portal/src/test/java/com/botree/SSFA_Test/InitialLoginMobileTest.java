package com.botree.SSFA_Test;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.botree.SSFA.InitialLoginPage;
import com.botree.utility.BaseTest_Listener;
import com.botree.utility.ReadExcelFile;

import io.appium.java_client.AppiumDriver;

public class InitialLoginMobileTest extends BaseTest_Listener {
	
	
	@Test(dataProvider = "BotreeUAT", enabled = true , priority = 1)
	public void initialSetup(HashMap<String, String> SSFA) throws Throwable {			
		AppiumDriver mobileDriver = getMobileDriver();	
		 InitialLoginPage Login=new InitialLoginPage(mobileDriver);
		 String userName = SSFA.get("UserNameA");
		 String password = SSFA.get("PasswordA");
	
		 Login.selectLanguage();
		 Login.initialPermission();
		 Login.mobileLogin(userName, password);
		 Login.clickSyncOk();
		 Login.beatSelection();

		
		 
		 
		 
		 
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