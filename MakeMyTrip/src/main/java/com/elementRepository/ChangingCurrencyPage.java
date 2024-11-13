package com.elementRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangingCurrencyPage {
    WebDriver driver;

    public ChangingCurrencyPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "(//span[@class='style__LocaleSettingsSelectorText-sc-1sh96gm-1 kbXnxm'])[2]")
    private WebElement currencyIcon;
    
    @FindBy(xpath = "//input[@placeholder='Search Currency']")
    private WebElement currencyTextfield;
    
    @FindBy(xpath = "//span[text()='Arab Emirates Dirham']")
    private WebElement selectedCurrency;
    
    @FindBy(xpath = "//span[text()='AED']")
    private WebElement verifyCurrency;
    
    @FindBy(xpath = "//p[text()='Showing Properties in Bangkok']")
    private WebElement verifyBangkok;
    
    @FindBy(xpath = "(//li[@class='srtByFltr__list--item '])[2]")
    private WebElement byPrice;
    
    @FindBy(xpath = "//input[@placeholder='Search for locality / hotel name']")
    private WebElement search;
    
    @FindBy(xpath = "//span[text()='The Berkeley Hotel Pratunam, Bangkok, Thailand']")
    private WebElement thirdbox;

    public WebElement getCurrencyIcon() {
        return currencyIcon;
    }

    public WebElement getCurrencyTextfield() {
        return currencyTextfield;
    }

    public WebElement getSelectedCurrency() {
        return selectedCurrency;
    }

    public WebElement getVerifyCurrency() {
        return verifyCurrency;
    }

    public WebElement getVerifyBangkok() {
        return verifyBangkok;
    }

    public WebElement getByPrice() {
        return byPrice;
    }

    public WebElement getSearch() {
        return search;
    }

    public WebElement getThirdbox() {
        return thirdbox;
    }
}
