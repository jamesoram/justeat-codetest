package com.justeat.codetest.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class AbstractPage {

    protected WebDriver driver;
    private WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        // this would be made configurable in a real-life situation
        this.driver = driver;
        PageFactory.initElements(driver, this);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        this.wait = new WebDriverWait(driver, 30);
    }

    public void waitForTextToChange(final WebElement element) {
        final String text = element.getText();
        wait.until(
                new ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        try {
                            return !element.getText().equals(text);
                        } catch (Exception e) {
                            return false;
                        }
                    }
                }
        );
    }
}
