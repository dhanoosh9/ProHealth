package com.Global;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait waitE;

	ReadConfig readconfig = new ReadConfig();
	String baseURL = readconfig.getApplicationURL();
	public String Practice = readconfig.getPractice();
	public String Username = readconfig.getUsername();
	public String Password = readconfig.getPassword();

	public static By practice = By.xpath("//input[contains(@name,'practice')]");
	public static By username = By.xpath("//input[@name='email']");
	public static By password = By.xpath("//input[@name='password']");
	public static By login_button = By.xpath("//button[contains(.,'LOGIN')]");

	@Parameters({ "browser" })
	@BeforeClass
	public void setup(String browserName) throws InterruptedException {
		if (browserName.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.navigate().to(baseURL);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
	}

	public void login() {
		sendKeys(practice, Practice);
		sendKeys(username, Username);
		sendKeys(password, Password);
		click(login_button);
	}

	public static String randomstring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		return generatedstring;
	}

	public static String randomNum() {
		String generatedstring2 = RandomStringUtils.randomNumeric(10);
		return generatedstring2;
	}

	// Click method with by element
	public static void click(By element) {
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (waitE.until(ExpectedConditions.elementToBeClickable((element))).isDisplayed()) {
			waitE.until(ExpectedConditions.elementToBeClickable(element)).click();
		} else {
			Assert.assertTrue(false);
		}
	}

	// Send keys method with by element
	public static void sendKeys(By element, String text) {
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (waitE.until(ExpectedConditions.presenceOfElementLocated((element))).isDisplayed()) {
			waitE.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
		} else {
			Assert.assertTrue(false);
		}
	}

	// Click method with web element element
	public static void click(WebElement element) {
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitE.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	// Send keys method with web element element
	public static void sendKeys(WebElement element, String text) {
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitE.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
	}

	// select by index with iteration
	public static void selectIndex(By element, int index, String[] expected) {
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (waitE.until(ExpectedConditions.presenceOfElementLocated(element)).isDisplayed()) {
			Select select = new Select(waitE.until(ExpectedConditions.presenceOfElementLocated(element)));
			List<WebElement> options = select.getOptions();
			for (WebElement ele : options) {
				boolean value = false;
				for (int i = 0; i < expected.length; i++) {
					if (ele.getText().equals(expected[i])) {
						System.out.println("Actual: " + ele.getText() + " matched " + "Expected: " + expected[i]);
						value = true;
					}
				}
				Assert.assertTrue(value);
			}
			select.selectByIndex(index);
		} else {
			Assert.assertTrue(false,"The element is not displayed");
		}

	}

	// select by index
	public static void selectIndex(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}

	// select by value
	public static void selectValue(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);

	}

	// select by value
	public static void selectVisibleText(WebElement element, String visibletext) {
		Select select = new Select(element);
		select.selectByValue(visibletext);
	}

	public static void hover(By element) {
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (waitE.until(ExpectedConditions.elementToBeClickable(element)).isDisplayed()) {
			Actions action = new Actions(driver);
			action.moveToElement(waitE.until(ExpectedConditions.presenceOfElementLocated(element))).perform();
		} else {
			Assert.assertTrue(false, "The element was not displayed");
		}

	}
	
//	public static void check(By element) {
//		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
//		if(waitE.until(ExpectedConditions.presenceOfElementLocated(element)).isDisplayed()) {
//			waitE.until(ExpectedConditions.presenceOfElementLocated(element)).getText();
//		}
//	}

	@AfterClass
	public void teardown() {
		driver.close();
		driver.quit();
	}

}
