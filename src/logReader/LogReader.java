package logReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.Collator;
import java.util.Comparator;
import java.util.LinkedList;

public class LogReader implements ProcessFile {
	private String fileName;
	private File files;
	private final LinkedList<String> list = new LinkedList<String>();
	private String target;
	private String logLevel = "E/DeviceON";
	//private String logLevel = "";
	public String collection[][] = { 
		{"kiosk", "ExternalKiosk", "deviceon", "[정보] gateZoneId"},
		{"default", "PUSH 받음", "최근", "Gate In", "Gate Out", "현재 적용되있는 위치기반 정책", "System Camera", "SSE MDM Camera With WhiteList", "블루투스"}
	};


	public LogReader(String name) {
		fileName = name;
		files = new File(fileName);
	}
		
	public void readFile(String _target) {
		target = _target;
		printLog("=============== start : " + target + " ================");
		FileInputStream in = null;
		try {
			in = new FileInputStream(this.files);
		}
		catch (FileNotFoundException e){e.printStackTrace();}

		try {
			InputStream flux = in; 
			InputStreamReader read = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(read);
			String line;
			int num = 0;
			while ((line = buff.readLine()) != null){
				validate(line, ++num);
			}
			buff.close();
			
			//sorting..
			list.sort( new Comparator<String>(){
				@Override
		        public int compare(String o1,String o2){
		            return Collator.getInstance().compare(o1,o2);
		        }
		    });
			
			printList();
		}
		catch(IOException e) {e.printStackTrace();}
		finally{
			printLog("==================== finshed ==========================");
		}
	}
	
	public void validate(String line, int num){
		if("".equals(logLevel) || line.indexOf(logLevel)>-1){
			if(hasTargets(line, num)){
				this.list.add(line.replace(logLevel, logLevel + " line : " + pad(String.valueOf(num)) + " "));
			}
		}
	}
	
	public String pad(String num){
		Integer n = num.length();
		for(int i=0;i<(10-n);i++){
			num = "0" + num;
		}
		return num;
	}
	
	public Boolean hasTargets(String line, int num){
		if(target==null) return true;
		String[] targets = getCollection(target);
		for(int i=0;i<targets.length;i++){
			if(line.indexOf(targets[i])>-1){
				return true;
			}
		}
		
		return false;
	}
	
	public String[] getCollection(String dataKind){
		for (int i = 0; i < collection.length; i++){
			if (collection[i][0].equals(dataKind)){
				String tmpStr[] = new String[(collection[i].length)-1];
				System.arraycopy(collection[i], 1, tmpStr, 0, collection[i].length - 1);
				return tmpStr;
			}
		}
		return new String[0];
	}

	public void printList(){
		for (int i = 0; i < this.list.size(); i++){
			printLog(this.list.get(i));
		}
	}
	
	public void printLog(String s) {
		System.out.println(s);
	}
}
