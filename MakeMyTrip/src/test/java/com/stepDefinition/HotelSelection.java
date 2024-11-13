package com.stepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.elementRepository.HotelSelectionPage;
import com.utilPackage.DriverFactory;
import com.utilityClasses.FileUtility;
import com.utilityClasses.JavaScriptUtil;
import com.utilityClasses.WebDriverUtility;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HotelSelection {
	WebDriver driver = DriverFactory.getDriver();
	HotelSelectionPage hotelSelectionPage = new HotelSelectionPage(driver);
	FileUtility fileUtility = new FileUtility();
	JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
	Actions actions = new Actions(driver);
	WebDriverUtility driverUtility = new WebDriverUtility();

	@Then("user is able to select city or location")
	public void user_is_able_to_select_city_or_location() throws Exception {
		hotelSelectionPage.getCityTextField().click();
		WebElement destination = hotelSelectionPage.getDestination();	
		String city = fileUtility.getDataFromExcel("TextFieldValue", 0, 0);
		destination.sendKeys(city);
		Assert.assertTrue(destination.isDisplayed(), "Destination field should be displayed"); 
		actions.pause(3000).sendKeys(destination, Keys.ARROW_DOWN + "" + Keys.ARROW_DOWN + "" + Keys.ENTER).perform();
		Reporter.log("City entered and selected: " + city, true); 
	}

	@Then("user is able to choose checkin and checkout dates")
	public void user_is_able_to_choose_checkin_and_checkout_dates() throws Exception {
		actions.scrollByAmount(0, 200).perform();
		String month = fileUtility.getDataFromExcel("TextFieldValue", 1, 0);
		String date = fileUtility.getDataFromExcel("TextFieldValue", 1, 1);
		Assert.assertTrue(hotelSelectionPage.selectCheckInDate(driver, month, date).isDisplayed(), "Check-in date should be selected");
		hotelSelectionPage.selectCheckInDate(driver, month, date).click();
		Reporter.log("Check-in date selected: " + month + " " + date, true);

		String month1 = fileUtility.getDataFromExcel("TextFieldValue", 1, 0);
		String date1 = fileUtility.getDataFromExcel("TextFieldValue", 2, 1);
		Assert.assertTrue(hotelSelectionPage.selectCheckOutDate(driver, month1, date1).isDisplayed(), "Check-out date should be selected"); 
		hotelSelectionPage.selectCheckOutDate(driver, month1, date1).click();
	    Reporter.log("Check-out date selected: " + month1 + " " + date1, true); 
	}

	@Then("select Room and guests then click on apply button")
	public void select_room_and_guests_then_click_on_apply_button() {
		Assert.assertTrue(hotelSelectionPage.getApplyButton().isDisplayed(), "Apply button should be displayed"); 
		hotelSelectionPage.getApplyButton().click();
		Reporter.log("Clicked on Apply button", true); 

	}
	
	@Then("Verify user is navigated to hotels list page")
	public void verify_user_is_navigated_to_hotels_list_page() {
		Assert.assertTrue(hotelSelectionPage.getBangkokPropertyList().isDisplayed());
		Reporter.log("User is navigated to Bangkok Property hotel list ");
	}


	@When("Scroll down to Price per night in filter option")
	public void scroll_down_to_price_per_night_in_filter_option() {
		actions.scrollByAmount(0, 1000).perform();	
		Reporter.log("Scrolled down to Price per night in filter option", true); 

	}

	@When("Select price checkbox and navigate to hotel list")
	public void select_price_checkbox_and_navigate_to_hotel_list() {
		WebElement priceCheckbox = hotelSelectionPage.getPrice();
		Assert.assertTrue(priceCheckbox.isDisplayed(), "Price checkbox should be displayed"); 
		priceCheckbox.click();
		Reporter.log("Selected Price checkbox and navigated to hotel list", true);

	}

	@Then("user should be able to click on hotel to view the hotel details")
	public void user_should_be_able_to_click_on_hotel_to_view_the_hotel_details() {
		WebElement hotelName = hotelSelectionPage.getHotelname();
		Assert.assertTrue(hotelName.isDisplayed(), "Hotel name should be displayed");
		hotelName.click(); 
		Reporter.log("Clicked on hotel to view the hotel details", true);

	}

	@When("Click on explore on map")
	public void click_on_explore_on_map() {
       WebElement map = hotelSelectionPage.getMap();
       Assert.assertTrue(map.isDisplayed(), "Map should be displayed");
       map.click();
       Reporter.log("Clicked on explore on map", true);
		
	}

	@Then("click on View main areas")
	public void click_on_view_main_areas() {
		WebElement viewMainArea = hotelSelectionPage.getViewMainArea(); 
		Assert.assertTrue(viewMainArea.isDisplayed(), "View main areas should be displayed");
		viewMainArea.click(); 
		Reporter.log("Clicked on View main areas", true);
	}

	

}
