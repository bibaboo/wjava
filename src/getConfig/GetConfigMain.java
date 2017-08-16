package getConfig;

public class GetConfigMain {

	public static void main(String[] args) {
		
		String website = Config.getProperty("website");
		System.out.println("website " + website);
	}
}
