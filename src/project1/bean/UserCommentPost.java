package project1.bean;


import java.io.Serializable;
import java.util.List;

public class UserCommentPost implements Serializable {
	private static final long serialVersionUID = 1L;
	private List<UserComment> listUserComment;
	private Post post;
	public UserCommentPost(){
	}

	public List<UserComment> getListUserComment() {
		return listUserComment;
	}

	public void setListUserComment(List<UserComment> listUserComment) {
		this.listUserComment = listUserComment;
	}

	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}

}