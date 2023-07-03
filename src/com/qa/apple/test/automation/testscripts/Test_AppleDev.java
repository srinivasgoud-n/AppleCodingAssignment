package com.qa.apple.test.automation.testscripts;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.apple.test.automation.base.BasePage;
import com.qa.apple.test.automation.exceptions.AppleException;
import com.qa.apple.test.automation.pages.AppleCatalogPage;

public class Test_AppleDev extends BasePage {

	AppleCatalogPage catalogPage = null;

	public Test_AppleDev() {
		catalogPage = new AppleCatalogPage();

	}

	@Test(priority = 1)
	public void tc_01() {

		Assert.assertEquals(_Driver.getCurrentUrl(),
				"https://developer.apple.com/documentation/applemusicapi/search_for_catalog_resources");
	}

	@Test(priority = 2)
	public void tc_02() throws AppleException {

		Assert.assertEquals(AppleCatalogPage.getAppleCatalogHeaderText(), "Search for Catalog Resources");

	}

	@Test(priority = 3)
	public void tc_03() throws AppleException {

		Assert.assertEquals(AppleCatalogPage.getURLlLink(), "URL");
		Assert.assertEquals(AppleCatalogPage.getURLAttributeValue(),
				"https://developer.apple.com/documentation/applemusicapi/search_for_catalog_resources#url");

		Assert.assertEquals(AppleCatalogPage.getTokenMethodName(), "GET");

		Assert.assertEquals(AppleCatalogPage.getTokenBaseUrl(), "https://api.music.apple.com");

		Assert.assertEquals(AppleCatalogPage.getTokenParamater(), "{storefront}");

		List<WebElement> listOfTokenPath = AppleCatalogPage.getListOfTokenPath();

		Assert.assertEquals(listOfTokenPath.get(0).getText(), "/v1/catalog/");

		Assert.assertEquals(listOfTokenPath.get(1).getText(), "/search");
	}

	@Test(priority = 4)
	public void tc_04() throws AppleException {

		List<WebElement> listOfParameterLabels = AppleCatalogPage.getListOfParameterLabels();

		Assert.assertEquals(listOfParameterLabels.get(0).getText(), "storefront");

		Assert.assertEquals(listOfParameterLabels.get(1).getText(), "term");

		Assert.assertEquals(listOfParameterLabels.get(2).getText(), "l");

		Assert.assertEquals(listOfParameterLabels.get(3).getText(), "limit");

		Assert.assertEquals(listOfParameterLabels.get(4).getText(), "offset");

		Assert.assertEquals(listOfParameterLabels.get(5).getText(), "types");

		Assert.assertEquals(listOfParameterLabels.get(6).getText(), "with");

		List<WebElement> listOfParameterContent = AppleCatalogPage.getListOfParameterContent();

		Assert.assertEquals(listOfParameterContent.get(0).getText(),
				"An iTunes Store territory, specified by an ISO 3166 alpha-2 country code. The possible values are the id attributes of Storefront objects.");

		Assert.assertEquals(listOfParameterContent.get(1).getText(),
				"The entered text for the search with ‘+’ characters between each word, to replace spaces (for example term=james+br).");

		Assert.assertEquals(listOfParameterContent.get(2).getText(),
				"The localization to use, specified by a language tag. The possible values are in the supportedLanguageTags array belonging to the Storefront object specified by storefront. Otherwise, the default is defaultLanguageTag in Storefront.");

		Assert.assertEquals(listOfParameterContent.get(3).getText(),
				"The number of objects or number of objects in the specified relationship returned.");

		Assert.assertEquals(listOfParameterContent.get(4).getText(), "The next page or group of objects to fetch.");

		Assert.assertEquals(listOfParameterContent.get(5).getText(),
				"The list of the types of resources to include in the results.");

		Assert.assertEquals(listOfParameterContent.get(6).getText(), "A list of modifications to apply to the request.");

		Assert.assertEquals(listOfParameterContent.get(7).getText(), "The request was successful.");

		Assert.assertEquals(listOfParameterContent.get(8).getText(), "A response indicating an incorrect Authorization header.");

		Assert.assertEquals(listOfParameterContent.get(9).getText(), "A response indicating an error occurred on the server.");

	}

	@Test(priority = 5)
	public void tc_05() throws AppleException {

		Assert.assertEquals(AppleCatalogPage.getResponsecodesHeader(), "Response Codes");

		List<WebElement> listOfResponseCodes = AppleCatalogPage.getListOfResponseCodes();

		Assert.assertEquals(listOfResponseCodes.get(0).getText(), "200");

		Assert.assertEquals(listOfResponseCodes.get(1).getText(), "401");

		Assert.assertEquals(listOfResponseCodes.get(2).getText(), "500");
	}

	@Test(priority = 6)
	public void tc_06() throws AppleException {

		Assert.assertEquals(AppleCatalogPage.getDiscussionHeader(), "Discussion");

		Assert.assertEquals(AppleCatalogPage.getDiscussionDescription(),
				"If successful, the HTTP status code is 200 (OK) and the results contains a map of search results. If unsuccessful, the HTTP status code indicates the error and the details are in the errors array. For more information, see Handling Requests and Responses.");

	}
	
	@Test(priority = 7)
	public void tc_07() throws AppleException {
		
		Assert.assertEquals(AppleCatalogPage.getSeeAlsoHeader(), "See Also");
		
		List<WebElement> catalogResourceLinks = AppleCatalogPage.getCatalogResourceLinks();
		
		Assert.assertEquals(catalogResourceLinks.get(0).getText(), "Fetch the search term results for a hint.");

		Assert.assertEquals(catalogResourceLinks.get(1).getText(), "Fetch the search suggestions for a provided term input.");
	}

}
