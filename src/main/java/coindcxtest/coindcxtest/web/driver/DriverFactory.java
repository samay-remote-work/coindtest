package coindcxtest.coindcxtest.web.driver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	static WebDriver driver;

	public static WebDriver getDriver() {
		if (driver == null) {
			driver = configDriver();
			return driver;
		} else {
			return driver;
		}
	}

	@SuppressWarnings("deprecation")
	private static WebDriver configDriver() {

		WebDriverManager.chromedriver().clearDriverCache();
		WebDriverManager.chromedriver().setup();
		DesiredCapabilities cap = DesiredCapabilities.chrome();

		String downloadFilepath = System.getProperty("user.dir") + File.separator + "downloads";
		Map<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		chromePrefs.put("download.default_directory", downloadFilepath);
		chromePrefs.put("download.prompt_for_download", false);
		chromePrefs.put("download.directory_upgrade", true);
		chromePrefs.put("safebrowsing.enabled", true);

		ChromeOptions options = new ChromeOptions();
		options.setExperimentalOption("prefs", chromePrefs);
		driver = new ChromeDriver(options);

		driver.manage().window().maximize();
		driver.get("https://coindcx.com/");
		return driver;
	}
}
