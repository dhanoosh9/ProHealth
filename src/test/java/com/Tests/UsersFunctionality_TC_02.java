package com.Tests;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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

	private static Logger log = LogManager.getLogger(UsersFunctionality_TC_02.class);
	
	@Test
	public void addProvider() throws InterruptedException {

		login();
		log.info("Login successfull");

		selectIndex(LoginElements.facility_dropdown, 1);
		
		selectIndex(LoginElements.roles_dropdown, 1);

		click(login_button);
		log.info("Clicked on login button");

		hover(DomainValuesElements.settings);
		log.info("Hovered on settings option");
		
		hover(UserFunctionalityElements.security_btn);
		log.info("Hovered on security option");
		
		click(UserFunctionalityElements.users_btn);
		log.info("Clicked on users button");

		click(UserFunctionalityElements.add_btn);
		log.info("Clicked on add button");

		Displayed(UserFunctionalityElements.details_btn);

		Displayed(UserFunctionalityElements.work_hours_btn);

		if (waitE.until(ExpectedConditions.visibilityOfElementLocated(UserFunctionalityElements.work_hours_btn))
				.isEnabled()) {
			log.error("Work hours button is enabled");
			Assert.assertTrue(false);
		}

		checkElements(UserFunctionalityData.create_user.length, UserFunctionalityData.create_user);

		click(UserFunctionalityElements.save);
		log.info("Clicked on save button");

		checkElements(UserFunctionalityData.validations.length, UserFunctionalityData.validations);

		validation(UserFunctionalityElements.firstname, UserFunctionalityElements.f_validation);

		sendKeys(UserFunctionalityElements.firstname, "Alan");

		validation(UserFunctionalityElements.lastname, UserFunctionalityElements.f_validation);

		sendKeys(UserFunctionalityElements.lastname, "Walker");
		
		selectIndex(UserFunctionalityElements.dropdown, 2, UserFunctionalityData.dropdown_values);

		click(UserFunctionalityElements.select_user_role);
		log.info("Clicked on select user role button");

		Displayed(By.xpath("(//div[contains(.,'Select Role')])[15]"));

		checkElements(UserFunctionalityData.select_role.length, UserFunctionalityData.select_role);

		Thread.sleep(3000);
	}

}
