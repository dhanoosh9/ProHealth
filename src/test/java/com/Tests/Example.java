package com.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Elements.FrontOfficeDashBoardElements;
import com.Elements.LoginElements;
import com.ExpectedData.FrontDashBoardData;
import com.Global.BaseClass;

public class Example extends BaseClass {
	public static Logger log = LogManager.getLogger();
	public static JavascriptExecutor js;

	public static void checkTable(int itr, String[] element, String[] expected, String[] element2) {
		for (int j = 0; j < itr; j++) {
			if (waitE.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element[j]))).isDisplayed()) {
				String text = waitE.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element[j])))
						.getText();
				if (text.equals(expected[j])) {
					click(By.xpath(element[j]));
					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,50)", "");
					boolean value = waitE.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element2[j])))
							.isDisplayed();
					Assert.assertTrue(value);
					if (driver.findElement(FrontOfficeDashBoardElements.alert_button).isDisplayed()) {
						driver.findElement(FrontOfficeDashBoardElements.alert_button).click();
					} else {
						continue;
					}
				}
			}
		}
	}

	@Test
	public void test() {

		login();

		selectIndex(LoginElements.facility_dropdown, 1);
		selectIndex(LoginElements.roles_dropdown, 1);

		click(login_button);

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(FrontOfficeDashBoardElements.settings)).perform();

		click(FrontOfficeDashBoardElements.domain_values);

		checkTable(FrontDashBoardData.domain_values_xpath.length, FrontDashBoardData.domain_values_xpath,
				FrontDashBoardData.expected, FrontDashBoardData.name);
	}

}
