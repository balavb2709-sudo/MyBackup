package com.botree.FebCR;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.botree.utility.AndroidCommonUtility;
import com.botree.utility.BaseTest_Listener;
import com.botree.utility.SeleniumCommonUtility;

import io.appium.java_client.AppiumDriver;

public class CapturePoDateAndNoInOrderBookingSummaryPage extends BaseTest_Listener {

	AppiumDriver mobileDriver = getMobileDriver();
	WebDriver webDriver = getWebDriver();

	public CapturePoDateAndNoInOrderBookingSummaryPage(AppiumDriver appiumDriver) {
		this.mobileDriver = appiumDriver;
		PageFactory.initElements(appiumDriver, this);

	}

	public CapturePoDateAndNoInOrderBookingSummaryPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	AndroidCommonUtility commonUtilityA = new AndroidCommonUtility();
	SeleniumCommonUtility commonUtilityS = new SeleniumCommonUtility();

	// ************Page Factory***********************//

	// Portal xpath and methods

	@FindBy(xpath = "//span[text()='Configuration']")
	WebElement btnConfiguration;
	@FindBy(xpath = "//*[@class='fa fa-fw fa-bars']")
	private WebElement btnHomeBar;

	public void clickconfigurartion() {
		if (commonUtilityS.elementIsDisplayed(btnHomeBar)) {
			commonUtilityS.clickElement(btnHomeBar);
			commonUtilityS.clickElement(btnConfiguration);
		} else {
			commonUtilityS.clickElement(btnConfiguration);
		}

	}

	@FindBy(xpath = "//span[text()='ApplicationConfiguration']")
	WebElement drpApplicationconfiguration;

	public void clickApplicationConfiguration() {

		commonUtilityS.clickElement(drpApplicationconfiguration);
	}

	@FindBy(xpath = "//h1[text()='Application Configuration']")
	WebElement headerApplicationconf;

	public void verifyAppConfHeader(String AppconfHeader) {

		Assert.assertEquals(headerApplicationconf.getText(), AppconfHeader);
		System.out.println("Application configuration header verifyed");
	}

	@FindBy(xpath = "(//div[@class='overview-box-icon'])[1]")
	WebElement btnMarketVisit;

	public void clickMarketVisit() {

		commonUtilityS.clickElement(btnMarketVisit);
	}

	@FindBy(xpath = "//*[text()='Y- means to display the PO Number, PO Date & PO Remarks to new view. - (EnablePurchaseOrderCapture)']")
	WebElement cmpConfigurationpoint01;

	@FindBy(xpath = "//input[@id='EnablePurchaseOrderCaptureY']")
	WebElement cmpConfigurationpoint01Yes;

	@FindBy(xpath = "//input[@id='EnablePurchaseOrderCaptureN']")
	WebElement cmpConfigurationpoint01No;

	public void scrollToTheConfiguration() throws Throwable {

		commonUtilityS.scrollIntoView(cmpConfigurationpoint01);
		commonUtilityS.clickRobotUpArrow();
		commonUtilityS.clickRobotUpArrow();

		Thread.sleep(2000);

	}

	public void poNumAndDateconfigurationNo() {
		commonUtilityS.clickElement(cmpConfigurationpoint01No);
	}

	public void poNumAndDateconfigurationYes() {
		commonUtilityS.clickElement(cmpConfigurationpoint01Yes);
	}

	@FindBy(xpath = "//button[@label='Save']")
	WebElement btnMarketVisitSave;

	@FindBy(xpath = "//span[text()='Yes']")
	WebElement btnSaveYes;

	public void NavigatetoTopandSave() throws Throwable {

		commonUtilityS.scrollIntoView(headerApplicationconf);
		commonUtilityS.clickElement(btnMarketVisitSave);
		commonUtilityS.clickElement(btnSaveYes);
	}

	// *************************APK************************************

	@FindBy(xpath = "//span[normalize-space()='Report']")
	private WebElement drpFieldActivity;
	// span[normalize-space()='Outlet Reports']

	@FindBy(xpath = "//*[@text='Outlet Visit']") // (//android.widget.ImageView[@resource-id="com.botree.productsfa.botreessfa:id/navigation_bar_item_icon_view"])[2]
	private WebElement clkOutletVisit;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.botree.mobilitysfa.preprodstage:id/tv_route_name\" ]")
	private List<WebElement> chkBeatSelection;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/beat_next_button")
	private WebElement BtnBeatNext;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/spinner_item")
	private WebElement drpSelectOutlet;

	@FindBy(id = "android:id/text1")
	private List<WebElement> drpListSelectOutlet;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.botree.mobilitysfa.preprodstage:id/retailer_name\" ]")
	private List<WebElement> txtRetailerName;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/remarks_submit_btn")
	private WebElement btnRemarksOk;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/button_ok")
	private WebElement btnOutletInfoPopupOk;

	@FindBy(xpath = "//*[@text='SHOP CLOSED']")
	private WebElement reason;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/alert_msg_ok_btn")
	private WebElement btnWorkingHrsPopupOk;

	@FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Pending\"]")
	private WebElement btnPending;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.botree.mobilitysfa.preprodstage:id/notifications_title_txt\" and @text=\"Completed\"]")
	private WebElement btnCompleted;

	public void beatSelection() throws InterruptedException {
		commonUtilityA.clickElement(clkOutletVisit);
		commonUtilityA.clickElement(chkBeatSelection.get(0));
		commonUtilityA.clickElement(BtnBeatNext);

	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/toolbar_title")
	private WebElement labelOutletVisit;

	public void verifyOutletVisitTab() {
		commonUtilityA.verifyVisiblity(labelOutletVisit);
		Assert.assertEquals(labelOutletVisit.getText(), "Outlet Visit");
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/order_book_text")
	private WebElement labelOrderBooking;

	public void verifyOrderBookingTab() {
		commonUtilityA.verifyVisiblity(labelOrderBooking);
		Assert.assertEquals(labelOrderBooking.getText(), "Order Booking");
	}

	public static String RetailerName;
	public static String RetailerNameInUpperCase;

	public void verifyRetailerisDisplayed() {
		commonUtilityA.verifyVisiblity(txtRetailerName.get(0));
		RetailerName = txtRetailerName.get(0).getText();
		RetailerNameInUpperCase = RetailerName.toUpperCase();
		System.out.println("Retailer " + RetailerName + " is displayed");
		System.out.println("Retailer " + RetailerNameInUpperCase + " is displayed");
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/update_loc_img_cap_btn")
	private WebElement btnCamera;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/switch_camera")
	private WebElement btnSwitchCamera;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/btn_takepicture")
	private WebElement btnTakepicture;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/checked")
	private WebElement btnChecked;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/loc_update_submit_btn")
	private WebElement btnSubmit1;

	public void verifyInitialUpdateLocation() throws Throwable {
		Thread.sleep(200);
		if (commonUtilityA.elementIsDisplayed(btnCamera)) {
			commonUtilityA.clickElement(btnCamera);
			commonUtilityA.clickElement(btnSwitchCamera);
			commonUtilityA.clickElement(btnTakepicture);
			commonUtilityA.clickElement(btnChecked);
			Thread.sleep(500);
			commonUtilityA.clickElement(btnSubmit1);
			Thread.sleep(1000);
			commonUtilityA.clickElement(txtRetailerName.get(0));

		} else {
			System.out.println("There is no need to update location in this Retailer");
		}
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/alert_title")
	private WebElement GeoFencingAlertPopup;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/alert_ok_btn")
	private WebElement BtnGeoFencingAlertPopupOk;

	public void verifyGeoFencingPopup() throws Throwable {
		Thread.sleep(200);
		if (commonUtilityA.elementIsDisplayed(GeoFencingAlertPopup)) {
			commonUtilityA.clickElement(BtnGeoFencingAlertPopupOk);

		} else {
			System.out.println("There is no Alert popup received for this Retailer");
		}
	}

	public void clickRetailer() throws Throwable {
		commonUtilityA.clickElement(txtRetailerName.get(0));
		verifyGeoFencingPopup();
		verifyInitialUpdateLocation();
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/tv_points_title")
	private WebElement VerifyPointsDetailsHeader;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/img_close")
	private WebElement closePointsDetails;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/toolbar_title")
	private WebElement OutletInfoHeader;

	public void ClosePointsDetail() {
		if (commonUtilityA.elementIsDisplayed(VerifyPointsDetailsHeader)) {
			commonUtilityA.clickElement(closePointsDetails);
		} else {
			System.out.println("Scheme point detial is not displayed");
		}
	}

	public void clickRetailerInfoOk() throws InterruptedException {
		// commonUtilityA.clickElement(btnOk);

		if (commonUtilityA.elementIsDisplayed(btnOutletInfoPopupOk)) {
			commonUtilityA.clickElement(btnOutletInfoPopupOk);
			ClosePointsDetail();

		} else {
			System.out.println("Verify Retailerpopup not displayed");
		}
		Thread.sleep(500);
		// commonUtilityA.pressBackKey();
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/toolbar_title")
	private WebElement labelOutletInfo;

	public void verifyOutletInfoTab() {
		commonUtilityA.verifyVisiblity(labelOutletInfo);
		Assert.assertEquals(labelOutletInfo.getText(), "OUTLET INFO");
		System.out.println("Outlet INFO diplayed");
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/idRetailerName")
	private WebElement labelRetailer;

	public void verifyRetailerTab() {
		Assert.assertEquals(labelRetailer.getText(), RetailerName);
		System.out.println("Retaile Name verifyed");
	}

	public void selectNoSalesReason() throws InterruptedException {
		commonUtilityA.verifyVisiblity(reason);
		commonUtilityA.clickElement(reason);
		Thread.sleep(1000);
	}

	public void clickPendingOutlets() {
		commonUtilityA.clickElement(btnPending);
	}

	public void clickCompletedOutlets() throws InterruptedException {
		commonUtilityA.clickElement(btnCompleted);
		Thread.sleep(2000);
	}

	public void clickWorkingHoursPopupOk() throws InterruptedException {
		commonUtilityA.clickElement(btnWorkingHrsPopupOk);
		Thread.sleep(500);
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/menu_othersearch")
	private WebElement btnOutletVisitSearch;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/search_src_text")
	private WebElement txtOutletVisitSearch;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/show_reason")
	private List<WebElement> txtOutletVisitStatus;

	public void searchOutletVisit() throws Exception {
		commonUtilityA.clickElement(btnOutletVisitSearch);
		commonUtilityA.sendKeys(txtOutletVisitSearch, RetailerName);
		commonUtilityA.hidekeyboard();
		commonUtilityA.pressEnterKey();
	}

	public void verifyOutletIsVisited() throws InterruptedException {
		commonUtilityA.verifyVisiblity(txtRetailerName.get(0));
		Assert.assertEquals(txtRetailerName.get(0).getText(), RetailerName);
		Assert.assertEquals(txtOutletVisitStatus.get(0).getText(), "Visited");
		Thread.sleep(2000);
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/yes_btn")
	private WebElement alertVisitMarketYes;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/open_camera")
	private WebElement clkCameraIcon;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/btn_takepicture")
	private WebElement clkTakePic;// 2

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/checked")
	private WebElement clkCameraTickIcon;// 2

	public void marketVisitPopupAndCaptureImage() throws InterruptedException {
		if (commonUtilityA.elementIsDisplayed(alertVisitMarketYes)) {
			commonUtilityA.clickElement(alertVisitMarketYes);
			commonUtilityA.clickElement(clkCameraIcon);
			commonUtilityA.clickElement(clkTakePic);
			Thread.sleep(1000);
			commonUtilityA.clickElement(clkCameraTickIcon);
			Thread.sleep(1000);
		} else {
			System.out.println("Do you want to visit market? popup not displayed");
		}
	}

	public void clickRemarksDone() {
		if (commonUtilityA.elementIsDisplayed(btnRemarksOk)) {
			commonUtilityA.clickElement(btnRemarksOk);
		} else {
			System.out.println("There is no Remark pop-up");
		}

	}

	/***************** Order Booking *********************/

	@FindBy(xpath = "//*[@text='BookOrder']")
	private WebElement btnOrderBooking;

//	@FindBy(id="com.botree.productsfa.botreessfa:id/checked")
//	private WebElement ClickButtonAfterPicture;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/alert_ok_btn")
	private WebElement btnAlertYes;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/search_src_text")
	private WebElement txtProductSearch;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/quantity_txt")
	private WebElement txtOrderQty;

	@FindBy(id = "android:id/text1")
	private WebElement drpUOM;

	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\"]")
	private List<WebElement> drpListUOM;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/orderbooking_submit_btn")
	private WebElement btnNext;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/cashDiscPercEt")
	private WebElement txtDiscPercentage;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/cashDiscValueEt")
	private WebElement txtDiscValue;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/cash_disc_apply_btn")
	private WebElement applyDiscount;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/retailer_ordsummary_submit_btn")
	private WebElement btnSubmit;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/alert_msg_ok_btn")
	private WebElement btnBackOk;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.botree.mobilitysfa.preprodstage:id/notifications_title_txt\" and @text=\"Completed\"]")
	private WebElement completed;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/top_cons")
	private WebElement completedOrder;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/button_ok")
	private WebElement btnCompletedOK;

	public void clickOrderBooking() throws InterruptedException {
		Thread.sleep(5000);
		commonUtilityA.clickElement(btnOrderBooking);
	}

	public void clickAlertYes() {
		commonUtilityA.clickElement(btnAlertYes);
	}

	public void clearProductSearch() throws InterruptedException {
		Thread.sleep(500);
		commonUtilityA.clear(txtProductSearch);
		Thread.sleep(200);
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/total_count")
	private WebElement totalNumOfProduct;

	public int productBeforeSearch;

	public void getProductCountBeforeSearch() {
		productBeforeSearch = Integer.parseInt(totalNumOfProduct.getText().trim());
		System.out.println(productBeforeSearch);
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.botree.mobilitysfa.preprodstage:id/product_name_txt\"]")
	private List<WebElement> listProducts;

	public static String product;

	public void searchProduct() throws Throwable {
		product = listProducts.get(0).getText();
		System.out.println(product);
		Thread.sleep(200);
		commonUtilityA.clear(txtProductSearch);
		Thread.sleep(200);
		commonUtilityA.sendKeys(txtProductSearch, product);
	}

	public void searchTheProduct(String SearchProduct) throws Throwable {
		Thread.sleep(200);
		commonUtilityA.clear(txtProductSearch);
		Thread.sleep(200);
		commonUtilityA.sendKeys(txtProductSearch, SearchProduct);
	}

	public void verifyProductIsListed() {
		listProducts.get(0).isDisplayed();
		System.out.println("Product is Sucessfully displayed after search");
	}

	public int productAfterSearch;

	public void getProductCountAfterSearch() {
		productAfterSearch = Integer.parseInt(totalNumOfProduct.getText().trim());
		System.out.println(productAfterSearch);
	}

	public void compareBoth() {
		Assert.assertTrue(productBeforeSearch > productAfterSearch);
	}

	public static String product1;

	public void searchProduct1() throws Throwable {
		txtProductSearch.clear();
		Thread.sleep(200);
		product1 = listProducts.get(1).getText();
		System.out.println(product1);
		commonUtilityA.sendKeys(txtProductSearch, product1);
	}

	public static String product2;

	public void searchProduct2() throws Throwable {
		product2 = listProducts.get(2).getText();
		System.out.println(product2);
		commonUtilityA.sendKeys(txtProductSearch, product2);
	}

	public void enterQuantity(String quantity) throws Throwable {
		commonUtilityA.sendKeys(txtOrderQty, quantity);
	}

	public void selectUOM(String uom) throws Throwable {
		commonUtilityA.clickElement(drpUOM);
		commonUtilityA.iterateAndClick(drpListUOM, uom);
//		enterQuantity2("1", "KG");
//		enterStockTake("1", "GM");
	}

	public void selectUOM2(String uom2) throws Throwable {
		commonUtilityA.clickElement(drpuom2.get(1));
		commonUtilityA.iterateAndClick(drpListUOM, uom2);

	}

	public void selectStocktakeUOM(String uom) throws Throwable {
		commonUtilityA.clickElement(drpuom2.get(2));
		commonUtilityA.iterateAndClick(drpListUOM, uom);
	}

	public void enterQuantity2(String quantity2, String uom2) throws Throwable {
		if (commonUtilityA.elementIsDisplayed(txtOrderQty2.get(0))) {
			commonUtilityA.sendKeys(txtOrderQty2.get(0), quantity2);
			selectUOM2(uom2);
		}

	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/stock_chk")
	private List<WebElement> txtStockTake;

	public void enterStockTake(String quantity3, String uom2) throws Throwable {
		if (commonUtilityA.elementIsDisplayed(txtStockTake.get(0))) {
			commonUtilityA.sendKeys(txtStockTake.get(0), quantity3);
			selectStocktakeUOM(uom2);
		}

	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/quantity2_txt")
	private List<WebElement> txtOrderQty2;
	@FindBy(id = "android:id/text1")
	private List<WebElement> drpuom2;

//	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\"]")
//	private List<WebElement> drpListUOM;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/done_btn")
	private WebElement btnCongratulationOk;

	public void clickNext() {
		commonUtilityA.clickElement(btnNext);
		// commonUtilityA.clickElement(btnCongratulationOk);
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/toolbar_title")
	private WebElement labelOrderSummary;

	public void verifyOrderSummaryTab() {
		Assert.assertEquals(labelOrderSummary.getText(), "Order Summary");
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/order_product_name_txt")
	private WebElement productAfterPlacingOrder;

	public void verifyProductPlaced() throws Throwable {

		Thread.sleep(500);
		System.out.println(productAfterPlacingOrder.getText());
	}

	@FindBy(xpath = "(//android.widget.ImageView[@content-desc=\"null\"])[3]")
	private WebElement clear;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/alert_ok_btn")
	private WebElement clearYes;

	public void clearOrder() {
		commonUtilityA.clickElement(clear);
		commonUtilityA.clickElement(clearYes);
	}

	public void applyDiscount(String discount) throws Exception {
		commonUtilityA.sendKeys(txtDiscValue, discount);
		commonUtilityA.clickElement(applyDiscount);
	}

	public void clickSubmit() {
		commonUtilityA.clickElement(btnSubmit);
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/more_horiz")
	private WebElement btn3dot;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/poc_btn")
	private WebElement txtPoCapture;
	// com.botree.mobilitysfa.preprodstage:id/po_number_box
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/top_toolbar")
	private WebElement txtHeader;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/po_number_box")
	private WebElement txtPoNumber;
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/po_date_box")
	private WebElement btnPoDate;
	
	@FindBy(id = "android:id/button1")
	private WebElement btnPoDateOk;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/remark")
	private WebElement txtPoRemarks;
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/item_img")
	private WebElement btnPoCaptureCamera;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/btn_takepicture")
	private WebElement btnPoCaptureCamera1;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/checked")
	private WebElement btnPoCaptureCameraTick;
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/submit_btn")
	private WebElement btnpoCaptureSubmit;
	public void click3Dot() {
		commonUtilityA.clickElement(btn3dot);
	}

	public void verifyPoCaptureInDisableMode() {
		if (commonUtilityA.elementIsDisplayed(txtPoCapture)) {
			Assert.fail("PO Capture is need to be in Disable mode but it's enabled");
		} else {
			System.out.println("PO Capture is Disable as per the Configuration Setting No");
			commonUtilityA.pressBackKey();
		}
	}
	public void verifyPoCaptureIsInEnableMode() {
		if (commonUtilityA.elementIsDisplayed(txtPoCapture)) {
			System.out.println("PO Capture is Enabled as per the Configuration Setting Yes");
			commonUtilityA.clickElement(txtPoCapture);
		} else {
			Assert.fail("PO Capture is need to be in Enable mode but it is in Disable mode");
		}
	}
	
	public void verifyPoCaptureScreenIsDisplayed() {
		commonUtilityA.verifyVisiblity(txtHeader);
		Assert.assertEquals(txtHeader.getText(), "PO Capture");
		System.out.println("Po capture screen is sucessfully displayed");
	}
	public void enterPoNumber(String poNumber) throws Exception {
		commonUtilityA.sendKeys(txtPoNumber, poNumber);
		commonUtilityA.hidekeyboard();
	}
	public void selectPoDate() {
		commonUtilityA.clickElement(btnPoDate);
		commonUtilityA.clickElement(btnPoDateOk);
	}
	public void enterPoRemarks(String poRemarks) throws Exception {
		commonUtilityA.sendKeys(txtPoRemarks, poRemarks);
		commonUtilityA.hidekeyboard();
	}
	public void CapturePoImage() {
		
		commonUtilityA.clickElement(btnPoCaptureCamera);
		commonUtilityA.clickElement(btnPoCaptureCamera1);
		commonUtilityA.clickElement(btnPoCaptureCameraTick);
	}
	public void clickPoCaptureSubmit() {
		commonUtilityA.clickElement(btnpoCaptureSubmit);
	}
	
	
	
}
