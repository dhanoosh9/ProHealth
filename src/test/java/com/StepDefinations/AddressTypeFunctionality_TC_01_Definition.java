package com.StepDefinations;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.Elements.DomainValuesElements;
import com.Elements.LoginElements;
import com.ExpectedData.FrontDashBoardData;
import com.Global.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddressTypeFunctionality_TC_01_Definition extends BaseClass {
	String[] expected = null;

	@Given("^Navigate to the prohealth application$")
	public void navigate_to_prohealth_application() {
		driver.navigate().to(baseURL);
		driver.manage().deleteAllCookies();
	}

	@And("^Enter practice valid username and password and click on login button$")
	public void enter_practice_valid_username_and_password_and_click_on_login_button() {
		login();
	}

	@And("^Select apollo and admin values in dropdown$")
	public void select_apollo_and_admin_values_in_dropdown() {
		boolean login_validation = waitE
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Log in to your Account')]")))
				.isDisplayed();
		Assert.assertTrue(login_validation);

		if (driver.findElement(LoginElements.facility_dropdown).isDisplayed()) {
			selectIndex(LoginElements.facility_dropdown, 1);
		}

		selectIndex(LoginElements.roles_dropdown, 1);
		
	}

	@Then("^Click on Login button$")
	public void click_on_login_button() {
		click(login_button);
	}

	@When("^Mouse hover on settings option$")
	public void mouse_hover_on_settings() {
		if (driver.findElement(By.xpath("//div[contains(@class,'breadCrumb')]")).isDisplayed()) {
			hover(DomainValuesElements.settings);

		}
	}

	@And("^Click on domain values button$")
	public void click_on_domain_values_button() {
		click(DomainValuesElements.domain_values);
	}

	@Then("^Verify address type table and add button is displayed$")
	public void verify_address_type_table_and_add_button_is_displayed() {
		if (waitE.until(ExpectedConditions.visibilityOfElementLocated((DomainValuesElements.address_type)))
				.isDisplayed()
				&& waitE.until(ExpectedConditions.visibilityOfElementLocated((DomainValuesElements.add_button)))
						.isDisplayed()) {
			Assert.assertTrue(true);
		}
	}

	@And("^Verify the list of security domain values are displayed by default$")
	public void verify_the_list_of_security_domain_values_are_displayed_by_default() {
		int domain_values = driver.findElements(DomainValuesElements.allvalues).size();
		int values = 43;
		Assert.assertEquals(domain_values, values);
	}

	@And("^Click on the list of all security values one by one$")
	public void click_on_the_list_of_all_security_values_one_by_one() {
		checkTable(FrontDashBoardData.domain_values_xpath.length, FrontDashBoardData.domain_values_xpath,
				FrontDashBoardData.expected, FrontDashBoardData.name);
	}

}
