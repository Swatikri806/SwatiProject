//package com.elementRepository;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.interactions.Actions;
//import org.openqa.selenium.support.FindBy;
//import org.openqa.selenium.support.PageFactory;
//import org.testng.Assert;
//import org.testng.Reporter;
//
//import com.utilityClasses.WebDriverUtility;
//
//public class ExploringHotelPage {
//    private WebDriver driver;
//
//    public ExploringHotelPage(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver, this);
//    }
//
//    @FindBy(xpath = "//span[text()='Group Deals']")
//    private WebElement groupDealsRadioButton;
//
//    @FindBy(xpath = "//button[@id='hsw_search_button']")
//    private WebElement getBestPricesButton;
//
//    @FindBy(xpath = "//input[@placeholder='Search for locality / hotel name']")
//    private WebElement searchBar;
//
//    @FindBy(xpath = "//ul[@id='search-results-dropdown']//li[1]")
//    private WebElement optionFromDropdown;
//
//    @FindBy(xpath = "//div[@id='hotel-search-results']")
//    private WebElement verifyHotelSearch;
//
//    // Action Methods
//    public void clickGroupDealsRadioButton() {
//        groupDealsRadioButton.click();
//        
//    }
//
//    public void clickGetBestPricesButton() {
//        
//        getBestPricesButton.click();
//    }
//
//    public void clickSearchBar() {
//       
//        searchBar.click();
//    }
//
//    public void selectOptionFromDropdown() {
//    	 optionFromDropdown.click();
//       
//    }
//
//    // Getter Methods
//    public WebElement getGroupDealsRadioButton() {
//        return groupDealsRadioButton;
//    }
//
//    public WebElement getGetBestPricesButton() {
//        return getBestPricesButton;
//    }
//
//    public WebElement getSearchBar() {
//        return searchBar;
//    }
//
//    public WebElement getOptionFromDropdown() {
//        return optionFromDropdown;
//    }
//
//    public WebElement getVerifyHotelSearch() {
//        return verifyHotelSearch;
//    }
//}
