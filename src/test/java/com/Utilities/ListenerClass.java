package com.Utilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends ScreenShotMethod implements ITestListener {

	public void onStart(ITestContext context) {
		System.out.println("Starting...");

	}

	public void onTestStart(ITestResult result) {
		System.out.println("Test is starting");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Test success");

	}

	public void onTestFailure(ITestResult result) {
		System.out.println("Test failed - capture screenshot");

		try {
			getScreenshot();

		} catch (IOException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("Test is skipped");
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
	}

}
