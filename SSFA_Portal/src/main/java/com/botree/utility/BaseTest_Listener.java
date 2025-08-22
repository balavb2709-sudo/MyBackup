package com.botree.utility;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.botree.ExtentReportListener.ExtentManager;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


public class BaseTest_Listener {

	private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();
    private static ThreadLocal<AppiumDriver> mobileDriver = new ThreadLocal<>();
    private static String apkPath = "\\APK\\PREPROD_STAGE_7.14.0_110325_1235.apk";

    public static WebDriver getWebDriver() {
        return webDriver.get();
    }

    public static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }
    
    public static AppiumDriver getMobileDriver() {
        return mobileDriver.get();
    }
    
    public static void setMobileDriver(AppiumDriver driver) {
        mobileDriver.set(driver);
    }

    public static void initializeWebDriver() {

        WebDriver webdriver = new ChromeDriver();
        
        setWebDriver(webdriver);
        webdriver.manage().window().maximize();
        webdriver.get("https://sfa-stage-preprod3.botreesoftware.com/#/");
        webdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }
//http://127.0.0.1:4723
  @BeforeTest
  @Parameters({"deviceName","systemPort","url"})
	public static void initializeAppiumDriver(
			String deviceName,String systemPort,String url  ) throws MalformedURLException {
    	UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName(deviceName);	
		options.setSystemPort(Integer.parseInt(systemPort));
		options.setNewCommandTimeout(Duration.ofMinutes(30));
		options.setAdbExecTimeout(Duration.ofMillis(20000));
		options.setUdid(deviceName);
		options.setApp(System.getProperty("user.dir") + apkPath);
		 AppiumDriver mobileDriver = new AndroidDriver(new URL(url), options);
		setMobileDriver(mobileDriver);
		mobileDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
    }


    public static void quitWebDriver() {
        if (getWebDriver() != null) {
            getWebDriver().quit();
            webDriver.remove();
        }
    }
    public static void quitMobileDriver() {
        if (getMobileDriver() != null) {
            getMobileDriver().quit();
            mobileDriver.remove();
        }
    }
    @BeforeSuite(alwaysRun=true)  
    public void setUp() throws MalformedURLException {
    	ExtentManager.setExtent();
  
    }
    
    @AfterSuite
    public void tearDownMobileDriver() throws InterruptedException {
        BaseTest_Listener.quitMobileDriver();
        ExtentManager.endReport();
     // Create();
    }

    
    @BeforeMethod
    public void setUpWebDriver() throws Exception {
    	BaseTest_Listener.initializeWebDriver();
       
    }

    @AfterMethod
    public void tearDownWebDriver() {
    	   BaseTest_Listener.quitWebDriver();
    }
    
    public static String mobileScreenShot(String filename) {
    	AppiumDriver mobileDriver = getMobileDriver();
    	
		try {
			
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) mobileDriver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/ScreenShots/AppiumScreenShots/" + filename + "_" + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			
			e.getMessage();
		}
		return destination;
		}catch (Exception e) {
			System.out.println("Appium Screenshot method is not working");
		}
		return filename;
		 }  
    
    
    public static String webScreenShot(String filename) {
    	
    	WebDriver webDriver = getWebDriver();
		try {
			
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot takesScreenshot = (TakesScreenshot) webDriver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "/ScreenShots/SeleniumScreenShots/" + filename + "_" + dateName + ".png";
		File finalDestination = new File(destination);
		try {
			FileUtils.copyFile(source, finalDestination);
		} catch (Exception e) {
			
			e.getMessage();
		}
		return destination;
		}catch (Exception e) {
			System.out.println("Selenium Screenshot method is not working");
		}
		return filename;
		 }    
    
  
    
    
    
    
    
    
    
    
    
}
