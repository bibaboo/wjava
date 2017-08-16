package masking;

public class MaskingMain {

	public static void main(String[] args) {
		
		String hp = "+82-1012345678";
		System.out.println("hp : " + hp);
		
		String _hp = MaskingUtil.setPhoneMasking(hp);
		System.out.println("hp : " + _hp);
		
		
		String str =  "a12345678";
		System.out.println("str : " + str);
		
		String _str = MaskingUtil.setMaskingBy(str);
		System.out.println("str : " + _str);
	}

}
