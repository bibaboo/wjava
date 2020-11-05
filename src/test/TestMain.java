package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
	
//		List<String> testList = new ArrayList<String>();
//		testList.add("aaa@aaa.com");
//		testList.add("bbb@bbb.com");
//		testList.add("ccc@ccc.com");
//			
//		String testMail = "bbb@bbb.com";
//		System.out.println("list result ==>" + testList.contains(testMail));
//		
//	
//		String a = "aaa,bbb,ccc";
//		String b = "bbb";
//		
//		System.out.println("String result ==>" + a.contains(b));	
//		System.out.println("String[] result ==>" + Arrays.asList(a.split(",")).contains(b));
		
		String path = "../../abc/aaa.gif";
		
		System.out.println(path);
		
		path = path.replace("../", "");
		
		System.out.println(path);
		
		
		
		
		
	}

}
