package com.botree.utility;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.HidesKeyboard;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.StartsActivity;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.nativekey.PressesKey;
import io.appium.java_client.touch.offset.PointOption;

public class AndroidCommonUtility extends BaseTest_Listener {
	AppiumDriver mobileDriver = getMobileDriver();
	WebDriverWait wait;

	// Perform double-click by using JavaScriptExecutor
	public void doubleClick(By ele) {
		WebElement element = mobileDriver.findElement(ele);
		if (element instanceof RemoteWebElement) {
			String elementId = ((RemoteWebElement) element).getId();
			((JavascriptExecutor) mobileDriver).executeScript("mobile: doubleClickGesture",
					ImmutableMap.of("elementId", elementId));
		} else {
			System.out.println("Double Click not performed : " + ele);
		}
	}

	// Perform LongPress by using JavaScriptExecutor
	public void longPress(By ele) {
		WebElement element = mobileDriver.findElement(ele);
		if (element instanceof RemoteWebElement) {
			String elementId = ((RemoteWebElement) element).getId();
			((JavascriptExecutor) mobileDriver).executeScript("mobile: longClickGesture",
					ImmutableMap.of("elementId", elementId, "duration", 2000));
		} else {
			System.out.println("LongPress Action not performed" + ele);
		}
	}

	// Perform Long-Click by using JavaScriptExecutor
	public void longClick(By ele) {
		WebElement element = mobileDriver.findElement(ele);
		if (element instanceof RemoteWebElement) {
			String elementId = ((RemoteWebElement) element).getId();
			((JavascriptExecutor) mobileDriver).executeScript("mobile: longClickGesture",
					ImmutableMap.of("elementId", elementId));
		} else {
			System.out.println("LongClick Action not performed" + ele);
		}
	}

//up, down, left and right
// SwipeAction
	public void swipeAction(By ele, String direction) {
		try {
			WebElement element = mobileDriver.findElement(ele);
			if (element instanceof RemoteWebElement) {
				String elementId = ((RemoteWebElement) element).getId();
				((JavascriptExecutor) mobileDriver).executeScript("mobile: swipeGesture",
						ImmutableMap.of("elementId", elementId, "direction", direction, "percent", 0.75));
			} else {
				System.out.println("Swipe action not performed" + ele);
			}
		} catch (Exception e) {
			System.out.println("Swipe action not performed" + ele);
			e.printStackTrace();
		}
	}

	// ExplicitWait For list<WebElement>
	public void explicitWaitList(List<WebElement> element) {
		try {
			wait = new WebDriverWait(mobileDriver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			Thread.sleep(200);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// Iterate and text based click in (<List>WebElement)
	public void iterateAndClick(List<WebElement> element, String textOfElement) {
		explicitWaitList(element);
		for (WebElement i : element) {
			if (i.getText().equalsIgnoreCase(textOfElement)) {
				System.out.println(i);
				i.click();
				break;
			}
		}
	}

	String AppPackage = "com.botree.mobilitysfa.preprodstage";
	String AppActivity = "com.botree.productsfa.main.LoginActivity";

	// Directly switch to another window
	@SuppressWarnings("deprecation")
	public void setActivity() throws InterruptedException {
		Thread.sleep(500);
		Activity activity = new Activity(AppPackage, AppActivity);
		Thread.sleep(500);
		((StartsActivity) mobileDriver).startActivity(activity);
	}

	// Waiting for sync
	public void verifyInvisiblityOfElement(WebElement element) {

		try {
			wait = new WebDriverWait(mobileDriver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.invisibilityOf(element));
		} catch (Exception e) {
			System.out.println("Time out to invisible the WebElement" + element);
			e.printStackTrace();
		}
	}

	// Visibility of WebElement
	public boolean verifyVisiblity(WebElement element) {
		boolean visiblity = false;
		WebDriverWait wait = new WebDriverWait(mobileDriver, Duration.ofSeconds(10));

		try {
			wait.until(ExpectedConditions.visibilityOf((element)));

		} catch (Exception e) {
			System.out.println("Time out to visible the WebElement" + element);
			e.printStackTrace();
		}
		return visiblity;
	}

	public void explicitWait(WebElement element) {

		try {
			WebDriverWait wait = new WebDriverWait(mobileDriver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOf(element));

		} catch (Exception e) {

			e.printStackTrace();
		}
	}

	// send keys
	public void sendKeys(WebElement element, String str) throws Exception {
		explicitWait(element);
		try {
			element.click();
			element.clear();
			element.sendKeys(str);

		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception("Sendkeys not performed. " + "" + element);
		}
	}

	// Perform click action
	public void clickElement(WebElement element) {
		explicitWait(element);
		try {
			element.click();
		} catch (Exception e) {
			System.out.println("Click action not performed in:" + element);
			e.printStackTrace();
		}

	}

	// Hide the keyboard
	public void hidekeyboard() {
		try {
			((HidesKeyboard) mobileDriver).hideKeyboard();
		} catch (Exception e) {
			System.out.println("Keyboard not hided");
			e.printStackTrace();
		}
	}

	// isDisplayed
	public boolean elementIsDisplayed(WebElement element) {
		boolean displayed = false;

		try {
			displayed = element.isDisplayed();
		} catch (Exception e) {

			// e.printStackTrace();
			System.out.println("Element is not displayed " + element);
		}

		return displayed;

	}

	// is enabled

	public boolean elementIsEnabled(WebElement element) {
		boolean enabled = false;

		try {
			enabled = element.isEnabled();
		} catch (Exception e) {

			e.printStackTrace();
		}
		return enabled;

	}

	// Verify checkBox Is Selected
	public void verifyCheckBoxIsSelected(WebElement element) {
		try {
			explicitWait(element);
			element.isSelected();
			System.out.println(element + "CheckBox Is Selected");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("CheckBox Is Not Selected");
		}
	}

	public void swipeVertical(By ele) throws InterruptedException {
		WebElement element = mobileDriver.findElement(ele);
		if (element instanceof RemoteWebElement) {
			String elementId = ((RemoteWebElement) element).getId();
			((JavascriptExecutor) mobileDriver).executeScript("arguments[0].scrollIntoView();", element);
			((JavascriptExecutor) mobileDriver).executeScript("scroll(0,25);");
		} else {
			System.out.println("LongClick Action not performed" + ele);
		}

	}
	// Swipe & Scroll in horizontal

	public void swipeHorizontal(By ele) throws InterruptedException {
		WebElement element = mobileDriver.findElement(ele);
		if (element instanceof RemoteWebElement) {

			Thread.sleep(500);
			((JavascriptExecutor) mobileDriver).executeScript("arguments[0].scrollIntoView();", element);
			((JavascriptExecutor) mobileDriver).executeScript("scroll(25,0);");
		} else {
			System.out.println("HorizontalSwipe Action not performed" + ele);
		}

	}

//Text based scroll & click
	public void scrollAndClick(String visibleText) {
		try {
			mobileDriver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ visibleText + "\").instance(0))"))
					.click();
			;
		} catch (Exception e) {
			System.out.println("Text based scroll & click not performed " + visibleText);
			e.printStackTrace();
		}
	}

//press back key in mobile
	public void pressBackKey() {
		try {
			Thread.sleep(200);
			((PressesKey) mobileDriver).pressKey(new KeyEvent(AndroidKey.BACK));
		} catch (Exception e) {
			System.out.println("Press back key not performed " + e.getMessage());
			e.printStackTrace();
		}
	}

	// press home button in mobile
	public void pressHomeKey() {
		try {
			Thread.sleep(500);
			((PressesKey) mobileDriver).pressKey(new KeyEvent(AndroidKey.HOME));
		} catch (Exception e) {
			System.out.println("Press Home key not performed " + e.getMessage());
			e.printStackTrace();
		}
	}

	// press enter button in mobile
	public void pressEnterKey() {
		try {
			Thread.sleep(500);
			((PressesKey) mobileDriver).pressKey(new KeyEvent(AndroidKey.ENTER));
		} catch (Exception e) {
			System.out.println("Press Enter key not performed " + e.getMessage());
			e.printStackTrace();
		}
	}

	public void scrollBasedOnText(String visibleText) {
		try {
			Thread.sleep(100);
			mobileDriver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""
							+ visibleText + "\").instance(0))"));
		} catch (Exception e) {
			System.out.println("Scroll Action not performed" + e.getMessage());
		}
	}

//used for unique id only
	public void scrollToId(String id) {
		try {
			mobileDriver.findElement(AppiumBy
					.androidUIAutomator("new UiScrollable(" + "new UiSelector().scrollable(true)).scrollIntoView("
							+ "new UiSelector().resourceIdMatches(\"" + id + "\"));"));
		} catch (Exception e) {
			System.out.println("ScrollToId not performed" + e.getMessage());
		}
	}

	public void scrollToUp(int x) {
		try {
			mobileDriver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true)).scrollToBeginning(" + x + ")"));
		} catch (Exception e) {
			System.out.println("Scroll to Up Action not performed" + e.getMessage());
		}
	}

	public void scrollToEnd(int x) {
		try {
			mobileDriver.findElement(AppiumBy
					.androidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).scrollToEnd(" + x + ")"));

		} catch (Exception e) {
			System.out.println("Scroll to End Action not performed" + e.getMessage());
		}
	}

//Scroll by using start Coordinates(x1,y1) to End Coordinates(x2,y2)
	@SuppressWarnings("deprecation")
	public void scrollByCoordinates(int x1, int y1, int x2, int y2) {

		try {

			@SuppressWarnings("rawtypes")
			TouchAction touchAction = new TouchAction((PerformsTouchActions) mobileDriver);
			Thread.sleep(200);
			touchAction.longPress(PointOption.point(x1, y1)).moveTo(PointOption.point(x2, y2)).release().perform();
		} catch (Exception e) {
			System.out.println("Scroll By Coordinates not working");
		}

	}

//Click by using Coordinates
	@SuppressWarnings("deprecation")
	public void clickByCoordinates(int x1, int y1) {

		try {

			@SuppressWarnings("rawtypes")
			TouchAction touchAction = new TouchAction((PerformsTouchActions) mobileDriver);
			Thread.sleep(500);
			touchAction.tap(PointOption.point(x1, y1)).release().perform();
		} catch (Exception e) {
			System.out.println("Click By Coordinates not working");
		}

	}

//LongPress by using Coordinates
	@SuppressWarnings("deprecation")
	public void longPressByCoordinates(int x1, int y1) {

		try {

			@SuppressWarnings("rawtypes")
			TouchAction touchAction = new TouchAction((PerformsTouchActions) mobileDriver);
			Thread.sleep(500);
			touchAction.longPress(PointOption.point(x1, y1)).release().perform();
		} catch (Exception e) {
			System.out.println("LongPress By Coordinates not working");
		}

	}

	public void clear(WebElement element) {
		try {
			element.clear();
		} catch (Exception e) {
			System.out.println("Clear not performed");
		}
	}

	// eg. 35.456==>35.45
	@SuppressWarnings("deprecation")
	public double extractNumberWithTwoDecimalDigits(double originalDoubleValue) {

		BigDecimal originalBigDecimal = new BigDecimal(String.valueOf(originalDoubleValue));
		BigDecimal adjustedBigDecimal = originalBigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
		double result = adjustedBigDecimal.doubleValue();
		System.out.println("Extracted Number with Two Digits After Decimal: " + result);
		return result;
	}

	// ****************************************************************************************************************
	public void scrollAndClickParticularText(List<WebElement> elementList, String module, int x) {

		boolean elementFound = false;
		while (!elementFound) {
			try {
				for (WebElement companyuser : elementList) {
					if (companyuser.getText().equalsIgnoreCase(module)) {
						System.out.println("Element found: " + companyuser.getText());
						companyuser.click();
						elementFound = true;
						break;
					}
				}
				if (!elementFound) {
					// scrollByCoordinates(884, 1710, 884, 350);
					scrollToEnd(x);
					iterateAndClick(elementList, module);
					break;
				}
			} catch (Exception e) {
				System.out.println("Error while searching: " + e.getMessage());
				break;
			}
		}
		if (!elementFound) {
			System.out.println("Element with name containing : " + module + " not found.");
		}
	}

	public void swipeAndClickParticularDashBoardModule(List<WebElement> elementList, String module) {

		boolean elementFound = false;
		while (!elementFound) {
			try {
				for (WebElement companyuser : elementList) {
					if (companyuser.getText().equalsIgnoreCase(module)) {
						System.out.println("Element found: " + companyuser.getText());
						companyuser.click();
						elementFound = true;
						break;
					}
				}
				if (!elementFound) {
					scrollByCoordinates(1055, 517, 88, 517);

					iterateAndClick(elementList, module);
					break;
				}
			} catch (Exception e) {
				System.out.println("Error while searching: " + e.getMessage());
				break;
			}
		}
		if (!elementFound) {
			System.out.println("Element with name containing : " + module + " not found.");
		}
	}
	
	 public String getCurrentDate() {
   	  LocalDate currentDate = LocalDate.now();
         String formattedDate = currentDate.format(DateTimeFormatter.ISO_DATE);
         System.out.println(formattedDate);
       return formattedDate;
   }
	
	
	
	
	
	
	

}