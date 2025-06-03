package Selenium_Practice;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Practice_06_01_25 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		
		
		driver.get("https://www.amazon.in/");
		driver.switchTo().newWindow(WindowType.TAB);

		// Take Screenshot
		double di = 123.3344d;
		int asd = (int) di;

		byte age = 127;
		short age2 = age;

		TakesScreenshot ts = (TakesScreenshot) driver;

		File srcFile = ts.getScreenshotAs(OutputType.FILE);

	}

}
