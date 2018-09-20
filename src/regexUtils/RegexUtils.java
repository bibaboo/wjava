package regexUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexUtils {
	
	public static boolean matches(RegexType regexType, String s){
	    return matches(regexType.pattern, s);
	}
	
	public static boolean matches(String pattern, String s){
	   return Pattern.compile(pattern).matcher(s).matches();
	}

	public static boolean contains(RegexType regexType, String s){
		return contains(regexType.pattern, s);
	}
	
	public static boolean contains(String pattern, String s){
	 return Pattern.compile(pattern).matcher(s).find();
	}

	public static String replaceAll(RegexType regexType, String s, String r){
	    return replaceAll(regexType.pattern, s, r);
	}
	
	public static String replaceAll(String pattern, String s, String r){
	   return Pattern.compile(pattern).matcher(s).replaceAll(r);
	}
	
	public static List<String> getList(RegexType regexType, String s){
	    return getList(regexType.pattern, s);
	}
	
	public static List<String> getList(String pattern, String s){
		List<String> allMatches = new ArrayList<String>();
		Matcher m = Pattern.compile(pattern).matcher(s);
		while (m.find()) {
			allMatches.add(m.group());
		}
		return allMatches;
	}
	
	public static String getText(String content) {
		Pattern scripts = Pattern.compile("<(no)?script[^>]*>.*?</(no)?script>", Pattern.DOTALL);
		Pattern style = Pattern.compile("<style[^>]*>.*</style>",Pattern.DOTALL);
		Pattern tags = Pattern.compile("<(\"[^\"]*\"|\'[^\']*\'|[^\'\">])*>");
		Pattern nTags = Pattern.compile("<\\w+\\s+[^<]*\\s*>");
		Pattern entityRefs = Pattern.compile("&[^;]+;");
		Pattern whiteSpace = Pattern.compile("\\s\\s+");

		Matcher m;
		String convertedContents = content;

		m = scripts.matcher(convertedContents);
		convertedContents = m.replaceAll("");

		m = style.matcher(convertedContents);
		convertedContents = m.replaceAll("");

		m = tags.matcher(convertedContents);
		convertedContents = m.replaceAll("");

		m = nTags.matcher(convertedContents);
		convertedContents = m.replaceAll("");

		m = entityRefs.matcher(convertedContents);
		convertedContents = m.replaceAll("");

		m = whiteSpace.matcher(convertedContents);
		convertedContents = m.replaceAll(" ");

		return convertedContents.replaceAll("\n", "</br>");

	}
}
