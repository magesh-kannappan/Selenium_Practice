package s5_JavaScript_Executor;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Java_Script_Executor {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/button");
		driver.manage().window().maximize();

		WebElement miniCartBtn = driver.findElement(By.id("home"));
		WebElement name = driver.findElement(By.xpath("//a[contains(text(),'Koushik Chatterjee')]"));

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		wait.until(ExpectedConditions.visibilityOf(miniCartBtn));
		wait.until(ExpectedConditions.elementToBeClickable(miniCartBtn));

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", miniCartBtn);

		String pageTitle = driver.getTitle();
		String actualTitle = "LetCode with Koushik";
		
		

		if (pageTitle.equals(actualTitle)) {
			js.executeScript("arguments[0].scrollIntoView(true);", name);
			System.out.println("Executed");
//			driver.close();
		} else {
			System.out.println("Error");
		}

	}

}
