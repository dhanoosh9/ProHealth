package com.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig {

	static Properties prop;

	public ReadConfig() {

		File src = new File("./PropertyLocation/Browser.properties");

		try {
			FileInputStream input = new FileInputStream(src);
			prop = new Properties();
			prop.load(input);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
			e.getStackTrace();
		}

	}

	public String getbrowserName() {
		String browserName = prop.getProperty("browser");
		return browserName;
	}

	public String getApplicationURL() {
		String url = prop.getProperty("baseURL");
		return url;
	}

	public String getPractice() {
		String practice = prop.getProperty("practice");
		return practice;
	}

	public String getUsername() {
		String username = prop.getProperty("username");
		return username;
	}

	public String getPassword() {
		String password = prop.getProperty("password");
		return password;
	}

}
