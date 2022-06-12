package com.Elements;

import org.openqa.selenium.By;

public class DomainValuesElements {

	public static By settings = By.xpath("//img[@src='./images/settings.png']");
	public static By domain_values = By.xpath("//a[contains(.,'Domain Values')]");
	public static By addresstype_button = By.xpath("//button[contains(.,'Address Type')]");
	public static By allvalues = By.xpath("//*[@id=\"main\"]/div[2]/div[2]/ul/li");
	public static By alert_button = By.xpath("(//span[@class='close-icon'])[2]");
	public static By address_type = By.xpath("(//div[contains(.,'Address Type')])[9]");
	public static By add_button = By.xpath("(//button[contains(.,'Add')])[2]");
}
