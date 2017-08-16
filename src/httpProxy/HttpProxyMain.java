package httpProxy;

import java.util.HashMap;
import java.util.Map;

public class HttpProxyMain {

	public static void main(String[] args) {
		
		HttpProxy p = new HttpProxy();

		Map<String, String> params = new HashMap<String, String>();
		params.put("w", "tot");
		params.put("q", "한예슬");

		System.out.println(p.get("http://m.search.daum.net/search", params));
	}
}
