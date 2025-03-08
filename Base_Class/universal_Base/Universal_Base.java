package universal_Base;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Universal_Base {

	private static final String snap = null;
	public static WebDriver driver;
	public static Properties configuration_properties = new Properties();
	public static FileReader fileReader;
	public static FileReader fileReader2;

	// ------------------------------------------URL_Launch----------------------------------------

	public static void eleCheck(WebElement element) {
		element.isDisplayed();
	}

	// ------------------------------------------URL_Launch----------------------------------------

	public static void LaunchUrl(String url) {
		driver.get(url);
	}

	// ------------------------------------------Navigate--------------------------------------------------
	public static void nav(String url) {
		driver.get(url);
	}

	// ------------------------------------------Thread_Sleep--------------------------------------------------

	public static void freeze() throws InterruptedException {
		Thread.sleep(5000);
	}

	// ------------------------------------------Send_Values---------------------------------------------------

	public static void sendValues(WebElement element, String values) {

		if (element.isEnabled()) {
			element.clear();
		} else {
			System.err.println("Element is not displayed");
		}

		element.sendKeys(values);
	}

	// ------------------------------------------Element_Click---------------------------------------------------

	// public static void clickingOnWebElement(WebElement element, long
	// waitTimeInSeconds) {
	// WebDriverWait clickWait = new WebDriverWait(driver,
	// Duration.ofSeconds(waitTimeInSeconds));
	// @SuppressWarnings("unused")
	// WebElement clickElement = null;
	// clickElement =
	// clickWait.until(ExpectedConditions.elementToBeClickable(element));
	// element.click();
	// }

	public static void clickingEle(WebElement element) {
		element.click();
	}

	// ------------------------------------------Close_current_Tab--------------------------------------------

	public static void closeTab() {
		driver.close();
	}

	// ------------------------------------------Close_all_browser_Tab----------------------------------------

	public static void quitBrowser() {
		driver.quit();
	}

	// ------------------------------------------Full_Screen----------------------------------------------

	public static void fullScreen() {
		driver.manage().window().fullscreen();
	}

	// ------------------------------------------Maximize_Screen----------------------------------------------

	public static void maximizeScreen() {
		driver.manage().window().maximize();
	}
	// ------------------------------------------Minimize_Screen----------------------------------------------

	public static void minimizeScreen() {
		driver.manage().window().minimize();
	}

	// ------------------------------------------Current_URL_and_page_Info------------------------------------

	public static void UrlpageInfo() {

		System.out.println("--------------- Current Window Info---------------\n");
		String currentUrl = driver.getCurrentUrl();
		System.out.println("Url of the current page - " + currentUrl);
		String title = driver.getTitle();
		System.out.println("Title of the current page - " + title);
		String currentWindowId = driver.getWindowHandle();
		System.out.println(currentWindowId);
	}

	// ------------------------------------------Full_Window_Screenshot------------------------------------------------------

	public static String fullScreenSnap() throws IOException, AWTException {

		Robot robotClassObject = new Robot();
		Rectangle screenSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage tmp = robotClassObject.createScreenCapture(screenSize);
		String path = System.getProperty("user.dir") + "/Screenshots/FullScreenSnap/" + snap
				+ System.currentTimeMillis() + ".png";
		ImageIO.write(tmp, "png", new File(path));
		return path;
	}

	// ------------------------------------------Page_Title_Checker---------------------------------------------------------

	public static void pageTitleChecker() throws IOException {

		fileReader = new FileReader(System.getProperty("user.dir") + "/src/test/resources/config/Config.properties");
		configuration_properties.load(fileReader);
		String originalLoginTitle = configuration_properties.getProperty("login_title");
		System.out.println(originalLoginTitle);
	}

	// --------------------------------Input_Box--------------------------------------------

	// Generic method to clear text inside a text box
	public static void clearTextBox(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		inputBox.clear();

	}

	// ---------------------------------------------------------------------------------

	// Generic method to send keys to an input text box with wait
	public static void sendKeysWithWait(WebDriver driver, By locator, String inputText) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		inputBox.clear();
		inputBox.sendKeys(inputText);
	}

	// ---------------------------------------------------------------------------------

	// Generic method to get text from inside a text box
	public static String getTextFromTextBox(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement inputBox = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return inputBox.getAttribute("value");
	}

	// ---------------------------------------------------------------------------------

	// Generic method to confirm if an element is Enable or Disabled
	public static WebElement isElementEnableOrDisable(WebDriver driver, By locator) {
		WebElement element = driver.findElement(locator);

		if (element.isEnabled()) {
			System.out.println("The input field is enabled.");
		} else {
			System.out.println("The input field is disabled.");
		}
		return element;
	}

	// ---------------------------------------------------------------------------------

	// Generic method to confirm if text is read-only
	public static void isTextReadOnly(WebDriver driver, By locator) {
		WebElement textElement = driver.findElement(locator);
		String readOnlyAttribute = textElement.getAttribute("readonly");

		if (readOnlyAttribute != null && readOnlyAttribute.equalsIgnoreCase("true")) {
			System.err.println("The text is read-only, You Can't able to edit the content.");
		} else {
			System.out.println("The textBox is editable.");
		}

	}

	// --------------------------------Hyper_Links--------------------------------------------

	// Generic method to count hyperlinks on a page
	public static void countHyperlinks(WebDriver driver) {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int linkCount = links.size();
		System.out.println("Number of hyperlinks on the page: " + linkCount);
	}

	// --------------------------------*****--------------------------------------------

	// Generic method to count broken hyperlinks on a page
	public static void countBrokenHyperlinks(WebDriver driver) {
		// Find all anchor elements on the page
		List<WebElement> links = driver.findElements(By.tagName("a"));

		int brokenLinkCount = 0;

		// Iterate through each link
		for (WebElement link : links) {
			String href = link.getAttribute("href");

			// Skip empty href attributes
			if (href != null && !href.isEmpty()) {
				try {
					// Send HTTP request to the link
					@SuppressWarnings("deprecation")
					HttpURLConnection connection = (HttpURLConnection) new URL(href).openConnection();
					connection.setRequestMethod("HEAD");
					int responseCode = connection.getResponseCode();

					// Check if the response code indicates an error
					if (responseCode >= 400) {
						System.out.println("Number of broken hyperlinks on the page: " + brokenLinkCount);
						System.out.println("Broken Link: " + href + " (HTTP status code: " + responseCode + ")");
						brokenLinkCount++;
					}
				} catch (IOException e) {
					// Handle IOException (e.g., URL format issues)
					System.out.println("Error checking link: " + href);
				}
			}
		}

	}

	// --------------------------------*****--------------------------------------------

	// Generic method to find the URL of a link without clicking
	public static void findLinkUrlWithoutClicking(WebDriver driver, By locator) {
		WebElement link = driver.findElement(locator);
		String linkUrl = link.getAttribute("href");
		System.out.println("URL of the link: " + linkUrl);

	}
	// --------------------------------Re-Check--------------------------------------------

	// Generic method to find duplicate links on a page
	public static void findDuplicateLinks(WebDriver driver) {
		List<WebElement> links = driver.findElements(By.tagName("a"));
		Set<String> uniqueLinks = new HashSet<>();
		List<String> duplicateLinks = new ArrayList<>();

		for (WebElement link : links) {
			String href = link.getAttribute("href");

			// Skip empty href attributes
			if (href != null && !href.isEmpty()) {
				if (!uniqueLinks.add(href)) {
					// If href is already in the set, it's a duplicate
					duplicateLinks.add(href);
				}
			}
		}

		// Print or log the duplicate links
		System.out.println("Duplicate Links on the Page:");
		for (String link : duplicateLinks) {
			System.out.println(link);
			System.out.println("END");
		}
	}

	// --------------------------------*****--------------------------------------------

}
