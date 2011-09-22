package info.apoluna.kosui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class WebDriverFactory {
	public static WebDriver getDriver(String browser) {
		if ("firefox".equals(browser)) {
			return new FirefoxDriver();
		} else if ("ie".equals(browser)) {
			return new InternetExplorerDriver();
		} else {
			throw new RuntimeException("unsupported:" + browser);
		}
	}
}
