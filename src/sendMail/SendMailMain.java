package sendMail;

import java.util.ArrayList;
import java.util.List;

public class SendMailMain {

	public static void main(String[] args) {
		
		MailInfo info = new MailInfo();
		
		List<String> to = new ArrayList<String>();
		to.add("bibaboo@naver.com");
		
		info.setTo(to);
		info.setFrom("wonchu.net");
		info.setTitle("테스트 제목 001");
		info.setMessage("테스트 내용 001");
		
		info.setAuthId(info.getFrom());
		info.setAuthPwd("tzxtgmccgrkoibuc");
		
		try{
			SendMail.send(info);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
