package a3_Selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class E1_LocalDriver {

	public static void main(String[] args) {

//		System.setProperty("webdriver.http.factory", "jdk-http-client");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Eclipse Projects\\Selenium Practice\\Driver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.netmeds.com/");

	}

}
