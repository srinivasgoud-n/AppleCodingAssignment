package com.qa.apple.test.automation.base;

import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.apple.test.automation.exceptions.AppleException;

public class Helper extends BasePage {
	
	public static Duration EXPLICIT_TIMEOUT = Duration.ofSeconds(30);
	public static boolean flag = false;

	public static String getFileSeparator() {
		String OS = System.getProperty("os.name");
		String fs = "";
		System.out.println("Windows: " + OS.contains("Windows"));
		if (OS.contains("WINDOWS") || OS.contains("Windows")) {
			fs = "\\";
		} else if (OS.equalsIgnoreCase("MAC") || OS.equalsIgnoreCase("LINUX")) {
			fs = "/";
		}
		return fs;
	}

	public static WebElement getElement(By locator) throws AppleException {
		WebElement element = null;

		WebDriverWait wait = new WebDriverWait(_Driver, Duration.ofSeconds(15));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			element = _Driver.findElement(locator);
		} catch (TimeoutException toe) {
			throw new AppleException("Locator not available: " + locator);
		}

		return element;
	}
	
	public static List<WebElement> getElements(By locator) throws AppleException {
		List<WebElement> elements = null;

		WebDriverWait wait = new WebDriverWait(_Driver, Duration.ofSeconds(15));
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			elements = _Driver.findElements(locator);
		} catch (TimeoutException toe) {
			throw new AppleException("Locator not available: " + locator);
		}

		return elements;
	}

	public static void clickElement(By locator) throws AppleException {
		getElement(locator).click();
	}

	public static void enterText(By locator, String input) throws AppleException {

		getElement(locator).sendKeys(input);
	}

	public static String getElementText(By locator) throws AppleException {

		return getElement(locator).getText().trim();
	}
	
	public static String getAttributeValue(By locator, String attributeName) throws AppleException {

		return getElement(locator).getAttribute(attributeName).trim();
	}
	
	public static void waitForPagetoLoad() {
		try {
			// 0.5 second delay beyond which we could say slow performance
			Thread.sleep(500);
			WebDriverWait wait = new WebDriverWait(_Driver, EXPLICIT_TIMEOUT);
			flag = wait.until(jQueryLoad) && wait.until(jsLoad) && wait.until(xhrLoad);
			browserResponse();

		} catch (Exception e) {
			// System.out.println("wait for page to load exception");
			browserResponse();
		}
	}
	
	public static ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
		@Override
		public Boolean apply(WebDriver driver) {
			try {
				return (Boolean) ((JavascriptExecutor) driver)
						.executeScript("return window.jQuery != undefined || jQuery.active == 0");
			} catch (Exception e) {
				return true;
			}
		}
	};

	public static ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
		@Override
		public Boolean apply(WebDriver driver) {

			return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
					.equals("complete");
		}
	};
	public static ExpectedCondition<Boolean> xhrLoad = new ExpectedCondition<Boolean>() {
		@Override
		public Boolean apply(WebDriver driver) {
			return ((JavascriptExecutor) driver).executeScript("return XMLHttpRequest.DONE").toString().equals("4");
		}
	};

	static HttpURLConnection con = null;

	public static boolean browserResponse() {
		try {
			HttpURLConnection.setFollowRedirects(true);

			con = (HttpURLConnection) new URL(_Driver.getCurrentUrl()).openConnection();
			con.setRequestMethod("HEAD");

			return (con.getResponseCode() == HttpURLConnection.HTTP_OK);
		} catch (Exception e) {
			// e.printStackTrace();
			return false;
		}
	}

}
