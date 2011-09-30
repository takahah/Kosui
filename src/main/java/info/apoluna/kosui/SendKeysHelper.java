package info.apoluna.kosui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SendKeysHelper {
	public static void sendKeys(WebDriver driver, By by, String value) {
		driver.findElement(by).sendKeys(value);
	}
}
