package coindcxtest.coindcxtest.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

public class WebAssertHelper {

	private SoftAssert softAssert;

	public WebAssertHelper(SoftAssert softAssert) {
		this.softAssert = softAssert;
	}

	/**
	 * Creates and returns web assert helper object using given soft assert
	 *
	 * @param softAssert
	 * @return WebAssertHelper
	 */
	public static WebAssertHelper getHelper(SoftAssert softAssert) {
		WebAssertHelper helper = new WebAssertHelper(softAssert);
		return helper;
	}

	/**
	 * assertElementInList
	 *
	 * @author ankit
	 * @param expectedValue
	 * @param webElems
	 */
	public void assertValueInElements(String expectedValue, List<WebElement> webElems) {
		Set<String> allTexts = new HashSet<>();
		for (WebElement webElem : webElems) {
			allTexts.add(webElem.getText());
		}
		softAssert.assertTrue(allTexts.contains(expectedValue), "Expected Value[" + expectedValue + "] not found in list[" + allTexts + "]");
	}

	/**
	 * compareTwoValues
	 *
	 * @author ankit
	 * @param actualValue
	 * @param expectedValue
	 */
	public void assertEquals(Object actualValue, Object expectedValue) {
		String errorMsg = "Expected and actual objects are not matching";
		assertEquals(actualValue, expectedValue, errorMsg);
	}

	/**
	 * Assert equals two objects
	 *
	 * @param actualValue
	 * @param expectedValue
	 * @param errorMsg
	 */
	public void assertEquals(Object actualValue, Object expectedValue, String errorMsg) {
		softAssert.assertEquals(actualValue, expectedValue, errorMsg);
	}

	/**
	 * compareTwoValues - array of objects
	 *
	 * @author ankit
	 * @param actualValue
	 * @param expectedValue
	 */
	public void assertEquals(Object[] actualValue, Object[] expectedValue) {
		String errorMsg = "Expected and actual arrays are not matching";
		softAssert.assertEquals(actualValue, expectedValue, errorMsg);
	}

	/**
	 * assertListOfElementsExistsInPage
	 *
	 * @author ankit
	 * @param webElems
	 */
	public void assertElementsExist(List<WebElement> webElems) {
		for (WebElement webElem : webElems) {
			softAssert.assertTrue(webElem.isDisplayed(), "Element[" + webElem + "] is not displayed");
		}
	}

	/**
	 * assertListOfElementsIsNotEmpty
	 *
	 * @author ankit
	 * @param webElems
	 */
	public void assertElementsNotEmpty(List<WebElement> webElems) {
		for (WebElement webElem : webElems) {
			String txt = webElem.getText();
			softAssert.assertTrue((txt != "" && txt != null), "Element[" + webElem + "] is empty");
		}
	}

	/**
	 * assertElementsExistsInPage
	 *
	 * @author ankit
	 * @param webElement
	 */
	public void assertElementExists(WebElement webElement) {
		boolean flag = false;
		try {
			flag = webElement.isDisplayed();
		} catch (NoSuchElementException e) {
			flag = false;
		}
		softAssert.assertTrue(flag, "Element[" + webElement + "] is not displayed");
	}

	/**
	 * assert that two strings are matching
	 *
	 * @author ankit
	 * @param expectedText
	 * @param actualText
	 */
	public void assertEquals(String actualText, String expectedText) {
		String errorMsg = "Expected[" + expectedText + "] and actual[" + actualText + "] strings are not matching";
		assertEquals(actualText, expectedText, errorMsg);
	}

	/**
	 * assert that two strings are matching
	 *
	 * @param actualText
	 * @param expectedText
	 * @param errorMsg
	 */
	public void assertEquals(String actualText, String expectedText, String errorMsg) {
		softAssert.assertEquals(actualText, expectedText, errorMsg);
	}

	/**
	 * assert that two strings are not matching
	 *
	 * @param actualText
	 * @param expectedText
	 * @param errorMsg
	 */
	public void assertNotEquals(String actualText, String expectedText, String errorMsg) {
		softAssert.assertNotEquals(actualText, expectedText, errorMsg);
	}

	/**
	 * assert two booleans values
	 *
	 * @author ankit
	 * @param expectedValue
	 * @param actualValue
	 */
	public void assertEquals(Boolean actualValue, Boolean expectedValue) {
		String errorMsg = "Expected[" + expectedValue + "] and actual[" + actualValue + "] booleans are not matching";
		softAssert.assertEquals(actualValue, expectedValue, errorMsg);
	}

	/**
	 * assertTrue
	 *
	 * @param actualValue
	 * @param errorMsg
	 */
	public void assertTrue(Boolean actualValue, String errorMsg) {
		softAssert.assertTrue(actualValue, errorMsg);
	}

	/**
	 * assertFalse
	 *
	 * @param actualValue
	 * @param errorMsg
	 */
	public void assertFalse(Boolean actualValue, String errorMsg) {
		softAssert.assertFalse(actualValue, errorMsg);
	}

	/**
	 * assert element not present in page
	 *
	 * @author ankit
	 * @param element
	 */
	public void assertElementsNotExist(List<WebElement> webElements) {
		softAssert.assertTrue(webElements.isEmpty(), "Element found and size is " + webElements.size());
	}

	/**
	 * assertListsAfterSorting
	 *
	 * @param actualValue
	 * @param expectedValue
	 */
	public void assertEqualAfterSorting(List<String> actualValue, List<String> expectedValue) {
		Collections.sort(actualValue);
		Collections.sort(expectedValue);
		assertEquals(actualValue, expectedValue);
	}

	/**
	 * assert two lists are not equal
	 *
	 * @param listOne
	 * @param listTwo
	 */
	public void assertNotEquals(List<String> listOne, List<String> listTwo) {
		softAssert.assertNotEquals(listOne, listTwo, "Values match. List one[" + listOne + "] List two[" + listTwo + "]");
	}

	/**
	 * assert two lists are equal
	 *
	 * @param listOne
	 * @param listTwo
	 */
	public void assertEquals(List<String> listOne, List<String> listTwo) {
		softAssert.assertEquals(listOne, listTwo, "Values do not match. Expected[" + listOne + "] Actual[" + listTwo + "]");
	}

	/**
	 * assertElementInStringList
	 *
	 * @author ankit
	 * @param expectedValue
	 * @param strings
	 */
	public void assertValueInList(String expectedValue, List<String> strings) {
		softAssert.assertTrue(strings.contains(expectedValue), "Expected Value[" + expectedValue + "] not found in list[" + strings + "]");
	}

	/**
	 * Assert Expected Value Not In List
	 *
	 * @param expectedValue
	 * @param elements
	 */
	public void assertValueNotInList(String expectedValue, List<WebElement> elements) {
		Set<String> allTexts = new HashSet<>();
		for (WebElement webElem : elements) {
			allTexts.add(webElem.getText());
		}
		softAssert.assertFalse(allTexts.contains(expectedValue), "Expected Value[" + expectedValue + "] found in list[" + allTexts + "]");
	}

	/**
	 * assertBrokenLinks
	 *
	 * @author ankit
	 * @param listOfLinks
	 */
	public void assertListEmpty(List<String> list) {
		softAssert.assertTrue(list.isEmpty(), "List[" + Arrays.toString(list.toArray()) + "]");
	}

	/**
	 * verifySorting
	 *
	 * @author ankit
	 * @param sortOrder
	 * @param webElements
	 */
	public void assertElementsAreSorted(String sortOrder, List<WebElement> webElements) {
		List<String> actualElemTexts = new ArrayList<>();
		List<String> expectedElemTexts = new ArrayList<>();
		for (WebElement element : webElements) {
			actualElemTexts.add(element.getText());
			expectedElemTexts.add(element.getText());
		}

		sortOrder = sortOrder.toLowerCase();
		if ("ascending".equalsIgnoreCase(sortOrder)) {
			Arrays.parallelSort(expectedElemTexts.toArray(new String[expectedElemTexts.size()]));
		} else if ("descending".equalsIgnoreCase(sortOrder)) {
			Arrays.parallelSort(expectedElemTexts.toArray(new String[expectedElemTexts.size()]), Collections.reverseOrder());
		}


		softAssert.assertEquals(actualElemTexts, expectedElemTexts);
	}
}
