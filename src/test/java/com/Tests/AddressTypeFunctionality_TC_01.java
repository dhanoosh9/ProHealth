package com.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Elements.AddressTypeElements;
import com.Elements.DomainValuesElements;
import com.Elements.LoginElements;
import com.ExpectedData.FrontDashBoardData;
import com.Global.BaseClass;

public class AddressTypeFunctionality_TC_01 extends BaseClass {
	String[] expected = null;

	@Test(groups = { "AddressType" })
	public void dashboardTest() throws InterruptedException {
		login();

		boolean login_validation = waitE
				.until(ExpectedConditions
						.visibilityOfElementLocated(By.xpath("//h3[contains(.,'Log in to your Account')]")))
				.isDisplayed();
		Assert.assertTrue(login_validation);

		if (driver.findElement(LoginElements.facility_dropdown).isDisplayed()) {
//			String expected[] = { "---select---", "Apollo", "cipla", "Dental", "Pharma" };
			selectIndex(LoginElements.facility_dropdown, 1);
		}

		if (driver.findElement(LoginElements.roles_dropdown).isDisplayed()) {
			String expected[] = { "---select---", "ADMIN" };
			selectIndex(LoginElements.roles_dropdown, 1, expected);
		}

		click(login_button);

		if (driver.findElement(By.xpath("//div[contains(@class,'breadCrumb')]")).isDisplayed()) {
			hover(DomainValuesElements.settings);

		}

		click(DomainValuesElements.domain_values);

		if (waitE.until(ExpectedConditions.visibilityOfElementLocated((DomainValuesElements.address_type)))
				.isDisplayed()
				&& waitE.until(ExpectedConditions.visibilityOfElementLocated((DomainValuesElements.add_button)))
						.isDisplayed()) {
			Assert.assertTrue(true);
		}

		int domain_values = driver.findElements(DomainValuesElements.allvalues).size();
		int values = 43;

		Assert.assertEquals(domain_values, values);
		checkTable(FrontDashBoardData.domain_values_xpath.length, FrontDashBoardData.domain_values_xpath,
				FrontDashBoardData.expected, FrontDashBoardData.name);
//		for (int j = 0; j < FrontDashBoardData.domain_values_xpath.length; j++) {
//			if (waitE
//					.until(ExpectedConditions
//							.visibilityOfElementLocated(By.xpath(FrontDashBoardData.domain_values_xpath[j])))
//					.isDisplayed()) {
//				String text = waitE
//						.until(ExpectedConditions
//								.visibilityOfElementLocated(By.xpath(FrontDashBoardData.domain_values_xpath[j])))
//						.getText();
//				if (text.equals(FrontDashBoardData.expected[j])) {
////					js = (JavascriptExecutor) driver;
////					js.executeScript("arguments[0].click();",
////							driver.findElement(By.xpath(FrontDashBoardData.domain_values_xpath[j])));
//					click(By.xpath(FrontDashBoardData.domain_values_xpath[j]));
//					js = (JavascriptExecutor) driver;
//					js.executeScript("window.scrollBy(0,50)", "");
//					boolean value = waitE
//							.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(FrontDashBoardData.name[j])))
//							.isDisplayed();
//					Assert.assertTrue(value);
//					if (driver.findElement(FrontOfficeDashBoardElements.alert_button).isDisplayed()) {
//						driver.findElement(FrontOfficeDashBoardElements.alert_button).click();
//					} else {
//						continue;
//					}
////					try {
////						driver.findElement(FrontOfficeDashBoardElements.alert_button).click();
////					} catch (Exception e) {
////
////					}
//
//				}
//
//			}
//		}

//		List<WebElement> options = driver.findElements(FrontOfficeDashBoardElements.allvalues);
//		for (int i = 1; i <= options.size(); i++) {
//
//			click(By.xpath("//*[@id='main']/div[2]/div[2]/ul/li[" + i + "]"));
//			boolean name = waitE
//					.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FrontDashBoardData.name[i])))
//					.isDisplayed();
//			Assert.assertTrue(name);
//			js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollBy(0,50)", "");
//			try {
//				driver.findElement(FrontOfficeDashBoardElements.alert_button).click();
//			} catch (Exception e) {
//
//			}
//		}
//		js.executeScript("window.scrollBy(0,-1000)", "");
//test
	}

}
