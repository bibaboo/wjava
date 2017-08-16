package generator;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;

public class GerneratorMain {

	public static void main(String[] args) throws IOException{

		try {
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			System.out.println(">> Input your name");
			String name = br.readLine();
			System.out.println("name ::: " + name);
			
			System.out.println(">> Input your age");
			String age = br.readLine();
			System.out.println("age ::: " + age);	
			
			String path = "C:\\";
			
			File f=new File(path);
			
			if(!f.exists()){
				f.mkdirs();
				
			}
			String fileName = "person.txt";
			
			////////////////////////////////////////////////////////////////
			BufferedWriter out = new BufferedWriter(new FileWriter(path+ fileName));
	      
			out.write("Personal information"); 
			out.newLine();
			out.write(" - name: [" + name + "]"); 
			out.newLine();		      
			out.write(" - age: [" + age + "]"); 
			out.newLine();		      
			out.write(""); 
			out.newLine();
			out.write(">> generated at : " + (new Date())); 
			out.newLine();

			out.close();
			////////////////////////////////////////////////////////////////
			
			System.out.println("Generated person txt");
		} catch (IOException e) {
			System.exit(1);
			System.out.println("error : " + e.getMessage());
		}
	}
}
