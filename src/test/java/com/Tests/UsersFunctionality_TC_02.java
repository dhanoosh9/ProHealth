package com.Tests;

import java.time.Duration;

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
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
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
		Thread.sleep(1000);
		sendKeys(UserFunctionalityElements.firstname, "Ayan");

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

		checkElements(UserFunctionalityData.provider_create_user.length, UserFunctionalityData.provider_create_user);
		log.info("All the elements in provider create user pop-up is displayed");

		regval("//label[contains(.,'Provider No*')]", UserFunctionalityElements.providerno, "Provider No*", "abc @%",
				"044", "04");

		regval("//label[contains(.,'NPI*')]", UserFunctionalityElements.npi, "NPI*", "ab @*", "56637106581",
				"5663710658");

		regval("//label[contains(.,'Taxonomy*')]", UserFunctionalityElements.taxonomy, "Taxonomy*", "ab @*",
				"51935794510", "5193579451");

		regval("//label[contains(.,'Encounter Sign Pin*')]", UserFunctionalityElements.encountersignpin,
				"Encounter Sign Pin*", "de #$", "02345", "0234");
		Displayed(By.xpath("(//span[@class='showError'])[8]"));
		driver.findElement(UserFunctionalityElements.encountersignpin).clear();
		sendKeys(UserFunctionalityElements.encountersignpin, "1234");

		regval("//label[contains(.,'Confirm Sign Pin*')]", UserFunctionalityElements.confirmsignpin,
				"Confirm Sign Pin*", "gh ^&", "52145", "5214");
		Displayed(By.xpath("(//span[@class='showError'])[9]"));
		driver.findElement(UserFunctionalityElements.confirmsignpin).clear();
		sendKeys(UserFunctionalityElements.confirmsignpin, "1234");

		regval("//label[contains(.,'Home Phone*')]", UserFunctionalityElements.homephone, "Home Phone*", "ij *&",
				"(456) 598-52225", "(456) 598-5222");

		Displayed(By.xpath("//label[contains(.,'Email*')]"));
		sendKeys(UserFunctionalityElements.email, "ayan123");
		Displayed(By.xpath("//span[contains(.,'Invalid email type')]"));
		driver.findElement(UserFunctionalityElements.email).clear();
		sendKeys(UserFunctionalityElements.email, "ayan123@gmail.com");

		regval("//label[contains(.,'Mobile*')]", UserFunctionalityElements.mobile, "Mobile*", "kl @#", "(456) 588-888",
				"(456) 588-888");
		Displayed(By.xpath("//span[contains(.,'Invalid mobile Number')]"));
		driver.findElement(UserFunctionalityElements.mobile).clear();
		sendKeys(UserFunctionalityElements.mobile,"5248796354");
		
		click(UserFunctionalityElements.save);
		
//		Assert.assertEquals(waitE.until(ExpectedConditions.visibilityOfElementLocated(UserFunctionalityElements.work_hours_btn))
//				.isEnabled(), true);
		
		Thread.sleep(3000);
	}

	public void regval(String xpath, By element, String text1, String text2, String text3, String text4) {
		Assert.assertEquals(driver.findElement(By.xpath(xpath)).getText(), text1);
		sendKeys(element, text2);
		Assert.assertEquals(driver.findElement(element).getAttribute("value"), "");
		driver.findElement(element).clear();
		sendKeys(element, text3);
		Assert.assertEquals(driver.findElement(element).getAttribute("value"), text4);
	}

}
