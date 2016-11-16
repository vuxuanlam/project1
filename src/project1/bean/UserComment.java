package project1.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class UserComment implements Serializable {
	private static final long serialVersionUID = 1L;
	private Comment comment;
	private User user;
	public UserComment(){
	}

	public Comment getComment() {
		return comment;
	}

	public void setComment(Comment comment) {
		this.comment = comment;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}