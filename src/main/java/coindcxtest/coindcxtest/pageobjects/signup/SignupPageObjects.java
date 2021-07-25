package coindcxtest.coindcxtest.pageobjects.signup;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignupPageObjects {
	
	
	@FindBy(xpath="//input[@name='firstName']")
	protected WebElement firstNameField;
	
	@FindBy(xpath="//input[@name='lastName']")
	protected WebElement lastNameField;
	
	@FindBy(xpath="//input[@name='email']")
	protected WebElement emailField;
	
	@FindBy(xpath="//input[@name='password']")
	protected WebElement passwordField;
	
	@FindBy(xpath="//input[@name='number']")
	protected WebElement phoneNumberField;
	
	@FindBy(xpath="//span[@id='recaptcha-anchor']")
	protected WebElement reCaptcha;
	
	
}
