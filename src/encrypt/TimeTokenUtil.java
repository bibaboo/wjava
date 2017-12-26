package encrypt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTokenUtil {
	
	public static final Boolean IS_PRINT = true;
	public static final long rndNum = 13131313;
	public static final int ALLOW_MINUTE = 1;
	
    //Encoder
	public static String encode(){
    	return encode(System.currentTimeMillis());
    }
	
    public static String encode(long mm){
    	long rnd1 = (long) (Math.random() * 8) + 2;
    	long rnd2 = (long) (Math.random() * 8) + 2;
    	long enc = (mm * rnd1) + (rndNum*rnd2);
    	String rtn = String.valueOf(enc) + String.valueOf(rnd1) + String.valueOf(rnd2);
    	print("=== EncryptUtil.encode ===\nmm : " + mm + "\nrnd1 : " + rnd1 + "\nrnd2 : " + rnd2 + "\nenc : " + enc + "\nrtn : " + rtn + "\n==========================");
    	return rtn;
    }

    //Decoder
    public static long decode(String rtn){
    	int len = rtn.length(); 
    	long rnd1 = Long.parseLong(rtn.substring(len-2, len-1));
    	long rnd2 = Long.parseLong(rtn.substring(len-1));
    	long enc = Long.parseLong(rtn.substring(0, rtn.length()-2));
    	long mm = (enc-(rndNum*rnd2))/rnd1 ;
    	
    	print("=== EncryptUtil.decode ===\nrtn : " + rtn + "\nrnd1 : " + rnd1 + "\nrnd2 : " + rnd2 + "\nenc : " + enc + "\nmm : " + mm + "\n==========================");
    	return mm;
    }
    
    public static Boolean validate(String enc) {
    	return validate(enc, ALLOW_MINUTE);
	}
    
    public static Boolean validate(String enc, int allowMinute) {
    	try{
    		Long reqMM = TimeTokenUtil.decode(enc);
    		
    		Calendar fromC = Calendar.getInstance();
			fromC.setTime(new Date());
			fromC.add(Calendar.MINUTE, -allowMinute);
			
			Calendar toC = Calendar.getInstance();
			toC.setTime(new Date());
			toC.add(Calendar.MINUTE, allowMinute);
			
			Boolean result = (reqMM>=fromC.getTimeInMillis() && reqMM<=toC.getTimeInMillis());
			
			if(IS_PRINT){
				Calendar reqC = Calendar.getInstance();
				reqC.setTimeInMillis(reqMM);
				print("=== EncryptUtil.validate ===\nallowMinute : " + allowMinute + "\nfromC : " + format(fromC) + "\nreqC : " + format(reqC) + "\ntoC : " + format(toC) + "\nresult : " + result + "\n============================");
			}
    		
    		return result;
    	}catch(Exception e){
    		return false;
    	}
	}
    
    public static void print(String val) {
    	if(IS_PRINT){
    		System.out.println(val);
    	}
    }
    
    public static String format(Calendar cal) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
	    return dateFormat.format(cal.getTime());
    }
}
