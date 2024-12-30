package a2_Base;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Universal_Base {

	// --------------------------------Input_Box--------------------------------------------

	// Generic method to clear text inside a text box
	public static void clearTextBox(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		inputBox.clear();

	}

	// ---------------------------------------------------------------------------------

	// Generic method to send keys to an input text box with wait
	public static void sendKeysWithWait(WebDriver driver, By locator, String inputText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		inputBox.clear();
		inputBox.sendKeys(inputText);
	}

	// ---------------------------------------------------------------------------------

	// Generic method to get text from inside a text box
	public static String getTextFromTextBox(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return inputBox.getAttribute("value");
	}

	// ---------------------------------------------------------------------------------

	// Generic method to confirm if an element is Enable or Disabled
	public static WebElement isElementEnableOrDisable(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);

		if (element.isEnabled()) {
			System.out.println("The input field is enabled.");
		} else {
			System.out.println("The input field is disabled.");
		}
		return element;
	}

	// ---------------------------------------------------------------------------------

	// Generic method to confirm if text is read-only
	public static void isTextReadOnly(WebDriver driver, By locator) {
		WebElement textElement = driver.findElement(locator);
		String readOnlyAttribute = textElement.getAttribute("readonly");

		if (readOnlyAttribute != null && readOnlyAttribute.equalsIgnoreCase("true")) {
			System.err.println("The text is read-only, You Can't able to edit the content.");
		} else {
			System.out.println("The textBox is editable.");
		}

	}

	// --------------------------------Hyper_Links--------------------------------------------

	// Generic method to count hyperlinks on a page
	public static void countHyperlinks(WebDriver driver) {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int linkCount = links.size();
		System.out.println("Number of hyperlinks on the page: " + linkCount);
	}

	// --------------------------------*****--------------------------------------------

	// Generic method to count broken hyperlinks on a page
	public static void countBrokenHyperlinks(WebDriver driver) {
		// Find all anchor elements on the page
		List<WebElement> links = driver.findElements(By.tagName("a"));

		int brokenLinkCount = 0;

		// Iterate through each link
		for (WebElement link : links) {
			String href = link.getAttribute("href");

			// Skip empty href attributes
			if (href != null && !href.isEmpty()) {
				try {
					// Send HTTP request to the link
					@SuppressWarnings("deprecation")
					HttpURLConnection connection = (HttpURLConnection) new URL(href).openConnection();
					connection.setRequestMethod("HEAD");
					int responseCode = connection.getResponseCode();

					// Check if the response code indicates an error
					if (responseCode >= 400) {
						System.out.println("Number of broken hyperlinks on the page: " + brokenLinkCount);
						System.out.println("Broken Link: " + href + " (HTTP status code: " + responseCode + ")");
						brokenLinkCount++;
					}
				} catch (IOException e) {
					// Handle IOException (e.g., URL format issues)
					System.out.println("Error checking link: " + href);
				}
			}
		}

	}

	// --------------------------------*****--------------------------------------------

	// Generic method to find the URL of a link without clicking
	public static void findLinkUrlWithoutClicking(WebDriver driver, By locator) {
		WebElement link = driver.findElement(locator);
		String linkUrl = link.getAttribute("href");
		System.out.println("URL of the link: " + linkUrl);

	}
	// --------------------------------Re-Check--------------------------------------------

	// Generic method to find duplicate links on a page
	public static void findDuplicateLinks(WebDriver driver) {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Set<String> uniqueLinks = new HashSet<>();
		List<String> duplicateLinks = new ArrayList<>();

		for (WebElement link : links) {
			String href = link.getAttribute("href");

			// Skip empty href attributes
			if (href != null && !href.isEmpty()) {
				if (!uniqueLinks.add(href)) {
					// If href is already in the set, it's a duplicate
					duplicateLinks.add(href);
				}
			}
		}

		// Print or log the duplicate links
		System.out.println("Duplicate Links on the Page:");
		for (String link : duplicateLinks) {
			System.out.println(link);
			System.out.println("END");
		}
	}

	// --------------------------------*****--------------------------------------------

}
