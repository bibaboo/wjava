package dateUtil;

public class DateUtilMain {

	public static void main(String[] args) {

		String dt = "201710121714";
		Boolean b = DateUtil.checkDate(dt);
		
		System.out.println(dt + " : " + b);
	}
}
