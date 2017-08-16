package masking;
public final class MaskingUtil {

	private MaskingUtil() {
		throw new AssertionError();
	}
	
	static private Boolean masking = true;
	
	public static String setPhoneMasking(String aValue) {
		if(!masking) return aValue;
		
		//ex +82-1012345678 => +82-1012**456**
		if(aValue !=null && !aValue.isEmpty()){
			String [] aValues = aValue.split("-");
			if(aValues.length>1 && aValues[1].length()>=9){
				return aValues[0] + "-" + aValues[1].substring(0, 4) + "**" + aValues[1].substring(6, aValues[1].length()-2) + "**";  
			}else{
				return aValue;
			}
		}else{
			return aValue;
		}
	}
	
	public static String setMaskingBy(String aValue) {
		if(!masking) return aValue;
		
		//ex a12345678 => a123***** 
		int n = 5;
		if(aValue !=null && !aValue.isEmpty() && aValue.length()>n){
			return aValue.substring(0, aValue.length()-n) + "*****";
		}else{
			return aValue;
		}
	}
}
