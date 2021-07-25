package coindcxtest.coindcxtest.pageobjects.signup;

import org.openqa.selenium.WebDriver;

import coindcxtest.coindcxtest.helper.SeleniumHelper;

public class SignupPage extends SeleniumHelper{
	
	WebDriver driver;
	
	public SignupPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	SignupPageObjects spo = new SignupPageObjects();
	
	
	public void enterFirstName(String firstName) {
		this.enterTextInTextField(spo.firstNameField, firstName);
		
	}
}
