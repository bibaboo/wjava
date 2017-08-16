package base62;

public class Base62Main {

	public static void main(String[] args) {
		String encodedReservationNo = Base62Util.encodeToLong(1234512345);
        System.out.println("ENCODE : "+encodedReservationNo+", DECODE : " + Base62Util.decodeToLong(encodedReservationNo));
        
		
	}

}
