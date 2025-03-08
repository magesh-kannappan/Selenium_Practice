package s1_Selenium_Programs;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Drop_Down {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://letcode.in/dropdowns");

		WebElement drop = driver.findElement(By.xpath("//select[@id='fruits']"));
		Select sel = new Select(drop);

		// --------------------------------------

		System.out.println("PRINT");

		sel.selectByIndex(1);
		WebElement firstSelectedOption = sel.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println(text);
		sel.selectByIndex(3);
		WebElement secondSelectedOption = sel.getFirstSelectedOption();
		String ndtext = secondSelectedOption.getText();
		System.out.println(ndtext);

		// --------------------------------------

		System.out.println("FOR EACH");

		List<WebElement> options = sel.getOptions();

		for (WebElement Listoption : options) {
			String text2 = Listoption.getText();
			System.out.println(text2);

		}

		System.out.println("FOR LOOP");

		List<WebElement> options1 = sel.getOptions();
		int size = options1.size();
		System.out.println(size);

		for (int i = 0; i < options.size(); i++) {

			WebElement listopt = options1.get(i);
			String opt = listopt.getText();
			System.out.println(opt);

		}

	}

}
