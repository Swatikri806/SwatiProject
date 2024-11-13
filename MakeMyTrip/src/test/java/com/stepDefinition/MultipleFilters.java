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
    public void scroll_down_to_the_list_of_places() {
        WebElement jaipurLink = multipleFiltersPage.getJaipurLink();
        jsUtil.jsScrollIntoView(true, jaipurLink);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(jaipurLink));
        wait.until(ExpectedConditions.elementToBeClickable(jaipurLink));
        Assert.assertTrue(jaipurLink.isDisplayed(), "Jaipur link should be displayed");
        Reporter.log("Scrolled down to the list of places", true);
    }

    @Then("Click on the specific location for hotels")
    public void click_on_the_specific_location_for_hotels() {
        WebElement jaipurLink = multipleFiltersPage.getJaipurLink();
        Assert.assertTrue(jaipurLink.isEnabled(), "Jaipur link should be clickable");
        jsUtil.jsClick(jaipurLink);
        Assert.assertTrue(driver.getCurrentUrl().contains("jaipur"), "URL should contain 'jaipur' after clicking the link");
        Reporter.log("Clicked on the specific location for hotels", true);
    }

    @Then("Verify after navigating to the page")
    public void verify_after_navigating_to_the_page() {
        WebElement verifyPage = multipleFiltersPage.getVerifyPage();
        Assert.assertTrue(verifyPage.isDisplayed(), "Verification page should be displayed");
        Reporter.log("Verified after navigating to the page", true);
    }

    @Then("Enter city and select checkin, checkout and room and guests textfield")
    public void enter_city_and_select_checkin_checkout_and_room_and_guests_textfield() throws Exception {
        multipleFiltersPage.getCityBox().click();
        String city = fileUtility.getDataFromExcel("TextFieldValue", 3, 0);
        WebElement cityPopUp = multipleFiltersPage.getCityPopUp();
        cityPopUp.sendKeys(city);
        Reporter.log("City entered in popup: " + city, true);
        actions.sendKeys(cityPopUp, Keys.ARROW_DOWN + "" + Keys.ARROW_DOWN + "" + Keys.ENTER).click().perform();
        multipleFiltersPage.getCheckInDate().click();
        multipleFiltersPage.getCheckOutDate().click();
        multipleFiltersPage.getApplyButton().click();
        Reporter.log("Entered city and selected checkin, checkout and room and guests textfield", true);
    }

    @When("User clicks on multiple filters")
    public void user_clicks_on_multiple_filters() throws InterruptedException {
        actions.scrollByAmount(0, 200).perform();
        WebElement starFilter = multipleFiltersPage.getStarFilter();
        Assert.assertTrue(starFilter.isDisplayed(), "Star filter should be displayed");
        starFilter.click();
        Reporter.log("Clicked on Star filter", true);
        Thread.sleep(2000);

        actions.scrollByAmount(0, 100).perform();
        WebElement breakfastFilter = multipleFiltersPage.getBreakfastFilter();
        Assert.assertTrue(breakfastFilter.isDisplayed(), "Breakfast filter should be displayed");
        breakfastFilter.click();
        Reporter.log("Clicked on Breakfast filter", true);
        Thread.sleep(2000);

        actions.scrollByAmount(0, 300).perform();
        WebElement swimmingPoolFilter = multipleFiltersPage.getSwimmingPool();
        Assert.assertTrue(swimmingPoolFilter.isDisplayed(), "Swimming Pool filter should be displayed");
        swimmingPoolFilter.click();
        Reporter.log("Clicked on Swimming Pool filter", true);
        Thread.sleep(2000);

        actions.scrollByAmount(0, 500).perform();
        WebElement priceFilter = multipleFiltersPage.getPriceFilter();
        Assert.assertTrue(priceFilter.isDisplayed(), "Price filter should be displayed");
        priceFilter.click();
        Reporter.log("Clicked on Price filter", true);
        Thread.sleep(2000);
    }

    @Then("Verify all the filters are applied to the page")
    public void verify_all_the_filters_are_applied_to_the_page() {
        WebElement appliedFilters = multipleFiltersPage.getAppliedFilters();
        Assert.assertTrue(appliedFilters.isDisplayed(), "All filters should be applied");
        Reporter.log("All filters are applied", true);
    }

    @When("User is able to scroll down to your budget option in filters section")
    public void user_is_able_to_scroll_down_to_your_budget_option_in_filters_section() {
        actions.scrollByAmount(0, 200).perform();
        Assert.assertTrue(multipleFiltersPage.getYourBudget().isDisplayed(), "Budget option should be displayed");
        Reporter.log("Budget option is displayed", true);
    }

    @Then("Enter max and min value in budget textfield")
    public void enter_max_and_min_value_in_budget_textfield() throws Exception {
        WebElement minRange = multipleFiltersPage.getMinRange();
        minRange.click();
        String minValue = fileUtility.getDataFromExcel("TextFieldValue", 4, 0);
        minRange.sendKeys(minValue);
        Assert.assertEquals(minRange.getAttribute("value"), minValue, "Min budget value should match the entered value");
        Reporter.log("Min value entered in popup: " + minValue, true);

        WebElement maxRange = multipleFiltersPage.getMaxRange();
        maxRange.click();
        String maxValue = fileUtility.getDataFromExcel("TextFieldValue", 5, 0);
        maxRange.sendKeys(maxValue);
        Assert.assertEquals(maxRange.getAttribute("value"), maxValue, "Max budget value should match the entered value");
        Reporter.log("Max value entered in popup: " + maxValue, true);
    }

    @Then("Click on arrow button")
    public void click_on_arrow_button() {
        WebElement budgetApply = multipleFiltersPage.getBudgetApply();
        Assert.assertTrue(budgetApply.isDisplayed(), "Arrow button should be displayed");
        budgetApply.click();
        Reporter.log("Clicked on arrow button", true);
    }

	
}
