package s7_Web_Table;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Web_Table {

	public static void main(String[] args) {

		ChromeOptions opt = new ChromeOptions();
		opt.addArguments("--headless");

		WebDriver driver = new ChromeDriver(opt);
		driver.get("https://letcode.in/table");

		WebElement shopTable = driver.findElement(By.id("shopping"));
		List<WebElement> colCount = shopTable.findElements(By.xpath("//table[@id='shopping']//thead//tr//th"));
		int colSize = colCount.size();
		System.out.println(colSize);

		List<WebElement> rowCount = shopTable.findElements(By.xpath("//table[@id='shopping']//tbody/tr"));
		int rowSize = rowCount.size();
		System.out.println(rowSize);

		List<WebElement> tableData = driver.findElements(By.xpath("//table[@id='shopping']//tbody//tr//td"));
		for (WebElement data : tableData) {
			String text = data.getText();
			System.out.println(text);

		}
	}

}
