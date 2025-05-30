package a1_Selenium_Practice;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File Dest = ts.getScreenshotAs(OutputType.FILE);
		File source = new File("C:\\Users\\NMSLAP511\\Downloads");
	}

}
