package coindcxtest.coindcxtest.helper;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SeleniumHelper {

	private WebDriver driver ;
	private int hardWait;

	public SeleniumHelper(WebDriver driver) {
		this.driver = driver;
		String env = System.getProperty("ENV");
	}

	public static SeleniumHelper getHelper(WebDriver driver) {
		SeleniumHelper helper = new SeleniumHelper(driver);
		return helper;
	}

	/**
	 * @param locator
	 * @return
	 */
	public WebElement getElement(By locator) {
		WebElement elem = null;
		try {
			elem = driver.findElement(locator);
		} catch (NoSuchElementException nsee) {
			throw nsee;
		}
		return elem;
	}

	/**
	 * Check for element is present based on locator If the element is present
	 * return the web element otherwise null
	 *
	 * @param locator
	 * @return WebElement or null
	 */

	public WebElement getElementWithNull(By locator) {
		WebElement elem = null;
		try {
			elem = driver.findElement(locator);
		} catch (NoSuchElementException nsee) {
			// ignore
		}
		return elem;
	}

	/**
	 * @param locator
	 * @return
	 */
	public boolean isElementPresentQuick(By locator) {
		boolean flag = !driver.findElements(locator).isEmpty();
		return flag;
	}

	/**
	 * @param element
	 * @param text
	 */
	public void enterTextInTextField(WebElement element, String text) {
		try {
			element.click();
			element.clear();
			element.sendKeys(text);
		} catch (ElementClickInterceptedException e) {
		}
	}

	/**
	 * @param element
	 */
	public void clearTextField(WebElement element) {
		element.click();
		element.clear();
	}

	/**
	 * @param element
	 */
	public void moveToElement(WebElement element) {
		Actions actions = new Actions(driver);
		actions.moveToElement(element);
		actions.perform();
		actions.build();
	}

	/**
	 * enter value in input box (by typing each char)
	 *
	 * @param element
	 * @param value
	 */
	public void enterTextInTextFieldCharWise(WebElement element, String value) {
		element.clear();
		for (int i = 0; i < value.length(); i++) {
			char charValue = value.charAt(i);
			element.sendKeys("" + charValue);
		}
	}

	/**
	 * getAttributeValuesFromListOfElement
	 *
	 * @param elements
	 * @param attributeName
	 * @return
	 */
	public List<String> getAttributeValuesFromListOfElements(List<WebElement> elements, String attributeName) {
		List<String> attributeValues = new ArrayList<String>();
		for (WebElement webElement : elements) {
			attributeValues.add(webElement.getAttribute(attributeName));
		}
		return attributeValues;
	}

	/**
	 *
	 * @param locator
	 * @return
	 */
	public List<WebElement> getElements(By locator) {
		List<WebElement> elems = driver.findElements(locator);
		if (elems.isEmpty()) {
		}
		return elems;
	}

	/**
	 * Method to get the text of Web Element
	 *
	 * @param element
	 * @return
	 */
	public String getText(WebElement element) {
		return element.getText();
	}

	/**
	 * Method to get text from List of Web Elements
	 *
	 * @param elements
	 * @return
	 */
	public List<String> getText(List<WebElement> elements) {
		List<String> textList = new ArrayList<String>();
		for (WebElement ele : elements) {
			textList.add(getText(ele));
		}
		return textList;
	}

	/**
	 * Method to get the attribute value for the WebElement
	 *
	 * @param element
	 * @param attribute
	 * @return
	 */
	public String getAttributeValue(WebElement element, String attribute) {
		String value = element.getAttribute(attribute);
		return value;
	}

	/**
	 * create dynamic xpath and return web-element
	 *
	 * @param xPath
	 * @param dynamicValues
	 * @return
	 */
	public WebElement returnElementWithDynamicXpath(String xPath, String dynamicValues) {
		Integer count = 1;
		for (String value : dynamicValues.split(";")) {
			xPath = xPath.replace("{PARAM" + count.toString() + "}", value);
			count++;
		}

		return getElement(By.xpath(xPath));
	}

	/**
	 * hit keyboard enter
	 *
	 * @param element
	 */
	public void clickKeyBoardEnter(WebElement element) {
		try {
			element.sendKeys(Keys.TAB);
		} catch (ElementClickInterceptedException e) {
		}
	}

	public void clickElement(WebElement element) {
		try {
			element.click();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
