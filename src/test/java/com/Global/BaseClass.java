package com.Global;

import java.time.Duration;
import java.util.List;

import org.apache.commons.lang3.RandomStringUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.Elements.DomainValuesElements;
import com.Utilities.ReadConfig;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static WebDriverWait waitE;
	public static Wait<WebDriver> wait;
	public static JavascriptExecutor js;

	ReadConfig readconfig = new ReadConfig();
	public String browser = System.getProperty("browser") != null ? System.getProperty("browser")
			: readconfig.getbrowserName();
	public String baseURL = readconfig.getApplicationURL();
	public String Practice = readconfig.getPractice();
	public String Username = readconfig.getUsername();
	public String Password = readconfig.getPassword();

	public static By practice = By.xpath("//input[contains(@name,'practice')]");
	public static By username = By.xpath("//input[@name='email']");
	public static By password = By.xpath("//input[@name='password']");
	public static By login_button = By.xpath("//button[contains(.,'LOGIN')]");
	public static By admin_btn = By.xpath("//div[@title='User Info']");
	public static By logout_btn = By.xpath("//a[contains(.,'Logout')]");

//	private static Logger log = LogManager.getLogger(BaseClass.class);

	public static ExtentReports extent = new ExtentReports();
	public static ExtentTest test;

	public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

//	@Parameters({ "browser" })
	@BeforeClass
	public void setup() throws InterruptedException {
		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}
//		test.info("Maximizing the window");
		driver.manage().window().maximize();
//		test.info("Selected browser is: " + browserName);
//		test.info("Navigating to the URL");
		driver.navigate().to(baseURL);
		driver.manage().deleteAllCookies();
	}

	@AfterClass
	public void teardown() {
		click(admin_btn);
		click(logout_btn);
		extentTest.get().info("Logged out successfully");

		driver.quit();
	}

	// Method for login
	public void login() {
		sendKeys(practice, Practice);
		extentTest.get().info("Entered practice type");

		sendKeys(username, Username);
		extentTest.get().info("Entered the username");

		sendKeys(password, Password);
		extentTest.get().info("Entered the password");

		click(login_button);
		extentTest.get().info("Clicked on login button");
	}

//	public void logins(String Practice, String Username, String Password) {
//		driver.findElement(practice).sendKeys(Practice);
//		driver.findElement(username).sendKeys(Username);
//		driver.findElement(password).sendKeys(Password);
//		sendKeys(practice, Practice);
//
//		sendKeys(username, Username);
//
//		sendKeys(password, Password);
//
//		click(login_button);
//	}

	// Creates a random string
	public static String randomstring() {
		String generatedstring = RandomStringUtils.randomAlphabetic(8);
		extentTest.get().info("Random string is generated: " + generatedstring);
		return generatedstring;
	}

	// Creates a random number
	public static String randomNum() {
		String generatedstring2 = RandomStringUtils.randomNumeric(10);
		extentTest.get().info("Random number is generated: " + generatedstring2);
		return generatedstring2;
	}

	// Click method with by element
	public static void click(By element) {
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		extentTest.get().info("Verifying the given click element is displayed or not");
		if (waitE.until(ExpectedConditions.visibilityOfElementLocated((element))).isDisplayed()) {
			extentTest.get()
					.info("The button "
							+ waitE.until(ExpectedConditions.visibilityOfElementLocated((element))).getText()
							+ " is displayed");
			extentTest.get().info("Clicking on the button: "
					+ waitE.until(ExpectedConditions.elementToBeClickable(element)).getText());
			waitE.until(ExpectedConditions.elementToBeClickable(element)).click();

		} else {
			extentTest.get().fail("The element is not displayed");
			Assert.assertTrue(false);
		}
	}

	// Send keys method with by element
	public static void sendKeys(By element, String text) {
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		extentTest.get().info("Verifying the given sendkeys element is displayed or not");
		if (waitE.until(ExpectedConditions.visibilityOfElementLocated((element))).isDisplayed()) {
			extentTest.get().info("The sendkeys element is displayed");
			waitE.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
			extentTest.get().info("Entered " + text + " in the box");
		} else {
			extentTest.get().fail("The given sendkeys element is not displayed");
			Assert.assertTrue(false);
		}
	}

	// select by index with iteration
	public static void selectIndex(By element, int index, String[] expected) {
//			waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(3))
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
		if (wait.until(ExpectedConditions.presenceOfElementLocated(element)).isDisplayed()) {
			Select select = new Select(wait.until(ExpectedConditions.presenceOfElementLocated(element)));
			List<WebElement> options = select.getOptions();
			for (WebElement ele : options) {
				boolean value = false;
				for (int i = 0; i < expected.length; i++) {
					if (ele.getText().equals(expected[i])) {
						extentTest.get().info("Actual: " + ele.getText() + " matched " + "Expected: " + expected[i]);
						value = true;
					}
				}

				Assert.assertTrue(value);
			}
			extentTest.get().info("selecting the value: " + index);
			select.selectByIndex(index);
			boolean value = select.getFirstSelectedOption().isDisplayed();
			Assert.assertTrue(value);
		} else {
			extentTest.get().fail("The given select element is not displayed");
			Assert.assertTrue(false, "The element is not displayed");
		}

	}

	// Hover
	public static void hover(By element) {
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		extentTest.get().info("Validating that the element is displayed");
		if (waitE.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed()) {
			extentTest.get().info("Hovering on the element: "
					+ waitE.until(ExpectedConditions.visibilityOfElementLocated(element)).getText());
			Actions action = new Actions(driver);
			action.moveToElement(waitE.until(ExpectedConditions.presenceOfElementLocated(element))).perform();
		} else {
			extentTest.get().fail("The given hover element is not displayed");
			Assert.assertTrue(false, "The element is not displayed");
		}
	}

	// Method to check all the domain values are displayed
	public static void checkTable(int itr, String[] element, String[] expected, String[] element2) {
		for (int j = 0; j < itr; j++) {
			if (waitE.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element[j]))).isDisplayed()) {
				String text = waitE.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element[j]))).getText();
				if (text.equals(expected[j])) {
					click(By.xpath(element[j]));
					js = (JavascriptExecutor) driver;
					js.executeScript("window.scrollBy(0,50)", "");
					boolean value = waitE.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element2[j])))
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

	// Method to check whether the elements are displayed
	public static void checkElements(int itr, String[] elements) {
		extentTest.get().info("Verifying that all elements are displayed");
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		for (int i = 0; i < itr; i++) {
			boolean value = waitE.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(elements[i])))
					.isDisplayed();
			Assert.assertTrue(value);
		}
		extentTest.get().info("All the elements are displayed");
	}

	// Method to check whether the element is displayed
	public static void Displayed(By element) {
		extentTest.get().info("Verifying the element is displayed");
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		boolean value = waitE.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
		Assert.assertTrue(value);
		extentTest.get().info("The given element is displayed");
	}

	// Validation method for send keys elements
	public static void validation(By element, By validation) {
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		String[] text = { "123", " ", "@$", "dha123" };
		for (int i = 0; i < 4; i++) {
			sendKeys(element, text[i]);
			boolean value = waitE.until(ExpectedConditions.visibilityOfElementLocated(validation)).isDisplayed();
			Assert.assertTrue(value);
//			waitE.until(ExpectedConditions.visibilityOfElementLocated(element)).clear();
			driver.findElement(element).clear();
		}

	}

	// Click method with web element element
	public static void click(WebElement element) {
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		extentTest.get().info("Clicked on the element: " + element.getText());
		waitE.until(ExpectedConditions.elementToBeClickable(element)).click();
	}

	// Send keys method with web element element
	public static void sendKeys(WebElement element, String text) {
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitE.until(ExpectedConditions.elementToBeClickable(element)).sendKeys(text);
	}

	// select by index
	public static void selectIndex(By element, int index) {
		waitE = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (waitE.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed()) {
			Select select = new Select(waitE.until(ExpectedConditions.presenceOfElementLocated(element)));
			select.selectByIndex(index);
		}
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

}
