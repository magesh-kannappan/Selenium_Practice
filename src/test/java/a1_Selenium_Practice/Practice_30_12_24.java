package a1_Selenium_Practice;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Practice_30_12_24 {

	public static void main(String[] args) {

		String testUrl = "https://letcode.in/test";

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();

		driver.get(testUrl);

		String currentUrl = driver.getCurrentUrl();
		if (testUrl.equals(currentUrl)) {
			System.out.println("PASS");
		}

		WebElement editCTA = driver.findElement(By.xpath("//a[@class='card-footer-item'][contains(text(),'Edit')]"));
		editCTA.click();

		// Checking the H1 tag

		WebElement pageHeading = driver.findElement(By.xpath("//h1[contains(text(),'Input')]"));
		String pageHeadingText = pageHeading.getText();

		// If the page heading is correct procceds to the next step

		if (pageHeadingText.equals("Input")) {

			WebElement enterFullName = driver.findElement(By.id("fullName"));

			String isReadOnly2 = enterFullName.getDomAttribute("readonly");

			if (isReadOnly2 != null && isReadOnly2.equals("true")) {
				System.out.println("The text box is in a readonly state.");
			} else {
				System.out.println("The text box is not in a readonly state.");
			}
			enterFullName.clear();
			enterFullName.sendKeys("Magesh Kannappan");

			WebElement appendText = driver.findElement(By.id("join"));
			appendText.sendKeys(" bad ugly");

			WebElement insideText = driver.findElement(By.id("getMe"));
			@Nullable
			String domAttribute = insideText.getDomAttribute("value");
			System.out.println(domAttribute);

			WebElement clearText = driver.findElement(By.id("clearMe"));
			clearText.clear();

			WebElement disableText = driver.findElement(By.id("noEdit"));

			if (disableText.isEnabled() && disableText.isDisplayed()) {
				System.out.println("Can edit the text box");
			} else {
				System.err.println("You can't edit the text box");
			}

			WebElement readOnlyTextBox = driver.findElement(By.id("dontwrite"));

			// Check if the text box is readonly

			String isReadOnly = readOnlyTextBox.getDomAttribute("readonly");

			// if (isReadOnly != null && isReadOnly.equals("true")) {
			if (isReadOnly != null && isReadOnly.equals("true")) {
				System.out.println("The text box is in a readonly state.");
			} else {
				System.out.println("The text box is not in a readonly state.");
			}

			driver.navigate().back();

			WebElement btnClick = driver
					.findElement(By.xpath("//a[@class='card-footer-item'][contains(text(),'Click')]"));
			btnClick.click();

			driver.findElement(By.id("home")).click();
			driver.navigate().back();

			String cssValue = driver.findElement(By.id("color")).getCssValue("background-color");
			System.out.println(cssValue);

			WebElement size = driver.findElement(By.id("property"));
			System.out.println(size.getSize());

			WebElement disabledButton = driver.findElement(By.id("isDisabled"));
			boolean isEnabled = disabledButton.isEnabled();
			System.out.println(isEnabled);

			WebElement holdBtn = driver.findElement(By.xpath("//button[@id='isDisabled'][@class='button is-primary']"));
			Actions act = new Actions(driver);
			act.clickAndHold(holdBtn);
			act.build().perform();

			driver.navigate().back();

			WebElement dialog = driver.findElement(By.linkText("Dialog"));
			dialog.click();

			WebElement simpleAlert = driver.findElement(By.id("accept"));
			simpleAlert.click();

			Alert simpleAert = driver.switchTo().alert();
			simpleAert.accept();

		} else {
			System.err.println("Page is not correct");
		}

	}

}
