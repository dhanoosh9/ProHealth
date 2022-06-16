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
		log.info("All create user pop-up validations are passed");

		click(UserFunctionalityElements.save);
		log.info("Clicked on save button");

		checkElements(UserFunctionalityData.validations.length, UserFunctionalityData.validations);
		log.info("All validation messages are displayed");

		validation(UserFunctionalityElements.firstname, UserFunctionalityElements.f_validation);
		log.info("Firstname passed all validations");

		sendKeys(UserFunctionalityElements.firstname, "Alan");

		validation(UserFunctionalityElements.lastname, UserFunctionalityElements.f_validation);
		log.info("Lastname passed all valdations");

		sendKeys(UserFunctionalityElements.lastname, "Walker");
		
		selectIndex(UserFunctionalityElements.dropdown, 2, UserFunctionalityData.dropdown_values);

		click(UserFunctionalityElements.select_user_role);
		log.info("Clicked on select user role button");

		Displayed(By.xpath("(//div[contains(.,'Select Role')])[15]"));

		checkElements(UserFunctionalityData.select_role.length, UserFunctionalityData.select_role);
		log.info("All elements are displaying in select role pop-up");
		
		click(UserFunctionalityElements.provider_cbox);
		log.info("Selected provider checkbox");
		
		click(UserFunctionalityElements.ok_btn);
		log.info("Clicked on ok button");
		
		checkElements(UserFunctionalityData.provider_create_user.length,UserFunctionalityData.provider_create_user);
		log.info("All the elements in provider create user pop-up is displayed");
		
		sendKeys(UserFunctionalityElements.providerno,"qwe");
		
		
		
		Thread.sleep(3000);
	}

}
