package logReader;

public class LogReaderMain {
	public static void main(String[] args) {		
		String name = "C:\\temp\\연정모선임_블루투스문제.log";

		LogReader reverseFile = new LogReader(name);
		reverseFile.readFile("default");
	}
}

