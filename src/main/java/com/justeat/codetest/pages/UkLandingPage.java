package com.justeat.codetest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UkLandingPage extends AbstractPage {

    public UkLandingPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "postcode")
    private WebElement postcodeTextbox;

    @FindBy(css = ".o-btn--primary")
    private WebElement findRestaurantsButton;

    public SearchResultsPage searchInArea(String postcode) {
        return enterPostcode(postcode).clickFindRestaurants();
    }

    public UkLandingPage enterPostcode(String postcode) {
        postcodeTextbox.sendKeys(postcode);
        return this;
    }

    public SearchResultsPage clickFindRestaurants() {
        findRestaurantsButton.click();
        return new SearchResultsPage(driver);
    }
}
