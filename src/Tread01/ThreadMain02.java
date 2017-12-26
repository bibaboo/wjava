package Tread01;

import java.util.ArrayList;
import java.util.List;

public class ThreadMain02 {
	 
    public static void main(String[] args) {

    	List<String> list = new ArrayList<String>();
    
    	list.add("aaaaaaaaaaaaaaa");
    	list.add("bbbbbbbbbbbbbbb");
    	list.add("ccccccccccccccc");
    	list.add("ddddddddddddddd");
    	list.add("eeeeeeeeeeeeeee");
    	list.add("fffffffffffffff");
    	list.add("ggggggggggggggg");
 
    	System.out.println("start..");
    	Test02Task1 task1 = new Test02Task1(list);
    	Thread thread = new Thread(task1);
		thread.start();
    }
 
}

 
