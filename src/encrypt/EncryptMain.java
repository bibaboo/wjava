package encrypt;

import base62.Base62Util;

public class EncryptMain {

	public static void main(String[] args) {
		
		long mm = System.currentTimeMillis()-(1000*60);
		
		String enc = TimeTokenUtil.encode();
		
		System.out.println("Base62 : " + Base62Util.encodeToLong(Long.parseLong(enc)));
			
		System.out.print("result : " + TimeTokenUtil.validate(enc));
	}
	
}


















