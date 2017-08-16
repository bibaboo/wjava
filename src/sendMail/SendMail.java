package sendMail;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SendMail {

	public static void send(MailInfo info)throws Exception{

		Properties p = new Properties();
		p.put("mail.smtp.user", info.getFrom()); 
		p.put("mail.smtp.host", "smtp.gmail.com");
		p.put("mail.smtp.port", "465");
		p.put("mail.smtp.starttls.enable","true");
		p.put("mail.smtp.auth", "true");
		p.put("mail.smtp.debug", "true");
		p.put("mail.smtp.socketFactory.port", "465"); 
		p.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory"); 
		p.put("mail.smtp.socketFactory.fallback", "false");    

		try {
			Authenticator auth = new SMTPAuthenticator(info);
			Session session = Session.getInstance(p, auth);
			session.setDebug(true); // 메일을 전송할 때 상세한 상황을 콘솔에 출력한다.
	
			MimeMessage msg = new MimeMessage(session);
			msg.setSubject(info.getTitle(),"UTF-8");
			Address fromAddr = new InternetAddress(info.getFrom()); // 보내는 사람의 메일주소
			msg.setFrom(fromAddr);
	
			InternetAddress[] addressTo = new InternetAddress[info.getTo().size()];
	
			for (int i = 0; i < info.getTo().size(); i++) {
				addressTo[i] = new InternetAddress(info.getTo().get(i));
			}
	
			msg.setRecipients(Message.RecipientType.TO, addressTo);
			msg.setContent(info.getMessage(), "text/html;charset=utf-8");
			Transport.send(msg);
		} catch (Exception e) {
			throw e;
		}
	}

	private static class SMTPAuthenticator extends javax.mail.Authenticator {
		String id;
		String pwd;
		
		SMTPAuthenticator(MailInfo info){
			this.id = info.getAuthId();
			this.pwd = info.getAuthPwd();
		}

		public PasswordAuthentication getPasswordAuthentication() {
			return new PasswordAuthentication(id, pwd);
		}
	} 
}

/*
	gmail 2단계 인증하여 비밀번호 등록하는 법

	1. https://myaccount.google.com/

	2. https://accounts.google.com/b/0/SmsAuthConfig?hl=ko 
		> 설정 시작

	3. 재로그인

	4. https://accounts.google.com/b/0/SmsAuthSettings?Setup=1
		> 전화번호 입력 후 코드 전송

		> 인증코드 입력
	
	5. https://security.google.com/settings/security/apppasswords?pli=1
		> 기기선택과 앱(MAIL) 선택 후 생성

	6. 생성된 비밀번호를 위 소스의 pwd란에 입력한다.
*/



