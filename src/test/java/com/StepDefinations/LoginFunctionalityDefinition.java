package com.StepDefinations;

import com.Elements.LoginElements;
import com.Global.BaseClass;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginFunctionalityDefinition extends BaseClass {

	@Given("^Navigate to the Prohealth application$")
	public void navigate_to_the_prohealth_application() {
		driver.navigate().to(baseURL);
		driver.manage().deleteAllCookies();
	}

	@When("^Enter practice (.+) valid username (.+) and password (.+) and click on login button$")
	public void enter_practice_valid_username_and_password_and_click_on_login_button(String Practice, String Username,
			String Password) {
		sendKeys(practice, Practice);

		sendKeys(username, Username);

		sendKeys(password, Password);

		click(login_button);
//		logins(Practice, Username, Password);
	}
	
    @And("^Select facility (.+) and roles (.+) values in dropdowns$")
    public void select_facility_and_roles_values_in_dropdowns(int facility, int roles) {
		selectIndex(LoginElements.facility_dropdown, facility);
		
		selectIndex(LoginElements.roles_dropdown, roles);
    }

	@Then("^Click on the Login button$")
	public void click_on_the_login_button() {
		click(login_button);
	}

}
