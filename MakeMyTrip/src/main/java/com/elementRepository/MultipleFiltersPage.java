package com.elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.utilityClasses.FileUtility;

public class MultipleFiltersPage {
    WebDriver driver;

    public MultipleFiltersPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//a[@class='darkGreyText'])[37]") 
    private WebElement jaipurLink;
    
    @FindBy(xpath = "//label[@class='lbl_input latoBold font12 blueText']")
    private WebElement cityBox;

    @FindBy(xpath = "//button[text()='Apply']")
    private WebElement applyButton;

    @FindBy(xpath = "//input[@placeholder=' Where do you want to stay?']")
    private WebElement cityPopUp;

    @FindBy(xpath = "//p[contains(text(),'Showing Properties in Jaipur')]")
    private WebElement verifyPage;
    
    @FindBy(xpath = "(//span[text()='5 Star'])[1]")
    private WebElement starFilter;
    
    @FindBy(xpath = "//span[text()='Free Breakfast']")
    private WebElement breakfastFilter;
    
    @FindBy(xpath = "(//span[text()='Swimming Pool'])[1]")
    private WebElement swimmingPool;
    
    @FindBy(xpath = "//span[text()='Applied Filters']")
    private WebElement appliedFilters;

    @FindBy(xpath = "//div[text()='December']/../..//div[text()='21']") 
    private WebElement checkInDate; 
    
    @FindBy(xpath = "//div[text()='December']/../..//div[text()='26']") 
    private WebElement checkOutDate; 
    
    @FindBy(xpath = "//input[@class='rangeInput ']")
    private WebElement minRange;
    
    @FindBy(xpath = "//input[@class='appendLeft5 rangeInput ']")
    private WebElement maxRange;
    
    @FindBy(xpath = "//span[text()='to']")
    private WebElement yourBudget;
    
    @FindBy(xpath = "//button[@aria-label='Select Range button']")
    private WebElement budgetApply;
 
    @FindBy(xpath = "//label[@for='₹ 8000 - ₹ 12000']")
    private WebElement priceFilter;

    // Action Methods
    public void jaipurLinkClicked() {
        new Actions(driver).moveToElement(jaipurLink).click().perform();
    }

    public void cityBoxClicked() {
        cityBox.click();
    }

    public void applyButtonClicked() {
        applyButton.click();
    }

    public void cityPopUpEntered(String city) {
        cityPopUp.sendKeys(city);
    }

    public void starFilterClicked() {
        starFilter.click();
    }

    public void breakfastFilterClicked() {
        breakfastFilter.click();
    }

    public void swimmingPoolClicked() {
        swimmingPool.click();
    }

    public void priceFilterClicked() {
        priceFilter.click();
    }

    public void budgetApplyClicked() {
        budgetApply.click();
    }

    public void verifyPropertiesValidation() throws Exception {
    	FileUtility fileUtility = new FileUtility();
        String verifyPropertiesValidation = fileUtility.getDataFromPropertiesFiles("PropertyVerification");
        Assert.assertTrue(verifyPage.isDisplayed(), verifyPropertiesValidation);
    }

    public void selectCityFromDropdown() {
        new Actions(driver).sendKeys(cityPopUp, Keys.ARROW_DOWN + "" + Keys.ARROW_DOWN + "" + Keys.ENTER).click().perform();
    }

    public void checkInDateClicked() {
        checkInDate.click();
    }

    public void checkOutDateClicked() {
        checkOutDate.click();
    }

    public void minRangeClicked() {
        minRange.click();
    }

    public void enterMinValue(String minValue) {
        minRange.sendKeys(minValue);
    }

    public void maxRangeClicked() {
        maxRange.click();
    }

    public void enterMaxValue(String maxValue) {
        maxRange.sendKeys(maxValue);
    }

    // Getter Methods
    public WebElement getCityBox() {
        return cityBox;
    }

    public WebElement getApplyButton() {
        return applyButton;
    }

    public WebElement getSwimmingPool() {
        return swimmingPool;
    }

    public WebElement getCheckInDate() {
        return checkInDate;
    }

    public WebElement getCheckOutDate() {
        return checkOutDate;
    }

    public WebElement getMinRange() {
        return minRange;
    }

    public WebElement getMaxRange() {
        return maxRange;
    }

    public WebElement getYourBudget() {
        return yourBudget;
    }

    public WebElement getBudgetApply() {
        return budgetApply;
    }

    public WebElement getPriceFilter() {
        return priceFilter;
    }

    public WebElement getJaipurLink() {
        return jaipurLink;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getVerifyPage() {
        return verifyPage;
    }

    public WebElement getStarFilter() {
        return starFilter;
    }

    public WebElement getBreakfastFilter() {
        return breakfastFilter;
    }

    public WebElement getCityPopUp() {
        return cityPopUp;
    }

    public WebElement getAppliedFilters() {
        return appliedFilters;
    }
}
