package Selenium_Practice;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://practice.expandtesting.com/dynamic-table");

//		List<WebElement> tableHeading = driver.findElements(By.tagName("th"));
		List<WebElement> tableHeading = driver.findElements(By.xpath("//table//th"));
		ArrayList<String> list = new ArrayList<String>();

		for (WebElement ele : tableHeading) {

			String names = ele.toString();
			System.out.println(names);
			list.add(names);
		}

		System.out.println(list);

//		WebElement searchField = driver.findElement(By.xpath("//input[@placeholder='Search']"));
//		searchField.sendKeys("Antonio");

	}

}
