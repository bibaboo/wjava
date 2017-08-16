package arrayCode;
public class ArrayCode {
	
	public static final String collection[][] = { 
		{"email", "naver.com", "google.com", "hanmail.net", "korea.com", "nate.com", "yahoo.co.kr"},
		{"telephone", "02","031","032","033","041","042","043","051","052","053","054","055","061","062","063","064"},
		{"handphone", "010","011","016","017","018","019"}
	};

	public static final String[] getCollection(String dataKind){
		for (int i = 0; i < collection.length; i++){
			if (collection[i][0].equals(dataKind)){
				String tmpStr[] = new String[(collection[i].length)-1];
				System.arraycopy(collection[i], 1, tmpStr, 0, collection[i].length - 1);
				return tmpStr;
			}
		}
		return new String[0];
	}
}
