package s1_Selenium_Programs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TablePractice {

	public static void main(String[] args) {

		ChromeDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/table");

		WebElement shoppingTable = driver.findElement(By.id("shopping"));
		List<WebElement> elements = shoppingTable.findElements(By.xpath("//table[@id='shopping']/thead/tr/th"));

		for (WebElement head : elements) {
			String text = head.getText();
			System.out.println(text);
		}
	}

}
