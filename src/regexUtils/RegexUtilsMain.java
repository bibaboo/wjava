package regexUtils;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtilsMain {

	public static void main(String[] args) {
		
		String s = "010-3214-9759 fdsfs fsdf 010-3214-9759";
		
		List<String> list = RegexUtils.getList(RegexType.phone, s);
		 
		
	}
}
