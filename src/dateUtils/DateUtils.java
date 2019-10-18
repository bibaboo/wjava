package dateUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public final class DateUtils {
	
	private DateUtils() {
		throw new AssertionError();
	}
	
	
	public static final String DATEFORMAT = "yyyy-MM-dd HH:mm:ss";
	
	
	/**
	 * GMT 날짜를 가져온다.
	 * @return Date 
	 */
	public static Date getGmtDate(){
		//GMT시간 불러오기
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat(DATEFORMAT);
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));
		SimpleDateFormat dateFormatLocal = new SimpleDateFormat(DATEFORMAT);
		Date mGmtTime = new Date();
		try {
			mGmtTime = dateFormatLocal.parse( dateFormatGmt.format(new Date()));
		} catch (ParseException e) {
			//TODO Auto-generated catch block
			//e.printStackTrace();
		}

		return mGmtTime;
	}
	
	/**
	 * 현재날짜를 가져와서 시간을 00:00:00으로 세팅한다.
	 * @return Date
	 */
	public static Date getDate(){
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Date());
		
		cal.set(Calendar.MILLISECOND, 0);
		cal.set(Calendar.SECOND, 0);
		cal.set(Calendar.MINUTE, 0);
		cal.set(Calendar.HOUR_OF_DAY, 0);
		return cal.getTime();
	}
	
	/**
	 * 날짜를 받아 분을 더한다.
	 * @param Date 날짜타입
	 * @param int  더할 분(minute)
	 * @return Date  
	 */
	public static Date addMinuteDate(Date aDate, int aAddMinute)
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(aDate);
		cal.add(Calendar.MINUTE, aAddMinute);

		return cal.getTime();
	}
	
	/**
	 * 날짜를 받아 날을 더한다.
	 * @param Date 날짜타입
	 * @param int  더할 날짜(day)
	 * @return Date  
	 */
	public static Date addDayDate(Date aDate, int aAddDay){
		Calendar cal = Calendar.getInstance();
		cal.setTime(aDate);
		cal.add(Calendar.DATE, aAddDay);
		return cal.getTime();
	}
	
	/**
	 * 현재 로컬 날짜를 포맷에 맞게 스트링으로 리턴한다. 
	 * @param aDateFormat 날짜포맷
	 * @return String   
	 */
	public static String getCurrentDate(String aDateFormat){
		return getFormatToDate(new Date(), aDateFormat);
	}
	
	/**
	 * 주어진 날짜를 포맷에 맞게 스트링으로 리턴한다.
	 * @param aDate 날짜
	 * @param aDateFormat 날짜포맷
	 * @return String   
	 */
	public static String getFormatToDate(Date aDate, String aDateFormat){
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat (aDateFormat);
		String mTime = mSimpleDateFormat.format(aDate);

		return mTime;
	}
	
	public static String getFormatToLocalDate(Date aDate,String aDateFormat){
		if(aDate==null) return "";
		SimpleDateFormat mSimpleDateFormat = new SimpleDateFormat (aDateFormat);
		String mTime = mSimpleDateFormat.format(new Date(aDate.getTime()+TimeZone.getDefault().getOffset(aDate.getTime())));

		return mTime;
	}
	
}
