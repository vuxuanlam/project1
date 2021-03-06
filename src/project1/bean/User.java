package project1.bean;

import java.sql.Timestamp;
import java.util.Date;

public class User {

	private int userId;
	private String name;
	private String password;
	private String email;
	private boolean activate;
	private boolean role;
	private Timestamp createAt;
	private Timestamp updateAt;

	public User() {
	}

	public User(String name, String password, String email) {
		this.name = name;
		this.password = password;
		this.email = email;
	}

	public int getUserId() {

		return userId;
	}

	public void setUserId(int userId) {

		this.userId = userId;
	}

	public String getName() {

		return name;
	}

	public void setName(String name) {

		this.name = name;
	}

	public String getPassword() {

		return password;
	}

	public void setPassword(String password) {

		this.password = password;
	}

	public String getEmail() {

		return email;
	}

	public void setEmail(String email) {

		this.email = email;

	}

	public boolean isRole() {

		return role;
	}

	public void setRole(boolean role) {

		this.role = role;
	}

	public boolean isActivated() {

		return activate;
	}

	public void setActivate(boolean activate) {

		this.activate = activate;
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

}
