package logReader;

public class LogReaderMain {
	public static void main(String[] args) {		
		String name = "C:\\project\\workspace_run\\Wonchu\\src\\LogReader\\test.log";

		LogReader reverseFile = new LogReader(name);
		reverseFile.readFile(null);
	}
}

