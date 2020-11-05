package stringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

;

public class StringUtilsMain {

	public static void main(String[] args) {
		
		
		String aa = "MG";
		
		
		if(aa.matches("MG")){
			aa = "GAC1";
		}
		
		System.out.println(aa);
		
//		
//		String yyMM = "1712";
//		
//		
//		int userId = 30;
//		
//		String markingUserId = String.format("%04d", userId);
//		
//		System.out.println(Integer.parseInt(yyMM + markingUserId));
		
		StringVo vo =  new StringVo();
		
		List<String> list = new ArrayList<String>();
	    Map<String, String> map = new HashMap<String, String>();

	    list.add("string1");
	    list.add("string2");
	    list.add("string3");

        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");

        vo.setList(list);
        vo.setMap(map);
        vo.setTest1("1111");


				
		System.out.println(StringUtils.toString(vo));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
