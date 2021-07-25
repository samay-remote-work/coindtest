package coindcxtest.coindcxtest.pageobjects.loginpage;

import org.openqa.selenium.WebDriver;

import coindcxtest.coindcxtest.helper.SeleniumHelper;

public class LoginPage extends SeleniumHelper {
	WebDriver driver;
	
	LoginpagePageObjects lpo = new LoginpagePageObjects();

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	public void clickLoginLink() {
		this.clickElement(lpo.loginLink);
	}
	
	public void clickRegisterLink() {
		this.clickElement(lpo.registerBtn);
	}
}
