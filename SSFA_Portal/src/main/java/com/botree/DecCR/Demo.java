package com.botree.DecCR;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.botree.utility.AndroidCommonUtility;
import com.botree.utility.BaseTest_Listener;
import com.botree.utility.SeleniumCommonUtility;

import io.appium.java_client.AppiumDriver;

public class Demo extends BaseTest_Listener {
	AppiumDriver mobileDriver = getMobileDriver();
	WebDriver webDriver = getWebDriver();

	public Demo(AppiumDriver appiumDriver) {
		this.mobileDriver = appiumDriver;
		PageFactory.initElements(appiumDriver, this);
	}

	public Demo(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	AndroidCommonUtility commonUtilityA = new AndroidCommonUtility();
	SeleniumCommonUtility commonUtilityS = new SeleniumCommonUtility();

	// *************************************web X-Path**********************************************
	@FindBy(xpath = "//span[normalize-space()='Field Activity']")
	private WebElement drpFieldActivity;

	@FindBy(xpath = "//*[@class='fa fa-fw fa-bars']")
	private WebElement btnHomeBar;

	public void clickFieldActivity() {
		if (commonUtilityS.elementIsDisplayed(btnHomeBar)) {
			commonUtilityS.clickElement(btnHomeBar);
			commonUtilityS.clickElement(drpFieldActivity);
		} else {
			commonUtilityS.clickElement(drpFieldActivity);
		}

	}


	
//*************************************************Mobile****************************************
	@FindBy(xpath = "(//*[@text='Outlet Visit'])[1]")
	private WebElement clkOutletVisit;

	@FindBy(xpath = "(//*[@resource-id='com.botree.productsfa.botreessfa:id/beat_selection_checkBox'])[1]")
	private WebElement chkBeatSelection1;

	@FindBy(xpath = "(//*[@resource-id='com.botree.productsfa.botreessfa:id/beat_selection_checkBox'])[2]")
	private WebElement chkBeatSelection2;

	@FindBy(id = "com.botree.productsfa.botreessfa:id/beat_next_button")
	private WebElement BtnBeatNext;

	

	public void beatSelection() throws InterruptedException {
		commonUtilityA.clickElement(clkOutletVisit);

		commonUtilityA.clickElement(chkBeatSelection1);
		commonUtilityA.clickElement(chkBeatSelection2);
		commonUtilityA.clickElement(BtnBeatNext);
	}

	


}
