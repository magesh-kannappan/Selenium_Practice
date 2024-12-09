package testpractice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GoogleShadowDom {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		// driver.get(
		// "https://www.amazon.in/s?k=iphone+8&crid=2OXWRZKBQ2HGW&sprefix=iphone+8%2Caps%2C360&ref=nb_sb_noss_2");
		//
		// WebElement element = driver.findElement(By.xpath(
		// "//div[@data-cy='title-recipe']/child::h2[@aria-label='POCO C61 Ethereal Blue
		// 4GB RAM 64GB ROM']/child::a"));
		//
		// @Nullable
		// String domAttribute = element.getDomAttribute("href");
		// System.out.println(domAttribute);
		// driver.navigate().to("https://www.amazon.in/" + domAttribute);

		driver.get("https://letcode.in/alert");
		WebElement simpleAlert = driver.findElement(By.id("accept"));
		simpleAlert.click();

		Alert simpleAlert1 = driver.switchTo().alert();
		Thread.sleep(2000);
		simpleAlert1.accept();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.elementToBeClickable(simpleAlert));
		wait.until(ExpectedConditions.visibilityOf(simpleAlert));
		simpleAlert.click();
	}

}
