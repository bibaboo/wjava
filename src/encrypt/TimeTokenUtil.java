package encrypt;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TimeTokenUtil {
	
	public static final Boolean IS_PRINT = false;
	public static final long rndNum = 131313;
	
    //Encoder
	public static String encoder()
    {
    	return encoder(System.currentTimeMillis());
    }
	
    public static String encoder(long mm)
    {
    	long rnd1 = (long) (Math.random() * 8) + 2;
    	long rnd2 = (long) (Math.random() * 8) + 2;
    	long enc = (mm * rnd1) + (rndNum*rnd2);
    	
    	print("=== EncryptUtil.encoder ===\nmm : " + mm + "\nrnd1 : " + rnd1 + "\nrnd2 : " + rnd2 + "\nenc : " + enc);
    	return String.valueOf(enc) + String.valueOf(rnd1) + String.valueOf(rnd2);
    }

    //Decoder
    public static long decoder(String enc)
    {
    	int len = enc.length(); 
    	long rnd1 = Long.parseLong(enc.substring(len-2, len-1));
    	long rnd2 = Long.parseLong(enc.substring(len-1));
    	long mm = Long.parseLong(enc.substring(0, enc.length()-2));
    	long dec = (mm-(rndNum*rnd2))/rnd1 ;
    	
    	print("=== EncryptUtil.decoder ===\nenc : " + enc + "\nmm : " + mm + "\nrnd1 : " + rnd1 + "\nrnd2 : " + rnd2 + "\ndec : " + dec);
    	return dec;
    }
    
    public static Boolean validate(String enc, int allowMinute) {
    	try{
    		Long reqMM = TimeTokenUtil.decoder(enc);
    		
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
				print("=== EncryptUtil.validate ===\nallowMinute : " + allowMinute + "\nfromC : " + format(fromC) + "\nreqC : " + format(reqC) + "\ntoC : " + format(toC) + "\nresult : " + result);
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
