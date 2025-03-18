package s3_Screenshot;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

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

		driver.get("https://letcode.in/edit");

		WebElement container = driver.findElement(By.xpath("//div[@class='card']"));

		File shot = container.getScreenshotAs(OutputType.FILE);
		File dest = new File("C:\\Users\\NMSLAP511\\Downloads\\Shipping Charges update\\temp1.png");
//		File asd = new File("C:\\Users\\NMSLAP511\\Downloads\\Shipping Charges update\\temp.jpg");

		FileHandler.copy(shot, dest);
		Desktop.getDesktop().open(dest);

		// driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		// WebElement search = driver.findElement(By.id("search"));
		// search.sendKeys("Magesh");
		// File sourceScreenshot = search.getScreenshotAs(OutputType.FILE);
		// File Destination = new File("C:/Eclipse/Mini Project/SeleniumPractice/" +
		// "Screenshot/screen.png");
		// FileHandler.copy(sourceScreenshot, Destination);
	}

}
