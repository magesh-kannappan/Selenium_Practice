package s1_Selenium_Programs;

import java.awt.Desktop;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFileWriter {

	public static void main(String[] args) throws IOException {

		String filepath = "C:\\Eclipse Projects\\Personal Workspace\\Selenium_Practice\\Write.txt";
		FileWriter write = new FileWriter(filepath);
		BufferedWriter buffer = new BufferedWriter(write);
		buffer.write("All is Well");
		buffer.write("\nI love India");
		File txtFile = new File(filepath);
		Desktop.getDesktop().open(txtFile);
		buffer.close();
	}

}
