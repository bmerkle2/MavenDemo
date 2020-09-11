package Adobe;

import org.apache.commons.csv.*;

import java.io.*;
import java.util.ArrayList;

public class CSVCombiner {
	final String fileName = "src/main/resources/data.csv";
	public static ArrayList<ArrayList<String>> read(String fileName) {
		Reader in;
		ArrayList<ArrayList<String>> a = new ArrayList<>();
		try {
			 
			 in = new FileReader(fileName);
			 Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(in);
			 
			 for (CSVRecord r: records) {
				 int sum = Integer.valueOf(r.get(0)) + Integer.valueOf(r.get(1));
				 ArrayList<String> ls = new ArrayList<>();
				 ls.add(r.get(0));
				 ls.add(r.get(1));
				 ls.add(String.valueOf(sum));
				 a.add(ls);
			 }
			 write(a);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return a;
	}
	
	
	public static void write(ArrayList<ArrayList<String>> list) {
		try {
			FileWriter fw = new FileWriter("data5.csv");
			CSVPrinter printer = new CSVPrinter(fw, CSVFormat.DEFAULT);
	
			for(ArrayList<String> ls : list) {
				printer.printRecord(ls);
			}
			fw.flush();
			fw.close();
			printer.close();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
}