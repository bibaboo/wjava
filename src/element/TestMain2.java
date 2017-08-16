package element;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class TestMain2 {

	public static void main(String[] args) {
		
        HashMap<String, String> dic = new HashMap<String, String>();
 
        dic.put("baby", "아기");
        dic.put("love", "사랑");
        dic.put("apple", "사과");
 
        Set<String> keys = dic.keySet();
        Iterator<String> it = keys.iterator();
        
        while (it.hasNext()) {
            String key = it.next();
            String value = dic.get(key);
            System.out.println("(" + key + "," + value + ")");
        }
        
        // 영어 단어를 입력 받고 한글 단어 검색
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 3; i++) {
            System.out.print("찾고 싶은 단어는?");
            String eng = scanner.next();
            System.out.println(dic.get(eng));
        }
		
	}
	
	
}
