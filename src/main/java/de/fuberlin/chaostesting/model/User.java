package de.fuberlin.chaostesting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USER_INFORMATION")
public class User {
	
	@Id	@GeneratedValue
	@Column(name="user_id")
	private int id;
	@Column(name="user_name")
	private String userName;
	@Column(name="pass_hash")
	private String passHash;
	@Column(name="is_admin")
	private boolean isAdmin;
	
	public User() {
	}
	
	public User(String name, String hash, boolean admin) {
		this.userName = name;
		this.passHash = hash;
		this.isAdmin = admin;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassHash() {
		return passHash;
	}

	public void setPassHash(String passHash) {
		this.passHash = passHash;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}
