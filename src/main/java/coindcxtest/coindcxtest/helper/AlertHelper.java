package coindcxtest.coindcxtest.helper;

import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;

public class AlertHelper {
	private WebDriver driver;

	public AlertHelper(WebDriver driver) {
		this.driver = driver;
	}

	public Alert getAlert() {
		return driver.switchTo().alert();
	}

	public void acceptAlert() {
		getAlert().accept();
	}

	public void dismissAlert() {
		getAlert().dismiss();
	}

	public String getAlertText() {
		String text = getAlert().getText();
		return text;
	}

	public boolean isAlertPresent() {
		boolean alertPresent = false;
		try {
			getAlert();
			alertPresent = true;
		} catch (NoAlertPresentException e) {
			// Ignore
		}

		return alertPresent;
	}

	public void acceptAlertIfPresent() {
		if (!isAlertPresent())
			return;
		acceptAlert();
	}

	public void dismissAlertIfPresent() {
		if (!isAlertPresent())
			return;
		dismissAlert();
	}

	public void acceptWithText(String text) {
		if (!isAlertPresent())
			return;

		Alert alert = getAlert();
		alert.sendKeys(text);
		alert.accept();
	}
}
