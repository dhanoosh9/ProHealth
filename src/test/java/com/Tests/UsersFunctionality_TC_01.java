package com.Tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.Elements.DomainValuesElements;
import com.Elements.LoginElements;
import com.Elements.UserFunctionalityElements;
import com.ExpectedData.UserFunctionalityData;
import com.Global.BaseClass;

public class UsersFunctionality_TC_01 extends BaseClass {

	@Test
	public void viewPageofUsers() {
		login();

		selectIndex(LoginElements.facility_dropdown, 2);

		selectIndex(LoginElements.roles_dropdown, 1);

		click(login_button);

		hover(DomainValuesElements.settings);

		hover(UserFunctionalityElements.security_btn);

		click(UserFunctionalityElements.users_btn);

		Displayed(By.xpath("//div[@class='breadCrumb'][contains(.,'Users')]"));
		checkElements(UserFunctionalityData.users_column_names.length, UserFunctionalityData.users_column_names);
		Displayed(UserFunctionalityElements.add_btn);
	}

}
