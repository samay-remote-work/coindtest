package coindcxtest.coindcxtest.pageobjects.loginpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginpagePageObjects {
	
	@FindBy(xpath="//div[@class='header-everything']//a[contains(@href,'/login')]")
	protected WebElement loginLink;
	
	@FindBy(xpath="//button[@id='register-btn']")
	protected WebElement registerBtn;
	
	

}
