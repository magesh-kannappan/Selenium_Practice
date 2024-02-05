package a1_Base;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Base {

	private static final String snap = null;
	public static WebDriver driver;
	public static Properties configuration_properties = new Properties();
	public static FileReader fileReader;
	public static FileReader fileReader2;

	public static void main(String[] args) throws IOException, AWTException, InterruptedException {

	}

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

}
