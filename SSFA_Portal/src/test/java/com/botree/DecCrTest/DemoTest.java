package com.botree.DecCrTest;

import java.util.HashMap;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.botree.DecCR.Demo;
import com.botree.SSFA.InitialLoginPage;
import com.botree.utility.BaseTest_Listener;
import com.botree.utility.ReadExcelFile;

import io.appium.java_client.AppiumDriver;

public class DemoTest extends BaseTest_Listener {

	@Test(dataProvider = "BotreeUAT", enabled = true, priority = 1)
	public void verifyUserAbleToDoActivityTrackerWithActiveAndTypeInputTextInPortalAndCheckWeatherItIsReflectingInApk_AT001(
			HashMap<String, String> SSFA) throws Throwable {
		AppiumDriver mobileDriver = getMobileDriver();
		WebDriver webDriver = getWebDriver();
		Demo trackerA = new Demo(mobileDriver);
		Demo trackerS = new Demo(webDriver);
		InitialLoginPage loginA = new InitialLoginPage(mobileDriver);
		InitialLoginPage loginS = new InitialLoginPage(webDriver);

		String userNameS = SSFA.get("UserNameS");
		String passwordS = SSFA.get("PasswordS");
		String userNameA = SSFA.get("UserNameA");
		String passwordA = SSFA.get("PasswordA");
	
		loginS.enterWebCredentials(userNameS, passwordS);
		trackerS.clickFieldActivity();
		
		loginA.setActivity(userNameA, passwordA);
		loginA.syncDownload();
		trackerA.beatSelection();
		

	}

	

	@DataProvider(name = "BotreeUAT")
	public Object[][] testDataExample() {
		String sheetName = "Login";
		String fileName = System.getProperty("user.dir") + "\\resource\\DataDriven\\DecCr.xlsx";
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
