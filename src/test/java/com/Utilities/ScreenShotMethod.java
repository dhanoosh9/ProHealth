package com.Utilities;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.Global.BaseClass;

public class ScreenShotMethod extends BaseClass {

	public static void getScreenshot() throws IOException {
		Date currentdate = new Date();
		String screenshotfilename = currentdate.toString().replace(" ", "-").replace(":", "-");
		File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotFile, new File(".//ScreenShots//" + screenshotfilename + ".png"));
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
