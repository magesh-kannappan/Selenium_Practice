package a1_Selenium4;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class E7_Iframe {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/frame.xhtml;jsessionid=node08kicr7gjsstzjz4fap1cq7hk102180.node0");

		// WebElement frame1 = driver
		// .findElement(By.xpath("//h5[text()=' Click Me (Inside Nested
		// frame)']/following-sibling::iframe"));
		// driver.switchTo().frame(frame1);

		WebElement frame1 = driver.findElement(By.xpath("//iframe[@width='100%'][@src='page.xhtml']"));
		driver.switchTo().frame(frame1);

		WebElement frame2 = driver.findElement(By.xpath("//iframe[@name='frame2'][@id='frame2']"));
		driver.switchTo().frame(frame2);

		// WebElement btn = driver.findElement(By.xpath("//button[text()='Click
		// Me'][2]"));
		List<WebElement> css = driver.findElements(By.cssSelector("button#Click"));
		WebElement first = css.getFirst();
		first.click();

		Thread.sleep(3000);

		System.out.println("COMPLETE");

		driver.close();
		driver.quit();

	}

}
