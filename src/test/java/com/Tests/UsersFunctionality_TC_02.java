package com.Tests;



import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Elements.DomainValuesElements;
import com.Elements.LoginElements;
import com.Elements.UserFunctionalityElements;
import com.ExpectedData.UserFunctionalityData;
import com.Global.BaseClass;

public class UsersFunctionality_TC_02 extends BaseClass {

	@Test
	public void addProvider() throws InterruptedException {

		login();

		selectIndex(LoginElements.facility_dropdown, 1);

		selectIndex(LoginElements.roles_dropdown, 1);

		click(login_button);

		hover(DomainValuesElements.settings);

		hover(UserFunctionalityElements.security_btn);

		click(UserFunctionalityElements.users_btn);

		click(UserFunctionalityElements.add_btn);

		Displayed(UserFunctionalityElements.details_btn);

		Displayed(UserFunctionalityElements.work_hours_btn);

		if (waitE.until(ExpectedConditions.visibilityOfElementLocated(UserFunctionalityElements.work_hours_btn))
				.isEnabled()) {
			Assert.assertTrue(false);
		}

		checkElements(UserFunctionalityData.create_user.length, UserFunctionalityData.create_user);

		click(UserFunctionalityElements.save);

		checkElements(UserFunctionalityData.validations.length, UserFunctionalityData.validations);

		selectIndex(UserFunctionalityElements.dropdown, 2, UserFunctionalityData.dropdown_values);

		validation(UserFunctionalityElements.firstname, UserFunctionalityElements.f_validation);

		sendKeys(UserFunctionalityElements.firstname, "Alan");

		validation(UserFunctionalityElements.lastname, UserFunctionalityElements.f_validation);

		sendKeys(UserFunctionalityElements.lastname, "Walker");

		click(UserFunctionalityElements.select_user_role);

		Displayed(By.xpath("(//div[contains(.,'Select Role')])[15]"));

		checkElements(UserFunctionalityData.select_role.length, UserFunctionalityData.select_role);

		Thread.sleep(3000);
	}

}
