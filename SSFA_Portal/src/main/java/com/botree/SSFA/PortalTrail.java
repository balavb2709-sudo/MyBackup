package com.botree.SSFA;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.botree.utility.AndroidCommonUtility;
import com.botree.utility.BaseTest_Listener;
import com.botree.utility.SeleniumCommonUtility;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;

public class PortalTrail extends BaseTest_Listener {
	AppiumDriver mobileDriver = getMobileDriver();
	WebDriver webDriver = getWebDriver();

	public PortalTrail(AppiumDriver appiumDriver) {
		this.mobileDriver = appiumDriver;
		PageFactory.initElements(appiumDriver, this);
	//	PageFactory.initElements(new AppiumFieldDecorator(appiumDriver), this);
	}

	public PortalTrail(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	AndroidCommonUtility commonUtility = new AndroidCommonUtility();
	SeleniumCommonUtility commonUtility1 = new SeleniumCommonUtility();
	@FindBy(xpath = "//input[@id='username']")
	private WebElement txtUserName;

	public void trailmethod() throws Exception {
		System.out.println("Trail is ok");
		// String URL=webDriver.getCurrentUrl();
		commonUtility1.getCurrentUrl();
		commonUtility1.getTitle();
		// commonUtility1.sendkeys(txtUserName, "SuperAdmin");
		// enterCredentials();
		// System.out.println(URL);
	}

	public void sendAppToBackground() {
		try {
			Runtime.getRuntime().exec("adb shell input keyevent KEYCODE_HOME");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@FindBy(xpath = "//input[@id='username']")
	private WebElement userName;
	@FindBy(xpath = "//input[@id='password']")
	private WebElement password;

	public void enterCredentials(String UserName,String PassWord) throws Exception {
//		webDriver.findElement(By.xpath("//input[@id='username']")).sendKeys("SuperAdmin");
//		webDriver.findElement(By.xpath("//input[@id='password']")).sendKeys("$uperAdmin");
		commonUtility1.sendkeys(userName, UserName);
		commonUtility1.sendkeys(password,PassWord);
		webDriver.findElement(By.xpath("//*[text()='Login']")).click();
		Thread.sleep(3000);
	}

	public static String portalValue = null;

	public void getValue() throws InterruptedException {
		//// span[@id='p-panel-0_header']
		portalValue = webDriver.findElement(By.xpath("//span[@id='p-panel-0_header']")).getText();
		System.out.println(portalValue);
		Thread.sleep(2000);
	}

	public void dummyMethod() throws InterruptedException {
		System.out.println(portalValue1 + " Trail2 completed every is working fine TC:2 passed");
		Thread.sleep(3000);
	}

	// span[@id='p-panel-1_header']
	public static String portalValue1 = null;

	public void getValue1() throws InterruptedException {
		//// span[@id='p-panel-0_header']
		portalValue1 = webDriver.findElement(By.xpath("//span[@id='p-panel-1_header']")).getText();
		System.out.println(portalValue1);
		Thread.sleep(2000);
	}

	// *****************************************APK*******************************************************
	private static String apkPath = "\\APK\\botreessfa-vansales-V7.3.0_01-Apr-2024.apk";
	private static String deviceName = "emulator-5554";

//	public static void initializeAppiumDriver() throws MalformedURLException, InterruptedException {
//
//		UiAutomator2Options options = new UiAutomator2Options();
//		options.setDeviceName(deviceName);
//		options.setSystemPort(8201);
//		options.setUdid(deviceName);
//		options.setApp(System.getProperty("user.dir") + apkPath);
//		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
//
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		Thread.sleep(3000);
//
//	}

	String AppPackage = "com.botree.productsfa.botreessfa";
	String AppActivity = "com.botree.productsfa.main.LoginActivity";

	// Directly switch to another window
	@SuppressWarnings("deprecation")
	public void setActivity() throws InterruptedException {
		Thread.sleep(500);
		Activity activity = new Activity(AppPackage, AppActivity);
		Thread.sleep(500);
		((StartsActivity) mobileDriver).startActivity(activity);
	}

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_foreground_only_button")
	private WebElement clkWhileUsingApp;// 3

	@FindBy(id = "com.botree.productsfa.botreessfa:id/accept_disclosure")
	private WebElement clkAccept;

	@FindBy(id = "android:id/button1")
	private WebElement clkOk;

	@FindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
	private WebElement clkAllow;// 2

	@FindBy(xpath = "(//*[@resource-id='com.botree.productsfa.botreessfa:id/constraint_layout'])[2]")
	private WebElement clkLanguageEnglish;

//	@FindBy(id = "com.botree.productsfa.botreessfa:id/continueTXT")
//	private WebElement btnContinue;
	@FindBy(id = "com.botree.productsfa.botreessfa:id/continueTXT")
	private WebElement continueButton;

	public void appiumPermissionSetting1() throws InterruptedException {
		Thread.sleep(1000);
		commonUtility.clickElement(continueButton);
		Thread.sleep(3000);
		commonUtility.clickElement(clkAccept);
		commonUtility.clickElement(clkOk);
		commonUtility.clickElement(clkWhileUsingApp);
		commonUtility.clickElement(clkWhileUsingApp);
		commonUtility.clickElement(clkWhileUsingApp);
		commonUtility.clickElement(clkAllow);
		commonUtility.clickElement(clkAllow);
		commonUtility.clickElement(clkAllow);
		System.out.println(portalValue + " Sucessfully get the value from portal TC:1 passed");
		Thread.sleep(3000);

	}

	public void appiumPermissionSetting() throws InterruptedException {
		Thread.sleep(1000);
		mobileDriver.findElement(By.id("com.botree.productsfa.botreessfa:id/continueTXT")).click();

		Thread.sleep(3000);
		mobileDriver.findElement(By.id("com.botree.productsfa.botreessfa:id/accept_disclosure")).click();
		mobileDriver.findElement(By.id("android:id/button1")).click();
		mobileDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))
				.click();
		mobileDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))
				.click();
		mobileDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_foreground_only_button"))
				.click();
		mobileDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		mobileDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		mobileDriver.findElement(By.id("com.android.permissioncontroller:id/permission_allow_button")).click();
		Thread.sleep(1000);

		System.out.println(portalValue + " Sucessfully get the value from portal TC:1 passed");
		Thread.sleep(3000);
	}

//	public void quitAppiumDriver() {
//
//		if (driver != null) {
//			driver.quit();
//
//		} else {
//			System.out.println("Appium driver is already null");
//		}
//	}

	@FindBy(xpath="/html/body/app-root/app-landing/div/div/div[1]/ng-component/div[2]/div[1]/div/div[2]/div[1]")
	private WebElement txtDistributor;
	
	public void printDataInHomeScreen() {
		Assert.assertEquals(txtDistributor.getText(), "Distributor / Retailers");
		System.out.println(txtDistributor.getText());
	}
	
	@FindBy(xpath="//div[@class='layout-topbar-menu-wrapper']/a[1]")
	private WebElement profileIcon;
	
	@FindBy(xpath="//span[@class='topbar-item-name profile-name']")
	private WebElement profile;
	
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	private WebElement logout;
	
	public void clickLogout() {
		commonUtility.clickElement(profileIcon);
		commonUtility.clickElement(profile);
		commonUtility.clickElement(logout);
	}
}
