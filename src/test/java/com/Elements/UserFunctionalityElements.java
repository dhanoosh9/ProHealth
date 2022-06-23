package com.Elements;

import org.openqa.selenium.By;

public class UserFunctionalityElements {

	public static By security_btn = By.xpath("(//div[contains(.,'Security')])[5]");
	public static By users_btn = By.xpath("//a[contains(.,'Users')]");
	public static By add_btn = By.xpath("//button[contains(.,'Add')]");
	public static By details_btn = By.xpath("//button[contains(.,'Details')]");
	public static By dropdown = By.xpath("//select[@class='select']");
	public static By firstname = By.name("firstName");
	public static By lastname = By.name("lastName");
	public static By select_user_role = By.xpath("//button[contains(.,'Select User Role')]");
	public static By f_validation  = By.xpath("//span[contains(.,'Only alphabets are allowed')]");
	public static By required = By.xpath("(//span[contains(.,'Required')])");
	public static By provider_cbox = By.xpath("//input[contains(@value,'Provider')]");
	public static By ok_btn = By.xpath("//button[contains(.,'Ok')]");
	public static By providerno = By.xpath("//input[@name='providerNo']");
	public static By npi = By.xpath("//input[@name='npi']");
	public static By taxonomy = By.xpath("//input[@name='taxonomy']");
	public static By encountersignpin = By.xpath("//input[@name='encounterSignPin']");
	public static By confirmsignpin = By.xpath("//input[@name='confirmSignPin']");
	public static By homephone = By.xpath("//input[@name='homePhone']");
	public static By email = By.xpath("//input[@name='email']");
	public static By mobile = By.xpath("//input[@name='mobilePhone']");
	public static By work_hours_btn = By.xpath("//button[contains(.,'Work Hours')]");
	public static By save = By.xpath("(//button[contains(.,'Save')])[1]");
	
	
	public static By edit_btn = By.xpath("//*[@id=\"main\"]/div[2]/div[2]/table/tbody/tr[1]/td[8]/div/span[1]");
	public static By time_9to930 = By.xpath("//div[contains(@id,'183')]");
	public static By work_hours_rad_btn = By.xpath("(//input[@value='work hours'])[70]");
	public static By break_btn = By.xpath("(//input[@value='break'])[70]");
	public static By save_btn = By.xpath("(//button[contains(.,'Save')])[24]");
	public static By cancel_btn = By.xpath("(//button[contains(.,'Cancel')])[24]");
	public static By submit_btn = By.xpath("//button[contains(.,'Submit')]");
	public static By edit_user_close_btn = By.xpath("(//span[contains(.,'×')])[2]");

}
