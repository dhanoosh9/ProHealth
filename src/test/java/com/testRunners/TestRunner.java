package com.testRunners;

//import org.junit.runner.RunWith;
//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(features = "Features",tags = "@LoginTest" ,glue = { "com.StepDefinations" }, monochrome = true, plugin = { "pretty",
		"html:HtmlReports/report.html", "json:JSONReports/report.json" })
public class TestRunner extends AbstractTestNGCucumberTests{

}
