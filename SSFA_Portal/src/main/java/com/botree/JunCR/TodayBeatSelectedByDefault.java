package com.botree.JunCR;

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

public class TodayBeatSelectedByDefault extends BaseTest_Listener {

	
	
	
	AppiumDriver mobileDriver = getMobileDriver();
	WebDriver webDriver = getWebDriver();

	public TodayBeatSelectedByDefault(AppiumDriver appiumDriver) {
		this.mobileDriver = appiumDriver;
		PageFactory.initElements(appiumDriver, this);

	}

	public TodayBeatSelectedByDefault(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	AndroidCommonUtility commonUtilityA = new AndroidCommonUtility();
	SeleniumCommonUtility commonUtilityS = new SeleniumCommonUtility();

	// ************************ Outlet Visit *****************************//

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



	public static String RetailerName;
	public static String RetailerNameInUpperCase1;

	public void verifyRetailerisDisplayed() {
		commonUtilityA.verifyVisiblity(txtRetailerName.get(0));
		RetailerName = txtRetailerName.get(0).getText();
		RetailerNameInUpperCase1 = RetailerName.toUpperCase();
		System.out.println("Retailer " + RetailerName + " is displayed");
		System.out.println("Retailer " + RetailerNameInUpperCase1 + " is displayed");
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

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/idTabFive")
	private WebElement clkMoreMenu;
	// *[@text='Activity Tracker']
	@FindBy(xpath = "//*[@text='Activity Tracker']")
	private WebElement clkActivityTracker;

	@FindBy(xpath = "//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/ans_radioGroup']")
	private List<WebElement> chkActivityTrackerQuestions;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/btn_submit_answers")
	private WebElement btnActivitytrackerSubmit;

	@FindBy(xpath = "//*[@text='Yes']")
	private List<WebElement> chkActivityTrackerYes;

	public void clickMoreMenu() throws InterruptedException {
		Thread.sleep(1000);
		commonUtilityA.clickElement(clkMoreMenu);
	}

	public void clickActivityTracker() throws InterruptedException {
		commonUtilityA.clickElement(clkActivityTracker);
		Thread.sleep(1000);
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
	//	enterStockTake("1", "GM");
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

	public void verifyStockTakeTextBoxIsDisplayed() {
		commonUtilityA.verifyVisiblity(txtStockTake.get(0));
		Assert.assertTrue(txtStockTake.get(0).isDisplayed());
		System.out.println("Stock Take TextBox is displayed");		
	}
	
	public void verifyStockTakeTextBoxIsDisabled() {
		Assert.assertFalse(txtStockTake.get(0).isEnabled());
		System.out.println("Stock Take TextBox is disabled");
	}
	
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

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/outlet_name")
	private WebElement labelRetailerAfterOderBooking;

	public void verifyRetailerTabAfterClickingOrderBooking() {
		Assert.assertEquals(labelRetailerAfterOderBooking.getText(), RetailerNameInUpperCase);
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/retailer_name")
	private WebElement labelRetailerAfterOderBookingInQuickMode;

	

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/order_book_text")
	private WebElement labelOrderBooking;

	public void verifyOrderBookingTab() {
		Assert.assertEquals(labelOrderBooking.getText(), "Order Booking");
	}

	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/dbQtyPercEdt")
	private WebElement txtDiscountInProductPage;

	public void enterDiscountPercentageInProductPage(String discount) throws Exception {
		commonUtilityA.sendKeys(txtDiscountInProductPage, discount);
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/dbQtyValueEdt")
	private WebElement txtValueInProductPage;

	public void getValueAfterDiscount() {
		String value = txtValueInProductPage.getText();
		System.out.println("Value After Discount :" + value);
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/signature_btn")
	private WebElement signature;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/signature_pad")
	private WebElement signPad;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/sign_save_button")
	private WebElement btnDone;

	public void AddSignature() {
		commonUtilityA.clickElement(signature);
		commonUtilityA.scrollByCoordinates(268, 1211, 575, 1211);
		commonUtilityA.clickElement(btnDone);
	}

	// *************************************MDSR*****************************************

	@FindBy(xpath = "//*[@resource-id='com.botree.productsfa.preprodstage:id/sync_image']")
	private List<WebElement> btnGTdistributor;

	@FindBy(xpath = "SS Visit")
	private WebElement ssVisit;

	public void clickSSVisit() throws Throwable {
		commonUtilityA.clickElement(ssVisit);
		Thread.sleep(2000);
	}

	@FindBy(xpath = "//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/distr_name']")
	private List<WebElement> btnUpdatedDistributor;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/user_name")
	private WebElement DirectpartyUser;

	@FindBy(xpath = "//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/sync_image']")
	private List<WebElement> btnGTdistributorsync;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/alert_ok_btn")
	private WebElement btnGTsyncOK;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/alert_title")
	private WebElement Alertandallowtitle;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/alert_yes_btn")
	private WebElement btnAlertandAllowOk;

	public void SelectDistributor(String Superstockist, String Substockist) throws Throwable {

		commonUtilityA.scrollAndClickParticularText(btnUpdatedDistributor, Superstockist, 1);
		if (commonUtilityA.elementIsDisplayed(Alertandallowtitle)) {
			commonUtilityA.clickElement(btnAlertandAllowOk);

		}
		Thread.sleep(500);

		if (commonUtilityA.elementIsDisplayed(DirectpartyUser)) {
			Assert.assertEquals(DirectpartyUser.getText(), Superstockist);

		} else {
			syncAndSelectSmtDistributor(btnUpdatedDistributor, Substockist);
		}

	}

	public void syncAndSelectSmtDistributor(List<WebElement> elementList, String smTDistributor)
			throws InterruptedException {

		for (int i = 0; i < elementList.size(); i++) {

			if (elementList.get(i).getText().equals(smTDistributor)) {

				btnGTdistributorsync.get(i).click();
				commonUtilityA.clickElement(btnAlertandAllowOk);
				btnGTsyncOK.click();
				Thread.sleep(12000);
				break;
			}

		}
	}

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/toolbar_title")
	private WebElement VerifyDistributorTitle;

	public void VerifyDistributorTitle(String Distributoheader) {

		Assert.assertEquals(VerifyDistributorTitle.getText(), Distributoheader);
		System.out.println("Verifyed Distributor Title Successful");
	}

	@FindBy(xpath = "//*[@text='Dashboard']")
	private WebElement clkDashBoard;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/toolbar_title")
	private WebElement txtTittle;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/daySection")
	private WebElement btnDay;
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/text")
	private List<WebElement> txtDashboardModule;

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/today_salesman_name_txt")
	private List<WebElement> txtInRouteData;

	@FindBy(xpath = "//*[@text='More']")
	private WebElement btnMdsrMore;
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/tvName")
	private List<WebElement> txtListMdsrMore;
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/layout_spinner_container")
	private WebElement drpDistributorType;
	
	@FindBy(xpath = "//*[@resource-id='android:id/text1']")
	private List<WebElement> drpListDistributorType;
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/layout_spinner_distributor")
	private WebElement drpDistributor;
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/layout_spinner_salesman")
	private WebElement drpSalesman;	
	//com.botree.mobilitysfa.preprodstage:id/tvDayDate
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/mtdSection")
	private WebElement btmMtd;
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/tvDayDate")
	private WebElement txtCurrentDate;
	public void clickDashboard() {
		commonUtilityA.clickElement(clkDashBoard);
	}

	public void verifyDashboardScreenIsDisplayed() {
		commonUtilityA.verifyVisiblity(txtTittle);
		Assert.assertEquals(txtTittle.getText(), "Dashboard");
		System.out.println("Dashboard screen is displayed.");

	}

	public void clickInRoute(String dashboardModule) {
		commonUtilityA.swipeAndClickParticularDashBoardModule(txtDashboardModule, dashboardModule);

	}
	public void clickInRouteCompamy(String dashboardModule) {
		commonUtilityA.swipeAndClickParticularDashBoardModule(txtDashboardModule, dashboardModule);

	}
	public void clickDay() {
		commonUtilityA.clickElement(btnDay);

	}

	public void verifyInRouteDataIsDisplayed() {
		commonUtilityA.verifyVisiblity(txtInRouteData.get(0));
		System.out.println("Planned call : " + txtInRouteData.get(1).getText());
		System.out.println("Cash Mode : " + txtInRouteData.get(2).getText());
		System.out.println("Productive Calls : " + txtInRouteData.get(3).getText());
		System.out.println("InStore call : " + txtInRouteData.get(4).getText());
		System.out.println("InStore % : " + txtInRouteData.get(5).getText());
		System.out.println("Away From Store : " + txtInRouteData.get(6).getText());
		System.out.println("OffRoute calls : " + txtInRouteData.get(7).getText());

	}
	
	
	public void clickMdsrDashboard(String outletVisitModule) {
		commonUtilityA.clickElement(btnMdsrMore);
		commonUtilityA.scrollAndClickParticularText(txtListMdsrMore, outletVisitModule, 1);
	}
	public void selectDistributorType(String distributorType) {
		commonUtilityA.clickElement(drpDistributorType);	
		commonUtilityA.iterateAndClick(drpListDistributorType, distributorType);
	}
	
	public void selectDistributor(String distributor) {
		commonUtilityA.clickElement(drpDistributor);	
		commonUtilityA.iterateAndClick(drpListDistributorType, distributor);
	}
	public void selectSalesman(String salesman) {
		commonUtilityA.clickElement(drpSalesman);	
		commonUtilityA.iterateAndClick(drpListDistributorType, salesman);
	}
	
	public void clickMtd() {
		commonUtilityA.clickElement(btmMtd);
	}
	
	public void verifyCurrentDate() {
		commonUtilityA.verifyVisiblity(txtCurrentDate);
		Assert.assertEquals(txtCurrentDate.getText().trim(), commonUtilityA.getCurrentDate().trim());
		System.out.println("Current date is verified");
	}
	//****************************************Portal**********************************
	
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

	@FindBy(xpath = "//*[text()='Display Stock take option in Order Booking Screen - (StockTake)']")
	WebElement cmpConfigurationpoint01;

	@FindBy(xpath = "//input[@id='StockTakeY']")
	WebElement cmpConfigurationpoint01Yes;

	@FindBy(xpath = "//input[@id='StockTakeN']")
	WebElement cmpConfigurationpoint01No;

	public void scrollToTheConfiguration() throws Throwable {

		commonUtilityS.scrollIntoView(cmpConfigurationpoint01);
		commonUtilityS.clickRobotUpArrow();
		commonUtilityS.clickRobotUpArrow();

		Thread.sleep(2000);

	}

	public void selectStockTakeOptionInOrderBookingScreenNo() {
		commonUtilityS.clickElement(cmpConfigurationpoint01No);
	}

	public void selectStockTakeOptionInOrderBookingScreenYes() {
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
	
	

	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/menu_back_icon")
	private WebElement btnMenuIcon;
	
	public void ClickMenuIcon() throws Throwable {
		
		Thread.sleep(1000);
		commonUtilityA.clickElement(btnMenuIcon);
		
	}
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/user_name")
	private List<WebElement> txtUsername;
	
	public static String UserName;

	public void verifyUserNameisDisplayed() {
		//commonUtility.verifyVisiblity(txtUsername.get(0));
		UserName = txtUsername.get(0).getText();
		System.out.println("User: " + UserName + " is displayed");
	}
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/profile_name")
	private WebElement txtProfileName;
	
	public void VerifyprofileName() {
		
		commonUtilityA.explicitWait(txtProfileName);		
		Assert.assertEquals(txtProfileName.getText(), UserName);
		System.out.println("ProfileName displayed sucessfully");
	}
	
	
	
		
		
	@FindBy(xpath = "//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/tvName']")
	private List<WebElement> btnMarketVisit1;
	
	public void ClickMarketVisit(String titleMarketVisit) throws Throwable {
		
		Thread.sleep(100);
		commonUtilityA.scrollAndClickParticularText(btnMarketVisit1, titleMarketVisit, 0);
		Thread.sleep(8000);

	}
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/toolbar_title")
	private WebElement txtmarketVisitTitle;
	
	public void VerifyMarketVistTitle(String headerMarketVisit) {
		
		Assert.assertEquals(txtmarketVisitTitle.getText(), headerMarketVisit); // Market Visit
		System.out.println("MarketVisit Title displayed sucessfully");
		
	}
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/filetr_root_layout")
	private WebElement btnFilter;
	
	public void ClickFilter() {
		
		commonUtilityA.clickElement(btnFilter);
	}
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/toolbar_title")
	private WebElement txtFilterTitle;
	
	public void VerifyFilterTitle(String headerFilter) throws Throwable {
		
		Thread.sleep(1000);
		Assert.assertEquals(txtFilterTitle.getText(), headerFilter); // Filter
		System.out.println("Filter Title displayed sucessfully");
	}
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/toolbar_title")
	private List<WebElement> btnDistributorHead;
	
	@FindBy(xpath = "//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/filter_title']")
	private List<WebElement> btnDistributor;
	
	@FindBy(xpath = "//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/sub_filter_child_name_txt']")
	private List<WebElement> ListNewDistributor;
	
	public void SelectDistributor(String distributor) {   //J M STEEL INDUSTRIES
		
		commonUtilityA.clickElement(btnDistributorHead.get(0));
		
		  boolean elementFound = false;
		  
	        while (!elementFound) {
	            try {
	               

	                for (WebElement companyuser : ListNewDistributor) {
	                    if (companyuser.getText().equalsIgnoreCase(distributor)) {
	                        System.out.println("Element found: " + companyuser.getText());
	                        companyuser.click();
	                        elementFound = true;
	                        break;
	                    }
	                }

	                if (!elementFound) {
	                	commonUtilityA.scrollByCoordinates(884, 1710, 884, 350);
	                  
	                }
	            } catch (Exception e) {
	                System.out.println("Error while searching: " + e.getMessage());
	                break;
	            }
	        }

	        if (!elementFound) {
	            System.out.println("Element with name containing"+ distributor+" not found.");
	        }
	    
		
		
		
		
		
	}
	
	@FindBy(xpath = "//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/filter_title']")
	private List<WebElement> btnSalesmanHead;
	
	@FindBy(xpath = "//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/layoutBackground']")
	private List<WebElement> btnSalesMan;
	
	@FindBy(xpath = "//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/sub_filter_child_name_txt']")
	private List<WebElement> ListNewSalesMan;
	
	
	public void SelectSalesMan(String salesman) {   //  Abdul Abid Aziz Sheikh
		
		commonUtilityA.clickElement(btnSalesmanHead.get(1));
		
		  boolean elementFound = false;
		  
	        while (!elementFound) {
	            try {
	               

	                for (WebElement companyuser : ListNewSalesMan) {
	                    if (companyuser.getText().equalsIgnoreCase(salesman)) {
	                        System.out.println("Element found: " + companyuser.getText());
	                        companyuser.click();
	                        elementFound = true;
	                        break;
	                    }
	                }

	                if (!elementFound) {
	                	commonUtilityA.scrollByCoordinates(884, 1710, 884, 350);
	                  
	                }
	            } catch (Exception e) {
	                System.out.println("Error while searching: " + e.getMessage());
	                break;
	            }
	        }

	        if (!elementFound) {
	            System.out.println("Element with name containing"+ salesman+" not found.");
	        }
	    
		
		
		
		
	}
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/sub_filter_empty_txt")
	private WebElement txtAfterFilter;
	
	public void VerifyDistributorandSalesmanSelectedSucessfully() {
		
		Assert.assertEquals(txtAfterFilter.getText(), "Press apply to see Reports");
		System.out.println("Distributor and salesman selected sucessfully");
	}
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/filter_apply_btn")
	private WebElement btnApply;
	
	public void ClickApplyButton() {
		
		commonUtilityA.clickElement(btnApply);
	}
	
	@FindBy(xpath = "//*[@text='Please Select Station Master']")
	private WebElement txtStationMastertitle;
	
	public void VerifyStationMasterHeader(String headerStationMaster) {
		
		Assert.assertEquals(txtStationMastertitle.getText(), headerStationMaster); // Please Select Station Master
		System.out.println("Station Master Title Displayed sucessfully");
	}
	
	@FindBy(xpath = "//*[@text='HQ']")
	private WebElement txtStationMaster;
	

	public void SelectStationMaster() throws Throwable {
		
		commonUtilityA.clickElement(txtStationMaster);
		Thread.sleep(3000);
	}
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/spinner_item")
	private WebElement drpRoute;
	
	@FindBy(xpath = "//*[@resource-id='android:id/text1']")
	private List<WebElement> drpListroute;
	
	

	
	public static String Route;

	public void SelectRoute() {
		
		commonUtilityA.clickElement(drpRoute);
		Route = drpListroute.get(0).getText();
		System.out.println("Stored:  " + Route + " is displayed");
		commonUtilityA.clickElement(drpListroute.get(0));
	}
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/progress_text")
	private WebElement Percentage;

		public static String startpercentage;
		public void verifyStartingpercentage() {
			commonUtilityA.verifyVisiblity(Percentage);
			startpercentage=Percentage.getText();
			System.out.println("Market Visit starting percentage " +startpercentage+" is displayed");
		}
		
		public static String Endpercentage;
		public void verifyEndingpercentage() {
			commonUtilityA.verifyVisiblity(Percentage);
			Endpercentage=Percentage.getText();
			System.out.println("Market Visit End percentage " +Endpercentage+" is displayed");
		}
		
		public void VerifyTotalPercentage() {
			
			Assert.assertNotSame(startpercentage, Endpercentage);
			System.out.println("Percentage Verifyed");
		}
	
	
	
		@FindBy(xpath = "//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/retailer_name_tv']")
		private List<WebElement> txtRetailerName1;
		
		
	
	public static String RetailerName1;
	public static String RetailerNameInUpperCase;

	public void verifyRetailerisDisplayed1() {
		commonUtilityA.verifyVisiblity(txtRetailerName1.get(0));
		RetailerName1 = txtRetailerName.get(0).getText();
		RetailerNameInUpperCase = RetailerName1.toUpperCase();

		System.out.println("Retailer1:  " + RetailerName1 + " is displayed");
		System.out.println("Retailer1:  " + RetailerNameInUpperCase + " is displayed");

	}

	
	
	
	@FindBy(xpath = "//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/ivMore']")
	private List<WebElement> btnMoreIcon;
	
	
	public void ClickMoreicon() {
		
		commonUtilityA.clickElement(btnMoreIcon.get(0));
	}
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/tvOrderBooking")
	private WebElement btnOrderBookingcmp;
	
	public void ClickCompanyUserOrderBooking() throws Throwable {
		
		commonUtilityA.clickElement(btnOrderBookingcmp);
		Thread.sleep(400);
	}
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/order_book_text")
	private WebElement titleOrderBookingHeader;
	
	public void verifyOrderBookingheader() {
		
		Assert.assertEquals(titleOrderBookingHeader.getText(), "Order Booking");
		System.out.println("header Verifyed");
	}
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/outlet_name")
	private WebElement txtOutletTitle;
	
	public void VerifyTheRetailer() {
		
		Assert.assertEquals(txtOutletTitle.getText(), RetailerNameInUpperCase);
		System.out.println("Outlet verifyed");

	}
	
	@FindBy(xpath = "//*[@resource-id='com.botree.mobilitysfa.preprodstage:id/product_name_txt']")
	private List<WebElement> Listproduct;
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/search_src_text")
	private WebElement txtSearchBox;
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/quantity_txt")
	private WebElement txtquantity1;
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/quantity2_txt")
	private WebElement txtquantity2;
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/orderbooking_submit_btn")
	private WebElement btnNext1;
	
	
	public static String productcmp;

	public void Selectproducandenterquantity(String quantitiy1, String quantitiy2) throws Throwable {
		
		product1 = Listproduct.get(0).getText();
		System.out.println("Retailer1:  " + product1 + " is displayed");
		commonUtilityA.sendKeys(txtSearchBox, product1);
		commonUtilityA.sendKeys(txtquantity1, quantitiy1);
		commonUtilityA.hidekeyboard();
		commonUtilityA.sendKeys(txtquantity2, quantitiy2);
		commonUtilityA.hidekeyboard();
		

	}

	public void cmpUserOrderBookingNext() {
		commonUtilityA.clickElement(btnNext);
	}
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/toolbar_title")
	private WebElement VerifyOrderSummaryheader;
	
	@FindBy(id = "com.botree.mobilitysfa.preprodstage:id/retailer_ordsummary_submit_btn")
	private WebElement btnSubmitcmp;
	
	public void VerifyAdnSumbitOrderBooking() {
		
		Assert.assertEquals(VerifyOrderSummaryheader.getText(), "Order Summary");
		System.out.println("Verify Order Summary header");
		commonUtilityA.clickElement(btnSubmitcmp);
	}
	

	
	
	
	
	
	
	
}