package Selenium_Practice;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class Practice_08_03_25 {

	public static void main(String[] args) throws InterruptedException, IOException {
//		selectDropDown();
		screenshot();
	}

	static void screenshot() throws IOException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://flipkart.com");

		File dest = new File("C:\\Users\\Magesh\\Downloads\\image.png");

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);

		//		FileHandler.copy();
		FileHandler.copy(source, dest);
		
		Desktop.getDesktop().open(dest);

	}

	static void selectDropDown() throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/dropdowns");

		WebElement dropdown = driver.findElement(By.id("fruits"));

		Select drop = new Select(dropdown);

		drop.selectByValue("3");
		Thread.sleep(Duration.ofSeconds(3));

		drop.selectByIndex(1);
		Thread.sleep(Duration.ofSeconds(3));

		drop.selectByVisibleText("Pine Apple");
		Thread.sleep(Duration.ofSeconds(3));

		System.out.println("Execution Completed");

		driver.quit();

	}

	static void verifyPageTitle() {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.netmeds.com");
		String pageTitle = driver.getTitle();

		String actualPageTitle = "order Medicine Online from India's Most Trusted Online Pharmacy | Netmeds";
		System.out.println("current page title - " + pageTitle);

		if (actualPageTitle.equals(pageTitle)) {
			System.out.println("Title matched");
		} else {
			System.err.println("Title not matched");
		}
	}
}
