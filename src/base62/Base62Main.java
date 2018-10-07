package base62;

public class Base62Main {

	public static void main(String[] args) {
		
		long num = Long.parseLong("12062184194023");
		String encodedReservationNo = Base62Utils.encodeToLong(num);
        System.out.println("ENCODE : "+encodedReservationNo+", DECODE : " + Base62Utils.decodeToLong(encodedReservationNo));
	}
}
