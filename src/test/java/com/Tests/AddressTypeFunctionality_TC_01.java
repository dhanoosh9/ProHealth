package com.Tests;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Elements.AddressTypeElements;
import com.Elements.FrontOfficeDashBoardElements;
import com.Elements.LoginElements;
import com.ExpectedData.FrontDashBoardData;
import com.Global.BaseClass;

public class AddressTypeFunctionality_TC_01 extends BaseClass {
	String[] expected = null;
	JavascriptExecutor js;

	@Test(groups = { "AddressType" })
	public void dashboardTest() throws InterruptedException {
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		login();

		boolean login_validation = waitE
				.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//h3[contains(.,'Log in to your Account')]")))
				.isDisplayed();
		Assert.assertTrue(login_validation);

		if (driver.findElement(LoginElements.facility_dropdown).isDisplayed()) {
			String expected[] = { "---select---", "Apollo", "cipla", "Dental", "Pharma" };
			selectIndex(LoginElements.facility_dropdown, 1, expected);
		}

		if (driver.findElement(LoginElements.roles_dropdown).isDisplayed()) {
			String expected[] = { "---select---", "ADMIN" };
			selectIndex(LoginElements.roles_dropdown, 1, expected);
		}

		click(login_button);

		if (driver.findElement(By.xpath("//div[contains(@class,'breadCrumb')]")).isDisplayed()) {
			hover(FrontOfficeDashBoardElements.settings);

		}

		click(FrontOfficeDashBoardElements.domain_values);

		if (waitE.until(ExpectedConditions.presenceOfElementLocated((FrontOfficeDashBoardElements.address_type)))
				.isDisplayed()
				&& waitE.until(ExpectedConditions.presenceOfElementLocated((FrontOfficeDashBoardElements.add_button)))
						.isDisplayed()) {
			Assert.assertTrue(true);
		}

		int domain_values = driver.findElements(FrontOfficeDashBoardElements.allvalues).size();
		int values = 43;

		Assert.assertEquals(domain_values, values);

		List<WebElement> options = driver.findElements(FrontOfficeDashBoardElements.allvalues);

		for (int j = 1; j <= options.size(); j++) {
			if (waitE
					.until(ExpectedConditions
							.presenceOfElementLocated(By.xpath(FrontDashBoardData.domain_values_xpath[j])))
					.isDisplayed()) {
				String text = waitE
						.until(ExpectedConditions
								.presenceOfElementLocated(By.xpath(FrontDashBoardData.domain_values_xpath[j])))
						.getText();
				if (text.equals(FrontDashBoardData.expected[j])) {
//					waitE.until(ExpectedConditions
//							.elementToBeClickable(By.xpath(FrontDashBoardData.domain_values_xpath[j]))).click();
					click(By.xpath(FrontDashBoardData.domain_values_xpath[j]));
					boolean value = waitE
							.until(ExpectedConditions.presenceOfElementLocated(By.xpath(FrontDashBoardData.name[j])))
							.isDisplayed();
					Assert.assertTrue(value);
					try {
						driver.findElement(FrontOfficeDashBoardElements.alert_button).click();
					} catch (Exception e) {

					}

				}

			}
		}

//		for (int i = 1; i <= options.size(); i++) {
//			click(By.xpath("//*[@id='main']/div[2]/div[2]/ul/li[" + i + "]"));
//			boolean name = driver.findElement(AddressTypeElements.name).isDisplayed();
//			Assert.assertTrue(name);
//			js = (JavascriptExecutor) driver;
//			js.executeScript("window.scrollBy(0,50)", "");
//			try {
//				driver.findElement(FrontOfficeDashBoardElements.alert_button).click();
//			} catch (Exception e) {
//
//			}
//		}
		js.executeScript("window.scrollBy(0,-1000)", "");

	}

}
