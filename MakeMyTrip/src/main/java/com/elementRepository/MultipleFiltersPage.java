package com.elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
    
    public WebElement getCityBox() {
		return cityBox;
	}
    @FindBy (xpath = "//button[text()='Apply']")
    private WebElement applyButton;

	@FindBy(xpath = "//input[@placeholder=' Where do you want to stay?']")
    private WebElement cityPopUp;
    
    public WebElement getApplyButton() {
		return applyButton;
	}

	public WebElement getSwimmingPool() {
		return swimmingPool;
	}

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
    
    
    public WebElement selectCheckInDate(WebDriver driver,String month,String date) {
    	return	 driver.findElement(By.xpath("//div[contains(text(),'"+month.substring(0,3)+"')]/../..//div[text()='"+date.substring(0,2)+"']"));
        }
    @FindBy(xpath = "//div[text()='December']/../..//div[text()='21']") 
    private WebElement checkInDate; 
    @FindBy(xpath = "//div[text()='December']/../..//div[text()='26']") 
    private WebElement checkOutDate; 
    public WebElement getCheckInDate() { 
    	return checkInDate; 
    	} 
    public WebElement getCheckOutDate() { 
    	return checkOutDate; 
    }
    
//    @FindBy(xpath = "(//div[@class='apldFltr__item--left'])[4]")
//    private WebElement verifyApplied;
    
    @FindBy (xpath = "//input[@class='rangeInput ']")
    private WebElement minRange;
    

    @FindBy (xpath = "//input[@class='appendLeft5 rangeInput ']")
    private WebElement maxRange;
    
    @FindBy (xpath = " //span[text()='to']")
    private WebElement yourBudget;
    
    @FindBy(xpath = "//button[@aria-label='Select Range button']")
    private WebElement budgetApply;
 
   public WebElement getBudgetApply() {
		return budgetApply;
	}

@FindBy(xpath = "//label[@for='₹ 8000 - ₹ 12000']")
   private WebElement priceFilter;


	public WebElement getPriceFilter() {
	return priceFilter;
}

	public WebElement getYourBudget() {
		return yourBudget;
	}

	public WebElement getMinRange() {
		return minRange;
	}

	public WebElement getMaxRange() {
		return maxRange;
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
