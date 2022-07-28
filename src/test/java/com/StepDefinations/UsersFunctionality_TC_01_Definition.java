package com.StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Elements.DomainValuesElements;

import com.Elements.UserFunctionalityElements;
import com.ExpectedData.UserFunctionalityData;
import com.Global.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class UsersFunctionality_TC_01_Definition extends BaseClass {

	@Before
	public void setUp() {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();

	}

	@After
	public void tearDown() {
		click(admin_btn);
		click(logout_btn);
		driver.quit();
	}

	@When("^Mouse hover on settings$")
	public void mouse_hover_on_settings() {
		hover(DomainValuesElements.settings);
		hover(UserFunctionalityElements.security_btn);
	}

	@And("^Click on users button$")
	public void click_on_users_button() {
		click(UserFunctionalityElements.users_btn);
	}

	@Then("^Verify the column names of users view page$")
	public void verify_the_column_names_of_users_view_page() {
		Displayed(By.xpath("//div[@class='breadCrumb'][contains(.,'Users')]"));
		checkElements(UserFunctionalityData.users_column_names.length, UserFunctionalityData.users_column_names);
	}

	@And("^Verify the add button is displayed$")
	public void verify_the_add_button() {
		Displayed(UserFunctionalityElements.add_btn);
	}

}
