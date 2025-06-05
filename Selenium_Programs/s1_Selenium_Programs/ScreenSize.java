package s1_Selenium_Programs;

import java.time.Duration;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenSize {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		Dimension dm = new Dimension(1024, 768);
		driver.manage().window().setSize(dm);

		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().minimize();

		driver.navigate().to("https://www.netmeds.com/");
		driver.manage().window().maximize();
		driver.manage().window().fullscreen();

		driver.close();
		driver.quit();

	}
}
