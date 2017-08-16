package enumeration;

public class EnumMain {

	public static void main(String[] args) {
		System.out.println(EnumType.ONE);
		System.out.println(EnumType.ONE.getCode());
		System.out.println(EnumType.ONE.getCodeName());
		
		EnumType test = EnumType.value2Enum(2);
		
		System.out.println(test.getCode());
		System.out.println(test.getCodeName());
		
	}

}
