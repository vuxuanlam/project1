package project1.bean;

import java.io.Serializable;
import java.util.Date;

public class Follow implements Serializable {

	private int followId;

	private int followingId;
	private int followerId;
	private Date createdAt;
	private Date updatedAt;

	public int getFollowId() {

		return followId;
	}

	public void setFollowId(int followId) {

		this.followId = followId;
	}

	public int getFollowingId() {
		return followingId;
	}

	public void setFollowingId(int followingId) {
		this.followingId = followingId;
	}

	public int getFollowerId() {
		return followerId;
	}

	public void setFollowerId(int followerId) {
		this.followerId = followerId;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
