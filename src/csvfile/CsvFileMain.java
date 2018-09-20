package csvfile;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class CsvFileMain {
	
	//Delimiter used in CSV file
	private static final String COMMA_DELIMITER = ",";
	private static final String NEW_LINE_SEPARATOR = "\n";
	private static final String FILE_NAME = "c:\\csvfile.csv";
	
	//CSV file header
	private static final String FILE_HEADER = "아이디,이름,성별";

	public static void main(String[] args) {
		
		List<CsvFileVo> list = new ArrayList<CsvFileVo>();
		
		list.add(new CsvFileVo(1, "AAA", "남"));
		list.add(new CsvFileVo(2, "BBB", "여"));
		list.add(new CsvFileVo(3, "CCC", "남"));
		list.add(new CsvFileVo(4, "DDD", "여"));
		list.add(new CsvFileVo(5, "EEE", "남"));
		
		
		 
		BufferedWriter fileWriter = null;
		try {
			
			fileWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(FILE_NAME), "euc-kr"));

			//Write the CSV file header
			fileWriter.append(FILE_HEADER.toString());
			
			//Add a new line separator after the header
			fileWriter.append(NEW_LINE_SEPARATOR);
			
			//Write a new student object list to the CSV file
			for (CsvFileVo info : list) {
				fileWriter.append(String.valueOf(info.getId()));
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(info.getName());
				fileWriter.append(COMMA_DELIMITER);
				fileWriter.append(info.getGeder());
				fileWriter.append(NEW_LINE_SEPARATOR);
			}

			System.out.println("CSV file was created successfully !!!");
			
		} catch (Exception e) {
			System.out.println("Error in CsvFileWriter !!!");
			e.printStackTrace();
		} finally {
			
			try {
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
			}
			
		}
		
	}
	

}
