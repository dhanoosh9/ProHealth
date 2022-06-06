package com.Tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import org.testng.annotations.Test;

import com.Elements.FrontOfficeDashBoardElements;
import com.Elements.LoginElements;
import com.Global.BaseClass;

public class Example extends BaseClass {
	public void table(String Name, String Xpath) {
		String text = driver.findElement(By.xpath(Xpath)).getText();
		if (text.equals(Name)) {
			driver.findElement(By.xpath(Xpath)).click();
		}
	}

	@Test(priority = 0)
	public void test() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		login();

		selectIndex(driver.findElement(LoginElements.facility_dropdown), 1);

		selectIndex(driver.findElement(LoginElements.roles_dropdown), 1);

		click(login_button);

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(FrontOfficeDashBoardElements.settings)).perform();

		click(FrontOfficeDashBoardElements.domain_values);

	}

	@Test(priority = 1, dependsOnMethods = "test")
	public void test1(String name, String xpath) {
		table(name, xpath);
	}

}
