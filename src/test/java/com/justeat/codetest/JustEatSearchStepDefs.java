package com.justeat.codetest;

import com.justeat.codetest.pages.AbstractPage;
import com.justeat.codetest.pages.SearchResultsPage;
import com.justeat.codetest.pages.UkLandingPage;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class JustEatSearchStepDefs {

    private static final String HOME_PAGE = "https://www.just-eat.co.uk";
    private WebDriver driver;
    private AbstractPage currentPage;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        driver.get(HOME_PAGE);
        currentPage = new UkLandingPage(driver);
    }

    @After
    public void tearDown() {
        if (null != driver) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

    @Given("^I want food in \"(.+)\"$")
    public void iWantFoodIn(String postcode) {
        currentPage = ((UkLandingPage)currentPage).enterPostcode(postcode);
    }

    @When("^I search for restaurants$")
    public void iSearchForRestaurants() {
        currentPage = ((UkLandingPage)currentPage).clickFindRestaurants();
    }

    @When("^I filter by \"(.+)\"")
    public void iFiterBy(String choice) {
        currentPage = ((SearchResultsPage)currentPage).filterByCuisine(choice);
    }

    @When("^I filter by name \"(.+)\"$")
    public void iFilterByName(String name) {
        currentPage = ((SearchResultsPage)currentPage).filterByName(name);
    }

    @Then("^I should see some restaurants in \"(.+)\"$")
    public void iShouldSeeSomeRestaurantsIn(String postcode) {
        String header = ((SearchResultsPage)currentPage).getHeader();
        assertThat(header, containsString(postcode));
    }

    @Then("^the results should contain \"(.+)\"$")
    public void resultsShouldContain(String expectedContents) {
        String searchResults = ((SearchResultsPage)currentPage).getEntireSearchResultsText();
        assertThat(searchResults, containsString(expectedContents));
    }
}
