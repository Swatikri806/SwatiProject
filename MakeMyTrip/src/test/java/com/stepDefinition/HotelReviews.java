//package com.stepDefinition;
//
//import java.time.Duration;
//
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.testng.Assert;
//import org.testng.Reporter;
//
//import com.elementRepository.HotelReviewsPage;
//import com.utilPackage.DriverFactory;
//import com.utilityClasses.FileUtility;
//import com.utilityClasses.JavaScriptUtil;
//import com.utilityClasses.WebDriverUtility;
//
//import io.cucumber.java.en.Then;
//
//public class HotelReviews {
//    WebDriver driver = DriverFactory.getDriver();
//    HotelReviewsPage hotelReviewsPage = new HotelReviewsPage(driver);
//    FileUtility fileUtility = new FileUtility();
//    WebDriverUtility driverUtility = new WebDriverUtility();
//    JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
//
//    @Then("Click and Enter {int} in the search bar")
//    public void click_and_enter_in_the_search_bar(Integer string) throws Exception {
//        WebElement searchBar = hotelReviewsPage.getClickSearchBar();
//        Assert.assertTrue(searchBar.isDisplayed(), "Search bar should be displayed");
//        searchBar.click();
//        
//        String locality = fileUtility.getDataFromExcel("locality", string, 0);
//        searchBar.sendKeys(locality);
//        Reporter.log("Entered locality: " + locality + " in the search bar", true);
//    }
//
//    @Then("Select the option from the dropdown and click to search the hotel")
//    public void select_the_option_from_the_dropdown_and_click_to_search_the_hotel() throws InterruptedException {
//        WebElement searchBar = hotelReviewsPage.getClickSearchBar();
//        searchBar.sendKeys(Keys.ARROW_DOWN + " " + Keys.ENTER);
//        
//        WebElement option = hotelReviewsPage.getOptions();
////        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
////        wait.until(ExpectedConditions.visibilityOf(option));
//        option.click();
//        Reporter.log("Selected the option from the dropdown and clicked to search the hotel", true);
//        Thread.sleep(3000);
//    }
//
//    @Then("Scroll down and click on Ratings of the hotel")
//    public void scroll_down_and_click_on_ratings_of_the_hotel() throws InterruptedException {
//        WebElement ratings = hotelReviewsPage.getRatings();
//        Actions action = new Actions(driver);
//        action.moveToElement(ratings).perform();
//        driverUtility.scrollToElement(driver, ratings);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(ratings));
//        ratings.click();
//        Reporter.log("Clicked on Ratings of the hotel", true);
//        
//        for (String windowHandle : driver.getWindowHandles()) {
//            driver.switchTo().window(windowHandle);
//        }
//    }
//
//    @Then("Navigate to details of hotel page and click on user reviews from navbar")
//    public void navigate_to_details_of_hotel_page_and_click_on_user_reviews_from_navbar() {
//        WebElement allReview = hotelReviewsPage.getAllReviews();
//        Actions action = new Actions(driver);
//        action.moveToElement(allReview).perform();
//        driverUtility.scrollToElement(driver, allReview);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.elementToBeClickable(allReview));
//        allReview.click();
//        Reporter.log("Navigated to details of hotel page and clicked on user reviews from navbar", true);
//    }
//
//    @Then("Click on sort by in User Rating & Reviews and select Positive first from dropdown")
//    public void click_on_sort_by_in_user_rating_reviews_and_select_positive_first_from_dropdown() throws InterruptedException {
//        WebElement dropDown = hotelReviewsPage.getDropDown();
//        WebElement option = hotelReviewsPage.getDropdownOption();
//        Actions actions = new Actions(driver);
//        dropDown.click();
//        actions.scrollToElement(option).perform();
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        wait.until(ExpectedConditions.visibilityOf(option));
//        wait.until(ExpectedConditions.elementToBeClickable(option));
//        actions.pause(2000).click(option).perform();
//        Reporter.log("Clicked on sort by in User Rating & Reviews and selected Positive first from dropdown", true);
//        Thread.sleep(3000);
//    }
//
//    @Then("Scroll down to read the reviews and Click on Helpful icon")
//    public void scroll_down_to_read_the_reviews_and_click_on_helpful_icon() {
//        WebElement icon = hotelReviewsPage.getHelpfulIcon();
//        driverUtility.scrollToElement(driver, icon);
//        Actions actions = new Actions(driver);
//        actions.moveToElement(icon).click().perform();
//        Reporter.log("Scrolled down to read the reviews and clicked on Helpful icon", true);
//    }
//}
