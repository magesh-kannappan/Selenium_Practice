package s1_Selenium_Programs;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileLoader {

	public static void main(String[] args) throws IOException {

		String filePath = "C:\\Eclipse Projects\\Personal Workspace\\Selenium_Practice\\Test.properties";
		FileInputStream file = new FileInputStream(filePath);
		Properties prop = new Properties();
		prop.load(file);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);

	}

}
