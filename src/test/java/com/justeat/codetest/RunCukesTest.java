package com.justeat.codetest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"html:target/cucumber-html-report"},
        features = {"src/test/resources/features/search.feature"})
public class RunCukesTest {

}