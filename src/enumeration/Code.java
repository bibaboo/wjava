package enumeration;

import java.io.Serializable;

public class Code<T> implements Serializable {

	private static final long serialVersionUID = -4244401054629875558L;

	private T key;
	
	private String value; 

	public T getKey() {
		return key;
	} 
	public String getValue() {
		return value;
	}  
	 
	public Code(T key, String value) {
		super();
		this.key = key;
		this.value = value;
	}
}
