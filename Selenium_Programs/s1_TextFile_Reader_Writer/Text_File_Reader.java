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
		while ((line = buffer.readLine()) != null) {
			System.out.println(line);
		}
		buffer.close();
	}

}
