package encrypt;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class shar512Main {

	public static void main(String[] args) {
		
		
		String enc ="@visitor1711061021OUT17110042ON#";
		
		System.out.println("shar : " + getHashCodeFromString(enc));
	}
	
	public static String encryptSHA512(String target) {
        try {
            MessageDigest sh = MessageDigest.getInstance("SHA-512");
            sh.update(target.getBytes());
            StringBuffer sb = new StringBuffer();
            for (byte b : sh.digest()) sb.append(Integer.toHexString(0xff & b));
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
	
	
	private static String getHashCodeFromString(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
		    md.update(str.getBytes());
		    byte byteData[] = md.digest();
	
		    //convert the byte to hex format method 1
		    StringBuffer hashCodeBuffer = new StringBuffer();
		    for (int i = 0; i < byteData.length; i++) {
		        hashCodeBuffer.append(Integer.toString((byteData[i] & 0xff) + 0x100, 16).substring(1));
		    }
		    return hashCodeBuffer.toString();
		} catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
	}
		
}


















