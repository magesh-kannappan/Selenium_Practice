package s1_Selenium_Programs;

import java.util.ArrayList;
import java.util.ListIterator;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

public class Alerts {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		
		
		
		driver.switchTo().newWindow(WindowType.TAB);
		driver.switchTo().newWindow(WindowType.TAB);

		ArrayList list = new ArrayList();

		list.add("Audi");
		list.add("Benz");
		list.add("Bugatti");
		list.add("Aston martin");

		ListIterator<String> listIterator = list.listIterator();

		while (listIterator.hasNext()) {
			System.out.println(listIterator.next());
		}
		//
		// WebDriver driver = new ChromeDriver();
		// driver.get("https://letcode.in/alert");
		//
		// WebElement simpleAlert = driver.findElement(By.cssSelector("button#accept"));
		// simpleAlert.click();
		//
		// Alert simpleAlertac = driver.switchTo().alert();
		//
		// try {
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// simpleAlertac.accept();
		//
		// // ----------------------------------------------------------
		//
		// WebElement confirmAlert =
		// driver.findElement(By.xpath("//button[text()='Confirm Alert']"));
		// confirmAlert.click();
		//
		// Alert confirmAccept = driver.switchTo().alert();
		//
		// try {
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// confirmAccept.dismiss();
		//
		// // ----------------------------------------------------------
		//
		// driver.navigate().refresh();
		//
		// try {
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		// wait.until(ExpectedConditions.visibilityOf(confirmAlert));
		//
		// confirmAlert.click();
		//
		// try {
		// Thread.sleep(2000);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		//
		// Alert confirmDismiss = driver.switchTo().alert();
		//
		// confirmDismiss.accept();

	}

}
