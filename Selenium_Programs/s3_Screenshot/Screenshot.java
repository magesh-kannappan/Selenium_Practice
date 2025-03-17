package s3_Screenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {

	public static void main(String[] args) throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get("https://www.netmeds.com/");
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		WebElement search = driver.findElement(By.id("search"));
		search.sendKeys("Magesh");
		File sourceScreenshot = search.getScreenshotAs(OutputType.FILE);
		File Destination = new File("C:/Eclipse/Mini Project/SeleniumPractice/" + "Screenshot/screen.png");
		FileHandler.copy(sourceScreenshot, Destination);
	}

}
