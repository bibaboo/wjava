package encrypt;

import base62.Base62Utils;

public class EncryptMain {

	public static void main(String[] args) {
		
		long mm = System.currentTimeMillis()-(1000*60);
		
		String enc = TimeTokenUtils.encode();
		
		System.out.println("Base62 : " + Base62Utils.encodeToLong(Long.parseLong(enc)));
			
		System.out.print("result : " + TimeTokenUtils.validate(enc));
	}
	
}


















