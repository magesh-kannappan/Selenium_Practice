package Selenium_Practice;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

public class ExcelFileReader {

	public static void main(String[] args) throws IOException {

		String filePath = "C:\\Eclipse 2024\\Selenium_Practice\\Read2.txt";
		File file = new File(filePath);
		Desktop.getDesktop().open(file);

		// FileInputStream fis = new FileInputStream(filePath);
		//
		// XSSFWorkbook workbook = new XSSFWorkbook(fis);
		// XSSFSheet sheet = workbook.getSheetAt(0);

		// XSSFsheet.getRow(0);

	}

}
