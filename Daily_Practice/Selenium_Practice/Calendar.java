package Selenium_Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Calendar {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://jqueryui.com/datepicker/");

		driver.switchTo().frame(0);
		WebElement DropDown_datepicker = driver.findElement(By.xpath("//input[@id='datepicker']"));
		DropDown_datepicker.click();

		String desiredDate = "May 2024";

		WebElement prevBtn = driver.findElement(By.xpath("//a[@data-handler='prev']"));

		while (true) {
			
			WebElement currentMonth = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']"));
			String currentMonthYear = currentMonth.getText();

			if (currentMonthYear.equals(desiredDate)) {
				break;
			}

			prevBtn.click();
			Thread.sleep(Duration.ofSeconds(2000));

		}

	}
}
