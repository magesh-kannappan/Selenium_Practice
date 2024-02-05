package a1_Universal_Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/edit");
		Thread.sleep(3000);

		// Example usage of the generic method
		By inputLocator = By.id("noEdit");
		isElementDisabled(driver, inputLocator);

	}

	// Generic method to confirm if an element is disabled
	public static WebElement isElementDisabled(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);

		if (element.isEnabled()) {
			System.out.println("The input field is enabled.");
		} else {
			System.out.println("The input field is disabled.");
		}
		return element;
	}

}