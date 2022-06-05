package com.Tests;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.Elements.FrontOfficeDashBoardElements;
import com.Elements.LoginElements;
import com.Global.BaseClass;

public class AddressTypeFunctionality_TC_01 extends BaseClass {
	String[] expected = null;
	JavascriptExecutor js;

	@Test(groups = { "AddressType" })
	public void dashboardTest() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		login();

		if (waitE
				.until(ExpectedConditions
						.presenceOfElementLocated(By.xpath("//h3[contains(.,'Log in to your Account')]")))
				.isDisplayed()) {
			Assert.assertTrue(true);
		}

		if (driver.findElement(LoginElements.facility_dropdown).isDisplayed()) {
			Assert.assertTrue(true);
			String expected[] = { "---select---", "Apollo", "cipla", "Dental", "Pharma" };
			selectIndex(driver.findElement(LoginElements.facility_dropdown), 1, expected);
		}

		if (driver.findElement(LoginElements.roles_dropdown).isDisplayed()) {
			Assert.assertTrue(true);
			String expected[] = { "---select---", "ADMIN" };
			selectIndex(driver.findElement(LoginElements.roles_dropdown), 1, expected);
		}

		click(login_button);

		if (driver.findElement(By.xpath("//div[contains(@class,'breadCrumb')]")).isDisplayed()) {
			Assert.assertTrue(true);
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(FrontOfficeDashBoardElements.settings)).perform();
		}

		click(FrontOfficeDashBoardElements.domain_values);

		if (driver.findElement(FrontOfficeDashBoardElements.address_type).isDisplayed()
				&& driver.findElement(FrontOfficeDashBoardElements.add_button).isDisplayed()) {
			Assert.assertTrue(true);
		}

		List<WebElement> options = driver.findElements(FrontOfficeDashBoardElements.allvalues);

		for (int i = 1; i <= options.size(); i++) {
			driver.findElement(By.xpath("//*[@id='main']/div[2]/div[2]/ul/li[" + i + "]")).click();
			js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,50)", "");
			try {
				driver.findElement(FrontOfficeDashBoardElements.alert_button).click();
			} catch (Exception e) {

			}
		}
	}

}
