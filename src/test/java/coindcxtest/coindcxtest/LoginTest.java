package coindcxtest.coindcxtest;

import org.testng.Assert;
import org.testng.annotations.Test;

import coindcxtest.coindcxtest.pageobjects.loginpage.LoginPage;
import coindcxtest.coindcxtest.pageobjects.signup.SignupPage;
import coindcxtest.coindcxtest.web.driver.DriverFactory;

public class LoginTest {

	LoginPage lp = new LoginPage(DriverFactory.getDriver());
	SignupPage sp = new SignupPage(DriverFactory.getDriver());

	@Test
	public void login() {

		lp.clickLoginLink();
		lp.clickRegisterLink();
		sp.enterFirstName("Samay");
	}
}
