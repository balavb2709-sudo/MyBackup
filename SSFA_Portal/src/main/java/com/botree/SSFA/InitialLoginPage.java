package com.botree.SSFA;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.botree.utility.AndroidCommonUtility;
import com.botree.utility.BaseTest_Listener;
import com.botree.utility.SeleniumCommonUtility;

import io.appium.java_client.AppiumDriver;

public class InitialLoginPage extends BaseTest_Listener {
	AppiumDriver mobileDriver = getMobileDriver();
	WebDriver webDriver = getWebDriver();

	public InitialLoginPage(AppiumDriver appiumDriver) {
		this.mobileDriver = appiumDriver;
		PageFactory.initElements(appiumDriver, this);
	}

	public InitialLoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	AndroidCommonUtility commonUtilityA = new AndroidCommonUtility();
	SeleniumCommonUtility commonUtilityS = new SeleniumCommonUtility();

	// **************************PermissionXpath*****************************

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement clkWhileUsingApp;// 3

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/accept_disclosure")
	private WebElement clkAccept;

	@FindBy(id = "android:id/button1")
	private WebElement clkOk;

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private WebElement clkAllow;// 2

	@FindBy(xpath = "(//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/constraint_layout'])[2]")
	private WebElement clkLanguageEnglish;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/continueTXT")
	private WebElement btnContinue;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/username_edt")
	private WebElement txtUserName;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/next_button_layout")
	private WebElement btnLogin;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/password_edt")
	private WebElement txtPassword;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/pwd_button_layout")
	private WebElement btnLogin1;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/alert_ok_btn")
	private WebElement syncOk;

	@FindBy(xpath = "(//*[@text='Outlet Visit'])[1]")
	private WebElement clkOutletVisit;

	@FindBy(xpath = "(//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/beat_selection_checkBox'])[1]")
	private WebElement chkBeatSelection;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/beat_next_button")
	private WebElement BtnBeatNext;

//************************************Methods****************************************
	public void beatSelection() throws InterruptedException {
		commonUtilityA.clickElement(clkOutletVisit);

	}

	public void selectLanguage() throws InterruptedException {

		Thread.sleep(1000);
		commonUtilityA.clickElement(btnContinue);

	}

	public void initialPermission() throws InterruptedException {
		Thread.sleep(1000);
		commonUtilityA.clickElement(clkAccept);
		commonUtilityA.clickElement(clkOk);
		commonUtilityA.clickElement(clkWhileUsingApp);
		commonUtilityA.clickElement(clkWhileUsingApp);
		commonUtilityA.clickElement(clkWhileUsingApp);
		commonUtilityA.clickElement(clkAllow);
		commonUtilityA.clickElement(clkAllow);
		commonUtilityA.clickElement(clkAllow);
		Thread.sleep(1000);

	}



	public void mobileLogin(String UserName, String Password) throws Exception {
		commonUtilityA.sendKeys(txtUserName, UserName);
		commonUtilityA.hidekeyboard();
		commonUtilityA.clickElement(btnLogin);
		commonUtilityA.sendKeys(txtPassword, Password);
		commonUtilityA.hidekeyboard();
		commonUtilityA.clickElement(btnLogin1);
		initialDisclaimerAccept();

	}
	
	@FindBy(id="com.botree.mobilitysfa.preprodstage:id/cb_terms_conditions")
	WebElement chkAgree;
	
	@FindBy(xpath="//android.widget.TextView[@text=\"Agree\"]")
	WebElement btnAgree;
	
	public void selectAgree() {
		commonUtilityA.clickElement(chkAgree);
		commonUtilityA.clickElement(btnAgree);
	}
	

	public void clickSyncOk() throws InterruptedException {
		Thread.sleep(500);
		commonUtilityA.clickElement(syncOk);
		Thread.sleep(10000);

	}

	public void setActivity(String UserName, String Password) throws Exception {
		commonUtilityA.setActivity();
		commonUtilityA.sendKeys(txtUserName, UserName);
		commonUtilityA.hidekeyboard();
		commonUtilityA.clickElement(btnLogin);
		commonUtilityA.sendKeys(txtPassword, Password);
		commonUtilityA.hidekeyboard();
		commonUtilityA.clickElement(btnLogin1);
	}

	public void loginSwitchUser(String UserName, String Password) throws Exception {

		commonUtilityA.sendKeys(txtUserName, UserName);
		commonUtilityA.hidekeyboard();
		commonUtilityA.clickElement(btnLogin);
		commonUtilityA.clickElement(btnSyncAlertPopup);
		commonUtilityA.sendKeys(txtPassword, Password);
		commonUtilityA.hidekeyboard();
		commonUtilityA.clickElement(btnLogin1);
		initialDisclaimerAccept();
		

	}

	public void setActivitySwitchUser(String UserName, String Password) throws Throwable {

		commonUtilityA.setActivity();
		loginSwitchUser(UserName, Password);
		commonUtilityA.clickElement(syncOk);
		Thread.sleep(10000);

	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/alert_ok_btn")
	private WebElement btnSyncAlertPopup;

	// **************************************************MDSR***********************************************
	@FindBy(xpath = "//*[@text='SS Visit']")
	private WebElement clkSSVisit;

	@FindBy(xpath = "//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/distr_name']")
	List<WebElement> clkListDistributor;

	public void clickSSvisit() throws InterruptedException {
		Thread.sleep(10000);
		commonUtilityA.clickElement(clkSSVisit);
	}

	public void selectDistributor() throws InterruptedException {
		commonUtilityA.clickElement(clkListDistributor.get(0));
		Thread.sleep(4000);
	}

	public void clickOutletVisit() throws InterruptedException {
		commonUtilityA.clickElement(clkOutletVisit);
		Thread.sleep(2000);
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/sync_fab")
	private WebElement clkSyncButton;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/new_sync_menu_download")
	private WebElement btnDownload;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/alert_ok_btn")
	private WebElement btnDownloadOK;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/new_sync_menu_upload")
	private WebElement btnUpload;

	public void syncDownload() throws InterruptedException {
		commonUtilityA.clickElement(clkSyncButton);
		commonUtilityA.clickElement(btnDownload);
		commonUtilityA.clickElement(btnDownloadOK);
		Thread.sleep(9000);
		commonUtilityA.verifyVisiblity(clkOutletVisit);

	}
	
	
	public void syncUpload() throws InterruptedException {
		commonUtilityA.clickElement(clkSyncButton);
		commonUtilityA.clickElement(btnUpload);
		commonUtilityA.clickElement(btnDownloadOK);
		Thread.sleep(9000);
		commonUtilityA.verifyVisiblity(clkOutletVisit);

	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/cb_terms_conditions")
	private WebElement chkDisclaimer;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/ll_agree")
	private WebElement btnDisclaimerAccept;

	public void initialDisclaimerAccept() {
		if (commonUtilityA.elementIsDisplayed(chkDisclaimer)) {
			commonUtilityA.clickElement(chkDisclaimer);
			commonUtilityA.clickElement(btnDisclaimerAccept);	
		}else {
			System.out.println("There is no Disclaimer popup.");
		}
			
	}

//***********************************************************************************************************
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;
	@FindBy(xpath = "//*[text()='Login']")
	private WebElement btnWebLogin;

	public void enterWebCredentials(String UserName, String PassWord) throws Exception {
		commonUtilityS.sendkeys(userName, UserName);
		commonUtilityS.sendkeys(password, PassWord);
		commonUtilityS.clickElement(btnWebLogin);
		Thread.sleep(3000);
	}
	
	@FindBy(xpath="com.botree.mobilitysfa.preprodstage:id/idLogout")
	WebElement iconLogout;
	
	@FindBy(xpath="com.botree.mobilitysfa.preprodstage:id/alert_ok_btn")
	WebElement logoutYes;
	
	public void clickLogout() {
		commonUtilityA.clickElement(iconLogout);
		commonUtilityA.clickElement(logoutYes);
	}
}
