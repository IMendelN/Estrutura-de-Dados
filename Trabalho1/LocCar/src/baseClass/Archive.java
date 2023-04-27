package baseClass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import lists.lde.LDE;

public class Archive {

	public static void record(String content, String archiveName) throws Exception {
		FileOutputStream archive = new FileOutputStream(new File(archiveName));
		BufferedWriter buffer = new BufferedWriter(new OutputStreamWriter(archive, "UTF-8"));
		buffer.write(content);
		buffer.close();
		archive.close();
	}
	
	public static LDE getLines(String archiveName) throws Exception {
		LDE list = new LDE();
		String line;
		FileInputStream archive = new FileInputStream(new File(archiveName));
		BufferedReader buffer = new BufferedReader(new InputStreamReader(archive, "UTF-8"));
		buffer.readLine();
		do {
			line = buffer.readLine();
			if (line != null)
				list.insertEnd(line);
		} while (line != null);
		buffer.close();
		archive.close();
		return list;
	}
}