package arrayCode;

public class ArrayCodeMain {

	public static void main(String[] args) {
		String[] email = ArrayCode.getCollection("email");
		for(int i=0;i<email.length;i++){
			System.out.println(i + " => " + email[i]);
		}
	}
}
