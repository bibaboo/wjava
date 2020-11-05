package fileUtil;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class FileMaker {
	
	public class Origin {
		public static final String rootPath= "D:\\99.temp\\";
		public static final String folderName= "report";
	}
	
	public class Target {
		public static final String rootPath= "D:\\99.temp2\\";
		public static final String folderName= "target";
	}
	
	public static final String ReplaceStrings[][] = {
		{"report", "target"},
		{"Report", "Target"},
		{"com.lgcns.mxps.console", "com.lgcns.mxps.test"}
	};
	
	public static void main(String[] args) {
		try {
			File originFolder = new File(Origin.rootPath + Origin.folderName);
			File targetFolder = new File(Target.rootPath + Target.folderName);
			File[] fileList = originFolder.listFiles();

			if(!targetFolder.exists()){
				targetFolder.mkdirs();
	        }
			
			checkFileList(fileList);

        } catch ( Exception e ) {
            e.printStackTrace( );
            System.out.println("FileMaker fail !!");
        }
	}
	
	public static void checkFileList(File[] fileList) {
		for (File file : fileList) {
			if(file.isDirectory()) {
				File pathFolder = new File(file.getAbsolutePath().replace(Origin.rootPath + Origin.folderName, Target.rootPath + Target.folderName));
				if(!pathFolder.exists()){
					pathFolder.mkdirs();
		        }

				checkFileList(file.listFiles());
			}else if (file.isFile()) {
				String path = file.getParent().replace(Origin.rootPath + Origin.folderName, Target.rootPath + Target.folderName);
				String repalceFileName = file.getName().replace(Origin.folderName, Target.folderName).replace(capitalize(Origin.folderName), capitalize(Target.folderName));
				contentConverter(file, new File(path + "\\" + repalceFileName));
				System.out.println(file.getAbsolutePath() + " => " + path + "\\" + repalceFileName);
			}
		}
	}
	
	
	public static void contentConverter(File inputFile, File outputFile){
		FileInputStream fileInputStream = null;
		BufferedReader bufferedReader = null;
		FileOutputStream fileOutputStream = null;
		BufferedWriter bufferedWriter = null;

		try {
		   // 생성
		   fileInputStream = new FileInputStream(inputFile);
		   fileOutputStream = new FileOutputStream(outputFile);
		   bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));
		   bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

		   String line;
		   String repLine="";

		   while ((line = bufferedReader.readLine()) != null) {
			   repLine = line;
			   for (int i = 0; i < ReplaceStrings.length; i++){
				   repLine = repLine.replaceAll(ReplaceStrings[i][0], ReplaceStrings[i][1]);
			   }
			   bufferedWriter.write(repLine, 0, repLine.length());
			   bufferedWriter.newLine();
		   	}
		} catch (IOException ex) {
			  ex.printStackTrace();
		} finally {
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
	
	public static String capitalize(final String line) {
	   return Character.toUpperCase(line.charAt(0)) + line.substring(1);
	}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
