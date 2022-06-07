package com.Utilities;

import java.io.IOException;
import java.util.Arrays;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenerClass extends ScreenShotMethod implements ITestListener {

	ExtentReports extent = new ExtentReports();

	ExtentTest test;

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
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test success");
		test = extent.createTest(result.getName());
		test.pass(result.getName());

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed - capture screenshot");
		String exception = Arrays.toString(result.getThrowable().getStackTrace());
		test = extent.createTest(result.getName());
		test.fail(result.getName());
		test.fail(exception);

		try {
			test.addScreenCaptureFromPath(capturescreenshot(driver));
			getScreenshot();

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped");
		test = extent.createTest(result.getName());
		test.skip(result.getName());
	}

//	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
//		System.out.println("Failed but has success?");
//	}
//
//	public void onTestFailedWithTimeout(ITestResult result) {
//		System.out.println("Test failed due to timeout - retry");
//	}

	public void onFinish(ITestContext context) {
		System.out.println("Ending...");
		extent.flush();
	}

}
