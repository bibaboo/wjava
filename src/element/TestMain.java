package element;

import java.util.ArrayList;
import java.util.List;

public class TestMain {

	public static void main(String[] args) {
		
		TestResult<Test> result = new TestResult<Test>();
		result.setList(getList());
		
		result.setTotalCount(100);
		result.setTotalPage(10);
		
	}
	
	
	public static List<Test>  getList(){
		
		List<Test> list = new ArrayList<Test>();
		
		Test test = new Test();
		test.setId("id1");
		test.setName("name1");
		list.add(test);
		
		return null;
	}
}
