package s4_Broken_Links_Images;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Broken_Image {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		String baseUrl = "https://omayo.blogspot.com/";
		driver.get(baseUrl);
		int totalImages = 0;

		List<WebElement> images = driver.findElements(By.tagName("img"));
		for (WebElement img : images) {

			String domAttribute = img.getDomAttribute("src");
			totalImages++;

			if (domAttribute == null || domAttribute.isEmpty()) {
				System.out.println("Image link is empty");
				continue;
			} else {

				try {
					URL url = new URL(baseUrl + domAttribute);
					HttpURLConnection http = (HttpURLConnection) url.openConnection();
					http.setConnectTimeout(3000);
					http.connect();
					int responseCode = http.getResponseCode();

					if (responseCode == 200) {
						System.out.println("Images is  not broken >>> " + baseUrl + domAttribute);
					} else {
						System.err.println("Image is broken >>> " + baseUrl + domAttribute);
					}
				} catch (Exception e) {
				}
			}
		}
		System.out.println("Total images count - " + totalImages);
	}

}
