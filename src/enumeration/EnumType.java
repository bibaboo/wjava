package enumeration;

public enum EnumType {

	ONE(1, "하나"),
	TWO(2, "둘"),
	THREE(3, "세"),
	FOUR(4, "넷");
	
	private Integer code;
	private String codeName;
	
	EnumType(Integer code, String codeName) {
        this.code = code;
        this.codeName = codeName;
    }

//	public ExternalGateIoResult getValue(){
//		return new ExternalGateIoResult(this.returnCode, this.returnDesc);
//    }
	
	public static EnumType value2Enum(int value){
		for(EnumType v : values()) {
			if(value == v.getCode()) {
				return v;
			}
		}
		throw new IllegalArgumentException("EnumType value setting error >> Invalid enum. "); // TODO: excpetion
	}
	
	public Integer getCode(){
		return this.code;
    }
	
	public String getCodeName(){
		return this.codeName;
    }
}