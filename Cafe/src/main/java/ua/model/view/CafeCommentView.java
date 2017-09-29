package ua.model.view;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CafeCommentView {

	private String comment;
	
	
	private String user;
	
	private String time;

	public CafeCommentView(String comment, String user, LocalDateTime time) {
		super();
		this.comment = comment;
		this.user = user;
		this.time = time.format(DateTimeFormatter.ofPattern("HH:mm dd/MM/yyyy"));
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
 	
	
}
