package com.UKTalentHubJava.test_cases.selenium.selenium_test_scripts.cucumberOptions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/UKTalentHubJava/test_cases/selenium/selenium_test_scripts/feature",
        glue = {"com/UKTalentHubJava/test_cases/selenium/selenium_test_scripts/step_definitions"},
        plugin = {"pretty", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"})
public class TestRunner {
}