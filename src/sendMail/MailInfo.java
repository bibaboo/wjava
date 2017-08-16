package sendMail;

import java.util.List;

public class MailInfo {
	
	private List<String> to;
	
	private String from;
	private String title;
	private String message;
	
	private String authId;
	private String authPwd;
	
	public List<String> getTo() {
		return to;
	}
	public void setTo(List<String> to) {
		this.to = to;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getAuthId() {
		return authId;
	}
	public void setAuthId(String authId) {
		this.authId = authId;
	}
	public String getAuthPwd() {
		return authPwd;
	}
	public void setAuthPwd(String authPwd) {
		this.authPwd = authPwd;
	}

}
