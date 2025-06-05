package s1_Selenium_Programs;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomExample {
	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("https://google.com");

		Dimension dm = new Dimension(1024, 768);
		driver.manage().window().setSize(dm);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Access shadow root using JavaScript
		WebElement shadowHost = driver.findElement(By.cssSelector("shadow-host-selector"));

		// Expand shadow root
		WebElement shadowRoot = (WebElement) js.executeScript("return arguments[0].shadowRoot", shadowHost);

		// Now find the inner element inside shadow root
		WebElement innerElement = shadowRoot.findElement(By.id("input"));
		innerElement.sendKeys("Test Input");

		driver.quit();
	}
}
