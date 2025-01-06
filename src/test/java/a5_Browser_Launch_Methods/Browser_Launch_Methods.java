package a5_Browser_Launch_Methods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Browser_Launch_Methods {

	public static WebDriver driver;

	public static void main(String[] args) {

	}

	public static void chromeBrowserLaunch() {
		driver = new ChromeDriver();
	}

	public static void firefoxBrowserLaunch() {
		driver = new FirefoxDriver();
	}

	public static void safariBrowserLaunch() {
		driver = new SafariDriver();
	}

	public static void edgeBrowserLaunch() {
		driver = new EdgeDriver();
	}

	public static void operaBrowserLaunch() {

	}

}
