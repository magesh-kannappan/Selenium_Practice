package a3_TestNG_Practice;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class TestNG_Practice_26_05_25 {

	@Test(priority = -1, enabled = false)
	public static void login() {
		System.out.println("Login");
	}

	@Ignore
	@Test(priority = 1)
	public static void logout() {
		System.out.println("Logout");
	}

//	@Ignore
	@Test(priority = 0, groups = "smoke")
	public static void orderPlacement() {
		System.out.println("Order Placement");
	}

	@Test
	public static void browserLaunch() {
		System.out.println("Browser Launch");
	}

}
