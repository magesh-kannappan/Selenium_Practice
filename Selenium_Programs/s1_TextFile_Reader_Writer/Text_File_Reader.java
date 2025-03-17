package s1_TextFile_Reader_Writer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Text_File_Reader {

	public static void main(String[] args) throws IOException {

		String filepath = "C:\\Eclipse Projects\\Personal Workspace\\Selenium_Practice\\Read.txt";

		FileReader read = new FileReader(filepath);
		BufferedReader buffer = new BufferedReader(read);
		String line;
		int lineCount = 0;
		String[] custData = null;

		while ((line = buffer.readLine()) != null) {
			lineCount++;
			if (lineCount == 2)
				custData = line.split(",");
		}

		System.out.println("Total number of lines in the text file - " + lineCount);
		System.out.println("Customer name - " + custData[0]);
		System.out.println("Customer age - " + custData[1]);
		System.out.println("Customer location - " + custData[2]);

		buffer.close();
	}

}
