package com.justeat.codetest.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchResultsPage extends AbstractPage {

    @FindBy(css = "h1")
    private WebElement header;

    @FindBy(css = ".c-serp__list")
    private WebElement searchResultsDiv;

    @FindBy(id = "nameSearch")
    private WebElement nameSearchTextbox;

    private static final String CUISINE_BY_NAME =
            "//div[@data-ft=\"cuisineFilter\"]/ul/li/a[contains(., '%s')]";

    public SearchResultsPage(WebDriver driver) {
        super(driver);
    }

    public SearchResultsPage filterByCuisine(String cuisineType) {
        driver.findElement(By.xpath(String.format(CUISINE_BY_NAME, cuisineType))).click();
        waitForTextToChange(searchResultsDiv);
        return new SearchResultsPage(driver);
    }

    public String getHeader() {
        return header.getText();
    }

    public String getEntireSearchResultsText() {
        return searchResultsDiv.getText();
    }

    public SearchResultsPage filterByName(String name) {
        nameSearchTextbox.sendKeys(name);
        waitForTextToChange(searchResultsDiv);
        return new SearchResultsPage(driver);
    }
}
