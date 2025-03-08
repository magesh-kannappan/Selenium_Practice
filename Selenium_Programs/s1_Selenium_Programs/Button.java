package s1_Selenium_Programs;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Button {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/alert");
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// WebElement button = driver.findElement(By.xpath("//button[@id='home']"));
		// String btnText = button.getText();
		// System.out.println(btnText);
		// button.click();
		//
		// driver.navigate().back();
		//
		// WebElement pos = driver.findElement(By.id("position"));
		// Point location = pos.getLocation();
		// int xs = location.x;
		// int getx2 = location.getX();
		//
		// System.out.println(xs);
		// System.out.println(getx2);
		//
		// WebElement color = driver.findElement(By.id("color"));
		// String cssValue = color.getCssValue("color");
		// System.out.println(cssValue);

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		WebElement prompt = driver.findElement(By.id("prompt"));
		prompt.click();
		Alert alert = driver.switchTo().alert();
		alert.sendKeys("Magesh");
		alert.accept();

		WebElement modern = driver.findElement(By.id("modern"));
		modern.click();
		System.out.println("END");

		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
		}

		WebElement click = driver.findElement(By.xpath("//button[@class='modal-close is-large']"));
		click.click();
	}

}
