package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;

import com.elementRepository.SortByHotelsPage;
import com.utilPackage.DriverFactory;
import com.utilityClasses.FileUtility;
import com.utilityClasses.JavaScriptUtil;
import com.utilityClasses.WebDriverUtility;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SortByHotels {
	WebDriver driver = DriverFactory.getDriver();
	SortByHotelsPage homePage = new SortByHotelsPage(driver);
	WebDriverUtility driverUtility = new WebDriverUtility();
	Actions action = new Actions(driver);
	JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
	FileUtility fileUtility = new FileUtility();

	@Given("Browser is launched and navigate to the URL")
	public void browser_is_launched_and_navigate_to_the_url() throws Exception {
		Reporter.log("Browser is launched", true);
		String verifyURL = fileUtility.getDataFromPropertiesFiles("VerifyURL");
		Assert.assertTrue(driver.getCurrentUrl().contains("makemytrip"), verifyURL);
		driverUtility.moveByOffSetAndClick(driver, 1102, 10);
		Reporter.log("Navigated to the specified URL", true);
	}

	@When("User is able to click on Hotels link")
	public void user_is_able_to_click_on_hotels_link() throws Exception {
		String verifyHotelLink = fileUtility.getDataFromPropertiesFiles("VerifyHotelLink");
		Assert.assertTrue(homePage.getHotelsLink().isEnabled(), verifyHotelLink);
		homePage.hotelsLinkClicked();
		Reporter.log("Clicked on hotel", true);

	}

	@When("Navigate to the Hotels page")
	public void navigate_to_the_hotels_page() throws Exception {
		String verifyHotelURL = fileUtility.getDataFromPropertiesFiles("VerifyHotelURL");
		Assert.assertEquals(driver.getCurrentUrl(), verifyHotelURL);
		Reporter.log("User is navigated to hotels page", true);
	}

	@Then("Click on Search button")
	public void click_on_search_button() throws Exception {
		String searchButton = fileUtility.getDataFromPropertiesFiles("SearchButton");
		Assert.assertTrue(homePage.getSearchButton().isDisplayed(), searchButton);
		homePage.searchButtonClicked();
		Reporter.log("Clicked on Search button", true);
	}

	@Then("Click on User Rating")
	public void click_on_user_rating() throws Exception {
		String ratings = fileUtility.getDataFromPropertiesFiles("Ratings");
		Assert.assertTrue(homePage.getUserRating().isDisplayed(), ratings);
		homePage.userRatingClicked();
		Reporter.log("Clicked on user rating", true);
	}

	@Then("Scroll down and click on highest ratings hotel")
	public void scroll_down_and_click_on_highest_ratings_hotel() throws Exception {
		String highestRating = fileUtility.getDataFromPropertiesFiles("HighestRating");
		WebElement hotelName = homePage.getHotelName();
		action.moveToElement(hotelName).perform();
		WebDriverUtility.waitUntilElementIsClickable(driver, hotelName);
		Assert.assertTrue(hotelName.isDisplayed(), highestRating);
		homePage.highestRatingsHotelClicked();
		Reporter.log("Clicked on highest ratings hotel", true);
	}

	@Then("Click on BOOK THIS NOW button")
	public void click_on_book_this_now_button() throws Exception {
		String switchTab = fileUtility.getDataFromPropertiesFiles("switchTab");
		driverUtility.switchToTabOnTitle(driver, switchTab);
		WebElement bookNowButton = homePage.getBookNowButton();
		jsUtil.jsScrollIntoView(true, bookNowButton);
		String bookNow = fileUtility.getDataFromPropertiesFiles("BookNow ");
		Assert.assertTrue(bookNowButton.isDisplayed(), bookNow);
		homePage.bookNowButtonClicked();
		Reporter.log("Clicked on BOOK THIS NOW button", true);
	}

	@When("User is navigated to Review your Booking")
	public void user_is_navigated_to_review_your_booking() throws Exception {
		WebElement review = homePage.getReviewHotel();
		String reviewBooking = fileUtility.getDataFromPropertiesFiles("ReviewBooking");
		Thread.sleep(4000);
		Assert.assertTrue(review.isDisplayed(), reviewBooking);
		Reporter.log("User is navigated to Review your Booking and element is verified", true);
	}

	@Then("Close the browser")
	public void close_the_browser() {
		Reporter.log("Browser is closed", true);
	}
}
