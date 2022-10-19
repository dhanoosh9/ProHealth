package com.Tests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Elements.DomainValuesElements;
import com.Elements.LoginElements;
import com.ExpectedData.FrontDashBoardData;
import com.Global.BaseClass;

public class Example extends BaseClass {

	private static Logger log = LogManager.getLogger(Example.class.getName());
	public static JavascriptExecutor js;

	public static void checkTable(int itr, String[] element, String[] expected, String[] element2) {
		for (int j = 0; j < itr; j++) {
			log.info("Checking for the element");
			if (waitE.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element[j]))).isDisplayed()) {
				String text = waitE.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element[j])))
						.getText();
				if (text.equals(expected[j])) {
					log.info("Clicking on the element");
					click(By.xpath(element[j]));
					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,50)", "");
					log.info("Validating the element");
					boolean value = waitE.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element2[j])))
							.isDisplayed();
					Assert.assertTrue(value);
					if (driver.findElement(DomainValuesElements.alert_button).isDisplayed()) {
						driver.findElement(DomainValuesElements.alert_button).click();
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
		log.info("Login Successfull");
		selectIndex(LoginElements.facility_dropdown, 1);
		selectIndex(LoginElements.roles_dropdown, 1);
		log.info("Clicking on login button");
		click(login_button);
		log.info("Clicked on login button");
		log.error("Not clicked");
		log.error("this is fatal");
		hover(DomainValuesElements.settings);

		click(DomainValuesElements.domain_values);
		log.info("Clicked on domain values button");
		checkTable(FrontDashBoardData.domain_values_xpath.length, FrontDashBoardData.domain_values_xpath,
				FrontDashBoardData.expected, FrontDashBoardData.name);
	}

}
