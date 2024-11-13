package com.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReviewHotelFromMapPage {
    WebDriver driver;

    public ReviewHotelFromMapPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//div[@class='areaLstItem'])[3]")
    private WebElement area;

    @FindBy(xpath = "//button[@class='areampHdr__cta appendLeft10 active']")
    private WebElement viewList;

    @FindBy(xpath = "//div[@class='apldFltr__item--left']")
    private WebElement appliedFilter;

    @FindBy(xpath = "(//span[@class='wordBreak appendRight10'])[1]")
    private WebElement filteredHotel;
    
    @FindBy(xpath = "//button[text()='Apply']")
    private WebElement applyRoom;
    
    @FindBy(xpath = "//p[text()='Showing Properties in Riverside']")
    private WebElement propertiesValidation;

    // Action Methods
    public void areaClicked() {
        new Actions(driver).moveToElement(area).click().perform();
    }

    public void viewListClicked() {
        viewList.click();
    }

    public void filteredHotelClicked() {
        new Actions(driver).moveToElement(filteredHotel).click().perform();
    }

    // Getter Methods
    public WebElement getPropertiesValidation() {
        return propertiesValidation;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebElement getApplyRoom() {
        return applyRoom;
    }

    public WebElement getArea() {
        return area;
    }

    public WebElement getViewList() {
        return viewList;
    }

    public WebElement getAppliedFilter() {
        return appliedFilter;
    }

    public WebElement getFilteredHotel() {
        return filteredHotel;
    }
}
