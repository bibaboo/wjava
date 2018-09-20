package fileUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileMaker {

	public static String rootPath = "D:/mdmProject/04.develop4/temp/";		
	public static String originU = "Administrator";
	public static String originS = "administrator";
	
	public static String targetU = "DeviceSubscription"; 
	public static String targetS = "deviceSubscription";
	
	public static void main(String[] args) {
		
		try {
			
			File oFolder = new File(rootPath + originS);
			File sFolder = new File(rootPath + targetS);
			File[] fileList = oFolder.listFiles();

			if(!sFolder.exists()){
				sFolder.mkdirs();
	        }
			
			for (File file : fileList) {
				if (file.isFile()) {
					contentConverter(file, new File(rootPath + targetS + "/" + file.getName().replace(originU, targetU).replace(originS, targetS)));
				}
			}

			System.out.println(targetU + " Package done !!");
        } catch ( Exception e ) {
            e.printStackTrace( );
            System.out.println(targetU + " Package fail !!");
        }
	}
	
	
	public static void contentConverter(File inputFile, File outputFile){
	
		FileInputStream fileInputStream = null;
		BufferedReader bufferedReader = null;
		FileOutputStream fileOutputStream = null;
		BufferedWriter bufferedWriter = null;

		boolean result = false;

		try {
		   // 생성
		   fileInputStream = new FileInputStream(inputFile);
		   fileOutputStream = new FileOutputStream(outputFile);
		   bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		   bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

		   // 원본 파일에서 읽어 들이는 한라인
		   String line;
		   // 패턴에 일치하는 문자로 대체하고 난 후의 string
		   String repLine;

		   // 원본 파일에서 한라인씩 읽는다.
		   while ((line = bufferedReader.readLine()) != null) {
			   // 일치하는 패턴에서는 바꿀 문자로 변환
			   repLine = line.replace(originU, targetU).replace(originS, targetS);

			   // 새로운 파일에 쓴다.
			   bufferedWriter.write(repLine, 0, repLine.length());
			   bufferedWriter.newLine();
		   	}

		   	result = true;
		} catch (IOException ex) {
			  ex.printStackTrace();
		} finally {
		  // 리소스 해제. 개별적으로 해제한다.
		  try {
			  bufferedReader.close();
		  } catch (IOException ex1) {
			  ex1.printStackTrace();
		  }
		  try {
			  bufferedWriter.close();
		  } catch (IOException ex2) {
			  ex2.printStackTrace();
		  }
	  }
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
