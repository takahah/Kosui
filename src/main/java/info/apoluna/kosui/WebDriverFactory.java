package info.apoluna.kosui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import com.opera.core.systems.OperaDriver;

public class WebDriverFactory {
	public static WebDriver getDriver(String browser) {
		if ("firefox".equals(browser)) {
			return new FirefoxDriver();
		} else if ("ie".equals(browser)) {
			return new InternetExplorerDriver();
		} else if ("opera".equals(browser)) {
			return new OperaDriver();
		} else {
			throw new RuntimeException("unsupported:" + browser);
		}
	}
}
