package a1_Selenium_Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practice_21_01_25 {

	static WebDriver driver;

	public static void main(String[] args) {
		chromeOptionsResize();
	}

	public static void resizeWindow() {

		// driver = new ChromeDriver();
		// Dimension dimension = new Dimension(234, 234);
		// driver.manage().window().setSize(dimension);
		// driver.get("https://www.google.com");
	}

	public static void chromeOptionsResize() {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--window-size=234,234");
		driver = new ChromeDriver(options);
		driver.get("https://www.google.com");
		driver.get("https://www.google.com");
	}

	public static void notepadFileReading() {
		
		
	}

}
