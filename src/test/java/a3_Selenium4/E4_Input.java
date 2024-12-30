package a3_Selenium4;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class E4_Input {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.get("https://letcode.in/edit");
		WebElement fullNameInput = driver.findElement(By.id("fullName"));
		fullNameInput.sendKeys("Magesh Kannappan");

		// try {
		// // Add a sleep of, for example, 5 seconds (5000 milliseconds)
		// Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// }

		WebElement appendInput = driver.findElement(By.xpath("//input[@id='join']"));
		appendInput.sendKeys(" Swetha" + Keys.TAB);

		WebElement textValue = driver.findElement(By.id("getMe"));
		String textValueattribute = textValue.getAttribute("value");
		System.out.println(textValueattribute);

		WebElement clearText = driver.findElement(By.id("clearMe"));
		clearText.clear();

		WebElement disabledInput = driver.findElement(By.id("noEdit"));

		if (disabledInput.isEnabled()) {

			disabledInput.sendKeys("Magesh");
		} else {

			System.err.println("Input Box is in disabled state");
		}

		WebElement readOnly = driver.findElement(By.id("dontwrite"));

		String attribute = readOnly.getAttribute("readonly");
		System.out.println(attribute);

		boolean enabled = readOnly.isEnabled();
		System.out.println("Input Box is enabled - " + enabled);

		boolean displayed = readOnly.isDisplayed();
		System.out.println("Input Box is displayed - " + displayed);
		//		
		//		if (readOnly == null) {
//            System.out.println("Editable");
//        } else if (readOnly != null) {
//            System.out.println("Not Editable");
//        } else {
//            System.out.println("Number is zero");
//        }

	}

}
