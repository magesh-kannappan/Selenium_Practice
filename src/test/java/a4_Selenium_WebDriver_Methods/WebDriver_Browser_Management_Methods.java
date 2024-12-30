package a4_Selenium_WebDriver_Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriver_Browser_Management_Methods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://flipkart.com");
		Thread.sleep(3000);
		driver.close();
		Thread.sleep(7000);
		driver.quit();
	}

}
