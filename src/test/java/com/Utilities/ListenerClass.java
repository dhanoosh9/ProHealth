package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Global.BaseClass;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerClass extends BaseClass implements ITestListener {
	ExtentReports extent = new ExtentReports();
	ExtentTest test;
	
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();

	public void onStart(ITestContext context) {
		System.out.println("Starting...");
		ExtentSparkReporter spark = new ExtentSparkReporter("Reports/index.html");
		spark.config().setDocumentTitle("My Report");
		spark.config().setReportName("ProHealth Report");
		spark.config().setTheme(Theme.DARK);
		extent.attachReporter(spark);

	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test is starting");
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test success");
		extentTest.get().pass(result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed - capture screenshot");
		extentTest.get().fail(result.getName());
		extentTest.get().fail(result.getThrowable());

		try {
			extentTest.get().addScreenCaptureFromPath(capturescreenshot(driver));

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped");
		extentTest.get().skip(result.getName());
	}

//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		System.out.println("Failed but has success?");
//	}
//
	public void onTestFailedWithTimeout(ITestResult result) {
		System.out.println("Test failed due to timeout - retry");
	}

	public void onFinish(ITestContext context) {
		System.out.println("Ending...");
		extent.flush();
	}

	public static String capturescreenshot(WebDriver driver) throws IOException {
		String timeStamp;
		timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		File srcfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File destinationfilepath = new File(".//ReportScreenShots//" + timeStamp + ".png");
		String absolutepathlocation = destinationfilepath.getAbsolutePath();

		FileUtils.copyFile(srcfile, destinationfilepath);
		return absolutepathlocation;
	}

}
