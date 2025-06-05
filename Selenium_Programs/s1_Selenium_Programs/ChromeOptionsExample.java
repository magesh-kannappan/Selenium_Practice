package s1_Selenium_Programs;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeOptionsExample {
	public static void main(String[] args) {
		// Create ChromeOptions object
		ChromeOptions options = new ChromeOptions();

		// Add some common arguments
		options.addArguments("--start-maximized"); // Start browser maximized
		options.addArguments("--incognito"); // Open browser in incognito mode
		options.addArguments("--disable-notifications"); // Disable pop-up notifications

		// Launch Chrome with options
		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
	}
}
