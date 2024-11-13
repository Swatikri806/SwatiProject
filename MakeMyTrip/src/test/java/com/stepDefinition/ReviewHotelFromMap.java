package com.stepDefinition;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.elementRepository.ReviewHotelFromMapPage;
import com.utilPackage.DriverFactory;
import com.utilityClasses.JavaScriptUtil;
import com.utilityClasses.FileUtility;

import io.cucumber.java.en.Then;

import java.time.Duration;

public class ReviewHotelFromMap {
    WebDriver driver = DriverFactory.getDriver();
    ReviewHotelFromMapPage reviewHotelFromMapPage = new ReviewHotelFromMapPage(driver);
    JavaScriptUtil jsUtil = new JavaScriptUtil(driver);
    Actions actions = new Actions(driver);
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    FileUtility fileUtility = new FileUtility();

    @Then("select one option for the areas")
    public void select_one_option_for_the_areas() throws Exception {
        WebElement area = reviewHotelFromMapPage.getArea();
        jsUtil.jsScrollIntoView(true, area);
    //    wait.until(ExpectedConditions.elementToBeClickable(area));
        String verifyAreaOption = fileUtility.getDataFromPropertiesFiles("VerifyAreaOption");
        Assert.assertTrue(area.isDisplayed(), verifyAreaOption);
        reviewHotelFromMapPage.areaClicked();
        Reporter.log("Clicked on the area option", true);
    }

    @Then("click on view list and navigate to the list of hotels")
    public void click_on_view_list_and_navigate_to_the_list_of_hotels() throws Exception {
        WebElement viewList = reviewHotelFromMapPage.getViewList();
        String verifyViewListButton = fileUtility.getDataFromPropertiesFiles("VerifyViewListButton");
        Assert.assertTrue(viewList.isDisplayed(), verifyViewListButton);
        reviewHotelFromMapPage.viewListClicked();
        
        WebElement propertiesVerification = reviewHotelFromMapPage.getPropertiesValidation();
        String propertyVerification= fileUtility.getDataFromPropertiesFiles("VerifyViewListButton");
        Assert.assertTrue(propertiesVerification.isDisplayed(), propertyVerification);
        Reporter.log("Navigated to hotel list page", true);
    }

    @Then("select hotel name to view details of the hotel")
    public void select_hotel_name_to_view_details_of_the_hotel() throws Exception {
        WebElement filteredHotel = reviewHotelFromMapPage.getFilteredHotel();
        String verifyFilteredHotel = fileUtility.getDataFromPropertiesFiles("VerifyFilteredHotel");
        Assert.assertTrue(filteredHotel.isDisplayed(), verifyFilteredHotel);
        reviewHotelFromMapPage.filteredHotelClicked();
        Reporter.log("Clicked on the filtered hotel to view details", true);
    }
}
