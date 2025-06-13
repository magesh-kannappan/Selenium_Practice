package s1_Selenium_Programs;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Header;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFileReader {

	public static void main(String[] args) throws Exception {

		String filePath = "C:\\Eclipse Projects\\Personal Workspace\\Selenium_Practice\\Excel Data\\UserData.xlsx";
		FileInputStream fis = new FileInputStream(filePath);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);

		for (Row row : sheet) {
			for (Cell cell : row) {

				switch (cell.getCellType()) {

				case STRING:
					System.out.println(cell.getStringCellValue());
					break;
				case NUMERIC:
					System.out.println(cell.getNumericCellValue());
					break;
				case BOOLEAN:
					System.out.println(cell.getBooleanCellValue());
					break;
				default:
					System.out.println("Unknown");
				}
			}
		}
		workbook.close();
		fis.close();
	}
}
