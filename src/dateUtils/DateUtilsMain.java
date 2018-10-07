package dateUtils;

public class DateUtilsMain {

	public static void main(String[] args) {

		String dt = "201710121714";
		Boolean b = DateUtils.checkDate(dt);
		
		System.out.println(dt + " : " + b);
	}
}
