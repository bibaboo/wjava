package encrypt;

public class EncryptMain {

	public static void main(String[] args) {
		
		long mm = System.currentTimeMillis()-(1000*60);
		
		String enc = TimeTokenUtil.encoder();
		
			
		System.out.print("result : " + TimeTokenUtil.validate(enc, 1));
	}
	
}


















