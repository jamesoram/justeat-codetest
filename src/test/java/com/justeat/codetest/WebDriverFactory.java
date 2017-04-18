package com.justeat.codetest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class WebDriverFactory {

    static WebDriver getDriver() {
        // here we could add logic to support different types of browsers, perhaps connect to a grid
        // or choose some desired capabilities based on configuration. However, I'm going to keep it simple.
        return new ChromeDriver();
    }
}
