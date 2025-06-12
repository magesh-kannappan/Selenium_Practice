package Selenium_Practice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) throws Exception {
		textFileReader();
	}

	public static void textFileReader() throws IOException {

		String filePath = "C:\\Eclipse Projects\\Personal Workspace\\Selenium_Practice\\Read2.txt";
		FileReader reader = new FileReader(filePath);
		BufferedReader buffer = new BufferedReader(reader);
		String line;

		if ((line = buffer.readLine()) != null) {

			System.out.println(line);

		}

	}

	public static void windowResize() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://netmeds.com");
		driver.manage().window().maximize();

		WebElement element = driver.findElement(By.xpath("//a[contains(text(), 'Customers Speak')]"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].ScrollIntoView(True)", element);
		js.executeScript("arguments[0].click", element);

		// driver.switchTo().newWindow(WindowType.TAB);
		// JavascriptExecutor js = (JavascriptExecutor) driver;
		// js.executeScript("window.open();");
		// Dimension dm = new Dimension(1234, 122);
		// driver.manage().window().setSize(dm);

	}

	public static void brokenImageCheck() throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.netmeds.com");

		int totalLinkCount = 0;
		int brokenLinkCount = 0;
		int goodLinkCount = 0;

		List<WebElement> anchorTags = driver.findElements(By.tagName("a"));

		for (WebElement anchor : anchorTags) {

			String hrefAtt = anchor.getDomAttribute("href");
			totalLinkCount++;
			System.out.println(totalLinkCount);
			System.out.println(hrefAtt);

			// URL url = new URL(hrefAtt);
			// HttpURLConnection http = (HttpURLConnection) url.openConnection();
			// http.setConnectTimeout(3000);
			// http.connect();
			// int res = http.getResponseCode();
			// if (res >= 400) {
			// brokenLinkCount++;
			//
			// } else {
			// goodLinkCount++;
			//
			// }
		}
		// System.err.println("Broken Links count- " + brokenLinkCount);
		// System.out.println("Good Links count " + goodLinkCount);
	}

	public static void brokenLinkChecker() {

		WebDriver driver = new ChromeDriver();
		driver.get("https://practice-automation.com/broken-links/");
		int totalLinkCount = 0;
		int brokenLinkCount = 0;
		int validLinkCount = 0;

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		for (WebElement link : allLinks) {
			String domAttribute = link.getDomAttribute("href");

			if (domAttribute != null && !domAttribute.isBlank()) {
				totalLinkCount++;
				try {
					URL url = new URL(domAttribute);
					HttpURLConnection http = (HttpURLConnection) url.openConnection();
					http.setConnectTimeout(3000);
					http.connect();

					int response = http.getResponseCode();

					if (response >= 400) {
						System.out.println("❌ Broken link: " + domAttribute);
						brokenLinkCount++;
					} else {
						System.out.println("✅ Valid link: " + domAttribute);
						validLinkCount++;
					}

				} catch (Exception e) {
					System.out.println("⚠️ Exception while checking link: " + domAttribute);
					e.printStackTrace();
				}
			} else {
				System.out.println("⚠️ Skipping null/empty href.");
			}
		}

		driver.quit();

		System.out.println("\n=== Link Check Summary ===");
		System.out.println("Total Links Found: " + allLinks.size());
		System.out.println("Total Links Tested: " + totalLinkCount);
		System.out.println("Valid Links: " + validLinkCount);
		System.out.println("Broken Links: " + brokenLinkCount);
	}

}
