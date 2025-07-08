package Selenium_Practice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Practice_07_07_25 {

	public static void main(String[] args) {

		ChromeOptions option = new ChromeOptions();
		option.addArguments("--headless");

		WebDriver driver = new ChromeDriver(option);
		driver.get("https://www.letcode.in");

		List<WebElement> links = driver.findElements(By.tagName("a"));

		for (WebElement link : links) {
			
			String text = link.getText();
			if(text.contains("http")) {
				System.out.println(link.getText());
			}
			
		}

		// WebElement dropdown = driver.findElement(By.id("fruits"));
		//
		// Select select = new Select(dropdown);
		// List<WebElement> options = select.getOptions();
		//
		// for (WebElement opt : options) {
		// System.out.println(opt.getText());
		// }

	}

}
