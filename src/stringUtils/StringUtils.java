package stringUtils;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class StringUtils {

	private StringUtils() {
		throw new AssertionError();
	}
	
	//####################################################################################
	// manipulate 
	//####################################################################################
	
	/**
	 * 문자열의 Null 값 치환
	 * 
	 * @param str
	 * @param replacer
	 * @return String
	 */
	public static String nvl(String str) {
		return nvl(str, "");
	}
	
	public static String nvl(String str, String replacer) {
		if (str == null) {
			return replacer;
		} else {
			return str;
		}
	}
	
	/**
	 * str의 왼쪽에 주어진 길이만큼 addStr로 채운다
	 * 
	 * @param str 대상문자열
	 * @param len 길이
	 * @param addStr 대체문자
	 * @return String
	 */

	public static String lpad(String str, int len, String addStr) {
		String result = str;
		int templen = len - result.length();

		for (int i = 0; i < templen; i++) {
			result = addStr + result;
		}

		return result;
	}
	
	/**
	 * 문자열을 치환함
	 * 
	 * @param str
	 * @param sourceStr
	 * @param targetStr
	 * @return String
	 */
	public static String replace(String value, String sourceStr, String targetStr) {

		String str = value;
		if (str == null || sourceStr == null || targetStr == null || str.length() == 0 || sourceStr.length() == 0) {
			return str;
		}

		int position = 0;
		int sourceStrLength = sourceStr.length();
		int targetStrLength = targetStr.length();

		while (true) {
			position = str.indexOf(sourceStr, position);
			if (position != -1) {
				if ((position + sourceStrLength) < str.length()) {
					str = str.substring(0, position) + targetStr + str.substring(position + sourceStrLength);
				} else {
					str = str.substring(0, position) + targetStr;
				}

				position = position + targetStrLength;

				if (position > str.length()) {
					position = str.length();
				}
			} else {
				break;
			}
		}

		return str;
	}
	
	/**
	 * 문자열 치환
	 * 
	 * @param value
	 * @return String
	 */
	public static String replaceContentString2(String value) {
		String str = value;
		if (str != null && str.length() > 0) {
			str = replace(str, "&amp;", "&");
			str = replace(str, "\"", "&quot;");
			str = replace(str, "&", "&amp;");
			str = replace(str, "<", "&lt;");
			str = replace(str, ">", "&gt;");
		}

		return str;
	}
	
	/**
	 * 문자열을 특정 크기로 잘라낸다.
	 * 
	 * @param strSource
	 * @param cutByte
	 * @return
	 */
	public static String cutString(String strSourceStr, int cutByte, String strPostfixStr) {

		boolean bTrim = false;
		String strSource = strSourceStr;
		String strPostfix = strPostfixStr;

		if (strSource == null) {
			return "";
		}

		strPostfix = (strPostfix == null) ? "" : strPostfix;
		int postfixSize = 0;
		for (int i = 0; i < strPostfix.length(); i++) {
			if (strPostfix.charAt(i) < 256) {
				postfixSize += 1;
			} else {
				postfixSize += 2;
			}
		}

		if (postfixSize > cutByte) {
			return strSource;
		}

		if (bTrim) {
			strSource = strSource.trim();
		}
		char[] charArray = strSource.toCharArray();

		int strIndex = 0;
		int byteLength = 0;
		for (; strIndex < strSource.length(); strIndex++) {

			int byteSize = 0;
			if (charArray[strIndex] < 256) {
				// 1byte character 이면
				byteSize = 1;
			} else {
				// 2byte character 이면
				byteSize = 2;
			}

			if ((byteLength + byteSize) > cutByte - postfixSize) {
				break;
			}
			
			byteLength += byteSize;
			//byteLength = byteLength += byteSize;
		}

		if (strIndex == strSource.length()) {
			strPostfix = "";
		} else {
			if ((byteLength + postfixSize) < cutByte) {
				strPostfix = " " + strPostfix;
			}
		}

		return strSource.substring(0, strIndex) + strPostfix;
	}
	
	/**
	 * delimeter로 년,월,일을 구분해서 나눈다.
	 * 
	 * @param value HHMMSS로 구성되어 있는 String
	 * @return 구분자로 구분이 된 결과 값
	 */
	public static String formatDate(String str, String delimeter) {
		if (str == null || str.length() != 8) {
			return "";
		}

		StringBuffer buffer = new StringBuffer();

		buffer.append(str.substring(0, 4));
		buffer.append(delimeter);
		buffer.append(str.substring(4, 6));
		buffer.append(delimeter);
		buffer.append(str.substring(6, 8));

		return buffer.toString();
	}

	public static String formatDate(String str) {
		return formatDate(str, ".");
	}

	/**
	 * delimeter로 시,분,초 을 구분해서 나눈다.
	 * 
	 * @param value HHMMSS로 구성되어 있는 String
	 * @return 구분자로 구분이 된 결과 값
	 */
	public static String formatTime(String str, String delimeter) {
		if (str == null || str.length() != 6) {
			return "";
		}

		StringBuffer buffer = new StringBuffer();

		buffer.append(str.substring(0, 2));
		buffer.append(delimeter);
		buffer.append(str.substring(2, 4));
		buffer.append(delimeter);
		buffer.append(str.substring(4, 6));

		return buffer.toString();
	}

	public static String formatTime(String str) {
		return formatTime(str, ":");
	}

	/**
	 * 넘어온 값에 세자리마다 ','를 넣어주는 함수.
	 * 
	 * @param value comma를 붙여야 되는 숫자
	 * @return 세자리 마다 ,가 붙어 있는 String
	 */
	public static String formatNumber(int value) {
		return formatNumber(String.valueOf(value));
	}

	/**
	 * 넘어온 값에 세자리마다 ','를 넣어주는 함수. 숫자인지는 체크하지 않음.
	 * 
	 * @param value comma를 붙여야 되는 String
	 * @return 세자리 마다 ,가 붙어 있는 String
	 */
	public static String formatNumber(String str) {
		if (str == null || str.equals("")) {
			return "0";
		}

		if (str.length() <= 3) {
			return str;
		} else {
			String remainder = str.substring(str.length() - 3, str.length());

			return formatNumber(str.substring(0, str.length() - 3)) + "," + remainder;
		}
	}

	/**
	 * 999,999,999 또는 999,999,999.99 format으로 되어있는 자료를 ','가 없는 형식으로 변환
	 * 
	 * @param value String type의 데이터
	 * @return String 숫자 format으로 변환된 데이터
	 */
	public static String unformatNumber(String value) {
		if (value == null) {
			return "err-numberFormat(null)";
		}

		StringBuffer res = new StringBuffer();

		StringTokenizer st = new StringTokenizer(value, ",");

		try {
			while (st.hasMoreTokens()) {
				res.append(st.nextToken());
			}
		} catch (NoSuchElementException nse) {
		}

		return res.toString();
	}
	
	/**
	 * 8859-1을 utf-8로 바꾼다.
	 * 
	 * @param str 인코딩할 문자열 String
	 * @return 인코딩된 결과 값
	 */
	public static String toKorean(String value) {
		String str = value;
		try {
			if (str != null) {
				str = new String(str.getBytes("8859_1"), "utf-8");
			}
		} catch (UnsupportedEncodingException e) {
			return "ENCORDING ERROR";
		}

		return str;
	}

	/**
	 * utf-8을 8859-1로 바꾼다.
	 * 
	 * @param str 인코딩할 문자열 String
	 * @return 인코딩된 결과 값
	 */
	public static String toEnglish(String value) {
		String str = value;
		try {
			if (str != null) {
				str = new String(str.getBytes("utf-8"), "8859_1");
			}
		} catch (UnsupportedEncodingException e) {
			return "ENCORDING ERROR";
		}

		return str;
	}

	/**
	 * 구분자를 가진 String을 받아서 List형태로 리턴함
	 * 
	 * @param str
	 * @param delim
	 * @return
	 */
	public static List<String> getTokens(String str, String delim) {
		if (str == null || delim == null || str.equals("") || delim.equals("")) {
			return null;
		}

		List<String> list = new ArrayList<String>();

		StringTokenizer st = new StringTokenizer(str, delim);

		while (st.hasMoreTokens()) {
			list.add(st.nextToken());
		}

		return list;
	}

	/**
	 * string[] 을 받아서 List 형태로 리턴함.
	 * 
	 * @param str
	 * @return
	 */
	public static List<String> getList(String[] str) {
		List<String> list = new ArrayList<String>();

		for (int i = 0; i < str.length; i++) {
			list.add(str[i]);
		}

		return list;
	}
	
	/**
	 * List를 받아서 String 형태로 리턴함.
	 * 
	 * @param aList
	 * @return
	 */
	public static <E> String List2String(List<E> aList){
		StringBuffer message = new StringBuffer();

		for(E item : aList){
			message.append((message.length() == 0 ? "" : ", ") + item.toString());
		}

		return String.format("[%s]", message.toString());
	}
	
	public static String toString(Object object){
        Field []fields = object.getClass().getDeclaredFields();
        StringBuffer sb = new StringBuffer();
        sb.append("{");
        for(Field field : fields){
            field.setAccessible(true);
            try {
                String type = field.getType().toString().substring(field.getType().toString().lastIndexOf(".") + 1);
                if(field.getType().toString().startsWith("class ") && !field.getType().toString().startsWith("class java.lang.")){
                   sb.append("\n\t" + type + " " + field.getName() + toString(field.get(object)));
                }else{
                	sb.append("\n\t" + type + " " + field.getName() + ":" + field.get(object));   
                }
            } catch (IllegalArgumentException e) {
            } catch (IllegalAccessException e) {
            }
        }
        sb.append("\n}");
        return sb.toString();
    }


	/**
	 * 파일 확장자를 리턴함
	 * 
	 * @param filename
	 * @return
	 */
	public static String getFileExtension(String filename) {
		String extension = null;

		if (filename != null && filename.lastIndexOf('.') > 0 && filename.length() >= 3) {
			extension = filename.substring(filename.lastIndexOf('.') + 1, filename.length());
		}

		return extension;
	}
	
	/**
	 * <pre>
	 * String[] items = { &quot;yellow&quot;, &quot;green&quot;, &quot;red&quot; };
	 * String[] numberItem = { &quot;1&quot;, &quot;2&quot;, &quot;3&quot; };
	 * 
	 * assertEquals(&quot;'yellow','green','red'&quot;, StringUtil.makeSqlInStatement(items, true));
	 * assertEquals(&quot;1,2,3&quot;, StringUtil.makeSqlInStatement(numberItem, false));
	 * </pre>
	 * 
	 * @param items in 조건에 들어갈 아이템들
	 * @param quote 인용부호를 붙이는지 여부 true 면 붙인다
	 * @return 만들어진 in 조건문
	 */
	public static String makeSqlInStatement(String[] items, boolean quote) {
		if (items == null || items.length == 0) {
			return "";
		}

		StringBuffer retStr = new StringBuffer("");
		for (int i = 0; i < items.length; i++) {
			retStr.append((!quote ? items[i] : "'" + items[i] + "'") + ",");
		}

		return retStr.toString().substring(0, retStr.length() - 1);
	}

	/**
	 * 랜덤 문자열 만들기
	 * 
	 * @param len
	 * @return
	 */
	public static String randomStr(int len) {
		char[] initRandomChar = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q',
				'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'x', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K',
				'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4',
				'5', '6', '7', '8', '9' };

		StringBuffer sb = new StringBuffer();
		SecureRandom random = new SecureRandom();
		
		int i = 0;
		while (i < len) {
			sb.append(initRandomChar[(int) (random.nextDouble() * initRandomChar.length)]);
			i++;
		}

		return sb.toString();
	}

	/**
	 * HTML에서 태그를 제외한 문자만 추출하는 유틸메서드
	 * 
	 * @param html the html
	 * @return the string
	 */
	public static String extractTextFormHTML(String html) {
		if (StringUtils.isEmpty(html)) {
			return "";
		}

		String extractText = html.replaceAll("(?:<!--.*?(?:--.*?--\\s*)*.*?-->)|(?:<(?:[^>'\"]*|\".*?\"|'.*?')+>)", "");

		return extractText;

	}
	
	//특수문자 제거 하기
	public static String StringReplace(String str){      
		String match = "[^\uAC00-\uD7A3xfe0-9a-zA-Z\\s]";
		str =str.replaceAll(match, " ");
		return str;
	}
	 
	//연속 스페이스 제거
	public static String continueSpaceRemove(String str){
	    String match2 = "\\s{2,}";
	    str = str.replaceAll(match2, " ");
	    return str;
	}
	
	
	//####################################################################################
	// validation 
	//####################################################################################
	
	/**
	 * 문자열의 Empty or Null 체크
	 * 
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(Object obj){
        if( obj instanceof String ) return obj==null || "".equals(obj.toString().trim());
        else if( obj instanceof List ) return obj==null || ((List)obj).isEmpty();
        else if( obj instanceof Map ) return obj==null || ((Map)obj).isEmpty();
        else if( obj instanceof Object[] ) return obj==null || Array.getLength(obj)==0;
        else return obj==null;
    }
     
    public static boolean isNotEmpty(Object obj){
        return !isEmpty(obj);
    }
	
    
    //이메일 유효성
  	public static boolean isEmailPattern(String email){
  		Pattern pattern=Pattern.compile("\\w+[@]\\w+\\.\\w+");
  		Matcher match=pattern.matcher(email);
  		return match.find();
  	}
  	
  	
  	
  	public static boolean hasString(String[] source, String search){
  		for(String item : source){
            if(item.contains(search)) return true;
        }
  		
        return false;
    }
  	
  	public static boolean hasString(String source, String[] search){
  		for(String item : search){
            if(source.contains(item)) return true;
        }
  		
        return false;
    }

  	public static boolean hasString(String source, String search){
        return source.contains(search);
    }
	
	
}
