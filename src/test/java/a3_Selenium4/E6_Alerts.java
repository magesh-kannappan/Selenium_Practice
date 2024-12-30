package a3_Selenium4;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E6_Alerts {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");

		WebElement simpleAlert = driver.findElement(By.cssSelector("button#accept"));
		simpleAlert.click();

		Alert simpleAlertac = driver.switchTo().alert();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		simpleAlertac.accept();

		// ----------------------------------------------------------

		WebElement confirmAlert = driver.findElement(By.xpath("//button[text()='Confirm Alert']"));
		confirmAlert.click();

		Alert confirmAccept = driver.switchTo().alert();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		confirmAccept.dismiss();

		// ----------------------------------------------------------

		driver.navigate().refresh();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(confirmAlert));

		confirmAlert.click();

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Alert confirmDismiss = driver.switchTo().alert();

		confirmDismiss.accept();

	}

}
