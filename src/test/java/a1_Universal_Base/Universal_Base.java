package a1_Universal_Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Universal_Base {

	// --------------------------------*****--------------------------------------------

	// Generic method to clear text inside a text box
	public static void clearTextBox(WebDriver driver, By locator) {
		WebElement textBox = driver.findElement(locator);
		textBox.clear();

	}

	// --------------------------------*****--------------------------------------------

	// Generic method to send input to an input text box
	public static void sendInput(WebDriver driver, WebElement element, String inputText) {
		element.clear(); // Clear existing text (optional)
		element.sendKeys(inputText);
	}

	// --------------------------------*****--------------------------------------------

	// Generic method to send input to an input text box
	public static void sendAppendInput(WebDriver driver, WebElement element, String inputText) {
		element.sendKeys(inputText);
	}

	// --------------------------------*****--------------------------------------------

	// Generic method to get text from inside a text box
	public static String getTextFromTextBox(WebDriver driver, WebElement element) {
		return element.getAttribute("value");
	}

}
