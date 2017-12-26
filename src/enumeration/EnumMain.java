package enumeration;

import java.util.List;

public class EnumMain {

	public static void main(String[] args) {
		String aa = EnumType.ONE.name();
		System.out.println(aa);
		System.out.println(EnumType.ONE.getCode());
		System.out.println(EnumType.ONE.getCodeName());
		
		EnumType test = EnumType.value2Enum(2);
		
		System.out.println(test.getCode());
		System.out.println(test.getCodeName());
		
		List<Code<Integer>> list = EnumType.toList();
		
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getValue());
		}
		
	}

}
