package com.Elements;

import org.openqa.selenium.By;

public class UserFunctionalityElements {

	public static By security_btn = By.xpath("(//div[contains(.,'Security')])[5]");
	public static By users_btn = By.xpath("//a[contains(.,'Users')]");
	public static By add_btn = By.xpath("//button[contains(.,'Add')]");
	public static By edit_btn = By.xpath("//*[@id=\"main\"]/div[2]/div[2]/table/tbody/tr[1]/td[8]/div/span[1]");
	public static By work_hours_btn = By.xpath("//button[contains(.,'Work Hours')]");
	public static By time_9to930 = By.xpath("//div[contains(@id,'183')]");
	public static By work_hours_rad_btn = By.xpath("(//input[@value='work hours'])[70]");
	public static By break_btn = By.xpath("(//input[@value='break'])[70]");
	public static By save_btn = By.xpath("(//button[contains(.,'Save')])[24]");
	public static By cancel_btn = By.xpath("(//button[contains(.,'Cancel')])[24]");
	public static By submit_btn = By.xpath("//button[contains(.,'Submit')]");
	public static By edit_user_close_btn = By.xpath("(//span[contains(.,'×')])[2]");

}
