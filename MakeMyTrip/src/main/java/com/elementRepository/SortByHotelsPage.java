package com.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.utilityClasses.WebDriverUtility;

public class SortByHotelsPage {
    private WebDriver driver;

    public SortByHotelsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//span[contains(@class, 'chNavIcon appendBottom2 chSprite chHotels inactive')]")
    private WebElement hotelsLink;

    @FindBy(xpath = "//button[@id='hsw_search_button']")
    private WebElement searchButton;

    @FindBy(xpath = "(//span[@class='srtByFltr__list--itemTitle'])[2]")
    private WebElement userRating;

    @FindBy(xpath = "//button[text()='BOOK THIS NOW']")
    private WebElement bookNowButton;

    @FindBy(xpath = "//h2[@class='font24 latoBlack whiteText']")
    private WebElement reviewHotel;

    @FindBy(xpath = "//input[@class='checkInDropdownClass']")
    private WebElement checkInDropdown;

    @FindBy(xpath = "//span[@id='htl_id_seo_202212071048015676']")
    private WebElement hotelName;

    @FindBy(xpath = "//a[text()='Pay Now']")
    private WebElement payNowButton;

    // Action Methods
    public void hotelsLinkClicked() {
        hotelsLink.click();
    }

    public void searchButtonClicked() {
        searchButton.click();
    }

    public void userRatingClicked() {
        userRating.click();
    }

    public void bookNowButtonClicked() {
        bookNowButton.click();
    }

    public void reviewHotelClicked() {
        reviewHotel.click();
    }
    
    public void highestRatingsHotelClicked() {
        new Actions(driver).moveToElement(hotelName).perform();
        WebDriverUtility.waitUntilElementIsClickable(driver, hotelName);
        hotelName.click();
    }

    // Getter Methods
    public WebElement getPayNowButton() {
        return payNowButton;
    }

    public WebElement getHotelName() {
        return hotelName;
    }

    public WebElement getHotelsLink() {
        return hotelsLink;
    }

    public WebElement getSearchButton() {
        return searchButton;
    }

    public WebElement getUserRating() {
        return userRating;
    }

    public WebElement getBookNowButton() {
        return bookNowButton;
    }

    public WebElement getReviewHotel() {
        return reviewHotel;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
