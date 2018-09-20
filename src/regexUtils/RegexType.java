package regexUtils;


public enum  RegexType {
	number("[0-9]"),
	english("[a-zA-Z]"),
	hangul("[가-힣]"),
	phone("01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}");
	
	String pattern;
	
	RegexType(String pattern) {
        this.pattern = pattern;
    }

	//전체 검색
	public String all(){
		return "^" + this.pattern + "*$";
	}
	
};
	
