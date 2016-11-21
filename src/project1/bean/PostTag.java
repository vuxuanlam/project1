package project1.bean;

import java.io.Serializable;

public class PostTag implements Serializable {
	private static final long serialVersionUID = 1L;
	private int post_Id;
	private int tag_Id;

	public PostTag() {
	}

	public int getPost_Id() {
		return post_Id;
	}

	public void setPost_Id(int post_Id) {
		this.post_Id = post_Id;
	}

	public int getTag_Id() {
		return tag_Id;
	}

	public void setTag_Id(int tag_Id) {
		this.tag_Id = tag_Id;
	}



}
