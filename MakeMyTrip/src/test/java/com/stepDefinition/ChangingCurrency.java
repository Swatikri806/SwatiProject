package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.elementRepository.ChangingCurrencyPage;
import com.utilPackage.DriverFactory;
import com.utilityClasses.FileUtility;

import io.cucumber.java.en.Then;
import java.time.Duration;

public class ChangingCurrency {
	WebDriver driver = DriverFactory.getDriver();
	ChangingCurrencyPage changingCurrencyPage = new ChangingCurrencyPage(driver);
	FileUtility fileUtility = new FileUtility();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	@Then("Click on Currency button and select one currency")
	public void click_on_currency_button_and_select_one_currency() {
		WebElement currencyIcon = changingCurrencyPage.getCurrencyIcon();
		Assert.assertTrue(currencyIcon.isDisplayed(), "Currency icon should be displayed");
		currencyIcon.click();
		Reporter.log("Clicked on Currency button", true);

		WebElement currencyTextfield = changingCurrencyPage.getCurrencyTextfield();
		Assert.assertTrue(currencyTextfield.isDisplayed(), "Currency text field should be displayed");

		WebElement selectedCurrency = changingCurrencyPage.getSelectedCurrency();
		wait.until(ExpectedConditions.elementToBeClickable(selectedCurrency));
		Assert.assertTrue(selectedCurrency.isDisplayed(), "Selected currency should be displayed");
		selectedCurrency.click();
		Reporter.log("Selected Arab Emirates Dirham currency", true);
	}

	@Then("Verify currency is changed to selected one")
	public void verify_currency_is_changed_to_selected_one() {
		WebElement verifyCurrency = changingCurrencyPage.getVerifyCurrency();
		Assert.assertTrue(verifyCurrency.isDisplayed(), "Currency should be changed to AED");
		Reporter.log("Currency is changed to AED", true);
	}

	@Then("verify user is naviagted to hotel list page")
	public void verify_user_is_naviagted_to_hotel_list_page() {
		WebElement verifyBangkok = changingCurrencyPage.getVerifyBangkok();
		Assert.assertTrue(verifyBangkok.isDisplayed(), "User should be navigated to hotel list page");
		Reporter.log("User is navigated to hotel list page", true);
	}

	@Then("Click on sort by price from navbar")
	public void click_on_sort_by_price_from_navbar() {
		WebElement sortByPrice = changingCurrencyPage.getByPrice();
		Assert.assertTrue(sortByPrice.isDisplayed(), "Sort by price option should be displayed");
		sortByPrice.click();
		Reporter.log("Clicked on sort by price from navbar", true);
	}

	@Then("Click and Enter area in the search bar")
	public void click_and_enter_area_in_the_search_bar() throws Exception {
		WebElement searchBar = changingCurrencyPage.getSearch();
		Assert.assertTrue(searchBar.isDisplayed(), "Search bar should be displayed");
		searchBar.click();
		Thread.sleep(3000);
		String area = fileUtility.getDataFromExcel("locality", 1, 0);
		searchBar.sendKeys(area);
		// searchBar.sendKeys(Keys.ENTER);
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_DOWN).perform();
		Thread.sleep(3000);
		act.sendKeys(Keys.ENTER).perform();

		Reporter.log("Entered area: " + area + " in the search bar", true);

		WebElement thirdOption = changingCurrencyPage.getThirdbox();
		wait.until(ExpectedConditions.visibilityOf(thirdOption));
		thirdOption.click();
		Reporter.log("Selected third option from the dropdown", true);
	}

	@Then("Verify hotel list is displayed in the same locality")
	public void verify_hotel_list_is_displayed_in_the_same_locality() {
		WebElement hotelList = changingCurrencyPage.getThirdbox();
		Assert.assertTrue(hotelList.isDisplayed(), "Hotel list should be displayed in the same locality");
		Reporter.log("Verified hotel list is displayed in the same locality", true);
	}
}
