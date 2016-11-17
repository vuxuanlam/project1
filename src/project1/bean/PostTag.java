package project1.bean;

import java.io.Serializable;

public class PostTag implements Serializable {
	private static final long serialVersionUID = 1L;
	private String post_Id;
	private String tag_Id;

	public PostTag() {
	}

	public String getPost_Id() {
		return post_Id;
	}

	public void setPost_Id(String post_Id) {
		this.post_Id = post_Id;
	}

	public String getTag_Id() {
		return tag_Id;
	}

	public void setTag_Id(String tag_Id) {
		this.tag_Id = tag_Id;
	}

}
