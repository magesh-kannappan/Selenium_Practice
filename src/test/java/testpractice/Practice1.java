package testpractice;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Practice1 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.get("https://letcode.in/test");
		driver.findElement(By.xpath("//a[contains(text(),'Edit')]")).click();

		WebElement inputHeading = driver.findElement(By.xpath("//h1[contains(text(),'Input')]"));
		String text = inputHeading.getText();
		System.out.println(text);
		String head = "Input";
		if (text == head) {
			System.out.println("Page is Correct");
		}
		WebElement stBox = driver.findElement(By.id("fullName"));
		stBox.sendKeys("Magesh Kannappan" + Keys.TAB);

		WebElement asd = driver.findElement(By.xpath("//input[@class='input'][@id='join']"));
		String domAttribute = asd.getDomAttribute("Value");
		System.out.println(domAttribute);

		driver.navigate().to("https://letcode.in/dropdowns");

		WebElement drop = driver.findElement(By.id("fruits"));

		Select select = new Select(drop);
		List<WebElement> options = select.getOptions();
		int size = options.size();
		System.out.println(size);

		for (WebElement option : options) {
			System.out.println(option);
		}

		driver.quit();
	}

}
