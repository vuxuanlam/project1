package project1.bean;

import java.io.Serializable;
import java.sql.Timestamp;

public class Comment implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private int comment_Id;
	private int post_Id;
	private int user_Id;
	private String content;
	private Timestamp createAt;
	private Timestamp updateAt;

	public Comment() {
	}

	public int getPost_Id() {
		return post_Id;
	}

	public void setPost_Id(int post_Id) {
		this.post_Id = post_Id;
	}

	public int getUser_Id() {
		return user_Id;
	}

	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public Comment(int post_Id, int user_Id, String content) {
		this.post_Id = post_Id;
		this.user_Id = user_Id;
		this.content = content;
	}

	public int getComment_Id() {
		return comment_Id;
	}

	public void setComment_Id(int comment_Id) {
		this.comment_Id = comment_Id;
	}
}