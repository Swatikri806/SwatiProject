package com.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelReviewsPage {
    private WebDriver driver;

    public HotelReviewsPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    @FindBy(xpath = "//input[@placeholder='Search for locality / hotel name']")
    private WebElement clickSearchBar;

    @FindBy(xpath = "//p[@class='makeFlex font16 hrtlCenter']")
    private WebElement locality;
    
    @FindBy(xpath = "(//p[@class='makeFlex font16 hrtlCenter'])[4]")
    private WebElement options;

   

	@FindBy(xpath = "(//span[text()='Very Good'])[1]")
    private WebElement ratings;
	
	@FindBy(xpath = "//h1[@class='hotelName']")
	private WebElement hotelNameDisplayed;

    

	@FindBy(xpath = "//button[text()='Update Search']")
    private WebElement updateSearch;

    @FindBy(xpath = "//div[@class='sortBy__dropdownCont']")
    private WebElement dropDown;

    @FindBy(xpath = "//li[contains(text(),'Positive first')]")
    private WebElement dropdownOption;

    @FindBy(xpath = "(//span[@class='sprite icUpvote appendLeft5'])[2]")
    private WebElement helpfulIcon;
    
    public WebElement getHotelNameDisplayed() {
		return hotelNameDisplayed;
	}
    ////p[text()='Sort by:']
    
    @FindBy(xpath = "//button[text()='All Reviews']")
    private WebElement allReviews;
    
    public WebElement getUpdateSearch() {
		return updateSearch;
	}

	public WebElement getAllReviews() {
		return allReviews;
	}

	public WebElement getOptions() {
		return options;
	}


    public WebElement getClickSearchBar() {
		return clickSearchBar;
	}

	public WebElement getLocality() {
        return locality;
    }

    public WebElement getRatings() {
        return ratings;
    }

    public WebElement getDropDown() {
        return dropDown;
    }

    public WebElement getDropdownOption() {
        return dropdownOption;
    }

    public WebElement getHelpfulIcon() {
        return helpfulIcon;
    }
}
