package a4_Selenium_WebDriver_Methods;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver_Browser_Management_Methods {

	public static void main(String[] args) {

		// Launch a new Chrome browser instance
		WebDriver driver = new ChromeDriver();

		// Maximize the browser window to occupy the full screen
		driver.manage().window().maximize();

		// Minimize the browser window
		driver.manage().window().minimize();

		// Set the browser window to a custom size (width: 760px, height: 760px)
		Dimension customSize = new Dimension(760, 760);
		driver.manage().window().setSize(customSize);

		// Navigate to the specified URL (Flipkart)
		driver.get("https://flipkart.com");

		// Close the current browser window (if multiple tabs are open, only the active
		// one closes)
		driver.close();

		// Quit the entire browser session (closes all windows and terminates WebDriver)
		driver.quit();
	}
}
