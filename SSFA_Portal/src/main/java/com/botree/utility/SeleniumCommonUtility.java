package com.botree.utility;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumCommonUtility extends BaseTest_Listener {
	
	WebDriver webDriver = getWebDriver();
	WebDriverWait wait;
	Actions action;

//Scroll to make a WebElement into visible
	public void scrollIntoView(WebElement element) throws InterruptedException {
		try {
			explicitWait(element);
			((JavascriptExecutor) webDriver).executeScript("arguments[0].scrollIntoView();", element);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//implicit wait in seconds
	public void implicityWait(int x) {
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(x));
	}

//MouseOver & Click
	public void mouseOverClick(WebElement element) {
		explicitWait(element);
		try {
			action = new Actions(webDriver);
			action.moveToElement(element).click().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// MouseOver & doubleClick
	public void mouseOverDoubleClick(WebElement element) {
		explicitWait(element);
		try {
			action = new Actions(webDriver);
			action.moveToElement(element).doubleClick().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// MouseOver & rightClick
	public void mouseOverRightClick(WebElement element) {
		explicitWait(element);
		try {
			action = new Actions(webDriver);
			action.moveToElement(element).contextClick().build().perform();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// current URL
	public String getCurrentUrl() throws Exception {
		String currentUrl = null;
		try {
			currentUrl = webDriver.getCurrentUrl();
			System.out.println(currentUrl);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("if Url is not present");
		}
		return currentUrl;
	}

	// Compare text
	public String compareText(By by) throws Exception {
		String str1 = null;
		try {
			WebElement element = webDriver.findElement(by);
			String str = element.getText();
			System.out.println(str);
			str.compareTo(str1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Text compared");

		}
		return str1;

	}

	// Visibility text
	public void verifyVisibility(WebElement element) throws Throwable {
		explicitWait(element);
		try {
		//	if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				element.isDisplayed();
			}
		 catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("Element is visible");
		}
	}

//verify TextBox in disable mode
	public boolean txtBoxNonEditable(WebElement element) {
		Boolean readOnly = false;
		explicitWait(element);
		readOnly = ((element.getAttribute("disabled") != null) || (element.getAttribute("readonly") != null));
		return readOnly;
	}

	public String currentdatePlusFivedays() {
		DateFormat Format = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, 5);
		String newDate = Format.format(cal.getTime());
		return newDate;
	}

	public String currentdatePMinusTwodays() {
		DateFormat Format = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		cal.add(Calendar.DATE, -2);
		String newDate = Format.format(cal.getTime());
		return newDate;
	}

	public static String getCurrentDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
		Date date = new Date();
		return dateFormat.format(date);
	}

	public static String getCurrentYear() {
		DateFormat dateFormat = new SimpleDateFormat("YYYY");
		Date date = new Date();
		return dateFormat.format(date);
	}

	// send keys
	public void sendkeys(WebElement element, String str) throws Exception {
		explicitWait(element);
		try {
			if (elementIsDisplayed(element) && elementIsEnabled(element)) {
				element.click();
			//	element.clear();
				element.sendKeys(str);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new Exception("values are not present");
		}

	}

	// get title
	public String getTitle() {
		String title = null;
		try {
			title = webDriver.getTitle();
			System.out.println(title);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return title;
	}

	// To click
	public void clickElement(WebElement element) {
		try {
			explicitWait(element);
			element.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

//Verify checkBox Is Selected
	public void verifyCheckBoxIsSelected(WebElement element) {
		try {
			explicitWait(element);
			element.isSelected();
			System.out.println(element + "CheckBox Is Selected");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("CheckBox Is Not Selected");
		}
	}

	// navigate to
	public void navigateTo(String url) {
		try {
			webDriver.navigate().to(url);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// navigate back
	public void navigateBack() {
		try {
			webDriver.navigate().back();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// navigate forward
	public void navigateForward() {
		try {
			webDriver.navigate().forward();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// navigate refresh
	public void navigateRefresh() {
		try {
			webDriver.navigate().refresh();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// get Text
	public void getText(WebElement element) {
		try {
			String text = element.getText();
			System.out.println(text);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// get Attribute
	public void getAttribute(WebElement element) {
		try {
			String attribute = element.getAttribute("Value");
			System.out.println(attribute);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	// drop down have a select Tag
	public void dropDownSelect(WebElement element, String str) {
		Select select = new Select(element);
		select.selectByVisibleText(str);

	}
	

	// window handles
	public void Windowhandles(WebElement element) {
		String childid = webDriver.getWindowHandle();
		element.click();
		Set<String> parentid = webDriver.getWindowHandles();
		String y = null;
		for (String d : parentid) {
			if (!d.equals(childid)) {
				y = d;
			}
		}
		webDriver.switchTo().window(y);

	}
	
	
	//windows Handles2
	
	public void WindowHandels2() {
		
		ArrayList<String> tabs = new ArrayList<String> (webDriver.getWindowHandles());
 		webDriver.switchTo().window(tabs.get(1));
 		webDriver.close();
 	    webDriver.switchTo().window(tabs.get(0));
	}

	// Alerts
	public void Alert(WebElement element, String var) {
		element.click();
		Alert alert = webDriver.switchTo().alert();
		if (var == "accept") {
			alert.accept();
			webDriver.switchTo().defaultContent();
		} else {
			alert.dismiss();
			webDriver.switchTo().defaultContent();

		}

	}

	public void close() {
		webDriver.close();
	}

	// quit
	public void quit() {
		webDriver.quit();
	}

//Move to mouse to particular WebElement
	public void moveToElement(WebElement element) {
		Actions action = new Actions(webDriver);
		action.moveToElement(element).build().perform();

	}

	// drag and drop
	public void dragAndDrop(WebElement element1, WebElement element2) {

		Actions ac = new Actions(webDriver);
		ac.dragAndDrop(element1, element2).build().perform();

	}

	// i-Frames

	public void iframes(WebElement element) {
		webDriver.switchTo().frame(element);

	}

	// explicit wait

	public void explicitWait(WebElement element) {

		try {
			wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOf(element));
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ExplicitWait For list<WebElement>
	public void explicitWaitList(List<WebElement> element) {
		try {
			wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			Thread.sleep(500);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// is displayed
	public boolean elementIsDisplayed(WebElement element) {
		boolean displayed = false;

		try {
			displayed = element.isDisplayed();
		} catch (Exception e) {
			System.out.println("Element is not displayed " +element);
		}

		return displayed;

	}

	// is enabled
	public boolean elementIsEnabled(WebElement element) {
		boolean enabled = false;

		try {
			enabled = element.isEnabled();
		} catch (Exception e) {
			
		//	e.printStackTrace();
			System.out.println("Element is not enabled" +element);
		}
		return enabled;

	}

	// is selected
	public boolean elementIsSelected(WebElement element) {

		boolean selected = false;
		try {
			selected = element.isSelected();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return selected;
	}

	// get url

	public void launchUrl(String url) {

		webDriver.get(url);

	}
	// Compare the string with List<WebElement> in dropdown 
	public void dropDownClick(By element, String str) throws InterruptedException {

		Thread.sleep(2000);
		List<WebElement> allOptions = webDriver.findElements(element);
		System.out.println(allOptions.size());
		for (int i = 0; i < allOptions.size(); i++) {

			if (allOptions.get(i).getText().equals(str)) {

				allOptions.get(i).click();
				break;
			}

		}
	}

	// Compare the string with List<WebElement> & click
	public void iterateListAndClick(List<WebElement> allElements, String str) throws InterruptedException {

		explicitWaitList(allElements);
		System.out.println(allElements.size());
		for (int i = 0; i < allElements.size(); i++) {

			if (allElements.get(i).getText().equals(str)) {

				allElements.get(i).click();
				break;
			}

		}
	}

	// click calendar icon & select year,month,date
	public void selectCalendarDate(WebElement calendar, WebElement year, String Years, WebElement month, String months,
			List<WebElement> allDates, String date) throws Throwable {
		try {

			explicitWait(calendar);
			calendar.click();
			explicitWait(year);
			dropDownSelect(year, Years);
			dropDownSelect(month, months);
			iterateListAndClick(allDates, date);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

//clear
	public void clear(WebElement element) {
		element.clear();

	}
	
	//entered values should be copied to clipboard
	public void setClipBoardValue(String file) {
		try {
			StringSelection obj = new StringSelection(file);
			
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(obj, null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
				
	}
	Robot robot;
	public void clickRobotUpArrow() throws AWTException, InterruptedException {

		  robot = new Robot();
		  Thread.sleep(2000);
		  robot.keyPress(KeyEvent.VK_ALT);
          robot.keyPress(KeyEvent.VK_TAB);
          robot.keyRelease(KeyEvent.VK_TAB);
          robot.keyRelease(KeyEvent.VK_ALT);
          Thread.sleep(1000); 
          robot.keyPress(KeyEvent.VK_UP);
          Thread.sleep(100);
          robot.keyRelease(KeyEvent.VK_UP);      
          Thread.sleep(100);
          System.out.println("Page Up key pressed");
	}

}
