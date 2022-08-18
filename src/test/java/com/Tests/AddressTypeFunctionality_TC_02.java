package com.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Elements.AddressTypeElements;
import com.Elements.DomainValuesElements;
import com.Elements.LoginElements;
import com.Global.BaseClass;

public class AddressTypeFunctionality_TC_02 extends BaseClass {

	@Test(dependsOnGroups = { "AddressType" })
	public void addressTypeTest() {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		test = extent.createTest("AddressTypeFunctionlaity_TC_02").assignAuthor("DHANOOSH").assignDevice("Dell Laptop");
		extentTest.set(test);
		login();

		selectIndex(LoginElements.facility_dropdown, 1);
		selectIndex(LoginElements.roles_dropdown, 1);

		click(login_button);

		hover(DomainValuesElements.settings);

		click(DomainValuesElements.domain_values);
//		click(DomainValuesElements.addresstype_button);

		if (driver.findElement(AddressTypeElements.name).isDisplayed()
				&& driver.findElement(AddressTypeElements.status).isDisplayed()
				&& driver.findElement(AddressTypeElements.action).isDisplayed()) {
			List<WebElement> rowcount = driver
					.findElements(By.xpath("//*[@id='main']/div[2]/div[3]/div[2]/table/tbody/tr"));

			for (int i = 1; i <= rowcount.size(); i++) {
				List<WebElement> colcount = driver
						.findElements(By.xpath("//*[@id='main']/div[2]/div[3]/div[2]/table/tbody/tr[" + i + "]/td"));
				for (int j = 1; j <= colcount.size(); j++) {
					boolean value = driver
							.findElement(By.xpath(
									"//*[@id='main']/div[2]/div[3]/div[2]/table/tbody/tr[" + i + "]/td[" + j + "]"))
							.isDisplayed();
					Assert.assertTrue(value);
				}
			}
		}

	}

}
