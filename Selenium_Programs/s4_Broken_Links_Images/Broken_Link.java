package s4_Broken_Links_Images;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Broken_Link {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/link.xhtml");
		driver.manage().window().maximize();

		List<WebElement> links = driver.findElements(By.tagName("a"));
		String title = driver.getTitle();
		int linkCount = 0;
		System.out.println("Links found in the " + title + ":");

		for (WebElement link : links) {

			String domAttribute = link.getDomAttribute("href");
//			System.out.println(domAttribute);

			if (domAttribute == null || domAttribute.isEmpty()) {

				try {
					URL url = new URL(domAttribute);
					linkCount++;
					HttpURLConnection http = (HttpURLConnection) url.openConnection();
					http.connect();
					int responseCode = http.getResponseCode();

					if (responseCode >= 400) {
						System.err.println("The link is broken");
					} else {
						System.out.println("Link is working fine - " + url);
						System.out.println("Total link count - " + linkCount);
					}
				} catch (Exception e) {

				}

			}
		}
		
	}
}
