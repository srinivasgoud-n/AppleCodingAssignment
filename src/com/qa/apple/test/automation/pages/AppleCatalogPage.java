package com.qa.apple.test.automation.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.qa.apple.test.automation.base.BasePage;
import com.qa.apple.test.automation.base.Helper;
import com.qa.apple.test.automation.exceptions.AppleException;

public class AppleCatalogPage extends BasePage {

	public static By appleCatalogHeader = By.xpath("//span[text()='Search for Catalog Resources']");

	public static By urlLink = By.cssSelector("#url a");

	public static By tokenMethodName = By.cssSelector(".source code .token-method");

	public static By tokenBaseUrl = By.cssSelector(".source code .token-baseURL");

	public static By tokenPath = By.cssSelector(".source code .token-path");

	public static By tokenParamater = By.cssSelector(".source code .token-parameter");

	public static By pathParameterHeader = By.cssSelector("#path-parameters a");

	public static By parameterLabels = By.cssSelector(".parameters-table .param-name code");

	public static By parameterContent = By.cssSelector(".parameters-table .param-content p");

	public static By responsecodesHeader = By.cssSelector("#response-codes a");

	public static By responseCodes = By.cssSelector(".parameters-table .response-name");
	
	public static By discussionHeader = By.cssSelector("#discussion a");
	
	public static By discussionDescription = By.xpath("//p[contains(text(),'If successful')]");
	
	public static By seeAlsoHeader = By.cssSelector("#see-also a");
	
	public static By catalogResourceLinks = By.cssSelector(".contenttable-section .link-block .content");

	public static String getAppleCatalogHeaderText() throws AppleException {
		return Helper.getElementText(appleCatalogHeader);
	}

	public static String getURLlLink() throws AppleException {
		return Helper.getElementText(urlLink);
	}

	public static String getURLAttributeValue() throws AppleException {
		return Helper.getAttributeValue(urlLink, "href");
	}

	public static String getTokenMethodName() throws AppleException {
		return Helper.getElementText(tokenMethodName);
	}

	public static String getTokenBaseUrl() throws AppleException {
		return Helper.getElementText(tokenBaseUrl);
	}

	public static List<WebElement> getListOfTokenPath() throws AppleException {
		return Helper.getElements(tokenPath);
	}

	public static String getTokenParamater() throws AppleException {
		return Helper.getElementText(tokenParamater);
	}

	public static List<WebElement> getListOfParameterLabels() throws AppleException {
		return Helper.getElements(parameterLabels);
	}

	public static List<WebElement> getListOfParameterContent() throws AppleException {
		return Helper.getElements(parameterContent);
	}

	public static String getResponsecodesHeader() throws AppleException {
		return Helper.getElementText(responsecodesHeader);
	}
	
	public static List<WebElement> getListOfResponseCodes() throws AppleException {
		return Helper.getElements(responseCodes);
	}
	
	public static String getDiscussionHeader() throws AppleException
	{
		return Helper.getElementText(discussionHeader);
	}
	
	public static String getDiscussionDescription() throws AppleException
	{
		return Helper.getElementText(discussionDescription);
	}
	
	public static String getSeeAlsoHeader()throws AppleException
	{
		return Helper.getElementText(seeAlsoHeader);
	}
	
	public static List<WebElement> getCatalogResourceLinks() throws AppleException {
		return Helper.getElements(catalogResourceLinks);
	}
	

}
