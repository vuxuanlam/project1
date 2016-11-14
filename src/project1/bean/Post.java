package project1.bean;

import java.io.Serializable;
import java.util.Date;

public class Post implements Serializable {

	private int post_Id;
	private int user_Id;
	private String name;
	private String content;
	private Date creatAt;
	private Date updateAt;

	public Post() {
	}

	public Post(String postName, int user_Id, String content) {
	       this.name = postName;
	       this.user_Id = user_Id;
	       this.content = content;
	   }
	public int getPostId() {
		return post_Id;
	}

	public void setPostId(int post_Id) {
		this.post_Id = post_Id;
	}

	public int getUserId() {
		return user_Id;
	}

	public void setUserId(int user_Id) {
		this.user_Id = user_Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatAt() {
		return creatAt;
	}

	public void setCreatAt(Date creatAt) {
		this.creatAt = creatAt;
	}

	public Date getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}

}
