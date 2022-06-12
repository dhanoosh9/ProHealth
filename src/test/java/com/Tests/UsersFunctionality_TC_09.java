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

public class UsersFunctionality_TC_09 extends BaseClass {

	@Test
	public void editWorkHours_PF() throws InterruptedException {
		login();

		selectIndex(LoginElements.facility_dropdown, 1);

		selectIndex(LoginElements.roles_dropdown, 1);

		click(login_button);

		hover(DomainValuesElements.settings);

		hover(UserFunctionalityElements.security_btn);

		click(UserFunctionalityElements.users_btn);

		click(UserFunctionalityElements.edit_btn);

		click(UserFunctionalityElements.work_hours_btn);

		checkElements(UserFunctionalityData.days_xpath.length, UserFunctionalityData.days_xpath);

		checkElements(UserFunctionalityData.time_xpath.length, UserFunctionalityData.time_xpath);

		click(UserFunctionalityElements.submit_btn);

//		boolean value = waitE
//				.until(ExpectedConditions.visibilityOfElementLocated(
//						By.xpath("//div[@class='content'][contains(.,'Work Hours Updated Successfully')]")))
//				.isDisplayed();
//		Assert.assertTrue(value);
		click(UserFunctionalityElements.edit_user_close_btn);
		
		
		
		Thread.sleep(3000);

	}

}
