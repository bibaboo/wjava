package constant;

public class ConstantMain {

	public static void main(String[] args) {
	
		System.out.println("Constant.GTEST01 => " + Constant.GTEST01);
		System.out.println("Constant.UserType.admin => " + Constant.UserType.admin);
		
		Constant.Gender gender = Constant.Gender.MAN;
		
		String gneder2 = gender.toString();
		System.out.println("Constant.Gender => " + gneder2);
	
		
		if(gender.equals(Constant.Gender.MAN)) {
			System.out.println("Constant.Gender.MAN => " + Constant.Gender.MAN);
		}
		
		for(Constant.Gender v : Constant.Gender.values()) {
            System.out.println(v);
        }
		
		
	}

}
