package com.qa.apple.test.automation.base;

import java.net.UnknownHostException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BasePage {

	protected static final String fs = Helper.getFileSeparator();
	protected static String CURRENTDIR = System.getProperty("user.dir");
	protected static WebDriver _Driver = null;

	@BeforeMethod
	public void setup() throws Exception {

		System.setProperty("webdriver.chrome.driver", CURRENTDIR + fs + "ExecutableDrivers" + fs + "chromedriver.exe");
		_Driver = new ChromeDriver();
		_Driver.manage().window().maximize();
		_Driver.get("https://developer.apple.com/documentation/applemusicapi/search_for_catalog_resources");

	}

	@AfterMethod
	public void tearDown(ITestResult iTestResult, ITestContext context) throws UnknownHostException, Exception {
		String s[] = iTestResult.getName().split(" ");

		System.out.println(s[0]);

		if (iTestResult.getStatus() == ITestResult.SUCCESS) {

			System.out.println("####Test Case PASSED:" + s[0]);
		} else if (iTestResult.getStatus() == ITestResult.FAILURE) {
			System.out.println("####Test Case FAILED:" + s[0]);
		}

		else {
			System.out.println("####Test Case SKIPPED:" + s[0]);

		}

		_Driver.close();
		_Driver.quit();

	}

}
