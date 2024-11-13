package com.elementRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HotelSelectionPage {
    WebDriver driver;

    public HotelSelectionPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='hsw_inputBox selectHtlCity']")
    private WebElement cityTextField;

    @FindBy(xpath = "//input[@placeholder='Where do you want to stay?']")
    private WebElement destination;

    @FindBy(xpath = "(//p[@class='sr_city'])[2]")
    private WebElement destinationOption;
    
    @FindBy(xpath = "//button[text()='Apply']")
    private WebElement applyButton;
    
    @FindBy(xpath = "//p[text()='Showing Properties in Bangkok']")
    private WebElement bangkokPropertyList;
    
    public WebElement getBangkokPropertyList() {
		return bangkokPropertyList;
	}

	@FindBy(xpath = "//label[@for='₹ 4500 - ₹ 8000']")
    private WebElement price;
    
    @FindBy(xpath = "//img[@class='mapEntry__map']")
    private WebElement map;
    
    @FindBy(xpath = "//button[@class='areampHdr__cta appendLeft10 ']")
    private WebElement viewMainArea;
    
    public WebElement getMap() {
		return map;
	}

	public WebElement getViewMainArea() {
		return viewMainArea;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getHotelname() {
		return hotelname;
	}

	@FindBy(xpath = "(//div[@class='makeFlex flexOne padding16 relative lftCol'])[1]")
    private WebElement hotelname;
    

    public WebDriver getDriver() {
		return driver;
	}

	public WebElement getApplyButton() {
		return applyButton;
	}

	public WebElement getCityTextField() {
        return cityTextField;
    }

    public WebElement getDestination() {
        return destination;
    }

    public WebElement getDestinationOption() {
        return destinationOption;
    }
    
    public WebElement selectCheckInDate(WebDriver driver,String month,String date) {
	return	 driver.findElement(By.xpath("//div[contains(text(),'"+month.substring(0,3)+"')]/../..//div[text()='"+date.substring(0,2)+"']"));
    }
    public WebElement selectCheckOutDate(WebDriver driver,String month1,String date1) {
    	return	 driver.findElement(By.xpath("//div[contains(text(),'"+month1.substring(0,3)+"')]/../..//div[text()='"+date1.substring(0,2)+"']"));
        }
    
}
