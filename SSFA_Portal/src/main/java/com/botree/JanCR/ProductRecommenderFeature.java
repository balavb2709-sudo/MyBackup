package com.botree.JanCR;

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

public class ProductRecommenderFeature extends BaseTest_Listener {
	AppiumDriver mobileDriver = getMobileDriver();
	WebDriver webDriver = getWebDriver();

	public ProductRecommenderFeature(AppiumDriver appiumDriver) {
		this.mobileDriver = appiumDriver;
		PageFactory.initElements(appiumDriver, this);
	}

	public ProductRecommenderFeature(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	AndroidCommonUtility commonUtilityA = new AndroidCommonUtility();
	SeleniumCommonUtility commonUtilityS = new SeleniumCommonUtility();

	// *************************************web X-Path**********************************************
	@FindBy(xpath = "//span[normalize-space()='Report']")
	private WebElement drpFieldActivity;
	//span[normalize-space()='Outlet Reports']
	
	@FindBy(xpath = "//*[@class='fa fa-fw fa-bars']")
	private WebElement btnHomeBar;

	@FindBy(xpath = "//*[@text='Outlet Visit']") // (//android.widget.ImageView[@resource-id="com.botree.productsfa.botreessfa:id/navigation_bar_item_icon_view"])[2]
	private WebElement clkOutletVisit;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.botree.mobilitysfa.preprodqa:id/tv_route_name\" ]")
	private List<WebElement> chkBeatSelection;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/beat_next_button")
	private WebElement BtnBeatNext;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/spinner_item")
	private WebElement drpSelectOutlet;

	@FindBy(id = "android:id/text1")
	private List<WebElement> drpListSelectOutlet;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.botree.mobilitysfa.preprodqa:id/retailer_name\" ]")
	private List<WebElement> txtRetailerName;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/remarks_submit_btn")
	private WebElement btnRemarksOk;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/button_ok")
	private WebElement btnOutletInfoPopupOk;

	@FindBy(xpath = "//*[@text='SHOP CLOSED']")
	private WebElement reason;
	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/alert_msg_ok_btn")
	private WebElement btnWorkingHrsPopupOk;

	@FindBy(xpath = "//android.widget.LinearLayout[@content-desc=\"Pending\"]")
	private WebElement btnPending;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.botree.mobilitysfa.preprodqa:id/notifications_title_txt\" and @text=\"Completed\"]")
	private WebElement btnCompleted;

	public void beatSelection() throws InterruptedException {
		commonUtilityA.clickElement(clkOutletVisit);
		commonUtilityA.clickElement(chkBeatSelection.get(0));
		commonUtilityA.clickElement(BtnBeatNext);

	}

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/toolbar_title")
	private WebElement labelOutletVisit;

	public void verifyOutletVisitTab() {
		commonUtilityA.verifyVisiblity(labelOutletVisit);
		Assert.assertEquals(labelOutletVisit.getText(), "Outlet Visit");
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

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/update_loc_img_cap_btn")
	private WebElement btnCamera;
	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/switch_camera")
	private WebElement btnSwitchCamera;
	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/btn_takepicture")
	private WebElement btnTakepicture;
	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/checked")
	private WebElement btnChecked;
	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/loc_update_submit_btn")
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

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/alert_title")
	private WebElement GeoFencingAlertPopup;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/alert_ok_btn")
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

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/tv_points_title")
	private WebElement VerifyPointsDetailsHeader;
	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/img_close")
	private WebElement closePointsDetails;
	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/toolbar_title")
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

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/toolbar_title")
	private WebElement labelOutletInfo;

	public void verifyOutletInfoTab() {
		commonUtilityA.verifyVisiblity(labelOutletInfo);
		Assert.assertEquals(labelOutletInfo.getText(), "OUTLET INFO");
		System.out.println("Outlet INFO diplayed");
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/idRetailerName")
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

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/menu_othersearch")
	private WebElement btnOutletVisitSearch;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/search_src_text")
	private WebElement txtOutletVisitSearch;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/show_reason")
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

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/yes_btn")
	private WebElement alertVisitMarketYes;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/open_camera")
	private WebElement clkCameraIcon;
	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/btn_takepicture")
	private WebElement clkTakePic;// 2

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/checked")
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

	@FindBy(xpath = "//*[@text='Book Order']")
	private WebElement btnOrderBooking;

//	@FindBy(id="com.botree.productsfa.botreessfa:id/checked")
//	private WebElement ClickButtonAfterPicture;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/alert_ok_btn")
	private WebElement btnAlertYes;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/search_src_text")
	private WebElement txtProductSearch;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/quantity_txt")
	private WebElement txtOrderQty;

	@FindBy(id = "android:id/text1")
	private WebElement drpUOM;

	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\"]")
	private List<WebElement> drpListUOM;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/orderbooking_submit_btn")
	private WebElement btnNext;
	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/cashDiscPercEt")
	private WebElement txtDiscPercentage;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/cashDiscValueEt")
	private WebElement txtDiscValue;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/cash_disc_apply_btn")
	private WebElement applyDiscount;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/retailer_ordsummary_submit_btn")
	private WebElement btnSubmit;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/alert_msg_ok_btn")
	private WebElement btnBackOk;

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.botree.mobilitysfa.preprodqa:id/notifications_title_txt\" and @text=\"Completed\"]")
	private WebElement completed;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/top_cons")
	private WebElement completedOrder;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/button_ok")
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

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/total_count")
	private WebElement totalNumOfProduct;

	public int productBeforeSearch;

	public void getProductCountBeforeSearch() {
		productBeforeSearch = Integer.parseInt(totalNumOfProduct.getText().trim());
		System.out.println(productBeforeSearch);
	}

	@FindBy(xpath = "//android.widget.TextView[@resource-id=\"com.botree.mobilitysfa.preprodqa:id/product_name_txt\"]")
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

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/stock_chk")
	private List<WebElement> txtStockTake;

	public void enterStockTake(String quantity3, String uom2) throws Throwable {
		if (commonUtilityA.elementIsDisplayed(txtStockTake.get(0))) {
			commonUtilityA.sendKeys(txtStockTake.get(0), quantity3);
			selectStocktakeUOM(uom2);
		}

	}

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/quantity2_txt")
	private List<WebElement> txtOrderQty2;
	@FindBy(id = "android:id/text1")
	private List<WebElement> drpuom2;

//	@FindBy(xpath = "//android.widget.CheckedTextView[@resource-id=\"android:id/text1\"]")
//	private List<WebElement> drpListUOM;
	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/done_btn")
	private WebElement btnCongratulationOk;

	public void clickNext() {
		commonUtilityA.clickElement(btnNext);
		// commonUtilityA.clickElement(btnCongratulationOk);
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/toolbar_title")
	private WebElement labelOrderSummary;

	public void verifyOrderSummaryTab() {
		Assert.assertEquals(labelOrderSummary.getText(), "Order Summary");
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/order_product_name_txt")
	private WebElement productAfterPlacingOrder;

	public void verifyProductPlaced() throws Throwable {

		Thread.sleep(500);
		System.out.println(productAfterPlacingOrder.getText());
	}

	@FindBy(xpath = "(//android.widget.ImageView[@content-desc=\"null\"])[3]")
	private WebElement clear;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/alert_ok_btn")
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

	public void clickBack() {
		commonUtilityA.pressBackKey();
		commonUtilityA.clickElement(btnBackOk);
	}

	public void clickCompleted() {
		commonUtilityA.clickElement(completed);
	}

	public void viewCompletedOrder() {
		commonUtilityA.clickElement(completedOrder);
		commonUtilityA.scrollToEnd(1);
		commonUtilityA.clickElement(btnCompletedOK);
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/outlet_name")
	private WebElement labelRetailerAfterOderBooking;

	public void verifyRetailerTabAfterClickingOrderBooking() {
		Assert.assertEquals(labelRetailerAfterOderBooking.getText(), RetailerNameInUpperCase);
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/retailer_name")
	private WebElement labelRetailerAfterOderBookingInQuickMode;

	

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/order_book_text")
	private WebElement labelOrderBooking;

	public void verifyOrderBookingTab() {
		Assert.assertEquals(labelOrderBooking.getText(), "Order Booking");
	}

	
	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/dbQtyPercEdt")
	private WebElement txtDiscountInProductPage;

	public void enterDiscountPercentageInProductPage(String discount) throws Exception {
		commonUtilityA.sendKeys(txtDiscountInProductPage, discount);
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/dbQtyValueEdt")
	private WebElement txtValueInProductPage;

	public void getValueAfterDiscount() {
		String value = txtValueInProductPage.getText();
		System.out.println("Value After Discount :" + value);
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/signature_btn")
	private WebElement signature;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/signature_pad")
	private WebElement signPad;

	@FindBy(id = "com.botree.mobilitysfa.preprodqa:id/sign_save_button")
	private WebElement btnDone;

	public void AddSignature() {
		commonUtilityA.clickElement(signature);
		commonUtilityA.scrollByCoordinates(268, 1211, 575, 1211);
		commonUtilityA.clickElement(btnDone);
	}
	
	
	public void clickReport() {
		if (commonUtilityS.elementIsDisplayed(btnHomeBar)) {
			commonUtilityS.clickElement(btnHomeBar);
			commonUtilityS.clickElement(drpFieldActivity);
		} else {
			commonUtilityS.clickElement(drpFieldActivity);
		}

	}
	@FindBy(xpath = "//span[normalize-space()='Outlet Reports']")
	private WebElement drpOutletReports;
	//span[normalize-space()='Order Information']
	@FindBy(xpath = "//span[normalize-space()='Order Information']")
	private WebElement btnOrderInfo;
	@FindBy(xpath = "//label[normalize-space()='Distributor']")
	private WebElement rbtnDistributor;

	@FindBy(xpath = "/html[1]/body[1]/app-root[1]/app-landing[1]/div[1]/div[1]/div[1]/ng-component[1]/div[1]/div[1]/div[1]/app-hierarchyselection[1]/p-dialog[1]/div[1]/div[1]/div[3]/div[2]/div[1]/p-table[1]/div[1]/div[1]/div[1]/div[1]/input[1]")
	private WebElement txtGlobalFilterSearch;

	@FindBy(xpath = "//p-tableheadercheckbox[@class='p-element']//div[@class='p-checkbox p-component']//div[@role='checkbox']")
	private WebElement rbtnHeader;

	@FindBy(xpath = "//span[normalize-space()='Ok']")
	private WebElement heirarchySelectionOk;

	@FindBy(xpath = "//p-radiobutton[@value='date']//span[@class='p-radiobutton-icon']")
	private WebElement rbtnDate;
	
	@FindBy(xpath = "//label[normalize-space()='OrderDt']")
	private WebElement rbtnOrderDt;
	@FindBy(xpath = "/html/body/app-root/app-landing/div/div/div[1]/app-order/div/div/div/app-calendar/p-dialog[1]/div/div/div[2]/div/button/timesicon")
	private WebElement btnClose;
	@FindBy(xpath = "//label[normalize-space()='SynDt']")
	private WebElement rbtnSynDt;
	//body//app-root//th[17]
	@FindBy(xpath = "//span[normalize-space()='Search']")
	private WebElement btnSearch;
	
	@FindBy(xpath = "//span[normalize-space()='View']")
	private WebElement btnView;
	@FindBy(xpath = "//div[normalize-space()='Order Summary']")
	private WebElement txtOrderSummaryTittle;
	
	@FindBy(xpath = "//body//app-root//th[17]")
	private WebElement txtHeaderOrderType;
	
	public void selectOrderInfoReport() throws InterruptedException {
		commonUtilityS.clickElement(drpOutletReports);
		commonUtilityS.scrollIntoView(btnOrderInfo);
		commonUtilityS.clickElement(btnOrderInfo);
	}
	public void selectDistributor(String distrCode) throws Exception {
		commonUtilityS.clickElement(rbtnDistributor);
		commonUtilityS.sendkeys(txtGlobalFilterSearch, distrCode);
		commonUtilityS.clickElement(rbtnHeader);
		commonUtilityS.clickElement(heirarchySelectionOk);
	}

	public void selectDate() {
		commonUtilityS.clickElement(rbtnDate);
		commonUtilityS.clickElement(btnClose);
	}
	
	public void selectOrderDt() {
		commonUtilityS.clickElement(rbtnDate);
	}
	
	public void selectSynDt() {
		commonUtilityS.clickElement(rbtnSynDt);
	}
	public void clickSearchButton() {
		commonUtilityS.clickElement(btnSearch);	
	}
	public void verifyOrderSummaryScreenIsDisplayed() throws Throwable {
		commonUtilityS.verifyVisibility(txtOrderSummaryTittle);
		Assert.assertEquals(txtOrderSummaryTittle.getText(), "Order Summary");
		System.out.println("Order Summary Detials is displayed");
	}
	public void clickViewButton() {
		commonUtilityS.clickElement(btnView);	
	}
	public void verifyOrderTypeField() throws Throwable {
		commonUtilityS.verifyVisibility(txtHeaderOrderType);
		Assert.assertEquals(txtHeaderOrderType.getText(), " Order Type ");
		System.out.println("Order Type Field is present");
	}
}


