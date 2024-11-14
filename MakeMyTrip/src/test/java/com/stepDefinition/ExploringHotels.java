//package com.stepDefinition;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.Reporter;
//
//import com.elementRepository.ExploringHotelPage;
//import com.utilPackage.DriverFactory;
//import com.utilityClasses.FileUtility;
//import com.utilityClasses.WebDriverUtility;
//import io.cucumber.java.en.Then;
//import java.time.Duration;
//
//public class ExploringHotels {
//    WebDriver driver = DriverFactory.getDriver();
//    ExploringHotelPage exploringHotelPage = new ExploringHotelPage(driver);
//    WebDriverUtility driverUtility = new WebDriverUtility();
//    FileUtility fileUtility = new FileUtility();
//    Actions actions = new Actions(driver);
//    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//    @Then("click on group deals radio button to select")
//    public void click_on_group_deals_radio_button_to_select() throws Exception {
//        String verifyGroupDealsRadioButton = fileUtility.getDataFromPropertiesFiles("VerifyGroupDealsRadioButton");
//        Assert.assertTrue(exploringHotelPage.getGroupDealsRadioButton().isDisplayed(), verifyGroupDealsRadioButton);
//        exploringHotelPage.clickGroupDealsRadioButton();
//        Reporter.log("Clicked on group deals radio button", true);
//    }
//
//    @Then("Click on get me best prices")
//    public void click_on_get_me_best_prices() throws Exception {
//        String verifyGetBestPricesButton = fileUtility.getDataFromPropertiesFiles("VerifyGetBestPricesButton");
//        Assert.assertTrue(exploringHotelPage.getGetBestPricesButton().isDisplayed(), verifyGetBestPricesButton);
//        exploringHotelPage.clickGetBestPricesButton();
//        Reporter.log("Clicked on get me best prices", true);
//    }
//
//    @Then("Click and Enter {int} in the search bar")
//    public void click_and_enter_in_the_search_bar(Integer TestCase7) throws Exception {
//        String verifySearchBar = fileUtility.getDataFromPropertiesFiles("VerifySearchBar");
//        Assert.assertTrue(exploringHotelPage.getSearchBar().isDisplayed(), verifySearchBar);
//        exploringHotelPage.clickSearchBar();
//        Reporter.log("Clicked on search bar", true);
//        String area = fileUtility.getDataFromExcel("TestCase7", TestCase7, 0);
//        switch(area) {
//        case "Thailand":
//        	
//        
//        }
//        exploringHotelPage.getSearchBar().sendKeys(area);
//        actions.sendKeys(Keys.ARROW_DOWN).perform();
//        Thread.sleep(3000);
//        actions.sendKeys(Keys.ENTER).perform();
//        Reporter.log("Entered area: " + area + " in the search bar", true);
//    }
//
//    @Then("Select the option from the dropdown and click to search the hotel")
//    public void select_the_option_from_the_dropdown_and_click_to_search_the_hotel() throws Exception {
//        String verifyOptionFromDropdown = fileUtility.getDataFromPropertiesFiles("VerifyOptionFromDropdown");
//        Assert.assertTrue(exploringHotelPage.getOptionFromDropdown().isDisplayed(), verifyOptionFromDropdown);
//        exploringHotelPage.selectOptionFromDropdown();
//        Reporter.log("Selected the option from the dropdown and clicked to search the hotel", true);
//    }
//
//    @Then("Verify is user able to search hotel in different places")
//    public void verify_is_user_able_to_search_hotel_in_different_places() throws Exception {
//        String verifyHotelSearch = fileUtility.getDataFromPropertiesFiles("VerifyHotelSearch");
//        Assert.assertTrue(exploringHotelPage.getVerifyHotelSearch().isDisplayed(), verifyHotelSearch);
//        Reporter.log("Verified user is able to search hotel in different places", true);
//    }
//}
