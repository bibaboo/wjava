package dateUtil;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public final class DateUtil {
	
	private DateUtil() {
		throw new AssertionError();
	}
	
	public static String setPhoneMasking(String aValue) {
		return "";
	}
	
	public static Boolean checkDate(String dt){
		
		try{
			
			int minute = 10;
			String format = "yyyyMMddHHmm";
			
			Calendar tCal = Calendar.getInstance();
			tCal.set(Integer.parseInt(dt.substring(0, 4)),
					Integer.parseInt(dt.substring(4, 6)) - 1,
					Integer.parseInt(dt.substring(6, 8)),
					Integer.parseInt(dt.substring(8, 10)),
					Integer.parseInt(dt.substring(10, 12)));
			
			SimpleDateFormat sdate = new SimpleDateFormat(format);
			
			Calendar sCal = Calendar.getInstance();
			sCal.add(Calendar.MINUTE, -minute);
			
			Calendar eCal = Calendar.getInstance();
			eCal.add(Calendar.MINUTE, minute);
			
			Long tDate = Long.parseLong(sdate.format(tCal.getTime()));
			Long sDate = Long.parseLong(sdate.format(sCal.getTime()));
			Long eDate = Long.parseLong(sdate.format(eCal.getTime()));
			
			System.out.println("sDate : " + sDate);
			System.out.println("tDate : " + tDate);
			System.out.println("eDate : " + eDate);
			
			return tDate>=sDate && tDate<=eDate;
		}catch(Exception e){
			return false;
		}
		
	}
}
