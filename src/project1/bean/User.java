package project1.bean;

import java.util.Date;

public class User {

	private int userId;
	private String name;
	private String password;
	private String email;
	private int phoneNumber;
	private Date birthday;
	private boolean activate;
	private boolean role;
	private Date createAt;
	private Date updateAt;

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

	public int getPhoneNumber() {

		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {

		this.phoneNumber = phoneNumber;
	}


	public Date getBirthday() {

		return birthday;
	}

	public void setBirthday(Date birthday ) {

		this.birthday = birthday;
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

	public Date getCreateAt() {

		return createAt;
	}

	public void setCreateAt(Date createAt) {

		this.createAt = createAt;
	}

	public Date getUpdateAt() {

		return updateAt;
	}

	public void setUpdateAt(Date updateAt) {

		this.updateAt = updateAt;
	}
}
