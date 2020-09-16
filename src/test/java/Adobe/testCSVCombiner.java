package Adobe;

import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.io.*;

import java.io.OutputStreamWriter;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.apache.commons.csv.CSVRecord;
import org.junit.Test;

public class testCSVCombiner {

	@Test
	public void Testread() {
		ArrayList<ArrayList<String>> a = CSVCombiner.read("src/main/resources/data.csv");
		
		assertEquals("yes", "37", a.get(0).get(2));
	
	}
	@Test
	public void Testwrite() {
		ArrayList<ArrayList<String>> a = CSVCombiner.read("src/main/resources/data.csv");
		CSVCombiner.write(a);
		try {
			File f = new File("data5.csv");
			f.isFile();
		} catch (Exception e) {
			fail();
		}
	}
}
