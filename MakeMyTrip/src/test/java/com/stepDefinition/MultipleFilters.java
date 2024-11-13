package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.elementRepository.HotelSelectionPage;
import com.elementRepository.MultipleFiltersPage;
import com.utilPackage.DriverFactory;
import com.utilityClasses.FileUtility;
import com.utilityClasses.JavaScriptUtil;
import com.utilityClasses.WebDriverUtility;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.time.Duration;

public class MultipleFilters {
	WebDriver driver = DriverFactory.getDriver();
	MultipleFiltersPage multipleFiltersPage = new MultipleFiltersPage(driver);
	WebDriverUtility driverUtility = new WebDriverUtility();
	JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
	HotelSelectionPage hotelSelectionPage = new HotelSelectionPage(driver);
	FileUtility fileUtility = new FileUtility();
	Actions actions = new Actions(driver);

	@Then("Scroll down to the list of places")
	public void scroll_down_to_the_list_of_places() throws Exception {
		WebElement jaipurLink = multipleFiltersPage.getJaipurLink();
		jsUtil.jsScrollIntoView(true, jaipurLink);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(jaipurLink));
		wait.until(ExpectedConditions.elementToBeClickable(jaipurLink));
		String jaipur = fileUtility.getDataFromPropertiesFiles("JaipurLink");
		Assert.assertTrue(jaipurLink.isDisplayed(), jaipur);
		multipleFiltersPage.jaipurLinkClicked();
		Reporter.log("User is able to scroll down to the list of places", true);
	}

	@Then("Click on the specific location for hotels")
	public void click_on_the_specific_location_for_hotels() throws Exception {
		WebElement jaipurLink = multipleFiltersPage.getJaipurLink();
		String jaipurCity = fileUtility.getDataFromPropertiesFiles("JaipurHotels");
		Assert.assertTrue(jaipurLink.isEnabled(), jaipurCity);
		multipleFiltersPage.jaipurLinkClicked();
		String jaipurURL = fileUtility.getDataFromPropertiesFiles("JaipurURL");
		Assert.assertTrue(driver.getCurrentUrl().contains("jaipur"), jaipurURL);
		Reporter.log("User is able to click on the specific location for hotels", true);
	}

	@Then("Verify after navigating to the page")
	public void verify_after_navigating_to_the_page() throws Exception {
		multipleFiltersPage.verifyPropertiesValidation();
		String verifyPages = fileUtility.getDataFromPropertiesFiles("VerifyPage");
		Assert.assertTrue(multipleFiltersPage.getVerifyPage().isDisplayed(), verifyPages);
		Reporter.log("Verified after navigating to the page", true);
	}

	@Then("Enter city and select checkin, checkout and room and guests textfield")
	public void enter_city_and_select_checkin_checkout_and_room_and_guests_textfield() throws Exception {
		multipleFiltersPage.cityBoxClicked();
		String city = fileUtility.getDataFromExcel("TextFieldValue", 3, 0);
		multipleFiltersPage.cityPopUpEntered(city);
		Reporter.log("City entered in popup: " + city, true);
		multipleFiltersPage.selectCityFromDropdown();
		multipleFiltersPage.checkInDateClicked();
		multipleFiltersPage.checkOutDateClicked();
		multipleFiltersPage.applyButtonClicked();
		Reporter.log("User is able to Enter city and selected checkin, checkout, room, and guests textfield", true);
	}

	@When("User clicks on multiple filters")
	public void user_clicks_on_multiple_filters() throws Exception {
		actions.scrollByAmount(0, 200).perform();
		String verifyStarFilter = fileUtility.getDataFromPropertiesFiles("VerifyStarFilter");
		Assert.assertTrue(multipleFiltersPage.getStarFilter().isDisplayed(), verifyStarFilter);
		multipleFiltersPage.starFilterClicked();
		Reporter.log(" User Clicked on Star filter", true);
		Thread.sleep(2000);

		actions.scrollByAmount(0, 100).perform();
		String verifyBreakfastFilter = fileUtility.getDataFromPropertiesFiles("VerifyBreakfastFilter");
		Assert.assertTrue(multipleFiltersPage.getBreakfastFilter().isDisplayed(), verifyBreakfastFilter);
		multipleFiltersPage.breakfastFilterClicked();
		Reporter.log("User Clicked on Breakfast filter", true);
		Thread.sleep(2000);

		actions.scrollByAmount(0, 300).perform();
		String verifySwimmingPool = fileUtility.getDataFromPropertiesFiles("VerifySwimmingPool");
		Assert.assertTrue(multipleFiltersPage.getSwimmingPool().isDisplayed(), verifySwimmingPool);
		multipleFiltersPage.swimmingPoolClicked();
		Reporter.log("User Clicked on Swimming Pool filter", true);
		Thread.sleep(2000);

		actions.scrollByAmount(0, 600).perform();
		String verifyPriceFilter = fileUtility.getDataFromPropertiesFiles("VerifyPriceFilter");
		Assert.assertTrue(multipleFiltersPage.getPriceFilter().isDisplayed(), verifyPriceFilter);
		multipleFiltersPage.priceFilterClicked();
		Reporter.log("User Clicked on Price filter", true);
		Thread.sleep(2000);
	}

	@Then("Verify all the filters are applied to the page")
	public void verify_all_the_filters_are_applied_to_the_page() throws Exception {
		WebElement appliedFilters = multipleFiltersPage.getAppliedFilters();
		String verifyAppliedFilters = fileUtility.getDataFromPropertiesFiles("VerifyAppliedFilters");
		Assert.assertTrue(appliedFilters.isDisplayed(), verifyAppliedFilters);
		Reporter.log("All filters are applied successfully", true);
	}

	@When("User is able to scroll down to your budget option in filters section")
	public void user_is_able_to_scroll_down_to_your_budget_option_in_filters_section() throws Exception {
		actions.scrollByAmount(0, 200).perform();
		String verifyBudgetOption = fileUtility.getDataFromPropertiesFiles("VerifyBudgetOption");
		Assert.assertTrue(multipleFiltersPage.getYourBudget().isDisplayed(), verifyBudgetOption);
		Reporter.log("User is able to see Budget option after scrolling", true);
	}

	@Then("Enter max and min value in budget textfield")
	public void enter_max_and_min_value_in_budget_textfield() throws Exception {
		multipleFiltersPage.minRangeClicked();
		String minValue = fileUtility.getDataFromExcel("TextFieldValue", 4, 0);
		multipleFiltersPage.enterMinValue(minValue);
		String verifyMinValue = fileUtility.getDataFromPropertiesFiles("VerifyMinValue");
		Assert.assertEquals(multipleFiltersPage.getMinRange().getAttribute("value"), minValue, verifyMinValue);
		Reporter.log("Min value entered in popup: " + minValue, true);
		multipleFiltersPage.maxRangeClicked();
		String maxValue = fileUtility.getDataFromExcel("TextFieldValue", 5, 0);
		multipleFiltersPage.enterMaxValue(maxValue);
		String verifyMaxValue = fileUtility.getDataFromPropertiesFiles("VerifyMaxValue");
		Assert.assertEquals(multipleFiltersPage.getMaxRange().getAttribute("value"), maxValue, verifyMaxValue);
		Reporter.log("Max value entered in popup: " + maxValue, true);
	}

	@Then("Click on arrow button")
	public void click_on_arrow_button() throws Exception {
		WebElement budgetApply = multipleFiltersPage.getBudgetApply();
		String verifyArrowButton = fileUtility.getDataFromPropertiesFiles("VerifyArrowButton");
		Assert.assertTrue(budgetApply.isDisplayed(), verifyArrowButton);
		multipleFiltersPage.budgetApplyClicked();
		Reporter.log("Clicked on arrow button", true);
	}
}
